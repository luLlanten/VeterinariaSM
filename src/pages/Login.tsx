import Footer from "../components/organisms/Footer";
import FormularioLogin from "../components/organisms/FormularioLogin"
import Navbar from "../components/organisms/Navbar";

function Login(){
    return(
        <>
        <Navbar/>
        <div style={{backgroundImage: "url('/images/perrologin.jpg')", backgroundSize:" cover", backgroundPosition: "center", backgroundRepeat: "no-repeat", minHeight: "100vh"}}>
        <section className="tarjeta-opcion" style={{width:"50%",backgroundColor:" #223526",marginLeft:"25%",marginBottom:"10%" ,marginTop:"10%"}}>
            <div style={{marginLeft:"15%",marginRight:"15%"}}>
                <h2 className="mb-4">Inicio de Sesión</h2>
                <FormularioLogin/>
            </div>
       </section>
       </div>
       <Footer/>
       </>
    )
}
export default Login;