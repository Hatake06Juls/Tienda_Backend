package com.Proyecto_Ecommerce.tienda.service;

import com.Proyecto_Ecommerce.tienda.model.CategoriaModel;
import com.Proyecto_Ecommerce.tienda.repository.CategoriaRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository c) {
        this.categoriaRepository = c;
    }

    public List<CategoriaModel> ListarCategorias() {
        return categoriaRepository.findAll();
    }

    public CategoriaModel unaCategoria(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada"));
    }
}
