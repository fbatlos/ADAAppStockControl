package org.example

import org.example.Entity.Producto
import org.example.Entity.Proveedor
import org.example.Entity.Usuario
import org.example.Repository.UsuarioRepository
import java.util.*

fun main() {
    //Cambiar el object porque es necesario que solo sea un factory
    val em = EntityManagerFactory.createManager("unidadMYSQL2")



    em.transaction.begin()
    val proveedor = Proveedor(nombre = "Papa S.A", direccion = "A.V Ansterdam")
    em.persist(proveedor)
    val producto1 = Producto("POPAPAL","Alimento","Cebolla","Usada para cocinar",12f,12f, Date(),2,proveedor)
    val producto2 = Producto("LAPORTA","Alimento","Apio","Usada para cocinar",12f,12f, Date(),1,proveedor)
    val usuario1 = Usuario("paco","12345")


    em.persist(producto1)
    em.persist(producto2)
    em.persist(usuario1)


    em.transaction.commit()




    val usuarioRepo = UsuarioRepository(em)
    val intentoUsuario = Usuario("paco","12345")
    println(usuarioRepo.comprobarUsuario(intentoUsuario))

    em.close()

}