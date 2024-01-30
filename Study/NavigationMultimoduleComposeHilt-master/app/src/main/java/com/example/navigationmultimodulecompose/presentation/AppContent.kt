package com.example.navigationmultimodulecompose.presentation


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.homeapi.HomeFeatureApi
import com.example.navigationmultimodulecompose.MainViewModel
import com.example.navigationmultimodulecompose.navigation.AppNavGraph
import com.example.navigationmultimodulecompose.ui.theme.NavigationMultimoduleComposeTheme
import com.example.settingsapi.SettingsFeatureApi
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(

) {
    ProvideWindowInsets {
        NavigationMultimoduleComposeTheme {
            val viemodel: MainViewModel = hiltViewModel()
            val tabs = remember { BottomTabs.values() }
            val navController = rememberNavController()
            Scaffold(

                bottomBar = { BottomBar(navController = navController, tabs) }
            ) { innerPaddingModifier ->
                AppNavGraph(
                   viemodel.homeFeatureApi,
                   viemodel.settingsFeatureApi,
                    navController = navController,
                    modifier = Modifier.padding(innerPaddingModifier)
                )
            }
        }
    }
}

@Composable
fun BottomBar(navController: NavController, tabs: Array<BottomTabs>) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: BottomTabs.HOME.route

    val routes = remember { BottomTabs.values().map { it.route } }
    if (currentRoute in routes) {
        NavigationBar(
            Modifier.navigationBarsHeight(additional = 56.dp)

        ) {

            tabs.forEach { tab ->
                NavigationBarItem(
                    icon = { Icon(painterResource(tab.icon), contentDescription = null) },
                    label = { Text(tab.title.uppercase(Locale.getDefault())) },
                    selected = currentRoute == tab.route,
                    onClick = {
                        if (tab.route != currentRoute) {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    alwaysShowLabel = false,

                    modifier = Modifier.navigationBarsPadding()
                )
            }
        }
    }
}
