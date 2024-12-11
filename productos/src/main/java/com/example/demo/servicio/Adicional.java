package com.example.demo.servicio;

import com.example.demo.clases.productos.CategoriaProducto;
import com.example.demo.clases.usuarios.Estado;

import java.util.ArrayList;



public interface Adicional {
    ArrayList<Estado> listaEstado();
    ArrayList<CategoriaProducto> listaCategoria();
    boolean agregarCategoria(String categoria);
    boolean eliminarCategoria(int id_categoria);
}
