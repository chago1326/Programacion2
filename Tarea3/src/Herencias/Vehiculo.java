/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencias;

/**
 *
 * @author personal
 */
public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private String color;

    public Vehiculo(String matricula, String marca, String modelo,String color) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;

    }

    public String getAtributos() {
        return "Matrícula: " + this.matricula
                + " Modelo: " + this.marca + " " + this.modelo
                + " Color: " + this.color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }




    
}
