import Footer from "../components/organisms/Footer";
import FormularioNuevaContrasena from "../components/organisms/FormularioNuevaContrasena";
import Navbar from "../components/organisms/Navbar";

function CambiarContrasena(){
    return(
        <> 
        <div style={{backgroundImage: "url('/images/perrologin.jpg')", backgroundSize:"cover", backgroundPosition: "center", backgroundRepeat: "no-repeat", minHeight: "100vh"}}>
        <Navbar/>
        <section className="tarjeta-opcion" style={{width:"50%",backgroundColor:" #223526",marginLeft:"25%",marginBottom:"6%" ,marginTop:"6%"}}>
            <div style={{marginLeft:"15%",marginRight:"15%"}}>
                <h2 className="mb-3" style={{color:"whitesmoke"}}>Crear Nueva Contraseña</h2>
                <FormularioNuevaContrasena/>
            </div>
       </section>
       <Footer/>
       </div>
       </>
    )
}
export default CambiarContrasena;