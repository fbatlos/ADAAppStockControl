package org.example

import org.example.ControlerService.UsuarioService
import org.example.Entity.Producto
import org.example.Entity.Proveedor
import org.example.Entity.Usuario
import org.example.Repository.ProductoRepository
import org.example.Repository.ProveedorRepository
import org.example.Repository.UsuarioRepository
import org.example.Utils.Consola
import java.util.*


fun main() {
    //Cambiar el object porque es necesario que solo sea un factory
    val em = EntityManagerFactory.createManager()
    val consola = Consola()

    val userDao = UsuarioRepository(em)
    val productoDao = ProductoRepository(em)
    val proveedorDao = ProveedorRepository(em)

    val usuarioService = UsuarioService(userDao)
    val proveedor = Proveedor(nombre = "Pasta SA", direccion = "A.V Risqueto", productos = null)
    em.transaction.begin()
    em.persist(proveedor)
    em.persist(Proveedor(nombre = "Lorca SA", direccion = "A.V Risqueto", productos = null))

    em.transaction.commit()

    val proveedores = proveedorDao.GetProveedores()

    proveedores.forEach { consola.Escribir("${it.nombre} con id ${it.id}") }

    em.close()

}