import React, {useState} from "react";
import LineaFicha from "../molecules/LineaFicha";

function FormularioNecropsia(){

    const[fechaNecropsia, setFechaNecropsia] = useState("");
    const[veterinario, setVeterinario] = useState("");
    const[propietario, setPropietario] = useState("");
    const[telefonoProp, setTelefonoProp] = useState("");
    const[especie, setEspecie] = useState("");
    const[identificacion, setIdentificacion] = useState("");
    const[sexo, setSexo] = useState("M");
    const[raza, setRaza] = useState("");
    const[edad, setEdad] = useState("");
    const[peso, setPeso] = useState("");
    const[antecedentes, setAntecedentes] = useState("");
    const[hallazgos, setHallazgos] = useState("");

    const guardar = (e: React.SubmitEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (fechaNecropsia.trim() === ""){
            alert("Debe Ingresar La Fecha De Necropsia");
            return;
        }
        if (veterinario.trim() === ""){
            alert("Debe Ingresar El Veterinario");
            return;
        }
        if (propietario.trim() === ""){
            alert("Debe Ingresar El Propietario");
            return;
        }
        if (telefonoProp.trim() === ""){
            alert("Debe Ingresar El Teléfono Del Propietario");
            return;
        }
        if (!/^[0-9]{8,}$/.test(telefonoProp)){
            alert("Ingrese Un Teléfono Válido Para El Propietario");
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
        if (sexo.trim() === ""){
            alert("Debe Ingresar El Sexo");
            return;
        }
        if (raza.trim() === ""){
            alert("Debe Ingresar La Raza");
            return;
        }
        if (edad.trim() === ""){
            alert("Debe Ingresar La Edad Estimada");
            return;
        }
        if (peso.trim() === ""){
            alert("Debe Ingresar El Peso");
            return;
        }
        if (!/^[0-9]+([.,][0-9]+)?$/.test(peso)){
            alert("Ingrese Un Peso Válido");
            return;
        }
        if (antecedentes.trim() === ""){
            alert("Debe Ingresar Los Antecedentes");
            return;
        }
        if (hallazgos.trim() === ""){
            alert("Debe Ingresar Los Hallazgos");
            return;
        }
        if (!window.confirm("¿Deseas guardar la ficha de necropsia?")){
            return;
        }
        alert("Ficha guardada con éxito");
    }

    return(
        <form onSubmit={guardar} noValidate>

            <div className="necropsia-hoja">
                <div className="necropsia-membrete">
                    <div>
                        <h1>Veterinaria San Marcos</h1>
                        <p>Clínica y hospital veterinario</p>
                    </div>
                </div>
                <div className="necropsia-titulo">Protocolo de necropsia</div>

                <div className="row justify-content-end">
                    <div className="col-12 col-md-6">
                        <LineaFicha
                    etiqueta="Fecha necropsia:"
                    tipo="date"
                    nombre="fechaNecropsia"
                    valor={fechaNecropsia}
                    alCambiar={setFechaNecropsia}
                    />
                    </div>
                </div>

                <div className="necropsia-seccion">Datos del veterinario</div>
                <LineaFicha
                    etiqueta="Veterinario:"
                    tipo="text"
                    nombre="veterinario"
                    valor={veterinario}
                    alCambiar={setVeterinario}
                    />

                <div className="necropsia-seccion">Datos del propietario</div>
                <div className="row">
                    <div className="col-12 col-md-7">
                        <LineaFicha
                    etiqueta="Propietario:"
                    tipo="text"
                    nombre="propietario"
                    valor={propietario}
                    alCambiar={setPropietario}
                    />
                    </div>
                    <div className="col-12 col-md-5">
                        <LineaFicha
                    etiqueta="Teléfono:"
                    tipo="text"
                    nombre="telefonoProp"
                    valor={telefonoProp}
                    alCambiar={setTelefonoProp}
                    />
                    </div>
                </div>

                <div className="necropsia-seccion">Datos del animal</div>
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
                <div className="row">
                    <div className="col-12 col-md-4">
                        <div className="lineas_escritura">
                            <label>Sexo:</label>
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
                    etiqueta="Edad estimada:"
                    tipo="text"
                    nombre="edad"
                    valor={edad}
                    alCambiar={setEdad}
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

                <div className="necropsia-seccion">Antecedentes</div>
                <p className="necropsia-etiqueta">Desparasitaciones, vacunaciones, patologías anteriores, etc.</p>
                <textarea
                className="necropsia-texto"
                rows={3}
                value={antecedentes}
                onChange={(e) => setAntecedentes(e.target.value)}
                />

                <div className="necropsia-seccion">Hallazgos de la necropsia</div>
                <p className="necropsia-etiqueta">Descripción general de lo observado:</p>
                <textarea
                className="necropsia-texto"
                rows={6}
                value={hallazgos}
                onChange={(e) => setHallazgos(e.target.value)}
                />

                <div className="necropsia-firma">
                    <div>Firma del veterinario</div>
                    <div>Timbre</div>
                </div>
            </div>

            <div className="necropsia-acciones">
                <button type="button" className="admin-btn admin-btn-claro" onClick={() => window.print()}>
                    Imprimir Ficha
                </button>
                <button type="submit" className="admin-btn">
                    Guardar Ficha
                </button>
            </div>
        </form>
    );
}

export default FormularioNecropsia;