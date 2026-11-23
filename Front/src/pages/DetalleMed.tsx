import { useParams } from "react-router-dom";
import Navbar from "../components/organisms/Navbar";
import Footer from "../components/organisms/Footer";
import BotonAgregarCarrito from "../components/atoms/BotonAgregarCarrito";
import { agregarAlCarrito } from "../data/carrito";
import BotonVolverCatalogo from "../components/atoms/BotonVolverCatologo";
import "../pages/Principal.css"
import { useEffect, useState } from "react";
    interface Med{
        id:number;
        categoria:string;
        nombre:string;
        precio:number;
        cantidad:number;
        imagen:string;
    }
function DetalleMed(){
    const [medicamento,setMedicamento]=useState<Med>()
    const [cargando, setCargando] = useState(true)
    const {id} = useParams();
    useEffect(()=>{
        const cargarMedicamento=async()=>{
            try{
            const respuesta = await fetch(`http://localhost:9090/catalogo/medicamentos/${id}`)
            if (!respuesta.ok){
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
            const med=(await respuesta.json()) as Med
            setMedicamento(med)
        }catch(error){
            console.error("Error al cargar producto",error)
            alert("Intente nuevamente")
        }finally{
            setCargando(false)
        }
    }
    cargarMedicamento()
})
    const agregar = () => {
        if(!medicamento){
                    alert("El servicio ya esta no disponible")
                    return
                }
        agregarAlCarrito(medicamento.id.toString(), medicamento.nombre, medicamento.precio, medicamento.imagen);
    }

    return(
        <>
        <Navbar/>
        <div className="container my-5">
            <h1 className="text-center mb-4">Detalle del medicamento</h1>
            {cargando&& <p className="text-center">Cargando medicamento...</p>}
            {!cargando && (
            <div className="row g-4 align-items-center">
                {medicamento&&<>
                <div className="col-md-6">
                    <img
                        src={medicamento.imagen}
                        alt={medicamento.nombre}
                        className="rounded"
                        style={{width:"540px",maxHeight:"540px",paddingLeft:"10%"}}
                    />
                </div>
                <div className="col-12 col-md-6 seccion-detalle">
                    <p className="mb-1">{medicamento.categoria}</p>
                    <h2>{medicamento.nombre}</h2>
                    <p className="fs-3 fw-bold">${medicamento.precio}</p>
                    <div className="d-flex gap-2">
                        <BotonVolverCatalogo ruta="/medicamentos"/>
                        <BotonAgregarCarrito ruta="/carrito" alAgregar={agregar}/>
                    </div>
                </div></>}
            </div>
            )}
        </div>
        <Footer/>
        </>
    );
}

export default DetalleMed;