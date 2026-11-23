import { useParams } from "react-router-dom";
import AdminNavbar from "../components/organisms/AdminNavbar";
import BotonVolverCatalogo from "../components/atoms/BotonVolverCatologo";
import "../pages/Admin.css";

async function DetalleMod(){
    interface Serv{
        id:number;
        categoria:string;
        nombre:string;
        precio:number;
        imagen:string;
    }
    interface Med{
        id:number;
        categoria:string;
        nombre:string;
        precio:number;
        cantidad:number;
        imagen:string;
    }
    const {id} = useParams();
    const respuesta1=await fetch(`http://localhost:9090/catalogo/servicios`)
    const respuesta2=await fetch(`http://localhost:9090/catalogo/medicamentos`)
    const servicios:Serv[] =await respuesta1.json()
    const medicamentos:Med[]=await respuesta2.json()
    // Primero busca entre los servicios, si no esta busca entre los medicamentos
    let producto = servicios.find(
        servicio => servicio.id.toString() === id
    );
    if (!producto){
        producto = medicamentos.find(
            medicamento => medicamento.id.toString() === id
        );
    }

    if (!producto){
        return(
            <div className="admin-layout">
                <AdminNavbar/>
                <div className="container py-5 text-center">
                    <div className="admin-panel">
                        <h2>No se encontró el producto.</h2>
                        <p>Por favor, vuelve al catálogo y selecciona un servicio o medicamento.</p>
                        <BotonVolverCatalogo ruta="/modificaciones"/>
                    </div>
                </div>
            </div>
        );
    }

    return(
        <div className="admin-layout">
            <AdminNavbar/>
            <div className="container py-5">
                <div className="admin-hero mb-4">
                    <h1>Detalle del producto</h1>
                    <p>{producto.categoria} · Código {producto.id}</p>
                </div>
                <div className="row justify-content-center">
                    <div className="col-md-8 col-lg-6">
                        <div className="admin-panel text-center">
                            <img
                                src={producto.imagen}
                                alt={producto.nombre}
                                className="img-fluid rounded mb-3"
                                style={{maxHeight:"280px", objectFit:"cover"}}
                            />
                            <h2 className="mb-2">{producto.nombre}</h2>
                            <p className="fs-3 fw-bold mb-2" style={{color:"#33553A"}}>${producto.precio}</p>
                            <button
                                className="admin-btn me-2"
                                onClick={() => alert("No hay base de datos")}
                            >
                                Editar
                            </button>
                            <BotonVolverCatalogo ruta="/modificaciones"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default DetalleMod;
