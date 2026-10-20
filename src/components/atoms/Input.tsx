type Props={
    tipo: string;
    nombre: string;
    valor: string;
    alCambiar: (valor: string) => void;
    clase?: string;
}

function Input({tipo, nombre, valor, alCambiar, clase = "form-control"}: Props){
    return(
        <input
        type={tipo}
        name={nombre}
        className={clase}

        value={valor}
        onChange={(e) => alCambiar(e.target.value)}
        />
    );
}

export default Input;