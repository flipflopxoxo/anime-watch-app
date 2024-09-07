package com.clydelizardo.animeonWatch.presentation.ongoing

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.clydelizardo.models.AnimeModel
import com.clydelizardo.models.AnimeType
import com.clydelizardo.models.ImageSource

@Preview
@Composable
fun AnimeListItemViewPreview() {
    Box(modifier = Modifier.background(Color.White)) {
        AnimeListItemView(
            animeModel =
                AnimeModel(
                    id = 1,
                    name = "Oshi no Ko",
                    image =
                        ImageSource(
                            smallUrl = "",
                            mediumUrl = "",
                            largeUrl = "",
                        ),
                    synopsis = "With the help of producer Masaya Kaburagi, Aquamarine \"Aqua\" Hoshino and Kana Arima have landed the roles of Touki and Tsurugi in Lala Lai Theatrical Company's stage adaptation of the popular manga series Tokyo Blade. Co-starring with them is Aqua's girlfriend, Akane Kurokawa, who plays Touki's fiancée, Princess Saya. Due to the fanbase preferring Tsurugi as Touki's love interest, Saya has made fewer and fewer appearances in the manga, making it difficult for Akane to fully immerse herself in the role. Her struggles are compounded by differences between the play's script and the original work—differences that also greatly frustrate Tokyo Blade's author, Abiko Samejima.\n",
                    genres = listOf("Drama", "Supernatural"),
                    type = AnimeType.TV,
                    episodes = 13,
                    duration = "25 min per ep",
                ),
            modifier = Modifier,
        )
    }
}

@Composable
fun AnimeListItemView(
    modifier: Modifier = Modifier,
    animeModel: AnimeModel,
    onClick: (AnimeModel) -> Unit = {},
) {
    Column(
        modifier =
            modifier.clickable {
                onClick(animeModel)
            },
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
            text = animeModel.name,
            style = MaterialTheme.typography.headlineSmall,
        )
        val durationText =
            when (animeModel.type) {
                AnimeType.TV ->
                    (
                        if (animeModel.episodes != null) {
                            animeModel.episodes.toString()
                        } else {
                            "?"
                        }
                    ) + " episodes - "

                else -> ""
            } + animeModel.duration
        Text(
            modifier =
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 4.dp),
            text = durationText,
        )
        Row(
            // Genres
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        ) {
            animeModel.genres.forEach {
                Box(
                    modifier =
                        Modifier.border(
                            1.dp,
                            color = MaterialTheme.colorScheme.onSurface,
                            shape = RoundedCornerShape(6.dp),
                        ),
                ) {
                    Text(modifier = Modifier.padding(2.dp), text = it)
                }
            }
        }
        Row {
            AsyncImage(
                model = animeModel.image.largeUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier =
                    Modifier
                        .weight(0.5f)
                        .aspectRatio(0.707f),
            )
            Text(
                modifier =
                    Modifier
                        .padding(8.dp)
                        .weight(0.5f)
                        .aspectRatio(0.707f),
                text = animeModel.synopsis,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}
