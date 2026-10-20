import { Link } from "react-router-dom";
import Navbar from "../components/organisms/Navbar";
import Footer from "../components/organisms/Footer";
import FormularioFicha from "../components/organisms/FormularioFicha";
import "../pages/Style.css";

function Ficha(){
    return(
        <>
        <Navbar/>
        <div className="container my-5">
            <div className="ficha-container">
                <FormularioFicha/>
            </div>
            <div className="text-center mt-3">
                <Link to="/" className="btn boton-opcion">Volver a la Pagina Principal</Link>
            </div>
        </div>
        <Footer/>
        </>
    );
}

export default Ficha;