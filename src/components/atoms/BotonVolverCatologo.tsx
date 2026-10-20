import { Link } from "react-router-dom";


//Boton de detalle para volver al Catalogo

interface BotonVolverProps{
    ruta:string;
}

function BotonVolverCatalogo({ ruta }: BotonVolverProps){
    return(
        <Link
            to={ruta}
            className='btn btn-primary'
        >
            Volver 
        </Link>
    )
}

export default BotonVolverCatalogo;

