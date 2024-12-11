package com.example.demo.controller;


import com.example.demo.Implemento.AddImplement;
import com.example.demo.Implemento.GeneradorCod;
import com.example.demo.Implemento.ProductoAdminImplento;
import com.example.demo.Implemento.ProductoImplemento;
import com.example.demo.clases.productos.CategoriaProducto;
import com.example.demo.clases.productos.Producto;
import com.example.demo.clases.usuarios.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/administrador")
public class AdministradorControlador {
    DecimalFormat df = new DecimalFormat("#.##");
    GeneradorCod cod = new GeneradorCod();
    @Autowired
    private ProductoAdminImplento productoAdminImplento;

    @Autowired
    private ProductoImplemento productoImplemento;

    @Autowired
    private AddImplement addImplement;

    @GetMapping("/productos")
    public String productosAdmin(Model model) {
        ArrayList<Producto> lista = productoAdminImplento.listaProducto();
        model.addAttribute("listaProducto", lista);
        model.addAttribute("cantPr", lista.size());
        ArrayList<Estado> listaEstado = addImplement.listaEstado();
        model.addAttribute("listaEstado", listaEstado);
        ArrayList<CategoriaProducto> CategoriaProducto = addImplement.listaCategoria();
        model.addAttribute("CategoriaProducto", CategoriaProducto);
        return "/administrador/productos";
    }
    @GetMapping("/editar/producto/{id_producto}")
    public String editarProducto(@PathVariable String id_producto, Model model) {
        Producto producto = productoImplemento.buscarProducto(id_producto);
        ArrayList<CategoriaProducto> cat =  addImplement.listaCategoria();
        model.addAttribute("cat", cat);
        model.addAttribute("producto", producto);
        return "administrador/editarProducto";
    }

    @PostMapping("/guardar/producto")
    public String guardarEditarProducto(@RequestParam String id_producto, @RequestParam String nombre_producto,
            @RequestParam String descripcion, @RequestParam int cantidad, @RequestParam float precio,
            @RequestParam int id_categoria, @RequestParam String url, @RequestParam int id_estado) {
        try {
            BigDecimal bigDecimal = new BigDecimal(precio).setScale(2, RoundingMode.HALF_UP);
            double formattedPrecio = bigDecimal.doubleValue();
            Producto producto = new Producto();
            producto.setId_producto(id_producto);
            producto.setNombre_producto(nombre_producto);
            producto.setDescripcion(descripcion);
            producto.setCantidad_stock(cantidad);
            producto.setPrecio_unidad(formattedPrecio);
            producto.setId_categoria(id_categoria);
            producto.setImg_url(url);
            producto.setId_estado(id_estado);
            productoAdminImplento.saveProducto(producto);
            return "redirect:/administrador/productos";
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();
            return "error"; // Redirige a una página de error
        }
    }

    @PostMapping("/registrar/producto")
    public String registrarProducto(@RequestParam String nombre_producto,
            @RequestParam String descripcion, @RequestParam int cantidad, @RequestParam float precio,
            @RequestParam int id_categoria, @RequestParam String url, @RequestParam int id_estado) {
        try {
        BigDecimal bigDecimal = new BigDecimal(precio).setScale(2, RoundingMode.HALF_UP);
        double formattedPrecio = bigDecimal.doubleValue();

            Producto producto = new Producto();
            producto.setId_producto(cod.codProductos());
            producto.setNombre_producto(nombre_producto);
            producto.setDescripcion(descripcion);
            producto.setCantidad_stock(cantidad);
            producto.setPrecio_unidad(formattedPrecio);
            producto.setId_categoria(id_categoria);
            producto.setImg_url(url);
            producto.setId_estado(id_estado);
            productoAdminImplento.saveProducto(producto);
            return "redirect:/administrador/productos";
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();
            return "error"; // Redirige a una página de error
        }
    }
    @GetMapping("/eliminar/producto/{id_producto}")
    public String getMethodName(@PathVariable String id_producto) {
        productoAdminImplento.eliminarProducto(id_producto);
        return  "redirect:/administrador/productos";
    }

    @GetMapping("/categoria/producto")
    public String cat(Model model) {
        ArrayList<CategoriaProducto> categoria = addImplement.listaCategoria();
        model.addAttribute("categoria", categoria);
        return "/administrador/CategoriasProducto";
    }

    @PostMapping("/agregar/categoria")
    public String postMethodName(@RequestParam String categoria) {

        addImplement.agregarCategoria(categoria);
        return "redirect:/administrador/categoria/producto";
    }
    @GetMapping("/eliminar/categoria/producto/{id_categoria}")
    public String cat(Model model, @PathVariable("id_categoria") int id_categoria) {
        addImplement.eliminarCategoria(id_categoria);
        return "redirect:/administrador/categoria/producto";
    }

}
