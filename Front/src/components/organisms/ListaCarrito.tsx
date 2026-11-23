import {useState, useEffect} from "react";
import { Link } from "react-router-dom";
import LineaCarrito from "../molecules/LineaCarrito";
import BotonAccion from "../atoms/BotonAccion";
import { obtenerCarrito, quitarDelCarrito, vaciarCarrito, comprar } from "../../data/carrito";
import type { ItemCarrito } from "../../data/carrito";

function ListaCarrito(){
    const[items, setItems] = useState<ItemCarrito[]>([]);
    const[cambios, setCambios] = useState(0);

    useEffect(() => {
        obtenerCarrito().then(setItems).catch(() => setItems([]));
    }, [cambios]);

    const quitar = async (id: string) => {
        if (!window.confirm("¿Quitar este producto del carrito?")){
            return;
        }
        await quitarDelCarrito(id);
        setCambios(cambios + 1);
    }

    const vaciar = async () => {
        if (!window.confirm("¿Vaciar todo el carrito?")){
            return;
        }
        await vaciarCarrito();
        setCambios(cambios + 1);
    }

    const pagar = async () => {
        if (!window.confirm("¿Confirmar la compra?")){
            return;
        }
        if (await comprar()){
            alert("Compra realizada con éxito");
        }else{
            alert("No se pudo realizar la compra");
        }
        setCambios(cambios + 1);
    }

    let total = 0;
    for (const item of items){
        total = total + item.precio * item.cantidad;
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