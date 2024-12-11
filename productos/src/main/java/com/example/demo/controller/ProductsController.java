package com.example.demo.controller;

import com.example.demo.Implemento.AddImplement;
import com.example.demo.Implemento.ProductoImplemento;
import com.example.demo.clases.productos.CategoriaProducto;
import com.example.demo.clases.productos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ProductsController {

    @GetMapping("/")
    public String products(){
        return "web/index";
    }

    @Autowired
    private ProductoImplemento productoImplemento;

    @Autowired
    private AddImplement addImplement;

    @GetMapping("/productos")
    public String productos(Model model) {
        ArrayList<CategoriaProducto> cat = addImplement.listaCategoria();
        ArrayList<Producto> listaProductos = productoImplemento.listarProducto();
        model.addAttribute("cat", cat);
        model.addAttribute("listaProductos", listaProductos);
        return "/cliente/productos";
    }
}
