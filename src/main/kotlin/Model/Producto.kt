package org.example.Entity

import jakarta.persistence.*
import java.util.Date


@Entity
@Table(name = "productos")
class Producto(

    @Id
    val id:String,

    @Column(nullable = false, length = 10)
    val categoria:String,

    @Column(nullable = false, length = 50)
    var nombre:String,

    @Column
    val descripcion:String,

    @Column(nullable = false)
    val precio_sin_iva:Float,

    @Column(nullable = false)
    val precio_con_iva:Float,

    @Column(nullable = false)
    val fecha_alta:Date,

    @Column(nullable = false)
    var stock:Int,

    @ManyToOne
    val proveedor:Proveedor?
){
    constructor() : this("","","","",0f,0f,Date(),0,null)
}
