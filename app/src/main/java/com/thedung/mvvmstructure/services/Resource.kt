package com.thedung.mvvmstructure.services

class Resource<out T>(
    val status: Status,
    val data: T? = null,
    val errorMessage: String? = null,
    val errorCode: String? = ""
) {
    companion object {
        fun <T> Success(data: T? = null): Resource<T> {
            return Resource(Status.SUCCESS, data)
        }

        fun <T> Error(errorMessage: String? = "", errorCode: String? = ""): Resource<T> {
            return Resource(Status.FAILED, errorMessage = errorMessage, errorCode = errorCode)
        }

        fun <T> Loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data)
        }
    }
}

enum class Status {
    LOADING,
    SUCCESS,
    FAILED
}