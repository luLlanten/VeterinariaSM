import Footer from "../components/organisms/Footer";
import FormularioCitas from "../components/organisms/FormularioCitas";
import Navbar from "../components/organisms/Navbar";

function Citas(){
    return(
        <>
        <div style={{ backgroundColor: "#f5f3ea", minHeight: "100vh", display: "flex", flexDirection: "column" }}>
            <Navbar/>
            <div style={{ flex: 1 }}>
                <section className="tarjeta-opcion" style={{ width: "50%", backgroundColor: "#223526", marginLeft: "25%", marginBottom: "5%", marginTop: "4%" }}>
                    <div style={{ marginLeft: "15%", marginRight: "15%" }}>
                        <h2 className="mb-3" style={{ color: "whitesmoke" }}>Agendar Cita</h2>
                        <FormularioCitas/>
                    </div>
                </section>
            </div>
            <Footer/>
        </div>
        </>
    );
}

export default Citas;