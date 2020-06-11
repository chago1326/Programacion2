/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

/**
 *
 * @author personal
 */
public class Araneae extends TiposInsectos{
     
    public String veneno;
    public int cantidadColmillos;

    public Araneae(String veneno, int cantidadColmillos, int patas, String color, String Tipo, int ojos, String habitat) {
        super(patas, color, Tipo, ojos, habitat);
        this.veneno = veneno;
        this.cantidadColmillos = cantidadColmillos;
    }

    @Override
    public String getAtributos() {
         return  "Cantidad de patas: " + patas +
                "\nColor: " + color +
                "\nTipo: " + Tipo +
                "\nCantidad de ojos: "+ ojos+
                "\nTipo de habitat: "+ habitat + 
                 "\nEs venenosa: " + veneno +
                 "\nNumero de colmillos: " + cantidadColmillos;
    }

   
    
     public void ClasificacionEspecie() {
       System.out.println("Su clasificacion es Araneae..");
    }

    
    public void reproduccion() {
        System.out.println("El tipo de reproduccion es sexual");
    }

    
    public void promedioDeVida() {
       System.out.println("Su promedio de vida es 1 a 20 años");
    }
    

    
    
}
