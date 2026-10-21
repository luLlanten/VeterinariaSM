import AdminNavbar from "../components/organisms/AdminNavbar"
import FormularioProducto from "../components/organisms/FormularioProducto"
import "../pages/Admin.css"

function Agregar(){
    return(
        <div className="admin-layout">
            <AdminNavbar/>
            <div className="container py-5">
                <div className="admin-hero mb-4">
                    <h1>Agregar nuevo producto</h1>
                    <p>Inserte los datos del producto que desea añadir al catálogo.</p>
                </div>
                <div className="row justify-content-center">
                    <div className="col-md-8 col-lg-6">
                        <div className="admin-panel">
                            <FormularioProducto/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default Agregar
