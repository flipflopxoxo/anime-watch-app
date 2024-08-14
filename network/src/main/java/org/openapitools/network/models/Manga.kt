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
 * Manga Resource
 *
 * @param malId MyAnimeList ID
 * @param url MyAnimeList URL
 * @param images 
 * @param approved Whether the entry is pending approval on MAL or not
 * @param titles All Titles
 * @param title Title
 * @param titleEnglish English Title
 * @param titleJapanese Japanese Title
 * @param type Manga Type
 * @param chapters Chapter count
 * @param volumes Volume count
 * @param status Publishing status
 * @param publishing Publishing boolean
 * @param published 
 * @param score Score
 * @param scoredBy Number of users
 * @param rank Ranking
 * @param popularity Popularity
 * @param members Number of users who have added this entry to their list
 * @param favorites Number of users who have favorited this entry
 * @param synopsis Synopsis
 * @param background Background
 * @param authors 
 * @param serializations 
 * @param genres 
 * @param explicitGenres 
 * @param themes 
 * @param demographics 
 */


data class Manga (

    /* MyAnimeList ID */
    @SerializedName("mal_id")
    val malId: kotlin.Int? = null,

    /* MyAnimeList URL */
    @SerializedName("url")
    val url: kotlin.String? = null,

    @SerializedName("images")
    val images: MangaImages? = null,

    /* Whether the entry is pending approval on MAL or not */
    @SerializedName("approved")
    val approved: kotlin.Boolean? = null,

    /* All Titles */
    @SerializedName("titles")
    val titles: kotlin.collections.List<Title>? = null,

    /* Title */
    @SerializedName("title")
    @Deprecated(message = "This property is deprecated.")
    val title: kotlin.String? = null,

    /* English Title */
    @SerializedName("title_english")
    @Deprecated(message = "This property is deprecated.")
    val titleEnglish: kotlin.String? = null,

    /* Japanese Title */
    @SerializedName("title_japanese")
    @Deprecated(message = "This property is deprecated.")
    val titleJapanese: kotlin.String? = null,

    /* Manga Type */
    @SerializedName("type")
    val type: Manga.Type? = null,

    /* Chapter count */
    @SerializedName("chapters")
    val chapters: kotlin.Int? = null,

    /* Volume count */
    @SerializedName("volumes")
    val volumes: kotlin.Int? = null,

    /* Publishing status */
    @SerializedName("status")
    val status: Manga.Status? = null,

    /* Publishing boolean */
    @SerializedName("publishing")
    val publishing: kotlin.Boolean? = null,

    @SerializedName("published")
    val published: Daterange? = null,

    /* Score */
    @SerializedName("score")
    val score: kotlin.Float? = null,

    /* Number of users */
    @SerializedName("scored_by")
    val scoredBy: kotlin.Int? = null,

    /* Ranking */
    @SerializedName("rank")
    val rank: kotlin.Int? = null,

    /* Popularity */
    @SerializedName("popularity")
    val popularity: kotlin.Int? = null,

    /* Number of users who have added this entry to their list */
    @SerializedName("members")
    val members: kotlin.Int? = null,

    /* Number of users who have favorited this entry */
    @SerializedName("favorites")
    val favorites: kotlin.Int? = null,

    /* Synopsis */
    @SerializedName("synopsis")
    val synopsis: kotlin.String? = null,

    /* Background */
    @SerializedName("background")
    val background: kotlin.String? = null,

    @SerializedName("authors")
    val authors: kotlin.collections.List<MalUrl>? = null,

    @SerializedName("serializations")
    val serializations: kotlin.collections.List<MalUrl>? = null,

    @SerializedName("genres")
    val genres: kotlin.collections.List<MalUrl>? = null,

    @SerializedName("explicit_genres")
    val explicitGenres: kotlin.collections.List<MalUrl>? = null,

    @SerializedName("themes")
    val themes: kotlin.collections.List<MalUrl>? = null,

    @SerializedName("demographics")
    val demographics: kotlin.collections.List<MalUrl>? = null

) {

    /**
     * Manga Type
     *
     * Values: Manga,Novel,Light_Novel,OneMinusShot,Doujinshi,Manhua,Manhwa,OEL
     */
    enum class Type(val value: kotlin.String) {
        @SerializedName(value = "Manga") Manga("Manga"),
        @SerializedName(value = "Novel") Novel("Novel"),
        @SerializedName(value = "Light Novel") Light_Novel("Light Novel"),
        @SerializedName(value = "One-shot") OneMinusShot("One-shot"),
        @SerializedName(value = "Doujinshi") Doujinshi("Doujinshi"),
        @SerializedName(value = "Manhua") Manhua("Manhua"),
        @SerializedName(value = "Manhwa") Manhwa("Manhwa"),
        @SerializedName(value = "OEL") OEL("OEL");
    }
    /**
     * Publishing status
     *
     * Values: Finished,Publishing,On_Hiatus,Discontinued,Not_yet_published
     */
    enum class Status(val value: kotlin.String) {
        @SerializedName(value = "Finished") Finished("Finished"),
        @SerializedName(value = "Publishing") Publishing("Publishing"),
        @SerializedName(value = "On Hiatus") On_Hiatus("On Hiatus"),
        @SerializedName(value = "Discontinued") Discontinued("Discontinued"),
        @SerializedName(value = "Not yet published") Not_yet_published("Not yet published");
    }

}

