// @vitest-environment jsdom
import { test, expect, vi } from "vitest";
import { render, screen, fireEvent } from "@testing-library/react";

import CampoInput from "../components/molecules/CampoInput";

test("El CampoInput renderiza la etiqueta y permite cambiar su valor", () => {
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

    fireEvent.change(inputElement, { target: { value: "test@correo.com" } });

    expect(alCambiarMock).toHaveBeenCalledWith("test@correo.com");
});