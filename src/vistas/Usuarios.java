package vistas;

import static conexiones.Conexion.getConnection;
import control.Empleado;
import control.Usuario;
import datosDAO.EmpleadoDAO;
import datosDAO.UsuarioDAO;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andres
 */
public class Usuarios extends javax.swing.JFrame {
    
    ArrayList ListCBOEmp;
    OpcionesdePrograma opProg;
    
    public Usuarios() {
        initComponents();
        setLocationRelativeTo(null);
        mostradatos();
        llenarCBEmpleados();
    }
    
    String darUsuario() {
        return txtUsuario.getText();
    }
    
    String darClave() {
        return String.valueOf(txtContraseña.getPassword());
    }

 
    void mensaje(String msg) {
        
        JOptionPane.showMessageDialog(this, msg);
    }
    
    boolean validarIngreso() {
        if (txtUsuario.getText().length() != 0 && txtContraseña.getText().length() != 0 && cboEmpleado.getSelectedItem() == null) {
            return true;
        }
        return false;
    }
    
    public void llenarCBEmpleados() {
        cboEmpleado.removeAllItems();
        ListCBOEmp = EmpleadoDAO.listar();
        Iterator iterator = ListCBOEmp.iterator();
        while (iterator.hasNext()) {
            Empleado emps = (Empleado) iterator.next();
            // Empleado emps = (Empleado) iterator.next();
            cboEmpleado.addItem(emps);
            
        }
        
    }
    
    void insertar() {

        //if (validarIngreso()) {
        //crear objeto empleado
        Usuario usu = new Usuario();
        //asignar valores a las propiedades
        //del objeto empleado: encapsulamiento
        Empleado empi = (Empleado) cboEmpleado.getSelectedItem();
        usu.setUsuario(darUsuario());
        usu.setClave(darClave());
        usu.setIdempleado(empi.getIdemp());

        //insertar empleado la base de datos
        UsuarioDAO.insertar(usu);
        //listar
        mensaje("Usuario " + darUsuario() + " creado correctamente C:");
        /* } else {
            Empleado empi = (Empleado) cboEmpleado.getSelectedItem();
            mensaje("Ingrese datos del usuario..." + empi.getIdemp());
        }*/
    }

    /*void agregar() {
        try {
            Connection con = getConnection();
            String SQL = "insert into usuario(usuario,clave,idempleado) values(?,?,?)";
            String SSQL = "select *from empleado where idempleado ";

            PreparedStatement pst = con.prepareStatement(SQL);

            ResultSet rs = pst.executeQuery(SSQL);
            PreparedStatement ppst = con.prepareStatement(SSQL);

            pst.setString(1, jTextField1.getText());
            pst.setString(2, String.valueOf(jPasswordField1.getPassword()));
            pst.setString(3,String.valueOf(txtIDempleado.getText()));

            pst.execute();
            JOptionPane.showMessageDialog(null, "Resgistro exitoso");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de resgistro " + e.getMessage());
        }
    }*/
    void mostradatos() {
        String[] titulos = {"Nombre", "A.Paterno", "A.Materno", "Cargo"};
        String[] registros = new String[7];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String SQL = "select *from empleado";
        try {
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(SQL);
            //java.sql.Statement st=con.createStatement();
            //java.sql.Statement st=con.createStatement();
            ResultSet rs = pst.executeQuery(SQL);
            while (rs.next()) {
                //registros[0] = rs.getString("idempleado");
                registros[0] = rs.getString("nombre");
                registros[1] = rs.getString("apepaterno");
                registros[2] = rs.getString("apematerno");
                registros[3] = rs.getString("cargo");
                
                modelo.addRow(registros);
            }
            jTable1.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos" + e.getMessage());
        }
    }

    /*
    void agregar() {
        try {
            Connection con = getConnection();
            String SQL = "insert into usuario(usuario,clave,idempleado) values(?,?,?)";
            String SSQL = "select *from empleado where idempleado ";

            PreparedStatement pst = con.prepareStatement(SQL);

            ResultSet rs = pst.executeQuery(SSQL);
            PreparedStatement ppst = con.prepareStatement(SSQL);

            pst.setString(1, jTextField1.getText());
            pst.setString(2, String.valueOf(jPasswordField1.getPassword()));
            pst.setString(3,String.valueOf(txtIDempleado.getText()));

            pst.execute();
            JOptionPane.showMessageDialog(null, "Resgistro exitoso");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de resgistro " + e.getMessage());
        }
    }

    void mostradatos() {
        String[] titulos = {"id", "Nombre", "A.Paterno", "A.Materno", "Cargo"};
        String[] registros = new String[7];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String SQL = "select *from empleado";
        try {
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(SQL);
            //java.sql.Statement st=con.createStatement();
            //java.sql.Statement st=con.createStatement();
            ResultSet rs = pst.executeQuery(SQL);
            while (rs.next()) {
                registros[0] = rs.getString("idempleado");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apepaterno");
                registros[3] = rs.getString("apematerno");
                registros[4] = rs.getString("cargo");

                modelo.addRow(registros);
            }
            jTable1.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos" + e.getMessage());
        }
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        logoRestamita = new javax.swing.JLabel();
        retornaraLacarta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnagregar = new javax.swing.JButton();
        cboEmpleado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        retornaraLacarta.setText("Menu");
        retornaraLacarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retornaraLacartaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(retornaraLacarta, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(retornaraLacarta)
                .addGap(0, 335, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 600));

        jPanel2.setBackground(new java.awt.Color(236, 235, 231));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Crear usuario");

        jLabel2.setText("Usuario");

        jLabel3.setText("Contraseña");

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyTyped(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione Empleado, thx"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Empleado");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        btnagregar.setBackground(new java.awt.Color(236, 235, 231));
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        cboEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmpleadoActionPerformed(evt);
            }
        });
        jPanel3.add(cboEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 50, 200, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 530, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retornaraLacartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retornaraLacartaActionPerformed
        opProg = new OpcionesdePrograma();
        opProg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_retornaraLacartaActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        if (txtUsuario.getText().isEmpty() == true || txtContraseña.getText().isEmpty() == true) {
            mensaje("Llenar todos los campos, porfavore");
        } else {
            insertar();
        }
        
    }//GEN-LAST:event_btnagregarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int filaSeleccionada = jTable1.rowAtPoint(evt.getPoint());
        //txtIDempleado.setText(jTable1.getValueAt(filaSeleccionada, 0).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void cboEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEmpleadoActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        char c = evt.getKeyChar();
        if (c < 'a' || c > 'z') {
            evt.consume();
        }
        if (txtUsuario.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
            evt.consume();
        }
        if (txtContraseña.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtContraseñaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    public javax.swing.JComboBox<Empleado> cboEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel logoRestamita;
    private javax.swing.JButton retornaraLacarta;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
