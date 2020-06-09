/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import java.awt.HeadlessException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author personal
 */
public class Transporte {

    private static int input(String text) {
        return Integer.parseInt(JOptionPane.showInputDialog(text));
    }

    private String nombre;
    private String cedula;
    private String tipoCamion;
    private String tipoDeCarga;
    private String[] registro;

    public Transporte(String pNombre, String pCedula, String pTipoCamion, String pTipoDeCarga) {
        this.registro = new String[4];
        this.nombre = pNombre;
        this.cedula = pCedula;
        this.tipoCamion = pTipoCamion;
        this.tipoDeCarga = pTipoDeCarga;
        this.registro = new String[4];
    }

    public void agregarChoferes(String nom, String ced, String tipoCam, String tipoCarg) {
        for (int i = 0; i < registro.length; i++) {
            registro[0] = nom;
            registro[1] = ced;
            registro[2] = tipoCam;
            registro[3] = tipoCarg;

        }
        System.out.println(Arrays.toString(registro));

    }

    public void consultarChof(String numCedula) {

        try {
            String datos;

            if (registro[1].equals(numCedula)) {

                datos = "|Nombre: " + registro[0] + "\n"
                        + "|N°Ced: " + registro[1] + "\n"
                        + "|Tipo de Camión: " + registro[2] + "\n"
                        + "|Transporta Materiales peligroso: " + registro[3];
                JOptionPane.showMessageDialog(null, datos);
            } else {
                JOptionPane.showMessageDialog(null, "Chofer no registrado!!");
            }

        } catch (HeadlessException e) {
            System.out.println("Error, detalles: " + e.getMessage());
        }

    }

    

    public static void main(String[] args) {
       

        String pNombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
        String pCedula = JOptionPane.showInputDialog("Ingrese su cedula: ");
        String pTipoCamion = JOptionPane.showInputDialog("Ingrese el tipo de camion: ");
        String pTipoDeCarga = JOptionPane.showInputDialog("Ingrese el tipo de carga del camion: ");

        Transporte log = new Transporte(pNombre, pCedula, pTipoCamion, pTipoDeCarga);

        boolean salir = false;
        int opcion;

        while (!salir) {
           opcion = input("__Menu___ " + "\n"
                    + "1.Agregar"+ "\n"
                    + "2.Consultas" + "\n"
                    + "3.Salir" + "\n"
                    + "Seleccione una opcion: ");
           
          
        

        switch (opcion) {

            case 1:
                String Nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
                String Cedula = JOptionPane.showInputDialog("Ingrese su cedula: ");
                String TipoCamion = JOptionPane.showInputDialog("Ingrese el tipo de camion: ");
                String TipoDeCarga = JOptionPane.showInputDialog("Ingrese el tipo de carga del camion: ");

                log.agregarChoferes(Nombre, Cedula, TipoCamion, TipoDeCarga);

                break;

            case 2:
                String cedula = JOptionPane.showInputDialog("Ingrese su cedula: ");

                log.consultarChof(cedula);
                break;

            case 3:

                JOptionPane.showMessageDialog(null, "Gracias por utilizar la aplicacion!!");
                salir = true;
                break;

            default:
                System.out.println("Usted ingreso una opcion invalida");

        } 
        
        }

    }

}
