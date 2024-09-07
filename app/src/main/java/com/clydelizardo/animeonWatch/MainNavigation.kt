package com.clydelizardo.animeonWatch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.clydelizardo.animeonWatch.details.presentation.AnimeDetailsView
import com.clydelizardo.animeonWatch.details.presentation.AnimeDetailsViewModel
import com.clydelizardo.animeonWatch.ongoing.presentation.OngoingAnimeListView
import com.clydelizardo.animeonWatch.ongoing.presentation.OngoingAnimeListViewModel

@Composable
fun MainNavHost(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("ongoingAnime") {
            val vm = hiltViewModel<OngoingAnimeListViewModel>()
            val viewState by vm.state.collectAsState()
            OngoingAnimeListView(ongoingAnimeViewState = viewState, onNavigate = {
                navController.navigate(it.path)
            })
        }
        composable(
            "animeDetails/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType }),
        ) {
            val vm = hiltViewModel<AnimeDetailsViewModel>()
            val viewState by vm.state.collectAsState()
            AnimeDetailsView(viewState = viewState, onNavigateUp = { navController.navigateUp() })
        }
    }
}

sealed class NavigationAction {
    data object OngoingAnime : NavigationAction() {
        override val path = "ongoingAnime"
    }

    data class AnimeDetails(
        val id: Int,
    ) : NavigationAction() {
        override val path: String
            get() = "animeDetails/$id"
    }

    abstract val path: String
}
