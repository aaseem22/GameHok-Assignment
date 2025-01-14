package com.thepuzzledev.gamehok_assignment.ui.screens.tournamentDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thepuzzledev.gamehok_assignment.R

@Composable
fun TournamentPrizeSection() {
    val prizes = listOf(
        PrizeInfo("1st", 1000),
        PrizeInfo("2nd", 500),
        PrizeInfo("3rd", 200),
        PrizeInfo("4th", 100),
        PrizeInfo("5th", 100)
    )

    TournamentPrizes(
        totalPrize = 2000,
        prizes = prizes,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun TournamentPrizes(
    totalPrize: Int,
    prizes: List<PrizeInfo>,
    modifier: Modifier = Modifier
) {
    val gradientColors = listOf(
        Color(0xFF4D5A53), // Start color
        Color(0xFF182920)  // End color
    )
    val darkerGreen = Color(0xFF001208)

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
           // .padding(16.dp)
    ) {
        // Total Prize Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = gradientColors,
                        startX = 0f,
                        endX = Float.POSITIVE_INFINITY
                    )
                )
                .padding( 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Total Tournament Prize",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "$totalPrize",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.width(6.dp))
                Image(
                    painter = painterResource(R.drawable.gs),
                    contentDescription = "gs",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        // Individual Prize Rows
        prizes.forEach { prize ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(darkerGreen)
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.trophy),
                        contentDescription = "Trophy",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "${prize.position} Prize",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${prize.amount}",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.width(6.dp))
                   Image(
                       painter = painterResource(R.drawable.gs),
                       contentDescription = "gs",
                       modifier = Modifier.size(20.dp)
                   )
                }
            }
            Spacer(modifier = Modifier.height(1.dp))
        }
    }
}

data class PrizeInfo(
    val position: String,
    val amount: Int
)

@Preview
@Composable
fun TournamentPrizesPreview() {
    TournamentPrizeSection()
}