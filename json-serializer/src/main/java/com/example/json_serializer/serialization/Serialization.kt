package com.example.json_serializer.serialization

import java.lang.reflect.Type

interface Serialization {
    fun toJson(source: Any): String
    fun <T> fromJson(json: String, clazz: Class<T>): T
    fun <T> fromJson(json: String, type: Type): T
}