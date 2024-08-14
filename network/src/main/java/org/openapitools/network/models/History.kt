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
 * Transform the resource into an array.
 *
 * @param entry 
 * @param increment Number of episodes/chapters watched/read
 * @param date Date ISO8601
 */


data class History (

    @SerializedName("entry")
    val entry: MalUrl? = null,

    /* Number of episodes/chapters watched/read */
    @SerializedName("increment")
    val increment: Int? = null,

    /* Date ISO8601 */
    @SerializedName("date")
    val date: String? = null

)

