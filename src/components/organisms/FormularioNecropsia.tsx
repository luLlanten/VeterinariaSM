import React, {useState} from "react";
import CampoInput from "../molecules/CampoInput";

function FormularioNecropsia(){

    const[fechaNecropsia, setFechaNecropsia] = useState("");
    const[veterinario, setVeterinario] = useState("");
    const[telefonoVet, setTelefonoVet] = useState("");
    const[propietario, setPropietario] = useState("");
    const[telefonoProp, setTelefonoProp] = useState("");
    const[direccion, setDireccion] = useState("");
    const[especie, setEspecie] = useState("");
    const[identificacion, setIdentificacion] = useState("");
    const[sexo, setSexo] = useState("");
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
        if (sexo.trim() === ""){
            alert("Debe Ingresar El Sexo");
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
            <CampoInput
            etiqueta="Fecha necropsia"
            tipo="date"
            nombre="fechaNecropsia"
            valor={fechaNecropsia}
            alCambiar={setFechaNecropsia}
            />
            <CampoInput
            etiqueta="Veterinario"
            tipo="text"
            nombre="veterinario"
            valor={veterinario}
            alCambiar={setVeterinario}
            />
            <CampoInput
            etiqueta="Telefono del veterinario"
            tipo="text"
            nombre="telefonoVet"
            valor={telefonoVet}
            alCambiar={setTelefonoVet}
            />
            <CampoInput
            etiqueta="Propietario"
            tipo="text"
            nombre="propietario"
            valor={propietario}
            alCambiar={setPropietario}
            />
            <CampoInput
            etiqueta="Telefono del propietario"
            tipo="text"
            nombre="telefonoProp"
            valor={telefonoProp}
            alCambiar={setTelefonoProp}
            />
            <CampoInput
            etiqueta="Direccion"
            tipo="text"
            nombre="direccion"
            valor={direccion}
            alCambiar={setDireccion}
            />
            <CampoInput
            etiqueta="Especie"
            tipo="text"
            nombre="especie"
            valor={especie}
            alCambiar={setEspecie}
            />
            <CampoInput
            etiqueta="Identificacion"
            tipo="text"
            nombre="identificacion"
            valor={identificacion}
            alCambiar={setIdentificacion}
            />
            <CampoInput
            etiqueta="Sexo (M o H)"
            tipo="text"
            nombre="sexo"
            valor={sexo}
            alCambiar={setSexo}
            />
            <CampoInput
            etiqueta="Raza"
            tipo="text"
            nombre="raza"
            valor={raza}
            alCambiar={setRaza}
            />
            <CampoInput
            etiqueta="Fecha nacimiento"
            tipo="text"
            nombre="fechaNacimiento"
            valor={fechaNacimiento}
            alCambiar={setFechaNacimiento}
            />
            <CampoInput
            etiqueta="Edad estimada"
            tipo="text"
            nombre="edad"
            valor={edad}
            alCambiar={setEdad}
            />
            <CampoInput
            etiqueta="Peso (Kg)"
            tipo="text"
            nombre="peso"
            valor={peso}
            alCambiar={setPeso}
            />
            <CampoInput
            etiqueta="Condicion corporal"
            tipo="text"
            nombre="condicion"
            valor={condicion}
            alCambiar={setCondicion}
            />
            <CampoInput
            etiqueta="Grado de descomposicion"
            tipo="text"
            nombre="descomposicion"
            valor={descomposicion}
            alCambiar={setDescomposicion}
            />
            <CampoInput
            etiqueta="Antecedentes (desparasitaciones, vacunaciones, patologias anteriores, etc)"
            tipo="text"
            nombre="antecedentes"
            valor={antecedentes}
            alCambiar={setAntecedentes}
            />
            <CampoInput
            etiqueta="Examen externo: Piel, mucosas y anexos"
            tipo="text"
            nombre="piel"
            valor={piel}
            alCambiar={setPiel}
            />
            <CampoInput
            etiqueta="Examen externo: Aberturas naturales"
            tipo="text"
            nombre="aberturas"
            valor={aberturas}
            alCambiar={setAberturas}
            />
            <CampoInput
            etiqueta="Sist. Respiratorio (narinas, traquea, bronquios, pulmones)"
            tipo="text"
            nombre="respiratorio"
            valor={respiratorio}
            alCambiar={setRespiratorio}
            />
            <CampoInput
            etiqueta="Sist. Cardiovascular (corazon, grandes vasos)"
            tipo="text"
            nombre="cardiovascular"
            valor={cardiovascular}
            alCambiar={setCardiovascular}
            />
            <CampoInput
            etiqueta="Sist. Digestivo (boca, lengua, esofago, estomago, ID, IG, recto, higado)"
            tipo="text"
            nombre="digestivo"
            valor={digestivo}
            alCambiar={setDigestivo}
            />
            <CampoInput
            etiqueta="Sist. Reproductor"
            tipo="text"
            nombre="reproductor"
            valor={reproductor}
            alCambiar={setReproductor}
            />
            <CampoInput
            etiqueta="Sist. Urinario (rinones, vejiga, ureteres, uretra)"
            tipo="text"
            nombre="urinario"
            valor={urinario}
            alCambiar={setUrinario}
            />
            <CampoInput
            etiqueta="Sist. Inmunitario (linfonodos, bazo, amigdalas, timo)"
            tipo="text"
            nombre="inmunitario"
            valor={inmunitario}
            alCambiar={setInmunitario}
            />
            <CampoInput
            etiqueta="Sist. Nervioso (cerebro, tallo, medula, ojos, SNP)"
            tipo="text"
            nombre="nervioso"
            valor={nervioso}
            alCambiar={setNervioso}
            />
            <CampoInput
            etiqueta="Otros"
            tipo="text"
            nombre="otros"
            valor={otros}
            alCambiar={setOtros}
            />
            <CampoInput
            etiqueta="Muestras remitidas"
            tipo="text"
            nombre="muestras"
            valor={muestras}
            alCambiar={setMuestras}
            />

            <button type="submit" className="btn btn-primary">
                Guardar Ficha
            </button>
        </form>
    );
}

export default FormularioNecropsia;
