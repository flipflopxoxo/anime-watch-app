package com.clydelizardo.animeonWatch.data.common

import retrofit2.Response

suspend fun <A, B> convertResponseToResult(
    requestCall: suspend () -> Response<A>,
    mapOutput: (A?) -> B
): Result<B> {
    return try {
        val response = requestCall()
        if (response.isSuccessful) {
            return Result.success(mapOutput(response.body()))
        } else {
            Result.failure(Exception())
        }
    } catch (e: Exception) {
        return Result.failure(e)
    }
}