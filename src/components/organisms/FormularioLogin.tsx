import React, {useState} from "react";
import CampoInput from "../molecules/CampoInput";



function FormularioLogin(){
    const[correo, setCorreo] = useState("");
    const[contrasena, setContrasena] = useState("");

    const Login = (e: React.SubmitEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/.test(correo)){
            alert("Ingrese Un Correo Valido")
            return;
        }
        if (contrasena.trim() === ""){
            alert("Debe Ingresar Una Contraseña");
            return;
        }
        alert("Bienvenidos a la Veterinaria San Marcos")
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