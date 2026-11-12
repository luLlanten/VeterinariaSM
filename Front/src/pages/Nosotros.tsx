import Footer from "../components/organisms/Footer"
import Navbar from "../components/organisms/Navbar"
import "../pages/Principal.css"

function Nosotros(){
    return(
        <>
        <Navbar/>
        <header className="inicio text-center">
            <div className="container">
                <h1>Sobre Nosotros</h1>
                <p className="lead">Conoce a quienes cuidan de tu mascota</p>
            </div>
        </header>

        <section className="container my-5">
            <div className="row align-items-center">
                <div className="col-md-6">
                    <img src="/images/nosotros.jpg" alt="Equipo de la veterinaria" className="img-nosotros mb-4 mb-md-0"/>
                </div>
                <div className="col-md-6">
                    <h2>Nuestra historia</h2>
                    <p>
                        En Veterinaria San Marcos llevamos más de 10 años cuidando la salud y el bienestar
                        de perros, gatos y otras mascotas de nuestra comunidad.
                    </p>
                    <p>
                        Creemos que cada mascota merece atención personalizada, por eso combinamos
                        experiencia clínica con mucho cariño en cada consulta.
                    </p>
                </div>
            </div>
        </section>

        <section className="container my-5">
            <div className="row">
                <div className="col-md-6 mb-4">
                    <div className="caja-info">
                        <h5>Misión</h5>
                        <p>Entregar atención veterinaria de calidad, cercana y accesible.</p>
                    </div>
                </div>
                <div className="col-md-6 mb-4">
                    <div className="caja-info">
                        <h5>¿Por qué elegirnos?</h5>
                        <ul>
                            <li>Médicos veterinarios certificados</li>
                            <li>Atención de urgencias</li>
                            <li>Instalaciones limpias y cómodas</li>
                            <li>Precios accesibles</li>
                            <li>Flexibilidad a pagos</li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <Footer/>
        </>
    )
}
export default Nosotros