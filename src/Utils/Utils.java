
package Utils;

import Frontend.Buscaminas.PantallaDificultad;
import Frontend.Buscaminas.PantallaJuegoBuscaminas;
import Frontend.PantallaFinJuego;
import Frontend.TaTeTi.PantallaJuegoTateti;
import Frontend.PrimerPantalla;
import Frontend.TaTeTi.PantallaPrimerTurno;
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
        PantallaJuegoTateti pjt = new PantallaJuegoTateti(opc);
        pjt.setVisible(true);
        pjt.setLocationRelativeTo(null);
    }
    
    public static void crearPrimerTurno() {
        PantallaPrimerTurno ppt = new PantallaPrimerTurno();
        ppt.setVisible(true);
        ppt.setLocationRelativeTo(null);
    }
    
    public static void crearDificultad() {
        PantallaDificultad pd = new PantallaDificultad();
        pd.setVisible(true);
        pd.setLocationRelativeTo(null);
    }
    
    public static void crearPantallaJuegoBuscaminas(int height, int width, int cantMinas){
        PantallaJuegoBuscaminas pjb = new PantallaJuegoBuscaminas(height, width, cantMinas);
        pjb.setVisible(true);
        pjb.setLocationRelativeTo(null);
    }
    
}
