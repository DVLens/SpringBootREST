package com.inventario.almacen.inventario_almacen_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ubicaciones")
public class Ubicacione {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDSector", nullable = false)
    private Sectore iDSector;

    @Column(name = "Seccion", nullable = false)
    private String seccion;

    @Column(name = "CodigoBarras", nullable = false)
    private String codigoBarras;

    @Column(name = "FechaCreacion", nullable = false)
    private Instant fechaCreacion;

    @Column(name = "Estado")
    private Integer estado;

    @OneToMany(mappedBy = "iDUbicacion")
    private Set<Movimiento> movimientos = new LinkedHashSet<>();

}