package com.Proyecto_Ecommerce.tienda.service;

import com.Proyecto_Ecommerce.tienda.model.ProductoModel;
import com.Proyecto_Ecommerce.tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // 1. CONSULTA (READ)
    public List<ProductoModel> listarProductos() {
        return productoRepository.findAll();
    }

    // 2. CREACIÓN (CREATE)
    public ProductoModel guardarProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    // 3. ACTUALIZACIÓN (UPDATE)
    public ProductoModel actualizarProducto(Integer id, ProductoModel datos) {
        // Busca el producto en MySQL por su ID; si no existe, lanza un error controlado
        ProductoModel existente = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        // Actualizar los datos del producto encontrado con los valores nuevos
        existente.setNombre(datos.getNombre());
        existente.setPrecio(datos.getPrecio());
        existente.setColor(datos.getColor());
        existente.setTallas(datos.getTallas());
        existente.setTallasDisp(datos.getTallasDisp());
        existente.setSku(datos.getSku());
        existente.setFit(datos.getFit());
        existente.setGsm(datos.getGsm());
        existente.setBadge(datos.getBadge());
        existente.setBadgeClass(datos.getBadgeClass());
        existente.setImg(datos.getImg());
        existente.setAlt(datos.getAlt());

        if (datos.getCategoria() != null) {
            existente.setCategoria(datos.getCategoria());
        }

        // Guardar los cambios actualizados en MySQL
        return productoRepository.save(existente);
    }

    // 4. ELIMINACIÓN DELETE
    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}