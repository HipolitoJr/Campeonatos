package com.example.hipolito.campeonatos

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hipolito.campeonatos.adapters.PartidasRVAdapter
import com.example.hipolito.campeonatos.adapters.TabelaLigaRVAdapter
import com.example.hipolito.campeonatos.api.APIService
import com.example.hipolito.campeonatos.models.EquipeAPIModel
import com.example.hipolito.campeonatos.models.PartidaAPIModel
import com.example.hipolito.campeonatos.models.PartidaModel
import com.example.hipolito.campeonatos.models.TabelaLigaAPIModel
import kotlinx.android.synthetic.main.activity_ligas.*
import kotlinx.android.synthetic.main.fragment_partidas.*
import kotlinx.android.synthetic.main.fragment_tabela.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("ValidFragment")
/**
 * Created by hipolito on 13/02/18.
 */
class FragmentPartidas(var idLiga: Int): Fragment(){

    var apiService: APIService? = null
    var partidas: MutableList<PartidaModel>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setupViews()
        return inflater!!.inflate(R.layout.fragment_partidas, container, false)
    }

    private fun setupViews() {
        apiService = APIService("")
        getPartidas()
    }

    private fun getPartidas() {

        val partida = apiService!!.partidaEndPoint!!.getPartida(idLiga)

        partida.enqueue(object: Callback<PartidaAPIModel>{
            override fun onFailure(call: Call<PartidaAPIModel>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<PartidaAPIModel>?, response: Response<PartidaAPIModel>?) {
                if (response!!.isSuccessful){
                    partidas = response.body().partidas
                    setPartidas()
                }
            }

        })

    }

    private fun setPartidas() {
        /*for (partida in partidas!!)
            if (partida.status == "TIMED")
                partidas!!.remove(partida)*/

        val partidasRVAdapter = PartidasRVAdapter(context as Activity, partidas!!)
        rvListaPartidas.adapter = partidasRVAdapter

        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        linearLayoutManager.scrollToPosition(0)

        rvListaPartidas.setHasFixedSize(true)
        rvListaPartidas.layoutManager = linearLayoutManager

    }


}