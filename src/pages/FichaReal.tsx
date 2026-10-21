import { Link } from "react-router-dom"
import AdminNavbar from "../components/organisms/AdminNavbar"
import FormularioNecropsia from "../components/organisms/FormularioNecropsia"
import "../pages/Admin.css"

function FichaReal(){
    return(
        <div className="admin-layout">
            <AdminNavbar/>
            <div className="admin-barra container py-4 d-flex flex-wrap justify-content-between align-items-center gap-2">
                <div>
                    <h2 className="admin-titulo">Ficha de necropsia</h2>
                    <p className="admin-subtitulo">Complete todos los campos de la ficha.</p>
                </div>
                <Link to="/modificaciones" className="admin-btn admin-btn-claro">Volver</Link>
            </div>
            <div className="necropsia-mesa">
                <FormularioNecropsia/>
            </div>
        </div>
    )
}
export default FichaReal
