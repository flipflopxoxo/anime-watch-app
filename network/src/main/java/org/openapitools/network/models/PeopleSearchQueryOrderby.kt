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
 * Available People order_by properties
 *
 * Values: mal_id,name,birthday,favorites
 */

enum class PeopleSearchQueryOrderby(val value: String) {

    @SerializedName(value = "mal_id")
    MAL_ID("mal_id"),

    @SerializedName(value = "name")
    NAME("name"),

    @SerializedName(value = "birthday")
    BIRTHDAY("birthday"),

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
        fun encode(data: Any?): String? = if (data is PeopleSearchQueryOrderby) "$data" else null

        /**
         * Returns a valid [PeopleSearchQueryOrderby] for [data], null otherwise.
         */
        fun decode(data: Any?): PeopleSearchQueryOrderby? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

