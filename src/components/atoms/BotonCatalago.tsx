import { Link } from "react-router-dom";

interface BotonProps{
    id: number;
}

//Boton para Catalogo que llevara al detalle

function BotonCatalogo ({id}: BotonProps){
    return(
        <Link
            to={"//"+id}
            className="btn btn-primary"
        >

        </Link>
    );
}

export default BotonCatalogo;