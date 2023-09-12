/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author casti
 */
public class PedidoEncabezado {

    private int idempleado, idcliente;
    private String fecha;
    private double total;

    public PedidoEncabezado(int idempleado, int idcliente, String fecha, double total) {

        this.idempleado = idempleado;
        this.idcliente = idcliente;
        this.fecha = fecha;
        this.total = total;
    }

    public PedidoEncabezado() {
    }

    public int getIdempleado() {
        return idempleado;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public String getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
