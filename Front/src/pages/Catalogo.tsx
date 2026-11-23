import Navbar from "../components/organisms/Navbar"
import Footer from "../components/organisms/Footer"
import CardProducto from "../components/molecules/CardProducto"
import { useEffect, useState } from "react";
interface Serv{
    id:number;
    categoria:string;
    nombre:string;
    precio:number;
    imagen:string;
}
function Catalogo(){    
    const [servicios, setServicios] = useState<Serv[]>([]);
    const [cargando, setCargando] = useState(true);
    useEffect(() => {
    const cargarServicios = async () => {
      try {
        const respuesta = await fetch("http://localhost:9090/catalogo/servicios");

        if (!respuesta.ok) {
          throw new Error(`Error HTTP: ${respuesta.status}`);
        }

        const datos = (await respuesta.json()) as Serv[];
        setServicios(datos);
      } catch (error) {
        console.error("Error al cargar catálogo:", error);
        alert("Intente nuevamente");
      } finally {
        setCargando(false);
      }
    };

    cargarServicios();
  }, []);
    
    return(
                <>
                <Navbar/>
                <div className="container my-5">
                    <h1 className="text-center mb-4">Catálogo de servicios</h1>
                        {cargando && <p className="text-center">Cargando servicios...</p>}
                        {!cargando &&  (
                        <div className="row g-4">
                            {servicios.map((servicio) => (
                            <div key={servicio.id} className="col-12 col-md-6 col-lg-4">
                                <CardProducto
                                id={servicio.id.toString()}
                                titulo={servicio.nombre}
                                precio={servicio.precio}
                                imagen={servicio.imagen}
                                ruta="/servicio/"
                                />
                            </div>
                            ))}
                        </div>
                        )}
                </div>
                <Footer/>
                </>
            )
}                       
export default Catalogo
