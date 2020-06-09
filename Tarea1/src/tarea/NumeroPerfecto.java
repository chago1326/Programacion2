/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author personal
 */
public class NumeroPerfecto {

    private static int input(String text) {
        return Integer.parseInt(JOptionPane.showInputDialog(text));
    }

    public void numeroPer(int numUsua) {
        int divi;
        int suma = 0;
        String perfecto = "Es perfecto";
        String noPer = "No es perfecto";
        for (divi = 1; divi < numUsua; divi++) {
            if (numUsua % divi == 0) {
                suma = suma + divi;
            }
        }
        if (suma == numUsua) {
             JOptionPane.showMessageDialog(null,perfecto);
        } else {
            JOptionPane.showMessageDialog(null,noPer);

        }
    }
        
        
         

    public static void main(String[] args) {
        NumeroPerfecto log = new NumeroPerfecto();
        Scanner sc = new Scanner(System.in);
        int usuario = input("Introduce un número: ");;
        

        log.numeroPer(usuario);

    }

}


