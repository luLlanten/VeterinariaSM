import { Link } from "react-router-dom"
function AdminNavbar(){
    return(
        <nav className="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
        <div className="container-fluid">
            <Link className="navbar-brand" to="/admin">Inicio Admin</Link>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNavDropdown">
            <ul className="navbar-nav">
                <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to="/">Volver a Homepage</Link>
                </li>
                <li className="nav-item">
                <Link className="nav-link" to="/modificaciones">Modificar</Link>
                </li>
                <li className="nav-item">
                <Link className="nav-link" to="/catalogo">Ver catalogo</Link>
                </li>
            </ul>
            </div>
        </div>
        </nav>
    )
}
export default AdminNavbar