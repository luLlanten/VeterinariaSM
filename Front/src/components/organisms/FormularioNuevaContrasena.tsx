import {useState} from "react";
import CampoInput from "../molecules/CampoInput";
import { Link } from "react-router-dom";
import type { SubmitEvent } from "react";

function FormularioNuevaContrasena(){
    const[correo, setCorreo] = useState("");
    const[nuevaContrasena, setNuevaContrasena] = useState("");
    const[confirmarContrasena, setConfirmarContrasena] = useState("");
    const[ruta, setRuta] = useState("");
    const formatoNormal =/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/
    const formatoAdmin=/^[a-zA-Z0-9._-]+@+sanmarcos+\.+cl$/
    const [enviando, setEnviando] =useState(false);

    const Cambiar = async (e: SubmitEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (enviando) return;

        if (correo.trim() === ""){
            alert("Debe Ingresar Su Correo");
            return;
        }
        if (nuevaContrasena.trim() === ""){
            alert("Debe Ingresar Su Nueva Contraseña");
            return;
        }
        if (confirmarContrasena.trim() === ""){
            alert("Debe Confirmar Su Nueva Contraseña");
            return;
        }
        if (nuevaContrasena !== confirmarContrasena){
            alert("Las Contraseñas No Coinciden");
            return;
        }
        if (formatoAdmin.test(correo)){
            setEnviando(true);
            alert("Contraseña actualizada");
            setRuta("/login");
            setEnviando(false);
            return;
        }
        if (formatoNormal.test(correo)){
            setEnviando(true);
            alert("Contraseña actualizada");
            setRuta("/login");
            setEnviando(false);
            return;
        }
        alert("Ingrese Un Correo Valido");
    }
        

    return(
        <form onSubmit={Cambiar} noValidate>
            <CampoInput
            etiqueta="Correo"
            tipo="text"
            nombre="correo"
            valor={correo}
            alCambiar={setCorreo}
            />
            <CampoInput
            etiqueta="Nueva Contrasena"
            tipo="password"
            nombre="nuevaContrasena"
            valor={nuevaContrasena}
            alCambiar={setNuevaContrasena}
            />
            <CampoInput
            etiqueta="Confirmar Nueva Contrasena"
            tipo="password"
            nombre="confirmarContrasena"
            valor={confirmarContrasena}
            alCambiar={setConfirmarContrasena}
            />
            <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", width: "100%", marginTop: "15px" }}>
                <div>
                    <button type="submit" disabled={enviando} style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%", padding: "4px 10px"}}>
                        {enviando ? "Cambiando":"Cambiar" }
                    </button>
                    {ruta !== "" && (
                        <Link to={ruta} style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%", padding: "4px 10px", textDecoration: "none", display: "inline-block", marginLeft: "8px"}}>
                            siguiente
                        </Link>
                    )}
                </div>
                <Link to="/olvide-contrasena" style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%", padding: "4px 10px", textDecoration: "none", display: "inline-block"}}>
                    Volver
                </Link>
            </div>
        </form>
    );
}

export default FormularioNuevaContrasena;