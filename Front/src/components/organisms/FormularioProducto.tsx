import React, {useState, type FormEvent} from "react";
import { Link } from "react-router-dom";
import CampoInput from "../molecules/CampoInput";

function FormularioProducto(){

    const[id, setId] = useState("");
    const[nombre, setNombre] = useState("");
    const[categoria, setCategoria] = useState("");
    const[tipo, setTipo] = useState("Medicamento");
    const[precio, setPrecio] = useState("");
    const[imagen, setImagen] = useState("");
    const[cantidad,setCantidad]=useState("")
    const[enviando, setEnviando] = useState(false);

    const guardar = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        if (enviando) return;
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
        setEnviando(true);
        if(tipo==="Medicamento"){
        try {
            const respuesta = await fetch(
                "/catalogo/medicamentos"
                , {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
            id:Number(id),
            categoria:categoria,
            nombre:nombre,
            precio:Number(precio),
            cantidad:Number(cantidad),
            imagen:imagen
        }),
        });
        if (!respuesta.ok) {
            throw new Error(`Error HTTP ${respuesta.status}`);
        }
        } catch (error) {
            console.error("Error al crear medicamento ", error);
            alert("Intente nuevamente");
            return;
        }finally {
        setEnviando(false);
        alert("Producto guardado con exito");
        }}
        if(tipo==="Servicio"){
        try {
            const respuesta = await fetch(
                "/catalogo/servicios"
                , {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
            id:Number(id),
            categoria:categoria,
            nombre:nombre,
            precio:Number(precio),
            imagen:imagen
        }),
        });
        if (!respuesta.ok) {
            throw new Error(`Error HTTP ${respuesta.status}`);
        }
        } catch (error) {
            console.error("Error al crear servicio ", error);
            alert("Intente nuevamente");
            return;
        }finally {
        setEnviando(false);
        alert("Producto guardado con exito");
        }}
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
            <div>
            <label>Tipo:</label>
            <select
            className="input-line"
            value={tipo}
            onChange={(e)=>setTipo(e.target.value)}
            >
                <option value="Medicamento">Medicamento</option>
                <option value="Servicio">Servicio</option>   
            </select>
            {tipo==="Medicamento"&&!/^[0-9]+$/.test(precio)&&<>
            <CampoInput
            etiqueta="Stock"
            tipo="text"
            nombre="cantidad"
            valor={cantidad}
            alCambiar={setCantidad}
            />
            </>}
            
            </div>

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

            <Link to="/modificaciones" className="admin-btn admin-btn-claro me-2">
                Volver
            </Link>
            <button type="submit" className="admin-btn">
                Guardar
            </button>
        </form>
    );
}

export default FormularioProducto;