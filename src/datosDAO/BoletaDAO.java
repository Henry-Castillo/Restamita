/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosDAO;

import conexiones.Conexion;
import control.PedidoDetalle;
import control.PedidoEncabezado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author casti
 */
public class BoletaDAO {

    public int registrarBoleta(PedidoEncabezado boleta, ArrayList<PedidoDetalle> detalleBoleta) {
        Connection cn = Conexion.abrir();
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;

        int resultado = -1;
        try {

            cn.setAutoCommit(false);
            try {
                String sql1 = "insert into pedido_encabezado (fecha,total,idempleado,idcliente)values(?,?,?,?)";

                pst1 = cn.prepareStatement(sql1);

                pst1.setString(1, boleta.getFecha());
                pst1.setDouble(2, boleta.getTotal());
                pst1.setInt(3, boleta.getIdempleado());
                pst1.setInt(4, boleta.getIdcliente());

                resultado = pst1.executeUpdate();
                cn.commit();
            } catch (Exception e) {
                System.out.println("asdsasd");
            }

            String sql2 = "insert into pedido_detalle (idpostre,idpedido,precio,cantidad,subtotal)values(?,?,?,?,?)";

            for (PedidoDetalle p : detalleBoleta) {

                pst2 = cn.prepareStatement(sql2);

                pst2.setInt(1, p.getIdpostre());
                pst2.setInt(2, p.getIdpedido());
                pst2.setDouble(3, p.getPrecio());
                pst2.setInt(4, p.getCantidad());
                pst2.setDouble(5, p.getSubtotal());

                resultado = pst2.executeUpdate();

            }
            String sql3 = "update postre set cantidad = cantidad  - ? where idpostre = ?";
            for (PedidoDetalle p : detalleBoleta) {

                pst3 = cn.prepareStatement(sql3);

                pst3.setInt(1, p.getCantidad());
                pst3.setInt(2, p.getIdpostre());

                resultado = pst3.executeUpdate();

            }

            cn.commit();
        } catch (Exception ex) {
            try {
                cn.rollback();
                System.out.println("fallo" + ex);
                resultado = -1;
            } catch (SQLException a) {
                System.out.println(a);
            }
            System.out.println(ex);
        }

        return resultado;
    }

    
    public static int ultimoIdInsertado(){
        String sql = "select max(idpedido)+1 from pedido_encabezado";
        int id=1;
        Connection cn = Conexion.abrir();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                id = rs.getInt("max(idpedido)+1");
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("error contenido");
        }
        return id;
    }
}
