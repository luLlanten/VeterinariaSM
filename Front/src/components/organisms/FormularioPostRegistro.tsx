import React, {useState} from "react";
import CampoInput from "../molecules/CampoInput";
import { Link } from "react-router-dom";

function FormularioPostRegistro(){
    const[nombre, setNombre]= useState("")
    const[apellido,setApellido]=useState("")
    const[direccion,setDireccion]=useState("")
    const[telefono,setTelefono]=useState("")
    const[creada, setCreada] = useState(false);
    const fromatoNombre=/^[a-zA-Z]$/
    const formatoTelefono=/^[0-9]{8}$/

    const RegistroPost=(e:React.SubmitEvent<HTMLFormElement>)=>{
        e.preventDefault()
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
        alert("Datos ingresados con exito");
        setCreada(true)
        
    }

    return(
        <form onSubmit={RegistroPost} noValidate>
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
                <Link to="/" style={{borderWidth: "0cap",backgroundColor: "rgb(24, 80, 43)",color: "white",borderRadius: "10%"}}>
                    Ir al inicio
                </Link>
            )}
        </form>

    )
}
export default FormularioPostRegistro