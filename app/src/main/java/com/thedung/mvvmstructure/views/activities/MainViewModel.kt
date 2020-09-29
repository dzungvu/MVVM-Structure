package com.thedung.mvvmstructure.views.activities

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.thedung.mvvmstructure.bases.BaseModel
import com.thedung.mvvmstructure.services.repositories.CharacterRepository
import com.thedung.mvvmstructure.services.repositories.MainRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MainViewModel @ViewModelInject constructor(repository: CharacterRepository) : BaseModel() {
    private val mCharacterData = MutableLiveData<Any>()
    val characterData = Transformations.switchMap(mCharacterData) {
        repository.getAllCharacters().asLiveData(viewModelScope.coroutineContext)
    }

    fun triggerCharacterContent() {
        mCharacterData.postValue(null)
    }
}