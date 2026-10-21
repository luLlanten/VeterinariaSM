import { Link } from "react-router-dom"

function AdminNavbar(){
    return(
        <nav className="navbar navbar-expand-lg admin-nav" data-bs-theme="dark">
            <div className="container">
                <Link className="navbar-brand" to="/admin">
                    Veterinaria San Marcos<span>ADMIN</span>
                </Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarAdmin" aria-controls="navbarAdmin" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarAdmin">
                    <ul className="navbar-nav ms-auto align-items-lg-center">
                        <li className="nav-item">
                            <Link className="nav-link" to="/admin">Inicio</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/modificaciones">Inventario</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/servicios">Ver catalogo</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/">Volver a Homepage</Link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}
export default AdminNavbar
