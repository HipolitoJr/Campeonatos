package com.example.hipolito.campeonatos.adapters

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.hipolito.campeonatos.FragmentPartidas
import com.example.hipolito.campeonatos.FragmentTabela
import com.example.hipolito.campeonatos.TabelaActivity

/**
 * Created by hipolito on 13/02/18.
 */
class FragmentPATabela(
        fm: FragmentManager?,
        var titulos: MutableList<String>,
        var idLiga: Int,
        var activity: Activity) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return FragmentTabela(idLiga, activity)

            1 -> return FragmentPartidas(idLiga)

            else -> return null
        }
    }

    override fun getCount(): Int {
        return titulos.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titulos.get(position)
    }

}