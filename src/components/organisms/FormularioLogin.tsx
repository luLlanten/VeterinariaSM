import React, {useState} from "react";
import CampoInput from "../molecules/CampoInput";
import { Link, Links, Route, Router, useRouteLoaderData } from "react-router-dom";
import Principal from "../../pages/Principal";



function FormularioLogin(){
    const[correo, setCorreo] = useState("");
    const[contrasena, setContrasena] = useState("");
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

        if (!formatoNormal.test(correo)&&!formatoAdmin.test(correo)){
            alert("Ingrese Un Correo Valido")
            return;
        }else{if(formatoAdmin.test(correo)){
                window.location.href="/admin"}
            else{
                if(formatoNormal.test(correo)){
                window.location.href="/"
            }
            }
        }
    }

    return(
        <form onSubmit={Login} noValidate>
            <CampoInput
            etiqueta="Correo"
            tipo="text"
            nombre="correo"
            valor={correo}
            alCambiar={setCorreo}
            />
            <CampoInput
            etiqueta="Contrasena"
            tipo="text"
            nombre="contrasena"
            valor={contrasena}
            alCambiar={setContrasena}
            />
            <button type="submit" className="btn btn-primary">
                Iniciar Sesion
            </button>
            

        </form>

    );
}

export default FormularioLogin;