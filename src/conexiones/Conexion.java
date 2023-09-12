package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private static String url = "jdbc:mysql://localhost/dbrestamita";
    private static String usuario = "root";
    private static String clave = "";
    private static Connection cn;

    public static Connection abrir() {
        try {
            //registrar dirver
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception ex) {
            return null;
        }
        return cn;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, clave);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
