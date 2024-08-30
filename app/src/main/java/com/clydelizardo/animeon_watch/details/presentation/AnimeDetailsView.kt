package com.clydelizardo.animeon_watch.details.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.clydelizardo.animeon_watch.view.ErrorView
import com.clydelizardo.domain.AnimeDetailsModel
import com.clydelizardo.domain.AnimeType
import com.clydelizardo.domain.ImageSource

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
                imageSource = ImageSource(
                    smallUrl = "",
                    mediumUrl = "",
                    largeUrl = "",
                )
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
                    modifier = Modifier.align(Alignment.TopCenter),
                    onRetry = { /*TODO*/ }
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
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = animeDetailsModel.titleEnglish,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 4.dp),
            text = animeDetailsModel.titleJapanese,
            style = MaterialTheme.typography.titleSmall
        )
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = animeDetailsModel.imageSource.largeUrl,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        DetailEntry(label = "Genres: ", text = asFormattedText(animeDetailsModel.genres))
        DetailEntry(label = "Themes: ", text = asFormattedText(animeDetailsModel.themes))
        DetailEntry(label = "Types: ", text = animeDetailsModel.type.displayName)
        if (animeDetailsModel.episodes != null) {
            DetailEntry(label = "Episodes: ", text = animeDetailsModel.episodes.toString())
        }
        DetailEntry(label = "Status: ", text = animeDetailsModel.status)
        DetailEntry(label = "Duration: ", text = animeDetailsModel.duration)
        DetailEntry(label = "Source: ", text = animeDetailsModel.source)
        if (animeDetailsModel.openingThemes.isNotEmpty()) {
            DetailHeader("Opening theme(s)")
            animeDetailsModel.openingThemes.forEach {
                ValueItem(text = it)
            }
        }
        if (animeDetailsModel.endingThemes.isNotEmpty()) {
            DetailHeader(text = "Ending theme(s)")
            animeDetailsModel.endingThemes.forEach {
                ValueItem(text = it)
            }
        }
        if (animeDetailsModel.relatedMedia.isNotEmpty()) {
            DetailHeader(text = "Related media")
            animeDetailsModel.relatedMedia.forEach {
                ValueItem(text = it)
            }
        }
    }
}

@Composable
private fun ValueItem(text: String) {
    Text(
        modifier = Modifier.padding(top = 6.dp, start = 8.dp, end = 8.dp),
        text = text
    )
}

@Composable
private fun DetailHeader(text: String) {
    Text(
        modifier = Modifier.padding(top = 12.dp, start = 8.dp, end = 8.dp),
        text = text,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun DetailEntry(label: String? = null, text: String) {
    Text(
        modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp),
        text = AnnotatedString(
            label.orEmpty(),
            spanStyle = SpanStyle(fontWeight = FontWeight.Bold)
        ) + AnnotatedString(text)
    )
}

@Composable
private fun asFormattedText(textList: List<String>) =
    textList.joinToString(", ")