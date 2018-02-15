package com.example.hipolito.campeonatos.api.endpoints

import com.example.hipolito.campeonatos.models.PartidaAPIModel
import com.example.hipolito.campeonatos.models.PartidaModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by hipolito on 15/02/18.
 */
interface PartidaEndPoint {

    @GET("v1/competitions/{id}/fixtures")
    fun getPartida(@Path("id") id: Int): Call<PartidaAPIModel>

}