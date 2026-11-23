import { Link } from "react-router-dom"
import AdminNavbar from "../components/organisms/AdminNavbar"
import CardProducto from "../components/molecules/CardProducto"
import "../pages/Admin.css"
import { useEffect, useState } from "react";
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
function Modificaciones(){
    const [servicios, setServicios] = useState<Serv[]>([]);
    const [medicamentos,setMedicamentos] = useState<Med[]>([]);
    const [cargando, setCargando] = useState(true);
    useEffect(() => {
    const cargarProductos = async () => {
      try {
        const respuesta = await fetch("http://localhost:9090/catalogo/servicios");
        const respuesta2 = await fetch("http://localhost:9090/catalogo/medicamentos");
        if (!respuesta.ok) {
          throw new Error(`Error HTTP: ${respuesta.status}`);
        }
        if (!respuesta2.ok) {
          throw new Error(`Error HTTP: ${respuesta.status}`);
        }

        const datos = (await respuesta.json()) as Serv[];
        const datos2 = (await respuesta2.json()) as Med[];
        setServicios(datos);
        setMedicamentos(datos2);
      } catch (error) {
        console.error("Error al cargar catálogo:", error);
        alert("Intente nuevamente");
      } finally {
        setCargando(false);
      }
    };
    cargarProductos();
  }, []);
    return(
        <div className="admin-layout">
            <AdminNavbar/>
            <div className="container py-5">

                <div className="admin-hero mb-4 d-flex flex-wrap justify-content-between align-items-center gap-3">
                    <div>
                        <h1>Inventario</h1>
                        <p>Vista del catálogo: servicios, medicamentos y vacunas.</p>
                    </div>
                    <div className="d-flex flex-wrap gap-2">
                        <Link to="/agregar" className="admin-btn admin-btn-claro">+ Agregar producto</Link>
                    </div>
                </div>

                <div className="admin-grid">
                    {cargando && <p className="text-center">Cargando servicios...</p>}
            {!cargando &&  (
                    <div className="row g-4">
                    {medicamentos.map((medicamento)=>(
                    <div key={medicamento.id} className="col-12 col-md-6 col-lg-3">
                        <CardProducto
                            id={medicamento.id.toString()}
                            titulo={medicamento.nombre}
                            precio={medicamento.precio}
                            imagen={medicamento.imagen}
                            ruta="/modificacion/med/"
                        />
                    </div>))}
                    {servicios.map((servicio) => (
                            <div key={servicio.id} className="col-12 col-md-6 col-lg-3">
                                <CardProducto
                                id={servicio.id.toString()}
                                titulo={servicio.nombre}
                                precio={servicio.precio}
                                imagen={servicio.imagen}
                                ruta="/modificacion/serv/"
                                />
                            </div>
                            ))}
                    </div>
                )}
                </div>

            </div>
        </div>
    )
}
export default Modificaciones
