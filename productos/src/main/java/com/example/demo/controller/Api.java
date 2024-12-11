package com.example.demo.controller;

import com.example.demo.Implemento.AddImplement;
import com.example.demo.Implemento.ProductoAdminImplento;
import com.example.demo.Implemento.ProductoImplemento;
import com.example.demo.clases.productos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class Api {

    @Autowired
    private ProductoAdminImplento productoAdminImplento;

    @Autowired
    private ProductoImplemento productoImplemento;

    @Autowired
    private AddImplement addImplement;

    @GetMapping("/productos")
    public ArrayList<Producto> productos(Model model) {
        ArrayList<Producto> listaProductos = productoImplemento.listarProducto();
        return listaProductos;
    }

    @GetMapping("/eliminar/producto/{id_producto}")
    public boolean eliminarProducto(@PathVariable String id_producto) {
        boolean res = productoAdminImplento.eliminarProducto(id_producto);
        if (true) {
            return true;
        } else {
            return false;
        }

    }
}
