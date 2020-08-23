package Datos;

import static Datos.conexion.resultado;
import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Locale;
import javafx.scene.control.ComboBox;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author personal
 */
public class conexion {
    
    private Connection connection = null;
    static Statement sentencia = null;
    static ResultSet resultado= null;
    FileInputStream fis;
    int longitudBytes;
    
    
    
    public void Conexion() {
        if (connection != null) {
            return;
        }

        String url = "jdbc:postgresql://localhost:5432/adopcion_Mascotas";
        String password = "ricardo13";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, "postgres", password);
            if (connection != null) {
                System.out.println("Connecting to database...");
            }
        } catch (Exception e) {
            System.out.println("Problem when connecting to the database");
        }
    }
    
     public void  mostrarFoto(JLabel lblfoto,String nombre,JTextField txtnombre,String id){
         String sql="select foto,foto_nom from  mascotas where codigo = "+ id;
        ImageIcon foto;
        InputStream is;
        
        try{
            sentencia = connection.createStatement();

            resultado = sentencia.executeQuery("select foto,foto_nom from  mascotas where id_mascota = '"+ id + "'");
            while(resultado.next()){
                is = resultado.getBinaryStream(1);
                
                
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);
                
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
                
                ImageIcon newicon = new ImageIcon(newimg);
                
                lblfoto.setIcon(newicon);
                
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"exception: "+ex.getLocalizedMessage());
        }
     }                    
     public void mostrar(JTable tabla,JLabel lblfoto){
         String[] titulos = {"id_mascota","nombre","sexo","edad","tamaño","color","tipo_animal","ubicación","fecha_ingreso","estado","foto"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            
            String estado = "Disponible";

              
            
            sentencia = connection.createStatement();
            
           
                    
            resultado = sentencia.executeQuery("select * from mascotas WHERE estado = '" + estado +  "'"
            );
            while (resultado.next()) {
                
                Object[] fila = new Object[11];
                fila[0]= resultado.getObject(1);
                fila[1]= resultado.getObject(2);
                fila[2]= resultado.getObject(3);
                fila[3]= resultado.getObject(4);
                fila[4]= resultado.getObject(5);
                fila[5]= resultado.getObject(6);
                fila[6]= resultado.getObject(7);
                fila[7]= resultado.getObject(8);
                fila[8]= resultado.getObject(9);
                fila[9]= resultado.getObject(10);
                fila[10] = resultado.getObject(12);
                
                modelo.addRow(fila);
               
                tabla.setRowHeight(70);
              
            }

                
            
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }


     }  
     
     
    public void imagen(JLabel lblfoto) {
        lblfoto.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
                    lblfoto.setIcon(new ImageIcon(icono));
                    lblfoto.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "imagen: " + ex);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    
