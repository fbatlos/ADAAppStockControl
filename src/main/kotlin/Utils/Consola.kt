package org.example.Utils

class Consola():IConsola {

    override fun Leer(): String {
        return readln()
    }

    override fun Escribir(texto: String, saltoLinea: Boolean) {
        if (saltoLinea){
            println(texto)
        }else{
            print(texto)
        }
    }
}