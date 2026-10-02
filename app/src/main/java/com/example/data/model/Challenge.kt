package com.example.data.model

data class Challenge(
    val id: Int,
    val title: String,
    val description: String,
    val category: String, // "funny", "brain", "fitness", "creative", "social", "gaming", "study", "dare", "quick"
    val difficulty: String, // "easy", "medium", "hard"
    val duration: Int, // seconds, 0 for untimed
    val points: Int
)

enum class ChallengeCategory(
    val key: String,
    val displayName: String,
    val emoji: String,
    val colorHex: Long
) {
    FUNNY("funny", "Funny", "😂", 0xFFFF8533),
    BRAIN("brain", "Brain", "🧠", 0xFF00D4FF),
    FITNESS("fitness", "Fitness", "💪", 0xFF2ED573),
    CREATIVE("creative", "Creative", "🎨", 0xFFFF4757),
    SOCIAL("social", "Social", "🎤", 0xFF7C5CFC),
    GAMING("gaming", "Gaming", "🎮", 0xFF9B51E0),
    STUDY("study", "Study", "📚", 0xFF2F80ED),
    DARE("dare", "Dare", "😈", 0xFFFF5252),
    QUICK("quick", "Quick", "⚡", 0xFFFFD166),
    RANDOM("random", "Random", "🎲", 0xFF20BF6B);

    companion object {
        fun fromKey(key: String): ChallengeCategory {
            return entries.firstOrNull { it.key.equals(key, ignoreCase = true) } ?: RANDOM
        }
    }
}

enum class ChallengeDifficulty(val key: String, val displayName: String, val pointRange: String) {
    EASY("easy", "Easy", "10-30 pts"),
    MEDIUM("medium", "Medium", "30-70 pts"),
    HARD("hard", "Hard", "70-100 pts");

    companion object {
        fun fromKey(key: String): ChallengeDifficulty {
            return entries.firstOrNull { it.key.equals(key, ignoreCase = true) } ?: MEDIUM
        }
    }
}
