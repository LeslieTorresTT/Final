package com.example.demo.servicio;

import com.example.demo.clases.productos.Producto;

import java.util.ArrayList;



public interface ProductoServicio {
    ArrayList<Producto> listarProducto();
    Producto buscarProducto(String id_producto);
 
}
