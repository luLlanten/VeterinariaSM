import { Link } from "react-router-dom"

function Navbar(){
    return(
        <nav className="navbar navbar-expand-lg">
            <div className="container">
                <Link className="navbar-brand d-flex align-items-center" to="/">
                    <img src="/images/logo.svg" alt="Logo Veterinaria San Marcos" width="40" height="40" className="me-2"/>
                    Veterinaria San Marcos
                </Link>
                <div className="drawer-body">
                    <ul className="navbar-nav ms-auto align-items-lg-center">
                        <li className="nav-item"><a className="nav-link" href="/#noticias">Noticias</a></li>
                        <li className="nav-item"><a className="nav-link" href="/#servicios">Servicios</a></li>
                        <li className="nav-item"><Link className="nav-link" to={"/nosotros"}>Nosotros</Link></li>
                        <li className="nav-item"><Link className="nav-link" to={"/login"}>Iniciar Sesion</Link></li>
                        <li className="nav-item"><Link className="boton-cuenta" to={"/registro"}>Crear Cuenta</Link></li>
                    </ul>
                </div>
            </div>
        </nav>
        )
}
export default Navbar