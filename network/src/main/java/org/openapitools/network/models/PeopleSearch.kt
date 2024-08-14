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
 * People Search
 *
 * @param pagination 
 * @param `data` 
 */


data class PeopleSearch (

    @SerializedName("pagination")
    val pagination: PaginationPlusPagination? = null,

    @SerializedName("data")
    val `data`: List<PeopleSearchAllOfData>? = null

)