public void insertarmascotas(String id,String Nombre,String sexo,String edad,
            String tamano, String color, String tipo, JLabel lblfoto, String ubicacion, Date fecha, String estado, String nombreImagen) throws SQLException {
        try {

            String spq = "INSERT INTO mascotas (id_mascota,nombre,sexo,edad,tamaño,color,tipo_animal,ubicación,fecha_ingreso,estado,foto,foto_nom) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            FileInputStream archivofoto;
            PreparedStatement SP = connection.prepareStatement(spq);
            SP.setString(1, id);
            SP.setString(2, Nombre);
            SP.setString(3, sexo);
            SP.setString(4, edad);
            SP.setString(5, tamano);
            SP.setString(6, color);
            SP.setString(7, tipo);
            SP.setString(8, ubicacion);
            SP.setDate(9, (java.sql.Date) fecha);
            SP.setString(10, estado);
            archivofoto = new FileInputStream(nombreImagen);
            SP.setBinaryStream(11, archivofoto);
            SP.setString(12, nombreImagen);

            lblfoto.setIcon(null);
            int i = SP.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa");

            }


    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR"+ e.getLocalizedMessage());
    }
    

}
    public void insertar(String id,String Nombre,String sexo,int edad,
            String tamano,String color,String tipo ,Byte foto ,String ubicacion,Date fecha,String estado){
      try {
           
          
             sentencia= connection.createStatement(); 
             
            int z = sentencia.executeUpdate("INSERT INTO mascotas (id_mascota,nombre,sexo,edad,tamaño,color,tipo_animal,ubicación,fecha_ingreso,estado,foto) "
                  + "VALUES ('" + id + "', '" + Nombre + "', '" + sexo + "', '"
                  + edad + "', '" + tamano + "', '" + color + "', '" + tipo + "', '"
                  + ubicacion + "', '" + fecha + "', '" + estado + "', '" +foto
                  + "')");
            if (z == 1) {
                JOptionPane.showMessageDialog(null,"Se agregó el registro de manera exitosa");
            } else {
                JOptionPane.showMessageDialog(null,"Error al insertar el registro");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de conexión" + e.getMessage());
        }
       
    }
    
    public void eliminar(String id){
   
        try {
     
           sentencia= connection.createStatement(); 
            int z = sentencia.executeUpdate("DELETE FROM mascotas WHERE nombre = '" + id + "'");
            if (z == 1) {
                JOptionPane.showMessageDialog(null,"Se eliminó el registro de manera exitosa");
            
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
    }
    
   public boolean desencriptar(String cedula,String pass,String tipo) throws SQLException{
       boolean dese= false;
       int re = 0;
       try {
           sentencia = connection.createStatement();

           resultado = sentencia.executeQuery(" select "
                   + "from usuarios\n"
                   + "where cedula ='" + cedula +  "'and pass = md5('" + pass + "') and tipo='"+ tipo +  "'");
            
        if(resultado.next()){
            re = 1;
            
        }
        
        if(re == 1){
            dese = true;
            JOptionPane.showMessageDialog(null,"Bienvenido!!");
        }else{
            JOptionPane.showMessageDialog(null, "Usuario o clave incorrepta!!");
            dese = false;
        }
           
       } catch (Exception e) {
       }
       
        return dese ;
       
   }
    public boolean login (String usu , String contra,String tipo){ 
        boolean existe = false;
        boolean entra = false;
      
        int re = 0;
        try {
           
            sentencia = connection.createStatement();

            resultado = sentencia.executeQuery("select * from usuarios where cedula='" + usu + "' and pass='"+ contra+ "' and tipo='"+ tipo +"'");
            
          
        
        
        
        if(resultado.next()){
            re = 1;
            
        }
        
        if(re == 1){
            existe = true;
            
            JOptionPane.showMessageDialog(null,"Bienvenido!!");
        }else{
            JOptionPane.showMessageDialog(null, "Usuario o clave incorrepta!!");
            existe = false;
        }
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en ingresar" + e.getMessage());
            existe = false;
        }
       
        
        
    
        
        return existe;
        
    
    }
    
     public void mostrarSoli(JTable tabla){
         
         String[] titulos = {"id_solicitud","cedula_usu","id_mascotas","estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            
            String estado = "pendiente";

              
            
            sentencia = connection.createStatement();
            
           
                    
            resultado = sentencia.executeQuery("select * from solicitud WHERE estado = '" + estado +  "'"
            );
            while (resultado.next()) {
                
                Object[] fila = new Object[4]; 

                
                for (int i = 0; i < 4; i++) {
                    fila[i] = resultado.getObject(i + 1); 
                }
                
                modelo.addRow(fila);
                tabla.setModel(modelo);
            }

                
            
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


     }
     
     public void insertarUsu(String cedula, String nombre,String pass,
             String correo,String tipo){
      try {
           
          
             sentencia= connection.createStatement(); 
             
            int z = sentencia.executeUpdate("INSERT INTO usuarios(cedula,nombre,pass,correo,tipo)"
                  + "VALUES ('" + cedula + "', '" + nombre + "', md5('" + pass + "'), '"
                  + correo + "', '" + tipo 
                  + "')");
            if (z == 1) {
                JOptionPane.showMessageDialog(null,"Se agregó el registro de manera exitosa");
            } else {
                JOptionPane.showMessageDialog(null,"Error al insertar el registro");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de conexión" + e.getMessage());
        }
       
    }
      
     public void buscarTipo(JTable Tabla ,String tipo ){
         String[] titulos = {"id_mascota","nombre","sexo","edad","tamaño","color","tipo_animal","ubicación","fecha_ingreso","estado","foto"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            
            
             String estado = "Disponible";
            
            sentencia = connection.createStatement();
            
           
                    
            resultado = sentencia.executeQuery("select * from mascotas WHERE tipo_animal = '" + tipo + "' and estado = '" + estado +  "'");
            
            while (resultado.next()) {
                
                Object[] fila = new Object[11];
                fila[0]= resultado.getObject(1);
                fila[1]= resultado.getObject(2);
                fila[2]= resultado.getObject(3);
                fila[3]= resultado.getObject(4);
                fila[4]= resultado.getObject(5);
                fila[5]= resultado.getObject(6);
                fila[6]= resultado.getObject(7);
                fila[7]= resultado.getObject(8);
                fila[8]= resultado.getObject(9);
                fila[9]= resultado.getObject(10);
                fila[10] = resultado.getObject(12);
                modelo.addRow(fila);
                Tabla.setModel(modelo);
            }

                
            
            Tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
     }
     
     
     public void buscarUbicacion(JTable Tabla ,String ubicacion ){
          String[] titulos = {"id_mascota","nombre","sexo","edad","tamaño","color","tipo_animal","ubicación","fecha_ingreso","estado","foto"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            
            
             String estado = "Disponible";
            
            sentencia = connection.createStatement();
            
           
                    
            resultado = sentencia.executeQuery("select * from mascotas WHERE ubicación = '" + ubicacion + "' and estado = '" + estado +   "'");
            
            while (resultado.next()) {
                
                Object[] fila = new Object[11];
                fila[0]= resultado.getObject(1);
                fila[1]= resultado.getObject(2);
                fila[2]= resultado.getObject(3);
                fila[3]= resultado.getObject(4);
                fila[4]= resultado.getObject(5);
                fila[5]= resultado.getObject(6);
                fila[6]= resultado.getObject(7);
                fila[7]= resultado.getObject(8);
                fila[8]= resultado.getObject(9);
                fila[9]= resultado.getObject(10);
                fila[10] = resultado.getObject(12);
                modelo.addRow(fila);
                Tabla.setModel(modelo);
            }

                
            
            Tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
       
     }
      
     public void buscarRango(JTable Tabla ,int desde,int hasta ){
           String[] titulos = {"id_mascota","nombre","sexo","edad","tamaño","color","tipo_animal","ubicación","fecha_ingreso","estado","foto"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            
            
             String estado = "Disponible";
            
            sentencia = connection.createStatement();
            
              resultado = sentencia.executeQuery("select * from mascotas WHERE edad BETWEEN " + desde +  " and " + hasta  + " and estado = '" + estado  + "'");
           
                    
           
            
            while (resultado.next()) {
                
                Object[] fila = new Object[11];
                fila[0]= resultado.getObject(1);
                fila[1]= resultado.getObject(2);
                fila[2]= resultado.getObject(3);
                fila[3]= resultado.getObject(4);
                fila[4]= resultado.getObject(5);
                fila[5]= resultado.getObject(6);
                fila[6]= resultado.getObject(7);
                fila[7]= resultado.getObject(8);
                fila[8]= resultado.getObject(9);
                fila[9]= resultado.getObject(10);
                fila[10] = resultado.getObject(12);
                modelo.addRow(fila);
                Tabla.setModel(modelo);
            }

                
            
            Tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
     }
     
     public void modificarEstado(String id){
         try{
             String blo = "Bloqueada";
           sentencia = connection.createStatement();
            int z = sentencia.executeUpdate("UPDATE mascotas SET estado = '" +blo +  "' WHERE id_mascota = '" + id +
                                    "'");
            if (z == 1) {
                System.out.println("Se módificó el registro de manera exitosa");
            } else {
                System.out.println("Error al modificar el registro");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
     }
     
     public void insertarSoli(String cedula , String id_mascotas){
     try {
           
          String estado = "pendiente";
             sentencia= connection.createStatement(); 
             
            int z = sentencia.executeUpdate("INSERT INTO solicitud (cedula_usu,id_mascotas,estado) "
                  + "VALUES ('" + cedula + "', '" + id_mascotas + "', '"
                  + estado + 
                   "')");
            if (z == 1) {
                JOptionPane.showMessageDialog(null,"Se agregó el registro de manera exitosa");
            } else {
                JOptionPane.showMessageDialog(null,"Error al insertar el registro");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de conexión" + e.getMessage());
        }
     }
       
    public void buscarSinFil(JTable Tabla ){
        String[] titulos = {"id_mascota","nombre","sexo","edad","tamaño","color","tipo_animal","ubicación","fecha_ingreso","estado","foto"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            
            String estado = "Disponible";
            
            sentencia = connection.createStatement();
            
           
                    
            resultado = sentencia.executeQuery("select * from mascotas WHERE estado = '" + estado +  "'"
            );
            while (resultado.next()) {
                
                Object[] fila = new Object[11];
                fila[0]= resultado.getObject(1);
                fila[1]= resultado.getObject(2);
                fila[2]= resultado.getObject(3);
                fila[3]= resultado.getObject(4);
                fila[4]= resultado.getObject(5);
                fila[5]= resultado.getObject(6);
                fila[6]= resultado.getObject(7);
                fila[7]= resultado.getObject(8);
                fila[8]= resultado.getObject(9);
                fila[9]= resultado.getObject(10);
                fila[10] = resultado.getObject(12);
                modelo.addRow(fila);
                Tabla.setModel(modelo);
            }

                
            
            Tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
     }
    
  public void modificarMascotas2(String id, String Nombre, String sexo, int edad,
            String tamano, String color, String tipo, Byte foto, String ubicacion, Date fecha, String estado,String nombre_Imagen) {
      try{
//          Agregarle lo de la edad
       sentencia = connection.createStatement();
           int z = sentencia.executeUpdate("UPDATE mascotas SET nombre = '" + Nombre + "', sexo ='" + sexo  +"',edad=" + edad +  " ,tamaño ='"+ tamano+
                   "',color='" + color+ "',tipo_animal='" +tipo+"',ubicación='" +ubicacion +"' WHERE id_mascota = '" + id
                  + "'");
            if (z == 1) {
                System.out.println("Se módificó el registro de manera exitosa");
            } else {
                System.out.println("Error al modificar el registro");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
      
     
  }
     
        
     public void modificarMascotas(String id, String Nombre, String sexo, String edad,
            String tamano, String color, String tipo, Byte foto, String ubicacion, Date fecha, String estado,String nombre_Imagen) {
          String update = "UPDATE mascotas SET nombre=?, sexo = ?, edad=? , tamaño=?, color=?, tipo_animal=?, ubicación=?, fecha_ingreso=?, estado=?, foto=?, foto_nom=? WHERE id_mascota = '" + id + "'";

        try{
            FileInputStream archivofoto;
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, Nombre);
            ps.setString(2, sexo);
            ps.setString(3, edad);
            ps.setString(4, tamano);
            ps.setString(5, color);
            ps.setString(6, tipo);
            ps.setString(7, ubicacion);
            ps.setDate(8, (java.sql.Date) fecha);
            ps.setString(9, estado);
            archivofoto = new FileInputStream(nombre_Imagen);
            ps.setBinaryStream(10, archivofoto);
            ps.setString(11, nombre_Imagen);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e.getLocalizedMessage());
        }
      
        
    }

    public void modificarEstadoRechaMas(String id){
         try{
             String blo = "Disponible";
           sentencia = connection.createStatement();
            int z = sentencia.executeUpdate("UPDATE mascotas SET estado = '" +blo +  "' WHERE id_mascota = '" + id +
                                    "'");
            if (z == 1) {
                System.out.println("Se módificó el registro de manera exitosa");
            } else {
                System.out.println("Error al modificar el registro");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
     }
    
    public void modificarEstadoSoliRecha(int id){
         try{
             String blo = "Rechazada";
           sentencia = connection.createStatement();
            int z = sentencia.executeUpdate("UPDATE solicitud SET estado = '" +blo +  "' WHERE id_so = " + id + "");
            if (z == 1) {
                System.out.println("Se módificó el registro de manera exitosa");
            } else {
                System.out.println("Error al modificar el registro");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
     }
    
     public void modificarEstadoMasAdop(String id){
         try{
             String blo = "adoptada";
           sentencia = connection.createStatement();
            int z = sentencia.executeUpdate("UPDATE mascotas SET estado = '" +blo +  "' WHERE id_mascota = '" + id +
                                    "'");
            if (z == 1) {
                System.out.println("Se módificó el registro de manera exitosa");
            } else {
                System.out.println("Error al modificar el registro");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
     }
     public void llenar_combo(JComboBox CMB){
       
        try {
           sentencia= connection.createStatement();
            resultado = sentencia.executeQuery("select * from historial");
            
           
           while(resultado.next()){
               CMB.addItem(resultado.getString("cedula_usu"));
               
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No Correcto" + e.getLocalizedMessage());
        }
     }
     
    public void modificarEstadoSoliApro(int id){
        String blo = "Aprobada";
          try{
           sentencia = connection.createStatement();
            int z = sentencia.executeUpdate("UPDATE solicitud SET estado= '" + blo +  "' WHERE id_so = " + id + "");
            if (z == 1) {
                System.out.println("Se módificó el registro de manera exitosa");
            } 
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
    }

    public void correoApro(String cedula,String id_mas) throws SQLException {
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        
        String correoEnvia = "chago312633@gmail.com";
        String contrasena = "ricardo3126";
        String destinatario = informacionCorreo(cedula);
        String asunto = "Respuesta de solicitud de adopción";
        String mensaje = informacioMas(id_mas) +"\n"
                + informacionAdopta(cedula) ;
        
        
        MimeMessage mail = new MimeMessage(sesion);
        
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia,contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            
            JOptionPane.showMessageDialog(null, "Correo enviado");
            
        } catch (AddressException ex) {
           JOptionPane.showMessageDialog(null, "error" + ex.getLocalizedMessage());
            
            
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "error" + ex.getLocalizedMessage());
            
        }
        
        
    }
    public void correoRecha(String cedula,String id_mas) throws SQLException {
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        
        String correoEnvia = "chago312633@gmail.com";
        String contrasena = "ricardo3126";
        String destinatario = informacionCorreo(cedula);
        String asunto = "Respuesta de solicitud de adopción";
        String mensaje = "Por disposiciones de la\n"
                + "administración, se le indica\n"
                + "que su solicitud fue\n"
                + "rechazada";
        
        
        MimeMessage mail = new MimeMessage(sesion);
        
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia,contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            
            JOptionPane.showMessageDialog(null, "Correo enviado");
            
        } catch (AddressException ex) {
           JOptionPane.showMessageDialog(null, "error" + ex.getLocalizedMessage());
            
            
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "error" + ex.getLocalizedMessage());
            
        }
        
        
    }
    public void respuesta_soli(String respuesta,String id_mascota, int id_soli,String cedula) throws SQLException{
        try {
            if (respuesta == "Aprobada") {
                modificarEstadoMasAdop(id_mascota);
               modificarEstadoSoliApro(id_soli);
               correoApro(cedula, id_mascota);

            } else {
                modificarEstadoRechaMas(id_mascota);
                modificarEstadoSoliRecha(id_soli);
                correoRecha(cedula, id_mascota);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        
    }
    
    public String informacionAdopta(String cedula) throws SQLException{
          String nombre= "";
          String cedula1 = "";
            try{    
            sentencia = connection.createStatement();
            resultado = sentencia.executeQuery("SELECT cedula,nombre from usuarios where usuarios.cedula = '" + cedula + "'");

            while (resultado.next()) {
                cedula1 =  (resultado.getString("cedula"));
                nombre = (resultado.getString("nombre"));
                
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
         return  cedula1 +"\n"+ nombre ;
        
    }
     public String informacionCorreo(String cedula) throws SQLException{
        String correo = "";
            try{    
            sentencia = connection.createStatement();
            resultado = sentencia.executeQuery("SELECT correo from usuarios where usuarios.cedula = '" + cedula + "'");

            while (resultado.next()) {
                correo =  (resultado.getString("correo"));
               
                
              
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
         return  correo;
        
    }
   
     public void insertarHistorial(int id_soli , String cedula_usu,String id_mascotas,Date fecha){
     try {
             sentencia= connection.createStatement(); 
             
            int z = sentencia.executeUpdate("INSERT INTO historial (id_solicitud,cedula_usu,id_mascotas,fecha_adopción) "
                  + "VALUES (" +  id_soli + ", '" + cedula_usu + "', '" + id_mascotas + "', '"
                  + fecha + 
                   "')");
            if (z == 1) {
                JOptionPane.showMessageDialog(null,"Se agregó el registro de manera exitosa");
                
            } else {
                JOptionPane.showMessageDialog(null,"Error al insertar el registro");
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de conexión" + e.getMessage());
        }
     }
     
     public String informacioMas(String id_mas){
          String mascota = "";
            try{    
            sentencia = connection.createStatement();
            resultado = sentencia.executeQuery("SELECT nombre,sexo,edad,tamaño,color,tipo_animal,ubicación,fecha_ingreso from mascotas where mascotas.id_mascota = '" + id_mas + "'");

            while (resultado.next()) {
                String nombre =  (resultado.getString("nombre"));
                String sexo =  (resultado.getString("sexo"));
                String edad =  (resultado.getString("edad"));
                String tamano =  (resultado.getString("tamaño"));
                String color =  (resultado.getString("color"));
                String tipo =  (resultado.getString("tipo_animal"));
                String ubicacio =  (resultado.getString("ubicación"));
                String fecha =  (resultado.getString("fecha_ingreso"));
                
                
                mascota = "Nombre: " + nombre + "\n"
                        +"sexo: " + sexo + "\n"
                        + "edad: " + edad + "\n"
                        + "Tamaño: " + tamano + "\n"
                        + "color: " + color + "\n"
                        + "Especie: " + tipo + "\n"
                        + "Ubicación: " + ubicacio + "\n"
                        + "fecha: " + fecha;
                        
                
               
                
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
         return  mascota;
        
         
         
     }
     
       public void mostrarReporteHistorial(JTable Tabla,String cedula ){
        String[] titulos = {"id_historial","id_solicitud","fecha_adopcion","id_mascota","nombre","sexo","edad","tamaño","color","tipo_animal","ubicación"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            String estado="adoptada";
           
            
            sentencia = connection.createStatement();
            
               resultado = sentencia.executeQuery("select h.id_historial,h.id_solicitud,h.fecha_adopción,m.id_mascota,m.nombre\n"
                    + ",m.sexo,m.edad,m.tamaño,m.color,m.tipo_animal,m.ubicación\n"
                    + "from historial h,mascotas m , solicitud s, usuarios u\n"
                    + "where h.id_mascotas = m.id_mascota  and m.id_mascota = s.id_mascotas\n"
                    + "and u.cedula = h.cedula_usu and u.cedula = s.cedula_usu and\n"
                    + " h.cedula_usu ='" + cedula + "'and m.estado ='"+estado    + "'");
            while (resultado.next()) {
                
                Object[] fila = new Object[11]; 

                
                for (int i = 0; i < 11; i++) {
                    fila[i] = resultado.getObject(i + 1); 
                }
                
                modelo.addRow(fila);
                Tabla.setModel(modelo);
            }

                
            
            Tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
     }
    
    public int cantidadMas(String animal,String desde, String hasta){
           int cant =0;
           String adoptada = "adoptada";
            try{    
               
            sentencia = connection.createStatement();
                resultado = sentencia.executeQuery("SELECT count(m.tipo_animal) as cantidad_perros \n"
                        + "from mascotas m WHERE m.tipo_animal ='" + animal +"' and m.estado ='"+adoptada+  
                        "' and fecha_ingreso BETWEEN '"+desde +"' and '" +hasta  +"'");

            while (resultado.next()) {
               
                cant = Integer.valueOf(resultado.getString("cantidad_perros"));
                
            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e.getMessage());
        }
         return cant ;
        
        
    }
    
    public void grafico(int cantidaGa ,int cantidadPe,JPanel grafico){
       String titulo = "Total de perro y gatos adoptados!!";
        try {
            DefaultCategoryDataset gra = new DefaultCategoryDataset();
            gra.addValue(cantidadPe, "Perros","");
            gra.addValue(cantidaGa, "Gatos", "");
            
            JFreeChart fico =ChartFactory.createBarChart(titulo, "Mascotas adoptadas", "Cantidad de mascotas", gra, PlotOrientation.VERTICAL, true, true, true);
          
            
            ChartPanel on  = new ChartPanel(fico);
            grafico.setLayout(new java.awt.BorderLayout());
            grafico.add(on);
            grafico.validate();
            
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" +" " + e.getLocalizedMessage() );
        }
        
        
    }
    
    public void mostrarHistorial(JTable Tabla){
        String[] titulos = {"id_historial","id_solicitud","fecha_adopcion","id_mascota","nombre","sexo","edad","tamaño","color","tipo_animal","ubicación"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            String es = "adoptada";
           
            
            sentencia = connection.createStatement();
            
               resultado = sentencia.executeQuery("select h.id_historial,h.id_solicitud,h.fecha_adopción,m.id_mascota,m.nombre\n"
                    + ",m.sexo,m.edad,m.tamaño,m.color,m.tipo_animal,m.ubicación\n"
                    + "from historial h,mascotas m , solicitud s, usuarios u\n"
                    + "where h.id_mascotas = m.id_mascota  and m.id_mascota = s.id_mascotas\n"
                    + "and u.cedula = h.cedula_usu and u.cedula = s.cedula_usu and\n"
                    + " m.estado ='" + es + "'");
            while (resultado.next()) {
                
                Object[] fila = new Object[11]; 

                
                for (int i = 0; i < 11; i++) {
                    fila[i] = resultado.getObject(i + 1); 
                }
                
                modelo.addRow(fila);
                Tabla.setModel(modelo);
            }

                
            
            Tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
     }
   
}
