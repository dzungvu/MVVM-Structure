package com.thedung.mvvmstructure.classes.adapters

import com.thedung.mvvmstructure.models.Error
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import java.lang.reflect.Type

class NetworkResponseAdapter<SUCCESS : Any, ERROR : Error>(
    private val successType: Type,
    private val errorConverter: Converter<ResponseBody, ERROR>
) : CallAdapter<SUCCESS, Call<NetworkResponse<SUCCESS, ERROR>>> {
    override fun adapt(call: Call<SUCCESS>): Call<NetworkResponse<SUCCESS, ERROR>> {
        return NetworkCall(call, errorConverter)
    }

    override fun responseType(): Type = successType
}