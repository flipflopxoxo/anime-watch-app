package com.clydelizardo.animeon_watch.details.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.clydelizardo.animeon_watch.view.ErrorView
import com.clydelizardo.domain.AnimeDetailsModel
import com.clydelizardo.domain.AnimeType

@Preview
@Composable
fun AnimeDetailsPreview() {
    AnimeDetailsView(
        AnimeDetailsViewStateModel(
            animeDetails = AnimeDetailsModel(
                id = 1,
                titleEnglish = "[Oshi No Ko] Season 2",
                titleJapanese = "【推しの子】第2期",
                genres = listOf("Drama", "Supernatural"),
                themes = listOf("Reincarnation", "Showbiz"),
                type = AnimeType.TV,
                episodes = 13,
                status = "Currently Airing",
                duration = "25 min per ep",
                source = "Manga",
                openingThemes = listOf("\"Fatale (ファタール)\" by GEMN"),
                endingThemes = listOf("\"Burning\" by Hitsujibungaku (羊文学)"),
                relatedMedia = listOf("Adaptation - \"Oshi no Ko\"", "Prequal - Oshi no Ko"),
            )
        )
    ) {  }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeDetailsView(viewState: AnimeDetailsViewStateModel, onNavigateUp: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text(text = "Anime Details") }, navigationIcon = {
                IconButton(onClick = onNavigateUp) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, "navigate up")
                }
            })
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            if (viewState.isLoading) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            if (viewState.errorMessage != null) {
                ErrorView(
                    message = viewState.errorMessage,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
            if (viewState.animeDetails != null) {
                AnimeDetailsContent(animeDetailsModel = viewState.animeDetails)
            }
        }
    }
}

@Composable
private fun AnimeDetailsContent(animeDetailsModel: AnimeDetailsModel) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = animeDetailsModel.titleEnglish, style = MaterialTheme.typography.headlineMedium)
        Text(text = animeDetailsModel.titleJapanese, style = MaterialTheme.typography.titleSmall)
        Text(text = "Genres: ${asFormattedText(animeDetailsModel.genres)}")
        Text(text = "Themes: ${asFormattedText(animeDetailsModel.themes)}")
        Text(text = "Type: ${animeDetailsModel.type.displayName}")
        if (animeDetailsModel.episodes != null) {
            Text(text = "Episodes: ${animeDetailsModel.episodes}")
        }
        Text(text = "Status: ${animeDetailsModel.status}")
        Text(text = "Duration: ${animeDetailsModel.duration}")
        Text(text = "Source: ${animeDetailsModel.source}")
        if (animeDetailsModel.openingThemes.isNotEmpty()) {
            Text(text = "Opening theme(s)")
            animeDetailsModel.openingThemes.forEach {
                Text(text = it)
            }
        }
        if (animeDetailsModel.endingThemes.isNotEmpty()) {
            Text(text = "Ending theme(s)")
            animeDetailsModel.endingThemes.forEach {
                Text(text = it)
            }
        }
        if (animeDetailsModel.relatedMedia.isNotEmpty()) {
            Text(text = "Related media")
            animeDetailsModel.relatedMedia.forEach {
                Text(text = it)
            }
        }
    }
}

@Composable
private fun asFormattedText(textList: List<String>) =
    textList.joinToString(", ")