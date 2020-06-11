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
public class Isoptera  extends TiposInsectos{
    
    public String antenas;
    public String clasificacionDeTermitas;

    public Isoptera(String antenas, String clasificacionDeTermitas, int patas, String color, String Tipo, int ojos, String habitat) {
        super(patas, color, Tipo, ojos, habitat);
        this.antenas = antenas;
        this.clasificacionDeTermitas = clasificacionDeTermitas;
    }

   
    public String getAtributos() {
         return  "Cantidad de patas: " + patas +
                "\nColor: " + color +
                "\nTipo: " + Tipo +
                "\nCantidad de ojos: "+ ojos+
                "\nTipo de habitat: "+ habitat + 
                 "\nAntenas: " + antenas +
                 "\n Tipo de termitas: " + clasificacionDeTermitas;
    }

   
   
    public void ClasificacionEspecie() {
       System.out.println("Su clasificacion es Isoptera..");
    }

    
    public void reproduccion() {
        System.out.println("El tipo de reproduccion es ovipara");
    }

    
    public void promedioDeVida() {
       System.out.println("Su promedio de vida es 2 a 3 años");
    }
    

}
