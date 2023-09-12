/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosDAO;

import conexiones.Conexion;
import control.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class UsuarioDAO {

    public static void insertar(Usuario usu) {
        String sql = "insert into usuario(usuario,clave,idempleado) values(?,?,?)";

        Connection cn = Conexion.abrir();
        try {

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getClave());
            ps.setInt(3, usu.getIdempleado());

            ps.executeUpdate();

            ps.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
