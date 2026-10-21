import React, {useState} from "react";
import LineaFicha from "../molecules/LineaFicha";

function FormularioNecropsia(){

    const[fechaNecropsia, setFechaNecropsia] = useState("");
    const[veterinario, setVeterinario] = useState("");
    const[telefonoVet, setTelefonoVet] = useState("");
    const[propietario, setPropietario] = useState("");
    const[telefonoProp, setTelefonoProp] = useState("");
    const[direccion, setDireccion] = useState("");
    const[especie, setEspecie] = useState("");
    const[identificacion, setIdentificacion] = useState("");
    const[sexo, setSexo] = useState("M");
    const[raza, setRaza] = useState("");
    const[fechaNacimiento, setFechaNacimiento] = useState("");
    const[edad, setEdad] = useState("");
    const[peso, setPeso] = useState("");
    const[condicion, setCondicion] = useState("");
    const[descomposicion, setDescomposicion] = useState("");
    const[antecedentes, setAntecedentes] = useState("");
    const[piel, setPiel] = useState("");
    const[aberturas, setAberturas] = useState("");
    const[respiratorio, setRespiratorio] = useState("");
    const[cardiovascular, setCardiovascular] = useState("");
    const[digestivo, setDigestivo] = useState("");
    const[reproductor, setReproductor] = useState("");
    const[urinario, setUrinario] = useState("");
    const[inmunitario, setInmunitario] = useState("");
    const[nervioso, setNervioso] = useState("");
    const[otros, setOtros] = useState("");
    const[muestras, setMuestras] = useState("");

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
        if (telefonoVet.trim() === ""){
            alert("Debe Ingresar El Telefono Del Veterinario");
            return;
        }
        if (!/^[0-9]{8,}$/.test(telefonoVet)){
            alert("Ingrese Un Telefono Valido Para El Veterinario");
            return;
        }
        if (propietario.trim() === ""){
            alert("Debe Ingresar El Propietario");
            return;
        }
        if (telefonoProp.trim() === ""){
            alert("Debe Ingresar El Telefono Del Propietario");
            return;
        }
        if (!/^[0-9]{8,}$/.test(telefonoProp)){
            alert("Ingrese Un Telefono Valido Para El Propietario");
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
        if (raza.trim() === ""){
            alert("Debe Ingresar La Raza");
            return;
        }
        if (fechaNacimiento.trim() === ""){
            alert("Debe Ingresar La Fecha De Nacimiento");
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
            alert("Ingrese Un Peso Valido");
            return;
        }
        if (condicion.trim() === ""){
            alert("Debe Ingresar La Condicion Corporal");
            return;
        }
        if (descomposicion.trim() === ""){
            alert("Debe Ingresar El Grado De Descomposicion");
            return;
        }
        if (antecedentes.trim() === ""){
            alert("Debe Ingresar Los Antecedentes");
            return;
        }
        if (piel.trim() === ""){
            alert("Debe Ingresar Piel, Mucosas Y Anexos");
            return;
        }
        if (aberturas.trim() === ""){
            alert("Debe Ingresar Las Aberturas Naturales");
            return;
        }
        if (respiratorio.trim() === ""){
            alert("Debe Ingresar El Sistema Respiratorio");
            return;
        }
        if (cardiovascular.trim() === ""){
            alert("Debe Ingresar El Sistema Cardiovascular");
            return;
        }
        if (digestivo.trim() === ""){
            alert("Debe Ingresar El Sistema Digestivo");
            return;
        }
        if (reproductor.trim() === ""){
            alert("Debe Ingresar El Sistema Reproductor");
            return;
        }
        if (urinario.trim() === ""){
            alert("Debe Ingresar El Sistema Urinario");
            return;
        }
        if (inmunitario.trim() === ""){
            alert("Debe Ingresar El Sistema Inmunitario");
            return;
        }
        if (nervioso.trim() === ""){
            alert("Debe Ingresar El Sistema Nervioso");
            return;
        }
        if (otros.trim() === ""){
            alert("Debe Ingresar Otros");
            return;
        }
        if (muestras.trim() === ""){
            alert("Debe Ingresar Las Muestras Remitidas");
            return;
        }
        alert("Ficha guardada con exito");
    }

    return(
        <form onSubmit={guardar} noValidate>

            <div className="necropsia-hoja">
                <div className="necropsia-membrete">
                    <div>
                        <h1>Veterinaria San Marcos</h1>
                        <p>Clínica y hospital veterinario</p>
                    </div>
                    <span className="necropsia-hojanum">HOJA 1 DE 2</span>
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
                <div className="row">
                    <div className="col-12 col-md-7">
                        <LineaFicha
                    etiqueta="Veterinario:"
                    tipo="text"
                    nombre="veterinario"
                    valor={veterinario}
                    alCambiar={setVeterinario}
                    />
                    </div>
                    <div className="col-12 col-md-5">
                        <LineaFicha
                    etiqueta="Teléfono:"
                    tipo="text"
                    nombre="telefonoVet"
                    valor={telefonoVet}
                    alCambiar={setTelefonoVet}
                    />
                    </div>
                </div>

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
                <LineaFicha
                    etiqueta="Dirección:"
                    tipo="text"
                    nombre="direccion"
                    valor={direccion}
                    alCambiar={setDireccion}
                    />

                <div className="necropsia-seccion">Identificación del animal</div>
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

                <div className="necropsia-seccion">Características generales</div>
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
                    etiqueta="Fecha nacimiento:"
                    tipo="text"
                    nombre="fechaNacimiento"
                    valor={fechaNacimiento}
                    alCambiar={setFechaNacimiento}
                    />
                    </div>
                    <div className="col-12 col-md-6">
                        <LineaFicha
                    etiqueta="o edad estimada:"
                    tipo="text"
                    nombre="edad"
                    valor={edad}
                    alCambiar={setEdad}
                    />
                    </div>
                </div>
                <div className="row">
                    <div className="col-12 col-md-5">
                        <LineaFicha
                    etiqueta="Peso (Kg):"
                    tipo="text"
                    nombre="peso"
                    valor={peso}
                    alCambiar={setPeso}
                    />
                    </div>
                    <div className="col-12 col-md-7">
                        <LineaFicha
                    etiqueta="Condición corporal:"
                    tipo="text"
                    nombre="condicion"
                    valor={condicion}
                    alCambiar={setCondicion}
                    />
                    </div>
                </div>
                <LineaFicha
                    etiqueta="Grado de descomposición:"
                    tipo="text"
                    nombre="descomposicion"
                    valor={descomposicion}
                    alCambiar={setDescomposicion}
                    />

                <div className="necropsia-seccion">Antecedentes</div>
                <p className="necropsia-etiqueta">Desparasitaciones, vacunaciones, patologías anteriores, etc.</p>
                <textarea
                className="necropsia-texto"
                rows={3}
                value={antecedentes}
                onChange={(e) => setAntecedentes(e.target.value)}
                />

                <div className="necropsia-seccion">Examen externo</div>
                <p className="necropsia-etiqueta">Piel, mucosas y anexos:</p>
                <textarea
                className="necropsia-texto"
                rows={2}
                value={piel}
                onChange={(e) => setPiel(e.target.value)}
                />
                <p className="necropsia-etiqueta">Aberturas naturales:</p>
                <textarea
                className="necropsia-texto"
                rows={2}
                value={aberturas}
                onChange={(e) => setAberturas(e.target.value)}
                />
            </div>

            <div className="necropsia-hoja">
                <div className="necropsia-membrete">
                    <div>
                        <h1>Veterinaria San Marcos</h1>
                        <p>Clínica y hospital veterinario</p>
                    </div>
                    <span className="necropsia-hojanum">HOJA 2 DE 2</span>
                </div>

                <div className="necropsia-seccion">Examen interno</div>
                <p className="necropsia-etiqueta">Sist. Respiratorio <em>(narinas, tráquea, bronquios, pulmones)</em></p>
                <textarea
                className="necropsia-texto"
                rows={2}
                value={respiratorio}
                onChange={(e) => setRespiratorio(e.target.value)}
                />
                <p className="necropsia-etiqueta">Sist. Cardiovascular <em>(corazón, grandes vasos)</em></p>
                <textarea
                className="necropsia-texto"
                rows={2}
                value={cardiovascular}
                onChange={(e) => setCardiovascular(e.target.value)}
                />
                <p className="necropsia-etiqueta">Sist. Digestivo <em>(boca, lengua, esófago, estómago, ID, IG, recto, hígado)</em></p>
                <textarea
                className="necropsia-texto"
                rows={2}
                value={digestivo}
                onChange={(e) => setDigestivo(e.target.value)}
                />
                <p className="necropsia-etiqueta">Sist. Reproductor <em>(ovarios, útero, vagina, vestíbulo, genitales externos) (testículos, próstata, vesícula seminal, pene)</em></p>
                <textarea
                className="necropsia-texto"
                rows={2}
                value={reproductor}
                onChange={(e) => setReproductor(e.target.value)}
                />
                <p className="necropsia-etiqueta">Sist. Urinario <em>(riñones, vejiga, uréteres, uretra)</em></p>
                <textarea
                className="necropsia-texto"
                rows={2}
                value={urinario}
                onChange={(e) => setUrinario(e.target.value)}
                />
                <p className="necropsia-etiqueta">Sist. Inmunitario <em>(linfonodos, bazo, amígdalas, timo)</em></p>
                <textarea
                className="necropsia-texto"
                rows={2}
                value={inmunitario}
                onChange={(e) => setInmunitario(e.target.value)}
                />
                <p className="necropsia-etiqueta">Sist. Nervioso <em>(cerebro, tallo, médula, ojos, SNP)</em></p>
                <textarea
                className="necropsia-texto"
                rows={2}
                value={nervioso}
                onChange={(e) => setNervioso(e.target.value)}
                />
                <p className="necropsia-etiqueta">Otros:</p>
                <textarea
                className="necropsia-texto"
                rows={2}
                value={otros}
                onChange={(e) => setOtros(e.target.value)}
                />

                <div className="necropsia-seccion">Muestras remitidas</div>
                <p className="necropsia-etiqueta">Detalle de las muestras enviadas a laboratorio:</p>
                <textarea
                className="necropsia-texto"
                rows={3}
                value={muestras}
                onChange={(e) => setMuestras(e.target.value)}
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
