package com.thepuzzledev.gamehok_assignment.ui.screens.tournamentDetail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thepuzzledev.gamehok_assignment.R

@Composable
fun OrganizerDetailsCard() {
    Card(
        modifier = Modifier

            .fillMaxWidth()

            .padding(16.dp)
        ,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(width = 1.dp, color = Color.White.copy(0.5f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF001208))
        ) {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF182920), Color(0xFF4D5A53)
                            ), startY = 0f, endY = Float.POSITIVE_INFINITY
                        )
                    )
                    .padding(24.dp)
            ) {
                Text(
                    text = "Organiser's Details and contact",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Normal
                )
            }

            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.gs),
                            contentDescription = "Gamehok Sports Logo",
                            modifier = Modifier.size(28.dp)
                        )
                        Text(
                            text = "Gamehok Esports",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Button(
                        onClick = { /* Handle follow action */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF002E14)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Follow",
                            color = Color.White,
                            fontSize = 14.sp,
                        )
                    }
                }

                Text(
                    text = "This is the in house organiser of this platform\nyou can follow our page on this platform for\nregular updates",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 16.sp,
                    lineHeight = 24.sp
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        ContactRow(
                            icon = Icons.Default.Phone, text = "9890987754"
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        ContactRow(
                            icon = Icons.Default.Email, text = "Support@gamehok.com"
                        )
                    }


                    ContactRow(
                        icon = Icons.Default.Notifications, text = "9890987754"
                    )
                }
            }
        }
    }
}

@Composable
private fun ContactRow(
    icon: ImageVector, text: String, modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = text, color = Color.White, fontSize = 14.sp
        )
    }
}

@Preview
@Composable
private fun Prev() {
    OrganizerDetailsCard()
}
