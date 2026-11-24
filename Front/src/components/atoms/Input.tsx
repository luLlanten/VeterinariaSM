type Props={
    tipo: string;
    nombre: string;
    valor: string;
    alCambiar: (valor: string) => void;
    clase?: string;
    min?: string;
}

function Input({tipo, nombre, valor, alCambiar, clase = "form-control", min}: Props){
    return(
        <input
        type={tipo}
        name={nombre}
        className={clase}
        min={min}
        value={valor}
        onChange={(e) => alCambiar(e.target.value)}
        />
    );
}

export default Input;