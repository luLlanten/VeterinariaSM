import { Link, useNavigate } from "react-router-dom";
import type { MouseEvent } from "react";
import { esperarAgregado } from "../../data/carrito";

interface BotonProps{
    ruta: string;
    alAgregar: () => void | Promise<boolean>;
}



function BotonAgregarCarrito({ruta, alAgregar}: BotonProps){
    const navegar = useNavigate();

    const agregar = async (e: MouseEvent) => {
        e.preventDefault();
        alAgregar();
        const resultado = await esperarAgregado();
        if (resultado === false){
            return;
        }
        navegar(ruta);
    }

    return(
        <Link
            to={ruta}
            className="boton-opcion2"
            onClick={agregar}
        >
            Agregar al carrito
        </Link>
    );
}

export default BotonAgregarCarrito;