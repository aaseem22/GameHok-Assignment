package com.thepuzzledev.gamehok_assignment.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thepuzzledev.gamehok_assignment.R
import com.thepuzzledev.gamehok_assignment.model.TournamentData

@Composable
fun TournamentSection(navController: NavController) {
    val sampleTournaments = listOf(
        TournamentData(
            title = "BGMI Solo Challenge",
            bannerImg = R.drawable.tournament_banner,
            organizer = "Esports Pro",
            startTime = "12 Jan, 5:00 PM",
            prizePool = "5000",
            playerCount = "50",
            maxPlayers = "100"
        ),
        TournamentData(
            title = "Valorant Clash",
            bannerImg = R.drawable.cs,
            organizer = "Game Masters",
            startTime = "15 Jan, 6:00 PM",
            prizePool = "10000",
            playerCount = "80",
            maxPlayers = "100"
        ),
        TournamentData(
            title = "COD Mobile Battle",
            bannerImg = R.drawable.cod,
            organizer = "Pro League",
            startTime = "20 Jan, 7:00 PM",
            prizePool = "8000",
            playerCount = "60",
            maxPlayers = "100"
        )
    )

    Column (modifier = Modifier.fillMaxWidth()){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                "Compete in Battles",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )

            Text(
                "View all",
                fontSize = 20.sp,
                color = Color(0xFF4CAF50),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        HorizontalTournamentCards(
            tournaments = sampleTournaments,
            onClick = { tournament ->
                // Handle click event
               // println("Clicked on tournament: ${tournament.title}")
                navController.navigate("TournamentDetail")
            }
        )
    }
}
@Composable
fun HorizontalTournamentCards(tournaments: List<TournamentData>, onClick: (TournamentData) -> Unit) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(tournaments.size) { index ->
            val tournament = tournaments[index]
            TournamentCard(
                title = tournament.title,
                bannerImg = tournament.bannerImg,
                organizer = tournament.organizer,
                startTime = tournament.startTime,
                prizePool = tournament.prizePool,
                playerCount = tournament.playerCount,
                maxPlayers = tournament.maxPlayers,
                onClick = { onClick(tournament) }
            )
        }
    }
}
@Composable
fun TournamentCard(
    title: String,
    bannerImg: Int,
    organizer: String,
    startTime: String,
    prizePool: String,
    playerCount: String,
    maxPlayers: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(300.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(bannerImg),
                    contentDescription = "Tournament Banner",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Surface(
                        color = Color.Black.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Registration Open",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            color = Color.White
                        )
                    }

                    Surface(
                        color = Color.Black.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.group),
                                contentDescription = "Players",
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "$playerCount/$maxPlayers",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF56E293),
                                Color(0xFF062E17)
                            )
                        )
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = "By $organizer",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.8f)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("BGMI", "Solo", "Entry-10 🪙").forEach { text ->
                        Surface(
                            color = Color.Black.copy(alpha = 0.7f),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = text,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                color = Color.White,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.clock),
                            contentDescription = "clock",
                            modifier = Modifier.size(20.dp),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = startTime,
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.trophy),
                                contentDescription = "trophy",
                                modifier = Modifier.size(20.dp),
                                contentScale = ContentScale.Fit
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Prize Pool- $prizePool 🪙",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "More details",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TournamentCardPrev() {
    TournamentSection(rememberNavController())
}