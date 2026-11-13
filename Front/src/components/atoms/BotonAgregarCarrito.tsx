import { Link } from "react-router-dom";

interface BotonProps{
    ruta: string;
    alAgregar: () => void;
}



function BotonAgregarCarrito({ruta, alAgregar}: BotonProps){
    return(
        <Link
            to={ruta}
            className="boton-opcion2"
            onClick={alAgregar}
        >
            Agregar al carrito
        </Link>
    );
}

export default BotonAgregarCarrito;