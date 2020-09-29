package com.thedung.mvvmstructure.services.repositories

import com.thedung.mvvmstructure.classes.adapters.NetworkResponse
import com.thedung.mvvmstructure.models.characters.CharacterItem
import com.thedung.mvvmstructure.models.mappers.toCharacterItem
import com.thedung.mvvmstructure.services.CharacterServices
import com.thedung.mvvmstructure.services.Resource
import com.thedung.mvvmstructure.utils.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CharacterRepository @Inject constructor(private val characterServices: CharacterServices) {
    fun getAllCharacters() = flow<Resource<CharacterItem>> {
        val response = characterServices.getAllCharacters(
            "35a902600aab81e4e369faa17dfcc69a",
            "4705ec03b51834ca798fdbef23044cce",
            "1601278505"
        )
        when (response) {
            is NetworkResponse.Success -> {
                emit(Resource.Success(response.body.data.toCharacterItem()))
            }
            else -> throw response.toError()
        }
    }.onStart {
        emit(Resource.Loading())
    }.catch {
        it.printStackTrace()
        emit(Resource.Error(it.message))
    }.flowOn(Dispatchers.IO)
}