package com.clydelizardo.animeonWatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.clydelizardo.animeonWatch.ui.theme.AnimeOnWatchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeOnWatchTheme {
                MainNavHost(
                    navController = rememberNavController(),
                    startDestination = Navigation.OngoingAnime,
                )
            }
        }
    }
}
