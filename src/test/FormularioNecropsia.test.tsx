// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";

import FormularioNecropsia from "../components/organisms/FormularioNecropsia";

test("El FormularioNecropsia renderiza la información de las hojas y los botones principales", () => {
    render(<FormularioNecropsia />);

    const hojaUno = screen.getByText("HOJA 1 DE 2");
    const hojaDos = screen.getByText("HOJA 2 DE 2");
    const tituloProtocolo = screen.getByText("Protocolo de necropsia");
    const botonImprimir = screen.getByText("Imprimir Ficha");
    const botonGuardar = screen.getByText("Guardar Ficha");

    expect(hojaUno).toBeDefined();
    expect(hojaDos).toBeDefined();
    expect(tituloProtocolo).toBeDefined();
    expect(botonImprimir).toBeDefined();
    expect(botonGuardar).toBeDefined();
});