package com.example.screen.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacionentreventanas.screen.nav.ScreenA
import com.example.navegacionentreventanas.screen.nav.ScreenB
import com.example.navegacionentreventanas.screen.nav.ScreenC

@Composable
@Preview(showBackground = true)
fun NavigationExample() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "screen_a"
    ) {
        composable(route = "screen_a") {
            ScreenA(navController)
        }

        composable(
            route = "screen_b/{nombre}/{correo}/{profesion}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("correo") { type = NavType.StringType },
                navArgument("profesion") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val correo = backStackEntry.arguments?.getString("correo") ?: ""
            val profesion = backStackEntry.arguments?.getString("profesion") ?: ""

            ScreenB(navController, nombre, correo, profesion)
        }

        composable(route = "screen_c") {
            ScreenC(navController)
        }
    }
}
