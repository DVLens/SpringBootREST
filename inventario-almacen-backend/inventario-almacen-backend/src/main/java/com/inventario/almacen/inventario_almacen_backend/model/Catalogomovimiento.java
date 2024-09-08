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
@Table(name = "catalogomovimientos")
public class Catalogomovimiento {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "FechaCreacion", nullable = false)
    private Instant fechaCreacion;

    @Column(name = "Estado")
    private Integer estado;

    @OneToMany(mappedBy = "iDCatalogoMovimiento")
    private Set<Movimiento> movimientos = new LinkedHashSet<>();

}