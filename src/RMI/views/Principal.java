/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.views;

import RMI.bodega.BodegaClient;
import RMI.recepcion.RecepcionClient;
import javax.swing.ImageIcon;

/**
 * 
 *
 * @author nata_
 */
public class Principal extends javax.swing.JFrame {

    ImageIcon logo = new ImageIcon("src/RMI/images/camion.png");
    ImageIcon fondo = new ImageIcon("src/RMI/images/fondo.jpg");
    private RecepcionClient RecepcionClient;
    private BodegaClient BodegaClient;
    
    /**
     * Creates new form Home
     */
    public Principal() {
        initComponents();
        this.RecepcionClient = new RecepcionClient("127.0.0.1");
        this.BodegaClient = new BodegaClient("127.0.0.1");
        setLocationRelativeTo(null);
        labelLogo.setIcon(logo);
        labelFondo.setIcon(fondo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrar = new javax.swing.JButton();
        btnSolicitar = new javax.swing.JButton();
        btnVerificar = new javax.swing.JButton();
        labelLogo = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btnRegistrar.setText("Registrar paquete");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 190, 53));

        btnSolicitar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btnSolicitar.setText("Solicitar envio de paquetes");
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSolicitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 190, 53));

        btnVerificar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btnVerificar.setText("Verificar envio de paquetes");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 190, 60));
        getContentPane().add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 110));

        jButton4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jButton4.setText("Cerrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        RegistroEnvio registro = new RegistroEnvio(this, true);
        registro.setRecepcionClient(this.RecepcionClient);
        registro.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        SolicitudEnvios envio = new SolicitudEnvios(this, true);
        envio.setBodegaClient(this.BodegaClient);
        envio.setRecepcionClient(this.RecepcionClient);
        envio.setVisible(true);
    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        EnviosRealizados envios = new EnviosRealizados(this, true);
        envios.setBodegaClient(this.BodegaClient);
        envios.setVisible(true);
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelLogo;
    // End of variables declaration//GEN-END:variables
}
