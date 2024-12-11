package com.example.demo.servicio;

import com.example.demo.clases.productos.Producto;

import java.util.ArrayList;



public interface ProductoAdminService {
    ArrayList<Producto> listaProducto();
    boolean saveProducto (Producto producto);
//    Producto buscarProducto(String id_producto);
    boolean eliminarProducto (String id_producto);

}
