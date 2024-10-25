package org.example.ControlerService

import org.example.Repository.UsuarioRepository

class UsuarioService (val usuarioRepository: UsuarioRepository){

    fun ComprobarUsuario(nombre:String, password:String): Boolean {
        val usuarioBD = usuarioRepository.getUsuario(nombre)

        if (usuarioBD != null && usuarioBD.password == password){
            return true
        }else return false

    }
}