export interface ItemCarrito {
    id: string;
    titulo: string;
    precio: number;
    imagen: string;
    cantidad: number;
}

interface CarritoBack{
    id:number;
}

interface FilaServicio{
    servicioDTO:{
        id:number;
    }
}

interface FilaMedicamento{
    medicamentoDTO:{
        id:number;
    }
}

interface Producto{
    id:number;
    nombre:string;
    precio:number;
    imagen:string;
}

// el id del usuario debe guardarse al iniciar sesion: localStorage.setItem("usuarioId", id)
async function obtenerIdCarrito(): Promise<number | null>{
    const usuarioId = localStorage.getItem("usuarioId");
    if(usuarioId === null){
        return null;
    }
    let respuesta=await fetch(`http://localhost:9090/compra/admin/carrito/user/${usuarioId}`)
    let texto=await respuesta.text()
    if(texto === ""){
        await fetch(`http://localhost:9090/compra/${usuarioId}`,{ method: "POST" })
        respuesta=await fetch(`http://localhost:9090/compra/admin/carrito/user/${usuarioId}`)
        texto=await respuesta.text()
    }
    const carrito=JSON.parse(texto) as CarritoBack
    return carrito.id;
}

export async function obtenerCarrito(): Promise<ItemCarrito[]>{
    const items: ItemCarrito[] = [];
    try{
        const idCarrito=await obtenerIdCarrito()
        if(idCarrito === null){
            return [];
        }
        const respuestaServ=await fetch(`http://localhost:9090/compra/${idCarrito}/agrserv`)
        if(!respuestaServ.ok){
            throw new Error(`Error HTTP ${respuestaServ.status}`);
        }
        const servicios:FilaServicio[] =await respuestaServ.json()
        for(const fila of servicios){
            const respuesta=await fetch(`http://localhost:9090/catalogo/servicios/${fila.servicioDTO.id}`)
            const servicio=(await respuesta.json()) as Producto
            items.push({ id: `servicio-${servicio.id}`, titulo: servicio.nombre, precio: servicio.precio, imagen: servicio.imagen, cantidad: 1 });
        }
        const respuestaMed=await fetch(`http://localhost:9090/compra/${idCarrito}/agrmed`)
        if(!respuestaMed.ok){
            throw new Error(`Error HTTP ${respuestaMed.status}`);
        }
        const medicamentos:FilaMedicamento[] =await respuestaMed.json()
        for(const fila of medicamentos){
            const respuesta=await fetch(`http://localhost:9090/catalogo/medicamentos/${fila.medicamentoDTO.id}`)
            const medicamento=(await respuesta.json()) as Producto
            items.push({ id: `medicamento-${medicamento.id}`, titulo: medicamento.nombre, precio: medicamento.precio, imagen: medicamento.imagen, cantidad: 1 });
        }
    }catch(error){
        console.error("Error al cargar el carrito",error);
        alert("No se pudo cargar el carrito")
    }
    return items;
}

let agregando: Promise<boolean> = Promise.resolve(true);

// el boton espera aqui a que termine de agregar antes de cambiar de pagina
export function esperarAgregado(){
    return agregando;
}

// titulo, precio e imagen se mantienen en la firma, pero el Back obtiene esos datos del catalogo
// eslint-disable-next-line @typescript-eslint/no-unused-vars
export function agregarAlCarrito(id: string, _titulo: string, _precio: number, _imagen: string){
    // en /medicamento/:id se agrega un medicamento, en /servicio/:id un servicio
    const ruta = window.location.pathname.startsWith("/medicamento") ? "agrmed" : "agrserv";
    agregando = agregar(id, ruta);
}

async function agregar(id: string, ruta: string): Promise<boolean>{
    try{
        const idCarrito=await obtenerIdCarrito()
        if(idCarrito === null){
            alert("Debes iniciar sesión para agregar al carrito")
            return false;
        }
        const respuesta=await fetch(`http://localhost:9090/compra/${idCarrito}/${ruta}/${id}`,{ method: "POST" })
        if(!respuesta.ok){
            throw new Error(`Error HTTP ${respuesta.status}`);
        }
        return true;
    }catch(error){
        console.error("Error al agregar al carrito",error);
        alert("No se pudo agregar al carrito")
        return false;
    }
}

export async function quitarDelCarrito(id: string){
    const [tipo, idProducto] = id.split("-");
    const ruta = tipo === "medicamento" ? "delmed" : "delserv";
    try{
        const idCarrito=await obtenerIdCarrito()
        const respuesta=await fetch(`http://localhost:9090/compra/${idCarrito}/${ruta}/${idProducto}`,{ method: "DELETE" })
        if(!respuesta.ok){
            throw new Error(`Error HTTP ${respuesta.status}`);
        }
    }catch(error){
        console.error("Error al quitar del carrito",error);
        alert("No se pudo quitar el producto")
    }
}

export async function vaciarCarrito(){
    const items=await obtenerCarrito()
    for(const item of items){
        await quitarDelCarrito(item.id)
    }
}

export async function comprar(): Promise<boolean>{
    try{
        const idCarrito=await obtenerIdCarrito()
        const respuestaCarrito=await fetch(`http://localhost:9090/compra/admin/carrito/${idCarrito}`)
        const carrito=(await respuestaCarrito.json()) as CarritoBack
        const respuesta=await fetch(
            "http://localhost:9090/compra/comprar",
            {
                body: JSON.stringify(carrito),
                headers: {'Content-Type':'application/json'},
                method: "POST"
            }
        );
        if(!respuesta.ok){
            throw new Error(`Error HTTP ${respuesta.status}`);
        }
        return true;
    }catch(error){
        console.error("Error al comprar",error);
        return false;
    }
}
