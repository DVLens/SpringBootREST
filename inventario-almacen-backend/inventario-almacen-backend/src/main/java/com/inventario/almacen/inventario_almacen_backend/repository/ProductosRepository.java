package com.inventario.almacen.inventario_almacen_backend.repository;

import com.inventario.almacen.inventario_almacen_backend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Producto,Long> {
}
