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
    if (texto === null) {
        return [];
    }
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