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
 * @param jpg 
 * @param webp 
 */


data class UserImages (

    @SerializedName("jpg")
    val jpg: UserImagesJpg? = null,

    @SerializedName("webp")
    val webp: UserImagesWebp? = null

)

