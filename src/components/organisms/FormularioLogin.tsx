import React, {useState} from "react";
import CampoInput from "../molecules/CampoInput";
import { Link } from "react-router-dom";


function FormularioLogin(){
    const[correo, setCorreo] = useState("");
    const[contrasena, setContrasena] = useState("");
    const[ruta, setRuta] = useState("");
    const formatoNormal =/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/
    const formatoAdmin=/^[a-zA-Z0-9._-]+@+sanmarcos+\.+cl$/

    const Login = (e: React.SubmitEvent<HTMLFormElement>) => {
        e.preventDefault();


        if (correo.trim() === ""){
            alert("Debe Ingresar Su Correo");
            return;
        }
        if (contrasena.trim() === ""){
            alert("Debe Ingresar Una Contraseña");
            return;
        }
         if (formatoAdmin.test(correo)){
            alert("Ingreso correcto");
            setRuta("/admin");
            return;
        }
        if (formatoNormal.test(correo)){
            alert("Ingreso correcto");
            setRuta("/");
            return;
        }
        alert("Ingrese Un Correo Valido");
    }
        

    return(
        <form onSubmit={Login} noValidate>
            <CampoInput
            etiqueta="Correo"
            tipo="password"
            nombre="correo"
            valor={correo}
            alCambiar={setCorreo}
            />
            <CampoInput
            etiqueta="Contrasena"
            tipo="password"
            nombre="contrasena"
            valor={contrasena}
            alCambiar={setContrasena}
            />
            <button type="submit" style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%"}}>
                Iniciar Sesion
            </button>
             {ruta !== "" && (
                <Link to={"/"} style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%"}}>
                    Continuar
                </Link>
             )}
            

        </form>

    );
}

export default FormularioLogin;