// @vitest-environment jsdom
import { test, expect } from "vitest";
import { MemoryRouter } from "react-router-dom";
import { render, screen } from "@testing-library/react";

import BotonVolverCatalogo from "../components/atoms/BotonVolverCatologo";

test("El Boton deberia de decir Volver", () => {
    render(
        <MemoryRouter>
            <BotonVolverCatalogo ruta={"/servicios/"} />
        </MemoryRouter>
    );

    const botonVolverCatalogo = screen.getByText("Volver");
    expect(botonVolverCatalogo.textContent).toBe("Volv");
});