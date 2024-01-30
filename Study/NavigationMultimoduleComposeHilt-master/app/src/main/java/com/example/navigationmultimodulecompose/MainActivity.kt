package com.example.navigationmultimodulecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationmultimodulecompose.presentation.AppContent
import com.example.navigationmultimodulecompose.ui.theme.NavigationMultimoduleComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        DependencyProvider.provideImpl(
//            homeFeatureApi = HomeFeatureImpl(),
//            settingsFeatureApi = SettingsFeatureImpl(),
//
//            )




        setContent {

            // A surface container using the 'background' color from the theme
            AppContent(

            )

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationMultimoduleComposeTheme {
        Greeting("Android")
    }
}