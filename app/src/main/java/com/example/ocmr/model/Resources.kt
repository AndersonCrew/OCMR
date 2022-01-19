package com.example.ocmr.model

/**
 * Created by BM Anderson on 18/01/2022.
 */
sealed class Resources<T>(val data: T?, val message: String? ) {
    class Error<T>(message: String?): Resources<T>(null, message)
    class Success<T>(data: T): Resources<T>(data, "Success")
}