package com.example.hipolito.campeonatos.models

import com.google.gson.annotations.SerializedName

/**
 * Created by hipolito on 12/02/18.
 */
class EquipeAPIModel(
        @SerializedName("position") var posicao: Int,
        @SerializedName("teamName") var nome: String,
        @SerializedName("points") var pontos: Int,
        @SerializedName("wins") var vitorias: Int,
        @SerializedName("draws") var empates: Int,
        @SerializedName("losses") var derrotas: Int,
        @SerializedName("crestURI") var escudo: String){


}