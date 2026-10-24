// @vitest-environment jsdom
import { test, expect, vi } from "vitest";
import { render, screen, fireEvent } from "@testing-library/react";

import LineaFicha from "../components/molecules/LineaFicha";

test("Falla porque el valor en el evento no coincide con el esperado", () => {
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

    expect(alCambiarMock).toHaveBeenCalledWith("Grave");
});