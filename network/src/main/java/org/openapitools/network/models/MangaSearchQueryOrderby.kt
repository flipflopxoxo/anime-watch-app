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
 * Available Manga order_by properties
 *
 * Values: mal_id,title,start_date,end_date,chapters,volumes,score,scored_by,rank,popularity,members,favorites
 */

enum class MangaSearchQueryOrderby(val value: String) {

    @SerializedName(value = "mal_id")
    MAL_ID("mal_id"),

    @SerializedName(value = "title")
    TITLE("title"),

    @SerializedName(value = "start_date")
    START_DATE("start_date"),

    @SerializedName(value = "end_date")
    END_DATE("end_date"),

    @SerializedName(value = "chapters")
    CHAPTERS("chapters"),

    @SerializedName(value = "volumes")
    VOLUMES("volumes"),

    @SerializedName(value = "score")
    SCORE("score"),

    @SerializedName(value = "scored_by")
    SCORED_BY("scored_by"),

    @SerializedName(value = "rank")
    RANK("rank"),

    @SerializedName(value = "popularity")
    POPULARITY("popularity"),

    @SerializedName(value = "members")
    MEMBERS("members"),

    @SerializedName(value = "favorites")
    FAVORITES("favorites");

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
        fun encode(data: Any?): String? = if (data is MangaSearchQueryOrderby) "$data" else null

        /**
         * Returns a valid [MangaSearchQueryOrderby] for [data], null otherwise.
         */
        fun decode(data: Any?): MangaSearchQueryOrderby? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

