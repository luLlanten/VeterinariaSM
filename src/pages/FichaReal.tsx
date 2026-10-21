import { Link } from "react-router-dom"
import AdminNavbar from "../components/organisms/AdminNavbar"
import FormularioNecropsia from "../components/organisms/FormularioNecropsia"
import "../pages/Admin.css"

function FichaReal(){
    return(
        <>
        <header>
            <AdminNavbar/>
        </header>
        <div style={{backgroundColor:"rgb(61, 61, 61)", marginTop:"0%"}}>
            <Link to="/modificaciones" className="btn btn-light">Volver</Link>
        </div>
        <div className="container my-5">
            <h2 className="mb-4">Ficha de necropsia</h2>
            <FormularioNecropsia/>
        </div>
        </>
    )
}
export default FichaReal