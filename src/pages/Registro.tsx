import Footer from "../components/organisms/Footer";
import FormularioRegistro from "../components/organisms/FormularioRegistro"
import Navbar from "../components/organisms/Navbar";

function Registro(){
    return(
        <>
        <Navbar/>
        <div style={{backgroundImage: "url('/images/perrologin.jpg')", backgroundSize:" cover", backgroundPosition: "center", backgroundRepeat: "no-repeat", minHeight: "100vh"}}>
        <section className="tarjeta-opcion" style={{width:"50%",backgroundColor:" #223526",marginLeft:"25%",marginBottom:"10%" ,marginTop:"10%"}}>
            <div style={{marginLeft:"15%",marginRight:"15%"}}>
                <h2 className="mb-4">Crear Cuenta</h2>
                <FormularioRegistro/>
            </div>
       </section>
       </div>
       <Footer/>
       </>
    )
}
export default Registro;