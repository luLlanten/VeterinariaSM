// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";

import AdminNavbar from "../components/organisms/AdminNavbar";

test("El enlace de navegacion contiene una ruta incorrecta", () => {
    render(
        <MemoryRouter>
            <AdminNavbar />
        </MemoryRouter>
    );

    const marca = screen.getByText("ADMINISTRACION");
    const navContainer = marca.closest("nav");
    const enlaceInicio = screen.getByText("Inicio");
    const enlaceInventario = screen.getByText("Inventario");
    const enlaceCatalogo = screen.getByText("Ver catalogo");
    const enlaceHome = screen.getByText("Volver a Homepage");

    expect(navContainer).toBeDefined();
    expect(enlaceInicio.getAttribute("href")).toBe("/ruta-incorrecta");
    expect(enlaceInventario.getAttribute("href")).toBe("/modificaciones");
    expect(enlaceCatalogo.getAttribute("href")).toBe("/servicios");
    expect(enlaceHome.getAttribute("href")).toBe("/");
});