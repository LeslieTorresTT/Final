package com.example.demo.Implemento;

import com.example.demo.clases.productos.Producto;
import com.example.demo.repositorio.ProductoRepository;
import com.example.demo.servicio.ProductoAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductoAdminImplento  implements ProductoAdminService {


    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public ArrayList<Producto> listaProducto() {
        ArrayList<Producto> lista =(ArrayList<Producto>) productoRepository.findAll();
    return lista;
    }


    @Override
    public boolean saveProducto (Producto producto){
       
        try {
             productoRepository.save(producto);        
            return true;
        } catch (Exception e) {
            return false;
        }
       
    }

    @Override
    public boolean eliminarProducto(String id_producto) {
        productoRepository.deleteById(id_producto);
       return true;
    }
}
