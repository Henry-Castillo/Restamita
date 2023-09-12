/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author casti
 */
public class PedidoDetalle {

    private int idpostre, idpedido, cantidad;
    private double precio, subtotal;

    public PedidoDetalle(int idpostre, int idpedido, int cantidad, double precio, double subtotal) {
        this.idpostre = idpostre;
        this.idpedido = idpedido;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public PedidoDetalle() {
    }

    public int getIdpostre() {
        return idpostre;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setIdpostre(int idpostre) {
        this.idpostre = idpostre;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }


}
