/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.conexion;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author personal
 */
public class Usuario {

    conexion log = new conexion();
    
    
    public void modificarMascotas2(String id, String Nombre, String sexo, int edad,
            String tamano, String color, String tipo, Byte foto, String ubicacion, Date fecha, String estado,String nombre_Imagen) {
        log.modificarMascotas2(id, Nombre, sexo, 0, tamano, color, tipo, foto, ubicacion, fecha, estado, nombre_Imagen);
    }
    public String informacionAdopta(String cedula) throws SQLException{
        return log.informacionAdopta(cedula);
    }
    public String informacioMas(String id_mas){
        return log.informacioMas(id_mas);
    }
    public void insertarHistorial( int id_soli, String cedula_usu, String id_mascotas, Date fecha) {
        log.insertarHistorial(id_soli, cedula_usu, id_mascotas, fecha);
    }

    public void modificarMascotas(String id, String Nombre, String sexo, String edad,
            String tamano, String color, String tipo, Byte foto, String ubicacion, Date fecha, String estado,String nombre_Imagen) {
        log.modificarMascotas(id, Nombre, sexo, edad, tamano, color, tipo, foto, ubicacion, fecha, estado,nombre_Imagen);
        
    }

     public void  mostrarFoto(JLabel lblfoto,String nombre,JTextField txtnombre,String id){
         log.mostrarFoto(lblfoto, nombre, txtnombre, id);
     }
    public void buscarSinFil(JTable Tabla) {
        log.buscarSinFil(Tabla);
    }

    public void insertarSoli( String cedula, String id_mascotas) {
        log.insertarSoli(cedula, id_mascotas);
    }
    public void insertarmascotas(String id,String Nombre,String sexo,String edad,
            String tamano,String color,String tipo ,JLabel lblfoto,String ubicacion,Date fecha,String estado,String nombreImagen) throws SQLException{
        log.insertarmascotas(id, Nombre, sexo, edad, tamano, color, tipo, lblfoto, ubicacion, fecha, estado, nombreImagen);
    }

    public void modificarEstado(String id) {
        log.modificarEstado(id);
        
    }
    
    public void buscarTipo(JTable Tabla, String tipo) {
        log.buscarTipo(Tabla, tipo);
    }
    
    public void buscarUbicacion(JTable Tabla, String ubicacion) {
        log.buscarUbicacion(Tabla, ubicacion);
    }

    public void buscarRango(JTable Tabla, int desde, int hasta) {
        log.buscarRango(Tabla, desde, hasta);
    }
    
    public boolean login(String usu, String contra, String tipo) {        
        return log.login(usu, contra, tipo);
    }
    
    public void Conexion() {
        log.Conexion();
    }
    
    public void insertar(String id, String Nombre, String sexo, int edad,
            String tamano, String color, String tipo, Byte foto, String ubicacion, Date fecha, String estado) {
        log.insertar(id, Nombre, sexo, edad, tamano, color, tipo, foto, ubicacion, fecha, estado);
    }
    
    public void mostrar(JTable tabla,JLabel lblfoto) {
        log.mostrar(tabla,lblfoto);
    }
    
    public void eliminar(String id) {
        log.eliminar(id);
    }

    public void mostrarSoli(JTable tabla) {
        log.mostrarSoli(tabla);
    }

    public void insertarUsu(String cedula, String nombre, String pass,
            String correo, String tipo) {
        log.insertarUsu(cedula, nombre, pass, correo, tipo);
    }
    
    public void respuesta_soli(String respuesta, String id_mascota,int id_soli
            , String cedula) throws SQLException {
        log.respuesta_soli(respuesta, id_mascota, id_soli, cedula);
        
    }
    
    public String informacionCorreo(String cedula) throws SQLException {
        return log.informacionCorreo(cedula);
    }

    public void llenar_combo(JComboBox CMB) {
        log.llenar_combo(CMB);
    }

    public void mostrarReporteHistorial(JTable Tabla, String cedula) {
        log.mostrarReporteHistorial(Tabla, cedula);
    }
    
    public int cantidadMas(String animal,String desde, String hasta) {
        return log.cantidadMas(animal,desde,hasta);
    }
    
    public void grafico(int cantidaGa, int cantidadPe,JPanel grafico) {
        log.grafico(cantidaGa, cantidadPe,grafico);
    }
    public void imagen(JLabel lblfoto){
        log.imagen(lblfoto);
    }
      public void mostrarHistorial(JTable Tabla){
          log.mostrarHistorial(Tabla);
      }
    
      public boolean desencriptar(String cedula,String pass,String tipo) throws SQLException{
          return log.desencriptar(cedula, pass,tipo);
      }
}
