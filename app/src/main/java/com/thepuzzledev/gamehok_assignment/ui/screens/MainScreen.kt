package com.thepuzzledev.gamehok_assignment.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
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

@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF001208))
            .verticalScroll(scrollState)
            .padding(top = 4.dp)

    ) {
        ProfileSection()
        PremiumCardsCarousel(onGetNowClick = { }, onViewAllFeatureClick = { })
        GamesSection(navController)
        HorizontalDivider(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp), thickness = 1.dp
        )
        Spacer(modifier = Modifier.height(6.dp))
        TournamentSection(navController)
        Spacer(modifier = Modifier.height(14.dp))
        CourseSection()
        Spacer(modifier = Modifier.height(14.dp))
        FollowSection()
    }

}

@Composable
fun ProfileSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {

        Box(
            contentAlignment = Alignment.BottomEnd, modifier = Modifier.size(56.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "Circle Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF01A74B))
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    contentDescription = "Overlay Icon",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0xFF4CAF50), shape = RoundedCornerShape(24.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.tickets),
                            contentDescription = "Ticket Icon",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "245",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    VerticalDivider(
                        color = Color.White, modifier = Modifier
                            .width(1.dp)
                            .height(24.dp)
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.coins),
                            contentDescription = "Coin Icon",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "2456", // Coin count
                            color = Color.White, style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Notification Icon",
                tint = Color.White,
                modifier = Modifier.size(26.dp)
            )
        }
    }
}

@Composable
fun PremiumCardsCarousel(
    onGetNowClick: () -> Unit, onViewAllFeatureClick: () -> Unit, modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = { 3 })

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxWidth()
    ) {
        HorizontalPager(
            state = pagerState, modifier = Modifier.fillMaxWidth()
        ) {
            PremiumCard(
                onGetNowClick = onGetNowClick,
                onViewAllFeatureClick = onViewAllFeatureClick,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
        Row(
            Modifier
                .padding(top = 16.dp, bottom = 8.dp)
                .height(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) {
                    Color.White
                } else {
                    Color.LightGray
                }
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }
}


@Composable
fun PremiumCard(
    onGetNowClick: () -> Unit, onViewAllFeatureClick: () -> Unit, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp), shape = RoundedCornerShape(24.dp)
    ) {
        Box(
            modifier = Modifier.background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFEEBA6), Color(0xFFFFFFFF)
                    ), startY = 0f, endY = Float.POSITIVE_INFINITY
                )
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Gamehok",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Surface(
                        color = Color(0xFFFFE5B1), shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = "Premium",
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Button(
                        onClick = onGetNowClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE97F5A)
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.height(32.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp)
                    ) {
                        Text(
                            text = "Get Now", color = Color.White, fontSize = 14.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Upgrade to premium membership and get",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
                Text(
                    text = "100 🎫 and many other premium features.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )

                TextButton(
                    onClick = onViewAllFeatureClick, colors = ButtonDefaults.textButtonColors(
                        contentColor = Color(0xFF4CAF50)
                    )
                ) {
                    Text(
                        text = "View All Feature", fontSize = 18.sp, fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "›", fontSize = 18.sp, fontWeight = FontWeight.Bold
                    )
                }
            }
        }

    }
}

@Composable
fun GamesSection(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                "Play tournaments by games",
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
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(8.dp)
        ) {
            GameCard(imageUrl = R.drawable.pubg,
                gameName = "PUBG",
                modifier = Modifier.padding(8.dp),
                onClick = { navController.navigate("GameDetail") })
            GameCard(imageUrl = R.drawable.cod,
                gameName = "Call of Duty",
                modifier = Modifier.padding(8.dp),
                onClick = { navController.navigate("GameDetail") })
            GameCard(imageUrl = R.drawable.cs,
                gameName = "Counter Strike ",
                modifier = Modifier.padding(8.dp),
                onClick = { navController.navigate("GameDetail") })

        }

    }
}

@Composable
fun GameCard(
    imageUrl: Int, gameName: String, modifier: Modifier = Modifier, onClick: () -> Unit = {}
) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier) {
        Card(
            modifier = Modifier
                .width(100.dp)
                .height(120.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ), onClick = onClick
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(imageUrl),
                        contentDescription = "$gameName game image",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                }

                Text(
                    text = gameName,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MainScreenPrev() {
    HomeScreen(rememberNavController())
}

