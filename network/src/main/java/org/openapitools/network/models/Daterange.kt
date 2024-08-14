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
 * Date range
 *
 * @param from Date ISO8601
 * @param to Date ISO8601
 * @param prop 
 */


data class Daterange (

    /* Date ISO8601 */
    @SerializedName("from")
    val from: kotlin.String? = null,

    /* Date ISO8601 */
    @SerializedName("to")
    val to: kotlin.String? = null,

    @SerializedName("prop")
    val prop: DaterangeProp? = null

)

