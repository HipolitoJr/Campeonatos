package com.example.hipolito.campeonatos.adapters

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.*
import android.widget.*
import com.example.hipolito.campeonatos.R
import android.support.constraint.R.id.parent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hipolito.campeonatos.models.LigasAPIModel
import kotlinx.android.synthetic.main.item_lista_ligas.view.*
import org.w3c.dom.Text

/**
 * Created by hipolito on 12/02/18.
 */
class CampeonatosRVAdapter(
        var context: Activity,
        var ligas: MutableList<LigasAPIModel>
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

        holder!!.itemView.txtItemLigaNome.setText(liga.nome)

    }

    override fun getItemCount(): Int {
        return ligas.size
    }
}