/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package McDonalds;

import Interfaz.McDonaldsCLI;

/**
 *
 * @author Guest
 * @param <T>
 */
public class Pedido<T> {

    private final String horaPedido;
    private final Producto<T> producto;
    private String direccion;
    private final boolean esDomicilio;
    private final String Cliente;

    public Pedido(String horaPedido, Producto<T> producto, boolean esDomicilio, String direccion, String Cliente) {
        this.horaPedido = horaPedido;
        this.producto = producto;
        this.esDomicilio = esDomicilio;
        this.direccion = direccion;
        this.Cliente = Cliente;

    }

    public String getCliente(String Cliente) {
        return Cliente;
    }

    public boolean isEsDomicilio() {
        return esDomicilio;
    }

    public Producto<T> getProducto() {
        return producto;
    }

    public String getHoraPedido() {
        return horaPedido;
    }

    public boolean esDomicilio() {
        return esDomicilio;
    }

    public String getDireccion( ) {
        return direccion;
    }

    @Override
    public String toString() {
        return "Pedido{" + "horaPedido=" + horaPedido + ", producto=" + producto + ", direccion=" + direccion + ", esDomicilio=" + esDomicilio + ", Cliente=" + Cliente + '}';
    }

}
