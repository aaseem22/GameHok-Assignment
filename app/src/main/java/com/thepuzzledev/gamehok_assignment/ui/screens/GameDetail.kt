package com.thepuzzledev.gamehok_assignment.ui.screens

import androidx.compose.foundation.*
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(
    navController: NavController,
) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Overview", "Streams", "Tutorials", "Group")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pubg", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back",tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF0A1F0A)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = Color(0xFF001208))
        ) {
            // Hero Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                // Game Banner
                Image(
                    painter = painterResource(id = R.drawable.pubg),
                    contentDescription = "Game Banner",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Overlay with game info
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF002E14).copy(0.8f))
                            .padding(horizontal = 16.dp,)
                    ) {
                        Text(
                            text = "A tactical game",
                            style = MaterialTheme.typography.headlineLarge,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                            )
                    }
                }
            }

            // Quick Stats
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem("250K", "Active Players")
                StatItem("15K", "Live Viewers")
                StatItem("1.2K", "Tutorials")
            }

            // Tab Navigation
            TabRow(selectedTabIndex = selectedTab,
                containerColor = Color(0xFF001208),
                contentColor = Color.White
                ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(title) }
                    )
                }
            }

            // Tab Content
            when (selectedTab) {
                0 -> OverviewTab()
                1 -> StreamsTab()
                2 -> TutorialsTab()
                3 -> CommunityTab()
            }
        }
    }
}

@Composable
private fun StatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = label,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun OverviewTab() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "About the Game",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color.White
        )
        Text(
            text = "Pubg is a free-to-play multiplayer tactical shooter where precise gunplay meets unique agent abilities. Create tactical opportunities, outplay your opponents, and prove your aim.",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Featured Content",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color.White
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(3) { index ->
                FeaturedCard()
            }
        }
    }
}

@Composable
private fun FeaturedCard() {
    Card(
        modifier = Modifier
            .width(280.dp)
            .height(160.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.cs),
                contentDescription = "Featured Content",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Featured Tutorial",
                modifier = Modifier
                    .background(color = Color(0xFF002E14).copy(0.8f))
                    .align(Alignment.BottomCenter)
                    .padding(8.dp),
                color = Color.White
            )
        }
    }
}

@Composable
private fun StreamsTab() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Live Streams",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color.White
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(5) {
                StreamCard()
            }
        }
    }
}

@Composable
private fun StreamCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF182920),
                            Color(0xFF4D5A53)
                        ), startY = 0f, endY = Float.POSITIVE_INFINITY
                    )
                )
        ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.cod),
                contentDescription = "Stream Thumbnail",
                modifier = Modifier
                    .size(80.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Pro Gaming Tips & Tricks",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "StreamerName • 15K ",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Button(
                onClick = { },
                modifier = Modifier.align(Alignment.CenterVertically),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF001208))
            ) {
                Text("Watch",color = Color.White)
            }
        }
    }
    }
}

@Composable
private fun TutorialsTab() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Learn & Improve",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(5) {
                TutorialCard()
            }
        }
    }
}

@Composable
private fun TutorialCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF182920),
                            Color(0xFF4D5A53)
                        )
                    )
                )
        ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = "Advanced Strategies",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Learn pro-level tactics and strategies",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Intermediate • 45 min",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
                TextButton(onClick = { }) {
                    Text("Start Learning",color = Color.White)
                }
            }
        }
        }
    }
}

@Composable
private fun CommunityTab() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Community",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(color = (Color(0xFF002E14).copy(0.8f)))
                    .padding(16.dp)
            ) {
                Text(
                    text = "Latest Discussions",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                repeat(3) {
                    DiscussionItem()
                    if (it < 2) Divider(modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }
}

@Composable
private fun DiscussionItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Best Agent Combinations",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "32 comments • 2h ago",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
        IconButton(onClick = { }) {
            Icon(Icons.Default.ArrowForward, "View Discussion")
        }
    }
}

@Preview
@Composable
private fun Preview() {
    GameDetailScreen(rememberNavController())
}