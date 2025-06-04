package com.example.json_serializer.json_provider

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JsonProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context
): JsonProvider {

    override fun provide(fileName: String): String {
        return context.assets.open(fileName).use {
            return@use it.readBytes().toString(Charsets.UTF_8)
        }
    }
}