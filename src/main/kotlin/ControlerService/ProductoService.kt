package org.example.ControlerService

import org.example.Entity.Producto
import org.example.Entity.Proveedor
import org.example.Repository.ProductoRepository
import org.example.Utils.Consola
import java.util.*

class ProductoService(val productoDao: ProductoRepository,val consola: Consola) {

    fun AltaProducto(proveedor: Proveedor){
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
        val precioConIva = (precioSinIva + (precioSinIva * 0.21)).toFloat()
        val fechaProducto = Date()
        val idProducto = HacerID(nombreProducto,categoriaProducto,proveedor.nombre)

        val producto = Producto(idProducto,categoriaProducto,nombreProducto,descripcionProducto,precioSinIva,precioConIva,fechaProducto,stockProducto,proveedor)

        productoDao.AltaProducto(producto)
    }

    fun BajaProducto(): String{
        consola.Escribir("Ingrese ID del Producto a eliminar: ")
        val id = consola.Leer()

        return productoDao.BajaProducto(id)
    }

    fun  UpdateNombreProducto():String{
        consola.Escribir("Ingrese ID del Producto a modificar: ")
        val producto_id = consola.Leer()
        consola.Escribir("Ingrese el nuevo nombre: ")
        val nuevoNombre = consola.Leer()

        return productoDao.UpdateNombreProducto(producto_id,nuevoNombre)
    }

    fun UpdateStockProducto():String{
        consola.Escribir("Ingrese ID del Producto a modificar: ")
        val producto_id = consola.Leer()
        consola.Escribir("Ingrese el nuevo stock: ")
        val nuevoStock = consola.Leer().toIntOrNull() ?: 0

        return productoDao.UpdateStockProducto(producto_id,nuevoStock)
    }

    fun GetProducto(): String {
        consola.Escribir("Ingrese ID del Producto a obtener: ")
        val producto_id = consola.Leer()
        val producto = productoDao.GetProducto(producto_id)
        if (producto == null) {
            return ("No se ha encontrado el producto.")
        }else{
            return ("${producto.nombre}  descripción : ${producto.descripcion} , precio : ${producto.precio_con_iva}")
        }
    }

    fun GetProductosConStock():List<Producto>{
        return productoDao.GetProductosConStock()
    }

    fun GetProductosSinStock():List<Producto>{
        return productoDao.GetProductosSinStock()
    }

    fun GetProveedorDeProducto(): String {
        consola.Escribir("Ingrese ID del Producto para obtener su proveedor: ")
        val producto_id = consola.Leer()

        val proveedor = productoDao.GetProveedorDeProducto(producto_id)

        if (proveedor == null) {
            return ("No se ha encontrado ningun producto.")
        }else{
            return ("${proveedor.nombre} con direccion : ${proveedor.direccion} e id : ${proveedor.id}")
        }
    }

    fun HacerID(nombreProducto:String , categoria:String,nombreProveedor:String):String{
        var idProducto = ""
        val posibilidadesId = listOf(nombreProducto.trim(),categoria.trim(),nombreProveedor.trim())

        for (i in 0..2){
            for (j in 0..2){
                idProducto += posibilidadesId[i][j]
            }
        }

        idProducto = idProducto.toUpperCase()

        return idProducto
    }
}