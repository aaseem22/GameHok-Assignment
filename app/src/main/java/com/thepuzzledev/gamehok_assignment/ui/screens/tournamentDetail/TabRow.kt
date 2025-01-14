package com.thepuzzledev.gamehok_assignment.ui.screens.tournamentDetail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thepuzzledev.gamehok_assignment.R
import kotlinx.coroutines.launch

@Composable
fun TournamentTabs() {
    val tabs = listOf("Overview", "Players", "Rules")
    val pagerState = rememberPagerState { tabs.size }
    val scope = rememberCoroutineScope()

    Column {
        TabRow(selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color(0xFF0A1F0A),
            contentColor = Color.White,
            divider = { /* Remove default divider */ }) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    modifier = Modifier.padding(vertical = 8.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Text(
                            text = title, fontWeight = if (pagerState.currentPage == index) {
                                FontWeight.Bold
                            } else {
                                FontWeight.Normal
                            }, color = if (pagerState.currentPage == index) {
                                Color.White
                            } else {
                                Color.White.copy(alpha = 0.6f)
                            }
                        )
                        // Custom indicator
                        if (pagerState.currentPage == index) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Box(
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(2.dp)
                                    .background(Color.White)
                            )
                        }
                    }
                }
            }
        }
        HorizontalPager(
            state = pagerState, modifier = Modifier.fillMaxSize()
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                when (page) {
                    0 -> OverviewContent()
                    1 -> PlayersContent()
                    2 -> RulesContent()
                }
            }
        }
    }
}

@Composable
private fun OverviewContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        Text(
            text = "Details", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White
        )

        DetailItem(
            icon = R.drawable.green_group, label = "TEAM SIZE", value = "Solo"
        )

        DetailItem(
            icon = R.drawable.format, label = "FORMAT", value = "Single Elimination"
        )

        DetailItem(
            icon = R.drawable.calendar,
            label = "TOURNAMENT STARTS",
            value = "Tue 24th Jan 2024, 01:00 PM"
        )

        DetailItem(
            icon = R.drawable.check_in,
            label = "CHECK-IN",
            value = "10 mins before the match starts"
        )
    }
}

@Composable
private fun PlayersContent() {
    Column {
        Text(
            text = "Registered Players", color = Color.White, fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun RulesContent() {
    Column {
        Text(
            text = "Tournament Rules", color = Color.White, fontWeight = FontWeight.Bold
        )
    }
}

@Preview()
@Composable
private fun TabPrev() {
    TournamentTabs()
}