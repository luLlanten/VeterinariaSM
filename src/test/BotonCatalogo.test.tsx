// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";

import BotonCatalogo from "../components/atoms/BotonCatalago";

test("Permite ingresar a ver los detalles del producto", () => {
    render(
        <MemoryRouter>
            <BotonCatalogo id={"SV001"} ruta={"/servicio/"} />
        </MemoryRouter>
    );

    const botoncatalogo = screen.getByText("Ver Producto");
    expect(botoncatalogo.textContent).toBe("Ver Producto");
});