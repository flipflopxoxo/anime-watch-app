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
 * @param role Character's Role
 * @param manga 
 */


data class CharacterFullMangaInner (

    /* Character's Role */
    @SerializedName("role")
    val role: kotlin.String? = null,

    @SerializedName("manga")
    val manga: MangaMeta? = null

)

