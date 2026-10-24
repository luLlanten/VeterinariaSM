import { Link } from "react-router-dom";

interface BotonProps{
    id: string;
    ruta:string;
}

//Boton para Catalogo que llevara al detalle

function BotonCatalogo ({id, ruta}: BotonProps){
    return(
        <Link
            to={ruta + id}
            className="btn btn-primary"
        >
            Ver Producto

        </Link>
    );
}

export default BotonCatalogo;