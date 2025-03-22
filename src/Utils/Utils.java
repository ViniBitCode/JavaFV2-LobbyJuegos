
package Utils;

import Frontend.Ahorcado.PantallaAhorcado;
import Frontend.Ahorcado.PrimerPantallaAhorcado;
import Frontend.Buscaminas.PrimerPantallaBuscaminas;
import Frontend.Buscaminas.PantallaBuscaminas;
import PantallasReutilizables.PantallaFinJuego;
import Frontend.TaTeTi.PantallaTateti;
import PantallasReutilizables.PrimerPantalla;
import Frontend.TaTeTi.PrimerPantallaTateti;
import javax.swing.JFrame;

public class Utils {

    public static void crearPantallaFinJuego(JFrame frameHeredado, int opc) {
        PantallaFinJuego pfj = new PantallaFinJuego(opc, frameHeredado);
        pfj.setVisible(true);
        pfj.setLocationRelativeTo(null);
    }

    public static void crearPrimerPantalla() {
        PrimerPantalla pp = new PrimerPantalla();
        pp.setVisible(true);
        pp.setLocationRelativeTo(null);
    }

    public static void crearJuegoTateti(int opc) {
        PantallaTateti pjt = new PantallaTateti(opc);
        pjt.setVisible(true);
        pjt.setLocationRelativeTo(null);
    }
    
    public static void crearPrimerTurnoTateti() {
        PrimerPantallaTateti ppt = new PrimerPantallaTateti();
        ppt.setVisible(true);
        ppt.setLocationRelativeTo(null);
    }
    
    public static void crearDificultadBuscaminas() {
        PrimerPantallaBuscaminas pd = new PrimerPantallaBuscaminas();
        pd.setVisible(true);
        pd.setLocationRelativeTo(null);
    }
    
    public static void crearPantallaJuegoBuscaminas(int height, int width, int cantMinas){
        PantallaBuscaminas pjb = new PantallaBuscaminas(height, width, cantMinas);
        pjb.setVisible(true);
        pjb.setLocationRelativeTo(null);
    }

    public static void crearIngresarPalabraAhorcado() {
        PrimerPantallaAhorcado ppa = new PrimerPantallaAhorcado();
        ppa.setVisible(true);
        ppa.setLocationRelativeTo(null);
    }
    
    public static void crearPantallaAhorcado(String palabra) {
        PantallaAhorcado pa = new PantallaAhorcado(palabra);
        pa.setVisible(true);
        pa.setLocationRelativeTo(null);
    }
    
}
