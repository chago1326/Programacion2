/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class hDeportiva extends Vehiculo {

    private int Potencia;
    private int velocidadMax;

    public hDeportiva(int Potencia, int velocidadMax, String matricula, String marca, String modelo, String color) {
        super(matricula, marca, modelo, color);
        this.Potencia = Potencia;
        this.velocidadMax = velocidadMax;
    }

    

   

    public String getAtributos() {
        return super.getAtributos()
                + " Cilindrada (cm3): " + this.Potencia
                + "Velocidad Maxima: " + this.velocidadMax;
    }
    String ruta = "C:\\TXT";
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
}
