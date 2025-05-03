package com.example;

public class Main {
    public static void main(String[] args) {
        try {
                    //METODOS

            // crear tienda
            TiendaVirtual tienda = new TiendaVirtual();

            // agregar productos
            Producto laptop = new ProductoElectronico("Laptop Gaming", 1200.0, 5, 24);
            Producto camiseta = new ProductoRopa("Camiseta Algodón", 25.0, 10, "M");
            tienda.agregarProducto(laptop);
            tienda.agregarProducto(camiseta);

            // crear usuario
            Usuario cliente = new Usuario("Juan Pérez", "juan@email.com");
            tienda.registrarUsuario(cliente);

            // mostrar inventario
            tienda.mostrarInventario();

            // agregar productos al carrito
            cliente.getCarrito().agregarProducto(laptop);
            cliente.getCarrito().agregarProducto(camiseta);

            // realizar compra
            MetodoPago tarjeta = new PagoTarjeta("1234567890123456");
            tienda.realizarCompra(cliente, tarjeta);

            // mostrar inventario actualizado
            tienda.mostrarInventario();

        } catch (TiendaException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}