// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";

import CardProducto from "../components/molecules/CardProducto";

test("El CardProducto renderiza la información del producto correctamente", () => {
    render(
        <MemoryRouter>
            <CardProducto 
                id="1"
                titulo="Alimento para Perros"
                descripcion="Bolsa de 15kg premium"
                precio={25990}
                imagen="imagen.jpg"
                ruta="/detalle/1"
            />
        </MemoryRouter>
    );

    const titulo = screen.getByText("Alimento para Perros");
    const descripcion = screen.getByText("Bolsa de 15kg premium");
    const precio = screen.getByText("$25990");
    const imagen = screen.getByAltText("Alimento para Perros");

    const cardContainer = titulo.closest(".card");

    expect(cardContainer).toBeDefined();
    expect(titulo).toBeDefined();
    expect(descripcion).toBeDefined();
    expect(precio).toBeDefined();
    expect(imagen).toBeDefined();
});