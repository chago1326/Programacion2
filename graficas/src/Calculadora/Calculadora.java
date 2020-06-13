/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

/**
 *
 * @author Ricardo Millon
 */
public class Calculadora {
    private String operacion;
    private double operando1;
    private double operando2;

    public Calculadora(){
        this.operacion = "+";
        this.operando1 = 0;
        this.operando2 = 0;
    }

    public double ejecutarOperacion() throws Exception{
        double resultado = 0;
        try{
            switch(this.operacion){
                case "+":
                    resultado = this.operando1 + this.operando2;
                    break;
                case "*":
                    resultado = this.operando1 * this.operando2;
                    break;
                case "/":
                    resultado = this.operando1 / this.operando2;
                    break;
                case "-":
                    resultado = this.operando1 - this.operando2;
                    break;
                default:
                    throw new Exception("Operación no soportada!");                    
            }
        }catch(ArithmeticException e){
            throw  e;
        }                
        return resultado;
    }
    
    /**
     * @return the operacion
     */
    public String getOperacion() {
        return operacion;
    }

    /**
     * @param operacion the operacion to set
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /**
     * @return the operando1
     */
    public double getOperando1() {
        return operando1;
    }

    /**
     * @param operando1 the operando1 to set
     */
    public void setOperando1(double operando1) {
        this.operando1 = operando1;
    }

    /**
     * @return the operando2
     */
    public double getOperando2() {
        return operando2;
    }

    /**
     * @param operando2 the operando2 to set
     */
    public void setOperando2(double operando2) {
        this.operando2 = operando2;
    }
    
    
   
}
