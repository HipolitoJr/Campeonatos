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
import com.example.hipolito.campeonatos.adapters.TabelaLigaRVAdapter
import com.example.hipolito.campeonatos.api.APIService
import com.example.hipolito.campeonatos.models.EquipeAPIModel
import com.example.hipolito.campeonatos.models.TabelaLigaAPIModel
import kotlinx.android.synthetic.main.fragment_tabela.*
import retrofit2.Call
import retrofit2.Response

@SuppressLint("ValidFragment")
/**
 * Created by hipolito on 13/02/18.
 */
class FragmentTabela(var idLiga: Int, var activity: Activity): Fragment() {

    var apiService: APIService? = null
    var listTabelaLiga: MutableList<EquipeAPIModel>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setupViews()

        return inflater!!.inflate(R.layout.fragment_tabela, container, false)
    }

    private fun setupViews() {
        apiService = APIService("")
        getCampeonato()
    }


    private fun getCampeonato() {
        val tabelaLiga = apiService!!.tabelaLigaEndPoint!!.getTabelaLiga(idLiga)

        tabelaLiga.enqueue(object : retrofit2.Callback<TabelaLigaAPIModel> {
            override fun onFailure(call: Call<TabelaLigaAPIModel>?, t: Throwable?) {
                Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<TabelaLigaAPIModel>?, response: Response<TabelaLigaAPIModel>?) {
                if (response!!.isSuccessful){
                    listTabelaLiga = response.body().tabela
                    activity.title = response.body().nome
                    setTabelaLiga()
                }
            }
        })
    }

    private fun setTabelaLiga() {
        val tabelaLigaRVAdapter = TabelaLigaRVAdapter(context as Activity, this!!.listTabelaLiga!!)
        rvTabelaLiga.adapter = tabelaLigaRVAdapter

        val linearLayoutManager = LinearLayoutManager(context as Activity, LinearLayoutManager.VERTICAL, false)
        linearLayoutManager.scrollToPosition(0)

        rvTabelaLiga.setHasFixedSize(true)
        rvTabelaLiga.layoutManager = linearLayoutManager
    }
}