package org.example

import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence

object EntityManagerFactory {

    fun createManager(persistenceUnitName:String): EntityManager {
        val emf = Persistence.createEntityManagerFactory(persistenceUnitName)
        return emf.createEntityManager()
    }
}