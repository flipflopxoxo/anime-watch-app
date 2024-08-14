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
 * Available Manga types
 *
 * Values: manga,novel,lightnovel,oneshot,doujin,manhwa,manhua
 */

enum class MangaSearchQueryType(val value: String) {

    @SerializedName(value = "manga")
    manga("manga"),

    @SerializedName(value = "novel")
    novel("novel"),

    @SerializedName(value = "lightnovel")
    lightnovel("lightnovel"),

    @SerializedName(value = "oneshot")
    oneshot("oneshot"),

    @SerializedName(value = "doujin")
    doujin("doujin"),

    @SerializedName(value = "manhwa")
    manhwa("manhwa"),

    @SerializedName(value = "manhua")
    manhua("manhua");

    /**
     * Override [toString()] to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: Any?): String? = if (data is MangaSearchQueryType) "$data" else null

        /**
         * Returns a valid [MangaSearchQueryType] for [data], null otherwise.
         */
        fun decode(data: Any?): MangaSearchQueryType? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

