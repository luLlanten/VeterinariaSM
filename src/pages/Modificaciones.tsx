import { Link } from "react-router-dom"
import AdminNavbar from "../components/organisms/AdminNavbar"
import CardProducto from "../components/molecules/CardProducto"
import "../pages/Admin.css"

function Modificaciones(){
    return(
        <>
        <header>
            <AdminNavbar/>
        </header>
        <main>
            <div style={{backgroundColor:"rgb(61, 61, 61)", marginTop:"0%"}}>
                <Link to="/agregar" className="btn btn-light me-2">Agregar</Link>
                <Link to="/ficha-real" className="btn btn-light">Crear Ficha</Link>
            </div>
            <h2>Vista catalogo</h2>
            <hr/>
            <div className="container pb-5">
                <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="SV001"
                        titulo="Consulta general"
                        descripcion="Consultas"
                        precio={15000}
                        imagen="/images/consulta-general.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="SV002"
                        titulo="Consulta urgencia"
                        descripcion="Consultas"
                        precio={25000}
                        imagen="/images/consulta-urgencia.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="SV003"
                        titulo="Control postoperatorio"
                        descripcion="Consultas"
                        precio={10000}
                        imagen="/images/control-postoperatorio.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="SV004"
                        titulo="Consulta ave / conejo"
                        descripcion="Consultas"
                        precio={18000}
                        imagen="/images/consulta-ave-conejo.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="SV005"
                        titulo="Segunda opinión médica"
                        descripcion="Consultas"
                        precio={20000}
                        imagen="/images/segunda-opinion-medica.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="CI001"
                        titulo="Esterilización hembra canina"
                        descripcion="Cirugía"
                        precio={80000}
                        imagen="/images/esterilizacion-hembra-canina.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="CI002"
                        titulo="Esterilización macho canino"
                        descripcion="Cirugía"
                        precio={60000}
                        imagen="/images/esterilizacion-macho-canino.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="CI003"
                        titulo="Esterilización hembra felina"
                        descripcion="Cirugía"
                        precio={65000}
                        imagen="/images/esterilizacion-hembra-felina.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="CI004"
                        titulo="Esterilización macho felino"
                        descripcion="Cirugía"
                        precio={50000}
                        imagen="/images/esterilizacion-macho-felino.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="CI005"
                        titulo="Extirpación de tumor cutáneo"
                        descripcion="Cirugía"
                        precio={120000}
                        imagen="/images/extirpacion-de-tumor-cutaneo.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="CI006"
                        titulo="Cesárea de urgencia"
                        descripcion="Cirugía"
                        precio={180000}
                        imagen="/images/cesarea-de-urgencia.png"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="DE001"
                        titulo="Desparasitación interna pequeños (<10 kg)"
                        descripcion="Desparasitación"
                        precio={8000}
                        imagen="/images/desparasitacion-interna-pequenos-0-kg.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="DE002"
                        titulo="Desparasitación interna medianos (10-25 kg)"
                        descripcion="Desparasitación"
                        precio={9500}
                        imagen="/images/desparasitacion-interna-medianos.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="DE003"
                        titulo="Desparasitación interna grandes (>25 kg)"
                        descripcion="Desparasitación"
                        precio={11000}
                        imagen="/images/desparasitacion-interna-grandes.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="DE004"
                        titulo="Desparasitación interna felina"
                        descripcion="Desparasitación"
                        precio={8000}
                        imagen="/images/desparasitacion-interna-felina.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="DE005"
                        titulo="Antiparasitario externo (pipeta)"
                        descripcion="Desparasitación"
                        precio={7500}
                        imagen="/images/antiparasitario-externo.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="EX001"
                        titulo="Hemograma completo"
                        descripcion="Exámenes"
                        precio={22000}
                        imagen="/images/hemograma-completo.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="EX002"
                        titulo="Perfil bioquímico completo"
                        descripcion="Exámenes"
                        precio={35000}
                        imagen="/images/perfil-bioquimico-completo.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="EX003"
                        titulo="Radiografía (1 proyección)"
                        descripcion="Exámenes"
                        precio={28000}
                        imagen="/images/radiografia.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="EX004"
                        titulo="Ecografía abdominal"
                        descripcion="Exámenes"
                        precio={45000}
                        imagen="/images/ecografia-abdominal.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="EX005"
                        titulo="Test de leishmaniasis"
                        descripcion="Exámenes"
                        precio={18000}
                        imagen="/images/test-de-leishmaniasis.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="OT001"
                        titulo="Corte de uñas"
                        descripcion="Otros"
                        precio={5000}
                        imagen="/images/corte-de-unas.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="OT002"
                        titulo="Limpieza dental"
                        descripcion="Otros"
                        precio={55000}
                        imagen="/images/limpieza-dental.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="OT003"
                        titulo="Microchip identificación"
                        descripcion="Otros"
                        precio={15000}
                        imagen="/images/microchip-identificacion.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="OT004"
                        titulo="Hospitalización (por día)"
                        descripcion="Otros"
                        precio={30000}
                        imagen="/images/hospitalizacion.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="VA001"
                        titulo="Vacuna antirrábica canina"
                        descripcion="Vacunación"
                        precio={12000}
                        imagen="/images/vacunaantirrabicacanina.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="VA002"
                        titulo="Vacuna sextuple canina"
                        descripcion="Vacunación"
                        precio={18000}
                        imagen="/images/Vacunasextuplecanina.png"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="VA003"
                        titulo="Vacuna bivalente felina"
                        descripcion="Vacunación"
                        precio={15000}
                        imagen="/images/Vacunabivalentefelina.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="VA004"
                        titulo="Vacuna triple felina"
                        descripcion="Vacunación"
                        precio={17000}
                        imagen="/images/Vacunatriplefelina.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="VA005"
                        titulo="Vacuna Bordetella canina"
                        descripcion="Vacunación"
                        precio={14000}
                        imagen="/images/VacunaBordetellacanina.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="VA006"
                        titulo="Vacuna antirrábica felina"
                        descripcion="Vacunación"
                        precio={12000}
                        imagen="/images/vacuna-antirrabica-felina.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME001"
                        titulo="Amoxibay 250mg"
                        descripcion="Antibióticos"
                        precio={4200}
                        imagen="/images/amoxibay250mg.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME002"
                        titulo="Enrox 50mg"
                        descripcion="Antibióticos"
                        precio={6800}
                        imagen="/images/Enrox50mg.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME003"
                        titulo="Metrobay 250mg"
                        descripcion="Antibióticos"
                        precio={3900}
                        imagen="/images/metrobay-250mg.png"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME004"
                        titulo="Nexgard"
                        descripcion="Antiparasitarios"
                        precio={9500}
                        imagen="/images/Nexgard.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME005"
                        titulo="Bravecto"
                        descripcion="Antiparasitarios"
                        precio={18900}
                        imagen="/images/Bravecto.png"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME006"
                        titulo="Revolution Plus"
                        descripcion="Antiparasitarios"
                        precio={14500}
                        imagen="/images/revolution-plus.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME007"
                        titulo="Drontal Plus"
                        descripcion="Antiparasitarios"
                        precio={3200}
                        imagen="/images/drontal-plus.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME008"
                        titulo="Milbemax Gato"
                        descripcion="Antiparasitarios"
                        precio={6800}
                        imagen="/images/milbemax-gato.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME009"
                        titulo="Meloxicam 1mg"
                        descripcion="Antiinflamatorios"
                        precio={4500}
                        imagen="/images/meloxicam-1mg.jpeg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME010"
                        titulo="Carprofen 50mg"
                        descripcion="Antiinflamatorios"
                        precio={9800}
                        imagen="/images/Carprofen50mg.png"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME011"
                        titulo="Clorhexidina shampoo"
                        descripcion="Dermatología"
                        precio={8900}
                        imagen="/images/clorhexidina-shampoo.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME012"
                        titulo="Malaseb shampoo"
                        descripcion="Dermatología"
                        precio={12500}
                        imagen="/images/malaseb-shampoo.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME013"
                        titulo="Apoquel 16mg"
                        descripcion="Dermatología"
                        precio={22000}
                        imagen="/images/apoquel-16mg.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME014"
                        titulo="Probifor"
                        descripcion="Digestivo"
                        precio={5600}
                        imagen="/images/Probifor.jpeg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME015"
                        titulo="Omeprazol 10mg vet"
                        descripcion="Digestivo"
                        precio={3800}
                        imagen="/images/omeprazol-10mg-vet.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME016"
                        titulo="Vetmedin 2.5mg"
                        descripcion="Cardíaco"
                        precio={28000}
                        imagen="/images/vetmedin-2-5mg.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME017"
                        titulo="Tramadol 50mg vet"
                        descripcion="Analgésicos"
                        precio={5200}
                        imagen="/images/tramadol-50mg-vet.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME018"
                        titulo="Nobivac DHPPi"
                        descripcion="Vacunas"
                        precio={8500}
                        imagen="/images/nobivac-dhppi.png"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME019"
                        titulo="Nobivac Rabies"
                        descripcion="Vacunas"
                        precio={5800}
                        imagen="/images/nobivac-rabies.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME020"
                        titulo="Felocell CVR"
                        descripcion="Vacunas"
                        precio={7200}
                        imagen="/images/felocell-cvr.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME021"
                        titulo="Omega vet 3-6-9"
                        descripcion="Suplementos"
                        precio={9900}
                        imagen="/images/Omega.png"
                        ruta="/modificacion/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-3">
                    <CardProducto
                        id="ME022"
                        titulo="Condrovet forte"
                        descripcion="Suplementos"
                        precio={14500}
                        imagen="/images/condrovetforte.jpg"
                        ruta="/modificacion/"
                    />
                </div>
                </div>
            </div>
        </main>
        </>
    )
}
export default Modificaciones
