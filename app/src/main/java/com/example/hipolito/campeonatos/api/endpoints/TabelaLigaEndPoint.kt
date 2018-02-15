package com.example.hipolito.campeonatos.api.endpoints

import retrofit2.Call
import com.example.hipolito.campeonatos.models.TabelaLigaAPIModel
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by hipolito on 12/02/18.
 */
interface TabelaLigaEndPoint {

    @GET("v1/competitions/{id}/leagueTable")
    fun getTabelaLiga(@Path("id") id: Int): Call<TabelaLigaAPIModel>

}