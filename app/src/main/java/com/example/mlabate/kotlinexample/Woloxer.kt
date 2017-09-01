package com.example.mlabate.kotlinexample

import java.io.Serializable


data class Woloxer(val nombre: String,
                   val segundoNombre: String?,
                   val apellido: String,
                   var sector: Sector,
                   var capi: Boolean = true): Serializable {
    enum class Sector {
        DEVELOPMENT, QA, OTHER
    }

}