package org.example.Repository

import jakarta.persistence.EntityManager
import org.example.Entity.Usuario
import org.example.EntityManagerFactory

class UsuarioRepository() {


    fun getUsuario(nombre_PosibleUSuario: String) :Usuario? {
        val em: EntityManager = EntityManagerFactory.createManager()
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