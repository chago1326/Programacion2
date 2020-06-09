/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author personal
 */
public class AdivinarNumero {
    private static int input(String text) {
		return Integer.parseInt(JOptionPane.showInputDialog(text));}
    public static void main(String[] args) {
		Random r = new Random();
		int numaAleatorio = r.nextInt(10); 
		int i = 0; 
		int numUsuario = input("Adivina el número secreto entre 0 y 10. ¿Que número es?");
		while (numaAleatorio != numUsuario) { 
			i++; 
			if (numaAleatorio > numUsuario) {
				numUsuario = input("El número a adivinar es más grande. \n Intentelo otra vez");
			} else {
				numUsuario = input("El número a adivinar es más chico. \n Intentelo otra vez");
			}
		}
		JOptionPane.showMessageDialog(null,
				"Felicitaciones ha dado con el número con " + i + " intentos fallidos");
	}

	

	 
	
    
}
