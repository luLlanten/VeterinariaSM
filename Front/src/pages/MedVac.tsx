import Navbar from "../components/organisms/Navbar"
import Footer from "../components/organisms/Footer"
import CardProducto from "../components/molecules/CardProducto"
import { useEffect, useState } from "react";
interface Med{
        id:number;
        categoria:string;
        nombre:string;
        precio:number;
        cantidad:number;
        imagen:string;
    }
function MedVac(){
    const [medicamentos,setMedicamentos] = useState<Med[]>([]);
    const [cargando, setCargando] = useState(true);
    useEffect(() => {
    const cargarMedicamentos = async () => {
      try {
        const respuesta = await fetch("http://localhost:9090/catalogo/medicamentos");

        if (!respuesta.ok) {
          throw new Error(`Error HTTP: ${respuesta.status}`);
        }

        const datos = (await respuesta.json()) as Med[];
        setMedicamentos(datos);
      } catch (error) {
        console.error("Error al cargar catálogo:", error);
        alert("Intente nuevamente");
      } finally {
        setCargando(false);
      }
    };

    cargarMedicamentos();
  }, []);
    return(
        <>
        <Navbar/>
        <div className="container my-5">
            <h1 className="text-center mb-4">Medicamentos y vacunas</h1>
            {cargando && <p className="text-center">Cargando servicios...</p>}
            {!cargando &&  (
            <div className="row g-3">
                {medicamentos.map((medicamento)=>(
                    <div key={medicamento.id} className="col-12 col-md-6 col-lg-4">
                        <CardProducto
                            id={medicamento.id.toString()}
                            titulo={medicamento.nombre}
                            precio={medicamento.precio}
                            imagen={medicamento.imagen}
                            ruta="/medicamento/"
                        />
                    </div>
                ))}
            </div>
            )}
        </div>
        <Footer/>
        </>
    )}
export default MedVac
