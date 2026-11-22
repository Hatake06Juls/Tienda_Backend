package com.Proyecto_Ecommerce.tienda.controller;

import com.Proyecto_Ecommerce.tienda.model.CategoriaModel;
import com.Proyecto_Ecommerce.tienda.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<CategoriaModel> listar() {
        return categoriaService.ListarCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaModel mostrarCategoria(@PathVariable("id") Integer id) {
        return categoriaService.unaCategoria(id);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public CategoriaModel registrar(@RequestBody CategoriaModel cat) {
        return categoriaService.registrarCategoria(cat);
    }
}
