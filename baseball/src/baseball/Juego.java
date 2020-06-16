/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author personal Ricardo 
 */
public class Juego {

    private String jugar1;
    private String jugar2;
    
    private int puntojuga1;

    private int conpunes1;
    private int conpunes2;
    private int conpunes3;
    private int puntosTotales;
    private int lanzamiento;
    
    
    
    private int conpunes4;
    private int conpunes5;
    private int conpunes6;
    private int puntosTotales2;
     private int puntojuga2;

    private int[] estante1 = {1, 1, 1, 1, 2};
    private int[] estante2 = {1, 1, 1, 1, 2};
    private int[] estante3 = {2, 2, 2, 2, 2};

    private static int input(String text) {
        return Integer.parseInt(JOptionPane.showInputDialog(text));
    }

    public void juego(){
       jugar1 = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador uno");
           this.jugar1();
           this.jugar2();
           this.jugar3();
  
       jugar2 = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador dos");
           this.jugar4();
           this.jugar5();
           this.jugar6();
       
       
    }
    
    public void jugar1() {
        
        this.conpunes1 = 0;

        for (int i = 0; i < estante1.length; i++) {
            Random r = new Random();
            int numaAleatorio = r.nextInt(5);

            if (i == numaAleatorio) {
                this.conpunes1 = conpunes1 + 1;
                lanzamiento = input("Digite uno para lanzar la pelota: ");
            } else if (estante1[4] == numaAleatorio) {
                this.conpunes1 = conpunes1 + 2;

            } else {
                this.conpunes1 = conpunes1 + 0;

                lanzamiento = input("Digite uno para lanzar la pelota: ");

            }

        }

        JOptionPane.showMessageDialog(null, "Sus puntos fueron!!" + this.conpunes1);

        JOptionPane.showMessageDialog(null, "Has terminado el estante numero uno, seguiras con el estante numero dos!!");

    }

    public void jugar2() {
        this.conpunes2 = 0;

        for (int i = 0; i < estante2.length; i++) {
            Random r = new Random();
            int numaAleatorio = r.nextInt(5);

            if (i == numaAleatorio) {
                this.conpunes2 = conpunes2 + 1;
                lanzamiento = input("Digite uno para lanzar la pelota: ");
            } else if (estante2[4] == numaAleatorio) {
                this.conpunes2 = conpunes2 + 2;

            } else {
                this.conpunes2 = conpunes2 + 0;

                lanzamiento = input("Digite uno para lanzar la pelota: ");

            }

        }

        JOptionPane.showMessageDialog(null, "Sus puntos fueron!!" + this.conpunes2);
        JOptionPane.showMessageDialog(null, "Has terminado el estante numero dos, seguiras con el estante numero tres!!");

    }

    public void jugar3() {

        this.conpunes3 = 0;

        for (int i = 0; i < estante3.length; i++) {
            Random r = new Random();
            int numaAleatorio = r.nextInt(5);

            if (i == numaAleatorio) {
                this.conpunes3 = conpunes3 + 2;
                lanzamiento = input("Digite uno para lanzar la pelota: ");
                

             }else {
                this.conpunes3 = conpunes3 + 0;

                lanzamiento = input("Digite uno para lanzar la pelota: ");

            }

        }

        JOptionPane.showMessageDialog(null, "Sus puntos fueron!!" + this.conpunes3);
        JOptionPane.showMessageDialog(null, "Fin de la partida del jugardor uno le corresponde al jugador dos !!");

    }

    public String toString() {
        this.puntosTotales = conpunes1 + conpunes2 + conpunes3;
        String detalle = "Puntos totales del jugador " +jugar1 + " " + puntosTotales;

        return detalle;

    }
    
    
    
    public void jugar4() {
        
        this.conpunes4 = 0;

        for (int i = 0; i < estante1.length; i++) {
            Random r = new Random();
            int numaAleatorio = r.nextInt(5);

            if (i == numaAleatorio) {
                this.conpunes4 = conpunes4 + 1;
                lanzamiento = input("Digite uno para lanzar la pelota: ");
            }else if(estante1[4] == numaAleatorio){
                this.conpunes4 = conpunes4 + 2;
                

            } else {
                this.conpunes4 = conpunes4 + 0;

                lanzamiento = input("Digite uno para lanzar la pelota: ");

            }

        }

        JOptionPane.showMessageDialog(null, "Sus puntos fueron!!" + this.conpunes4);

        JOptionPane.showMessageDialog(null, "Has terminado el estante numero uno, seguiras con el estante numero dos!!");

    }

    public void jugar5() {
        this.conpunes5 = 0;

        for (int i = 0; i < estante2.length; i++) {
            Random r = new Random();
            int numaAleatorio = r.nextInt(5);

            if (i == numaAleatorio) {
                this.conpunes5 = conpunes5 + 1;
                lanzamiento = input("Digite uno para lanzar la pelota: ");
            }else if(estante2[4] == numaAleatorio){
                this.conpunes5 = conpunes5 + 2;

            }else {
                this.conpunes5 = conpunes5 + 0;

                lanzamiento = input("Digite uno para lanzar la pelota: ");

            }

        }

        JOptionPane.showMessageDialog(null, "Sus puntos fueron!!" + this.conpunes5);
        JOptionPane.showMessageDialog(null, "Has terminado el estante numero dos, seguiras con el estante numero tres!!");

    }

    public void jugar6() {

        this.conpunes6 = 0;

        for (int i = 0; i < estante3.length; i++) {
            Random r = new Random();
            int numaAleatorio = r.nextInt(5);

            if (i == numaAleatorio) {
                this.conpunes6 = conpunes6 + 2;
                lanzamiento = input("Digite uno para lanzar la pelota: ");

             }else {
                this.conpunes6 = conpunes6 + 0;

                lanzamiento = input("Digite uno para lanzar la pelota: ");

            }

        }

        JOptionPane.showMessageDialog(null, "Sus puntos fueron!!" + this.conpunes6);
        JOptionPane.showMessageDialog(null, "FIN DEL JUEGO!!");

    }
    public String toString2() {
       
        this.puntosTotales2 = conpunes4 + conpunes5 +conpunes6;
        String detalle = "Puntos totales del jugador "  +jugar2 + " " + puntosTotales2;

        return detalle;

    }


public void gandador(){
    if(puntosTotales > puntosTotales2){
        JOptionPane.showMessageDialog(null, "El ganador es el jugador " + jugar1+  " con los puntos " + puntosTotales);
    }else if (puntosTotales == puntosTotales2){
        if(conpunes3 > conpunes6){
                    JOptionPane.showMessageDialog(null, "El ganador es el jugador " + jugar1+  " por que acerto mas puntos en el estante 3 " + "fue un total de: " + conpunes3);

        }else{
               JOptionPane.showMessageDialog(null, "El ganador es el jugador " + jugar2+  " por que acerto mas puntos en el estante 3 "+ "fue un total de: " + conpunes6);
        }
    }else{
        JOptionPane.showMessageDialog(null, "El ganador es el jugador " + jugar2+  " con los puntos " + puntosTotales2);
    }
}

public String toStringReglase(){
    String reglas = "Existen tres estantes de cinco balones cada uno.\n" +
"• Dos de los estantes tienen cuatro balones oficiales de la NBA y un balón\n" +
"multicolor, el cual se lanza de último.\n" +
"• Los balones oficiales valen 1 punto y la multicolor vale 2 puntos.\n" +
"• En el tercer estante los cinco balones son multicolores valen 2 puntos todos los que acerte ";
        return reglas;
}
}



