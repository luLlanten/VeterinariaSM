// @vitest-environment jsdom
import { test, expect, vi } from "vitest";
import { render, screen, fireEvent } from "@testing-library/react";

import CampoInput from "../components/molecules/CampoInput";

test("Renderiza la etiqueta y el input correctamente", () => {
    const alCambiarMock = vi.fn();

    render(
        <CampoInput 
            etiqueta="Correo Electrónico"
            tipo="email" 
            nombre="email" 
            valor="" 
            alCambiar={alCambiarMock} 
        />
    );

    const labelElement = screen.getByText("Correo Electrónico");
    const inputElement = screen.getByRole("textbox");

    fireEvent.change(inputElement, { target: { value: "a" } });

    expect(alCambiarMock).toHaveBeenCalledWith("a");
});