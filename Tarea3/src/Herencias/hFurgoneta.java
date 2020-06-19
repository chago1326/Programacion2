/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author personal
 */
public class hFurgoneta extends Vehiculo {
    
   private int capacidad;
   private String disponibilidad;

    public hFurgoneta(int capacidad, String disponibilidad, String matricula, String marca, String modelo, String color) {
        super(matricula, marca, modelo, color);
        this.capacidad = capacidad;
        this.disponibilidad = disponibilidad;
    }
   
    public String getAtributos() {
        return super.getAtributos()
                + " Capacidad: " + this.capacidad
                + "Disponible: " + this.disponibilidad;
    }
   
     public void InsertarEnArchivoFurgo(String lista,String ruta,String lugar) {
        try {
            File archivo = new File(ruta,lugar);
            BufferedWriter archi = new BufferedWriter(new FileWriter(archivo, true));
            archi.write(lista + "\r\n");
            archi.close();
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo" + e);
        }
    }
}
