package com.example;

import java.util.ArrayList;
import java.util.List;

class TiendaVirtual {
    private List<Producto> inventario;
    private List<Usuario> usuarios;

    public TiendaVirtual() {
        this.inventario = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        inventario.add(producto);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void realizarCompra(Usuario usuario, MetodoPago metodoPago) throws TiendaException {
        CarritoCompra carrito = usuario.getCarrito();
        if (carrito.getProductos().isEmpty()) {
            throw new TiendaException("El carrito de compra está vacío.");
        }

        double totalCompra = carrito.calcularTotal();
        if (metodoPago.procesarPago(totalCompra)) {
            System.out.println("Compra realizada por " + usuario.getNombre() + " por un total de $" + String.format("%.2f", totalCompra) + " con " + metodoPago.obtenerDetalles());
            usuario.getCarrito().getProductos().clear();
            throw new TiendaException("El pago no pudo ser procesado.");
        }
    }

    public void mostrarInventario() {
        System.out.println("\nINVENTARIO DE LA TIENDA");
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto producto : inventario) {
                System.out.println(producto.getDetalles() + " (ID: " + producto.getId() + ")");
            }
        }
    }
}
