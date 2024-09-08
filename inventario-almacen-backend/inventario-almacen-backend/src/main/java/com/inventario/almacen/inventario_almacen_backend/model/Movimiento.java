package com.inventario.almacen.inventario_almacen_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCatalogoMovimiento", nullable = false)
    private Catalogomovimiento iDCatalogoMovimiento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDUbicacion", nullable = false)
    private Ubicacione iDUbicacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDProducto", nullable = false)
    private Producto iDProducto;

    @Column(name = "Cantidad", nullable = false, precision = 10)
    private BigDecimal cantidad;

    @Column(name = "Stock", nullable = false, precision = 10)
    private BigDecimal stock;

    @Column(name = "Estado")
    private Integer estado;

}