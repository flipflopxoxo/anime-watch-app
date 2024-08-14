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
 * @param username MyAnimeList Username
 * @param url MyAnimeList URL
 * @param images 
 * @param lastOnline Last Online Date ISO8601
 * @param gender User Gender
 * @param birthday Birthday Date ISO8601
 * @param location Location
 * @param joined Joined Date ISO8601
 */


data class UserProfile (

    /* MyAnimeList ID */
    @SerializedName("mal_id")
    val malId: kotlin.Int? = null,

    /* MyAnimeList Username */
    @SerializedName("username")
    val username: kotlin.String? = null,

    /* MyAnimeList URL */
    @SerializedName("url")
    val url: kotlin.String? = null,

    @SerializedName("images")
    val images: UserImages? = null,

    /* Last Online Date ISO8601 */
    @SerializedName("last_online")
    val lastOnline: kotlin.String? = null,

    /* User Gender */
    @SerializedName("gender")
    val gender: kotlin.String? = null,

    /* Birthday Date ISO8601 */
    @SerializedName("birthday")
    val birthday: kotlin.String? = null,

    /* Location */
    @SerializedName("location")
    val location: kotlin.String? = null,

    /* Joined Date ISO8601 */
    @SerializedName("joined")
    val joined: kotlin.String? = null

)

