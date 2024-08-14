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
 * 
 *
 * @param malId MyAnimeList ID
 * @param url MyAnimeList URL. This is the URL of the episode's video. If there is no video url, this will be null.
 * @param title Title
 * @param titleJapanese Title Japanese
 * @param titleRomanji title_romanji
 * @param duration Episode duration in seconds
 * @param aired Aired Date ISO8601
 * @param filler Filler episode
 * @param recap Recap episode
 * @param forumUrl Episode discussion forum URL
 */


data class AnimeEpisodesAllOfData (

    /* MyAnimeList ID */
    @SerializedName("mal_id")
    val malId: kotlin.Int? = null,

    /* MyAnimeList URL. This is the URL of the episode's video. If there is no video url, this will be null. */
    @SerializedName("url")
    val url: kotlin.String? = null,

    /* Title */
    @SerializedName("title")
    val title: kotlin.String? = null,

    /* Title Japanese */
    @SerializedName("title_japanese")
    val titleJapanese: kotlin.String? = null,

    /* title_romanji */
    @SerializedName("title_romanji")
    val titleRomanji: kotlin.String? = null,

    /* Episode duration in seconds */
    @SerializedName("duration")
    val duration: kotlin.Int? = null,

    /* Aired Date ISO8601 */
    @SerializedName("aired")
    val aired: kotlin.String? = null,

    /* Filler episode */
    @SerializedName("filler")
    val filler: kotlin.Boolean? = null,

    /* Recap episode */
    @SerializedName("recap")
    val recap: kotlin.Boolean? = null,

    /* Episode discussion forum URL */
    @SerializedName("forum_url")
    val forumUrl: kotlin.String? = null

)

