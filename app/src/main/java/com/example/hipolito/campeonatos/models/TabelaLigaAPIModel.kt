package com.example.hipolito.campeonatos.models

import com.google.gson.annotations.SerializedName

/**
 * Created by hipolito on 12/02/18.
 */
class TabelaLigaAPIModel(
        @SerializedName("leagueCaption") var nome: String,
        @SerializedName("standing") var tabela: MutableList<EquipeAPIModel>){

    override fun toString(): String {
        return nome
    }
}