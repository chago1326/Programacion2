/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CrearArchivo {

    public void crearArchivo() {
        try {
            File archivo = new File("Datos.txt");
            archivo.createNewFile();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en el archivo \n"
                    + "Detalles: " + e);
        }
    }

    public void guardarDatos(String lista) {
        try {
            File archivo = new File("Datos.txt");
            BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo, true));
            escribir.write(lista + "\r\n");
            escribir.close();
            JOptionPane.showMessageDialog(null, "Registro guardado exitosamente!!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos \n"
                    + "Detalles: " + e);
        }
    }

    public void modificar(ArrayList<String> lista) {
        try {
            File archivo = new File("Datos.txt");
            FileWriter escribir = new FileWriter(archivo);
            for (int i = 0; i < lista.size(); i++) {
                escribir.write(lista.get(i) + "\r\n");
            }
            escribir.close();
            JOptionPane.showMessageDialog(null, "Registro modificado exitosamente!!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos \n"
                    + "Detalles: " + e.getMessage());
        }
    }
}
