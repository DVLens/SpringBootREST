import React, { useEffect, useState } from "react";
import ProductosService from "../services/ProductosService"

export const ProductosTableComponent = () => {
    const [productos, setProductos] = useState([]);

    useEffect(() => {
        ProductosService.getAllProductos().then(response => {
            setProductos(response.data);
            console.log(response.data);
        }).catch(error => {
            console.log(error);
        })
    }, []);

    return (
        <div className="container">
            <h2 className="text-center"> Lista de productos</h2>
            <table className="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Codigo</th>
                        <th>Descripcion</th>
                        <th>Precio</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        productos.map(producto => (
                            <tr key={producto.id}>
                                <td>{producto.id}</td>
                                <td>{producto.nombre}</td>
                                <td>{producto.codigo}</td>
                                <td>{producto.descripcion}</td>
                                <td>{producto.precio}</td>
                                <td>{producto.estado}</td>
                                <td>[Botones]</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ProductosTableComponent;
