package com.Proyecto_Ecommerce.tienda.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id_producto;

    @Column(length = 225, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer precio;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaModel categoria;

    // Campos visuales adicionales para el frontend KULT Studio
    private String sku;
    private String fit;
    private String gsm;
    private String color;
    private String tallas;

    @Column(name = "tallas_disp")
    private String tallasDisp;

    private String badge;

    @Column(name = "badge_class")
    private String badgeClass;

    @Column(columnDefinition = "LONGTEXT")
    private String img;
    private String alt;
}