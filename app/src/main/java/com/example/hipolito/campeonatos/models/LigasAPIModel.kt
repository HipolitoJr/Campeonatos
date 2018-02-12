package com.example.hipolito.campeonatos.models

import com.google.gson.annotations.SerializedName

/**
 * Created by hipolito on 11/02/18.
 */
class LigasAPIModel(
        @SerializedName("caption") var nome: String ){

    override fun toString(): String {
        return nome
    }
}