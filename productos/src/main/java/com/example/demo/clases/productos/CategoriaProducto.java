package com.example.demo.clases.productos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria_producto")
public class CategoriaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Asignación automática del valor del ID
    private int id_categoria;

    private String nombre_categoria;
}
