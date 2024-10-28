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
                1 -> altaProducto()
                2 -> bajaProducto()
                3 -> modificarNombreProducto()
                4 -> modificarStockProducto()
                5 -> getProducto()
                6 -> getProductosConStock()
                7 -> getProductosSinStock()
                8 -> getProveedorProducto()
                9 -> getTodosProveedores()
                0 -> return "Cerrado"
                else -> println("Opción no válida, por favor intente de nuevo.")
            }
        }

    }

    fun altaProducto() {
        consola.Escribir("Ingrese Nombre del Producto: ")
        val nombreProducto = consola.Leer()
        consola.Escribir("Ingrese Categoria del Producto: ")
        val categoriaProducto = consola.Leer()
        consola.Escribir("Ingrese Precio sin IVA: ")
        val precioSinIva = consola.Leer().toFloatOrNull() ?: return
        consola.Escribir("Ingrese Descripción del Producto: ")
        val descripcionProducto = consola.Leer()
        consola.Escribir("Ingrese Stock del Producto: ")
        val stockProducto = consola.Leer().toIntOrNull() ?: return
        val precioConIva = (precioSinIva + precioSinIva * 0.21).toFloat()
        val fechaProducto = Date()

        consola.Escribir("Ingrese Nombre del Proveedor: ")
        val nombreProveedor = consola.Leer()
        consola.Escribir("Ingrese Dirección del Proveedor: ")
        val direccionProveedor = consola.Leer()

        val idProducto = productoService.HacerID(nombreProducto,categoriaProducto,nombreProveedor)

        val proveedor = Proveedor(nombre = nombreProveedor , direccion = direccionProveedor)

        proveedorService.AltaProveedor(proveedor)

        val producto = Producto(idProducto,categoriaProducto,nombreProducto,descripcionProducto,precioSinIva,precioConIva,fechaProducto,stockProducto,proveedor)

        productoService.AltaProducto(producto)
    }

    fun bajaProducto() {
        consola.Escribir("Ingrese ID del Producto a eliminar: ")
        val id = consola.Leer()

        val eliminado = productoService.BajaProducto(id)

        consola.Escribir(eliminado)
    }

    fun modificarNombreProducto() {
        consola.Escribir("Ingrese ID del Producto a modificar: ")
        val id = consola.Leer()
        consola.Escribir("Ingrese el nuevo nombre: ")
        val nuevoNombre = consola.Leer()
        val producto = productoService.UpdateNombreProducto(id,nuevoNombre)
        consola.Escribir(producto)
    }

    fun modificarStockProducto() {
        consola.Escribir("Ingrese ID del Producto a modificar: ")
        val id = consola.Leer()
        consola.Escribir("Ingrese el nuevo stock: ")
        val nuevoStock = consola.Leer().toIntOrNull() ?: return
        val producto = productoService.UpdateStockProducto(id,nuevoStock)
        consola.Escribir(producto)
    }

    fun getProducto() {
        consola.Escribir("Ingrese ID del Producto a obtener: ")
        val id = consola.Leer()
        val producto = productoService.GetProducto(id)
        if (producto == null) {
            consola.Escribir("No se ha encontrado el producto.")
        }else{
            consola.Escribir("${producto.nombre}  descripción : ${producto.descripcion} , precio : ${producto.precio_con_iva}")
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

    fun getProveedorProducto() {
        consola.Escribir("Ingrese ID del Producto para obtener su proveedor: ")
        val idProducto = consola.Leer()
        val proveedor = productoService.GetProveedorDeProducto(idProducto)
        if (proveedor == null) {
            consola.Escribir("No se ha encontrado ningun producto.")
        }else{
            consola.Escribir("${proveedor.nombre} con direccion : ${proveedor.direccion} e id : ${proveedor.id}")
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