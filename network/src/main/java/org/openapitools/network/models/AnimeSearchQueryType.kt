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
 * Available Anime types
 *
 * Values: tv,movie,ova,special,ona,music,cm,pv,tv_special
 */

enum class AnimeSearchQueryType(val value: kotlin.String) {

    @SerializedName(value = "tv")
    tv("tv"),

    @SerializedName(value = "movie")
    movie("movie"),

    @SerializedName(value = "ova")
    ova("ova"),

    @SerializedName(value = "special")
    special("special"),

    @SerializedName(value = "ona")
    ona("ona"),

    @SerializedName(value = "music")
    music("music"),

    @SerializedName(value = "cm")
    cm("cm"),

    @SerializedName(value = "pv")
    pv("pv"),

    @SerializedName(value = "tv_special")
    tv_special("tv_special");

    /**
     * Override [toString()] to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): kotlin.String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is AnimeSearchQueryType) "$data" else null

        /**
         * Returns a valid [AnimeSearchQueryType] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): AnimeSearchQueryType? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

