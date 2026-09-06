let catalogo = [
    {
        id: "SV001",
        nombre: "Consulta general",
        categoria: "Consultas",
        tipo: "Servicio",
        precio: "$15.000",
        imagen: "../Pag_principal/img/Consulta general.jpg",
        detalles: " - Duración: 30 min"
    },
    {
        id: "SV002",
        nombre: "Consulta urgencia",
        categoria: "Consultas",
        tipo: "Servicio",
        precio: "$25.000",
        imagen: "../Pag_principal/img/Consulta urgencia.jpg",
        detalles: "Fuera de horario +$10.000 - Duración: 30 min"
    },
    {
        id: "SV003",
        nombre: "Control postoperatorio",
        categoria: "Consultas",
        tipo: "Servicio",
        precio: "$10.000",
        imagen: "../Pag_principal/img/Control postoperatorio.jpg",
        detalles: " - Duración: 20 min"
    },
    {
        id: "SV004",
        nombre: "Consulta ave / conejo",
        categoria: "Consultas",
        tipo: "Servicio",
        precio: "$18.000",
        imagen: "../Pag_principal/img/Consulta ave conejo.jpg",
        detalles: " - Duración: 30 min"
    },
    {
        id: "SV005",
        nombre: "Segunda opinión médica",
        categoria: "Consultas",
        tipo: "Servicio",
        precio: "$20.000",
        imagen: "../Pag_principal/img/Segunda opinión médica.jpg",
        detalles: "Requiere ficha previa - Duración: 40 min"
    },
    {
        id: "CI001",
        nombre: "Esterilización hembra canina",
        categoria: "Cirugía",
        tipo: "Servicio",
        precio: "$80.000",
        imagen: "../Pag_principal/img/Esterilización hembra canina.jpg",
        detalles: "Incluye anestesia y hospitalización 24h - Duración: 90 min"
    },
    {
        id: "CI002",
        nombre: "Esterilización macho canino",
        categoria: "Cirugía",
        tipo: "Servicio",
        precio: "$60.000",
        imagen: "../Pag_principal/img/Esterilización macho canino.jpg",
        detalles: "Incluye anestesia - Duración: 60 min"
    },
    {
        id: "CI003",
        nombre: "Esterilización hembra felina",
        categoria: "Cirugía",
        tipo: "Servicio",
        precio: "$65.000",
        imagen: "../Pag_principal/img/Esterilización hembra felina.jpg",
        detalles: "Incluye anestesia y hospitalización 12h - Duración: 60 min"
    },
    {
        id: "CI004",
        nombre: "Esterilización macho felino",
        categoria: "Cirugía",
        tipo: "Servicio",
        precio: "$50.000",
        imagen: "../Pag_principal/img/Esterilización macho felino.jpg",
        detalles: "Incluye anestesia - Duración: 45 min"
    },
    {
        id: "CI005",
        nombre: "Extirpación de tumor cutáneo",
        categoria: "Cirugía",
        tipo: "Servicio",
        precio: "$120.000",
        imagen: "../Pag_principal/img/Extirpación de tumor cutáneo.jpg",
        detalles: "Precio referencial; varía según tamaño - Duración: 60 min"
    },
    {
        id: "CI006",
        nombre: "Cesárea de urgencia",
        categoria: "Cirugía",
        tipo: "Servicio",
        precio: "$180.000",
        imagen: "../Pag_principal/img/Cesárea de urgencia.png",
        detalles: " - Duración: 120 min"
    },
    {
        id: "DE001",
        nombre: "Desparasitación interna pequeños (<10 kg)",
        categoria: "Desparasitación",
        tipo: "Servicio",
        precio: "$8.000",
        imagen: "../Pag_principal/img/Desparasitación interna pequeños (0 kg).jpg",
        detalles: " - Duración: 5 min"
    },
    {
        id: "DE002",
        nombre: "Desparasitación interna medianos (10-25 kg)",
        categoria: "Desparasitación",
        tipo: "Servicio",
        precio: "$9.500",
        imagen: "../Pag_principal/img/Desparasitación interna medianos.jpg",
        detalles: " - Duración: 5 min"
    },
    {
        id: "DE003",
        nombre: "Desparasitación interna grandes (>25 kg)",
        categoria: "Desparasitación",
        tipo: "Servicio",
        precio: "$11.000",
        imagen: "../Pag_principal/img/Desparasitación interna grandes.jpg",
        detalles: " - Duración: 5 min"
    },
    {
        id: "DE004",
        nombre: "Desparasitación interna felina",
        categoria: "Desparasitación",
        tipo: "Servicio",
        precio: "$8.000",
        imagen: "../Pag_principal/img/Desparasitación interna felina.jpg",
        detalles: " - Duración: 5 min"
    },
    {
        id: "DE005",
        nombre: "Antiparasitario externo (pipeta)",
        categoria: "Desparasitación",
        tipo: "Servicio",
        precio: "$7.500",
        imagen: "../Pag_principal/img/Antiparasitario externo.jpg",
        detalles: "Incluye aplicación - Duración: 5 min"
    },
    {
        id: "EX001",
        nombre: "Hemograma completo",
        categoria: "Exámenes",
        tipo: "Servicio",
        precio: "$22.000",
        imagen: "../Pag_principal/img/Hemograma completo.jpg",
        detalles: "Resultado en 24-48 h - Duración: 30 min"
    },
    {
        id: "EX002",
        nombre: "Perfil bioquímico completo",
        categoria: "Exámenes",
        tipo: "Servicio",
        precio: "$35.000",
        imagen: "../Pag_principal/img/Perfil bioquímico completo.jpg",
        detalles: "Resultado en 24-48 h - Duración: 30 min"
    },
    {
        id: "EX003",
        nombre: "Radiografía (1 proyección)",
        categoria: "Exámenes",
        tipo: "Servicio",
        precio: "$28.000",
        imagen: "../Pag_principal/img/Radiografía.jpg",
        detalles: " - Duración: 20 min"
    },
    {
        id: "EX004",
        nombre: "Ecografía abdominal",
        categoria: "Exámenes",
        tipo: "Servicio",
        precio: "$45.000",
        imagen: "../Pag_principal/img/Ecografía abdominal.jpg",
        detalles: " - Duración: 30 min"
    },
    {
        id: "EX005",
        nombre: "Test de leishmaniasis",
        categoria: "Exámenes",
        tipo: "Servicio",
        precio: "$18.000",
        imagen: "../Pag_principal/img/Test de leishmaniasis.jpg",
        detalles: " - Duración: 20 min"
    },
    {
        id: "OT001",
        nombre: "Corte de uñas",
        categoria: "Otros",
        tipo: "Servicio",
        precio: "$5.000",
        imagen: "../Pag_principal/img/Corte de uñas.jpg",
        detalles: " - Duración: 15 min"
    },
    {
        id: "OT002",
        nombre: "Limpieza dental",
        categoria: "Otros",
        tipo: "Servicio",
        precio: "$55.000",
        imagen: "../Pag_principal/img/Limpieza dental.jpg",
        detalles: "Requiere anestesia - Duración: 45 min"
    },
    {
        id: "OT003",
        nombre: "Microchip identificación",
        categoria: "Otros",
        tipo: "Servicio",
        precio: "$15.000",
        imagen: "../Pag_principal/img/Microchip identificación.jpg",
        detalles: "Incluye registro - Duración: 10 min"
    },
    {
        id: "OT004",
        nombre: "Hospitalización (por día)",
        categoria: "Otros",
        tipo: "Servicio",
        precio: "$30.000",
        imagen: "../Pag_principal/img/Hospitalización.jpg",
        detalles: "Incluye monitoreo y alimentación básica - Duración: 24 h"
    },
    {
                id: "VA001",
                nombre: "Vacuna antirrábica canina",
                categoria: "Vacunación",
                tipo: "Servicio",
                precio: "$12.000",
                imagen: "../Pag_principal/img/Vacunaantirrábicacanina.jpg",
                detalles: "Obligatoria por ley - Duración: 10 min"
            },
            {
                id: "VA002",
                nombre: "Vacuna sextuple canina",
                categoria: "Vacunación",
                tipo: "Servicio",
                precio: "$18.000",
                imagen: "../Pag_principal/img/Vacunasextuplecanina.png",
                detalles: "Refuerzo anual - Duración: 10 min"
            },
            {
                id: "VA003",
                nombre: "Vacuna bivalente felina",
                categoria: "Vacunación",
                tipo: "Servicio",
                precio: "$15.000",
                imagen: "../Pag_principal/img/Vacunabivalentefelina.jpg",
                detalles: "Refuerzo anual - Duración: 10 min"
            },
            {
                id: "VA004",
                nombre: "Vacuna triple felina",
                categoria: "Vacunación",
                tipo: "Servicio",
                precio: "$17.000",
                imagen: "../Pag_principal/img/Vacunatriplefelina.jpg",
                detalles: "Refuerzo anual - Duración: 10 min"
            },
            {
                id: "VA005",
                nombre: "Vacuna Bordetella canina",
                categoria: "Vacunación",
                tipo: "Servicio",
                precio: "$14.000",
                imagen: "../Pag_principal/img/VacunaBordetellacanina.jpg",
                detalles: "Tos de las perreras - Duración: 10 min"
            },
            {
                id: "VA006",
                nombre: "Vacuna antirrábica felina",
                categoria: "Vacunación",
                tipo: "Servicio",
                precio: "$12.000",
                imagen: "../Pag_principal/img/Vacuna antirrábica felina.jpg",
                detalles: " - Duración: 10 min"
            },
            
            {
                id: "ME001",
                nombre: "Amoxibay 250mg",
                categoria: "Antibióticos",
                tipo: "Medicamento",
                precio: "$4.200",
                imagen: "../Pag_principal/img/Amoxibay250mg.jpg",
                detalles: "Principio Activo: Amoxicilina - Stock: 45"
            },
            {
                id: "ME002",
                nombre: "Enrox 50mg",
                categoria: "Antibióticos",
                tipo: "Medicamento",
                precio: "$6.800",
                imagen: "../Pag_principal/img/Enrox50mg.jpg",
                detalles: "Principio Activo: Enrofloxacino - Stock: 30"
            },
            {
                id: "ME003",
                nombre: "Metrobay 250mg",
                categoria: "Antibióticos",
                tipo: "Medicamento",
                precio: "$3.900",
                imagen: "../Pag_principal/img/Metrobay 250mg.png",
                detalles: "Principio Activo: Metronidazol - Stock: 28"
            },
            {
                id: "ME004",
                nombre: "Nexgard",
                categoria: "Antiparasitarios",
                tipo: "Medicamento",
                precio: "$9.500",
                imagen: "../Pag_principal/img/Nexgard.jpg",
                detalles: "Principio Activo: Afoxolaner - Stock: 60"
            },
            {
                id: "ME005",
                nombre: "Bravecto",
                categoria: "Antiparasitarios",
                tipo: "Medicamento",
                precio: "$18.900",
                imagen: "../Pag_principal/img/Bravecto.png",
                detalles: "Principio Activo: Fluralaner - Stock: 40"
            },
            {
                id: "ME006",
                nombre: "Revolution Plus",
                categoria: "Antiparasitarios",
                tipo: "Medicamento",
                precio: "$14.500",
                imagen: "../Pag_principal/img/Revolution Plus.jpg",
                detalles: "Principio Activo: Selamectina+Sarolaner - Stock: 35"
            },
            {
                id: "ME007",
                nombre: "Drontal Plus",
                categoria: "Antiparasitarios",
                tipo: "Medicamento",
                precio: "$3.200",
                imagen: "../Pag_principal/img/Drontal Plus.jpg",
                detalles: "Principio Activo: Praziquantel+Pamoato - Stock: 80"
            },
            {
                id: "ME008",
                nombre: "Milbemax Gato",
                categoria: "Antiparasitarios",
                tipo: "Medicamento",
                precio: "$6.800",
                imagen: "../Pag_principal/img/Milbemax Gato.jpg",
                detalles: "Principio Activo: Milbemicina+Praziq. - Stock: 50"
            },
            {
                id: "ME009",
                nombre: "Meloxicam 1mg",
                categoria: "Antiinflamatorios",
                tipo: "Medicamento",
                precio: "$4.500",
                imagen: "../Pag_principal/img/Meloxicam 1mg.jpeg",
                detalles: "Principio Activo: Meloxicam - Stock: 55"
            },
            {
                id: "ME010",
                nombre: "Carprofen 50mg",
                categoria: "Antiinflamatorios",
                tipo: "Medicamento",
                precio: "$9.800",
                imagen: "../Pag_principal/img/Carprofen50mg.png",
                detalles: "Principio Activo: Carprofeno - Stock: 30"
            },
            {
                id: "ME011",
                nombre: "Clorhexidina shampoo",
                categoria: "Dermatología",
                tipo: "Medicamento",
                precio: "$8.900",
                imagen: "../Pag_principal/img/Clorhexidina shampoo.jpg",
                detalles: "Principio Activo: Clorhexidina 2% - Stock: 25"
            },
            {
                id: "ME012",
                nombre: "Malaseb shampoo",
                categoria: "Dermatología",
                tipo: "Medicamento",
                precio: "$12.500",
                imagen: "../Pag_principal/img/Malaseb shampoo.jpg",
                detalles: "Principio Activo: Miconazol+Clorhex. - Stock: 20"
            },
            {
                id: "ME013",
                nombre: "Apoquel 16mg",
                categoria: "Dermatología",
                tipo: "Medicamento",
                precio: "$22.000",
                imagen: "../Pag_principal/img/Apoquel 16mg.jpg",
                detalles: "Principio Activo: Oclacitinib - Stock: 18"
            },
            {
                id: "ME014",
                nombre: "Probifor",
                categoria: "Digestivo",
                tipo: "Medicamento",
                precio: "$5.600",
                imagen: "../Pag_principal/img/Probifor.jpeg",
                detalles: "Principio Activo: Bacillus clausii - Stock: 40"
            },
            {
                id: "ME015",
                nombre: "Omeprazol 10mg vet",
                categoria: "Digestivo",
                tipo: "Medicamento",
                precio: "$3.800",
                imagen: "../Pag_principal/img/Omeprazol 10mg vet.jpg",
                detalles: "Principio Activo: Omeprazol - Stock: 35"
            },
            {
                id: "ME016",
                nombre: "Vetmedin 2.5mg",
                categoria: "Cardíaco",
                tipo: "Medicamento",
                precio: "$28.000",
                imagen: "../Pag_principal/img/Vetmedin 2.5mg.jpg",
                detalles: "Principio Activo: Pimobendan - Stock: 15"
            },
            {
                id: "ME017",
                nombre: "Tramadol 50mg vet",
                categoria: "Analgésicos",
                tipo: "Medicamento",
                precio: "$5.200",
                imagen: "../Pag_principal/img/Tramadol 50mg vet.jpg",
                detalles: "Principio Activo: Tramadol - Stock: 22"
            },
            {
                id: "ME018",
                nombre: "Nobivac DHPPi",
                categoria: "Vacunas",
                tipo: "Medicamento",
                precio: "$8.500",
                imagen: "../Pag_principal/img/Nobivac DHPPi.png",
                detalles: "Principio Activo: Vacuna polivalente - Stock: 48"
            },
            {
                id: "ME019",
                nombre: "Nobivac Rabies",
                categoria: "Vacunas",
                tipo: "Medicamento",
                precio: "$5.800",
                imagen: "../Pag_principal/img/Nobivac Rabies.jpg",
                detalles: "Principio Activo: Vacuna antirrábica - Stock: 60"
            },
            {
                id: "ME020",
                nombre: "Felocell CVR",
                categoria: "Vacunas",
                tipo: "Medicamento",
                precio: "$7.200",
                imagen: "../Pag_principal/img/Felocell CVR.jpg",
                detalles: "Principio Activo: Vacuna triple felina - Stock: 36"
            },
            {
                id: "ME021",
                nombre: "Omega vet 3-6-9",
                categoria: "Suplementos",
                tipo: "Medicamento",
                precio: "$9.900",
                imagen: "../Pag_principal/img/Omega.png",
                detalles: "Principio Activo: Ácidos grasos omega - Stock: 30"
            },
            {
                id: "ME022",
                nombre: "Condrovet forte",
                categoria: "Suplementos",
                tipo: "Medicamento",
                precio: "$14.500",
                imagen: "../Pag_principal/img/Condrovetforte.jpg",
                detalles: "Principio Activo: Condroitín+Glucos. - Stock: 25"
            }
];

let mod = document.getElementById("mod");
    for (let i = 0; i < catalogo.length; i++) {        
        mod.innerHTML += `
        <div class="producto-card">
            <img src="${catalogo[i].imagen}" alt="${catalogo[i].nombre}">
            <h3>${catalogo[i].nombre}</h3>
            <p>${catalogo[i].categoria}</p>
            <p style="font-weight: bold;">${catalogo[i].precio}</p>
            <button onclick="verDetalle('${catalogo[i].id}')">
                Ver detalle
            </button>
        </div>
        `;
    }

function verDetalle(id) {
    let productoSeleccionado;
    for (let i = 0; i < catalogo.length; i++) {
        if (catalogo[i].id === id) {
            productoSeleccionado = catalogo[i]; 
            break;
        }
    }
    localStorage.setItem(
        "producto",
        JSON.stringify(productoSeleccionado)
    );
    console.log(productoSeleccionado);
    window.location.href = "detallemod.html";
}
function agregarProducto(){
    window.location.href="agregar.html";
}