import { useState, useEffect } from "react";
import CampoInput from "../molecules/CampoInput";
import { Link } from "react-router-dom";
import type { SubmitEvent } from "react";

function FormularioPerfilUser(){
    const [nombre, setNombre] = useState("");
    const [apellido, setApellido] = useState("");
    const [telefono, setTelefono] = useState("");
    const [correo, setCorreo] = useState("");
    const [contrasena, setContrasena] = useState("");
    const [ruta, setRuta] = useState("");
    const [enviando, setEnviando] = useState(false);

    const formatoNormal = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

    useEffect(() => {
        const datos = JSON.parse(localStorage.getItem("datosUsuario") || "{}");
        setNombre(datos.nombre || "");
        setApellido(datos.apellido || "");
        setTelefono(datos.telefono || "");
        setCorreo(datos.correo || localStorage.getItem("correoUsuario") || "");
        setContrasena(datos.contrasena || "");
    }, []);

    const Modificar = async (e: SubmitEvent<HTMLFormElement>) => {
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
        if (contrasena.trim() === ""){
            alert("Debe Ingresar Su Contraseña");
            return;
        }
        if (!formatoNormal.test(correo)){
            alert("Ingrese Un Correo Valido");
            return;
        }

        setEnviando(true);
        const datosAnteriores = JSON.parse(localStorage.getItem("datosUsuario") || "{}");
        localStorage.setItem("correoUsuario", correo.trim());
        localStorage.setItem("datosUsuario", JSON.stringify({
            ...datosAnteriores,
            nombre: nombre.trim(),
            apellido: apellido.trim(),
            telefono: telefono.trim(),
            correo: correo.trim(),
            contrasena: contrasena.trim(),
            modificado: true
        }));
        alert("Perfil actualizado correctamente");
        setRuta("/");
        setEnviando(false);
    }

    return(
        <form onSubmit={Modificar} noValidate>
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
            <CampoInput
                etiqueta="Nueva Contraseña"
                tipo="password"
                nombre="contrasena"
                valor={contrasena}
                alCambiar={setContrasena}
            />

            <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", width: "100%", marginTop: "15px" }}>
                <div>
                    <button type="submit" disabled={enviando} style={{ borderWidth: "0cap", backgroundColor: "rgb(24, 80, 43)", color: "white", borderRadius: "10%", padding: "4px 10px" }}>
                        {enviando ? "Guardando" : "Guardar Cambios"}
                    </button>
                    {ruta !== "" && (
                        <Link to={ruta} style={{ borderWidth: "0cap", backgroundColor: "rgb(24, 80, 43)", color: "white", borderRadius: "10%", padding: "4px 10px", textDecoration: "none", display: "inline-block", marginLeft: "8px" }}>
                            siguiente
                        </Link>
                    )}
                </div>
                <Link to="/" style={{ borderWidth: "0cap", backgroundColor: "rgb(24, 80, 43)", color: "white", borderRadius: "10%", padding: "4px 10px", textDecoration: "none", display: "inline-block" }}>
                    Volver
                </Link>
            </div>
        </form>
    );
}

export default FormularioPerfilUser;