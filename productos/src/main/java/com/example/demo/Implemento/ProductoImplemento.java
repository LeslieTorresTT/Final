package com.example.demo.Implemento;

import com.example.demo.clases.productos.Producto;
import com.example.demo.repositorio.ProductoRepository;
import com.example.demo.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class ProductoImplemento  implements ProductoServicio {
    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public ArrayList<Producto> listarProducto() {
      ArrayList<Producto> lista =  (ArrayList<Producto>) productoRepository.findAll();
      return lista;
    }

    @Override
    public Producto buscarProducto(String id_producto) {
      Optional<Producto> productoOptional = productoRepository.findById(id_producto);
    
    if(productoOptional.isPresent()) {
        return productoOptional.get();
    } else {
        
        return null; 
    }
  }
}
