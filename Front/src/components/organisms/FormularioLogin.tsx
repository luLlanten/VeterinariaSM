import { useState, type FormEvent } from "react";
import CampoInput from "../molecules/CampoInput";
import { Link } from "react-router-dom";

function FormularioLogin() {
  const [correo, setCorreo] = useState("");
  const [contrasena, setContrasena] = useState("");
  const [ruta, setRuta] = useState("");
  const [enviando, setEnviando] = useState(false);

  const formatoNormal = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
  const formatoAdmin = /^[a-zA-Z0-9._-]+@sanmarcos\.cl$/;

  const Login = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (enviando) return;

    if (correo.trim() === "") {
      alert("Debe Ingresar Su Correo");
      return;
    }
    if (contrasena.trim() === "") {
      alert("Debe Ingresar Una Contraseña");
      return;
    }

    const esAdmin = formatoAdmin.test(correo);
    const esNormal = formatoNormal.test(correo);

    if (!esAdmin && !esNormal) {
      alert("Ingrese Un Correo Valido");
      return;
    }

    const datosGuardados = JSON.parse(localStorage.getItem("datosUsuario") || "null");
    if (datosGuardados && datosGuardados.modificado) {
      if (
        datosGuardados.correo === correo.trim() &&
        datosGuardados.contrasena === contrasena.trim()
      ) {
        localStorage.setItem("usuarioLogueado", "true");
        localStorage.setItem("correoUsuario", correo.trim());
        alert("Ingreso correcto");
        setRuta(esAdmin ? "/admin" : "/");
        return;
      } else {
        alert("Contraseña incorrecta, intente otra vez");
        return;
      }
    }

    const url = esAdmin ? "/lobby/login/admin" : "/lobby/login";

    setEnviando(true);
    try {
      const respuesta = await fetch(url, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          correo: correo.trim(),
          contrasena: contrasena.trim(),
        }),
      });

      if (!respuesta.ok) {
        throw new Error(`Error HTTP ${respuesta.status}`);
      }

      const dto = (await respuesta.json()) as boolean;

      if (!dto) {
        alert("Contraseña incorrecta, intente otra vez");
        return;
      }

      localStorage.setItem("usuarioLogueado", "true");
      localStorage.setItem("correoUsuario", correo.trim());
      alert("Ingreso correcto");
      setRuta(esAdmin ? "/admin" : "/");
    } catch (error) {
      console.error("Error al ingresar", error);
      alert("Intente ingresar nuevamente");
    } finally {
      setEnviando(false);
    }
  };

  return (
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
      <div
        style={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
          width: "100%",
          marginTop: "15px",
        }}
      >
        <div>
          <button
            type="submit"
            disabled={enviando}
            style={{
              borderWidth: "0cap",
              backgroundColor: "rgb(24, 80, 43)",
              color: "white",
              borderRadius: "10%",
              padding: "4px 10px",
            }}
          >
            {enviando ? "Ingresando" : "Iniciar Sesion"}
          </button>
          {ruta !== "" && (
            <Link
              to={ruta}
              style={{
                borderWidth: "0cap",
                backgroundColor: "rgb(24, 80, 43)",
                color: "white",
                borderRadius: "10%",
                padding: "4px 10px",
                textDecoration: "none",
                display: "inline-block",
                marginLeft: "8px",
              }}
            >
              siguiente
            </Link>
          )}
        </div>
        <Link
          to="/olvide-contrasena"
          style={{
            borderWidth: "0cap",
            backgroundColor: "rgb(24, 80, 43)",
            color: "white",
            borderRadius: "10%",
            padding: "4px 10px",
            textDecoration: "none",
            display: "inline-block",
          }}
        >
          Olvidé mi contraseña
        </Link>
      </div>
    </form>
  );
}

export default FormularioLogin;