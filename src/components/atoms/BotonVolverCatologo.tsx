import { Link } from "react-router-dom";
import "../../pages/principal.css";

//Boton de detalle para volver al Catalogo

interface BotonVolverProps{
    ruta:string;
}

function BotonVolverCatalogo({ ruta }: BotonVolverProps){
    return(
        <Link
            to={ruta}
            className='boton-opcion2'
        >
            Volver 
        </Link>
    )
}

export default BotonVolverCatalogo;

