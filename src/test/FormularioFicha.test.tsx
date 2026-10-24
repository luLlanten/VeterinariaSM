// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";

import FormularioFicha from "../components/organisms/FormularioFicha";

test("El FormularioFicha renderiza todos los campos, secciones y botones", () => {
    render(<FormularioFicha />);

    const campoMedicamento = screen.getByText("Medicamento:");
    const campoPropietario = screen.getByText("Propietario:");
    const campoTelefono = screen.getByText("Teléfono:");
    const campoDireccion = screen.getByText("Dirección:");
    const campoEspecie = screen.getByText("Especie:");
    const campoIdentificacion = screen.getByText("Identificación:");
    const seccionCaracteristicas = screen.getByText("Características generales");
    const campoSexo = screen.getByText("SEXO:");
    const campoRaza = screen.getByText("Raza:");
    const seccionAntecedentes = screen.getByText("Antecedentes");
    const botonImprimir = screen.getByText("Imprimir Ficha");
    const botonGuardar = screen.getByText("Guardar Ficha");

    expect(campoMedicamento).toBeDefined();
    expect(campoPropietario).toBeDefined();
    expect(campoTelefono).toBeDefined();
    expect(campoDireccion).toBeDefined();
    expect(campoEspecie).toBeDefined();
    expect(campoIdentificacion).toBeDefined();
    expect(seccionCaracteristicas).toBeDefined();
    expect(campoSexo).toBeDefined();
    expect(campoRaza).toBeDefined();
    expect(seccionAntecedentes).toBeDefined();
    expect(botonImprimir).toBeDefined();
    expect(botonGuardar).toBeDefined();
});