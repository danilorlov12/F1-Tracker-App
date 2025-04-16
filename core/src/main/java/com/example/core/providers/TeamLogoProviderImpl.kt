package com.example.core.providers

import android.content.res.Resources
import com.example.core.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamLogoProviderImpl @Inject constructor(): TeamLogoProvider {

    override fun logoByTeamId(id: Int) = when (id) {
        0 -> R.mipmap.mclaren_logo
        1 -> R.mipmap.ferrari_logo
        2 -> R.mipmap.red_bull_logo
        3 -> R.mipmap.mercedes_logo
        4 -> R.mipmap.aston_martin_logo
        5 -> R.mipmap.alpine_logo
        6 -> R.mipmap.haas_logo
        7 -> R.mipmap.racing_bulls_logo
        8 -> R.mipmap.williams_logo
        9 -> R.mipmap.kick_sauber_logo
        else -> throw Resources.NotFoundException()
    }
}