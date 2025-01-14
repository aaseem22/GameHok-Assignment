package com.thepuzzledev.gamehok_assignment.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thepuzzledev.gamehok_assignment.ui.screens.GameDetailScreen
import com.thepuzzledev.gamehok_assignment.ui.screens.HomeScreen
import com.thepuzzledev.gamehok_assignment.ui.screens.tournamentDetail.TournamentDetailScreen

@Composable
fun NavigationHost() {
    val navController = rememberNavController() // Create NavController

    // Set up the NavHost
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") { HomeScreen(navController) }
        composable("TournamentDetail") { TournamentDetailScreen(navController) }
        composable("GameDetail") { GameDetailScreen(navController) }
    }
}
