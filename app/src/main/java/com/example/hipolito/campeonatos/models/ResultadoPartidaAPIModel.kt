package com.example.hipolito.campeonatos.models

import com.google.gson.annotations.SerializedName

/**
 * Created by hipolito on 14/02/18.
 */
class ResultadoPartidaAPIModel(
        @SerializedName("goalsHomeTeam") var golsTimeCasa: Int,
        @SerializedName("goalsAwayTeam") var golsTimeFora: Int){


}