/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Frontend.PantallaFinJuego;
import Frontend.TaTeTi.PantallaJuegoTateti;
import Frontend.PrimerPantalla;
import Frontend.TaTeTi.PantallaPrimerTurno;
import javax.swing.JFrame;

public class Utils {

    public static void crearPantallaFinJuego(JFrame frameHeredado) {
        PantallaFinJuego pfj = new PantallaFinJuego(1, frameHeredado);
        pfj.setVisible(true);
        pfj.setLocationRelativeTo(null);
    }

    public static void crearPrimerPantalla() {
        PrimerPantalla pp = new PrimerPantalla();
        pp.setVisible(true);
        pp.setLocationRelativeTo(null);
    }

    public static void crearJuegoTateti(int opc) {
        PantallaJuegoTateti pjt = new PantallaJuegoTateti(opc);
        pjt.setVisible(true);
        pjt.setLocationRelativeTo(null);
    }
    
    public static void crearPrimerTurno() {
        PantallaPrimerTurno ppt = new PantallaPrimerTurno();
        ppt.setVisible(true);
        ppt.setLocationRelativeTo(null);
    }
    
}
