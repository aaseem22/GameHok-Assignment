package com.thepuzzledev.gamehok_assignment.ui.screens.tournamentDetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
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
import com.thepuzzledev.gamehok_assignment.ui.screens.HorizontalTournamentCards

@Composable
fun TournamentDetailScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val sampleTournaments = listOf(
        TournamentData(
            title = "BGMI Solo Challenge",
            bannerImg = R.drawable.tournament_banner,
            organizer = "Esports Pro",
            startTime = "12 Jan, 5:00 PM",
            prizePool = "5000",
            playerCount = "50",
            maxPlayers = "100"
        ), TournamentData(
            title = "Valorant Clash",
            bannerImg = R.drawable.cs,
            organizer = "Game Masters",
            startTime = "15 Jan, 6:00 PM",
            prizePool = "10000",
            playerCount = "80",
            maxPlayers = "100"
        ), TournamentData(
            title = "COD Mobile Battle",
            bannerImg = R.drawable.cod,
            organizer = "Pro League",
            startTime = "20 Jan, 7:00 PM",
            prizePool = "8000",
            playerCount = "60",
            maxPlayers = "100"
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF001208))
            .verticalScroll(scrollState)

    ) {
        TopBanner(navController)
        TournamentHeader()
        TournamentTabs()
        TournamentPrizeSection()
        TournamentScheduleSection()
        MatchJoinInstructions()
        OrganizerDetailsCard()
        Column {
            Text(
                "More Tournaments for you",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            HorizontalTournamentCards(tournaments = sampleTournaments, onClick = { tournament ->
                println("Clicked on tournament: ${tournament.title}")
            })
        }
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.White.copy(0.5f))
        Spacer(modifier = Modifier.height(4.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF01A74B)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        ) {
            Text(
                "Join Tournament",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun TopBanner(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.tournament_banner),
            contentDescription = "Battlegrounds Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { navController.popBackStack() }, modifier = Modifier
                    .background(
                        Color.Gray.copy(alpha = 0.5f), RoundedCornerShape(50)
                    )
                    .size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }

            IconButton(
                onClick = { },
                modifier = Modifier
                    .background(Color(0xFF002E14), RoundedCornerShape(50))
                    .size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = Color.White
                )
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0xFF002E14))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Registration Closes in 2d 15h 10m",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0xFF002E14))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.group),
                        contentDescription = "Players",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "670/800", color = Color.White, fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
fun TournamentHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0A1F0A))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "PUBG tournament",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "By Red Bull",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF1B3B1B))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "BGMI", color = Color.White, fontSize = 14.sp
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF1B3B1B))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "Entry-10 🪙", color = Color.White, fontSize = 14.sp
                        )
                    }
                }
            }
            Image(
                painter = painterResource(id = R.drawable.red_bull),
                contentDescription = "Red Bull Logo",
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(50)),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview
@Composable
private fun TourPrev() {
    TournamentDetailScreen(rememberNavController())
}

