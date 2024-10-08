/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.network.models

import com.google.gson.annotations.SerializedName

/**
 * Anime Resource
 *
 * @param malId MyAnimeList ID
 * @param url MyAnimeList URL
 * @param images 
 * @param trailer 
 * @param approved Whether the entry is pending approval on MAL or not
 * @param titles All titles
 * @param title Title
 * @param titleEnglish English Title
 * @param titleJapanese Japanese Title
 * @param titleSynonyms Other Titles
 * @param type Anime Type
 * @param source Original Material/Source adapted from
 * @param episodes Episode count
 * @param status Airing status
 * @param airing Airing boolean
 * @param aired 
 * @param duration Parsed raw duration
 * @param rating Anime audience rating
 * @param score Score
 * @param scoredBy Number of users
 * @param rank Ranking
 * @param popularity Popularity
 * @param members Number of users who have added this entry to their list
 * @param favorites Number of users who have favorited this entry
 * @param synopsis Synopsis
 * @param background Background
 * @param season Season
 * @param year Year
 * @param broadcast 
 * @param producers 
 * @param licensors 
 * @param studios 
 * @param genres 
 * @param explicitGenres 
 * @param themes 
 * @param demographics 
 */


data class Anime (

    /* MyAnimeList ID */
    @SerializedName("mal_id")
    val malId: Int? = null,

    /* MyAnimeList URL */
    @SerializedName("url")
    val url: String? = null,

    @SerializedName("images")
    val images: AnimeImages? = null,

    @SerializedName("trailer")
    val trailer: TrailerBase? = null,

    /* Whether the entry is pending approval on MAL or not */
    @SerializedName("approved")
    val approved: Boolean? = null,

    /* All titles */
    @SerializedName("titles")
    val titles: List<Title>? = null,

    /* Title */
    @SerializedName("title")
    @Deprecated(message = "This property is deprecated.")
    val title: String? = null,

    /* English Title */
    @SerializedName("title_english")
    @Deprecated(message = "This property is deprecated.")
    val titleEnglish: String? = null,

    /* Japanese Title */
    @SerializedName("title_japanese")
    @Deprecated(message = "This property is deprecated.")
    val titleJapanese: String? = null,

    /* Other Titles */
    @SerializedName("title_synonyms")
    @Deprecated(message = "This property is deprecated.")
    val titleSynonyms: List<kotlin.String>? = null,

    /* Anime Type */
    @SerializedName("type")
    val type: Anime.Type? = null,

    /* Original Material/Source adapted from */
    @SerializedName("source")
    val source: String? = null,

    /* Episode count */
    @SerializedName("episodes")
    val episodes: Int? = null,

    /* Airing status */
    @SerializedName("status")
    val status: Anime.Status? = null,

    /* Airing boolean */
    @SerializedName("airing")
    val airing: Boolean? = null,

    @SerializedName("aired")
    val aired: Daterange? = null,

    /* Parsed raw duration */
    @SerializedName("duration")
    val duration: String? = null,

    /* Anime audience rating */
    @SerializedName("rating")
    val rating: Anime.Rating? = null,

    /* Score */
    @SerializedName("score")
    val score: Float? = null,

    /* Number of users */
    @SerializedName("scored_by")
    val scoredBy: Int? = null,

    /* Ranking */
    @SerializedName("rank")
    val rank: Int? = null,

    /* Popularity */
    @SerializedName("popularity")
    val popularity: Int? = null,

    /* Number of users who have added this entry to their list */
    @SerializedName("members")
    val members: Int? = null,

    /* Number of users who have favorited this entry */
    @SerializedName("favorites")
    val favorites: Int? = null,

    /* Synopsis */
    @SerializedName("synopsis")
    val synopsis: String? = null,

    /* Background */
    @SerializedName("background")
    val background: String? = null,

    /* Season */
    @SerializedName("season")
    val season: Anime.Season? = null,

    /* Year */
    @SerializedName("year")
    val year: Int? = null,

    @SerializedName("broadcast")
    val broadcast: Broadcast? = null,

    @SerializedName("producers")
    val producers: List<MalUrl>? = null,

    @SerializedName("licensors")
    val licensors: List<MalUrl>? = null,

    @SerializedName("studios")
    val studios: List<MalUrl>? = null,

    @SerializedName("genres")
    val genres: List<MalUrl>? = null,

    @SerializedName("explicit_genres")
    val explicitGenres: List<MalUrl>? = null,

    @SerializedName("themes")
    val themes: List<MalUrl>? = null,

    @SerializedName("demographics")
    val demographics: List<MalUrl>? = null

) {

    /**
     * Anime Type
     *
     * Values: TV,OVA,Movie,Special,ONA,Music
     */
    enum class Type(val value: String) {
        @SerializedName(value = "TV") TV("TV"),
        @SerializedName(value = "OVA") OVA("OVA"),
        @SerializedName(value = "Movie") Movie("Movie"),
        @SerializedName(value = "Special") Special("Special"),
        @SerializedName(value = "ONA") ONA("ONA"),
        @SerializedName(value = "Music") Music("Music");
    }
    /**
     * Airing status
     *
     * Values: Finished_Airing,Currently_Airing,Not_yet_aired
     */
    enum class Status(val value: String) {
        @SerializedName(value = "Finished Airing") Finished_Airing("Finished Airing"),
        @SerializedName(value = "Currently Airing") Currently_Airing("Currently Airing"),
        @SerializedName(value = "Not yet aired") Not_yet_aired("Not yet aired");
    }
    /**
     * Anime audience rating
     *
     * Values: G_Minus_All_Ages,PG_Minus_Children,PGMinus13_Minus_Teens_13_or_older,R_Minus_17Plus_Left_ParenthesisViolence_Ampersand_profanityRight_Parenthesis,RPlus_Minus_Mild_Nudity,Rx_Minus_Hentai
     */
    enum class Rating(val value: String) {
        @SerializedName(value = "G - All Ages") G_Minus_All_Ages("G - All Ages"),
        @SerializedName(value = "PG - Children") PG_Minus_Children("PG - Children"),
        @SerializedName(value = "PG-13 - Teens 13 or older") PGMinus13_Minus_Teens_13_or_older("PG-13 - Teens 13 or older"),
        @SerializedName(value = "R - 17+ (violence & profanity)") R_Minus_17Plus_Left_ParenthesisViolence_Ampersand_profanityRight_Parenthesis("R - 17+ (violence & profanity)"),
        @SerializedName(value = "R+ - Mild Nudity") RPlus_Minus_Mild_Nudity("R+ - Mild Nudity"),
        @SerializedName(value = "Rx - Hentai") Rx_Minus_Hentai("Rx - Hentai");
    }
    /**
     * Season
     *
     * Values: summer,winter,spring,fall
     */
    enum class Season(val value: String) {
        @SerializedName(value = "summer") summer("summer"),
        @SerializedName(value = "winter") winter("winter"),
        @SerializedName(value = "spring") spring("spring"),
        @SerializedName(value = "fall") fall("fall");
    }

}

