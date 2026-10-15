import { Link } from "react-router-dom";


//Boton de detalle para volver al Catalogo

function BotonVolverCatalogo(){
    return(
        <Link
            to={"/"}
            className='btn btn-primary'
        >
        </Link>
    )
}

export default BotonVolverCatalogo;