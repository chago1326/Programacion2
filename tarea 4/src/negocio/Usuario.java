/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.BDUsuarios;
import java.io.File;
import javax.swing.JComboBox;

/**
 *
 * @author personal
 */
public class Usuario {
    
       BDUsuarios log = new BDUsuarios();
    
    public void InsertarUsuarios(String lista)
    {        
        log.InsertarEnArchivo(lista);        
    }
    
    public void buscarEs(File archivo, String nombre){
        log.BuscarEstudiante(archivo, nombre);
    }
    
     public void buscarlog(File archivo, String nombre ,String contra){
        log.BuscarLogin(archivo, nombre , contra);
    }
      public String sacarNota() {
        String respuesta = "";
        int resultado = 0;

        resultado = (log.numnota1 +log.numnota2 + log.numnota3) / 3;
        
        if (resultado >= 70) {
            respuesta = "Aprobado";
        } else if (resultado < 60) {
            respuesta = "Reprobado";

        } else if (resultado >= 60 && resultado < 70) {
            respuesta = "Aplazado";
            
        }
        
   
        return respuesta;
        
        
        
    }
        public void buscarnota(File archivo, String nombre){
        log.BuscarEstudianteNota(archivo, nombre );
        
    }
     public void LLENARCOMBO(JComboBox CMB){
        log.llenarComboDepa(CMB);
        
    }
}
