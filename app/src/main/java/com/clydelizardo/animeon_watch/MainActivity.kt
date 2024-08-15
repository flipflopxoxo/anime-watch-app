package com.clydelizardo.animeon_watch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.clydelizardo.animeon_watch.ongoing.presentation.OngoingAnimeListView
import com.clydelizardo.animeon_watch.ongoing.presentation.OngoingAnimeListViewModel
import com.clydelizardo.animeon_watch.ui.theme.AnimeOnWatchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: OngoingAnimeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeOnWatchTheme {
                val vm = viewModel
                val viewState by vm.state.collectAsState()
                OngoingAnimeListView(ongoingAnimeViewState = viewState)
            }
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
    AnimeOnWatchTheme {
        Greeting("Android")
    }
}