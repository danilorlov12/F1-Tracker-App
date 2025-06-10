package com.example.countries

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryResourceProviderImpl @Inject constructor() : CountryResourceProvider {

    override fun countryFlagResByName(name: String) = when (name) {
        "bhr" -> R.mipmap.bhr
        "sau" -> R.mipmap.sau
        "aus" -> R.mipmap.aus
        "chn" -> R.mipmap.chn
        "jap" -> R.mipmap.jap
        "usa" -> R.mipmap.usa
        "are" -> R.mipmap.are
        "aut" -> R.mipmap.aut
        "aze" -> R.mipmap.aze
        "bel" -> R.mipmap.bel
        "bra" -> R.mipmap.bra
        "can" -> R.mipmap.can
        "esp" -> R.mipmap.esp
        "gbr" -> R.mipmap.gbr
        "hun" -> R.mipmap.hun
        "ita" -> R.mipmap.ita
        "mco" -> R.mipmap.mco
        "mex" -> R.mipmap.mex
        "nld" -> R.mipmap.nld
        "qat" -> R.mipmap.qat
        "sgp" -> R.mipmap.sgp
        else -> 0
    }
}