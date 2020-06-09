/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import javax.swing.JOptionPane;

/**
 *
 * @author personal
 */
public class PalabraRima {

    public void palabraRima() {
        String pa1 = JOptionPane.showInputDialog("Digite su palabra: ");
        String pa2 = JOptionPane.showInputDialog("Digite su palabra: ");

        String ultitre1;

        String ultitre2;

        String ultidos1;

        String ultidos2;

        String ultima1;

        String ultima2;

        ultitre1 = pa1.substring(pa1.length() - 3, pa1.length());
        ultitre2 = pa2.substring(pa2.length() - 3, pa2.length());

        ultidos1 = pa1.substring(pa1.length() - 2, pa1.length());
        ultidos2 = pa2.substring(pa2.length() - 2, pa2.length());

        ultima1 = pa1.substring(pa1.length() - 1, pa1.length());
        ultima2 = pa2.substring(pa2.length() - 1, pa2.length());

        if (ultitre1.equals(ultitre2)) {
            JOptionPane.showMessageDialog(null, "Las palabras que ingreso riman!!");
        } else if (ultidos1.equals(ultidos2)) {
            JOptionPane.showMessageDialog(null, "Las palabras que ingreso riman un poco!!");
        } else {
            JOptionPane.showMessageDialog(null, "Las palabras que ingreso no riman!!");
        }

    }

    public static void main(String[] args) {
        PalabraRima log = new PalabraRima();

        log.palabraRima();

    }

}
