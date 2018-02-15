package com.example.hipolito.campeonatos.adapters

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hipolito.campeonatos.R
import com.example.hipolito.campeonatos.models.PartidaModel
import kotlinx.android.synthetic.main.item_lista_partidas.view.*
import java.util.*

/**
 * Created by hipolito on 15/02/18.
 */
class PartidasRVAdapter(
        var context: Activity,
        var partidas: MutableList<PartidaModel>
    ): RecyclerView.Adapter<PartidasRVAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var contexto = parent!!.context
        var inflater = LayoutInflater.from(contexto)
        val view = inflater.inflate(R.layout.item_lista_partidas, parent, false)
        var viewHolder = ViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        var partida = partidas.get(position)

        //val dataPartida = Calendar.getInstance(TimeZone.getTimeZone(partida.data))

        holder!!.itemView.txtItemPartidasData.setText(partida.data)
        holder!!.itemView.txtItemPartidasTimeCasa.setText(partida.timeCasa)
        holder!!.itemView.txtItemPartidasGolsCasa.setText(""+ partida.resultado.golsTimeCasa)
        holder!!.itemView.txtItemPartidasTimeFora.setText(partida.timeFora)
        holder!!.itemView.txtItemPartidasGolsFora.setText(""+ partida.resultado.golsTimeFora)

    }

    override fun getItemCount(): Int {
        return partidas.size
    }
}