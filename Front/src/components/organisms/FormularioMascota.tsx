import React, {useState} from "react";
import LineaFicha from "../molecules/LineaFicha";

function FormularioMascota(){

    const[numeroFicha, setNumeroFicha] = useState("");
    const[nombre, setNombre] = useState("");
    const[especie, setEspecie] = useState("");
    const[identificacion, setIdentificacion] = useState("");
    const[sexo, setSexo] = useState("M");
    const[raza, setRaza] = useState("");
    const[fechaNacimiento, setFechaNacimiento] = useState("");
    const[peso, setPeso] = useState("");

    const guardar = (e: React.SubmitEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (numeroFicha.trim() === ""){
            alert("Debe Ingresar El N° De Ficha");
            return;
        }
        if (!/^[0-9]+$/.test(numeroFicha)){
            alert("El N° De Ficha Debe Contener Solo Números");
            return;
        }
        if (nombre.trim() === ""){
            alert("Debe Ingresar El Nombre De La Mascota");
            return;
        }
        if (especie.trim() === ""){
            alert("Debe Ingresar La Especie");
            return;
        }
        if (identificacion.trim() === ""){
            alert("Debe Ingresar La Identificación");
            return;
        }
        if (raza.trim() === ""){
            alert("Debe Ingresar La Raza");
            return;
        }
        if (fechaNacimiento.trim() === ""){
            alert("Debe Ingresar La Fecha De Nacimiento");
            return;
        }
        if (new Date(fechaNacimiento) > new Date()){
            alert("La Fecha De Nacimiento No Puede Ser Futura");
            return;
        }
        if (peso.trim() === ""){
            alert("Debe Ingresar El Peso");
            return;
        }
        if (!/^[0-9]+([.,][0-9]+)?$/.test(peso) || parseFloat(peso.replace(",", ".")) <= 0){
            alert("Ingrese Un Peso Válido");
            return;
        }
        if (!window.confirm("¿Deseas guardar la mascota?")){
            return;
        }
        alert("Mascota guardada con éxito");
    }

    return(
        <form className="ficha" onSubmit={guardar} noValidate>
            <div className="titulo_seccion">Ingreso de mascota</div>
            <LineaFicha
            etiqueta="N° de ficha:"
            tipo="text"
            nombre="numeroFicha"
            valor={numeroFicha}
            alCambiar={setNumeroFicha}
            />
            <LineaFicha
            etiqueta="Nombre:"
            tipo="text"
            nombre="nombre"
            valor={nombre}
            alCambiar={setNombre}
            />
            <div className="row">
                <div className="col-12 col-md-5">
                    <LineaFicha
                    etiqueta="Especie:"
                    tipo="text"
                    nombre="especie"
                    valor={especie}
                    alCambiar={setEspecie}
                    />
                </div>
                <div className="col-12 col-md-7">
                    <LineaFicha
                    etiqueta="Identificación:"
                    tipo="text"
                    nombre="identificacion"
                    valor={identificacion}
                    alCambiar={setIdentificacion}
                    />
                </div>
            </div>

            <div className="titulo_seccion">Características generales</div>
            <div className="row">
                <div className="col-12 col-md-4">
                    <div className="lineas_escritura">
                        <label>SEXO:</label>
                        <select
                        className="input-line"
                        value={sexo}
                        onChange={(e) => setSexo(e.target.value)}
                        >
                            <option value="M">M</option>
                            <option value="H">H</option>
                        </select>
                    </div>
                </div>
                <div className="col-12 col-md-8">
                    <LineaFicha
                    etiqueta="Raza:"
                    tipo="text"
                    nombre="raza"
                    valor={raza}
                    alCambiar={setRaza}
                    />
                </div>
            </div>
            <div className="row">
                <div className="col-12 col-md-6">
                    <LineaFicha
                    etiqueta="Fecha de nacimiento:"
                    tipo="date"
                    nombre="fechaNacimiento"
                    valor={fechaNacimiento}
                    alCambiar={setFechaNacimiento}
                    />
                </div>
                <div className="col-12 col-md-6">
                    <LineaFicha
                    etiqueta="Peso (Kg):"
                    tipo="text"
                    nombre="peso"
                    valor={peso}
                    alCambiar={setPeso}
                    />
                </div>
            </div>

            <div className="d-flex flex-wrap gap-3 mt-3">
                <button type="submit" className="boton-opcion2">
                    Guardar Mascota
                </button>
            </div>
        </form>
    );
}

export default FormularioMascota;