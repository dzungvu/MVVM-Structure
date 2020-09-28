package com.thedung.mvvmstructure.models.characters

import com.google.gson.annotations.SerializedName
import com.thedung.mvvmstructure.models.Url

//data class CharactersResponse(
//    @SerializedName("code")
//    val code: Int,
//    @SerializedName("status")
//    val status: String,
//    @SerializedName("copyright")
//    val copyright: String,
//    @SerializedName("attributionText")
//    val attributionText: String,
//    @SerializedName("attributionHTML")
//    val attributionHTML: String,
//    @SerializedName("etag")
//    val eTag: String,
//    @SerializedName("data")
//    val data: CharacterItemResponse
//)

data class CharacterItemResponse(
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("results")
    val results: List<CharacterItemResultResponse>
)

data class CharacterItemResultResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("thumbnail")
    val thumbnail: CharacterItemResultThumbnailResponse,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("comics")
    val comics: CharacterItemResultGeneralResponse,
    @SerializedName("series")
    val series: CharacterItemResultGeneralResponse,
    @SerializedName("stories")
    val stories: CharacterItemResultGeneralResponse,
    @SerializedName("events")
    val events: CharacterItemResultGeneralResponse,
    @SerializedName("urls")
    val urls: List<Url>
)

//regionThumbnail
data class CharacterItemResultThumbnailResponse(
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val extension: String
)
//endregion

//regionGeneral
data class CharacterItemResultGeneralResponse(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<CharacterItemResultGeneralItemResponse>,
    @SerializedName("returned")
    val returned: Int
)

data class CharacterItemResultGeneralItemResponse(
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("name")
    val name: String
)
//endregion

