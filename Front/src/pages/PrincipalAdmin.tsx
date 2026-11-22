import { Link } from "react-router-dom"
import Footer from "../components/organisms/Footer"
import "../pages/Admin.css"
import AdminNavbar from "../components/organisms/AdminNavbar"

function PrincipalAdmin(){
    return(
        <>
        <div className="admin-layout">
            <AdminNavbar/>
            <div className="container py-5">

                <div className="admin-hero mb-5">
                    <h1>Panel de Administración</h1>
                    <p>Ha iniciado sesión en una cuenta de administrador.</p>
                    <p>Aquí encontrará las opciones y vistas de administración que necesite.</p>
                </div>

                <div className="row g-4 mb-5">
                    <div className="col-12">
                        <Link to="/modificaciones" className="admin-opcion">
                            <img src="images/icono_caja.png" alt="ic_inventario" className="admin-icono" />
                            <h3>Inventario</h3>
                            <p>
                                Aquí puedes observar un detalle resumido del stock
                                disponible en el inventario, puedes usar sus datos
                                para añadir cualquier producto al catálogo.
                            </p>
                            <span className="admin-irA">Ir al inventario →</span>
                        </Link>
                    </div>
                </div>

                <div className="admin-panel">
                    <h2>Lista de Usuarios</h2>
                    <table className="admin-tabla">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Rol</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Cristian Vega</td>
                                <td><span className="admin-rol rol-admin">Administrador</span></td>
                            </tr>
                            <tr>
                                <td>Ricardo Yañez</td>
                                <td><span className="admin-rol rol-vet">Veterinario</span></td>
                            </tr>
                            <tr>
                                <td>Javiera Mardones</td>
                                <td><span className="admin-rol rol-cliente">Cliente</span></td>
                            </tr>
                            <tr>
                                <td>Carlos Gonzales</td>
                                <td><span className="admin-rol rol-cliente">Cliente</span></td>
                            </tr>
                            <tr>
                                <td>Luciano Jimenez</td>
                                <td><span className="admin-rol rol-cliente">Cliente</span></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>
            <Footer/>
        </div>
        </>
    )
}
export default PrincipalAdmin
