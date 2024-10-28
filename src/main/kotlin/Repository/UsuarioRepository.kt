package org.example.Repository

import jakarta.persistence.EntityManager
import org.example.Entity.Usuario
import org.example.EntityManagerFactory

class UsuarioRepository(val em: EntityManager) {


    fun getUsuario(nombre_PosibleUSuario: String) :Usuario? {
        try {
            val usuarioFromBD = em.find(Usuario::class.java, nombre_PosibleUSuario)
            return usuarioFromBD

        }catch (e : Exception) {
            println(e.message)
            return null
        }finally {
            em.close()
        }
    }


}