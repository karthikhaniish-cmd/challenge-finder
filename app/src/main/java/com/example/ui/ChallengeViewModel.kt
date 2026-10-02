package com.example.ui

import android.app.Application
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.datasource.ChallengeDataSource
import com.example.data.local.AppDatabase
import com.example.data.local.CompletedChallengeEntity
import com.example.data.local.UserStatsEntity
import com.example.data.model.Challenge
import com.example.data.model.ChallengeCategory
import com.example.data.model.ChallengeDifficulty
import com.example.data.repository.ChallengeRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

data class ChallengeUiState(
    val currentChallenge: Challenge? = null,
    val isGenerating: Boolean = false,
    val selectedCategory: ChallengeCategory = ChallengeCategory.RANDOM,
    val selectedDifficulty: String = "all", // "all", "easy", "medium", "hard"
    val recentChallengeIds: List<Int> = emptyList(),
    // Timer
    val isTimerActive: Boolean = false,
    val isTimerRunning: Boolean = false,
    val timerTotalSeconds: Int = 0,
    val timerRemainingSeconds: Int = 0,
    val timerChallenge: Challenge? = null,
    // Celebration
    val showConfetti: Boolean = false,
    val pointsAwarded: Int = 0,
    val toastMessage: String? = null,
    // List search & filters
    val searchQuery: String = "",
    val listCategoryFilter: String = "all",
    val listDifficultyFilter: String = "all",
    // Daily Challenge
    val dailyChallenge: Challenge = ChallengeDataSource.challenges[0],
    val isDailyCompletedToday: Boolean = false
)

class ChallengeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ChallengeRepository
    private val vibrator: Vibrator?

    init {
        val db = AppDatabase.getDatabase(application)
        repository = ChallengeRepository(db.challengeDao())
        vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = application.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
            vibratorManager?.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            application.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        }
    }

    val history: StateFlow<List<CompletedChallengeEntity>> = repository.history
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val stats: StateFlow<UserStatsEntity> = repository.stats
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UserStatsEntity(id = 1))

    private val _uiState = MutableStateFlow(ChallengeUiState())
    val uiState: StateFlow<ChallengeUiState> = _uiState.asStateFlow()

    private var timerJob: Job? = null

    init {
        initDailyChallenge()
        // Generate an initial challenge
        generateChallenge(isInitial = true)
    }

    private fun initDailyChallenge() {
        val todayStr = SimpleDateFormat("yyyyMMdd", Locale.US).format(Date())
        val seed = todayStr.toLongOrNull() ?: 12345L
        val daily = ChallengeDataSource.getDailyChallenge(seed)
        _uiState.value = _uiState.value.copy(dailyChallenge = daily)
    }

    fun selectCategory(category: ChallengeCategory) {
        _uiState.value = _uiState.value.copy(selectedCategory = category)
    }

    fun selectDifficulty(difficulty: String) {
        _uiState.value = _uiState.value.copy(selectedDifficulty = difficulty)
    }

    fun generateChallenge(isInitial: Boolean = false) {
        viewModelScope.launch {
            if (!isInitial) {
                triggerHaptic(50)
                _uiState.value = _uiState.value.copy(isGenerating = true)
                delay(380) // Smooth shuffle animation duration
            }

            val category = _uiState.value.selectedCategory
            val difficulty = _uiState.value.selectedDifficulty
            val recentIds = _uiState.value.recentChallengeIds

            val all = ChallengeDataSource.challenges

            // Filter pool
            var pool = all.filter { challenge ->
                val categoryMatches = if (category == ChallengeCategory.RANDOM) {
                    true
                } else {
                    challenge.category.equals(category.key, ignoreCase = true)
                }

                val difficultyMatches = if (difficulty == "all") {
                    true
                } else {
                    challenge.difficulty.equals(difficulty, ignoreCase = true)
                }

                categoryMatches && difficultyMatches
            }

            if (pool.isEmpty()) {
                // Fallback to all in category or all
                pool = if (category == ChallengeCategory.RANDOM) all else all.filter {
                    it.category.equals(category.key, ignoreCase = true)
                }
            }

            // Exclude recent if possible
            val nonRecent = pool.filterNot { recentIds.contains(it.id) }
            val chosenList = if (nonRecent.isNotEmpty()) nonRecent else pool

            val selected = chosenList.randomOrNull() ?: all.first()

            val updatedRecent = (recentIds + selected.id).takeLast(6)

            _uiState.value = _uiState.value.copy(
                currentChallenge = selected,
                isGenerating = false,
                recentChallengeIds = updatedRecent,
                toastMessage = if (!isInitial) "🎯 New challenge generated!" else null
            )
        }
    }

    fun startChallenge(challenge: Challenge) {
        triggerHaptic(40)
        if (challenge.duration > 0) {
            startTimerForChallenge(challenge)
        } else {
            // Untimed challenge, user starts doing it
            _uiState.value = _uiState.value.copy(
                toastMessage = "▶ Challenge started: ${challenge.title}"
            )
        }
    }

    private fun startTimerForChallenge(challenge: Challenge) {
        timerJob?.cancel()
        _uiState.value = _uiState.value.copy(
            isTimerActive = true,
            isTimerRunning = true,
            timerTotalSeconds = challenge.duration,
            timerRemainingSeconds = challenge.duration,
            timerChallenge = challenge
        )

        timerJob = viewModelScope.launch {
            while (_uiState.value.timerRemainingSeconds > 0 && _uiState.value.isTimerRunning) {
                delay(1000)
                if (_uiState.value.isTimerRunning) {
                    val remaining = _uiState.value.timerRemainingSeconds - 1
                    _uiState.value = _uiState.value.copy(timerRemainingSeconds = remaining)

                    if (remaining == 0) {
                        triggerCelebrationHaptic()
                        completeChallenge(challenge)
                        closeTimer()
                        break
                    }
                }
            }
        }
    }

    fun pauseTimer() {
        _uiState.value = _uiState.value.copy(isTimerRunning = false)
    }

    fun resumeTimer() {
        val remaining = _uiState.value.timerRemainingSeconds
        if (remaining > 0) {
            _uiState.value = _uiState.value.copy(isTimerRunning = true)
            timerJob?.cancel()
            timerJob = viewModelScope.launch {
                while (_uiState.value.timerRemainingSeconds > 0 && _uiState.value.isTimerRunning) {
                    delay(1000)
                    if (_uiState.value.isTimerRunning) {
                        val newRemaining = _uiState.value.timerRemainingSeconds - 1
                        _uiState.value = _uiState.value.copy(timerRemainingSeconds = newRemaining)
                        if (newRemaining == 0) {
                            triggerCelebrationHaptic()
                            _uiState.value.timerChallenge?.let { completeChallenge(it) }
                            closeTimer()
                            break
                        }
                    }
                }
            }
        }
    }

    fun restartTimer() {
        val total = _uiState.value.timerTotalSeconds
        _uiState.value = _uiState.value.copy(
            timerRemainingSeconds = total,
            isTimerRunning = true
        )
        _uiState.value.timerChallenge?.let { startTimerForChallenge(it) }
    }

    fun closeTimer() {
        timerJob?.cancel()
        timerJob = null
        _uiState.value = _uiState.value.copy(
            isTimerActive = false,
            isTimerRunning = false
        )
    }

    fun completeChallenge(challenge: Challenge) {
        viewModelScope.launch {
            triggerCelebrationHaptic()
            val points = repository.completeChallenge(challenge)
            _uiState.value = _uiState.value.copy(
                showConfetti = true,
                pointsAwarded = points,
                toastMessage = "✓ Challenge completed! +$points points"
            )
            // Auto close timer if was running for this challenge
            if (_uiState.value.isTimerActive && _uiState.value.timerChallenge?.id == challenge.id) {
                closeTimer()
            }
        }
    }

    fun dismissConfetti() {
        _uiState.value = _uiState.value.copy(showConfetti = false)
    }

    fun clearToast() {
        _uiState.value = _uiState.value.copy(toastMessage = null)
    }

    fun clearHistory() {
        viewModelScope.launch {
            repository.clearHistory()
            _uiState.value = _uiState.value.copy(toastMessage = "🗑 History cleared")
        }
    }

    fun resetAllData() {
        viewModelScope.launch {
            repository.resetAll()
            _uiState.value = _uiState.value.copy(
                recentChallengeIds = emptyList(),
                toastMessage = "🔄 All challenge stats reset"
            )
        }
    }

    fun toggleDarkMode(currentDark: Boolean) {
        viewModelScope.launch {
            repository.toggleDarkMode(currentDark)
            val nextTheme = if (currentDark) "☀️ Light mode enabled" else "🌙 Dark mode enabled"
            _uiState.value = _uiState.value.copy(toastMessage = nextTheme)
        }
    }

    // List filtering & search
    fun updateSearchQuery(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
    }

    fun updateListCategoryFilter(category: String) {
        _uiState.value = _uiState.value.copy(listCategoryFilter = category)
    }

    fun updateListDifficultyFilter(difficulty: String) {
        _uiState.value = _uiState.value.copy(listDifficultyFilter = difficulty)
    }

    fun resetListFilters() {
        _uiState.value = _uiState.value.copy(
            searchQuery = "",
            listCategoryFilter = "all",
            listDifficultyFilter = "all"
        )
    }

    fun selectChallengeFromList(challenge: Challenge) {
        _uiState.value = _uiState.value.copy(
            currentChallenge = challenge,
            toastMessage = "🎯 Selected: ${challenge.title}"
        )
    }

    private fun triggerHaptic(durationMs: Long) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator?.vibrate(VibrationEffect.createOneShot(durationMs, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                @Suppress("DEPRECATION")
                vibrator?.vibrate(durationMs)
            }
        } catch (_: Exception) {}
    }

    private fun triggerCelebrationHaptic() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val timings = longArrayOf(0, 100, 60, 120, 80, 200)
                val amplitudes = intArrayOf(0, 180, 0, 220, 0, 255)
                vibrator?.vibrate(VibrationEffect.createWaveform(timings, amplitudes, -1))
            } else {
                @Suppress("DEPRECATION")
                vibrator?.vibrate(300)
            }
        } catch (_: Exception) {}
    }
}
