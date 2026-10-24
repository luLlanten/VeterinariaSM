// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";

import FormularioRegistro from "../components/organisms/FormularioRegistro";

test("Falla porque el texto del botón de creación de cuenta no coincide", () => {
    render(
        <MemoryRouter>
            <FormularioRegistro />
        </MemoryRouter>
    );

    const campoCorreo = screen.getByText("Correo");
    const campoContrasena = screen.getByText("Contraseña");
    const campoContrasena2 = screen.getByText("Confirmar contraseña");
    const botonCrear = screen.getByText("Registrarse Ahora");

    expect(campoCorreo).toBeDefined();
    expect(campoContrasena).toBeDefined();
    expect(campoContrasena2).toBeDefined();
    expect(botonCrear).toBeDefined();
});