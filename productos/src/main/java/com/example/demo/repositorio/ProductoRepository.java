package com.example.demo.repositorio;

import com.example.demo.clases.productos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository  extends JpaRepository<Producto, String>{
}
