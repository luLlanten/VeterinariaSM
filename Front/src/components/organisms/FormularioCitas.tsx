import { useState, useEffect } from "react";
import CampoInput from "../molecules/CampoInput";
import { Link } from "react-router-dom";
import type { SubmitEvent } from "react";

function FormularioCitas(){
    const [servicioDetectado, setServicioDetectado] = useState("");
    const [fecha, setFecha] = useState("");
    const [hora, setHora] = useState("");
    const [ruta, setRuta] = useState("");
    const [enviando, setEnviando] = useState(false);

    const hoy = new Date();
    const fechaMinima = `${hoy.getFullYear()}-${String(hoy.getMonth() + 1).padStart(2, "0")}-${String(hoy.getDate()).padStart(2, "0")}`;

    const bloquesHorarios: string[] = [
        "09:00",
        "10:30",
        "12:00",
        "15:00",
        "16:30",
        "18:00"
    ];

    useEffect(() => {
        const servicioGuardado = localStorage.getItem("servicioSeleccionado");
        if (servicioGuardado) {
            setServicioDetectado(servicioGuardado);
        }
    }, []);

    const Agendar = async (e: SubmitEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (enviando) return;

        if (servicioDetectado.trim() === ""){
            alert("No se detectó ningún servicio seleccionado");
            return;
        }
        if (fecha.trim() === ""){
            alert("Debe Seleccionar Una Fecha");
            return;
        }
        if (fecha < fechaMinima){
            alert("No puede seleccionar una fecha pasada");
            return;
        }
        if (hora.trim() === ""){
            alert("Debe Seleccionar Una Hora");
            return;
        }

        setEnviando(true);

        const fechaCompleta = `${fecha}T${hora}:00`;
        localStorage.setItem("fechaCita", fechaCompleta);

        alert(`Cita agendada para ${servicioDetectado} el ${fecha} a las ${hora} hrs`);
        setRuta("/carrito");
        setEnviando(false);
    }

    return(
        <form onSubmit={Agendar} noValidate>
            <div className="mb-3">
                <label className="form-label" style={{ color: "whitesmoke" }}>
                    Servicio Seleccionado
                </label>
                <input
                    type="text"
                    className="form-control"
                    value={servicioDetectado}
                    placeholder="Sin servicio seleccionado"
                    readOnly
                    style={{ backgroundColor: "#e9ecef", fontWeight: "bold", color: "#223526" }}
                />
            </div>

            <CampoInput
                etiqueta="Fecha de la Cita"
                tipo="date"
                nombre="fecha"
                valor={fecha}
                alCambiar={setFecha}
                min={fechaMinima}
            />

            <div className="mb-3">
                <label className="form-label" style={{ color: "whitesmoke" }}>
                    Hora de Atención
                </label>
                <select
                    className="form-select"
                    name="hora"
                    value={hora}
                    onChange={(e) => setHora(e.target.value)}
                >
                    <option value="">Seleccione una hora disponible</option>
                    {bloquesHorarios.map((bloque) => (
                        <option key={bloque} value={bloque}>
                            {bloque} hrs
                        </option>
                    ))}
                </select>
            </div>

            <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", width: "100%", marginTop: "15px" }}>
                <div>
                    <button type="submit" disabled={enviando} style={{ borderWidth: "0cap", backgroundColor: "rgb(24, 80, 43)", color: "white", borderRadius: "10%", padding: "4px 10px" }}>
                        {enviando ? "Agendando" : "Confirmar Cita"}
                    </button>
                    {ruta !== "" && (
                        <Link to={ruta} style={{ borderWidth: "0cap", backgroundColor: "rgb(24, 80, 43)", color: "white", borderRadius: "10%", padding: "4px 10px", textDecoration: "none", display: "inline-block", marginLeft: "8px" }}>
                            siguiente
                        </Link>
                    )}
                </div>
                <Link to="/ficha" style={{ borderWidth: "0cap", backgroundColor: "rgb(24, 80, 43)", color: "white", borderRadius: "10%", padding: "4px 10px", textDecoration: "none", display: "inline-block" }}>
                    Volver
                </Link>
            </div>
        </form>
    );
}

export default FormularioCitas;