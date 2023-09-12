/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author casti
 */
public class Postre {

    private int idpostre, idcategoria, cantidad;
    private String nombre;
    private double precio;

    public Postre(int idpostre, int idcategoria, int cantidad, String nombre, double precio) {
        this.idpostre = idpostre;
        this.idcategoria = idcategoria;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Postre() {
    }

    public int getIdpostre() {
        return idpostre;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setIdpostre(int idpostre) {
        this.idpostre = idpostre;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
