package com.clydelizardo.animeonWatch.data.ongoing

import com.clydelizardo.animeonWatch.data.mapper.ApiAnimeTypeToAnimeTypeMapper
import com.clydelizardo.models.AnimeModel
import com.clydelizardo.models.AnimeType
import com.clydelizardo.models.ImageSource
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.openapitools.network.models.Anime
import org.openapitools.network.models.AnimeImages
import org.openapitools.network.models.AnimeImagesJpg
import org.openapitools.network.models.MalUrl
import org.openapitools.network.models.Title

class AnimeToAnimeModelMapperTest {
    @get:Rule
    val rule = MockKRule(this)

    @MockK
    lateinit var animeTypeMapper: ApiAnimeTypeToAnimeTypeMapper

    lateinit var mapper: AnimeToAnimeModelMapper

    @Before
    fun setup() {
        mapper = AnimeToAnimeModelMapper(animeTypeMapper)
    }

    @Test
    fun `Given anime instance, Then map to anime model`() {
        every { animeTypeMapper.map(any()) } returns AnimeType.Unknown
        val anime =
            Anime(
                malId = 1,
                titles =
                listOf(
                    Title(type = "English", title = "Oshi no Ko"),
                ),
                images =
                AnimeImages(
                    jpg =
                    AnimeImagesJpg(
                        imageUrl = "imageUrl",
                        smallImageUrl = "smallImageUrl",
                        largeImageUrl = "largeImageUrl",
                    ),
                ),
                synopsis = "With the help of producer Masaya Kaburagi, Aquamarine \"Aqua\" Hoshino and Kana Arima have landed the roles of Touki and Tsurugi in Lala Lai Theatrical Company's stage adaptation of the popular manga series Tokyo Blade. Co-starring with them is Aqua's girlfriend, Akane Kurokawa, who plays Touki's fiancée, Princess Saya. Due to the fanbase preferring Tsurugi as Touki's love interest, Saya has made fewer and fewer appearances in the manga, making it difficult for Akane to fully immerse herself in the role. Her struggles are compounded by differences between the play's script and the original work—differences that also greatly frustrate Tokyo Blade's author, Abiko Samejima.\n",
                genres =
                listOf(
                    MalUrl(name = "Drama"),
                    MalUrl(name = "Supernatural"),
                ),
                type = Anime.Type.TV,
                episodes = 13,
                duration = "25 min per ep",
            )
        val expected =
            AnimeModel(
                id = 1,
                name = "Oshi no Ko",
                image =
                ImageSource(
                    smallUrl = "smallImageUrl",
                    mediumUrl = "imageUrl",
                    largeUrl = "largeImageUrl",
                ),
                synopsis = "With the help of producer Masaya Kaburagi, Aquamarine \"Aqua\" Hoshino and Kana Arima have landed the roles of Touki and Tsurugi in Lala Lai Theatrical Company's stage adaptation of the popular manga series Tokyo Blade. Co-starring with them is Aqua's girlfriend, Akane Kurokawa, who plays Touki's fiancée, Princess Saya. Due to the fanbase preferring Tsurugi as Touki's love interest, Saya has made fewer and fewer appearances in the manga, making it difficult for Akane to fully immerse herself in the role. Her struggles are compounded by differences between the play's script and the original work—differences that also greatly frustrate Tokyo Blade's author, Abiko Samejima.\n",
                genres = listOf("Drama", "Supernatural"),
                type = AnimeType.Unknown,
                episodes = 13,
                duration = "25 min per ep",
            )

        val result = mapper.map(anime)
        Assert.assertEquals(expected, result)
    }
}