// @vitest-environment jsdom
import { test, expect, vi } from "vitest";
import { render, screen, fireEvent } from "@testing-library/react";

import CampoInput from "../components/molecules/CampoInput";

test("Falla porque el valor esperado en el cambio no coincide", () => {
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

    expect(alCambiarMock).toHaveBeenCalledWith("holaa@correo.com");
});