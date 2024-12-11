package com.example.demo.Implemento;

import com.example.demo.clases.productos.CategoriaProducto;
import com.example.demo.clases.usuarios.Estado;
import com.example.demo.repositorio.CategoriaRepository;
import com.example.demo.repositorio.EstadoRepository;
import com.example.demo.servicio.Adicional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AddImplement implements Adicional {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public ArrayList<Estado> listaEstado() {
        ArrayList<Estado> lista = (ArrayList<Estado>) estadoRepository.findAll();
        return lista;
    }

    @Override
    public ArrayList<CategoriaProducto> listaCategoria() {
        ArrayList<CategoriaProducto> lista = (ArrayList<CategoriaProducto>) categoriaRepository.findAll();
        return lista;
    }

    @Override
    public boolean agregarCategoria(String categoria) {
        CategoriaProducto cat = new CategoriaProducto();
        cat.setNombre_categoria(categoria);
        categoriaRepository.save(cat);
        return true;
    }

    @Override
    public boolean eliminarCategoria(int id_categoria) {
        categoriaRepository.deleteById(id_categoria);
       return true;
    }

    

}
