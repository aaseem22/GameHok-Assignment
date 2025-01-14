package com.thepuzzledev.gamehok_assignment.ui.screens.tournamentDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MatchJoinInstructions(
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "How to Join a Match",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        val instructions = listOf(
            "Have your game open already and on the latest version",
            "Once the match is configured you will receive an invite in-game to join the lobby.",
            "Join the match and wait for the game to start.",
            "When eliminated return to the match room page to be ready to join the next map in the round."
        )

        instructions.forEach { instruction ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "•", color = Color.White, fontSize = 16.sp
                )
                Text(
                    text = instruction, color = Color.White, fontSize = 16.sp
                )
            }
        }
    }
}

