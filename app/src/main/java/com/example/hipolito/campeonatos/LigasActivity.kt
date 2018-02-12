package com.example.hipolito.campeonatos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Adapter
import android.widget.ArrayAdapter
import com.example.hipolito.campeonatos.adapters.CampeonatosRVAdapter
import com.example.hipolito.campeonatos.api.APIService
import com.example.hipolito.campeonatos.models.LigasAPIModel
import kotlinx.android.synthetic.main.activity_ligas.*
import retrofit2.Response

class LigasActivity : AppCompatActivity() {

    var apiService: APIService? = null
    var listLigas: MutableList<LigasAPIModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ligas)
        setupViews()
    }
    override fun onResume() {
        super.onResume()
        getCompeticoes()
    }

    private fun setupViews() {
        apiService = APIService("")
        listLigas = ArrayList<LigasAPIModel>()
    }


    private fun getCompeticoes() {
        var call = apiService!!.competicoesEndPoint!!.getLigas()

        call.enqueue(object : retrofit2.Callback<MutableList<LigasAPIModel>> {
            override fun onFailure(call: retrofit2.Call<MutableList<LigasAPIModel>>?, t: Throwable?) {

            }

            override fun onResponse(call: retrofit2.Call<MutableList<LigasAPIModel>>?, response: Response<MutableList<LigasAPIModel>>?) {
                listLigas = response!!.body()
                setListaLigas();
            }

        })

    }

    private fun setListaLigas() {

        val campeonatosRVAdapter = CampeonatosRVAdapter(this, this!!.listLigas!!)

        rvListaCampeonatos.adapter = campeonatosRVAdapter

        val gridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        rvListaCampeonatos.setHasFixedSize(true)
        rvListaCampeonatos.layoutManager = gridLayoutManager

        //var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listLigas)

    }


}
