import Input from "../atoms/Input";

type Props ={
    etiqueta: string;
    tipo: string;
    nombre: string;
    valor: string;
    alCambiar:(valor: string) => void;
    min?: string;
}

function CampoInput({etiqueta,tipo,nombre,valor,alCambiar,min}: Props){
    return(
        <div className="mb-3">
            <label className="form-label">
                {etiqueta}
            </label>

            <Input
            tipo={tipo}
            nombre={nombre}
            valor={valor}
            alCambiar={alCambiar}
            min={min}
            />
        </div>
    );
}

export default CampoInput;