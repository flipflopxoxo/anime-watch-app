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
 * @param type Title type
 * @param title Title value
 */


data class Title (

    /* Title type */
    @SerializedName("type")
    val type: kotlin.String? = null,

    /* Title value */
    @SerializedName("title")
    val title: kotlin.String? = null

)

