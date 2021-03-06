/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;



/**
 *
 * @author personal
 */
public class JDMenuAdmi extends javax.swing.JDialog {

    /**
     * Creates new form JDMenuAdmi
     */
    public JDMenuAdmi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        btnMantenimiento = new javax.swing.JRadioButtonMenuItem();
        btnSolicitudes = new javax.swing.JRadioButtonMenuItem();
        btnHistorial = new javax.swing.JRadioButtonMenuItem();
        jMenu5 = new javax.swing.JMenu();
        btnMacotasAdoptadas = new javax.swing.JRadioButtonMenuItem();
        btnGrafico = new javax.swing.JRadioButtonMenuItem();
        cerrar = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perr.jpg"))); // NOI18N

        jMenu3.setText("Opciones ");

        btnMantenimiento.setSelected(true);
        btnMantenimiento.setText("Mantenimiento de mascotas. ");
        btnMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoActionPerformed(evt);
            }
        });
        jMenu3.add(btnMantenimiento);

        btnSolicitudes.setSelected(true);
        btnSolicitudes.setText("Ver solicitudes.");
        btnSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitudesActionPerformed(evt);
            }
        });
        jMenu3.add(btnSolicitudes);

        btnHistorial.setSelected(true);
        btnHistorial.setText("Ver historial.");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        jMenu3.add(btnHistorial);

        jMenuBar2.add(jMenu3);

        jMenu5.setText("Reporte");

        btnMacotasAdoptadas.setSelected(true);
        btnMacotasAdoptadas.setText("Mascotas adoptadas");
        btnMacotasAdoptadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMacotasAdoptadasActionPerformed(evt);
            }
        });
        jMenu5.add(btnMacotasAdoptadas);

        btnGrafico.setSelected(true);
        btnGrafico.setText("Grafico");
        btnGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficoActionPerformed(evt);
            }
        });
        jMenu5.add(btnGrafico);

        jMenuBar2.add(jMenu5);

        cerrar.setText("Cerrar sesión");
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        jMenuBar2.add(cerrar);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        // TODO add your handling code here:
       
  
       
    }//GEN-LAST:event_cerrarActionPerformed

    private void btnMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoActionPerformed
        // TODO add your handling code here:
        JDMantenimiento log = new JDMantenimiento(null, true);
        log.setVisible(true);
        
        
    }//GEN-LAST:event_btnMantenimientoActionPerformed

    private void btnSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitudesActionPerformed
        // TODO add your handling code here:
        JDSolicitudes log = new JDSolicitudes(null,true);
        
        log.setVisible(true);
       
        
    }//GEN-LAST:event_btnSolicitudesActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        // TODO add your handling code here:
        JDHistorial log = new JDHistorial(null,true);
        log.setVisible(true);
        
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        // TODO add your handling code here:
        dispose();
        JDMenuPrincipal log = new JDMenuPrincipal(null, true);

        log.setVisible(true);

    }//GEN-LAST:event_cerrarMouseClicked

    private void btnGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficoActionPerformed
        // TODO add your handling code here:
        JDGrafico log = new JDGrafico(null, true);
        
        log.setVisible(true);
        
    }//GEN-LAST:event_btnGraficoActionPerformed

    private void btnMacotasAdoptadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMacotasAdoptadasActionPerformed
        // TODO add your handling code here:
        JDRepoHisto log = new JDRepoHisto(null, true);
       
        log.setVisible(true);
    }//GEN-LAST:event_btnMacotasAdoptadasActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem btnGrafico;
    private javax.swing.JRadioButtonMenuItem btnHistorial;
    private javax.swing.JRadioButtonMenuItem btnMacotasAdoptadas;
    private javax.swing.JRadioButtonMenuItem btnMantenimiento;
    private javax.swing.JRadioButtonMenuItem btnSolicitudes;
    private javax.swing.JMenu cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    // End of variables declaration//GEN-END:variables
}
