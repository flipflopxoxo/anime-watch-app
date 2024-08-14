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
 * @param character 
 * @param role Character's Role
 * @param voiceActors 
 */


data class AnimeCharactersDataInner (

    @SerializedName("character")
    val character: AnimeCharactersDataInnerCharacter? = null,

    /* Character's Role */
    @SerializedName("role")
    val role: kotlin.String? = null,

    @SerializedName("voice_actors")
    val voiceActors: kotlin.collections.List<AnimeCharactersDataInnerVoiceActorsInner>? = null

)

