package com.example.hipolito.campeonatos.adapters

import android.app.Activity
import android.content.Intent
import android.widget.*
import com.example.hipolito.campeonatos.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hipolito.campeonatos.TabelaActivity
import com.example.hipolito.campeonatos.models.LigaAPIModel
import kotlinx.android.synthetic.main.item_lista_ligas.view.*

/**
 * Created by hipolito on 12/02/18.
 */
class CampeonatosRVAdapter(
        var context: Activity,
        var ligas: MutableList<LigaAPIModel>
        ): RecyclerView.Adapter<CampeonatosRVAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var txtNomeLiga: TextView

        init {
            txtNomeLiga = itemView.findViewById<TextView>(R.id.txtItemLigaNome)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var contexto = parent!!.context
        var inflater = LayoutInflater.from(contexto)

        val view = inflater.inflate(R.layout.item_lista_ligas, parent, false)

        var viewHolder = ViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        var liga = ligas.get(position)

        holder!!.itemView.txtItemLigaNome.setText(liga.nome + " - " + liga.id)

        if (liga.logoLiga != 0)
            holder.itemView.ivItemLigaImagem.setImageResource(liga.logoLiga)
        else
            holder.itemView.ivItemLigaImagem.setImageResource(R.drawable.icon_liga)

        holder!!.itemView.setOnClickListener(View.OnClickListener {
            setupClick(liga, position)
        })

    }

    private fun setupClick(liga: LigaAPIModel, position: Int) {

        val intent = Intent(context, TabelaActivity::class.java)
        intent.putExtra("id", liga.id)
        context.startActivity(intent)

    }

    override fun getItemCount(): Int {
        return ligas.size
    }
}