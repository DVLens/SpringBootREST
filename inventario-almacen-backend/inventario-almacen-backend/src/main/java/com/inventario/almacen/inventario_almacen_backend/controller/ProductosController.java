package com.inventario.almacen.inventario_almacen_backend.controller;


import com.inventario.almacen.inventario_almacen_backend.exception.RecursoNoEncontrado;
import com.inventario.almacen.inventario_almacen_backend.model.Producto;
import com.inventario.almacen.inventario_almacen_backend.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

///
/// Controlador de Productos
///
@RestController
@RequestMapping("/api/v1")
public class ProductosController {
    @Autowired
    private ProductosRepository productosRepository;

    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return productosRepository.findAll();
    }

    @PostMapping("/productos")
    public Producto postProductos(@RequestBody Producto productos){
        productos.setFechaCreacion(Instant.now());
        productos.setEstado(1);
        return productosRepository.save(productos);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> getProductos(@PathVariable Long id){
        Producto productos = productosRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("El producto no fue encontrado."));
        return ResponseEntity.ok(productos);
    }
    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> postProductos(@PathVariable Long id, @RequestBody Producto productosRequest){
        Producto productos = productosRepository.findById(id)
        .orElseThrow(() -> new RecursoNoEncontrado("El producto no fue encontrado."));

        productos.setNombre(productosRequest.getNombre());
        productos.setCodigo(productosRequest.getCodigo());
        productos.setDescripcion(productosRequest.getDescripcion());
        productos.setPrecio(productosRequest.getPrecio());
        productos.setFechaCreacion(Instant.now());
        productos.setEstado(1);

        Producto productoActualizado = productosRepository.save(productos);
        return ResponseEntity.ok(productoActualizado);

    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteProducto(@PathVariable Long id) {
        Producto productos = productosRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("El producto no fue encontrado."));

        productosRepository.delete(productos);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
