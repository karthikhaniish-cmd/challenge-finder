package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "completed_challenges")
data class CompletedChallengeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val challengeId: Int,
    val title: String,
    val category: String,
    val difficulty: String,
    val points: Int,
    val completedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "user_stats")
data class UserStatsEntity(
    @PrimaryKey
    val id: Int = 1,
    val totalPoints: Int = 0,
    val completedCount: Int = 0,
    val currentStreak: Int = 0,
    val bestStreak: Int = 0,
    val lastCompletedDate: String = "", // "yyyy-MM-dd"
    val isDarkMode: Boolean = true
)
