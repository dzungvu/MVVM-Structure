package com.thedung.mvvmstructure.models

import com.google.gson.annotations.SerializedName
import com.thedung.mvvmstructure.models.characters.CharacterItemResponse

data class DataResponse<DATA>(
    @SerializedName("code")
    val code: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("attributionText")
    val attributionText: String,
    @SerializedName("attributionHTML")
    val attributionHTML: String,
    @SerializedName("etag")
    val eTag: String,
    @SerializedName("data")
    val data: DATA?
)


open class Error(
    @SerializedName("code")
    val code: String?,
    @SerializedName("message")
    val message: String?
) {

    fun getErrorCode(): Int {
        return try {
            code?.toInt() ?: 0
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

}