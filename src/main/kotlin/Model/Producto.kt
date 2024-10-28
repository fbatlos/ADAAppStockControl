package org.example.Entity

import jakarta.persistence.*
import java.util.Date


@Entity
@Table(name = "productos")
class Producto(

    @Id
    val id:String,

    @Column
    val categoria:String,

    @Column
    var nombre:String,

    @Column
    val descripcion:String,

    @Column
    val precio_sin_iva:Float,

    @Column
    val precio_con_iva:Float,

    @Column
    val fecha_alta:Date,

    @Column
    var stock:Int,

    @ManyToOne
   // @JoinColumn(name = "id_proveedor")
    val proveedor:Proveedor
){

}
