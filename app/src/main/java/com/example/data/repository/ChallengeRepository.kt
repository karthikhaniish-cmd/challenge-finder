package com.example.data.repository

import com.example.data.local.ChallengeDao
import com.example.data.local.CompletedChallengeEntity
import com.example.data.local.UserStatsEntity
import com.example.data.model.Challenge
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ChallengeRepository(private val dao: ChallengeDao) {

    val history: Flow<List<CompletedChallengeEntity>> = dao.getAllCompleted()

    val stats: Flow<UserStatsEntity> = dao.getUserStats().map { entity ->
        entity ?: UserStatsEntity(id = 1, totalPoints = 0, completedCount = 0, currentStreak = 0, bestStreak = 0)
    }

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    suspend fun completeChallenge(challenge: Challenge): Int {
        val currentStats = dao.getUserStatsOnce() ?: UserStatsEntity(id = 1)
        val todayStr = dateFormat.format(Date())

        val (newCurrentStreak, newBestStreak) = calculateStreak(
            lastDate = currentStats.lastCompletedDate,
            today = todayStr,
            currentStreak = currentStats.currentStreak,
            bestStreak = currentStats.bestStreak
        )

        val updatedStats = currentStats.copy(
            totalPoints = currentStats.totalPoints + challenge.points,
            completedCount = currentStats.completedCount + 1,
            currentStreak = newCurrentStreak,
            bestStreak = newBestStreak,
            lastCompletedDate = todayStr
        )
        dao.saveUserStats(updatedStats)

        val entity = CompletedChallengeEntity(
            challengeId = challenge.id,
            title = challenge.title,
            category = challenge.category,
            difficulty = challenge.difficulty,
            points = challenge.points,
            completedAt = System.currentTimeMillis()
        )
        dao.insertCompleted(entity)

        return challenge.points
    }

    private fun calculateStreak(
        lastDate: String,
        today: String,
        currentStreak: Int,
        bestStreak: Int
    ): Pair<Int, Int> {
        if (lastDate.isEmpty()) {
            return Pair(1, maxOf(1, bestStreak))
        }

        if (lastDate == today) {
            // Already completed today, streak remains same
            val current = if (currentStreak == 0) 1 else currentStreak
            return Pair(current, maxOf(current, bestStreak))
        }

        val cal = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_YEAR, -1)
        val yesterdayStr = dateFormat.format(cal.time)

        return if (lastDate == yesterdayStr) {
            val nextStreak = currentStreak + 1
            Pair(nextStreak, maxOf(nextStreak, bestStreak))
        } else {
            // Streak broken
            Pair(1, maxOf(1, bestStreak))
        }
    }

    suspend fun clearHistory() {
        dao.clearHistory()
    }

    suspend fun resetAll() {
        dao.clearHistory()
        dao.resetStats()
    }

    suspend fun toggleDarkMode(currentDark: Boolean) {
        val currentStats = dao.getUserStatsOnce() ?: UserStatsEntity(id = 1)
        dao.saveUserStats(currentStats.copy(isDarkMode = !currentDark))
    }
}
