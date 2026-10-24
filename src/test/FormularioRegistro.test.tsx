// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";

import FormularioRegistro from "../components/organisms/FormularioRegistro";

test("El FormularioRegistro renderiza los campos y el botón de creación de cuenta", () => {
    render(
        <MemoryRouter>
            <FormularioRegistro />
        </MemoryRouter>
    );

    const campoCorreo = screen.getByText("Correo");
    const campoContrasena = screen.getByText("Contraseña");
    const campoContrasena2 = screen.getByText("Confirmar contraseña");
    const botonCrear = screen.getByText("Crear Cuenta");

    expect(campoCorreo).toBeDefined();
    expect(campoContrasena).toBeDefined();
    expect(campoContrasena2).toBeDefined();
    expect(botonCrear).toBeDefined();
});