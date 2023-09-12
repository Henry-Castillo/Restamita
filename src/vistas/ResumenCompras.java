package vistas;

import static conexiones.Conexion.getConnection;
import crearPDF.PlantillaPDF;
import crearPDF.PostrePDF;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ResumenCompras extends javax.swing.JFrame {

    OpcionesdePrograma op;
    Carta carta;
    JFramePostres p1;
    ArrayList<PostrePDF> postres;
    DefaultTableModel modelo;
    PlantillaPDF plantilla;

    public ResumenCompras() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        postres = new ArrayList<>();
        listarXD();
        //mostrarVistaPrevia();
    }

    String darCantidad() {
        return CantidadModificar.getText();
    }

    String darNombre() {
        return NombreModifcar.getText();
    }

    public void retornarStock() {
        try {
            Connection con = getConnection();
            String SQL = "UPDATE postre SET cantidad = cantidad + ? WHERE nombre = ?  ";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, darCantidad());
            pst.setString(2, darNombre());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de resgistro " + e.getMessage());
        }
    }

    void listarXD() {
        String[] titulos = {"Indice", "Nombre", "Precio", "Cantidad"};
        String[] registros = new String[7];
        modelo = new DefaultTableModel(null, titulos);
        //modelo = (DefaultTableModel) tablaPrevia.getModel();
        String SQL = "select *from postrestemporales";
        try {
            Connection con = getConnection();
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                registros[0] = rs.getString("idpostrestemporales");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("precio");
                registros[3] = rs.getString("cantidad");
                modelo.addRow(registros);
            }
            tablaPrevia.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos" + e.getMessage());
        }
    }

    void limpiarCampos() {
        NombreModifcar.setText("");
        PrecioModificar.setText("");
        CantidadModificar.setText("");
    }

    void mostrarVistaPrevia() {
        String[] titulos = {"Indice", "Nombre", "Precio", "Cantidad"};
        String[] registros = new String[7];
        modelo = new DefaultTableModel(null, titulos);
        //modelo = (DefaultTableModel) tablaPrevia.getModel();
        String SQL = "select *from postrestemporales";
        try {
            Connection con = getConnection();
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                registros[0] = rs.getString("idpostrestemporales");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("precio");
                registros[3] = rs.getString("cantidad");
                modelo.addRow(registros);
                PostrePDF e = new PostrePDF(registros[0], registros[1], registros[2], registros[3]);
                postres.add(e);
            }
            tablaPrevia.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos" + e.getMessage());
        }
    }

    void mensajeError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", 0);
    }

    void modificar() {
        try {
            Connection con = getConnection();
            String SQL = "update postrestemporales set nombre=?,precio=?,cantidad=? where idpostrestemporales=?";
            int filaSeleccinado = tablaPrevia.getSelectedRow();
            String dao = (String) tablaPrevia.getValueAt(filaSeleccinado, 0);

            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, NombreModifcar.getText());
            pst.setString(2, PrecioModificar.getText());
            pst.setString(3, CantidadModificar.getText());
            pst.setString(4, dao);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado exitosamente");
            mostrarVistaPrevia();
            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de edición " + e.getMessage());
        }
    }

    public void eliminar() {
        int filaselect = tablaPrevia.getSelectedRow();
        try {
            Connection con = getConnection();
            String SQL = "delete from postrestemporales where idpostrestemporales=" + tablaPrevia.getValueAt(filaselect, 0);
            PreparedStatement pst = con.prepareStatement(SQL);
            int n = pst.executeUpdate(SQL);
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                mostrarVistaPrevia();
                limpiarCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro " + e.getMessage());
        }
    }

    public void procesarCompra() {
        try {
            Connection con = getConnection();
            String SQL = "delete from postrestemporales";
            /*PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, darCantidad());
            pst.setString(2, darNombre());
            pst.execute();*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de resgistro " + e.getMessage());
        }
    }

    public String pagos2() {
        double total = 0;
        for (int i = 0; i < tablaPrevia.getRowCount(); i++) {
            total += Double.parseDouble(tablaPrevia.getValueAt(i, 2).toString()) * Double.parseDouble(tablaPrevia.getValueAt(i, 3).toString());
        }
        return "S/. " + String.valueOf(total);
    }

  /*  public void crearPDFRestamita() {
        mostrarVistaPrevia();
        plantilla = new PlantillaPDF(
                "Dynamite Team",
                new Date().toString(),
                "src/imagenes/Restamita3.png",
                this.postres,
                pagos2());
        plantilla.crearPlantilla();
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        logoRestamita = new javax.swing.JLabel();
        retornaraLacarta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrevia = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NombreModifcar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PrecioModificar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CantidadModificar = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btncomprar = new javax.swing.JButton();
        btnPostres = new javax.swing.JButton();

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

        retornaraLacarta.setText("Regresar a la carta");
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
                .addGap(43, 43, 43)
                .addComponent(retornaraLacarta, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(retornaraLacarta)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 600));

        jPanel2.setBackground(new java.awt.Color(236, 235, 231));

        tablaPrevia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Producto", "Nombre", "Precio", "Cantidad"
            }
        ));
        tablaPrevia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPreviaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPrevia);
        if (tablaPrevia.getColumnModel().getColumnCount() > 0) {
            tablaPrevia.getColumnModel().getColumn(1).setPreferredWidth(220);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Resumen de compras");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Modifica o Eliminar");

        jLabel3.setText("Nombre:");

        NombreModifcar.setEditable(false);
        NombreModifcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreModifcarActionPerformed(evt);
            }
        });

        jLabel4.setText("Precio:");

        PrecioModificar.setEditable(false);

        jLabel5.setText("Cantidad:");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Elimina");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btncomprar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncomprar.setText("PROCESAR COMPRA");
        btncomprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncomprarActionPerformed(evt);
            }
        });

        btnPostres.setText("Postres");
        btnPostres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 149, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(55, 55, 55)
                        .addComponent(btnPostres)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(148, 148, 148)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(NombreModifcar)
                                            .addComponent(PrecioModificar)
                                            .addComponent(CantidadModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(btncomprar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(52, 52, 52)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPostres)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NombreModifcar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(PrecioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CantidadModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(btncomprar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 530, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retornaraLacartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retornaraLacartaActionPerformed
        op = new OpcionesdePrograma();
        op.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_retornaraLacartaActionPerformed

    private void tablaPreviaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPreviaMouseClicked
        int filaSeleccionada = tablaPrevia.rowAtPoint(evt.getPoint());
        NombreModifcar.setText(tablaPrevia.getValueAt(filaSeleccionada, 1).toString());
        PrecioModificar.setText(tablaPrevia.getValueAt(filaSeleccionada, 2).toString());
        CantidadModificar.setText(tablaPrevia.getValueAt(filaSeleccionada, 3).toString());
        CantidadModificar.requestFocus();
    }//GEN-LAST:event_tablaPreviaMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        retornarStock();
        eliminar();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btncomprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncomprarActionPerformed
        ResumenComprasContinuacion rcc = new ResumenComprasContinuacion();
        rcc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btncomprarActionPerformed

    private void NombreModifcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreModifcarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreModifcarActionPerformed

    private void btnPostresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostresActionPerformed
        p1 = new JFramePostres();
        p1.setVisible(true);
    }//GEN-LAST:event_btnPostresActionPerformed

    public void abrir(String nombreDirector) {
        try {
            File path = new File(nombreDirector + ".pdf");
            Desktop.getDesktop().open(path);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Atención", 2);
        }
    }

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
            java.util.logging.Logger.getLogger(ResumenCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResumenCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResumenCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResumenCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResumenCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField CantidadModificar;
    public javax.swing.JTextField NombreModifcar;
    public javax.swing.JTextField PrecioModificar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnPostres;
    private javax.swing.JButton btncomprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoRestamita;
    private javax.swing.JButton retornaraLacarta;
    public javax.swing.JTable tablaPrevia;
    // End of variables declaration//GEN-END:variables
}
