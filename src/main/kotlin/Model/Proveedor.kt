package org.example.Entity

import jakarta.persistence.*

@Entity
@Table(name = "Proveedores")
open class Proveedor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true,nullable = false, length = 50)
    val nombre: String,

    @Column(nullable = false)
    val direccion: String,

    @OneToMany(mappedBy = "proveedor")
    val productos: List<Producto>? = null
){
    constructor() : this(null, "", "", listOf())
}