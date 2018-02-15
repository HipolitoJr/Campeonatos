package com.example.hipolito.campeonatos.models

import com.example.hipolito.campeonatos.FragmentPartidas
import com.google.gson.annotations.SerializedName

/**
 * Created by hipolito on 15/02/18.
 */
class PartidaAPIModel(
        @SerializedName("fixtures") var partidas: MutableList<PartidaModel>){

}