package com.inventario.almacen.inventario_almacen_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class RecursoNoEncontrado extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public  RecursoNoEncontrado(String mensaje){
        super(mensaje);
    }
}
