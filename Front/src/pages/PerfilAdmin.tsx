import AdminNavbar from "../components/organisms/AdminNavbar";
import Footer from "../components/organisms/Footer";
import FormularioPerfilAdmin from "../components/organisms/FormularioPerfilAdmin";

function PerfilAdmin(){
    return(
        <>
        <div style={{ backgroundImage: "url('/images/perrologin.jpg')", backgroundSize: "cover", backgroundPosition: "center", backgroundRepeat: "no-repeat", backgroundAttachment: "fixed", minHeight: "100vh" }}>
            <AdminNavbar/>
            <section className="tarjeta-opcion" style={{ width: "50%", backgroundColor: "#223526", marginLeft: "25%", marginBottom: "5%", marginTop: "4%" }}>
                <div style={{ marginLeft: "15%", marginRight: "15%" }}>
                    <h2 className="mb-3" style={{ color: "whitesmoke" }}>Modificar Perfil Administrador</h2>
                    <FormularioPerfilAdmin/>
                </div>
            </section>
            <Footer/>
        </div>
        </>
    );
}

export default PerfilAdmin;