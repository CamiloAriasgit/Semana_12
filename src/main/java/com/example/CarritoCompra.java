package com.example;

import java.util.ArrayList;
import java.util.List;

class CarritoCompra {
    private List<Producto> productos;

    public CarritoCompra() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) throws TiendaException {
        if (producto.getStock() > 0) {
            productos.add(producto);
            producto.setStock(producto.getStock() - 1);
        } else {
            throw new TiendaException("No hay stock disponible para el producto: " + producto.getNombre());
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }
}
