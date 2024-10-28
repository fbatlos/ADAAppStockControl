package org.example.ControlerService

import org.example.Entity.Proveedor
import org.example.Repository.ProveedorRepository

class ProveedorService(val proveedorDao: ProveedorRepository) {

    fun GetProveedores() : List<Proveedor>{
        return proveedorDao.GetProveedores()
    }

    fun AltaProveedor(proveedor: Proveedor): String{
        return proveedorDao.AltaProveedor(proveedor)
    }
}