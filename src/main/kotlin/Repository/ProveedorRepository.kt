package org.example.Repository

import jakarta.persistence.EntityManager
import org.example.Entity.Producto
import org.example.Entity.Proveedor

class ProveedorRepository(val em: EntityManager) {

    fun GetProveedores() : List<Proveedor> {
        try {
            val query = "FROM Proveedor "
            val proveedorFromBD = em.createQuery(query, Proveedor::class.java).resultList
            return proveedorFromBD

        }catch (e : Exception) {
            println(e.message)
            return listOf()
        }
    }
}