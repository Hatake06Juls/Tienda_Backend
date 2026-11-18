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

    public CategoriaModel registrarCategoria(CategoriaModel cat) {
        return categoriaRepository.save(cat);
    }

    public CategoriaModel modificarCategoria(Integer id,CategoriaModel cat) {
        validarCategoria(cat);
        CategoriaModel actual = unaCategoria(id);
        actual.setNombre(cat.getNombre());
        actual.setDescripcion(cat.getDescripcion());

        return categoriaRepository.save(actual);
    }

    private void validarCategoria(CategoriaModel cat) {
        if (cat == null || cat.getNombre() == null
                || cat.getNombre().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El nombre de la categoría es obligatorio");
        }
        cat.setNombre(cat.getNombre().trim());
    }
}
