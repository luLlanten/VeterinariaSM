import Footer from "../components/organisms/Footer";
import FormularioPerfilUser from "../components/organisms/FormularioPerfilUser";
import Navbar from "../components/organisms/Navbar";

function PerfilUser(){
    return(
        <>
        <div style={{ backgroundImage: "url('/images/perrologin.jpg')", backgroundSize: "cover", backgroundPosition: "center", backgroundRepeat: "no-repeat", backgroundAttachment: "fixed", minHeight: "100vh" }}>
            <Navbar/>
            <section className="tarjeta-opcion" style={{ width: "50%", backgroundColor: "#223526", marginLeft: "25%", marginBottom: "5%", marginTop: "4%" }}>
                <div style={{ marginLeft: "15%", marginRight: "15%" }}>
                    <h2 className="mb-3" style={{ color: "whitesmoke" }}>Modificar Perfil</h2>
                    <FormularioPerfilUser/>
                </div>
            </section>
            <Footer/>
        </div>
        </>
    );
}

export default PerfilUser;