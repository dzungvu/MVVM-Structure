package com.thedung.mvvmstructure.models.mappers

import com.thedung.mvvmstructure.models.characters.*
import com.thedung.mvvmstructure.models.toListUrl

fun CharacterItemResponse?.toCharacterItem(): CharacterItem {
    return if (this == null) {
        CharacterItem(
            offset = 0,
            limit = 0,
            total = 0,
            count = 0,
            results = emptyList()
        )
    } else CharacterItem(
        offset = offset ?: 0,
        limit = limit ?: 0,
        total = total ?: 0,
        count = count ?: 0,
        results = results.toListCharacterItemResult()
    )
}

fun List<CharacterItemResultResponse>?.toListCharacterItemResult(): List<CharacterItemResult> {
    val arr = arrayListOf<CharacterItemResult>()
    this?.let {
        for (item in this) {
            arr.add(item.toCharacterItemResult())
        }
    }

    return arr
}

fun CharacterItemResultResponse.toCharacterItemResult(): CharacterItemResult {
    return CharacterItemResult(
        id = id ?: -1,
        name = name ?: "",
        description = description ?: "",
        modified = modified ?: "",
        thumbnail = thumbnail.toCharacterItemResultThumbnail(),
        resourceURI = resourceURI ?: "",
        comics = comics.toCharacterItemResultGeneral(),
        events = events.toCharacterItemResultGeneral(),
        series = series.toCharacterItemResultGeneral(),
        stories = stories.toCharacterItemResultGeneral(),
        urlResponses = urlResponses.toListUrl()
    )
}

fun CharacterItemResultThumbnailResponse?.toCharacterItemResultThumbnail(): CharacterItemResultThumbnail {
    return if (this == null) {
        return CharacterItemResultThumbnail(path = "", extension = "")
    } else {
        CharacterItemResultThumbnail(
            path = path ?: "",
            extension = extension ?: ""
        )
    }
}

fun List<CharacterItemResultGeneralItemResponse>.toListCharacterItemResultGeneralItem(): List<CharacterItemResultGeneralItem> {
    val arr = arrayListOf<CharacterItemResultGeneralItem>()
    for (item in this) {
        arr.add(item.toCharacterItemResultGeneralItem())
    }

    return arr
}

fun CharacterItemResultGeneralResponse?.toCharacterItemResultGeneral(): CharacterItemResultGeneral {
    return if (this == null) {
        return CharacterItemResultGeneral(
            available = 0,
            collectionURI = "",
            returned = 0,
            items = emptyList()
        )
    } else CharacterItemResultGeneral(
        available = available ?: 0,
        collectionURI = collectionURI ?: "",
        returned = returned ?: 0,
        items = items?.toListCharacterItemResultGeneralItem() ?: emptyList()
    )
}

fun CharacterItemResultGeneralItemResponse.toCharacterItemResultGeneralItem(): CharacterItemResultGeneralItem {
    return CharacterItemResultGeneralItem(
        resourceURI = resourceURI ?: "",
        name = name ?: ""
    )
}