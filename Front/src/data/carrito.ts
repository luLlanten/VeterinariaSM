import { useState } from "react";

interface ItemCarrito {
    id: string;
    titulo: string;
    precio: number;
    imagen: string;
    cantidad: number;
}

const CLAVE = "carrito";

export function obtenerCarrito(): ItemCarrito[] {
    const texto = localStorage.getItem(CLAVE);
    const id= useState(null)
    if (texto === null) {
        return [];
    }
    //tiene que devolver un carrito, pero necesito 
    // el usuario y usar algo de aca para guardar el carrito 
    fetch(`/compra/${id}` ,
        {method:'POST'}
    )
    return JSON.parse(texto);
}

function guardarCarrito(items: ItemCarrito[]) {
    localStorage.setItem(CLAVE, JSON.stringify(items));
}

export function agregarAlCarrito(id: string, titulo: string, precio: number, imagen: string) {
    const items = obtenerCarrito();
    const existente = items.find(item => item.id === id);
    if (existente) {
        existente.cantidad = existente.cantidad + 1;
    } else {
        items.push({ id, titulo, precio, imagen, cantidad: 1 });
    }
    guardarCarrito(items);
}

export function quitarDelCarrito(id: string) {
    const items = obtenerCarrito().filter(item => item.id !== id);
    guardarCarrito(items);
}

export function vaciarCarrito() {
    localStorage.removeItem(CLAVE);
}