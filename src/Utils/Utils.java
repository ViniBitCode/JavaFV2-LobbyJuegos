/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Frontend.PantallaFinJuego;
import javax.swing.JFrame;

public class Utils {

    public static void crearPantallaFinJuego(JFrame frameHeredado) {
        PantallaFinJuego pfj = new PantallaFinJuego(1, frameHeredado);
        pfj.setVisible(true);
        pfj.setLocationRelativeTo(null);
    }
}
