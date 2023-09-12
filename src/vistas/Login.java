package vistas;

import com.formdev.flatlaf.*;
import static conexiones.Conexion.getConnection;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Login extends javax.swing.JFrame {

    OpcionesdePrograma p2;
    public static String tema = "/doki/themes/sword_art_online/Asuna_Light.theme.json";//tema palorosa

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    String darUsuario() {
        return txtusuario.getText();
    }

    String darContraseña() {
        return txtpassword.getText();
    }

    void mensajeError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", 0);
    }

    void mensajeCorrecto(String msg) {
        //formato this, mensaje, titulo "Error" ,0=Error, 1 = Informarcion, 2 = Peligro o Advertencia, 3 = interrogante 
        JOptionPane.showMessageDialog(this, msg, "Correcto", 1);
    }

    /*void validaciondelAdmin() {
        var resultado = 0;

        try {
            Connection con = getConnection();
            String user = txtusuario.getText();
            String password = String.valueOf(txtpassword.getPassword());
            if (!(user.equals("") || password.equals(""))) {
                String sql = "SELECT * FROM usuario WHERE idusuario='1' and usuario='" + user + "'and clave='" + password + "'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    resultado = 1;
                    if (resultado == 1) {
                        this.dispose();
                        p2 = new OpcionesdePrograma();
                        p2.btnAdministrador.setEnabled(true);
                        p2.setVisible(true);
                    }
                } else {
                    validaciondeIngreso();
                }
            } else {
                mensajeError("Falta llenar uno o más campos");
            }
        } catch (SQLException e) {
            mensajeError("Error de conexion: " + e.getMessage());
        }
    }*/

    public  void validaciondeIngreso() throws SQLException {
        int resultado = 0;
        try {
            Connection con = getConnection();
            String user = txtusuario.getText();
            String password = String.valueOf(txtpassword.getPassword());
            if (!(user.equals("") || password.equals(""))) {
                String sql = "SELECT * FROM usuario WHERE usuario='" + user + "'and clave='" + password + "'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    resultado = 1;
                    if (resultado == 1) {
                        this.dispose();
                        p2 = new OpcionesdePrograma();
                       // p2.btnAdministrador.setEnabled(false);
                        p2.setVisible(true);
                    }
                } else {
                    mensajeError("Error de usuario y/o contraseña");
                }
            } else {
                mensajeError("Falta llenar uno o más campos");
            }

        } catch (SQLException ex) {
            mensajeError("Error de conexion: " + ex.getMessage());
        }
    }

    void confirmacion() {
        String usuario = "admin";
        String clave = "123";
        String m = "";
        boolean bandera = true;
        if (darUsuario().equals(usuario)) {
            if (darContraseña().equals(clave)) {
                //abre la siguiente ventana
                mensajeCorrecto("Si funciona");
                this.dispose();
                p2 = new OpcionesdePrograma();
                p2.setVisible(true);
            } else if (darContraseña().equals(m)) {
                mensajeError("La contraseña está vacía, inserte una contraseña");
            } else {
                mensajeError("La contraseña es incorrecta vuelva a insertarlo");
            }
        } else if (darUsuario().equals(m) && darContraseña().equals(m)) {
            mensajeError("El usuario y la contraseña están vacios");
        } else if (darUsuario().equals(m)) {
            mensajeError("El usuario está vacio, inserte un usuario");
        } else {
            if (darUsuario().equals(usuario)) {
            } else {
                if (darContraseña().equals(clave)) {
                } else {
                    mensajeError("El usuario y la contraseña son incorrectos, vuelva ingresarlos");
                    bandera = false;
                }
            }
            if (bandera == false) {
            } else {
                mensajeError("El nombre del usuario es incorrecto, vuelva a insertarlo");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        logoRestamita = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtpassword = new javax.swing.JPasswordField();
        txtusuario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        iconoDeUusuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));

        jPanel4.setBackground(new java.awt.Color(34, 34, 34));

        logoRestamita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoRestamita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Restamita3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoRestamita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoRestamita, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 370, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 600));

        jPanel2.setBackground(new java.awt.Color(236, 235, 231));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña:");

        btnIniciarSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpasswordKeyTyped(evt);
            }
        });

        txtusuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(236, 235, 231));

        iconoDeUusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/USUARIO.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconoDeUusuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconoDeUusuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtpassword)
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(btnSalir))
                                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(138, 138, 138))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnIniciarSesion)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(129, 129, 129))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 530, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        try {
            validaciondeIngreso();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            btnIniciarSesion.requestFocus();
            btnIniciarSesion.doClick();
        }


    }//GEN-LAST:event_txtpasswordKeyPressed

    private void txtpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
            evt.consume();
        }
        if (txtpassword.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtpasswordKeyTyped

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        char c = evt.getKeyChar();
        if (c < 'a' || c > 'z') {
            evt.consume();
        }
        if (txtusuario.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtusuarioKeyTyped
    @SuppressWarnings({"unchecked", "Convert2Lambda", "CallToPrintStackTrace", "UseSpecificCatch"})
    public static void main(String args[]) {
        try {//es necesario tener 2 librerias la de doki.theme-jetbrains-78.2-1.1.1 y flatlaf-2.3
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            //IntelliJTheme.setup(Login.class.getResourceAsStream(tema));
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @SuppressWarnings("override")
            public void run() {
                new Login().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel iconoDeUusuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel logoRestamita;
    public static javax.swing.JPasswordField txtpassword;
    public static javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
