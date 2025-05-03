package com.example;

class ProductoRopa extends Producto {
    private String talla;

    public ProductoRopa(String nombre, double precio, int stock, String talla) {
        super(nombre, precio, stock);
        this.talla = talla;
    }

    @Override
    public String getDetalles() {
        return String.format("Producto Ropa: %s, Precio: $%.2f, Stock: %d, Talla: %s",
                             getNombre(), getPrecio(), getStock(), talla);
    }
}
