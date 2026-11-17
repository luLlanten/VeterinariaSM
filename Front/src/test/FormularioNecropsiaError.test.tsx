// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";

import FormularioNecropsia from "../components/organisms/FormularioNecropsia";

test("Falla porque el texto del botón imprimir no coincide", () => {
    render(<FormularioNecropsia />);

    const tituloProtocolo = screen.getByText("Protocolo de necropsia");
    const botonImprimir = screen.getByText("Imprimir Protocolo");
    const botonGuardar = screen.getByText("Guardar Ficha");

    expect(tituloProtocolo).toBeDefined();
    expect(botonImprimir).toBeDefined();
    expect(botonGuardar).toBeDefined();
});