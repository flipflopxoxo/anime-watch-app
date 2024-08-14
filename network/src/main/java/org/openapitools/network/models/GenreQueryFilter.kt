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
 * Filter genres by type
 *
 * Values: genres,explicit_genres,themes,demographics
 */

enum class GenreQueryFilter(val value: kotlin.String) {

    @SerializedName(value = "genres")
    genres("genres"),

    @SerializedName(value = "explicit_genres")
    explicit_genres("explicit_genres"),

    @SerializedName(value = "themes")
    themes("themes"),

    @SerializedName(value = "demographics")
    demographics("demographics");

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
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is GenreQueryFilter) "$data" else null

        /**
         * Returns a valid [GenreQueryFilter] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): GenreQueryFilter? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

