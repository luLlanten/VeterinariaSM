import {useState} from "react";
import CampoInput from "../molecules/CampoInput";
import { Link } from "react-router-dom";
import type { SubmitEvent } from "react";

function FormularioContrasena(){
    const[nombre, setNombre] = useState("");
    const[apellido, setApellido] = useState("");
    const[telefono, setTelefono] = useState("");
    const[correo, setCorreo] = useState("");
    const[ruta, setRuta] = useState("");
    const formatoNormal =/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/
    const formatoAdmin=/^[a-zA-Z0-9._-]+@+sanmarcos+\.+cl$/
    const [enviando, setEnviando] =useState(false);

    const Recuperar = async (e: SubmitEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (enviando) return;

        if (nombre.trim() === ""){
            alert("Debe Ingresar Su Nombre");
            return;
        }
        if (apellido.trim() === ""){
            alert("Debe Ingresar Su Apellido");
            return;
        }
        if (telefono.trim() === ""){
            alert("Debe Ingresar Su Telefono");
            return;
        }
        if (correo.trim() === ""){
            alert("Debe Ingresar Su Correo");
            return;
        }
        if (formatoAdmin.test(correo)){
            setEnviando(true);
            alert("Datos verificados");
            setRuta("/cambiar-contrasena");
            setEnviando(false);
            return;
        }
        if (formatoNormal.test(correo)){
            setEnviando(true);
            alert("Datos verificados");
            setRuta("/cambiar-contrasena");
            setEnviando(false);
            return;
        }
        alert("Ingrese Un Correo Valido");
    }
        

    return(
        <form onSubmit={Recuperar} noValidate>
            <CampoInput
            etiqueta="Nombre"
            tipo="text"
            nombre="nombre"
            valor={nombre}
            alCambiar={setNombre}
            />
            <CampoInput
            etiqueta="Apellido"
            tipo="text"
            nombre="apellido"
            valor={apellido}
            alCambiar={setApellido}
            />
            <CampoInput
            etiqueta="Telefono"
            tipo="text"
            nombre="telefono"
            valor={telefono}
            alCambiar={setTelefono}
            />
            <CampoInput
            etiqueta="Correo"
            tipo="text"
            nombre="correo"
            valor={correo}
            alCambiar={setCorreo}
            />
            <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", width: "100%", marginTop: "15px" }}>
                <div>
                    <button type="submit" disabled={enviando} style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%", padding: "4px 10px"}}>
                        {enviando ? "Verificando":"Verificar" }
                    </button>
                    {ruta !== "" && (
                        <Link to={ruta} style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%", padding: "4px 10px", textDecoration: "none", display: "inline-block", marginLeft: "8px"}}>
                            siguiente
                        </Link>
                    )}
                </div>
                <Link to="/login" style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%", padding: "4px 10px", textDecoration: "none", display: "inline-block"}}>
                    Volver
                </Link>
            </div>
        </form>
    );
}

export default FormularioContrasena;