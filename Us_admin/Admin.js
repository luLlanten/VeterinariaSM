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
    tabla.innerHTML +=`
            <th>${listaUsuarios[i].nombre}</th>
            <th>${listaUsuarios[i].rol}</th>
        `
};//HAY QUE CAMBIAR ESTO