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
 * @param url MyAnimeList review URL
 * @param type Entry type
 * @param reactions 
 * @param date Review created date ISO8601
 * @param review Review content
 * @param score Number of user votes on the Review
 * @param tags Review tags
 * @param isSpoiler The review contains spoiler
 * @param isPreliminary The review was made before the entry was completed
 */


data class MangaReview (

    /* MyAnimeList ID */
    @SerializedName("mal_id")
    val malId: kotlin.Int? = null,

    /* MyAnimeList review URL */
    @SerializedName("url")
    val url: kotlin.String? = null,

    /* Entry type */
    @SerializedName("type")
    val type: kotlin.String? = null,

    @SerializedName("reactions")
    val reactions: MangaReviewReactions? = null,

    /* Review created date ISO8601 */
    @SerializedName("date")
    val date: kotlin.String? = null,

    /* Review content */
    @SerializedName("review")
    val review: kotlin.String? = null,

    /* Number of user votes on the Review */
    @SerializedName("score")
    val score: kotlin.Int? = null,

    /* Review tags */
    @SerializedName("tags")
    val tags: kotlin.collections.List<kotlin.String>? = null,

    /* The review contains spoiler */
    @SerializedName("is_spoiler")
    val isSpoiler: kotlin.Boolean? = null,

    /* The review was made before the entry was completed */
    @SerializedName("is_preliminary")
    val isPreliminary: kotlin.Boolean? = null

)

