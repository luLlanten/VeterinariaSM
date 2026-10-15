import { Link } from "react-router-dom"

function Navbar(){
    return(
        <nav className="navbar navbar-expand-lg">
            <div className="container">
                <a className="navbar-brand" href="principal.html">Veterinaria San Marcos </a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="menu">
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