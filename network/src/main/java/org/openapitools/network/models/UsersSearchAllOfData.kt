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
 * @param url MyAnimeList URL
 * @param username MyAnimeList Username
 * @param images 
 * @param lastOnline Last Online Date ISO8601
 */


data class UsersSearchAllOfData (

    /* MyAnimeList URL */
    @SerializedName("url")
    val url: String? = null,

    /* MyAnimeList Username */
    @SerializedName("username")
    val username: String? = null,

    @SerializedName("images")
    val images: UserImages? = null,

    /* Last Online Date ISO8601 */
    @SerializedName("last_online")
    val lastOnline: String? = null

)

