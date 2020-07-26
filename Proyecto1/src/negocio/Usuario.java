/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.BDUsuarios;
import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author personal
 */
public class Usuario {
    
       BDUsuarios log = new BDUsuarios();
       
       
       
       
       
       
       public  void buscarCoincidenciaAviones(String letraBuscar, File archivo) {
           log.buscarCoincidenciaAviones(letraBuscar, archivo);
       }
    public void busquedaRangoFechas(JTable tb,JDateChooser fechaInicio,JDateChooser fechaFinal) {
        log.busquedaRangoFechas(tb, fechaInicio, fechaFinal);
    }
    
    public void llenarComboAvion(JComboBox CMB,File archivo){
        log.llenarComboAvion(CMB, archivo);
        
    }
     public void modificar(ArrayList<String> lista){
         log.modificar(lista);
         
     }

    public void InsertarUsuarios(String lista,File archivo)
    {        
        log.InsertarEnArchivo(lista,archivo);        
    }
    public void tablaAeroli(JTable tb, File archivo){
        log.tablaAero(tb, archivo);
       
    }
    public void tablahistorial(JTable tb, File archivo,String cedula ,String contra,String sum){
        log.tablaHistorial(tb, archivo, cedula, contra,sum);
       
    }
    public void tablaAeropuerto(JTable tb, File archivo){
        log.tablaAeropuerto(tb, archivo);
       
    }
   public void tablaAvion(JTable tb, File archivo){
        log.tablaAvion(tb, archivo);
       
    }
   public void tablaTriou(JTable tb, File archivo){
        log.tablaTripulacion(tb, archivo);
       
    }
   public void tablaVuelo(JTable tb, File archivo){
        log.tablaVuelo(tb, archivo);
       
    }
   public void llenarcomboIATA(JComboBox CMB, File archivo, String nombre){
       log.llenarComboIATA(CMB, archivo, nombre);
   }
           
   
     public LocalTime hora(String h1,String h2){
         return log.hora(h1, h2);
     }  
    
  
   public void RankingAviones(String letraBuscar, File archivo){
       log.buscarCoincidenciaAviones(letraBuscar, archivo);
   }
    public void tablareporVuelo(JTable tb, File archivo, String nombre){
        log.tablareporteVueloAer(tb, archivo, nombre);
       
    }
     public boolean buscarlog(File archivo, String cedula ,String contra,String cmb){
        log.BuscarLogin(archivo, cedula , contra ,cmb);
           return log.BuscarLogin(archivo, cedula , contra ,cmb);
    }
     
     public void tablaPasajero(JTable tb, File archivo,String aerosalida,String aerollegada , String fechaSalida,String fechallegada){
         log.tablaPasajero(tb, archivo, aerosalida, aerollegada, fechaSalida, fechallegada);
         
     }
    
       
     public void LLENARCOMBO(JComboBox CMB,File archivo){
        log.llenarComboDepa(CMB,archivo);
        
    }
      public void LLENARCOMBOPilo(JComboBox CMB,File archivo,String ID){
        log.llenarComboPiloto(CMB,archivo,ID);
        
    }
      public void COMBOAvionVuel(JComboBox CMB,File archivo,String ID){
          log.llenarIDaVION(CMB, archivo, ID);
      }
      public boolean Buscarfecha(File archivo,
            JTable tb, String AeroSalila, String Aerolle,
            JDateChooser dateFechasalida, JDateChooser dateFechaLlegada, int suma){
           return log.Buscarfecha(archivo, tb, AeroSalila, Aerolle, dateFechasalida, dateFechaLlegada, suma);
          
      }
      
      public void LLENARCOMBOServicio(JComboBox CMB,File archivo,String ID){
        log.llenarComboServicio(CMB, archivo, ID);
        
    }
      public void LLENARCOMBOAero(JComboBox CMB,File archivo){
        log.llenarComboAero(CMB,archivo);
        
    } 
      public void LLENARCOMBOreporAero(JComboBox CMB,File archivo){
        log.llenarComboAerrepo(CMB,archivo);
        
    } 
      public String buscarIATA(File archivo,String nombre){
           return log.buscarIATA(archivo, nombre);
          
      }
      
      public void mostrarTripulacion(JTable tb , File archivo,String nombre){
          log.mostrarinformacio(tb, archivo, nombre);
      }
      
//      public void LLENARCOMBOAvion(JComboBox CMB,File archivo){
//        log.llenarComboAvion(CMB,archivo);
//        
//    } 
     
     public ArrayList<String> LeerUsuarios(File archivo)
    {
        ArrayList<String> listaUsuarios = log.LeerDesdeArchivo(archivo);     
        return listaUsuarios;
    }
    
}
