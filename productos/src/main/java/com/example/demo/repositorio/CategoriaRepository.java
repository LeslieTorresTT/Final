package com.example.demo.repositorio;

import com.example.demo.clases.productos.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends JpaRepository<CategoriaProducto, Integer>{
    
}
