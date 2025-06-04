package com.example.json_serializer

import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> fromJsonAsset(jsonProvider: JsonProvider, serialization: Serialization, assetName: String): T {
    val string = jsonProvider.provide(assetName)
    val type = object : TypeToken<T>() {}.type
    return serialization.fromJson(string, type)
}

inline fun <reified T> String.fromJson(): List<T> {
    val type = object : TypeToken<List<T>>() {}.type
    return Gson().fromJson(this, type)
}

inline fun <reified T> String.fromJsonDataClass(): T {
    val type = object : TypeToken<T>() {}.type
    return Gson().fromJson(this, type)
}