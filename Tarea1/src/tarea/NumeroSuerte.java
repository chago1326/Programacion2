/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import java.util.Scanner;

/**
 *
 * @author personal
 */
public class NumeroSuerte {
    
    

    public  void numeroSuerte() {
        Scanner var = new Scanner(System.in);
        int dia, mes, año, suerte, num, suma = 0;
        String numero;
        System.out.print("Digite el dia: ");
        dia = var.nextInt();
        System.out.print("Digite el mes: ");
        mes = var.nextInt();
        System.out.print("Digite el año: ");
        año = var.nextInt();
        suerte = dia + mes + año;
        numero = String.valueOf(suerte);
        for (int i = 0; i < 4; i++) {
            char indice = numero.charAt(i);
            num = Integer.parseInt(String.valueOf(indice));
            suma += num;
        }
        System.out.println("El numero de suerte es: " + suma);
    }
    
     public static void main(String[] args) {
         NumeroSuerte log = new NumeroSuerte();
         
         log.numeroSuerte();
         
     }
       
}

    

