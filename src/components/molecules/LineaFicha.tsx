import Input from "../atoms/Input";

type Props ={
    etiqueta: string;
    tipo: string;
    nombre: string;
    valor: string;
    alCambiar:(valor: string) => void;
}

// Una linea de la ficha:  Etiqueta: ..........
function LineaFicha({etiqueta,tipo,nombre,valor,alCambiar}: Props){
    return(
        <div className="lineas_escritura">
            <label>
                {etiqueta}
            </label>

            <Input
            tipo={tipo}
            nombre={nombre}
            valor={valor}
            alCambiar={alCambiar}
            clase="input-line"
            />
        </div>
    );
}

export default LineaFicha;