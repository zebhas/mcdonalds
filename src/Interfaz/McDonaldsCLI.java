/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import Lista.Cola;
import McDonalds.AdministracionMcDonalds;
import McDonalds.ListaDobleEncadenada;
import McDonalds.Pedido;
import java.util.Iterator;
import java.util.Scanner;

//import taller.mundo.*;
//import taller.mundo.AdministracionMcDonalds.Pedido;
public class McDonaldsCLI<T> {

    private final AdministracionMcDonalds admin;
    String nombreCliente = "";
    private final Scanner in;

    public McDonaldsCLI() {
        admin = new AdministracionMcDonalds();
        in = new Scanner(System.in);
    }

    public void mainMenu() throws InterruptedException {
        boolean finish = false;
        while (!finish) {
            System.out.println("------------------------------------------");
            System.out.println("-                                        -");
            System.out.println("-        McDonalds - Candelaria          -");
            System.out.println("                                                        \n"
                    + "                  ╥╣▒▒▒▒@,        ╥╢▒▒▒▒@╖                            \n"
                    + "                ╥▒▒▒▒▄▒▒▒▒▀█▄   ╓╣▒▒▒▄▒▒▒▒▒█▄                         \n"
                    + "               ╣▒▒▒▒███╢▒▒▒▒██ ╓▒▒╣▒███╚▒▒╢▒██                        \n"
                    + "              ╣▒▒▒▒███  ▒▒▒▒▒█▌▒▒╣▒▓██  ║▒▒▒▒██▄                      \n"
                    + "             ╣▒▒▒▒███   ]▒▒╢▒▒╣░║▒▒██U   ╢▒▒▒▒██µ                     \n"
                    + "            ║▒▒╣▒▐██     ▒▒▒▒▒░░▒▒▐██     ▒▒▒▒▒██                     \n"
                    + "            ╣▒▒▒▒███     ╢▒▒╢╣░║▒▒██▌     ╢▒▒▒▒▀██                    \n"
                    + "           ╢▒▒╢▒▒██      ]▒▒▒╣░▒▒▒██      ]▒▒▒▒▒██µ                   \n"
                    + "           ╣▒▒▒▒███       ▒▒▒╣░▒▒▐██       ▒▒▒▒▒▀██                   \n"
                    + "          ║░░╢▒▒██▌       ▒▒░╢║▒▒██▌       ║▒▒╢▒▒██                   \n"
                    + "          ▒░▒▒▒▒██        ╢▒░▒╢▒▒██▌       ]▒▒▒▒▒██▌                  \n"
                    + "          ╣░▒▒▒▐██        ║▒░▒▒▒▒██U        ▒▒▒▒▒▐██                  \n"
                    + "         ]▒░▒▒▒▐██        ║▒░▒▒▒▒██         ▒▒░▒▒▒██                  \n"
                    + "         ║▒░║▒▒██▌        ]▒▒╣▒▒▒██         ▒▒░▒▒▒██                  \n"
                    + "         ║▒╢▒▒▒██▌         ╙▓██████         ▒▒╢▒▒▒██                \n"
                    + "         ``██████▌          ╙▀▀▀▀▀▀         ``██████                ");
            System.out.println("-                                        -");
            System.out.println("------------------------------------------");
            System.out.println("Bienvenido McDonalds\n");

            System.out.println("Menú principal:");
            System.out.println("-----------------");
            System.out.println("1. Agregar cliente a la cola");
            System.out.println("2. Atender cliente");
            System.out.println("3. Entregar pedido");
            System.out.println("4. Cantidad de clientes en cola");
            System.out.println("5. Cola de pedidos en cocina");
            System.out.println("6. Registrar pedido de domicilio");
            System.out.println("7. Despachar pedido de domicilio");
            System.out.println("8. Agregar producto al catálogo");
            System.out.println("9. Eliminar producto del catalogo ");
            System.out.println("10. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opt1 = in.nextInt();
            in.nextLine();
            switch (opt1) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    atenderCliente();
                    break;
                case 3:
                    entregarPedido();
                    break;
                case 4:
                    numeroClientes();
                    break;
                case 5:
                    pedidos();
                    break;

                case 6:
                    registrarDomicilio();
                    break;
                case 7:
                    despacharDomicilio();
                    break;
                default:
                    break;

                case 8:
                    agregarProductoAlCatalogo();
                    break;
                case 9:
                    eliminarProductoDelCatalogo();
                    break;
                case 10:
                    finish = true;
                    break;

            }
        }
    }

