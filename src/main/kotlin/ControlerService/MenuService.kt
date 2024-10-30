package org.example.ControlerService

import org.example.Entity.Producto
import org.example.Entity.Proveedor
import org.example.Utils.Consola
import java.util.*

class MenuService(
    val consola: Consola,
    val usuarioService: UsuarioService,
    val productoService: ProductoService,
    val proveedorService: ProveedorService
) {
    fun Menu(): String {
        var log = false

        while (!log){
            log = login()
        }

        while (true) {
            consola.Escribir("\n--- Gestión de Productos y Proveedores ---")
            consola.Escribir("1. Alta Producto")
            consola.Escribir("2. Baja Producto")
            consola.Escribir("3. Modificar Nombre Producto")
            consola.Escribir("4. Modificar Stock Producto")
            consola.Escribir("5. Obtener Producto")
            consola.Escribir("6. Obtener Productos con Stock")
            consola.Escribir("7. Obtener Productos sin Stock")
            consola.Escribir("8. Obtener Proveedor de un Producto")
            consola.Escribir("9. Obtener Todos los Proveedores")
            consola.Escribir("0. Salir")
            consola.Escribir("Seleccione una opción: ")

            when (readLine()?.toIntOrNull()) {
                1 -> {
                    val proveedor = proveedorService.AltaProveedor()
                    productoService.AltaProducto(proveedor)
                }
                2 -> consola.Escribir(productoService.BajaProducto())

                3 -> consola.Escribir(productoService.UpdateNombreProducto())

                4 -> consola.Escribir(productoService.UpdateStockProducto())

                5 -> consola.Escribir(productoService.GetProducto())

                6 -> getProductosConStock()

                7 -> getProductosSinStock()

                8 -> consola.Escribir(productoService.GetProveedorDeProducto())

                9 -> getTodosProveedores()

                0 -> return "Cerrado"
                else -> consola.Escribir("Opción no válida, por favor intente de nuevo.")
            }
        }

    }

    fun getProductosConStock() {
        val productosConStock = productoService.GetProductosConStock()

        if (productosConStock.isEmpty()) {
            consola.Escribir("No se ha encontrado ningun producto.")
        }else{
            productosConStock.forEach { producto -> consola.Escribir("${producto.nombre}  descripción : ${producto.descripcion} , precio : ${producto.precio_con_iva}")}
        }
    }

    fun getProductosSinStock() {
        val productosSinStock = productoService.GetProductosSinStock()

        if (productosSinStock.isEmpty()) {
            consola.Escribir("No se ha encontrado ningun producto.")
        }else{
            productosSinStock.forEach { producto -> consola.Escribir("${producto.nombre}  descripción : ${producto.descripcion} , precio : ${producto.precio_con_iva}")}
        }
    }

    fun getTodosProveedores() {
        val proveedores = proveedorService.GetProveedores()

        if (proveedores.isNotEmpty()) {
            proveedores.forEach { proveedor -> consola.Escribir("${proveedor.nombre} con direccion : ${proveedor.direccion} e id : ${proveedor.id}")}
        } else {
            println("No hay proveedores registrados.")
        }
    }

    fun login():Boolean {
        consola.Escribir("Ingrese nombre de usuario o ID: ")
        val userInput = consola.Leer()
        consola.Escribir("Ingrese contraseña: ")
        val passInput = consola.Leer()

        val log = usuarioService.ComprobarUsuario(userInput, passInput)

        return log
    }
}