package com.thepuzzledev.gamehok_assignment.ui.screens.tournamentDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TournamentRound(
    val title: String,
    val roundNumber: Int,
    val description: String,
    val eliminationType: String,
    val dateTime: String
)

@Composable
fun TournamentScheduleSection() {
    val rounds = listOf(
        TournamentRound(
            "Qualifiers", 1, "Top 4 to next round", "Single Elimination", "3rd Aug, 10:00 pm"
        ), TournamentRound(
            "Round of 32", 2, "Top 16 advance", "Single Elimination", "4th Aug, 2:00 pm"
        ), TournamentRound(
            "Round of 16", 3, "Top 8 advance", "Double Elimination", "4th Aug, 6:00 pm"
        )
    )

    TournamentSchedule(
        rounds = rounds, modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TournamentSchedule(
    rounds: List<TournamentRound>, modifier: Modifier = Modifier
) {
    val darkBackground = Color(0xFF0A1810)
    val grayText = Color(0xFF8B8B8B)
    val dividerColor = Color(0xFF2A362F)
    val eliminationBgColor = Color(0xFF1F1B37)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(darkBackground)
            .padding(16.dp)
    ) {
        Text(
            text = "Rounds and Schedule",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        rounds.forEachIndexed { index, round ->
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = round.title,
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = " (Round ${round.roundNumber})",
                            color = grayText,
                            fontSize = 16.sp
                        )
                    }

                    Text(
                        text = round.eliminationType,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .background(
                                eliminationBgColor, RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = round.description, color = Color.White, fontSize = 16.sp
                    )
                    Text(
                        text = round.dateTime, color = Color.White, fontSize = 16.sp
                    )
                }

                if (index < rounds.size - 1) {
                    HorizontalDivider(
                        color = dividerColor,
                        thickness = 1.dp,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TournamentSchedulePreview() {
    TournamentScheduleSection()
}