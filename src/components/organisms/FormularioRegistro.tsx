import React, {useState} from "react";
import CampoInput from "../molecules/CampoInput";
import { Link } from "react-router-dom";



function FormularioRegistro(){
    const[correo, setCorreo] = useState("");
    const[contrasena, setContrasena] = useState("");
    const[contrasena2, setContrasena2] = useState("");
    const[creada, setCreada] = useState(false);
    const formatoCorreo =/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/



    const Registro = (e: React.SubmitEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (correo.trim() === ""){
            alert("Debe Ingresar Su Correo");
            return;
        }
        if (!formatoCorreo.test(correo)){
            alert("Ingrese Un Correo Valido");
            return;
        }
        if (contrasena.trim() === ""){
            alert("Debe Ingresar Una Contraseña");
            return;
        }
        if (contrasena.length < 8){
            alert("La contraseña debe tener al menos 8 caracteres");
            return;
        }
        if (contrasena !== contrasena2){
            alert("Las contraseñas no coinciden");
            return;
        }
        alert("Cuenta creada con éxito");
        setCreada(true);
    }



    return(
        <form onSubmit={Registro} noValidate>
            <CampoInput
            etiqueta="Correo"
            tipo="text"
            nombre="correo"
            valor={correo}
            alCambiar={setCorreo}
            />
            <CampoInput
            etiqueta="Contraseña"
            tipo="password"
            nombre="contrasena"
            valor={contrasena}
            alCambiar={setContrasena}
            />
            <CampoInput
            etiqueta="Confirmar contraseña"
            tipo="password"
            nombre="contrasena2"
            valor={contrasena2}
            alCambiar={setContrasena2}
            />
            <button type="submit" className="btn btn-primary">
                Crear Cuenta
            </button>
            {creada && (
                <Link to="/" className="btn btn-primary ms-2">
                    Ir al inicio
                </Link>
            )}
        </form>
    );
}

export default FormularioRegistro;