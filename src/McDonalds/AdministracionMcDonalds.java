/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package McDonalds;

import Interfaz.McDonaldsCLI;
import java.util.Iterator;
import Lista.Cola;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdministracionMcDonalds<T> {

    public final Cola<String> colaClientes;
    private final Cola<Pedido<T>> colaPedidos;
    private final Cola<Pedido<T>> colaDomicilios;
    private final ListaDobleEncadenada<Producto<T>> catalogoProductos;

    public AdministracionMcDonalds() {
        colaClientes = new Cola<>();
        colaPedidos = new Cola<>();
        colaDomicilios = new Cola<>();
        catalogoProductos = new ListaDobleEncadenada<>();

        catalogoProductos.addLast((Producto<T>) new Producto<McDonaldsCLI>("Combo Nuggets", 2, 5.99));
        catalogoProductos.addLast((Producto<T>) new Producto<McDonaldsCLI>("Combo Big Mac", 6, 4.99));
        catalogoProductos.addLast((Producto<T>) new Producto<McDonaldsCLI>("Combo Cuarto de Libra", 9, 6.99));
        catalogoProductos.addLast((Producto<T>) new Producto<McDonaldsCLI>("McFlurry", 10, 3.49));

    }

    public void agregarCliente(String nombre) {
        colaClientes.encolar(nombre);

    }

    public String eliminarCliente() {
        return colaClientes.desencolar();
    }

    public String atenderCliente(Pedido<T> pedido) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        colaPedidos.encolar(pedido);
        return colaClientes.desencolar();
    }

    public String entregarPedido() {
        Pedido<T> p = colaPedidos.desencolar();
        try {
            Thread.sleep((long) p.getProducto().getTiempoPreparacion());
        } catch (InterruptedException e) {
        }
        return p.getProducto().getNombre();
    }

    public void registrarDomicilio(Pedido<T> pedido) {
        colaDomicilios.encolar(pedido);
    }

    public String obtenerHoraActual() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String despacharDomicilio() {
        Pedido<T> p = colaDomicilios.desencolar();
        try {
            Thread.sleep((long) p.getProducto().getTiempoPreparacion());
        } catch (InterruptedException e) {
        }
        return p.getProducto().getNombre();
    }

    public int clientesEnFila() {
        return colaClientes.tamanio();
    }

    public int pedidosEnEspera() {
        return colaPedidos.tamanio();
    }

    public int domiciliosEnEspera() {
        return colaDomicilios.tamanio();
    }

    public Cola<String> getColaClientes() {
        return colaClientes;
    }

    public Iterator<String> clientes() {
        return colaClientes.iterator();
    }

    public Pedido<T> buscarPedido(String nombreProductoBuscado) {
        Iterator<Pedido<T>> iterator = colaPedidos.iterator();

        while (iterator.hasNext()) {
            Pedido<T> pedido = iterator.next();
            Producto<T> producto = pedido.getProducto();

            if (producto.getNombre().equals(nombreProductoBuscado)) {
                return pedido; // Se encontró el pedido
            }
        }

        return null; // Pedido no encontrado
    }

    public Iterator<Pedido<T>> pedidos() {
        return colaPedidos.iterator();
    }

    public Iterator<Pedido<T>> domicilios() {
        return colaDomicilios.iterator();
    }

    public ListaDobleEncadenada<Producto<T>> getCatalogoProductos() {
        return catalogoProductos;
    }

    public void agregarProductoAlCatalogo(Producto<T> producto) {
        catalogoProductos.addLast(producto);
    }

    public void eliminarProductoDelCatalogo(String nombreProducto) {
        Iterator<Producto<T>> iterator = catalogoProductos.iterator();

        while (iterator.hasNext()) {
            Producto<T> producto = iterator.next();

            if (producto.getNombre().equals(nombreProducto)) {
                iterator.remove(); // Elimina el producto del catálogo
                return;
            }
        }
    }

    public Pedido<T> eliminarDomicilio() {
        return colaDomicilios.desencolar();
    }

    public Pedido<T> eliminarPedido() {
        return colaPedidos.desencolar();
    }
}
