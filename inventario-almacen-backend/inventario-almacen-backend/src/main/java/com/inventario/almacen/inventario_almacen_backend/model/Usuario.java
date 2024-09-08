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
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Pasword", nullable = false)
    private String pasword;

    @Column(name = "FechaCreacion")
    private Instant fechaCreacion;

    @Column(name = "Estado")
    private Integer estado;

    @OneToMany(mappedBy = "iDUsuario")
    private Set<Productoshistorial> productoshistorials = new LinkedHashSet<>();

    @OneToMany(mappedBy = "iDUsuario")
    private Set<Usuarioslog> usuarioslogs = new LinkedHashSet<>();

}