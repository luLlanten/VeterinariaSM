import Navbar from "../components/organisms/Navbar"
import Footer from "../components/organisms/Footer"
import CardProducto from "../components/molecules/CardProducto"

function Catalogo(){
    return(
        <>
        <Navbar/>
        <div className="container my-5">
            <h1 className="text-center mb-4">Catálogo de servicios</h1>

            <h3 className="mt-5 mb-3">Consultas</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="SV001"
                        titulo="Consulta general"
                        descripcion="Duración: 30 min"
                        precio={15000}
                        imagen="/images/consulta-general.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="SV002"
                        titulo="Consulta urgencia"
                        descripcion="Fuera de horario +$10.000 - Duración: 30 min"
                        precio={25000}
                        imagen="/images/consulta-urgencia.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="SV003"
                        titulo="Control postoperatorio"
                        descripcion="Duración: 20 min"
                        precio={10000}
                        imagen="/images/control-postoperatorio.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="SV004"
                        titulo="Consulta ave / conejo"
                        descripcion="Duración: 30 min"
                        precio={18000}
                        imagen="/images/consulta-ave-conejo.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="SV005"
                        titulo="Segunda opinión médica"
                        descripcion="Requiere ficha previa - Duración: 40 min"
                        precio={20000}
                        imagen="/images/segunda-opinion-medica.jpg"
                        ruta="/servicio/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Cirugía</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="CI001"
                        titulo="Esterilización hembra canina"
                        descripcion="Incluye anestesia y hospitalización 24h - Duración: 90 min"
                        precio={80000}
                        imagen="/images/esterilizacion-hembra-canina.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="CI002"
                        titulo="Esterilización macho canino"
                        descripcion="Incluye anestesia - Duración: 60 min"
                        precio={60000}
                        imagen="/images/esterilizacion-macho-canino.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="CI003"
                        titulo="Esterilización hembra felina"
                        descripcion="Incluye anestesia y hospitalización 12h - Duración: 60 min"
                        precio={65000}
                        imagen="/images/esterilizacion-hembra-felina.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="CI004"
                        titulo="Esterilización macho felino"
                        descripcion="Incluye anestesia - Duración: 45 min"
                        precio={50000}
                        imagen="/images/esterilizacion-macho-felino.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="CI005"
                        titulo="Extirpación de tumor cutáneo"
                        descripcion="Precio referencial; varía según tamaño - Duración: 60 min"
                        precio={120000}
                        imagen="/images/extirpacion-de-tumor-cutaneo.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="CI006"
                        titulo="Cesárea de urgencia"
                        descripcion="Duración: 120 min"
                        precio={180000}
                        imagen="/images/cesarea-de-urgencia.png"
                        ruta="/servicio/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Desparasitación</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="DE001"
                        titulo="Desparasitación interna pequeños (<10 kg)"
                        descripcion="Duración: 5 min"
                        precio={8000}
                        imagen="/images/desparasitacion-interna-pequenos-0-kg.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="DE002"
                        titulo="Desparasitación interna medianos (10-25 kg)"
                        descripcion="Duración: 5 min"
                        precio={9500}
                        imagen="/images/desparasitacion-interna-medianos.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="DE003"
                        titulo="Desparasitación interna grandes (>25 kg)"
                        descripcion="Duración: 5 min"
                        precio={11000}
                        imagen="/images/desparasitacion-interna-grandes.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="DE004"
                        titulo="Desparasitación interna felina"
                        descripcion="Duración: 5 min"
                        precio={8000}
                        imagen="/images/desparasitacion-interna-felina.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="DE005"
                        titulo="Antiparasitario externo (pipeta)"
                        descripcion="Incluye aplicación - Duración: 5 min"
                        precio={7500}
                        imagen="/images/antiparasitario-externo.jpg"
                        ruta="/servicio/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Exámenes</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="EX001"
                        titulo="Hemograma completo"
                        descripcion="Resultado en 24-48 h - Duración: 30 min"
                        precio={22000}
                        imagen="/images/hemograma-completo.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="EX002"
                        titulo="Perfil bioquímico completo"
                        descripcion="Resultado en 24-48 h - Duración: 30 min"
                        precio={35000}
                        imagen="/images/perfil-bioquimico-completo.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="EX003"
                        titulo="Radiografía (1 proyección)"
                        descripcion="Duración: 20 min"
                        precio={28000}
                        imagen="/images/radiografia.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="EX004"
                        titulo="Ecografía abdominal"
                        descripcion="Duración: 30 min"
                        precio={45000}
                        imagen="/images/ecografia-abdominal.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="EX005"
                        titulo="Test de leishmaniasis"
                        descripcion="Duración: 20 min"
                        precio={18000}
                        imagen="/images/test-de-leishmaniasis.jpg"
                        ruta="/servicio/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Otros</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="OT001"
                        titulo="Corte de uñas"
                        descripcion="Duración: 15 min"
                        precio={5000}
                        imagen="/images/corte-de-unas.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="OT002"
                        titulo="Limpieza dental"
                        descripcion="Requiere anestesia - Duración: 45 min"
                        precio={55000}
                        imagen="/images/limpieza-dental.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="OT003"
                        titulo="Microchip identificación"
                        descripcion="Incluye registro - Duración: 10 min"
                        precio={15000}
                        imagen="/images/microchip-identificacion.jpg"
                        ruta="/servicio/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="OT004"
                        titulo="Hospitalización (por día)"
                        descripcion="Incluye monitoreo y alimentación básica - Duración: 24 h"
                        precio={30000}
                        imagen="/images/hospitalizacion.jpg"
                        ruta="/servicio/"
                    />
                </div>
            </div>
        </div>
        <Footer/>
        </>
    )
}
export default Catalogo
