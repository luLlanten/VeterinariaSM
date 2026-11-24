import {useState} from "react";
import { Link } from "react-router-dom";
import LineaCarrito from "../molecules/LineaCarrito";
import BotonAccion from "../atoms/BotonAccion";
import { obtenerCarrito, quitarDelCarrito, vaciarCarrito } from "../../data/carrito";

function ListaCarrito(){
    const[items, setItems] = useState(obtenerCarrito());
    const[enviando, setEnviando] = useState(false);

    function quitar(id: string){
        if (!window.confirm("¿Quitar este producto del carrito?")){
            return;
        }
        quitarDelCarrito(id);
        setItems(obtenerCarrito());
    }

    function vaciar(){
        if (!window.confirm("¿Vaciar todo el carrito?")){
            return;
        }
        vaciarCarrito();
        setItems([]);
    }
    let total = 0;
    for (const item of items){
        total = total + item.precio * item.cantidad;
    }
    async function pagar(){
        setEnviando(true)

        try{
            const respuesta = await fetch(
                "/compra/comprar"
                , {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
            id:null,
            cantidad:items.length,
            total:total,
            usuarioId:null
        }),
        });
        if (!respuesta.ok) {
            throw new Error(`Error HTTP ${respuesta.status}`);
        }
        setItems(await respuesta.json())
        setEnviando(false)
        return
        //añadir aca boleta
        }catch(error){
            console.error("Error en la compra ", error);
            alert("Error en la compra, intente nuevamente");
            return;
        }
    }

    
    

    if (items.length === 0){
        return(
            <div className="text-center">
                <p>Tu carrito está vacío.</p>
                <Link to="/medicamentos" className="boton-opcion2">Ver medicamentos</Link>
            </div>
        );
    }

    return(
        <div>
            {items.map(item => (
                <LineaCarrito
                    key={item.id}
                    id={item.id}
                    titulo={item.titulo}
                    precio={item.precio}
                    cantidad={item.cantidad}
                    imagen={item.imagen}
                    alQuitar={quitar}
                />
            ))}
            <div className="text-end mt-4">
                <h4>Total: ${total}</h4>
                <BotonAccion texto="Vaciar carrito" alHacerClick={vaciar}/>
                <BotonAccion texto="Comprar" alHacerClick={pagar}/>
            </div>
        </div>
    );
}

export default ListaCarrito;