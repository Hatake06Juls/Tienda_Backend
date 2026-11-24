package com.Proyecto_Ecommerce.tienda.controller;

import com.Proyecto_Ecommerce.tienda.model.ProductoModel;
import com.Proyecto_Ecommerce.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // GET -> Consultar todos los productos
    @GetMapping
    public List<ProductoModel> obtenerTodos() {
        return productoService.listarProductos();
    }

    // POST -> Crear un nuevo producto
    @PostMapping
    public ProductoModel crear(@RequestBody ProductoModel producto) {
        return productoService.guardarProducto(producto);
    }

    // PUT -> Actualizar un producto existente por su ID
    @PutMapping("/{id}")
    public ProductoModel actualizar(@PathVariable Integer id, @RequestBody ProductoModel producto) {
        return productoService.actualizarProducto(id, producto);
    }

    // DELETE -> Eliminar un producto por su ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
    }
}