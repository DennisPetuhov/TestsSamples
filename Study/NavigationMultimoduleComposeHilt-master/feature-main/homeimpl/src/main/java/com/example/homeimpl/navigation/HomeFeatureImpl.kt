package com.example.homeimpl.navigation

import android.net.Uri
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.homeapi.HomeFeatureApi

import com.example.homeimpl.presentation.HomeScreen
import com.example.homeimpl.presentation.ScreenA
import com.example.homeimpl.presentation.ScreenB
import javax.inject.Inject

private const val baseRoute = "home"
private const val scenarioABRoute = "$baseRoute/scenario"
private const val screenBRoute = "$scenarioABRoute/B"
private const val screenARoute = "$scenarioABRoute/A"
private const val argumentKey = "arg"

class HomeFeatureImpl @Inject constructor() : HomeFeatureApi {

    override val homeRoute = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {

        navGraphBuilder.composable(baseRoute) {
            HomeScreen(
                modifier = modifier,
                onNavigateToABFlow = {
                    navController.navigate(scenarioABRoute)
                }
            )
        }

        /* Nested graph for internal scenario */
        navGraphBuilder.navigation(
            route = scenarioABRoute,
            startDestination = screenARoute
        ) {

            composable(route = screenARoute) {
                ScreenA(
                    modifier = modifier,
                    onNavigateNextWithArgument = { argument ->
                        val encodedArgument = Uri.encode(argument)
                        navController.navigate(route = "$screenBRoute/$encodedArgument")
                    }
                )
            }

            composable(
                route = "$screenBRoute/{$argumentKey}",
                arguments = listOf(
                    navArgument(argumentKey) {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val arguments = requireNotNull(backStackEntry.arguments)
                val argument = Uri.decode(arguments.getString(argumentKey).orEmpty())

                ScreenB(
                    modifier = modifier,
                    argument = argument.orEmpty()
                )
            }
        }
    }
}