// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";

import FormularioLogin from "../components/organisms/FormularioLogin";

test("Falla porque el texto del botón de inicio de sesión no coincide", () => {
    render(
        <MemoryRouter>
            <FormularioLogin />
        </MemoryRouter>
    );

    const campoCorreo = screen.getByText("Correo");
    const campoContrasena = screen.getByText("Contrasena");
    const botonLogin = screen.getByText("Entrar al Sistema");

    expect(campoCorreo).toBeDefined();
    expect(campoContrasena).toBeDefined();
    expect(botonLogin).toBeDefined();
});