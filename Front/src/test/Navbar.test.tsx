// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";

import Navbar from "../components/organisms/Navbar";

test("El Navbar renderiza la marca y todos sus enlaces de navegación", () => {
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
    expect(enlaceLogin.getAttribute("href")).toBe("/login");
    expect(enlaceRegistro.getAttribute("href")).toBe("/registro");
});