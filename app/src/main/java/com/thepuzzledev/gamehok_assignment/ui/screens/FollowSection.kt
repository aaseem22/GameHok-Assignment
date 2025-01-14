package com.thepuzzledev.gamehok_assignment.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thepuzzledev.gamehok_assignment.R

@Composable
fun FollowSection() {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                "People to follow",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )

            Text(
                "View more",
                fontSize = 20.sp,
                color = Color(0xFF4CAF50),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        ProfileCard(
            profileImage = R.drawable.people1,
            profileName = "Legend Gamer",
            onFollowClick = { /* Handle follow action */ }
        )
        ProfileCard(
            profileImage = R.drawable.people2,
            profileName = "Legend Gamer",
            onFollowClick = { /* Handle follow action */ }
        )
        ProfileCard(
            profileImage = R.drawable.people3,
            profileName = "Legend Gamer",
            onFollowClick = { /* Handle follow action */ }
        )
    }
}

@Composable
fun ProfileCard(
    profileImage: Int,
    profileName: String,
    onFollowClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isFollowing by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Image and Name
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(profileImage),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(
                text = profileName,
                fontSize = 18.sp,
                color = Color.White
            )
        }

        Button(
            onClick = {
                isFollowing = !isFollowing
                onFollowClick()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFollowing) Color.Transparent else Color(0xFF4CAF50).copy(0.2f),
            ),
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(
                text = if (isFollowing) "Following" else "Follow",
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ProfileExample() {
    FollowSection()
}
