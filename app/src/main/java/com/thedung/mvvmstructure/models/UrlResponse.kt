package com.thedung.mvvmstructure.models

import com.google.gson.annotations.SerializedName

data class UrlResponse(
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)

data class Url(
    val type: String,
    val url: String
)

fun UrlResponse?.toUrl(): Url {
    return Url(type = this?.type ?: "", url = this?.url ?: "")
}

fun List<UrlResponse>?.toListUrl(): List<Url> {
    val arr = arrayListOf<Url>()
    this?.let {
        for (item in it) {
            arr.add(item.toUrl())
        }
    }

    return arr
}