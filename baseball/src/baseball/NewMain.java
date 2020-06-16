/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;

import javax.swing.JOptionPane;

/**
 *
 * @author personal Ricardo 
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
       int select = -1;
       Juego log = new Juego();
       while(select != 5){
			
			try{
				    String menu = JOptionPane.showInputDialog(null, "************************\nElige opción:\n1.- 1-Jugar"
                                    + "\n2.- Ver resultado de la partida\n"
                                    + "3.- Total de puntos de cada jugador\n"
                                    + "4.- Reglas del juego\n"
                                    + "5.- salir\n"
                                    + "************************");

				select = Integer.parseInt(menu); 
		
				
				switch(select){
                                    case 1:
                                       log.juego();
                                        break;
                                    case 2:
                                        log.gandador();
                                        break;
                                    case 3:
                                        JOptionPane.showMessageDialog(null, log.toString());
                                        JOptionPane.showMessageDialog(null, log.toString2());
                                        break;
                                    case 4:
                                        JOptionPane.showMessageDialog(null, log.toStringReglase());
                                        break;
                                    case 5:
                                        JOptionPane.showMessageDialog(null,"Gracias por utilizar nuestro juego!");
					break;
				default:
					JOptionPane.showMessageDialog(null,"opción invalida ");
                                        break;
                                    
                                    
                                }
                        }catch(Exception e){
				JOptionPane.showMessageDialog(null,"! Error!");}
       }
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                
        
        
    }
    
}
