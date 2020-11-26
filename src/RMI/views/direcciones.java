/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 *
 * @author Jesus David Otero
 */
public class direcciones extends javax.swing.JDialog {

    Principal principal;
    ImageIcon logo = new ImageIcon("src/RMI/images/camion.png");
    ImageIcon fondo = new ImageIcon("src/RMI/images/fondo.jpg");

    /**
     * Creates new form direcciones
     */
    public direcciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        labelFondo.setIcon(fondo);
        labelLogo.setIcon(logo);
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public static boolean validIP(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }
        ip = ip.trim();
        if ((ip.length() < 6) & (ip.length() > 15)) {
            return false;
        }

        try {
            Pattern pattern = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
            Matcher matcher = pattern.matcher(ip);
            return matcher.matches();
        } catch (PatternSyntaxException ex) {
            return false;
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

        jLabel1 = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblBodega = new javax.swing.JLabel();
        lblRecepcion = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DIRECCION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        txtDir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 192, 33));

        btnConectar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnConectar.setText("CONEXIÓN");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, 43));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 132, 43));

        lblBodega.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblBodega.setForeground(new java.awt.Color(255, 255, 255));
        lblBodega.setText("BODEGA: OFF");
        getContentPane().add(lblBodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        lblRecepcion.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblRecepcion.setForeground(new java.awt.Color(255, 255, 255));
        lblRecepcion.setText("RECEPCION OFF");
        getContentPane().add(lblRecepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, -1, -1));
        getContentPane().add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 110));
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        if (validIP(txtDir.getText())) {
            if (principal.setdirCon(txtDir.getText())) {
                lblRecepcion.setText("RECEPCION: ON");
                lblBodega.setText("BODEGA: ON");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Direccion IP no es valida, revise el formato. \t Ejemplo: '123.123.78.9'", "direccion ip invalida", WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(direcciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(direcciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(direcciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(direcciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                direcciones dialog = new direcciones(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel lblBodega;
    private javax.swing.JLabel lblRecepcion;
    private javax.swing.JTextField txtDir;
    // End of variables declaration//GEN-END:variables
}
