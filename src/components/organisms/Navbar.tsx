import { Link } from "react-router-dom"

function Navbar(){
    return(
        <nav className="navbar navbar-expand-lg">
            <div className="container">
                <Link className="navbar-brand" to="/">Veterinaria San Marcos </Link>
                <div className="drawer-body">
                    <ul className="navbar-nav ms-auto align-items-lg-center">
                        <li className="nav-item"><Link className="nav-link" to={"/noticias"}>Noticias</Link></li>
                        <li className="nav-item"><Link className="nav-link" to={"/servicios"}>Servicios</Link></li>
                        <li className="nav-item"><Link className="nav-link" to={"/login"}>Iniciar Sesion</Link></li>
                        <li className="nav-item"><Link className="boton-cuenta" to={"/registro"}>Crear Cuenta</Link></li>
                    </ul>
                </div>
            </div>
        </nav>
        )
}
export default Navbar