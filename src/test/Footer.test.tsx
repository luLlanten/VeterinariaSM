// @vitest-environment jsdom
import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";

import Footer from "../components/organisms/Footer";

test("El Footer renderiza la información de contacto, ubicación y copyright", () => {
    render(<Footer />);

    const telefono = screen.getByText("+56 9 99989647");
    const correo = screen.getByText("contacto@veterinariaSanMarcos.cl");
    const direccion = screen.getByText("Pasaje Las Camelias 2635 , Valle Grande, Lampa");
    const footerContainer = telefono.closest("footer");

    expect(footerContainer).toBeDefined();
    expect(telefono).toBeDefined();
    expect(correo).toBeDefined();
    expect(direccion).toBeDefined();
});