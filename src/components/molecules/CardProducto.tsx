import BotonCatalogo from '../atoms/BotonCatalago'

interface CardProps{
    id: string;
    titulo: string;
    descripcion: string;
    precio: number;
    imagen: string;
    ruta: string;
}

function CardProducto({id,titulo,descripcion,precio,imagen,ruta}: CardProps){
    return(
        <div className='card h-100'>
            <img
                src={imagen}
                className="card-img-top"
                alt={titulo}
                style={{height:"200px",objectFit:"cover"}}
            />
            <div className="card-body d-flex flex-column">
                <h5 className="card-title">
                    {titulo}
                </h5>
                <p className="card-text">
                    {descripcion}
                </p>
                <p className="card-text">
                    ${precio}
                </p>
                <div className='mt-auto'>
                    <BotonCatalogo id={id} ruta={ruta}/>
                </div>
            </div>
        </div>
    )
}
export default CardProducto;