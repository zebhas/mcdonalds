/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package McDonalds;

public class Producto<T> {
    private String nombre;
    private double tiempoPreparacion;
    private double costo;
    

    public Producto(String nombre, double tiempoPreparacion, double costo) {
        this.nombre = nombre;
        this.tiempoPreparacion = tiempoPreparacion;
        this.costo = costo;
        
    }

    public String getNombre() {
        return nombre;
    }

    public double getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", tiempoPreparacion=" + tiempoPreparacion + ", costo=" + costo + '}';
    }

}
