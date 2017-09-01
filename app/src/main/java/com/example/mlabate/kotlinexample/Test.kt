package com.example.mlabate.kotlinexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_test.*

class Test : AppCompatActivity() {

    var tincho = Woloxer("Martin", "Javier", "Labate", Woloxer.Sector.DEVELOPMENT)
    var juani = Woloxer("Juan", "Ignacio", "Molina", Woloxer.Sector.DEVELOPMENT)
    var capi = Woloxer("capi", null, "capi", Woloxer.Sector.OTHER)
    var shizus = Woloxer("shizus", null, "shizus", Woloxer.Sector.OTHER, false)

    var woloxers = ArrayList<Woloxer?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val ghost: Woloxer? = null
        with(woloxers) {
            add(tincho)
            add(juani)
            add(capi)
            add(shizus)
            add(ghost)
        }

        filrar_woloxres.setOnClickListener {
            filtrarWoloxers()
        }

        mostrar_woloxres.setOnClickListener{
            mostrarWoloxers()
        }

    }

    fun mostrarWoloxers() {
        var strWoloxers = ""

        woloxers.forEach {
            it?.let {
                var segundoNombre = it.segundoNombre ?:" no tiene"
                Log.d("Woloxers", it.nombre + " " + segundoNombre + " " +it.apellido)
                strWoloxers += it.nombre + " " + segundoNombre + " " +it.apellido + "\n"
            }
        }
        lista_woloxers.text = strWoloxers
    }

    fun filtrarWoloxers() {
        val filteredWoloxers = woloxers.filterNotNull()
        var strWoloxers: String = ""

        filteredWoloxers.forEach {
            Log.d("filteredWoloxers", it.nombre + " " +it.apellido)
            strWoloxers += it.toString() + "\n"
        }

        lista_woloxers_filtrados.text = strWoloxers
    }


    fun filtrarWoloxrers2() {
        var filtrarWoloxers = ArrayList<Woloxer>()

        woloxers.forEach {
            it?.let {
                var tieneSegundoNombre = if (it.segundoNombre.isNullOrBlank()) {
                                            null
                                        } else {
                                            it
                                        }
                tieneSegundoNombre?.let {
                    filtrarWoloxers.add(it)
                }
            }
        }
        var strWoloxers = ""
        filtrarWoloxers.forEach {
            strWoloxers = it.nombre + "\n"
        }
        lista_woloxers_filtrados2.text = strWoloxers
    }

}
