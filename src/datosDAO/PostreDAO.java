/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosDAO;

import conexiones.Conexion;
import control.Postre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author casti
 */
public class PostreDAO {

    public static void insertar(Postre pos) {
        String sql = "insert into postre(nombre,precio,cantidad,idcategoria)values(?,?,?,?)";

        Connection cn = Conexion.abrir();
        try {

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, pos.getNombre());
            ps.setDouble(2, pos.getPrecio());
            ps.setInt(3, pos.getCantidad());
            ps.setInt(4, pos.getIdcategoria());

            ps.executeUpdate();

            ps.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void modificar(Postre pos) {
        String sql = "update  postre set nombre=?,precio=?,cantidad=?,idcategoria=? where idpostre=?";

        Connection cn = Conexion.abrir();
        try {

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, pos.getNombre());
            ps.setDouble(2, pos.getPrecio());
            ps.setInt(3, pos.getCantidad());
            ps.setInt(4, pos.getIdcategoria());
            ps.setInt(5, pos.getIdpostre());

            ps.executeUpdate();

            ps.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void eliminar(int cod) {

        String sql = "DELETE FROM POSTRE WHERE IDPOSTRE=?";

        Connection cn = Conexion.abrir();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, cod);

            ps.executeUpdate();

            ps.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "Postre eliminado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Este postre no se puede eliminar, porque cuenta con una venta");
        }
    }

}
