package com.Proyecto_Ecommerce.tienda.controller;

import com.Proyecto_Ecommerce.tienda.model.CategoriaModel;
import com.Proyecto_Ecommerce.tienda.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Listar todos
    @GetMapping
    public List<CategoriaModel> listar() {
        return categoriaService.ListarCategorias();
    }

    // Buscar por ID (Asegúrate de que tenga esta estructura exacta)
    @GetMapping("/{id}")
    public CategoriaModel mostrarCategoria(@PathVariable("id") Integer id) {
        return categoriaService.unaCategoria(id);
    }
}
