import React, {useState} from "react";
import LineaFicha from "../molecules/LineaFicha";

function FormularioFicha(){

    const[medicamento, setMedicamento] = useState("");
    const[propietario, setPropietario] = useState("");
    const[telefono, setTelefono] = useState("");
    const[direccion, setDireccion] = useState("");
    const[especie, setEspecie] = useState("");
    const[identificacion, setIdentificacion] = useState("");
    const[sexo, setSexo] = useState("M");
    const[raza, setRaza] = useState("");
    const[antecedentes, setAntecedentes] = useState("");

    const guardar = (e: React.SubmitEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (medicamento.trim() === ""){
            alert("Debe Ingresar El Medicamento");
            return;
        }
        if (propietario.trim() === ""){
            alert("Debe Ingresar El Propietario");
            return;
        }
        if (telefono.trim() === ""){
            alert("Debe Ingresar El Telefono");
            return;
        }
        if (!/^[0-9]{8,}$/.test(telefono)){
            alert("Ingrese Un Telefono Valido");
            return;
        }
        if (direccion.trim() === ""){
            alert("Debe Ingresar La Direccion");
            return;
        }
        if (especie.trim() === ""){
            alert("Debe Ingresar La Especie");
            return;
        }
        if (identificacion.trim() === ""){
            alert("Debe Ingresar La Identificacion");
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
        if (antecedentes.trim() === ""){
            alert("Debe Ingresar Los Antecedentes");
            return;
        }
        alert("Ficha guardada con exito");
    }

    return(
        <form className="ficha" onSubmit={guardar} noValidate>
            <LineaFicha
            etiqueta="Medicamento:"
            tipo="text"
            nombre="medicamento"
            valor={medicamento}
            alCambiar={setMedicamento}
            />
            <LineaFicha
            etiqueta="Propietario:"
            tipo="text"
            nombre="propietario"
            valor={propietario}
            alCambiar={setPropietario}
            />
            <LineaFicha
            etiqueta="Teléfono:"
            tipo="text"
            nombre="telefono"
            valor={telefono}
            alCambiar={setTelefono}
            />
            <LineaFicha
            etiqueta="Dirección:"
            tipo="text"
            nombre="direccion"
            valor={direccion}
            alCambiar={setDireccion}
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

            <div className="titulo_seccion">
                Antecedentes
                <span style={{fontWeight:"normal", textDecoration:"none"}}>
                    {" "}(desparasitaciones, vacunaciones, patologías anteriores, etc)
                </span>
            </div>
            <textarea
            className="textarea-clean"
            rows={3}
            value={antecedentes}
            onChange={(e) => setAntecedentes(e.target.value)}
            />

            <div className="d-flex flex-wrap gap-2 mt-3">
                <button type="button" className="btn btn-primary" onClick={() => window.print()}>
                    Imprimir Ficha
                </button>
                <button type="submit" className="btn btn-primary">
                    Guardar Ficha
                </button>
            </div>
        </form>
    );
}

export default FormularioFicha;