package com.example.hipolito.campeonatos.api.endpoints

import com.example.hipolito.campeonatos.models.LigaAPIModel
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by hipolito on 11/02/18.
 */
interface CompeticoesEndPoint {

    @GET("v1/competitions/")
    fun getLigas(): Call<MutableList<LigaAPIModel>>

}