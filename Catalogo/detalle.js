let productoJSON = localStorage.getItem("producto");

if (productoJSON) {
    let producto = JSON.parse(productoJSON);

    document.getElementById("imagen").src = producto.imagen;
    document.getElementById("imagen").alt = producto.nombre;

    document.getElementById("nombre").textContent = producto.nombre;

   
    document.getElementById("precio").textContent = "Precio: " + producto.precio;

    
    document.getElementById("descripcion").textContent = producto.detalles;
    
} else {
    
    document.getElementById("nombre").textContent = "No se encontró el producto.";
    document.getElementById("descripcion").textContent = "Por favor, vuelve al catálogo y selecciona un servicio o medicamento.";
}

function agregarFicha() {
    let productoJSON = localStorage.getItem("producto");

    if (productoJSON) {
        localStorage.setItem("medicamentoFicha", productoJSON);
    }

    window.location.href = "ficha.html";
}