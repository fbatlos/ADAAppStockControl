package org.example.Utils

interface IConsola {
    fun Leer(): String

    fun Escribir(texto:String, saltoLinea: Boolean = true)
}