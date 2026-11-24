import React, {useState, type FormEvent} from "react";
import CampoInput from "../molecules/CampoInput";
import { Link } from "react-router-dom";



function FormularioRegistro(){
    const[correo, setCorreo] = useState("");
    const[contrasena, setContrasena] = useState("");
    const[contrasena2, setContrasena2] = useState("");
    const[creada, setCreada] = useState(false);
    const[nombre, setNombre]= useState("")
    const[apellido,setApellido]=useState("")
    const[direccion,setDireccion]=useState("")
    const[telefono,setTelefono]=useState("")
    const [enviando, setEnviando] = useState(false);
    const formatoCorreo =/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/
    const fromatoNombre=/^[a-zA-Z]{1,20}$/
    const formatoTelefono=/^[0-9]{8}$/


    const Registro = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        if (enviando) return;
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
        if(nombre.trim()===""){
            alert("Ingrese un nombre")
            return
        }
        if(!fromatoNombre.test(nombre)){
            alert("Ingrese un nombre valido")
            return
        }
        if(apellido.trim()===""){
            alert("Ingrese un apellido")
            return
        }
        if(!fromatoNombre.test(apellido)){
            alert("Ingrese un apellido valido")
            return
        }
        if(direccion.trim()===""){
            alert("Ingrese una direccion valida")
            return
        }
        if(telefono.trim()===""){
            alert("Ingrese un numero de telefono")
            return
        }
        if(!formatoTelefono.test(telefono)){
            alert("Ingrese un numero valido")
            return
        }
        
        setEnviando(true);
        try {
            const respuesta = await fetch(
                "/lobby/registro?v=true"
                , {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
            correo: correo.trim(),
            contrasena: contrasena2.trim(),
            nombre:nombre.trim(),
            apellido:apellido.trim(),
            direccion:direccion.trim(),
            telefono:Number(telefono)
        }),
        });
        if (!respuesta.ok) {
            throw new Error(`Error HTTP ${respuesta.status}`);
        }
        } catch (error) {
            console.error("Error al crear cuenta ", error);
            alert("Intente nuevamente");
            return;
        }finally {
        setEnviando(false);
        }

        localStorage.setItem("datosUsuario", JSON.stringify({
            correo: correo.trim(),
            contrasena: contrasena2.trim(),
            nombre: nombre.trim(),
            apellido: apellido.trim(),
            direccion: direccion.trim(),
            telefono: telefono.trim()
        }));
        
        alert("Datos ingresados con exito");
        setCreada(true)
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
            etiqueta="Direccion"
            tipo="text"
            nombre="direccion"
            valor={direccion}
            alCambiar={setDireccion}
            />
            <CampoInput
            etiqueta="Telefono"
            tipo="text"
            nombre="telefono"
            valor={telefono}
            alCambiar={setTelefono}
            />
            <button type="submit" style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%"}}>
                Crear Cuenta
            </button>
            {creada && (
                <Link to="/login" style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%", marginLeft:"10%", textDecoration:"none"}}>
                    Ir al inicio de sesion
                </Link>
            )}
        </form>
    );
}

export default FormularioRegistro;