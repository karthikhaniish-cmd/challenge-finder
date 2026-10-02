package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Casino
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FormatListBulleted
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Insights
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.ChallengeViewModel
import com.example.ui.components.ChallengeTimerDialog
import com.example.ui.components.ConfettiCelebrationDialog
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.ChallengesListScreen
import com.example.ui.screens.DailyChallengeScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.HistoryScreen
import com.example.ui.screens.StatsScreen
import com.example.ui.theme.ChallengeGeneratorTheme

enum class AppNavDestination(
    val title: String,
    val icon: ImageVector,
    val testTag: String
) {
    HOME("Generator", Icons.Default.Casino, "nav_generator"),
    CHALLENGES("Browse", Icons.Default.FormatListBulleted, "nav_challenges"),
    DAILY("Daily", Icons.Default.DateRange, "nav_daily"),
    STATS("Stats", Icons.Default.Insights, "nav_stats"),
    HISTORY("History", Icons.Default.History, "nav_history"),
    ABOUT("About", Icons.Default.Info, "nav_about")
}

class MainActivity : ComponentActivity() {

    private val viewModel: ChallengeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val stats by viewModel.stats.collectAsStateWithLifecycle()
            val history by viewModel.history.collectAsStateWithLifecycle()

            ChallengeGeneratorTheme(darkTheme = stats.isDarkMode) {
                MainAppContent(
                    viewModel = viewModel,
                    stats = stats,
                    history = history
                )
            }
        }
    }
}

@Composable
fun MainAppContent(
    viewModel: ChallengeViewModel,
    stats: com.example.data.local.UserStatsEntity,
    history: List<com.example.data.local.CompletedChallengeEntity>
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var currentTab by remember { mutableStateOf(AppNavDestination.HOME) }
    val snackbarHostState = remember { SnackbarHostState() }

    // Handle Back Press: if on non-home tab, go back to HOME
    BackHandler(enabled = currentTab != AppNavDestination.HOME) {
        currentTab = AppNavDestination.HOME
    }

    // Show toast messages via Snackbar
    LaunchedEffect(uiState.toastMessage) {
        uiState.toastMessage?.let { msg ->
            snackbarHostState.showSnackbar(msg)
            viewModel.clearToast()
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val isWideScreen = maxWidth >= 600.dp

        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            bottomBar = {
                if (!isWideScreen) {
                    NavigationBar(
                        modifier = Modifier.testTag("bottom_nav_bar"),
                        containerColor = MaterialTheme.colorScheme.surface
                    ) {
                        AppNavDestination.entries.forEach { dest ->
                            val isSelected = currentTab == dest
                            NavigationBarItem(
                                selected = isSelected,
                                onClick = { currentTab = dest },
                                icon = {
                                    Icon(
                                        imageVector = dest.icon,
                                        contentDescription = dest.title
                                    )
                                },
                                label = { Text(dest.title) },
                                modifier = Modifier.testTag(dest.testTag)
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Side Navigation Rail for tablets / landscape
                if (isWideScreen) {
                    NavigationRail(
                        modifier = Modifier
                            .fillMaxHeight()
                            .testTag("side_navigation_rail"),
                        containerColor = MaterialTheme.colorScheme.surface
                    ) {
                        AppNavDestination.entries.forEach { dest ->
                            NavigationRailItem(
                                selected = currentTab == dest,
                                onClick = { currentTab = dest },
                                icon = {
                                    Icon(
                                        imageVector = dest.icon,
                                        contentDescription = dest.title
                                    )
                                },
                                label = { Text(dest.title) },
                                modifier = Modifier.testTag(dest.testTag)
                            )
                        }
                    }
                }

                // Main Screen Body
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    when (currentTab) {
                        AppNavDestination.HOME -> {
                            HomeScreen(
                                uiState = uiState,
                                stats = stats,
                                onCategorySelected = { viewModel.selectCategory(it) },
                                onDifficultySelected = { viewModel.selectDifficulty(it) },
                                onGenerateChallenge = { viewModel.generateChallenge() },
                                onStartChallenge = { viewModel.startChallenge(it) },
                                onCompleteChallenge = { viewModel.completeChallenge(it) }
                            )
                        }

                        AppNavDestination.CHALLENGES -> {
                            ChallengesListScreen(
                                searchQuery = uiState.searchQuery,
                                categoryFilter = uiState.listCategoryFilter,
                                difficultyFilter = uiState.listDifficultyFilter,
                                onSearchChanged = { viewModel.updateSearchQuery(it) },
                                onCategoryFilterChanged = { viewModel.updateListCategoryFilter(it) },
                                onDifficultyFilterChanged = { viewModel.updateListDifficultyFilter(it) },
                                onResetFilters = { viewModel.resetListFilters() },
                                onSelectChallenge = { challenge ->
                                    viewModel.selectChallengeFromList(challenge)
                                    currentTab = AppNavDestination.HOME
                                }
                            )
                        }

                        AppNavDestination.DAILY -> {
                            DailyChallengeScreen(
                                dailyChallenge = uiState.dailyChallenge,
                                stats = stats,
                                onStartChallenge = { viewModel.startChallenge(it) },
                                onCompleteChallenge = { viewModel.completeChallenge(it) }
                            )
                        }

                        AppNavDestination.STATS -> {
                            StatsScreen(
                                stats = stats,
                                history = history
                            )
                        }

                        AppNavDestination.HISTORY -> {
                            HistoryScreen(
                                history = history,
                                onClearHistory = { viewModel.clearHistory() }
                            )
                        }

                        AppNavDestination.ABOUT -> {
                            AboutScreen(
                                isDarkMode = stats.isDarkMode,
                                onToggleTheme = { viewModel.toggleDarkMode(stats.isDarkMode) },
                                onResetAllData = { viewModel.resetAllData() }
                            )
                        }
                    }
                }
            }
        }

        // Active Countdown Timer Modal
        if (uiState.isTimerActive && uiState.timerChallenge != null) {
            ChallengeTimerDialog(
                challenge = uiState.timerChallenge!!,
                totalSeconds = uiState.timerTotalSeconds,
                remainingSeconds = uiState.timerRemainingSeconds,
                isRunning = uiState.isTimerRunning,
                onPause = { viewModel.pauseTimer() },
                onResume = { viewModel.resumeTimer() },
                onRestart = { viewModel.restartTimer() },
                onFinish = {
                    uiState.timerChallenge?.let { viewModel.completeChallenge(it) }
                },
                onClose = { viewModel.closeTimer() }
            )
        }

        // Confetti Celebration Dialog
        if (uiState.showConfetti) {
            ConfettiCelebrationDialog(
                pointsAwarded = uiState.pointsAwarded,
                onDismiss = { viewModel.dismissConfetti() }
            )
        }
    }
}
