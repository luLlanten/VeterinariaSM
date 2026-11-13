interface Props{
    texto: string;
    alHacerClick: () => void;
    clase?: string;
}



function BotonAccion({texto, alHacerClick, clase = "boton-opcion2"}: Props){
    return(
        <button
            type="button"
            className={clase}
            onClick={alHacerClick}
        >
            {texto}
        </button>
    );
}

export default BotonAccion;