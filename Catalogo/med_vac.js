let catalogo = [
            {
                id: "VA001",
                nombre: "Vacuna antirrábica canina",
                categoria: "Vacunación",
                tipo: "Servicio",
                precio: "$12.000",
                imagen: "servicio.png",
                detalles: "Obligatoria por ley - Duración: 10 min"
            },
            {
                id: "VA002",
                nombre: "Vacuna sextuple canina",
                categoria: "Vacunación",
                tipo: "Servicio",
                precio: "$18.000",
                imagen: "servicio.png",
                detalles: "Refuerzo anual - Duración: 10 min"
            },
            {
                id: "VA003",
                nombre: "Vacuna bivalente felina",
                categoria: "Vacunación",
                tipo: "Servicio",
                precio: "$15.000",
                imagen: "servicio.png",
                detalles: "Refuerzo anual - Duración: 10 min"
            },
            {
                id: "VA004",
                nombre: "Vacuna triple felina",
                categoria: "Vacunación",
                tipo: "Servicio",
                precio: "$17.000",
                imagen: "servicio.png",
                detalles: "Refuerzo anual - Duración: 10 min"
            },
            {
                id: "VA005",
                nombre: "Vacuna Bordetella canina",
                categoria: "Vacunación",
                tipo: "Servicio",
                precio: "$14.000",
                imagen: "servicio.png",
                detalles: "Tos de las perreras - Duración: 10 min"
            },
            {
                id: "VA006",
                nombre: "Vacuna antirrábica felina",
                categoria: "Vacunación",
                tipo: "Servicio",
                precio: "$12.000",
                imagen: "servicio.png",
                detalles: " - Duración: 10 min"
            },
            
            {
                id: "ME001",
                nombre: "Amoxibay 250mg",
                categoria: "Antibióticos",
                tipo: "Medicamento",
                precio: "$4.200",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Amoxicilina - Stock: 45"
            },
            {
                id: "ME002",
                nombre: "Enrox 50mg",
                categoria: "Antibióticos",
                tipo: "Medicamento",
                precio: "$6.800",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Enrofloxacino - Stock: 30"
            },
            {
                id: "ME003",
                nombre: "Metrobay 250mg",
                categoria: "Antibióticos",
                tipo: "Medicamento",
                precio: "$3.900",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Metronidazol - Stock: 28"
            },
            {
                id: "ME004",
                nombre: "Nexgard",
                categoria: "Antiparasitarios",
                tipo: "Medicamento",
                precio: "$9.500",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Afoxolaner - Stock: 60"
            },
            {
                id: "ME005",
                nombre: "Bravecto",
                categoria: "Antiparasitarios",
                tipo: "Medicamento",
                precio: "$18.900",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Fluralaner - Stock: 40"
            },
            {
                id: "ME006",
                nombre: "Revolution Plus",
                categoria: "Antiparasitarios",
                tipo: "Medicamento",
                precio: "$14.500",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Selamectina+Sarolaner - Stock: 35"
            },
            {
                id: "ME007",
                nombre: "Drontal Plus",
                categoria: "Antiparasitarios",
                tipo: "Medicamento",
                precio: "$3.200",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Praziquantel+Pamoato - Stock: 80"
            },
            {
                id: "ME008",
                nombre: "Milbemax Gato",
                categoria: "Antiparasitarios",
                tipo: "Medicamento",
                precio: "$6.800",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Milbemicina+Praziq. - Stock: 50"
            },
            {
                id: "ME009",
                nombre: "Meloxicam 1mg",
                categoria: "Antiinflamatorios",
                tipo: "Medicamento",
                precio: "$4.500",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Meloxicam - Stock: 55"
            },
            {
                id: "ME010",
                nombre: "Carprofen 50mg",
                categoria: "Antiinflamatorios",
                tipo: "Medicamento",
                precio: "$9.800",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Carprofeno - Stock: 30"
            },
            {
                id: "ME011",
                nombre: "Clorhexidina shampoo",
                categoria: "Dermatología",
                tipo: "Medicamento",
                precio: "$8.900",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Clorhexidina 2% - Stock: 25"
            },
            {
                id: "ME012",
                nombre: "Malaseb shampoo",
                categoria: "Dermatología",
                tipo: "Medicamento",
                precio: "$12.500",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Miconazol+Clorhex. - Stock: 20"
            },
            {
                id: "ME013",
                nombre: "Apoquel 16mg",
                categoria: "Dermatología",
                tipo: "Medicamento",
                precio: "$22.000",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Oclacitinib - Stock: 18"
            },
            {
                id: "ME014",
                nombre: "Probifor",
                categoria: "Digestivo",
                tipo: "Medicamento",
                precio: "$5.600",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Bacillus clausii - Stock: 40"
            },
            {
                id: "ME015",
                nombre: "Omeprazol 10mg vet",
                categoria: "Digestivo",
                tipo: "Medicamento",
                precio: "$3.800",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Omeprazol - Stock: 35"
            },
            {
                id: "ME016",
                nombre: "Vetmedin 2.5mg",
                categoria: "Cardíaco",
                tipo: "Medicamento",
                precio: "$28.000",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Pimobendan - Stock: 15"
            },
            {
                id: "ME017",
                nombre: "Tramadol 50mg vet",
                categoria: "Analgésicos",
                tipo: "Medicamento",
                precio: "$5.200",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Tramadol - Stock: 22"
            },
            {
                id: "ME018",
                nombre: "Nobivac DHPPi",
                categoria: "Vacunas",
                tipo: "Medicamento",
                precio: "$8.500",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Vacuna polivalente - Stock: 48"
            },
            {
                id: "ME019",
                nombre: "Nobivac Rabies",
                categoria: "Vacunas",
                tipo: "Medicamento",
                precio: "$5.800",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Vacuna antirrábica - Stock: 60"
            },
            {
                id: "ME020",
                nombre: "Felocell CVR",
                categoria: "Vacunas",
                tipo: "Medicamento",
                precio: "$7.200",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Vacuna triple felina - Stock: 36"
            },
            {
                id: "ME021",
                nombre: "Omega vet 3-6-9",
                categoria: "Suplementos",
                tipo: "Medicamento",
                precio: "$9.900",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Ácidos grasos omega - Stock: 30"
            },
            {
                id: "ME022",
                nombre: "Condrovet forte",
                categoria: "Suplementos",
                tipo: "Medicamento",
                precio: "$14.500",
                imagen: "medicamento.png",
                detalles: "Principio Activo: Condroitín+Glucos. - Stock: 25"
            }
        ];


let catalogoContainer = document.getElementById('catalogo_med');

function cargarCatalogo() {
    catalogoContainer.innerHTML = '';
    
    for (let i = 0; i < catalogo.length; i++) {
        let producto = catalogo[i];
        
        let card = document.createElement('div');
        card.className = 'producto-card';
        
        let img = document.createElement('img');
        img.src = producto.imagen;
        img.alt = producto.nombre;
        
        let titulo = document.createElement('h3');
        titulo.textContent = producto.nombre;
        
        let categoria = document.createElement('p');
        categoria.textContent = producto.categoria;
        
        let precio = document.createElement('p');
        precio.textContent = producto.precio;
        precio.style.fontWeight = 'bold';
        
        let boton = document.createElement('button');
        boton.className = 'btn-detalles';
        boton.textContent = 'Ver Detalles';
        
        boton.onclick = function() {
            alert('Has seleccionado: ' + producto.nombre);
        };
        
        card.appendChild(img);
        card.appendChild(titulo);
        card.appendChild(categoria);
        card.appendChild(precio);
        card.appendChild(boton);
        
        catalogoContainer.appendChild(card);
    }
}

window.onload = cargarCatalogo;