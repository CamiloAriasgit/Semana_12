package com.example;

class PagoTarjeta implements MetodoPago {
    private String numeroTarjeta;

    public PagoTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public boolean procesarPago(double monto) throws TiendaException {

        System.out.println("Procesando pago con tarjeta terminada en: ****-****-****-" + obtenerUltimosDigitos());
        System.out.println("Pago de $" + String.format("%.2f", monto) + " exitoso.");
        return true;
    }

    @Override
    public String obtenerDetalles() {
        return "Tarjeta terminada en: ****-****-****-" + obtenerUltimosDigitos();
    }

    private String obtenerUltimosDigitos() {
        if (numeroTarjeta != null && numeroTarjeta.length() > 4) {
            return numeroTarjeta.substring(numeroTarjeta.length() - 4);
        } else {
            return "N/A";
        }
    }
}