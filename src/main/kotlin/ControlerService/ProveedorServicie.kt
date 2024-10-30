package org.example.ControlerService

import org.example.Entity.Proveedor
import org.example.Repository.ProveedorRepository
import org.example.Utils.Consola

class ProveedorService(val proveedorDao: ProveedorRepository,val consola: Consola) {

    fun GetProveedores() : List<Proveedor>{
        return proveedorDao.GetProveedores()
    }

    fun AltaProveedor(): Proveedor{

        consola.Escribir("Ingrese Nombre del Proveedor: ")
        val nombreProveedor = consola.Leer()
        consola.Escribir("Ingrese Dirección del Proveedor: ")
        val direccionProveedor = consola.Leer()

        val proveedor = Proveedor(nombre = nombreProveedor , direccion = direccionProveedor)

        proveedorDao.AltaProveedor(proveedor)

        return proveedor
    }
}