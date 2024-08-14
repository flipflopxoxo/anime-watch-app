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
 * @param url MyAnimeList URL
 * @param images 
 * @param name Entry name
 */


data class CharacterMeta (

    /* MyAnimeList ID */
    @SerializedName("mal_id")
    val malId: kotlin.Int? = null,

    /* MyAnimeList URL */
    @SerializedName("url")
    val url: kotlin.String? = null,

    @SerializedName("images")
    val images: CharacterImages? = null,

    /* Entry name */
    @SerializedName("name")
    val name: kotlin.String? = null

)

