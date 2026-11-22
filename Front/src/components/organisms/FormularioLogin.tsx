import {useState} from "react";
import CampoInput from "../molecules/CampoInput";
import { Link } from "react-router-dom";
import type { SubmitEvent } from "react";

function FormularioLogin(){
    const[correo, setCorreo] = useState("");
    const[contrasena, setContrasena] = useState("");
    const[ruta, setRuta] = useState("");
    const formatoNormal =/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/
    const formatoAdmin=/^[a-zA-Z0-9._-]+@+sanmarcos+\.+cl$/
    const [enviando, setEnviando] =useState(false);
    interface DTO{
        v:Boolean
    }

    const Login = async (e: SubmitEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (enviando) return;

        if (correo.trim() === ""){
            alert("Debe Ingresar Su Correo");
            return;
        }
        if (contrasena.trim() === ""){
            alert("Debe Ingresar Una Contraseña");
            return;
        }
         if (formatoAdmin.test(correo)){
            setEnviando(true);
            try{
                const respuesta = await fetch(
                    "http://localhost:9090/lobby/login/admin",
                    {
                        body: JSON.stringify({
                        
                            correo: correo.trim(),
                            contrasena: contrasena.trim()
                            }),
                        headers: {'Content-Type':'application/json'}
                    }
                );
                if(!respuesta.ok){
                    throw new Error(`Error HTTP ${respuesta.status}`);
                }
                const dto=(await respuesta.json()) as DTO
                if(!dto){
                    alert("Contraseña incorrecta, intente otra vez")
                    return
                }
            }catch(error){
                console.error("Error al ingresar",error);
                alert("Intente ingresar nuevamente")
                setEnviando(false)
                return;
            }
            alert("Ingreso correcto");
            setRuta("/admin");
            return;
        }
        if (formatoNormal.test(correo)){
            setEnviando(true);
            try{
                const respuesta = await fetch(
                    "http://localhost:9090/lobby/login",
                    {
                        body: JSON.stringify({
                        
                            correo: correo.trim(),
                            contrasena: contrasena.trim()
                            }),
                        headers: {'Content-Type':'application/json'}
                    }
                );
                if(!respuesta.ok){
                    throw new Error(`Error HTTP ${respuesta.status}`);
                }
                const dto=(await respuesta.json()) as DTO
                if(!dto){
                    alert("Contraseña incorrecta, intente otra vez")
                    return
                }
                
            }catch(error){
                console.error("Error al ingresar",error);
                alert("Intente ingresar nuevamente")
                setEnviando(false)
                return;
            }
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
            tipo="text"
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
            <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", width: "100%", marginTop: "15px" }}>
                <div>
                    <button type="submit" disabled={enviando} style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%", padding: "4px 10px"}}>
                        {enviando ? "Ingresando":"Iniciar Sesion" }
                    </button>
                     {ruta !== "" && (
                        <Link to={ruta} style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%", padding: "4px 10px", textDecoration: "none", display: "inline-block", marginLeft: "8px"}}>
                            siguiente
                        </Link>
                     )}
                </div>
                <Link to="/recuperar-contrasena" style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%", padding: "4px 10px", textDecoration: "none", display: "inline-block"}}>
                    Olvidé mi contraseña
                </Link>
            </div>
            

        </form>

    );
}

export default FormularioLogin;