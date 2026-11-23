import { useParams } from "react-router-dom";
import Navbar from "../components/organisms/Navbar";
import BotonVolverCatalogo from "../components/atoms/BotonVolverCatologo";
import BotonAgregarCarrito from "../components/atoms/BotonAgregarCarrito";
import { agregarAlCarrito } from "../data/carrito";
import Footer from "../components/organisms/Footer";
import "../pages/Principal.css"
import { useEffect, useState } from "react";
interface Serv{
        id:number;
        categoria:string;
        nombre:string;
        precio:number;
        imagen:string;
    }
function Detalle(){
    const [servicio,setServicio]=useState<Serv>()
    const [cargando, setCargando] = useState(true)
    const {id} = useParams();
    useEffect(()=>{
        const cargarServicio=async()=>{
        try{    
        const respuesta = await fetch(`http://localhost:9090/catalogo/servicios/${id}`)
            if (!respuesta.ok){
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
            const serv=(await respuesta.json()) as Serv
            setServicio(serv)
            
        }catch(error){
            console.error("Error al cargar producto",error)
            alert("Intente nuevamente")
        }finally{
            setCargando(false)
        }
    }
    cargarServicio()
    })
    const agregar = () => {
                if(!servicio){
                    alert("El servicio ya esta no disponible")
                    return
                }agregarAlCarrito(servicio.id.toString(), servicio.nombre, servicio.precio, servicio.imagen);
                
            }

    return(
        <>
        <Navbar/>
        <div className="container my-5">
            <h1 className="text-center mb-4">Detalle del servicio</h1>
            {cargando&& <p className="text-center">Cargando servicio...</p>}
            {!cargando && (
                <div className="row g-4 align-items-center">
                    {servicio &&<>
                    <div className="col-md-6">
                    <img
                        src={servicio.imagen}
                        alt={servicio.nombre}
                        className="rounded"
                        style={{ width:"540px",maxHeight:"540px",paddingLeft:"10%"}}
                    />
                </div>
                <div className="col-12 col-md-6 seccion-detalle">
                    <p className="mb-1">{servicio.categoria}</p>
                    <h2>{servicio.nombre}</h2>
                    <p className="fs-3 fw-bold">${servicio.precio}</p>
                    <div className="d-flex gap-2">
                        <BotonVolverCatalogo ruta="/servicios"/>
                        <BotonAgregarCarrito ruta="/ficha" alAgregar={agregar}/>
                    </div>
                </div></>
                    }
                
            </div>

            )
            }
            
        </div>
        <Footer/>
        </>
    );
}

export default Detalle;