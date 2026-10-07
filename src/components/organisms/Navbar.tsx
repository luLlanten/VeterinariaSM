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
                        <li className="nav-item"><a className="nav-link" href="#nosotros">Nosotros</a></li>/*RECUERDEN CAMBIAR A Link LOS a */
                        <li className="nav-item"><a className="nav-link" href="#noticias">Noticias</a></li>
                        <li className="nav-item"><a className="nav-link" href="#servicios">Servicios</a></li>
                        <li className="nav-item"><a className="nav-link" href="../Login_reg/login.html">Iniciar Sesion</a></li>
                        <li className="nav-item"><a className="boton-cuenta" href="../Login_reg/registro.html">Crear Cuenta</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        )
}
export default Navbar