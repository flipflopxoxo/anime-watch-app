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
 * Youtube Details
 *
 * @param youtubeId YouTube ID
 * @param url YouTube URL
 * @param embedUrl Parsed Embed URL
 * @param images 
 */


data class Trailer (

    /* YouTube ID */
    @SerializedName("youtube_id")
    val youtubeId: String? = null,

    /* YouTube URL */
    @SerializedName("url")
    val url: String? = null,

    /* Parsed Embed URL */
    @SerializedName("embed_url")
    val embedUrl: String? = null,

    @SerializedName("images")
    val images: TrailerImagesImages? = null

)

