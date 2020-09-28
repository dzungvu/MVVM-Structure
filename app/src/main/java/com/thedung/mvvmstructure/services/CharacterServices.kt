package com.thedung.mvvmstructure.services

import com.thedung.mvvmstructure.classes.adapters.RemoteResponse
import com.thedung.mvvmstructure.models.characters.CharacterItemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterServices {
    @GET("v1/public/characters")
    fun getAllCharacters(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") ts: String
    ): RemoteResponse<Response<CharacterItemResponse>>
}