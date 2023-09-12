/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosDAO;

import conexiones.Conexion;
import control.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class EmpleadoDAO {

    public static ArrayList<Empleado> listar() {

        Empleado emp;

        ArrayList<Empleado> empleados = new ArrayList<>();

        String sql = "SELECT *FROM EMPLEADO";

        Connection cn = Conexion.abrir();
        try {

            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                emp = new Empleado(rs.getInt("idempleado"), rs.getString("nombre"),
                        rs.getString("apepaterno"), rs.getString("apematerno"), rs.getString("cargo"));

                empleados.add(emp);
            }

            cn.close();
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error en lista de empleados:" + ex.getMessage());
        }
        return empleados;
    }

    public static void insertar(Empleado emp) {
        String sql = "insert into empleado(nombre,apepaterno,apematerno,cargo)values(?,?,?,?)";

        Connection cn = Conexion.abrir();
        try {

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getPaterno());
            ps.setString(3, emp.getMaterno());
            ps.setString(4, emp.getCargo());

            ps.executeUpdate();

            ps.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void modificar(Empleado emp) {
        String sql = "update  empleado set nombre=?,apepaterno=?,apematerno=?,cargo=? where idempleado=?";

        //conexion
        Connection cn = Conexion.abrir();
        try {

            //asignar valores a los parametros
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getPaterno());
            ps.setString(3, emp.getMaterno());
            ps.setString(4, emp.getCargo());
            ps.setInt(5, emp.getIdemp());
            //cejecutar
            ps.executeUpdate();

            //cerrar obejtos
            ps.close();
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Seleccione Empleado a modificar, porfavor");
        }
    }

    public static void eliminar(int cod) {
        //instruccion sql para insertar empleado a la base de datos
        String sql = "DELETE FROM EMPLEADO WHERE IDEMPLEADO=?";

        //conexion a la base de datos
        Connection cn = Conexion.abrir();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            //asignar valore a los prametros ?
            ps.setInt(1, cod);
            //ejecutar
            ps.executeUpdate();
            //cerrar objetos
            ps.close();
            cn.close();
                    JOptionPane.showMessageDialog(null, "Empleado eliminado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Este empleado no se puede eliminar, porque cuenta con un usuario");
        }
    }

}
