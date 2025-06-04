package com.example.json_serializer.json_provider

interface JsonProvider {
    fun provide(fileName: String): String
}