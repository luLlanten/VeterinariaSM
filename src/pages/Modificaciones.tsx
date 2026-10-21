import { Link } from "react-router-dom"
import AdminNavbar from "../components/organisms/AdminNavbar"
import "../pages/Admin.css"

function Modificaciones(){
    return(
        <>
        <header>
            <AdminNavbar/>
        </header>
        <main>
            <div style={{backgroundColor:"rgb(61, 61, 61)", marginTop:"0%"}}>
                <Link to="/agregar" className="btn btn-light me-2">Agregar</Link>
                <Link to="/ficha-real" className="btn btn-light">Crear Ficha</Link>
            </div>
            <h2>Vista catalogo</h2>
            <hr/>
            <div style={{display:"flex", flexWrap:"wrap", gap:"25px", maxWidth:"90%", marginLeft:"5%"}}>
            </div>
        </main>
        </>
    )
}
export default Modificaciones