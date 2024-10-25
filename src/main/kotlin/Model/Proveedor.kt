package org.example.Entity

import jakarta.persistence.*

@Entity
@Table(name = "Proveedores")
open class Proveedor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    val nombre: String,

    @Column
    val direccion: String,

    @OneToMany(mappedBy = "proveedor")
    val productos: List<Producto>? = null
)