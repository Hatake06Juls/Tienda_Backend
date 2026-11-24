package com.Proyecto_Ecommerce.tienda.repository;

import com.Proyecto_Ecommerce.tienda.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Integer> {
}