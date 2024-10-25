package org.example

import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence

object EntityManagerFactory {
    val emf = Persistence.createEntityManagerFactory("unidadMYSQL2")
    fun createManager(): EntityManager {
        return emf.createEntityManager()
    }
}