import { useParams } from "react-router-dom";
import Navbar from "../components/organisms/Navbar";
import Footer from "../components/organisms/Footer";
import BotonVolverCatalogo from "../components/atoms/BotonVolverCatologo";
import { medicamentos } from "../data/Medicamentos";
import "../pages/Principal.css"
function DetalleMed(){
    const {id} = useParams();
    const medicamento = medicamentos.find(
        medicamento => medicamento.id === id
    );

    if (!medicamento){
        return(
            <>
            <Navbar/>
            <div className="container my-5 text-center">
                <h2>Medicamento no encontrado</h2>
                <BotonVolverCatalogo ruta="/medicamentos"/>
            </div>
            <Footer/>
            </>
        );
    }

    return(
        <>
        <Navbar/>
        <div className="container my-5">
            <h1 className="text-center mb-4">Detalle del medicamento</h1>
            <div className="row g-4 align-items-center">
                <div className="col-md-6">
                    <img
                        src={medicamento.imagen}
                        alt={medicamento.titulo}
                        className="rounded"
                        style={{maxWidth:"540px", maxHeight:"400px"}}
                    />
                </div>
                <div className="col-12 col-md-6 seccion-detalle">
                    <p className="mb-1">{medicamento.categoria}</p>
                    <h2>{medicamento.titulo}</h2>
                    <p>{medicamento.descripcion}</p>
                    <p className="fs-3 fw-bold">${medicamento.precio}</p>
                    <BotonVolverCatalogo ruta="/medicamentos"/>
                </div>
            </div>
        </div>
        <Footer/>
        </>
    );
}

export default DetalleMed;
