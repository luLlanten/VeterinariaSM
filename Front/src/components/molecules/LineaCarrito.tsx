import BotonAccion from "../atoms/BotonAccion";

interface Props{
    id: string;
    titulo: string;
    precio: number;
    cantidad: number;
    imagen: string;
    alQuitar: (id: string) => void;
}


function LineaCarrito({id, titulo, precio, cantidad, imagen, alQuitar}: Props){
    return(
        <div className="d-flex align-items-center border-bottom py-3">
            <img
                src={imagen}
                alt={titulo}
                width="80"
                height="80"
                className="me-3 rounded"
                style={{objectFit:"cover"}}
            />
            <div className="flex-grow-1">
                <h5 className="mb-1">{titulo}</h5>
                <p className="mb-0">${precio} x {cantidad}</p>
            </div>
            <BotonAccion texto="Quitar" alHacerClick={() => alQuitar(id)}/>
        </div>
    );
}

export default LineaCarrito;