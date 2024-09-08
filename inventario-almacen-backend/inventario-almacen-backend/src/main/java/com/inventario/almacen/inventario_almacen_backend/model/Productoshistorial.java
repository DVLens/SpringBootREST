package com.inventario.almacen.inventario_almacen_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "productoshistorial")
public class Productoshistorial {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDProducto", nullable = false)
    private Producto iDProducto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDUsuario", nullable = false)
    private Usuario iDUsuario;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Codigo", nullable = false)
    private String codigo;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Precio", nullable = false, precision = 10)
    private BigDecimal precio;

    @Column(name = "FechaCreacion", nullable = false)
    private Instant fechaCreacion;

    @Column(name = "FechaModificacion", nullable = false)
    private Instant fechaModificacion;

    @Column(name = "Estado")
    private Integer estado;

}