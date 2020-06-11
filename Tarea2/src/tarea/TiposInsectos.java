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
public class TiposInsectos {
    
    public int patas;
    public String color;
    public String Tipo;
    public int ojos;
    public String habitat;

    public TiposInsectos(int patas, String color, String Tipo, int ojos, String habitat) {
        this.patas = patas;
        this.color = color;
        this.Tipo = Tipo;
        this.ojos = ojos;
        this.habitat = habitat;
    }
    
    public String getAtributos() {
        return  "Cantidad de patas: " + patas +
                "\nColor: " + color +
                "\nTipo: " + Tipo +
                "\nCantidad de ojos: "+ ojos+
                "\nTipo de habitat: "+ habitat;
        
    }
   
    public void ClasificacionEspecie(){
        System.out.println("Su clasificacion es...");
    }
    
    public void reproduccion(){
        System.out.println("El tipo de reproduccion es...");
    }
    
   public void promedioDeVida(){
       System.out.println("Su promedio de vida es...");
   }  
    
    
}
