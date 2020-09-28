package com.thedung.mvvmstructure.services.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class DataResponse<DATA>(
    val result: Int, // 1 -> success
    val data: DATA?
)

@Parcelize
open class Error(
    val result: String?,
    val code: String?,
    val message: String?
) : Parcelable {
    fun getErrorCode(): Int {
        return try {
            code?.toInt() ?: 0
        } catch (ex: Exception) {
            ex.printStackTrace()
            0
        }
    }
}
