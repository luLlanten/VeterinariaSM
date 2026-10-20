import { useParams } from "react-router-dom";
import Navbar from "../components/organisms/Navbar";
import BotonVolverCatalogo from "../components/atoms/BotonVolverCatologo";
import { servicios } from "../data/servicios";
import Footer from "../components/organisms/Footer";

function Detalle(){
   const {id} = useParams();
    const servicio = servicios.find(
        servicio => servicio.id === id
    );

    if (!servicio){
        return(
            <>
            <Navbar/>
            <div className="container my-5 text-center">
                <h2>Servicio no encontrado</h2>
                <BotonVolverCatalogo ruta="/servicios"/>
            </div>
            <Footer/>
            </>
        );
    }

    return(
        <>
        <Navbar/>
        <div className="container my-5">
            <h1 className="text-center mb-4">Detalle del servicio</h1>
            <div className="row g-4 align-items-center">
                <div className="col-12 col-md-6">
                    <img
                        src={servicio.imagen}
                        alt={servicio.titulo}
                        className="img-fluid rounded"
                    />
                </div>
                <div className="col-12 col-md-6">
                    <p className="mb-1">{servicio.categoria}</p>
                    <h2>{servicio.titulo}</h2>
                    <p>{servicio.descripcion}</p>
                    <p className="fs-3 fw-bold">${servicio.precio}</p>
                    <BotonVolverCatalogo ruta="/servicios"/>
                </div>
            </div>
        </div>
        <Footer/>
        </>
    );
}

export default Detalle;