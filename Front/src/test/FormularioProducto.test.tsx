// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";

import FormularioProducto from "../components/organisms/FormularioProducto";

test("El FormularioProducto renderiza todos los campos y botones", () => {
    render(
        <MemoryRouter>
            <FormularioProducto />
        </MemoryRouter>
    );

    const campoId = screen.getByText("Id");
    const campoNombre = screen.getByText("Nombre");
    const campoCategoria = screen.getByText("Categoria");
    const campoTipo = screen.getByText("Tipo");
    const campoPrecio = screen.getByText("Precio");
    const campoImagen = screen.getByText("Imagen (URL)");
    const campoDetalles = screen.getByText("Detalles");
    const botonVolver = screen.getByText("Volver");
    const botonGuardar = screen.getByText("Guardar");

    expect(campoId).toBeDefined();
    expect(campoNombre).toBeDefined();
    expect(campoCategoria).toBeDefined();
    expect(campoTipo).toBeDefined();
    expect(campoPrecio).toBeDefined();
    expect(campoImagen).toBeDefined();
    expect(campoDetalles).toBeDefined();
    expect(botonVolver).toBeDefined();
    expect(botonGuardar).toBeDefined();
});