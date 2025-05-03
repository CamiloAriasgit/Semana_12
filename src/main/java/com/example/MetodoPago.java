package com.example;

interface MetodoPago {
    boolean procesarPago(double monto) throws TiendaException;
    String obtenerDetalles();
}
