/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosDAO;

import conexiones.Conexion;
import control.Cliente;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class ClienteDAO {

    public static ArrayList<Cliente> listar() {

        Cliente cli;

        ArrayList<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT *FROM cliente";

        Connection cn = Conexion.abrir();
        try {

            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                cli = new Cliente(rs.getInt("idcliente"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("dni"));

                clientes.add(cli);
            }

            cn.close();
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error en lista de empleados:" + ex.getMessage());
        }
        return clientes;
    }

    public static void insertar(Cliente cli) {
        String sql = "insert into cliente (nombre,apellidos,dni)values(?,?,?)";

        Connection cn = Conexion.abrir();
        try {

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellidos());
            ps.setString(3, cli.getDni());

            ps.executeUpdate();

            ps.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void modificar(Cliente cli) {
        String sql = "update  cliente set nombre=?,apellidos=?,dni=? where idcliente=?";

        Connection cn = Conexion.abrir();
        try {

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellidos());
            ps.setString(3, cli.getDni());
            ps.setInt(4, cli.getIdcliente());

            ps.executeUpdate();

            ps.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void eliminar(int cod) {

        String sql = "DELETE FROM cliente WHERE idcliente=?";

        Connection cn = Conexion.abrir();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, cod);

            ps.executeUpdate();

            ps.close();
            cn.close();

            JOptionPane.showMessageDialog(null, "Cliente Eliminado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Este cliente no se puede eliminar, porque tiene registrado una venta");
        }
    }

}
