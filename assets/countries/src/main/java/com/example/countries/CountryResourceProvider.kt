package com.example.countries

interface CountryResourceProvider {
    fun countryFlagResByName(name: String): Int
}