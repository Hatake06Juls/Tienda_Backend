package com.Proyecto_Ecommerce.tienda.repository;

import com.Proyecto_Ecommerce.tienda.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Integer>{
    List<CategoriaModel> findByNombre(String texto);
}
