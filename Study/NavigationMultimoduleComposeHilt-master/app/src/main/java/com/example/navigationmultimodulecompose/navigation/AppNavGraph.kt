package com.example.navigationmultimodulecompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.feature_api.register
import com.example.homeapi.HomeFeatureApi
import com.example.settingsapi.SettingsFeatureApi


@Composable
fun AppNavGraph(
    homeFeatureApi: HomeFeatureApi,
    settingsFeatureApi: SettingsFeatureApi,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "settings"
    ) {
        register(
            homeFeatureApi,
            navController = navController,
            modifier = modifier
        )

        register(
            settingsFeatureApi,
            navController = navController,
            modifier = modifier
        )


    }
}
