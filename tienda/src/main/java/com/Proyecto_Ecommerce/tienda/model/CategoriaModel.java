package com.Proyecto_Ecommerce.tienda.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "categorias")
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;

    private String nombre;

    private String descripcion;
}
