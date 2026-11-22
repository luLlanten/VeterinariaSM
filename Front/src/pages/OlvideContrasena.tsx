import Footer from "../components/organisms/Footer";
import FormularioContrasena from "../components/organisms/FormularioContrasena";
import Navbar from "../components/organisms/Navbar";

function OlvideContrasena(){
    return(
        <> 
        <div style={{backgroundImage: "url('/images/perrologin.jpg')", backgroundSize:"cover", backgroundPosition: "center", backgroundRepeat: "no-repeat", minHeight: "100vh"}}>
        <Navbar/>
        <section className="tarjeta-opcion" style={{width:"50%",backgroundColor:" #223526",marginLeft:"25%",marginBottom:"4%" ,marginTop:"4%"}}>
            <div style={{marginLeft:"15%",marginRight:"15%"}}>
                <h2 className="mb-3" style={{color:"whitesmoke"}}>Recuperar Contraseña</h2>
                <FormularioContrasena/>
            </div>
       </section>
       <Footer/>
       </div>
       </>
    )
}
export default OlvideContrasena;