package com.example.settingsimpl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.settingsapi.SettingsFeatureApi
import com.example.settingsimpl.presentation.SettingsScreen
import javax.inject.Inject

class SettingsFeatureImpl  @Inject constructor(): SettingsFeatureApi {

    override val settingsRoute: String = "settings"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(settingsRoute) {
            SettingsScreen(modifier = modifier)
        }
    }
}