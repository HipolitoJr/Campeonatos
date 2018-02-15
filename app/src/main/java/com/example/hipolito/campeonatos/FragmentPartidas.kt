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
class FragmentPartidas(var idLiga: Int): Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_partidas, container, false)
    }


}