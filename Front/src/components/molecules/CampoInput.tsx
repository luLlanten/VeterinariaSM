import Input from "../atoms/Input";

type Props ={
    etiqueta: string;
    tipo: string;
    nombre: string;
    valor: string;
    alCambiar:(valor: string) => void;
}

function CampoInput({etiqueta,tipo,nombre,valor,alCambiar}: Props){
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
            />
        </div>
    );
}

export default CampoInput;