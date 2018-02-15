package com.example.hipolito.campeonatos.models

import com.example.hipolito.campeonatos.R
import com.google.gson.annotations.SerializedName

/**
 * Created by hipolito on 11/02/18.
 */
class LigaAPIModel(
        @SerializedName("id") var id: Int,
        @SerializedName("caption") var nome: String){

    var logoLiga: Int = 0


    override fun toString(): String {
        return nome
    }

    fun setIconLiga(){

    }
}