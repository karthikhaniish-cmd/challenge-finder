package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import kotlin.random.Random

private data class ConfettiParticle(
    var x: Float,
    var y: Float,
    var vx: Float,
    var vy: Float,
    var rotation: Float,
    var vRot: Float,
    val size: Float,
    val color: Color,
    val isCircle: Boolean
)

private val confettiColors = listOf(
    Color(0xFFFFD166), // Gold
    Color(0xFF00D4FF), // Cyan
    Color(0xFF7C5CFC), // Violet
    Color(0xFFFF5C8A), // Pink
    Color(0xFF2ED573), // Green
    Color(0xFFFF8533)  // Orange
)

@Composable
fun ConfettiCelebrationDialog(
    pointsAwarded: Int,
    onDismiss: () -> Unit
) {
    val particles = remember {
        mutableStateListOf<ConfettiParticle>().apply {
            repeat(70) {
                add(
                    ConfettiParticle(
                        x = Random.nextFloat(),
                        y = -Random.nextFloat() * 0.3f,
                        vx = (Random.nextFloat() - 0.5f) * 0.008f,
                        vy = 0.005f + Random.nextFloat() * 0.012f,
                        rotation = Random.nextFloat() * 360f,
                        vRot = (Random.nextFloat() - 0.5f) * 12f,
                        size = 14f + Random.nextFloat() * 16f,
                        color = confettiColors.random(),
                        isCircle = Random.nextBoolean()
                    )
                )
            }
        }
    }

    LaunchedEffect(Unit) {
        var lastTime = 0L
        while (true) {
            withFrameNanos { time ->
                if (lastTime != 0L) {
                    particles.forEach { p ->
                        p.x += p.vx
                        p.y += p.vy
                        p.rotation += p.vRot
                        p.vy += 0.0003f // Gravity
                        if (p.y > 1.1f) {
                            p.y = -0.1f
                            p.x = Random.nextFloat()
                            p.vy = 0.005f + Random.nextFloat() * 0.012f
                        }
                    }
                }
                lastTime = time
            }
        }
    }

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .testTag("confetti_celebration_overlay"),
            contentAlignment = Alignment.Center
        ) {
            // Confetti canvas
            Canvas(modifier = Modifier.fillMaxSize()) {
                val w = size.width
                val h = size.height

                particles.forEach { p ->
                    val px = p.x * w
                    val py = p.y * h
                    rotate(p.rotation, pivot = Offset(px, py)) {
                        if (p.isCircle) {
                            drawCircle(
                                color = p.color,
                                radius = p.size / 2,
                                center = Offset(px, py)
                            )
                        } else {
                            drawRect(
                                color = p.color,
                                topLeft = Offset(px - p.size / 2, py - p.size / 2),
                                size = Size(p.size, p.size * 0.6f)
                            )
                        }
                    }
                }
            }

            // Reward Card
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
                modifier = Modifier
                    .padding(24.dp)
                    .testTag("celebration_card")
            ) {
                Column(
                    modifier = Modifier.padding(28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "🎉",
                        fontSize = 56.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Challenge Complete!",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Text(
                            text = "+$pointsAwarded Points ⭐",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Awesome work! Keep the momentum going to build your daily streak.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = onDismiss,
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        modifier = Modifier.testTag("celebration_continue_button")
                    ) {
                        Text(
                            text = "Awesome! 🚀",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                        )
                    }
                }
            }
        }
    }
}
