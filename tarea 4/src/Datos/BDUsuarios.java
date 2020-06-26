/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import presentacion.FrmMenu;


/**
 *
 * @author personal
 */
public class BDUsuarios {
    public int numnota1;
    public int numnota2;
    public int numnota3;
    
    FrmMenu log = new FrmMenu();
    
     public void InsertarEnArchivo(String lista) {
        try {
            File archivo = new File("ListaEstudiantes.txt");
            BufferedWriter archi = new BufferedWriter(new FileWriter(archivo, true));
            archi.write(lista + "\r\n");
            JOptionPane.showMessageDialog(null, "Insertado con exito!");
            archi.close();
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo" + e);
        }
    }
    

    public void BuscarEstudiante(File archivo, String nombre){
        try {
            
            if(archivo.exists()) {
                
                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
               
                String lineaLeida;
                 JOptionPane.showMessageDialog(null, "*******Buscando*************");
               
                while((lineaLeida = leerArchivo.readLine()) != null) {
                    
                    String[] palabras = lineaLeida.split(",");
                    for(int i = 0 ; i < palabras.length ; i++) {
                        if(palabras[i].equals(nombre)) {
                            JOptionPane.showMessageDialog(null, "Nombre: " + palabras[0] + "\n"
                                    + "Apellido: " + palabras[1] 
                            );

 
                            JOptionPane.showMessageDialog(null,"**********");
                        }
                    }
                }
            }
           
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
    }
     public void BuscarLogin(File archivo, String Usuario,String contra){
        try {
            
            if(archivo.exists()) {
                
                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
               
                String lineaLeida;
                 JOptionPane.showMessageDialog(null, "*******Buscando*************");
               
                while((lineaLeida = leerArchivo.readLine()) != null) {
                    
                    String[] palabras = lineaLeida.split(",");
                    for (int i = 0; i < palabras.length; i++) {
                        if (palabras[i].equals(Usuario)){
                            
                        }
                        for (int x = 0; i < palabras.length; x++) {
                            if (palabras[x].equals(contra)) {
                                JOptionPane.showMessageDialog(null, "Bienvenido " + Usuario);
                                log.pack();
                                log.setVisible(true);

                                
                             

                            }

                        }
                    }
                }
            }
           
        } catch(Exception e) {
            
        }
        
    }
     public void BuscarEstudianteNota(File archivo, String nombre){
        try {
            
            if(archivo.exists()) {
                
                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
               
                String lineaLeida;
                 JOptionPane.showMessageDialog(null, "*******Buscando*************");
               
                while((lineaLeida = leerArchivo.readLine()) != null) {
                    
                    String[] palabras = lineaLeida.split(",");
                    for(int i = 0 ; i < palabras.length ; i++) {
                        if(palabras[i].equals(nombre)) {
                            JOptionPane.showMessageDialog(null,"Sus notas fueron "+ palabras[2] + "\n"
                            + palabras[3] + "\n"+ palabras[4] );
                            numnota1 = Integer.parseInt(palabras[2]);
                            numnota2 = Integer.parseInt(palabras[3]);
                            numnota3 = Integer.parseInt(palabras[4]);
                            
                           

 
                            JOptionPane.showMessageDialog(null,"**********");
                        }
                    }
                }
            }
           
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
    }
     
     
     public void llenarComboDepa(JComboBox CMB) {
        try {

            File archivo;
            FileReader fr;
            BufferedReader br;
            archivo = new File("ListaEstudiantes.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p;
            String linea = br.readLine();
            while (linea != null) {

                String[] campoLinea = linea.split(",");
                p = campoLinea[0].trim();
                linea = br.readLine();

                CMB.addItem(p);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
    }
    
  
    
        
    
}
