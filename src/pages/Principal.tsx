import Footer from "../components/organisms/Footer"
import Navbar from "../components/organisms/Navbar"

function Principal(){
    return(
        <>
        <Navbar/>
        <section id="nosotros" className="container my-5">
    <div className="row align-items-center">
      <div className="col-md-6">
        <img src="img/nosotros.jpg" alt="Equipo de la veterinaria" className="img-nosotros mb-4 mb-md-0"/>
      </div>
      <div className="col-md-6">
        <h2>Sobre Nosotros</h2>
        <p>
          En Veterinaria San Marcos llevamos más de 10 años cuidando la salud y el bienestar
          de perros, gatos y otras mascotas de nuestra comunidad. Contamos con un equipo de
          médicos veterinarios apasionados por los animales, equipo moderno y un trato
          humano tanto para las mascotas como para sus familias.
        </p>
        <p>
          Creemos que cada mascota merece atención personalizada, por eso combinamos
          experiencia clínica con mucho cariño en cada consulta.
        </p>
        <div className="caja-info">
          <h5>¿Por qué elegirnos?</h5>
          <ul>
            <li>Medicos veterinarios certificados</li>
            <li>Atencion de urgencias</li>
            <li>Instalaciones limpias y comodas</li>
            <li>Precios accesibles</li>
            <li>Flexibilidad a pagos</li>
          </ul>
        </div>
      </div>
    </div>
  </section>

  
  <section id="noticias" className="fondo-verde py-5">
    <div className="container">
      <h2 className="text-center mb-4">Noticias</h2>
      <div className="row">
        <div className="col-md-4 mb-4">
          <div className="card tarjeta-noticia">
            <img src="img/noticia1.jpg" alt="Campaña de vacunación" className="img-noticia"/>
            <div className="card-body">
              <h5 className="card-title">Campaña de vacunación gratuita</h5>
              <p className="card-text">Durante este mes de septiembre ofrecemos vacunas antirrabicas sin costo para mascotas del sector.</p>
            </div>
          </div>
        </div>
        <div className="col-md-4 mb-4">
          <div className="card tarjeta-noticia">
            <img src="img/noticia2.jpg" alt="Nuevo horario de atención" className="img-noticia"/>
            <div className="card-body">
              <h5 className="card-title">Nuevo horario de atención</h5>
              <p className="card-text">Ahora atendemos también los domingos en la mañana desde las 08:00 hrs  hasta las 23:00 hrs para casos de urgencia.</p>
            </div>
          </div>
        </div>
        <div className="col-md-4 mb-4">
          <div className="card tarjeta-noticia">
            <img src="img/noticia3.jpg" alt="Jornada de esterilización" className="img-noticia"/>
            <div className="card-body">
              <h5 className="card-title">Jornada de esterilización</h5>
              <p className="card-text">Inscribete a nuestra jornada de esterilizacion a precio reducido, cupos limitados.</p>
            </div>
          </div>
        </div>
      </div>
      <div className="text-center">
        <a href="noticias.html" className="btn boton-opcion">Ver mas</a>
      </div>
    </div>
  </section>


  <section id="servicios" className="container my-5">
    <h2 className="text-center mb-4">¿Que necesitas hoy?</h2>
    <div className="row justify-content-center">
      <div className="col-md-5 mb-4">
        <div className="tarjeta-opcion text-center">
          <h4>Catalogo de Servicios</h4>
          <p>Consultas, cirugias, peluqueria y mas servicios para tu mascota.</p>
          <a href="../Catalogo/catalogo.html" className="btn boton-opcion">Ver Servicios</a>
        </div>
      </div>
      <div className="col-md-5 mb-4">
        <div className="tarjeta-opcion text-center">
          <h4>Medicamentos y Vacunas</h4>
          <p>Revisa nuestro catalogo de medicamentos y el calendario de vacunacion.</p>
          <a href="../Catalogo/med_vac.html" className="btn boton-opcion">Ver Medicamentos</a>
        </div>
      </div>
    </div>
  </section>
  <Footer/>
  </>
    )
}
export default Principal