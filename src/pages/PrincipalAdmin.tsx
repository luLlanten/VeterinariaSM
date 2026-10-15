import Footer from "../components/organisms/Footer"
import Navbar from "../components/organisms/Navbar"

function PrincipalAdmin(){
    return(
        <>
        <Navbar/>
            <div style={{marginLeft: "20px", marginTop: "10px"}}>
                <h1 style={{fontWeight: "bolder"}}>Administración</h1>
                <br/>
                <p>Ha iniciado sesión en una cuenta de administrador.</p>
                <p>Bajo este parrafo podrá encotrar las opciones y vistas de administración que necesite</p>
            </div>
                <br/><br/>
                <div className="contenedores">
                    <a href="modificaciones.html" className="linkeado">
                    <section className="contenedor">
                        <h3 style={{fontWeight:" bold"}}>Inventario</h3>
                        <p>
                            Aqui puedes observar un detalle 
                            resumido del stock disponible en 
                            el inventario, puedes usar sus datos 
                            para añadir cualquier producto al
                            catalogo.
                        </p>
                    </section>
                    </a>
                    <a className="linkeado" onClick={()=>alert('Opcion no disponible temporalmente')}>
                    <section className="contenedor">
                        <h3 style={{fontWeight: "bold"}}>Balance</h3>
                        <p>
                            Aqui encontraras un resumen de los ultimos pagos 
                            hechos por los clientes 
                        </p>
                    </section>
                    </a>
                    <a className="linkeado" onClick={()=>alert('Opcion no disponible temporalmente')}>
                    <section className="contenedor">
                        <h3 style={{fontWeight: "bold"}}>Fichas</h3>
                        <p>
                            Aqui tendras acceso a las fichas medicas
                            de los pacientes, podras analizarlos y Modificarlos
                        </p>
                    </section>
                    </a>
                </div>
            <br/><br/>
            <div className="contenedor">
                <h2 style={{fontWeight: "bold"}}>Lista de Usuarios</h2>
                <hr/>
                <table style={{width: "100%",borderCollapse: "collapse"}}>
                    <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Rol</th>
                    </tr>
                    </thead>
                    <tbody id="tablaUsuarios">
                    </tbody>
                </table>
            </div>
            <Footer/>
        </>
    )
}
export default PrincipalAdmin