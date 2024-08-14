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
 * User's anime list status filter options
 *
 * Values: all,reading,completed,onhold,dropped,plantoread
 */

enum class UserMangaListStatusFilter(val value: String) {

    @SerializedName(value = "all")
    all("all"),

    @SerializedName(value = "reading")
    reading("reading"),

    @SerializedName(value = "completed")
    completed("completed"),

    @SerializedName(value = "onhold")
    onhold("onhold"),

    @SerializedName(value = "dropped")
    dropped("dropped"),

    @SerializedName(value = "plantoread")
    plantoread("plantoread");

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
        fun encode(data: Any?): String? = if (data is UserMangaListStatusFilter) "$data" else null

        /**
         * Returns a valid [UserMangaListStatusFilter] for [data], null otherwise.
         */
        fun decode(data: Any?): UserMangaListStatusFilter? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

