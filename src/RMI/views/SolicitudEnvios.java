/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.views;

import RMI.bodega.BodegaClient;
import RMI.elements.Ciudad;
import RMI.elements.Departamento;
import RMI.elements.Paquete;
import RMI.elements.Coordenadas;
import RMI.recepcion.RecepcionClient;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nata_
 */
public class SolicitudEnvios extends javax.swing.JDialog {

    ImageIcon logo = new ImageIcon("src/RMI/images/camion1.png");
    ImageIcon fondo = new ImageIcon("src/RMI/images/fondo.jpg");
    private BodegaClient BodegaClient;
    private RecepcionClient RecepcionClient;
    private ArrayList<Paquete> paquetes;
    private DefaultTableModel model;
    private ArrayList<Ciudad> ciudades;

    /**
     * Creates new form Envio
     */
    public SolicitudEnvios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        labelLogo.setIcon(logo);
        labelFondo.setIcon(fondo);
    }

    public void setBodegaClient(BodegaClient clienteBodega) {
        this.BodegaClient = clienteBodega;
        this.paquetes = this.BodegaClient.obtenerPBodega();
        this.generateForms();
    }

    public void setRecepcionClient(RecepcionClient clienteRecepcion) {
        this.RecepcionClient = clienteRecepcion;

        for (Departamento departamento : this.RecepcionClient.obtenerDepartamentos()) {
            CBDepartamento.addItem(departamento.getNombre());
        }
    }

    private void generateForms() {
        this.model = (DefaultTableModel) tableSolicitud.getModel();
        if (this.paquetes != null) {
            for (Paquete paquete : this.paquetes) {
                model.addRow(new Object[]{paquete.getNombreEmisor(), paquete.getCiudadEmisor(), paquete.getNombreReceptor(), paquete.getCiudadReceptor(), paquete.getCoordenadas().getLatitud(), paquete.getCoordenadas().getLongitud(), paquete.getEstado(), paquete.getPeso()});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableSolicitud = new javax.swing.JTable();
        btnSolicitar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CBDepartamento = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        CBCiudad = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCapacidadC = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();
        labelLogo = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableSolicitud.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        tableSolicitud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emisor", "Ciudad Emision", "Receptor", "Ciudad Destino", "Latitud", "Longitud", "Estado", "Peso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableSolicitud);
        if (tableSolicitud.getColumnModel().getColumnCount() > 0) {
            tableSolicitud.getColumnModel().getColumn(0).setResizable(false);
            tableSolicitud.getColumnModel().getColumn(1).setResizable(false);
            tableSolicitud.getColumnModel().getColumn(2).setResizable(false);
            tableSolicitud.getColumnModel().getColumn(3).setResizable(false);
            tableSolicitud.getColumnModel().getColumn(4).setResizable(false);
            tableSolicitud.getColumnModel().getColumn(5).setResizable(false);
            tableSolicitud.getColumnModel().getColumn(6).setResizable(false);
            tableSolicitud.getColumnModel().getColumn(7).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 110, 720, 282));

        btnSolicitar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btnSolicitar.setText("Solicitar Envío");
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSolicitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 221, 40));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SOLICITUD DE ENVÍO DE PAQUETES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        CBDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBDepartamentoActionPerformed(evt);
            }
        });
        getContentPane().add(CBDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 169, 31));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Departamento:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, -1, -1));

        getContentPane().add(CBCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 172, 31));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ciudad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Capacidad camion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, -1, -1));
        getContentPane().add(txtCapacidadC, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, 170, 31));

        btnCerrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 230, 40));
        getContentPane().add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, 70));
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 570));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Datos Camión");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        String ciudad = CBCiudad.getSelectedItem().toString();
        double peso = 0;
        if (ciudad.equals("")) {
            JOptionPane.showMessageDialog(null, "No deben haber campos vacíos");
            return;
        }

        try {
            peso = Double.parseDouble(txtCapacidadC.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "El peso ingresado no es válido");
            return;
        }

        Coordenadas ubicacion = null;
        
        for (Ciudad c : this.ciudades) {
            if(c.getNombre().equals(ciudad)){
                ubicacion = c.getCoordenadas();
                break;
            }
        }

        this.BodegaClient.solicitarEnvioPaquetes(ubicacion, peso);
        this.dispose();
    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void CBDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBDepartamentoActionPerformed
        String nombreCiudad = CBDepartamento.getSelectedItem().toString();
        CBCiudad.removeAllItems();
        this.ciudades = this.RecepcionClient.obtenerCiudades(nombreCiudad);
        for (Ciudad ciudad : this.ciudades) {
            CBCiudad.addItem(ciudad.getNombre());
        }
    }//GEN-LAST:event_CBDepartamentoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBCiudad;
    private javax.swing.JComboBox<String> CBDepartamento;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JTable tableSolicitud;
    private javax.swing.JTextField txtCapacidadC;
    // End of variables declaration//GEN-END:variables
}
