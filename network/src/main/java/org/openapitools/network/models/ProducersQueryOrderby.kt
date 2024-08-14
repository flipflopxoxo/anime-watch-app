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
 * Producers Search Query Order By
 *
 * Values: mal_id,count,favorites,established
 */

enum class ProducersQueryOrderby(val value: String) {

    @SerializedName(value = "mal_id")
    MAL_ID("mal_id"),

    @SerializedName(value = "count")
    COUNT("count"),

    @SerializedName(value = "favorites")
    FAVORITES("favorites"),

    @SerializedName(value = "established")
    ESTABLISHED("established");

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
        fun encode(data: Any?): String? = if (data is ProducersQueryOrderby) "$data" else null

        /**
         * Returns a valid [ProducersQueryOrderby] for [data], null otherwise.
         */
        fun decode(data: Any?): ProducersQueryOrderby? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

