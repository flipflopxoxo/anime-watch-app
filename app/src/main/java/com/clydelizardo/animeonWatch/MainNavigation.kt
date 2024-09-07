package com.clydelizardo.animeonWatch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.clydelizardo.animeonWatch.presentation.common.BaseViewModel
import com.clydelizardo.animeonWatch.presentation.details.AnimeDetailsView
import com.clydelizardo.animeonWatch.presentation.details.AnimeDetailsViewAction
import com.clydelizardo.animeonWatch.presentation.details.AnimeDetailsViewModel
import com.clydelizardo.animeonWatch.presentation.ongoing.OngoingAnimeListAction
import com.clydelizardo.animeonWatch.presentation.ongoing.OngoingAnimeListView
import com.clydelizardo.animeonWatch.presentation.ongoing.OngoingAnimeListViewAction
import com.clydelizardo.animeonWatch.presentation.ongoing.OngoingAnimeListViewModel

@Composable
fun MainNavHost(
    navController: NavHostController,
    startDestination: Navigation,
) {
    NavHost(navController = navController, startDestination = startDestination.path) {
        composable("ongoingAnime") {
            val vm = hiltViewModel<OngoingAnimeListViewModel>()
            LaunchedEffect(vm) {
                vm.handleAction(OngoingAnimeListViewAction.LoadOngoingAnimeList)
            }
            val viewState by vm.state.collectAsState()
            OngoingAnimeListView(ongoingAnimeViewState = viewState, onAction = { action ->
                handleAction(vm, navController, action)
            })
        }
        composable(
            "animeDetails/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType }),
        ) {
            val vm = hiltViewModel<AnimeDetailsViewModel>()
            LaunchedEffect(vm) {
                vm.handleAction(AnimeDetailsViewAction.LoadAnimeDetails(it.arguments!!.getInt("id")))
            }
            val viewState by vm.state.collectAsState()
            AnimeDetailsView(viewState = viewState, onAction = { action ->
                handleAction(vm, navController, action)
            })
        }
    }
}

private inline fun <reified A : Action> handleAction(
    viewModel: BaseViewModel<A>,
    navController: NavController,
    action: Action
) {
    if (action is A && viewModel.handleAction(action)) {
        return
    }
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
