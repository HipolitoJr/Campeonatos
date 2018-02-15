package com.example.hipolito.campeonatos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.hipolito.campeonatos.adapters.CampeonatosRVAdapter
import com.example.hipolito.campeonatos.api.APIService
import com.example.hipolito.campeonatos.models.LigaAPIModel
import kotlinx.android.synthetic.main.activity_ligas.*
import retrofit2.Response

class LigasActivity : AppCompatActivity() {

    var apiService: APIService? = null
    var listLigas: MutableList<LigaAPIModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ligas)
        setupViews()
    }
    override fun onResume() {
        super.onResume()
    }

    private fun setupViews() {
        apiService = APIService("")
        listLigas = ArrayList<LigaAPIModel>() as MutableList<LigaAPIModel>?

        getCompeticoes()
    }


    private fun getCompeticoes() {
        var call = apiService!!.competicoesEndPoint!!.getLigas()

        call.enqueue(object : retrofit2.Callback<MutableList<LigaAPIModel>> {
            override fun onFailure(call: retrofit2.Call<MutableList<LigaAPIModel>>?, t: Throwable?) {

            }

            override fun onResponse(call: retrofit2.Call<MutableList<LigaAPIModel>>?, response: Response<MutableList<LigaAPIModel>>?) {
                if (response!!.isSuccessful){
                    listLigas = response!!.body()
                    setIconsLigas()
                    setListaLigas()
                }
            }
        })
    }

    private fun setListaLigas() {

        val campeonatosRVAdapter = CampeonatosRVAdapter(this, this!!.listLigas!!)

        rvListaCampeonatos.adapter = campeonatosRVAdapter

        val gridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        rvListaCampeonatos.setHasFixedSize(true)
        rvListaCampeonatos.layoutManager = gridLayoutManager

    }

    private fun setIconsLigas() {
        for (liga in listLigas!!){
            when(liga.id){
                444 -> liga.logoLiga = R.drawable.icon_brasileirao
                445 -> liga.logoLiga = R.drawable.icon_ingles
                449 -> liga.logoLiga = R.drawable.icon_holandes
                450 -> liga.logoLiga = R.drawable.icon_frances_1
                451 -> liga.logoLiga = R.drawable.icon_frances_2
                452 -> liga.logoLiga = R.drawable.icon_alemao_1
                453 -> liga.logoLiga = R.drawable.icon_alemao_2
                455 -> liga.logoLiga = R.drawable.icon_espanhol
                456 -> liga.logoLiga = R.drawable.icon_italiano_1
                459 -> liga.logoLiga = R.drawable.icon_italiano_2
            }
        }
    }
}
