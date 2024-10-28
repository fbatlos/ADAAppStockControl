package org.example

import org.example.ControlerService.MenuService
import org.example.ControlerService.ProductoService
import org.example.ControlerService.ProveedorService
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

    val userDao = UsuarioRepository()
    val productoDao = ProductoRepository()
    val proveedorDao = ProveedorRepository()

    val usuarioService = UsuarioService(userDao)
    val productoService = ProductoService(productoDao)
    val proveedorService = ProveedorService(proveedorDao)

    val proveedor = Proveedor(nombre = "Pasta SA", direccion = "A.V Risqueto", productos = null)
    em.transaction.begin()
    em.persist(proveedor)
    em.persist(Proveedor(nombre = "Lorca SA", direccion = "A.V Risqueto", productos = null))
    em.persist(Producto("ALUMATTEC","Material","Aluminio","Aluminio bro",12f,13.4f, Date(),47,proveedor))
    em.persist(Usuario("paco","123"))

    em.transaction.commit()
    em.close()

    val menu = MenuService(consola,usuarioService,productoService,proveedorService).Menu()
    consola.Escribir(menu)




}