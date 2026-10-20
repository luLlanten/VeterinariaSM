import { useParams } from "react-router-dom";
import Navbar from "../components/organisms/Navbar";
import BotonVolverCatalogo from "../components/atoms/BotonVolverCatologo";
import { servicios } from "../data/servicios";
import Footer from "../components/organisms/Footer";

function Detalle(){
    return(
        <>
        <Navbar/>

        <Footer/>
        </>
    );
}

export default Detalle;