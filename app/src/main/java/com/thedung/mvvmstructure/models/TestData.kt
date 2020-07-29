package com.thedung.mvvmstructure.models

import com.google.gson.annotations.SerializedName

data class TestData (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: Int
)