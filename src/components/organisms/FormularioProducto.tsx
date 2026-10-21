import React, {useState} from "react";
import { Link } from "react-router-dom";
import CampoInput from "../molecules/CampoInput";

function FormularioProducto(){

    const[id, setId] = useState("");
    const[nombre, setNombre] = useState("");
    const[categoria, setCategoria] = useState("");
    const[tipo, setTipo] = useState("");
    const[precio, setPrecio] = useState("");
    const[imagen, setImagen] = useState("");
    const[detalles, setDetalles] = useState("");

    const guardar = (e: React.SubmitEvent<HTMLFormElement>) => {
        e.preventDefault();

                e.preventDefault();

        if (id.trim() === ""){
            alert("Debe Ingresar El Id");
            return;
        }
        if (nombre.trim() === ""){
            alert("Debe Ingresar El Nombre");
            return;
        }
        if (categoria.trim() === ""){
            alert("Debe Ingresar La Categoria");
            return;
        }
        if (tipo.trim() === ""){
            alert("Debe Ingresar El Tipo");
            return;
        }
        if (precio.trim() === ""){
            alert("Debe Ingresar El Precio");
            return;
        }
        if (!/^[0-9]+$/.test(precio)){
            alert("Ingrese Un Precio Valido");
            return;
        }
        if (imagen.trim() === ""){
            alert("Debe Ingresar La Imagen");
            return;
        }
        if (detalles.trim() === ""){
            alert("Debe Ingresar Los Detalles");
            return;
        }
        alert("Producto guardado sin exito");
    }

    return(
        <form onSubmit={guardar} noValidate>
            <CampoInput
            etiqueta="Id"
            tipo="text"
            nombre="id"
            valor={id}
            alCambiar={setId}
            />
            <CampoInput
            etiqueta="Nombre"
            tipo="text"
            nombre="nombre"
            valor={nombre}
            alCambiar={setNombre}
            />
            <CampoInput
            etiqueta="Categoria"
            tipo="text"
            nombre="categoria"
            valor={categoria}
            alCambiar={setCategoria}
            />
            <CampoInput
            etiqueta="Tipo"
            tipo="text"
            nombre="tipo"
            valor={tipo}
            alCambiar={setTipo}
            />
            <CampoInput
            etiqueta="Precio"
            tipo="text"
            nombre="precio"
            valor={precio}
            alCambiar={setPrecio}
            />
            <CampoInput
            etiqueta="Imagen (URL)"
            tipo="text"
            nombre="imagen"
            valor={imagen}
            alCambiar={setImagen}
            />
            <CampoInput
            etiqueta="Detalles"
            tipo="text"
            nombre="detalles"
            valor={detalles}
            alCambiar={setDetalles}
            />

            <Link to="/modificaciones" className="btn btn-secondary me-2">
                Volver
            </Link>
            <button type="submit" className="btn btn-primary">
                Guardar
            </button>
        </form>
    );
}

export default FormularioProducto;