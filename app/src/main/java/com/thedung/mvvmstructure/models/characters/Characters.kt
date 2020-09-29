package com.thedung.mvvmstructure.models.characters

import com.thedung.mvvmstructure.models.Url
import com.thedung.mvvmstructure.models.UrlResponse


data class CharacterItem(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharacterItemResult>
)

data class CharacterItemResult(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: CharacterItemResultThumbnail,
    val resourceURI: String,
    val comics: CharacterItemResultGeneral,
    val series: CharacterItemResultGeneral,
    val stories: CharacterItemResultGeneral,
    val events: CharacterItemResultGeneral,
    val urlResponses: List<Url>
)

//regionThumbnail
data class CharacterItemResultThumbnail(
    val path: String,
    val extension: String
)
//endregion

//regionGeneral
data class CharacterItemResultGeneral(
    val available: Int,
    val collectionURI: String,
    val items: List<CharacterItemResultGeneralItem>,
    val returned: Int
)

data class CharacterItemResultGeneralItem(
    val resourceURI: String,
    val name: String
)