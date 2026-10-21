import { useParams } from "react-router-dom";
import AdminNavbar from "../components/organisms/AdminNavbar";
import BotonVolverCatalogo from "../components/atoms/BotonVolverCatologo";
import { servicios } from "../data/servicios";
import { medicamentos } from "../data/Medicamentos";
import "../pages/Admin.css";

function DetalleMod(){
    const {id} = useParams();

    // Primero busca entre los servicios, si no esta busca entre los medicamentos
    let producto = servicios.find(
        servicio => servicio.id === id
    );
    if (!producto){
        producto = medicamentos.find(
            medicamento => medicamento.id === id
        );
    }

    if (!producto){
        return(
            <>
            <header>
                <AdminNavbar/>
            </header>
            <div className="container my-5 text-center">
                <h2>No se encontró el producto.</h2>
                <p>Por favor, vuelve al catálogo y selecciona un servicio o medicamento.</p>
                <BotonVolverCatalogo ruta="/modificaciones"/>
            </div>
            </>
        );
    }

    return(
        <>
        <header>
            <AdminNavbar/>
        </header>
        <div className="container my-5">
            <h1 className="text-center mb-4">Detalle del Servicio</h1>
            <div className="row justify-content-center">
                <div className="col-md-6 col-lg-5">
                    <div className="caja-info text-center shadow-sm">
                        <img
                            src={producto.imagen}
                            alt={producto.titulo}
                            className="img-fluid rounded mb-3"
                            style={{maxHeight:"250px", objectFit:"cover"}}
                        />
                        <h2 className="mb-2">{producto.titulo}</h2>
                        <p className="fs-4 fw-bold mb-2">Precio: ${producto.precio}</p>
                        <p className="text-muted mb-4">{producto.descripcion}</p>
                        <button
                            className="btn btn-secondary me-2"
                            onClick={() => alert("No hay base de datos")}
                        >
                            Editar
                        </button>
                        <BotonVolverCatalogo ruta="/modificaciones"/>
                    </div>
                </div>
            </div>
        </div>
        </>
    );
}

export default DetalleMod;