    private void agregarCliente() throws InterruptedException {
        boolean finish = false;

        while (!finish) {
            System.out.println("Agregar un cliente nuevo a la cola del restaurante");
            System.out.println("----------------------------------");
            System.out.println("Ingrese el nombre del cliente:");
            nombreCliente = in.nextLine();
            admin.agregarCliente(nombreCliente);
            System.out.println("Se agregó el cliente llamando " + nombreCliente + " a la cola del restaurante");
            System.out.println("Presione enter para volver al menú principal");
            in.nextLine();
            finish = true;
        }

    }

    private void atenderCliente() throws InterruptedException {
        if (admin.clientesEnFila() == 0) {
            System.out.println("No hay clientes en la fila");
            return;
        }

        // Obtén el nombre del primer cliente en la cola
        String nombreCliente = (String) admin.getColaClientes().first();

        System.out.println("Atender al cliente " + nombreCliente);
        System.out.println("----------------------------------");
        System.out.println("Escoja la orden del cliente:");
        int i = 1;

        // Recorremos el catálogo de productos usando un iterador
        Iterator<McDonalds.Producto<McDonaldsCLI>> iterator = admin.getCatalogoProductos().iterator();
        while (iterator.hasNext()) {
            McDonalds.Producto<McDonaldsCLI> producto = iterator.next();
            System.out.println(i + ". " + producto.getNombre());
            i++;
        }

        int orden = in.nextInt();
        in.nextLine();
        if (orden < 1 || orden > i - 1) {
            System.out.println("Opción no válida. Intente nuevamente.");
            return;
        }

        // Crea el pedido usando el producto seleccionado y el nombre del cliente
        Iterator<McDonalds.Producto<McDonaldsCLI>> iterator2 = admin.getCatalogoProductos().iterator();
        McDonalds.Producto<McDonaldsCLI> productoSeleccionado = null;
        for (int j = 1; j <= orden; j++) {
            productoSeleccionado = iterator2.next();
        }
        Pedido<McDonaldsCLI> pedido = new Pedido<>(admin.obtenerHoraActual(), productoSeleccionado, false, "no hay dirección", nombreCliente);

        // Atiende al cliente y obtén el nombre
        String clienteAtendido = admin.atenderCliente(pedido);

        System.out.println("Atendiendo a " + clienteAtendido + ". Pedido: " + productoSeleccionado.getNombre());
    }

    private void entregarPedido() throws InterruptedException {
        if (admin.pedidosEnEspera() == 0) {
            System.out.println("No hay pedidos en la cocina");
            return;
        }
        System.out.println("Entregar el primer pedido en lista de la cocina");
        System.out.println("----------------------------------");
        System.out.println("Prepadando pedido porfavor espere .......");
        String pedido = admin.entregarPedido();
        System.out.println("Se entregó el pedido: " + pedido);
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(3000);
    }

    private void numeroClientes() throws InterruptedException {
        System.out.println("Número de clientes esperando en fila");
        System.out.println("----------------------------------");

        // Obtener la cola de clientes desde AdministracionMcDonalds
        Cola colaClientes = admin.getColaClientes();
        int num = colaClientes.tamanio();

        if (num > 0) {
            System.out.println("Clientes en la cola:");
            for (Object cliente : colaClientes) {
                System.out.println("- " + cliente);
            }
        } else {
            System.out.println("No hay clientes en la fila");
        }

        System.out.println("Hay " + num + " clientes esperando en la fila.");
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(3000);
    }

