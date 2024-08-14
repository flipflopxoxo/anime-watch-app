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
 * Date Prop
 *
 * @param from 
 * @param to 
 * @param string Raw parsed string
 */


data class DaterangeProp (

    @SerializedName("from")
    val from: DaterangePropFrom? = null,

    @SerializedName("to")
    val to: DaterangePropTo? = null,

    /* Raw parsed string */
    @SerializedName("string")
    val string: kotlin.String? = null

)

