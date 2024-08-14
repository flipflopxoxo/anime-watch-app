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
 * @param lastVisiblePage 
 * @param hasNextPage 
 * @param items 
 */


data class PaginationPlusPagination (

    @SerializedName("last_visible_page")
    val lastVisiblePage: Int? = null,

    @SerializedName("has_next_page")
    val hasNextPage: Boolean? = null,

    @SerializedName("items")
    val items: PaginationPlusPaginationItems? = null

)

