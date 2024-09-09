///TODO: CENTRALIZAR LLAMADAS API
import axios from "axios";
const PRODUCTO_BASE_REST_API_URL = "http://localhost:8080/api/v1/productos";

class ProductosService{
    getAllProductos(){
        return axios.get(PRODUCTO_BASE_REST_API_URL);
    }
}

export default new ProductosService();