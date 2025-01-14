package com.thepuzzledev.gamehok_assignment.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.thepuzzledev.gamehok_assignment.model.CourseData
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thepuzzledev.gamehok_assignment.R

@Composable
fun CourseSection() {
    val sampleCourses = listOf(
        CourseData(
            title = "Esports for Beginners",
            subtitle = "Start your journey with experts and be the professional you want",
            author = "Abhijeet Nishal",
            duration = "16 Mins",
            thumbnailId = R.drawable.course_thumbnail
        ),
        CourseData(
            title = "Advanced Gaming Strategies",
            subtitle = "Master advanced techniques and competitive gameplay",
            author = "Sarah Johnson",
            duration = "20 Mins",
            thumbnailId = R.drawable.course_thumbnail
        ),
        CourseData(
            title = "Game Analysis",
            subtitle = "Learn to analyze games and improve decision making and improve gyro",
            author = "Mike Chen",
            duration = "25 Mins",
            thumbnailId = R.drawable.course_thumbnail
        )
    )
    Column {
        Text("Learn from best to be the best",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp)
        )
        CourseCarousel(
            courses = sampleCourses,
            onStartCourse = { /* Handle course selection */ }
        )
    }
}

@Composable
fun CourseCarousel(
    courses: List<CourseData>,
    modifier: Modifier = Modifier,
    onStartCourse: (CourseData) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { courses.size })

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentPadding = PaddingValues(horizontal = 32.dp)
        ) { page ->
            CourseCard(
                courseData = courses[page],
                modifier = Modifier.fillMaxWidth(0.9f),
                onStartCourse = { onStartCourse(courses[page]) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth(),
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
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }
}


@Composable
fun CourseCard(
    courseData: CourseData,
    modifier: Modifier = Modifier,
    onStartCourse: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
            .clickable { onStartCourse() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF1F3FF)
        )
    ) {
        Box(
            modifier = Modifier.background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFC4CFFF)
                    ), startY = 0f, endY = Float.POSITIVE_INFINITY
                )
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Thumbnail with aspect ratio
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                    ) {
                        Image(
                            painter = painterResource(id = courseData.thumbnailId),
                            contentDescription = "Course Thumbnail",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(16.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }

                    // Course Info
                    Column(
                        modifier = Modifier
                            .weight(1.5f)
                            .wrapContentHeight(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = courseData.title,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            maxLines = 2
                        )

                        Text(
                            text = courseData.subtitle,
                            fontSize = 14.sp,
                            color = Color.Black.copy(alpha = 0.7f),
                            lineHeight = 20.sp,
                            maxLines = 3
                        )

                        Text(
                            text = "By ${courseData.author}",
                            fontSize = 14.sp,
                            color = Color.Black.copy(alpha = 0.7f),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Bottom Row with Duration and Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.course_time),
                            contentDescription = "Duration",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = courseData.duration,
                            fontSize = 16.sp,
                            color = Color.Black.copy(alpha = 0.7f)
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.start_course),
                            contentDescription = "Start Course",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "Start Course",
                            color = Color(0xFF4CAF50),
                            fontSize = 16.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CourseCardPreview() {
    CourseSection()
}