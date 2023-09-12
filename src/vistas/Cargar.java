package vistas;

import com.formdev.flatlaf.*;
import control.Load;
import javax.swing.UIManager;

public final class Cargar extends javax.swing.JFrame {

    public static String tema = "/doki/themes/shokugeki_no_soma/Yukihira_Soma.theme.json";//tema de rojo y negro

    /*temas:
    "/doki/themes/konosuba/Megumin.theme.json";//tema rojo      
    "/doki/themes/miss_kobayashi's_dragon_maid/Tohru.theme.json";
    "/doki/themes/shokugeki_no_soma/Yukihira_Soma.theme.json";//tema de rojo y negro
    "/doki/themes/sword_art_online/Asuna_Light.theme.json";//tema palorosa
    "/doki/themes/sword_art_online/Asuna_Dark.theme.json";//tema dark
    "/doki/themes/nekopara/Cinnamon.theme.json";//tema morado y verde 
     */
    Load hilo;

    public Cargar() {
        initComponents();
        iniciar();
        setResizable(false);
    }

    public void iniciar() {
        setLocationRelativeTo(null);
        hilo = new Load(getprogreso());
        hilo.start();
        hilo = null;
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargando.jpg"))); // NOI18N

        jProgressBar1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jProgressBar1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jProgressBar1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jProgressBar1StateChanged
        if (jProgressBar1.getValue() == 100) {
            this.dispose();
            Login x = new Login();
            x.setVisible(true);
        }
    }//GEN-LAST:event_jProgressBar1StateChanged

    public javax.swing.JProgressBar getprogreso() {
        return jProgressBar1;
    }

    @SuppressWarnings({"unchecked", "Convert2Lambda", "CallToPrintStackTrace", "UseSpecificCatch"})
    public static void main(String args[]) {
        try {

            UIManager.setLookAndFeel(new FlatIntelliJLaf());

        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cargar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
