// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";

import Navbar from "../components/organisms/Navbar";

test("Falla porque el enlace de Iniciar Sesion tiene una ruta incorrecta", () => {
    render(
        <MemoryRouter>
            <Navbar />
        </MemoryRouter>
    );

    const marca = screen.getByText("Veterinaria San Marcos");
    const navContainer = marca.closest("nav");
    const enlaceLogin = screen.getByText("Iniciar Sesion");
    const enlaceRegistro = screen.getByText("Crear Cuenta");

    expect(navContainer).toBeDefined();
    expect(enlaceLogin.getAttribute("href")).toBe("/inicio-sesion");
    expect(enlaceRegistro.getAttribute("href")).toBe("/registro");
});