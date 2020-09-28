package com.thedung.mvvmstructure.services.repositories

import com.thedung.mvvmstructure.models.characters.CharacterItemResponse
import com.thedung.mvvmstructure.services.CharacterServices
import com.thedung.mvvmstructure.services.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val characterServices: CharacterServices) {
    fun getAllCharacters() = flow<Resource<Response<CharacterItemResponse>>> {
        val response = characterServices.getAllCharacters("", "", "")
    }
}