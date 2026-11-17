// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";

import FormularioNecropsia from "../components/organisms/FormularioNecropsia";

test("El FormularioNecropsia renderiza el título, los campos principales y los botones", () => {
    render(<FormularioNecropsia />);

    const tituloProtocolo = screen.getByText("Protocolo de necropsia");
    const seccionHallazgos = screen.getByText("Hallazgos de la necropsia");
    const botonImprimir = screen.getByText("Imprimir Ficha");
    const botonGuardar = screen.getByText("Guardar Ficha");

    expect(tituloProtocolo).toBeDefined();
    expect(seccionHallazgos).toBeDefined();
    expect(botonImprimir).toBeDefined();
    expect(botonGuardar).toBeDefined();
});