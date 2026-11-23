import { useParams } from "react-router-dom";
import AdminNavbar from "../components/organisms/AdminNavbar";
import BotonVolverCatalogo from "../components/atoms/BotonVolverCatologo";
import "../pages/Admin.css";
import { useEffect, useState } from "react";
    interface Med{
        id:number;
        categoria:string;
        nombre:string;
        precio:number;
        cantidad:number;
        imagen:string;
    }
function DetalleModMed(){
    const [medicamento,setMedicamento]=useState<Med>()
    const [cargando, setCargando] = useState(true)
    const {id} = useParams();
    useEffect(()=>{
        const cargarProductos=async()=>{
            try{
            const respuesta1 = await fetch(`http://localhost:9090/catalogo/medicamentos/${id}`)
            if (!respuesta1.ok){
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
            const med=(await respuesta1.json()) as Med
            setMedicamento(med)
        }catch(error){
            console.error("Error al cargar producto",error)
            alert("Intente nuevamente")
        }finally{
            setCargando(false)
        }
    }
    cargarProductos()
})
    

    return(
        <div className="admin-layout">
            <AdminNavbar/>
            <div className="container py-5">
                <div className="admin-hero mb-4">
                    <h1>Detalle del producto</h1>
                </div>
                {cargando&& <p className="text-center">Cargando producto...</p>}
                {!cargando && (
                <div className="row justify-content-center">
                    {medicamento &&<>
                    <div className="col-md-8 col-lg-6">
                        <div className="admin-panel text-center">
                            <img
                                src={medicamento.imagen}
                                alt={medicamento.nombre}
                                className="img-fluid rounded mb-3"
                                style={{maxHeight:"280px", objectFit:"cover"}}
                            />
                            <h2 className="mb-2">{medicamento.nombre}</h2>
                            <p className="fs-3 fw-bold mb-2" style={{color:"#33553A"}}>${medicamento.precio}</p>
                            <button
                                className="admin-btn me-2"
                                onClick={() => fetch(`/catalogo/medicamentos/borrar/${id}`,{
                                    method:'DELETE'
                                }).then(()=>alert("Objeto eliminado, vuelva a inicio para continuar"))
                                }
                            >
                                Eliminar
                            </button>
                            <BotonVolverCatalogo ruta="/modificaciones"/>
                        </div>
                    </div></>}
                </div>)}
            </div>
        </div>
    );
}

export default DetalleModMed;