let listaUsuarios=[
    {
        nombre:"Cristian Vega",
        rol:"Administrador"
    },
    {
        nombre:"Ricardo Yañez",
        rol:"Veterinario"
    },
    {
        nombre:"Javiera Mardones",
        rol:"Cliente"
    },
    {
        nombre:"Carlos Gonzales",
        rol:"Cliente"
    },
    {
        nombre:"Luciano Jimenez",
        rol:"Cliente"
    }
];
let tabla=document.getElementById("tablaUsuarios");
for(let i=0;i<listaUsuarios.length;i++){
    tabla.innerHTML +=`<div>
        <tr>
            <td>${listaUsuarios[i].nombre}</td>
            <td>${listaUsuarios[i].rol}</td>
        </tr>
        </div>
            `
};//HAY QUE CAMBIAR ESTO