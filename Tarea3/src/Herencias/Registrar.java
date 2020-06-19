/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencias;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Herencias.hDeportiva;
import Herencias.hFurgoneta;
/**
 *
 * @author personal
 */
public class Registrar extends javax.swing.JDialog {
    private hDeportiva log;
    private hFurgoneta fur;

    /**
     * Creates new form Registrar
     */
    public Registrar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        llenarComboColor();
        llenarComboVehiculos();
        soloNumero(txtPrecio);
      
        
       
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Disponibles = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbMarcas = new javax.swing.JComboBox<>();
        cmbColor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtPotencia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbVelocidad = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jradiosi = new javax.swing.JRadioButton();
        jradioNo = new javax.swing.JRadioButton();
        guardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Escoge la marca del vehiculo");

        jLabel2.setText("Color");

        jLabel3.setText("Ingrese el precio del vehiculo");

        jLabel4.setText("$");

        jLabel5.setText("Ingrese Placa");

        jLabel6.setText("Tipo de vehiculo");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deportivo", "Furgoneta", "N/C" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        jLabel7.setText("Potencia");

        jLabel8.setText("Velocidad maxima");

        cmbVelocidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100 km/h", "150 km/h", "200 km/h" }));

        jLabel9.setText("Capacidad");

        jLabel10.setText("Disponible");

        Disponibles.add(jradiosi);
        jradiosi.setText("Si");

        Disponibles.add(jradioNo);
        jradioNo.setText("No");

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jradiosi)
                                .addGap(10, 10, 10)
                                .addComponent(jradioNo))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbMarcas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtPlaca)
                                .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPotencia)
                                .addComponent(cmbVelocidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCapacidad))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(guardar)
                        .addGap(66, 66, 66)
                        .addComponent(jButton2)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jradiosi)
                    .addComponent(jradioNo))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(jButton2))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

  
    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
         if (cmbTipo.getSelectedItem().equals("Deportivo")) {
            txtCapacidad.setEnabled(false);
            jradiosi.setEnabled(false);
            jradioNo.setEnabled(false);

        }else if (cmbTipo.getSelectedItem().equals("Furgoneta")){
            txtPotencia.setEnabled(false);
            cmbVelocidad.setEnabled(false);
        }
        
    
        
    }//GEN-LAST:event_cmbTipoActionPerformed

    
     public void InsertarEnArchivoDepor(String lista) {
        try {
            File archivo = new File(ruta,"carro.txt");
            BufferedWriter archi = new BufferedWriter(new FileWriter(archivo, true));
            archi.write(lista + "\r\n");
            archi.close();
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo" + e);
        }
    }
    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        String tipo = (String) cmbTipo.getSelectedItem().toString();
        switch (tipo) {
            case "Deportivo":
                try {
                    String MARCA = (String) cmbMarcas.getSelectedItem().toString();
                String color = (String) cmbColor.getSelectedItem().toString();
                String precio = txtPrecio.getText();
                String placa = txtPlaca.getText();
                String tip = (String) cmbTipo.getSelectedItem().toString();
                String potencia = txtPotencia.getText();
                String velo = (String) cmbVelocidad.getSelectedItem().toString();
                String datos = MARCA + " , " + color + " , " + precio + " , " + placa + " , " + tip + " , " + potencia + " , " + velo;
                InsertarEnArchivoDepor(datos);
                setVisible(false);
                break;
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "ERROR" + e);
                }
               
            case "Furgoneta":
                try {
                    String MARCA2 = (String) cmbMarcas.getSelectedItem().toString();
                    String color3 = (String) cmbColor.getSelectedItem().toString();
                    String precio4 = txtPrecio.getText();
                    String placa5 = txtPlaca.getText();
                    String tip6 = (String) cmbTipo.getSelectedItem().toString();
                    String capa = txtCapacidad.getText();
                    String dis = SeleccionRadioButton();
                    String datos2 = MARCA2 + " , " + color3 + " , " + precio4 + " , " + placa5 + " , " + tip6 + " , " + capa + " , " + dis;
                    InsertarEnArchivoDepor(datos2);
                    setVisible(false);
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR" + e);
                }

                
                
        }
        
    }//GEN-LAST:event_guardarActionPerformed

   private String SeleccionRadioButton() {
        String res = "";
        if (jradiosi.isSelected()) {
            res = "Si";
        } else if (jradioNo.isSelected()) {
            res = "No";
        }
        return res;
    }

    
    
    public void soloNumero(JTextField a){
      a.addKeyListener(new KeyAdapter() {
       public void keyTyped(KeyEvent e){
           char c = e.getKeyChar();
           if(!Character.isDigit(c)){
               getToolkit().beep();
               e.consume();
           }
           
       }
});
        
        
    }
    String ruta = "C:\\TXT";
  private void llenarComboVehiculos() {
        try {

            File archivo;
            FileReader fr;
            BufferedReader br;
            archivo = new File(ruta, "vehiculos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p;
            String linea = br.readLine();
            while (linea != null) {

                String[] campoLinea = linea.split(",");
                p = campoLinea[0].trim();
                linea = br.readLine();

                cmbMarcas.addItem(p);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
    }

  private void llenarComboColor() {
        try {

            File archivo;
            FileReader fr;
            BufferedReader br;
            archivo = new File(ruta, "color.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p;
            String linea = br.readLine();
            while (linea != null) {

                String[] campoLinea = linea.split(",");
                p = campoLinea[0].trim();
                linea = br.readLine();

                cmbColor.addItem(p);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Disponibles;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbColor;
    private javax.swing.JComboBox<String> cmbMarcas;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JComboBox<String> cmbVelocidad;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jradioNo;
    private javax.swing.JRadioButton jradiosi;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPotencia;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
