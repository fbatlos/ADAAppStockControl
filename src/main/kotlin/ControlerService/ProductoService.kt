package org.example.ControlerService

import org.example.Entity.Producto
import org.example.Entity.Proveedor
import org.example.Repository.ProductoRepository

class ProductoService(val productoDao: ProductoRepository) {

    fun AltaProducto(producto: Producto): String{
        return productoDao.AltaProducto(producto)
    }

    fun BajaProducto(producto_id: String): String{
        return productoDao.BajaProducto(producto_id)
    }

    fun  UpdateNombreProducto(producto_id: String , nuevoNombre:String):String{
        return productoDao.UpdateNombreProducto(producto_id,nuevoNombre)
    }

    fun UpdateStockProducto(producto_id: String , nuevoStock:Int):String{
        return productoDao.UpdateStockProducto(producto_id,nuevoStock)
    }

    fun GetProducto(producto_id: String):Producto?{
        return productoDao.GetProducto(producto_id)
    }

    fun GetProductosConStock():List<Producto>{
        return productoDao.GetProductosConStock()
    }

    fun GetProductosSinStock():List<Producto>{
        return productoDao.GetProductosSinStock()
    }

    fun GetProveedorDeProducto(producto_id: String): Proveedor?{
        return productoDao.GetProveedorDeProducto(producto_id)
    }

    fun HacerID(nombreProducto:String , categoria:String,nombreProveedor:String):String{
        var idProducto = ""
        val posibilidadesId = listOf(nombreProducto,categoria,nombreProveedor)

        for (i in 0..2){
            for (j in 0..2){
                idProducto += posibilidadesId[i][j]
            }
        }

        idProducto = idProducto.toUpperCase()

        return idProducto
    }
}