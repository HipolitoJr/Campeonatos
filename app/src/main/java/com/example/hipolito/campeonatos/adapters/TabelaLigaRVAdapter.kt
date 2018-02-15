package com.example.hipolito.campeonatos.adapters

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hipolito.campeonatos.R
import com.example.hipolito.campeonatos.models.EquipeAPIModel
import com.example.hipolito.campeonatos.models.LigaAPIModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_lista_tabela_liga.view.*

/**
 * Created by hipolito on 12/02/18.
 */
class TabelaLigaRVAdapter(
        var context: Activity,
        var equipes: MutableList<EquipeAPIModel>
): RecyclerView.Adapter<TabelaLigaRVAdapter.ViewHolder>(){


    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder{
        var contexto = parent!!.context
        var inflater = LayoutInflater.from(contexto)
        val view = inflater.inflate(R.layout.item_lista_tabela_liga, parent, false)
        var viewHolder = ViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        var equipe = equipes.get(position)

        holder!!.itemView.txtItemTabelaPos.setText(""+ equipe.posicao)
        holder!!.itemView.txtItemTabelaNome.setText(equipe.nome)
        holder!!.itemView.txtItemTabelaPts.setText(""+ equipe.pontos)
        holder!!.itemView.txtItemTabelaVitorias.setText(""+ equipe.vitorias)
        holder!!.itemView.txtItemTabelaEmpates.setText(""+ equipe.empates)
        holder!!.itemView.txtItemTabelaDerrotas.setText(""+ equipe.derrotas)

        if(!equipe.escudo.isNullOrEmpty() && !equipe.escudo.isNullOrBlank()) {
            Picasso.with(context)
                    .load(equipe!!.escudo)
                    .error(R.drawable.escudo_time)
                    .into(holder!!.itemView.ivItemTabelaEscudo)
        }
    }

    override fun getItemCount(): Int {
        return equipes.size
    }

}