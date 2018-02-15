package com.example.hipolito.campeonatos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.hipolito.campeonatos.adapters.FragmentPATabela

import kotlinx.android.synthetic.main.activity_tabela.*
import kotlinx.android.synthetic.main.content_tabela.*

class TabelaActivity : AppCompatActivity() {

    var idLiga: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabela)
        setSupportActionBar(toolbar)
        setupViews()

    }

    private fun setupViews() {
        var titles: MutableList<String>? = ArrayList()
        titles!!.add("Tabela")
        titles!!.add("Partidas")

        val intent = intent
        idLiga = intent.getIntExtra("id", 0)

        viewPager.setAdapter(FragmentPATabela(supportFragmentManager, titles!!, idLiga, this))
        tabLayout.setupWithViewPager(viewPager)

    }

}
