package com.inventario.almacen.inventario_almacen_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Codigo", nullable = false)
    private String codigo;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Precio", nullable = false, precision = 10)
    private BigDecimal precio;

    @Column(name = "FechaCreacion", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Instant fechaCreacion;

    @Column(name = "Estado")
    private Integer estado;

    @OneToMany(mappedBy = "iDProducto")
    private Set<Movimiento> movimientos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "iDProducto")
    private Set<Productoshistorial> productoshistorials = new LinkedHashSet<>();

    @PrePersist
    protected void onCreate() {
        fechaCreacion = Instant.now();
    }
}