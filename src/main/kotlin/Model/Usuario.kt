package org.example.Entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "Usuarios")
open class Usuario(

    @Id
    var nombre_user: String,

    @Column(nullable = false , length = 20)
    var password: String
){
    // Constructor sin argumentos
    constructor() : this("", "")
}