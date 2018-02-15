package com.example.hipolito.campeonatos.models

import com.google.gson.annotations.SerializedName

/**
 * Created by hipolito on 14/02/18.
 */
class PartidaModel(
        @SerializedName("homeTeamName") var timeCasa: String,
        @SerializedName("awayTeamName") var timeFora: String,
        @SerializedName("status") var status: String,
        @SerializedName("date") var data: String,
        @SerializedName("result") var resultado: ResultadoPartidaAPIModel){

}