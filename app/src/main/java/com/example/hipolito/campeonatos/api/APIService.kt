package com.example.hipolito.campeonatos.api

import com.example.hipolito.campeonatos.api.endpoints.CompeticoesEndPoint
import com.example.hipolito.campeonatos.api.endpoints.PartidaEndPoint
import com.example.hipolito.campeonatos.api.endpoints.TabelaLigaEndPoint
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by hipolito on 11/02/18.
 */
class APIService{

    public val BASE_URL = "http://api.football-data.org/"

    var retrofit: Retrofit? = null
    var interceptorFootballAPI: InterceptorFootballAPI? = null

    var competicoesEndPoint: CompeticoesEndPoint? = null
    var tabelaLigaEndPoint: TabelaLigaEndPoint? = null
    var partidaEndPoint: PartidaEndPoint? = null

    constructor(TOKEN: String){

        interceptorFootballAPI = InterceptorFootballAPI(TOKEN)

        val builderCliente = OkHttpClient.Builder()
        builderCliente.addInterceptor(interceptorFootballAPI)
        val cliente = builderCliente.build()

        val builderRetrofit = Retrofit.Builder()
        retrofit = builderRetrofit
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(cliente)
                .build()

        competicoesEndPoint = retrofit!!.create(CompeticoesEndPoint::class.java)
        tabelaLigaEndPoint = retrofit!!.create(TabelaLigaEndPoint::class.java)
        partidaEndPoint = retrofit!!.create(PartidaEndPoint::class.java)
    }
}