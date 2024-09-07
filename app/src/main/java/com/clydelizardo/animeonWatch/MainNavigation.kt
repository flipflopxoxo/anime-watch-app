package com.clydelizardo.animeonWatch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.clydelizardo.animeonWatch.presentation.common.Action
import com.clydelizardo.animeonWatch.presentation.details.AnimeDetailsView
import com.clydelizardo.animeonWatch.presentation.details.AnimeDetailsViewModel
import com.clydelizardo.animeonWatch.presentation.ongoing.OngoingAnimeListAction
import com.clydelizardo.animeonWatch.presentation.ongoing.OngoingAnimeListView
import com.clydelizardo.animeonWatch.presentation.ongoing.OngoingAnimeListViewModel

@Composable
fun MainNavHost(
    navController: NavHostController,
    startDestination: Navigation,
) {
    NavHost(navController = navController, startDestination = startDestination.path) {
        composable("ongoingAnime") {
            val vm = hiltViewModel<OngoingAnimeListViewModel>()
            val viewState by vm.state.collectAsState()
            OngoingAnimeListView(ongoingAnimeViewState = viewState, onAction = {
                handleAction(navController, it)
            })
        }
        composable(
            "animeDetails/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType }),
        ) {
            val vm = hiltViewModel<AnimeDetailsViewModel>()
            val viewState by vm.state.collectAsState()
            AnimeDetailsView(viewState = viewState, onAction = {
                handleAction(navController, it)
            })
        }
    }
}

private fun handleAction(navController: NavController, action: Action) {
    when (action) {
        is OngoingAnimeListAction.ShowAnimeDetails -> {
            navController.navigate(Navigation.AnimeDetails(action.animeId).path)
        }
        is Action.NavigateUp -> {
            navController.navigateUp()
        }
        else -> Unit
    }
}

sealed class Navigation {
    data object OngoingAnime : Navigation() {
        override val path = "ongoingAnime"
    }

    data class AnimeDetails(
        val id: Int,
    ) : Navigation() {
        override val path: String
            get() = "animeDetails/$id"
    }

    abstract val path: String
}
