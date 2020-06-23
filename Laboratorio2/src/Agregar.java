
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author personal
 */
public class Agregar extends javax.swing.JDialog {
     
    CrearArchivo log = new CrearArchivo();
    
    String[] datos;
    ArrayList<ArrayList<String>> Datosmodi = new ArrayList<ArrayList<String>>();

    /**
     * Creates new form Agregar
     */
    public Agregar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        setLocationRelativeTo(null);
        soloNumero(txtCedula);
        llenarComboDepa();
        llenarComboPuesto();
        txtEdad.setEnabled(true);
        
       
        
    }
   
    private String ConvertirFechaIngreString() {
        Date fecha = calenFechaIngreso.getDate();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaConvertida = formato.format(fecha);
        return fechaConvertida;
    }
    private String ConvertirFechaNaciString() {
       Date fecha = calenFechaNaci.getDate();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaConvertida = formato.format(fecha);
        return fechaConvertida;
    }
    private String SeleccionMasFEME() {
        String resultado = "";
        if (radioboMasculino.isSelected()) {
            resultado = "Masculino";
        } else if (RadiobotonFemenino.isSelected()) {
            resultado = "Femenino";
        }
        return resultado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        radioboMasculino = new javax.swing.JRadioButton();
        RadiobotonFemenino = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cmbDepartamentos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        calenFechaNaci = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        calenFechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        cmbIngles = new javax.swing.JComboBox<>();
        cmbPuesto = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("cedula");

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        jLabel2.setText(" Nombre ");

        jLabel3.setText("Genero");

        radioboMasculino.setText("Masculino");

        RadiobotonFemenino.setText("Femenino");

        jLabel4.setText("Departamentos");

        jLabel5.setText("Puestos");

        jLabel6.setText("Fecha de nacimiento");

        jLabel7.setText("Edad");

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });

        jLabel8.setText("Fecha de ingreso");

        jLabel9.setText("Nivel de inglés");

        cmbIngles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1", "A2", "B1", "B2", "C1" }));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton2.setText("Salir ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(calenFechaNaci, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calenFechaIngreso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbIngles, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPuesto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RadiobotonFemenino)
                            .addComponent(radioboMasculino)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCedula)
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioboMasculino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RadiobotonFemenino)))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cmbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(jLabel6))
                            .addComponent(calenFechaNaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8))
                    .addComponent(calenFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbIngles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(jButton2)
                    .addComponent(btnBuscar)
                    .addComponent(btnEditar))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
       
    }//GEN-LAST:event_jButton2ActionPerformed

 
    

 
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (txtCedula.getText().equals("") || txtNombre.getText().equals("")) {
            JOptionPane.showConfirmDialog(null, "Debe ingresar datos en los espacios vacios");
        }else{
            String cedula = txtCedula.getText();
            String nombre = txtNombre.getText();
            String genero = SeleccionMasFEME();
            String departamentos = (String)cmbDepartamentos.getSelectedItem().toString();
            String fechaNaci = ConvertirFechaNaciString();
            String edad = txtEdad.getText();
            String fechaIngre = ConvertirFechaIngreString();
            String nivelIn= (String) cmbIngles.getSelectedItem().toString();
            String puesto = (String) cmbPuesto.getSelectedItem().toString();
            String datos = cedula + "," + nombre+ "," + genero + "," + departamentos + "," + fechaNaci + "," + edad+ "," + fechaIngre + "," + nivelIn + "," + puesto;
            log.guardarDatos(datos);
            
            
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String registro = null;
        String cedula = txtCedula.getText();
        try {
            File fichero = new File("Datos.txt");
            if (fichero.exists()) {
                BufferedReader leer = new BufferedReader(new FileReader(fichero));
                String linea;
                while (leer.ready()) {
                    linea = leer.readLine();
                    datos = linea.trim().split(",");
                    ArrayList<String> arreglo = new ArrayList<>();
                    for (int i = 0; i < datos.length; i++) {
                        arreglo.add(datos[i]);
                    }
                    Datosmodi.add(arreglo);
                }
                for (int i = 0; i < Datosmodi.size(); i++) {
                    if (cedula.equals(Datosmodi.get(i).get(0))) {
                        txtNombre.setText(Datosmodi.get(i).get(1));
                        Datosmodi.get(i).get(2).equals(SeleccionMasFEME());
                        cmbDepartamentos.getModel().setSelectedItem(Datosmodi.get(i).get(3));

                        txtEdad.setText(Datosmodi.get(i).get(5));

                        cmbIngles.getModel().setSelectedItem(Datosmodi.get(i).get(7));
                        cmbPuesto.getModel().setSelectedItem(Datosmodi.get(i).get(8));

                    
                }
                    
                }
                    
                
                leer.close();

            } else {
                JOptionPane.showMessageDialog(null, "Fichero inexistente!!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed


    }//GEN-LAST:event_txtEdadActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        ArrayList<String> arreglo = new ArrayList<>();
        String cedula = txtEdad.getText();
        String nombre = txtNombre.getText();
        String genero = SeleccionMasFEME();
        String departamentos = String.valueOf(cmbDepartamentos.getSelectedItem());;
        String fechaNaci = ConvertirFechaNaciString();
        String edad = txtEdad.getText();
        String fechaIngreso = ConvertirFechaIngreString();
        String ingles = String.valueOf(cmbIngles.getSelectedItem());
        String puesto = String.valueOf(cmbPuesto.getSelectedItem());

        for (int i = 0; i < Datosmodi.size(); i++) {
            cedula = Datosmodi.get(i).get(0);
            nombre = Datosmodi.get(i).get(1);
            genero = Datosmodi.get(i).get(2);
            departamentos = Datosmodi.get(i).get(3);
            fechaNaci = Datosmodi.get(i).get(4);
            edad = Datosmodi.get(i).get(5);
            fechaIngreso = Datosmodi.get(i).get(6);
            ingles = Datosmodi.get(i).get(7);
            puesto = Datosmodi.get(i).get(8);
            String datos = cedula + ","
                    + nombre + ","
                    + genero + ","
                    + departamentos + ","
                    + fechaNaci + ","
                    + edad + ","
                    + fechaIngreso + ","
                    + ingles + ","
                    + puesto;
            arreglo.add(datos);
        }
        log.modificar(arreglo);
        dispose();
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

   
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
  private void llenarComboDepa() {
        try {

            File archivo;
            FileReader fr;
            BufferedReader br;
            archivo = new File(ruta, "Departamentos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p;
            String linea = br.readLine();
            while (linea != null) {

                String[] campoLinea = linea.split(",");
                p = campoLinea[0].trim();
                linea = br.readLine();

                cmbDepartamentos.addItem(p);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
    }
private void llenarComboPuesto() {
        try {

            File archivo;
            FileReader fr;
            BufferedReader br;
            archivo = new File(ruta, "Puestos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p;
            String linea = br.readLine();
            while (linea != null) {

                String[] campoLinea = linea.split(",");
                p = campoLinea[0].trim();
                linea = br.readLine();

                cmbPuesto.addItem(p);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadiobotonFemenino;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private com.toedter.calendar.JDateChooser calenFechaIngreso;
    private com.toedter.calendar.JDateChooser calenFechaNaci;
    private javax.swing.JComboBox<String> cmbDepartamentos;
    private javax.swing.JComboBox<String> cmbIngles;
    private javax.swing.JComboBox<String> cmbPuesto;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton radioboMasculino;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