    private void pedidos() throws InterruptedException {
        System.out.println("Listar pedidos en cocina y a domicilio");
        System.out.println("--------------------------------------");
        Iterator<McDonalds.Pedido<T>> itPedidos = admin.pedidos();
        Iterator<McDonalds.Pedido<T>> itDomicilios = admin.domicilios();

        // Mostrar todos los pedidos en cocina
        System.out.println("Pedidos en cocina:");
        while (itPedidos.hasNext()) {
            McDonalds.Pedido<T> pedido = itPedidos.next();
            System.out.println(pedido.toString());
        }

        // Mostrar todos los pedidos a domicilio
        System.out.println("\nPedidos a domicilio:");
        while (itDomicilios.hasNext()) {
            McDonalds.Pedido<T> pedidoDomicilio = itDomicilios.next();
            System.out.println(pedidoDomicilio.toString());
        }

        System.out.println("\nPresione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(3000);
    }

    private void registrarDomicilio() {
        System.out.println("Registrar pedido de domicilio");
        System.out.println("----------------------------------");
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = in.nextLine(); // Solicitar el nombre del cliente

        System.out.println("Ingrese la dirección del cliente:");
        String direccion = in.nextLine();

        System.out.println("Escoja la orden del cliente para el domicilio:");

        // Mostrar el catálogo de productos para que el usuario seleccione uno
        int i = 1;
        Iterator<McDonalds.Producto<McDonaldsCLI>> iterator = admin.getCatalogoProductos().iterator();
        while (iterator.hasNext()) {
            McDonalds.Producto<McDonaldsCLI> producto = iterator.next();
            System.out.println(i + ". " + producto.getNombre());
            i++;
        }

        int orden = in.nextInt();
        in.nextLine();
        if (orden < 1 || orden > i - 1) {
            System.out.println("Opción no válida. Intente nuevamente.");
            return; // Salir del método si la opción no es válida.
        }

        // Seleccionar el producto correspondiente a la orden
        Iterator<McDonalds.Producto<McDonaldsCLI>> iterator2 = admin.getCatalogoProductos().iterator();
        McDonalds.Producto<McDonaldsCLI> productoSeleccionado = null;
        for (int j = 1; j <= orden; j++) {
            productoSeleccionado = iterator2.next();
        }

        // Crear el pedido de domicilio con la dirección y el nombre del cliente
        Pedido<McDonaldsCLI> pedidoDomicilio = new Pedido<>(admin.obtenerHoraActual(), productoSeleccionado, true, direccion, nombreCliente);

        // Registrar el pedido de domicilio
        admin.registrarDomicilio(pedidoDomicilio);

        System.out.println("Pedido de domicilio registrado.");
    }

    private void despacharDomicilio() {
        String resultado = admin.despacharDomicilio();
        System.out.println(resultado);

    }

    private void agregarProductoAlCatalogo() {
        System.out.println("Agregar un producto al catálogo");
        System.out.println("----------------------------------");
        System.out.println("Ingrese el nombre del producto:");
        String nombreProducto = in.nextLine();

        System.out.println("Ingrese la cantidad de tiempo de preparación (en minutos):");
        double tiempoPreparacion = in.nextDouble();

        System.out.println("Ingrese el precio del producto:");
        double precio = in.nextDouble();

        // Crear un nuevo producto y agregarlo al catálogo
        McDonalds.Producto<McDonaldsCLI> producto = new McDonalds.Producto<>(nombreProducto, tiempoPreparacion, precio);
        admin.agregarProductoAlCatalogo(producto);

        System.out.println("Producto agregado al catálogo.");
    }

    private void eliminarProductoDelCatalogo() {
        System.out.println("Eliminar un producto del catálogo");
        System.out.println("----------------------------------");
        System.out.println("Ingrese el nombre del producto a eliminar:");
        String nombreProducto = in.nextLine();

        admin.eliminarProductoDelCatalogo(nombreProducto);

        System.out.println("Producto eliminado del catálogo.");
    }

    private void eliminarCliente() throws InterruptedException {
        if (admin.clientesEnFila() == 0) {
            System.out.println("No hay clientes en la fila");
            return;
        }

        String clienteEliminado = admin.eliminarCliente();

        System.out.println("Cliente " + clienteEliminado + " eliminado de la cola.");
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(3000);
    }

    private void eliminarPedido() throws InterruptedException {
        if (admin.pedidosEnEspera() == 0) {
            System.out.println("No hay pedidos en la cocina");
            return;
        }

        McDonalds.Pedido<McDonaldsCLI> pedidoEliminado = admin.eliminarPedido();

        System.out.println("Pedido eliminado de la cocina: " + pedidoEliminado.getProducto().getNombre());
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(3000);
    }

    private void eliminarDomicilio() {
        if (admin.domiciliosEnEspera() == 0) {
            System.out.println("No hay pedidos de domicilio en espera");
            return;
        }

        McDonalds.Pedido<McDonaldsCLI> pedidoDomicilioEliminado = admin.eliminarDomicilio();

        System.out.println("Pedido de domicilio eliminado: " + pedidoDomicilioEliminado.getProducto().getNombre());
    }
}
