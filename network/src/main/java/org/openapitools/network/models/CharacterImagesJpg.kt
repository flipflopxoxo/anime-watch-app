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
 * Available images in JPG
 *
 * @param imageUrl Image URL JPG
 * @param smallImageUrl Small Image URL JPG
 */


data class CharacterImagesJpg (

    /* Image URL JPG */
    @SerializedName("image_url")
    val imageUrl: kotlin.String? = null,

    /* Small Image URL JPG */
    @SerializedName("small_image_url")
    val smallImageUrl: kotlin.String? = null

)

