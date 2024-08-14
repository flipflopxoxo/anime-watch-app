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
 * @param malId MyAnimeList ID or Episode Number
 * @param title Episode Title
 * @param episode Episode Subtitle
 * @param url Episode Page URL
 * @param images 
 */


data class AnimeVideosEpisodesAllOfData (

    /* MyAnimeList ID or Episode Number */
    @SerializedName("mal_id")
    val malId: kotlin.Int? = null,

    /* Episode Title */
    @SerializedName("title")
    val title: kotlin.String? = null,

    /* Episode Subtitle */
    @SerializedName("episode")
    val episode: kotlin.String? = null,

    /* Episode Page URL */
    @SerializedName("url")
    val url: kotlin.String? = null,

    @SerializedName("images")
    val images: CommonImages? = null

)

