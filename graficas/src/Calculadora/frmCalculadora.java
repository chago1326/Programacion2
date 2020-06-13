/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

import javax.swing.JOptionPane;

/**
 *
 * @author Ricardo Millon
 */
public class frmCalculadora extends javax.swing.JFrame {

    /**
     * Creates new form frmCalculadora
     */
    public frmCalculadora() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOperador1 = new javax.swing.JLabel();
        lblOperador2 = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();
        lblOperacion = new javax.swing.JLabel();
        numOperador1 = new javax.swing.JSpinner();
        numOperador2 = new javax.swing.JSpinner();
        numResultado = new javax.swing.JSpinner();
        cmbOperacion = new javax.swing.JComboBox<>();
        btnCalcular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblOperador1.setText("Operador 1:");

        lblOperador2.setText("Operador 2:");

        lblResultado.setText("Resultado:");

        lblOperacion.setText("Operación:");

        numOperador1.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        numOperador2.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        numResultado.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        numResultado.setEnabled(false);

        cmbOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sumar (+)", "Restar (-)", "Multiplicar (*)", "Dividir (/)" }));

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCalcular)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblOperador1)
                            .addGap(18, 18, 18)
                            .addComponent(numOperador1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblOperador2)
                                .addComponent(lblResultado)
                                .addComponent(lblOperacion))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(numOperador2)
                                .addComponent(numResultado)
                                .addComponent(cmbOperacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOperador1)
                    .addComponent(numOperador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOperacion)
                    .addComponent(cmbOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOperador2)
                    .addComponent(numOperador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResultado)
                    .addComponent(numResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCalcular)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:        
        String operacion = ""; 
        switch((String)this.cmbOperacion.getSelectedItem()){
            case "Sumar (+)":
                operacion = "+";
                break;               
            case "Restar (-)":
                operacion = "-";
                break;
            case "Multiplicar (*)":
                operacion = "*";
                break;
            case "Dividir (/)":
                operacion = "/";
                break;
        }
        try{
            Calculadora oCalculadora = new Calculadora();
            oCalculadora.setOperacion(operacion);
            oCalculadora.setOperando1((Double)this.numOperador1.getValue());
            oCalculadora.setOperando2((Double)this.numOperador2.getValue());
            this.numResultado.setValue(oCalculadora.ejecutarOperacion());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCalcularActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JComboBox<String> cmbOperacion;
    private javax.swing.JLabel lblOperacion;
    private javax.swing.JLabel lblOperador1;
    private javax.swing.JLabel lblOperador2;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JSpinner numOperador1;
    private javax.swing.JSpinner numOperador2;
    private javax.swing.JSpinner numResultado;
    // End of variables declaration//GEN-END:variables
}