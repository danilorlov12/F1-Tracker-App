package com.example.json_serializer.serialization

import com.google.gson.Gson
import java.lang.reflect.Type

class SerializationImpl : Serialization {
    override fun toJson(source: Any): String = Gson().toJson(source)
    override fun <T> fromJson(json: String, clazz: Class<T>): T = Gson().fromJson(json, clazz)
    override fun <T> fromJson(json: String, type: Type): T = Gson().fromJson(json, type)
}