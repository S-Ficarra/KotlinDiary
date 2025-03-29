package com.example.mydiary.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mydiary.ui.screens.Diary
import com.example.mydiary.ui.screens.HomePage
import androidx.compose.animation.*
import androidx.compose.animation.core.tween

@Composable
fun Navigation() {
    // Crée un NavController qui gère la navigation
    val navController = rememberNavController()

    // Déclare un NavHost pour manage la navigation entre les screens
    NavHost(
        navController = navController,
        startDestination = "HomePage",
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { 1000 }, // L'écran arrive de la droite
                animationSpec = tween(500) // Animation dure 500ms
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -1200 }, // L'écran sort vers la gauche
                animationSpec = tween(500)
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -1000 }, // En revenant, l'écran vient de la gauche
                animationSpec = tween(500)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { 1000 }, // L'écran sort vers la droite
                animationSpec = tween(500)
            )
        }
    ) {
        // Déclare screens "HomePage"
        composable("HomePage") {
            HomePage(navController)
        }
        // Déclare screens "Diary"
        composable("Diary") {
            Diary(navController)
        }
    }
}
