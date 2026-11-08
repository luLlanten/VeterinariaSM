// @vitest-environment jsdom
import { test, expect, vi } from "vitest";
import { render, screen, fireEvent } from "@testing-library/react";

import LineaFicha from "../components/molecules/LineaFicha";

test("El LineaFicha renderiza la etiqueta y permite cambiar su valor", () => {
    const alCambiarMock = vi.fn();

    render(
        <LineaFicha 
            etiqueta="Diagnóstico"
            tipo="text" 
            nombre="diagnostico" 
            valor="" 
            alCambiar={alCambiarMock} 
        />
    );

    const labelElement = screen.getByText("Diagnóstico");
    const inputElement = screen.getByRole("textbox");

    fireEvent.change(inputElement, { target: { value: "Sano" } });

    expect(alCambiarMock).toHaveBeenCalledWith("Sano");
});