package com.inventario.almacen.inventario_almacen_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "usuarioslog")
public class Usuarioslog {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDUsuario", nullable = false)
    private Usuario iDUsuario;

    @Column(name = "FechaRegistro")
    private Instant fechaRegistro;

    @Column(name = "Estado")
    private Integer estado;

}