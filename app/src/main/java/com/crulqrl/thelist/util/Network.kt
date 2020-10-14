package com.crulqrl.thelist.util

import com.crulqrl.thelist.data.api.Result


suspend fun <T : Any> safeApiCall(call: suspend () -> T): Result<T> {
    return try {
        Result.Success(call())
    } catch (e: Exception) {
        e.printStackTrace()
        return Result.Error(e)
    }
}