import Navbar from "../components/organisms/Navbar"
import Footer from "../components/organisms/Footer"
import CardProducto from "../components/molecules/CardProducto"

function MedVac(){
    return(
        <>
        <Navbar/>
        <div className="container my-5">
            <h1 className="text-center mb-4">Medicamentos y vacunas</h1>

            <h3 className="mt-5 mb-3">Vacunación</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="VA001"
                        titulo="Vacuna antirrábica canina"
                        descripcion="Obligatoria por ley - Duración: 10 min"
                        precio={12000}
                        imagen="/images/vacunaantirrabicacanina.jpg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="VA002"
                        titulo="Vacuna sextuple canina"
                        descripcion="Refuerzo anual - Duración: 10 min"
                        precio={18000}
                        imagen="/images/Vacunasextuplecanina.png"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="VA003"
                        titulo="Vacuna bivalente felina"
                        descripcion="Refuerzo anual - Duración: 10 min"
                        precio={15000}
                        imagen="/images/Vacunabivalentefelina.jpg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="VA004"
                        titulo="Vacuna triple felina"
                        descripcion="Refuerzo anual - Duración: 10 min"
                        precio={17000}
                        imagen="/images/Vacunatriplefelina.jpg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="VA005"
                        titulo="Vacuna Bordetella canina"
                        descripcion="Tos de las perreras - Duración: 10 min"
                        precio={14000}
                        imagen="/images/VacunaBordetellacanina.jpg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="VA006"
                        titulo="Vacuna antirrábica felina"
                        descripcion="Duración: 10 min"
                        precio={12000}
                        imagen="/images/vacuna-antirrabica-felina.jpg"
                        ruta="/medicamento/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Antibióticos</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME001"
                        titulo="Amoxibay 250mg"
                        descripcion="Principio Activo: Amoxicilina - Stock: 45"
                        precio={4200}
                        imagen="/images/amoxibay250mg.jpg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME002"
                        titulo="Enrox 50mg"
                        descripcion="Principio Activo: Enrofloxacino - Stock: 30"
                        precio={6800}
                        imagen="/images/Enrox50mg.jpg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME003"
                        titulo="Metrobay 250mg"
                        descripcion="Principio Activo: Metronidazol - Stock: 28"
                        precio={3900}
                        imagen="/images/metrobay-250mg.png"
                        ruta="/medicamento/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Antiparasitarios</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME004"
                        titulo="Nexgard"
                        descripcion="Principio Activo: Afoxolaner - Stock: 60"
                        precio={9500}
                        imagen="/images/Nexgard.jpg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME005"
                        titulo="Bravecto"
                        descripcion="Principio Activo: Fluralaner - Stock: 40"
                        precio={18900}
                        imagen="/images/Bravecto.png"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME006"
                        titulo="Revolution Plus"
                        descripcion="Principio Activo: Selamectina+Sarolaner - Stock: 35"
                        precio={14500}
                        imagen="/images/revolution-plus.jpg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME007"
                        titulo="Drontal Plus"
                        descripcion="Principio Activo: Praziquantel+Pamoato - Stock: 80"
                        precio={3200}
                        imagen="/images/drontal-plus.jpg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME008"
                        titulo="Milbemax Gato"
                        descripcion="Principio Activo: Milbemicina+Praziq. - Stock: 50"
                        precio={6800}
                        imagen="/images/milbemax-gato.jpg"
                        ruta="/medicamento/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Antiinflamatorios</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME009"
                        titulo="Meloxicam 1mg"
                        descripcion="Principio Activo: Meloxicam - Stock: 55"
                        precio={4500}
                        imagen="/images/meloxicam-1mg.jpeg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME010"
                        titulo="Carprofen 50mg"
                        descripcion="Principio Activo: Carprofeno - Stock: 30"
                        precio={9800}
                        imagen="/images/Carprofen50mg.png"
                        ruta="/medicamento/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Dermatología</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME011"
                        titulo="Clorhexidina shampoo"
                        descripcion="Principio Activo: Clorhexidina 2% - Stock: 25"
                        precio={8900}
                        imagen="/images/clorhexidina-shampoo.jpg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME012"
                        titulo="Malaseb shampoo"
                        descripcion="Principio Activo: Miconazol+Clorhex. - Stock: 20"
                        precio={12500}
                        imagen="/images/malaseb-shampoo.jpg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME013"
                        titulo="Apoquel 16mg"
                        descripcion="Principio Activo: Oclacitinib - Stock: 18"
                        precio={22000}
                        imagen="/images/apoquel-16mg.jpg"
                        ruta="/medicamento/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Digestivo</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME014"
                        titulo="Probifor"
                        descripcion="Principio Activo: Bacillus clausii - Stock: 40"
                        precio={5600}
                        imagen="/images/Probifor.jpeg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME015"
                        titulo="Omeprazol 10mg vet"
                        descripcion="Principio Activo: Omeprazol - Stock: 35"
                        precio={3800}
                        imagen="/images/omeprazol-10mg-vet.jpg"
                        ruta="/medicamento/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Cardíaco</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME016"
                        titulo="Vetmedin 2.5mg"
                        descripcion="Principio Activo: Pimobendan - Stock: 15"
                        precio={28000}
                        imagen="/images/vetmedin-2-5mg.jpg"
                        ruta="/medicamento/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Analgésicos</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME017"
                        titulo="Tramadol 50mg vet"
                        descripcion="Principio Activo: Tramadol - Stock: 22"
                        precio={5200}
                        imagen="/images/tramadol-50mg-vet.jpg"
                        ruta="/medicamento/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Vacunas</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME018"
                        titulo="Nobivac DHPPi"
                        descripcion="Principio Activo: Vacuna polivalente - Stock: 48"
                        precio={8500}
                        imagen="/images/nobivac-dhppi.png"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME019"
                        titulo="Nobivac Rabies"
                        descripcion="Principio Activo: Vacuna antirrábica - Stock: 60"
                        precio={5800}
                        imagen="/images/nobivac-rabies.jpg"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME020"
                        titulo="Felocell CVR"
                        descripcion="Principio Activo: Vacuna triple felina - Stock: 36"
                        precio={7200}
                        imagen="/images/felocell-cvr.jpg"
                        ruta="/medicamento/"
                    />
                </div>
            </div>

            <h3 className="mt-5 mb-3">Suplementos</h3>
            <div className="row g-3">
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME021"
                        titulo="Omega vet 3-6-9"
                        descripcion="Principio Activo: Ácidos grasos omega - Stock: 30"
                        precio={9900}
                        imagen="/images/Omega.png"
                        ruta="/medicamento/"
                    />
                </div>
                <div className="col-12 col-md-6 col-lg-4">
                    <CardProducto
                        id="ME022"
                        titulo="Condrovet forte"
                        descripcion="Principio Activo: Condroitín+Glucos. - Stock: 25"
                        precio={14500}
                        imagen="/images/condrovetforte.jpg"
                        ruta="/medicamento/"
                    />
                </div>
            </div>
        </div>
        <Footer/>
        </>
    )
}
export default MedVac
