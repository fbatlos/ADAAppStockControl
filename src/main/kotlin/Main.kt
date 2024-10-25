package org.example

import org.example.ControlerService.UsuarioService
import org.example.Entity.Usuario
import org.example.Repository.ProductoRepository
import org.example.Repository.ProveedorRepository
import org.example.Repository.UsuarioRepository
import org.example.Utils.Consola


fun main() {
    //Cambiar el object porque es necesario que solo sea un factory
    val em = EntityManagerFactory.createManager()
    val consola = Consola()

    val userDao = UsuarioRepository(em)
    val productoDao = ProductoRepository(em)
    val proveedorDao = ProveedorRepository(em)

    val usuarioService = UsuarioService(userDao)

    if (usuarioService.ComprobarUsuario("paco","12345")){
        consola.Escribir("Gooood")
    }

    em.close()

}