/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import jdk.nashorn.internal.ir.BreakNode;
import com.toedter.calendar.JDateChooser;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 *
 * @author personal
 */
public class BDUsuarios {
    
   
   

    public void tablaAero(JTable tb, File archivo){
        
        String []titulos =  {"Identificador","Nombre de aerolinea","Año de fundación","Tipo"};
         DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String datos= "";

        try {
            BufferedReader archi = new BufferedReader(new FileReader(archivo));
            
            
            while ((datos = archi.readLine()) != null) {
                String[] palabra = datos.split(",");
                
                String fila [] = {palabra[0],palabra[1],
                palabra[2],palabra[3]};
                
                modelo.addRow(fila);
               

            }
           tb.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
    }
      
       public void tablaHistorial(JTable tb, File archivo,String cedula ,String contra ,String sum){
        
        String []titulos =  {"ID Aerolinea","Precio","Fecha de salida ","Aeropuerto de salida"
                 ,"Fecha de llegada ","Aeropuerto de llegada","Horas totales","Total de sus vuelos"};
         DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String datos= "";

        try {
            BufferedReader archi = new BufferedReader(new FileReader(archivo));
            
            
            while ((datos = archi.readLine()) != null) {
                String[] palabra = datos.trim().split(",");
             
                if (palabra[0].equals(cedula)) {
                    String fila[] = {palabra[1],palabra[2],palabra[3],palabra[4],palabra[5],palabra[6]
                            ,palabra[7],sum
                    };
                    modelo.addRow(fila);
                } else {
                    JOptionPane.showMessageDialog(null, "No tienes ningun vuelo!!");
                }

            }
           tb.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
      
       

       
                
        
    }
   
    public void tablaAeropuerto(JTable tb, File archivo) {

        String[] titulos = {"Identificador", "IATA", "Nombre", "País"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String datos = "";

        try {
            BufferedReader archi = new BufferedReader(new FileReader(archivo));

            while ((datos = archi.readLine()) != null) {
                String[] palabra = datos.split(",");

                String fila[] = {palabra[0], palabra[1],
                    palabra[2], palabra[3]};

                modelo.addRow(fila);

            }
            tb.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }

    }

    public void tablaAvion(JTable tb, File archivo){
        
        String []titulos =  {"Identificador","Modelo","Año de construcción","ID de aerolinea"
        ,"Capacidad","Estado"};
         DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String datos= "";

        try {
            BufferedReader archi = new BufferedReader(new FileReader(archivo));
            
            
            while ((datos = archi.readLine()) != null) {
                String[] palabra = datos.split(",");
                
                String fila [] = {palabra[0],palabra[1],
                palabra[2],palabra[3],palabra[4],palabra[5]};
                
                modelo.addRow(fila);
               

            }
           tb.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
                
        
    }
    
    
      public void tablaTripulacion(JTable tb, File archivo){
        
        String []titulos =  {"Cédula","Nombre","Fecha de nacimiento","ID de aerolinea"
        ,"Rol","Estado"};
         DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String datos= "";

        try {
            BufferedReader archi = new BufferedReader(new FileReader(archivo));
            
            
            while ((datos = archi.readLine()) != null) {
                String[] palabra = datos.split(",");
                
                String fila [] = {palabra[0],palabra[1],
                palabra[2],palabra[3],palabra[4],palabra[5]};
                
                modelo.addRow(fila);
               

            }
           tb.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
                
        
    }
     public void tablaPasajero(JTable tb, File archivo, String aerosalida, String aerollegada, String fechaSalida, String fechallegada) {
        boolean existe = false;
        int contaEs = 0;
        String[] titulos = {"ID  Aerolinea",
            "Precio vuelo", "Fecha y hora salida",
            "Aeropuerto salida", "Fecha y hora llegada", "Aeropuerto llegada","Hora total"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String datos = "";

        
           try {
            BufferedReader archi = new BufferedReader(new FileReader(archivo));

            while ((datos = archi.readLine()) != null) {
                String[] palabra = datos.split(",");

                if (palabra[5].equals(aerosalida) && palabra[8].equals(aerollegada)
                        && palabra[3].equals(fechaSalida) && palabra[6].equals(fechallegada)) {
                    JOptionPane.showMessageDialog(null, "Hay un vuelo directo para su viaje");
                    String fila[] = {palabra[1],  palabra[2],
                        palabra[3] + palabra[4], palabra[5], palabra[6] + palabra[7],
                        palabra[8],palabra[15]};
                    existe = true;
                    modelo.addRow(fila);

                }
                
                else if (palabra[5].equals(aerosalida) && palabra[3].equals(fechaSalida)) {
                     JOptionPane.showMessageDialog(null, "Hay una escala para su viaje");
                    String fila[] = {palabra[1], palabra[2],
                            palabra[3] + palabra[4], palabra[5], palabra[6] + palabra[7],
                            palabra[8], palabra[15]};
                       modelo.addRow(fila);
                        existe = true;
                        
                    
                    if (palabra[8].equals(aerollegada) && palabra[6].equals(fechallegada)) {
                        modelo.addRow(fila);
                        existe = true;
                        
                    }
                    
                    else if(palabra[8].equals(aerollegada) && palabra[6].equals(fechallegada)){
                        modelo.addRow(fila);
                        existe = true;
                        
                    if (palabra[5].equals(aerosalida) && palabra[3].equals(fechaSalida)){
                        
                        existe = true;
                        modelo.addRow(fila);
                       
                    }
                    else if(palabra[8].equals(aerollegada)){
                        existe = true;
                        modelo.addRow(fila);
                        
                        
                    }

                }
                }
            }
            if (!existe) {
                JOptionPane.showMessageDialog(null, "No HAY NINGUN VUELO EN ESAS FECHAS");
            }

            tb.setModel(modelo);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }

    }

     public void tablaVuelo(JTable tb, File archivo) {
         
        String[] titulos = {"Vuelo identificación", "ID  Aerolinea",
            "Precio vuelo", "Fecha y hora salida",
            "Aeropuerto salida", "Fecha y hora llegada", "Aeropuerto llegada",
            "ID  Avion", "ID piloto 1", "ID piloto 2",
            "ID Servicio cliente 1", "ID Servicio cliente 2",
            "ID Servicio cliente 3" , "Hora total"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String datos = "";

        try {
            BufferedReader archi = new BufferedReader(new FileReader(archivo));

            while ((datos = archi.readLine()) != null) {
                String[] palabras = datos.split(",");

                String fila[] = {palabras[0], palabras[1], palabras[2], palabras[3]
                    + palabras[4], palabras[5], palabras[6] + palabras[7],
                    palabras[8], palabras[9], palabras[10], palabras[11], palabras[12], palabras[13], palabras[14],palabras[15]};
                
                modelo.addRow(fila);

            }
            tb.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }

    }
    
       public ArrayList<String> LeerDesdeArchivo(File archivo)
    {
        ArrayList<String> contenido = new ArrayList<>();
        try {
 
            BufferedReader archi = new BufferedReader(new FileReader(archivo));
            while (archi.ready())
            {
                contenido.add(archi.readLine());
            }
            archi.close();
        } catch (Exception e) {
            System.out.println("Error al leer del archivo" + e);
        }
        return contenido;
    }

    
     public void InsertarEnArchivo(String lista,File archivo) {
        try {
            BufferedWriter archi = new BufferedWriter(new FileWriter(archivo, true));
            archi.write(lista + "\r\n");
            JOptionPane.showMessageDialog(null, "Insertado con exito!");
            archi.close();
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo" + e);
        }
    }
    
    
  
     

     
     
     
    public void tablareporteVueloAer(JTable tb, File archivo, String nombre) {

        String[] titulos = {"Vuelo identificación", "ID  Aerolinea",
            "Precio vuelo", "Fecha y hora salida",
            "Aeropuerto salida", "Fecha y hora llegada", "Aeropuerto llegada",
            "ID  Avion", "ID piloto 1", "ID piloto 2",
            "ID Servicio cliente 1", "ID Servicio cliente 2",
            "ID Servicio cliente 3"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String datos = "";
        boolean existe = false;

        try {
            BufferedReader archi = new BufferedReader(new FileReader(archivo));

            while ((datos = archi.readLine()) != null) {
                String[] palabras = datos.split(",");
               
                    if (palabras[1].equals(nombre)) {
                        String fila[] = {palabras[0], palabras[1], palabras[2], palabras[3]
                            + palabras[4], palabras[5], palabras[6] + palabras[7],
                            palabras[8], palabras[9], palabras[10], palabras[11], palabras[12], palabras[13], palabras[14]};

                        modelo.addRow(fila);
                        existe = true;
                    }
                }

                if (!existe) {
                    JOptionPane.showMessageDialog(null, "No HAY NINGUN VUELO EN ESAS FECHAS");
                }

            
            tb.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }

    }

  
     
public String buscarIATA(File archivo,String nombre){
    boolean existe = false;
        String res = "";
        try {

            if (archivo.exists()) {

                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));

                String lineaLeida;

                while ((lineaLeida = leerArchivo.readLine()) != null) {
                    String[] palabra = lineaLeida.split(",");
                    if (palabra[1].equals(nombre)) {
                        res = palabra[0];
                        
                        existe = true;
                    }
                }

                if (!existe) {
                    res = "Nombre de Aaerolinea no exite";
                }
            }

        } catch (Exception e) {

        }
        return res;

    }

    public boolean BuscarLogin(File archivo, String cedula, String contra, String cmbPuesto) {
        boolean existe = false;
        try {

            if (archivo.exists()) {

                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));

                String lineaLeida;

                while ((lineaLeida = leerArchivo.readLine()) != null) {
                    String[] palabra = lineaLeida.split(",");
                    if (palabra[0].equals(cedula) && palabra[1].equals(contra) && palabra[2].equals(cmbPuesto)) {

                        if (cmbPuesto == "Administrador") {
                            
                            existe = true;
                            
                        } 
                        
                        if (cmbPuesto == "Pasajero") {
                          
                            existe = true;

                        }

                   
                    }
                    
                }
               
                if (!existe) {
                    JOptionPane.showMessageDialog(null, "Usuario o cedula incorrecto.");
                    
                    
                }
            }

        } catch (Exception e) {

        }
        return existe;

    }

   
      
    public void llenarComboIATA(JComboBox CMB, File archivo, String nombre) {
        boolean existe = false;
        try {

            FileReader fr;
            BufferedReader br;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p;
            String linea = br.readLine();
            while ((p = br.readLine()) != null) {
                String[] palabra = p.split(",");
                if (palabra[2].equals(nombre)) {
                    
                    p = palabra[1].trim();
                    
                    CMB.addItem(p);
                    existe = true;

                }
                
                   
                }
            if (!existe) {
                
               
                
            }
            

            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
    }
      
    
       public void llenarComboAvion(JComboBox CMB,File archivo) {
         
     try {

            FileReader fr;
            BufferedReader br;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p;
            String linea = br.readLine();
            while (linea != null) {

                String[] campoLinea = linea.split(",");
                p = campoLinea[0].trim();
                linea = br.readLine();

                CMB.addItem(p);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
    }
       public void llenarComboAero(JComboBox CMB, File archivo) {
            try {

            FileReader fr;
            BufferedReader br;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p;
            String linea = br.readLine();
            while (linea != null) {

                String[] campoLinea = linea.split(",");
                p = campoLinea[2].trim();
                linea = br.readLine();

                CMB.addItem(p);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
        
    }

   

     
     public void llenarComboAerrepo(JComboBox CMB,File archivo) {
        try {

            FileReader fr;
            BufferedReader br;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p;
            String linea = br.readLine();
            while (linea != null) {

                String[] campoLinea = linea.split(",");
                p = campoLinea[1].trim();
                linea = br.readLine();

                CMB.addItem(p);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
    }
    
  
      public void llenarComboDepa(JComboBox CMB,File archivo) {
        try {

            FileReader fr;
            BufferedReader br;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p;
            String linea = br.readLine();
            while (linea != null) {

                String[] campoLinea = linea.split(",");
                p = campoLinea[0].trim();
                linea = br.readLine();

                CMB.addItem(p);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
    }
      
   
    
  public void mostrarinformacio(JTable tb, File archivo, String nombre){
      

        String[] titulos = {"Cedula","Nombre","Fecha de nacimiento","ID de aerolinea"
        ,"Rol","Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String datos = "";
        boolean existe = false;

        try {
            BufferedReader archi = new BufferedReader(new FileReader(archivo));

            while ((datos = archi.readLine()) != null) {
                String[] palabras = datos.split(",");
               
                    if (palabras[3].equals(nombre)) {
                        
                        String fila[] = {palabras[0], palabras[1], palabras[2], palabras[3]
                            , palabras[4],palabras[5]};

                        modelo.addRow(fila);
                        existe = true;
                    }
                }

                if (!existe) {
                    JOptionPane.showMessageDialog(null, "No HAY NINGUN  TRABAJADOR DE ESA AEROLINEA");
                }

            
            tb.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }

    
      
  }
    
        
public  void buscarCoincidenciaAviones(String letraBuscar, File archivo) {
        int totalCoincidencias = 0;

        try {
            if (archivo.exists()) {

                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
                String lineaLeida;

                while ((lineaLeida = archivoLeer.readLine()) != null) {

                    String[] partes = lineaLeida.split(",");

                    for (int i = 0; i < partes.length; i++) {
                        if (partes[i].equals(letraBuscar)) {
                            totalCoincidencias = totalCoincidencias + 1;
                        }
                    }
                }

                archivoLeer.close();
            }

            JOptionPane.showMessageDialog(null, 
                     " se encuentra: " + totalCoincidencias
                    + " veces en el archivo buscando ranking de aviones");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   static boolean DentroDelRango(String Fecha, String FechaRango1, String FechaRango2) throws ParseException 
{
    DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    
    Date MiFecha = formato.parse(Fecha);
    Date RangoIni = formato.parse(FechaRango1);
    Date RangoFin = formato.parse(FechaRango2);
    Calendar c = Calendar.getInstance();
    c .add(Calendar.YEAR, 2);
    

    return MiFecha.compareTo(RangoIni) >= 0 &&
           MiFecha.compareTo(RangoFin) <= 0;

    
}
   
      
    public void llenarComboPiloto(JComboBox CMB, File archivo, String ID) {
        try {

            FileReader fr;
            BufferedReader br;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p = null;
            String linea = br.readLine();
            while (linea != null) {
                String[] campoLinea = linea.split(",");
                if (campoLinea[3].equals(ID)
                        && campoLinea[4].equals("Piloto")
                        && campoLinea[5].equals("Disponible")) {

             
                    p = campoLinea[0].trim();
                    linea = br.readLine();
                    CMB.addItem(p);
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR");
                    break;
            }
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
    }
    public void llenarComboServicio(JComboBox CMB, File archivo, String ID) {
        try {

            FileReader fr;
            BufferedReader br;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p = null;
            String linea = br.readLine();
            while (linea != null) {
                String[] campoLinea = linea.split(",");
                  
                    p = campoLinea[0].trim();
                    linea = br.readLine();
                    CMB.addItem(p);
                
            
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
    }
     public LocalTime hora(String h1,String h2){
        
        LocalTime hora_1 = LocalTime.parse(h1);
        LocalTime hora_2 = LocalTime.parse(h2);
        int hora = 60; //Una hora = 60 minutos
        long diff = ChronoUnit.MINUTES.between(hora_1, hora_2) - hora;
        Double h = diff / 60.00;
        Long m = diff % 60;
        LocalTime hf = LocalTime.of(h.intValue(), m.intValue());
        
        String s = hf.toString();
        JOptionPane.showMessageDialog(null, s);
        System.out.println(hf);
        
        return hf;
    
      }  
     
     
      public void modificar(ArrayList<String> lista) {
        try {
            File archivo = new File("Tripulacion.txt");
            FileWriter escribir = new FileWriter(archivo);
            for (int i = 0; i < lista.size(); i++) {
                escribir.write(lista.get(i) + "\r\n");
            }
            escribir.close();
            JOptionPane.showMessageDialog(null, "Registro modificado exitosamente!!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos \n"
                    + "Detalles: " + e.getMessage());
        }
    }
      
      public void busquedaRangoFechas(JTable tb,JDateChooser fechaInicio,JDateChooser fechaFinal) {
           ArrayList<ArrayList<String>> arregloPapa = new ArrayList<ArrayList<String>>();
         String[] titulos = {"Vuelo identificación", "ID  Aerolinea",
            "Precio vuelo", "Fecha y hora salida",
            "Aeropuerto salida", "Fecha y hora llegada", "Aeropuerto llegada",
            "ID  Avion", "ID piloto 1", "ID piloto 2",
            "ID Servicio cliente 1", "ID Servicio cliente 2",
            "ID Servicio cliente 3"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            File fichero = new File("vuelos.txt");
            if (fichero.exists()) {
                BufferedReader leer = new BufferedReader(new FileReader(fichero));
                String linea;
                String [] data;
                while (leer.ready()) {
                    linea = leer.readLine();
                    data = linea.split(",");
                    ArrayList<String> arreglo = new ArrayList<>();
                    for (int i = 0; i < data.length; i++) {
                        arreglo.add(data[i]);
                    }
                    arregloPapa.add(arreglo);
                }
                for (int i = 0; i < arregloPapa.size(); i++) {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    String xFecha = arregloPapa.get(i).get(6);
                    Date fecha;
                    java.util.Date nFecha = formato.parse(xFecha);
                    fecha = new Date(nFecha.getTime());
                    if (fecha.after(fechaInicio.getDate()) && fecha.before(fechaFinal.getDate())) {
                        modelo.addRow(new String[]{arregloPapa.get(i).get(0),
                            arregloPapa.get(i).get(1),arregloPapa.get(i).get(2),
                        arregloPapa.get(i).get(3)+ arregloPapa.get(i).get(4),
                        arregloPapa.get(i).get(5),arregloPapa.get(i).get(6)+
                        arregloPapa.get(i).get(7),arregloPapa.get(i).get(8),
                        arregloPapa.get(i).get(9),arregloPapa.get(i).get(10),
                        arregloPapa.get(i).get(11),arregloPapa.get(i).get(12),
                        arregloPapa.get(i).get(13),arregloPapa.get(i).get(14)});
                         
                    }else{
                        JOptionPane.showMessageDialog(null, "No hay vuelos disponibles!!");
                    }
                }
                tb.setModel(modelo);
                leer.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar los datos \n"
                    + "Detalles del error: " + e.getMessage());
        }
    }

       public void llenarIDaVION(JComboBox CMB, File archivo, String ID) {
        try {

            FileReader fr;
            BufferedReader br;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String p = null;
            String linea = br.readLine();
            while (linea != null) {
                String[] campoLinea = linea.split(",");
             
            
                    p = campoLinea[0].trim();
                    linea = br.readLine();
                    CMB.addItem(p);
               
            
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, detalles: " + e.getMessage());
        }
    }
    
      public boolean Buscarfecha(File archivo,
            JTable tb, String AeroSalila, String Aerolle,
            JDateChooser dateFechasalida, JDateChooser dateFechaLlegada, int suma) {
        String[] palabra = null;

        boolean existe = false;
        boolean existe2 = false;
       
        int numViajes = 0;

        

        try {
            if (archivo.exists()) {
                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));

                String lineaLeida;

                while ((lineaLeida = leerArchivo.readLine()) != null) {
                    palabra = lineaLeida.split(",");
                    int valorSpinner = suma;
                    String fe = sum(dateFechasalida.getDate(), valorSpinner);
                    String re = res(dateFechasalida.getDate(), valorSpinner);
                    String fe2 = sum(dateFechaLlegada.getDate(), valorSpinner);
                    String res2 = res(dateFechaLlegada.getDate(), valorSpinner);

                   
                    existe = DentroDelRango(palabra[3], re, fe)
                            || DentroDelRango(palabra[3], re, fe);

                    existe2 = DentroDelRango(palabra[6], res2, fe2)
                            || DentroDelRango(palabra[6], res2, fe2);

                   
String[] titulos = {"Rango de fecha salida " + re + " " +fe ,
    "Rango fecha llegada " + res2 + " " + fe2};
                    DefaultTableModel modelo = new DefaultTableModel(null, titulos);

                
            
            

                if (existe && existe2 && palabra[5].equals(AeroSalila) && palabra[8].equals(Aerolle)
                        ) {
                    
                    String fila[] = {
                        palabra[3] + palabra[4], palabra[6] + palabra[7]
                    };

                   
                    modelo.addRow(fila);

                }
                if (existe && existe2 && palabra[5].equals(AeroSalila)) {
                   
                     String fila[] = {
                        palabra[3] + palabra[4], palabra[6] + palabra[7]
                    };

                    
                    modelo.addRow(fila);

                } else if (existe && existe2 && palabra[5].equals(AeroSalila)&& palabra[8].equals(Aerolle)) {

                    String fila[] = {
                        palabra[3] + palabra[4], palabra[6] + palabra[7]
                    };


                    
                    existe = true;
                    modelo.addRow(fila);
                    
                }
                tb.setModel(modelo);
               }
                
            }
             

            if (numViajes == 0) {
                JOptionPane.showMessageDialog(null, "No hay viajes.");
            } else {
                JOptionPane.showMessageDialog(null, "Viajes encontrados: " + Integer.toString(numViajes));
            }
            
        } catch (Exception e) {
           
        }

        return (numViajes != 0);
    }

    public String sum(Date fecha, int dias) {
        String fechasu = "";
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        cal.add(Calendar.DATE, dias);
        SimpleDateFormat fe = new SimpleDateFormat("dd/MM/yyyy");
        fechasu = fe.format(cal.getTime());
        return fechasu;
    }

    public String res(Date fecha, int dias) {
        String fechasu = "";
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        cal.add(Calendar.DATE, -dias);
        SimpleDateFormat fe = new SimpleDateFormat("dd/MM/yyyy");
        fechasu = fe.format(cal.getTime());
        return fechasu;
    }
}
