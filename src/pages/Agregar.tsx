import AdminNavbar from "../components/organisms/AdminNavbar"
import FormularioProducto from "../components/organisms/FormularioProducto"
import "../pages/Admin.css"

function Agregar(){
    return(
        <>
        <header>
            <AdminNavbar/>
        </header>
        <div className="container my-5">
            <h2>Agregar nuevo producto</h2>
            <hr/>
            <div className="col-md-8 col-lg-6 mx-auto">
                <h4 className="text-center mb-3">Inserte los datos del producto</h4>
                <FormularioProducto/>
            </div>
        </div>
        </>
    )
}
export default Agregar