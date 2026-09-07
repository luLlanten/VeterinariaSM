let productoJSON = localStorage.getItem("producto");

if (productoJSON) {
    let producto = JSON.parse(productoJSON);
    document.getElementById("medicamento").value = producto.nombre;
}