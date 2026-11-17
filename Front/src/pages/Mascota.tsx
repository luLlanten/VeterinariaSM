import { Link } from "react-router-dom";
import Navbar from "../components/organisms/Navbar";
import Footer from "../components/organisms/Footer";
import FormularioMascota from "../components/organisms/FormularioMascota";
import "../pages/Principal.css";

function Mascota(){
    return(
        <>
        <Navbar/>
        <div className="container my-5">
            <div className="ficha-container">
                <FormularioMascota/>
            </div>
            <div className="text-center mt-3">
                <Link to="/ficha" className="boton-opcion2">Volver a la Ficha</Link>
            </div>
        </div>
        <Footer/>
        </>
    );
}

export default Mascota;