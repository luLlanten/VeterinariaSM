// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";

import FormularioLogin from "../components/organisms/FormularioLogin";

test("El FormularioLogin renderiza los campos y el botón de inicio de sesión", () => {
    render(
        <MemoryRouter>
            <FormularioLogin />
        </MemoryRouter>
    );

    const campoCorreo = screen.getByText("Correo");
    const campoContrasena = screen.getByText("Contrasena");
    const botonLogin = screen.getByText("Iniciar Sesion");

    expect(campoCorreo).toBeDefined();
    expect(campoContrasena).toBeDefined();
    expect(botonLogin).toBeDefined();
});