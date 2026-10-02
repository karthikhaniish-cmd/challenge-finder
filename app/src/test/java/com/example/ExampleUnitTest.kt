package com.example

import com.example.data.datasource.ChallengeDataSource
import com.example.data.model.ChallengeCategory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun database_hasOver100UniqueChallenges() {
        val challenges = ChallengeDataSource.challenges
        assertTrue("Challenge database should have at least 100 challenges", challenges.size >= 100)
        val uniqueIds = challenges.map { it.id }.toSet()
        assertEquals("All challenge IDs should be distinct", challenges.size, uniqueIds.size)
    }

    @Test
    fun database_coversAllStandardCategories() {
        val categories = ChallengeDataSource.challenges.map { it.category.lowercase() }.toSet()
        val expectedCategories = listOf(
            "funny", "brain", "fitness", "creative", "social", "gaming", "study", "dare", "quick"
        )
        for (cat in expectedCategories) {
            assertTrue("Expected category $cat to be present", categories.contains(cat))
        }
    }

    @Test
    fun challenge_pointsConformToDifficultyGuidelines() {
        ChallengeDataSource.challenges.forEach { challenge ->
            when (challenge.difficulty.lowercase()) {
                "easy" -> assertTrue(
                    "Easy challenge ${challenge.id} should have points between 10 and 30",
                    challenge.points in 10..30
                )
                "medium" -> assertTrue(
                    "Medium challenge ${challenge.id} should have points between 30 and 70",
                    challenge.points in 30..70
                )
                "hard" -> assertTrue(
                    "Hard challenge ${challenge.id} should have points between 70 and 100",
                    challenge.points in 70..100
                )
            }
        }
    }

    @Test
    fun dailyChallenge_isDeterministic() {
        val challenge1 = ChallengeDataSource.getDailyChallenge(20261002L)
        val challenge2 = ChallengeDataSource.getDailyChallenge(20261002L)
        assertEquals("Same day seed must return the same challenge", challenge1.id, challenge2.id)
    }
}
