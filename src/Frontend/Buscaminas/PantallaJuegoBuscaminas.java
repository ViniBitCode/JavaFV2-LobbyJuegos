package Frontend.Buscaminas;

import Utils.Utils;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class PantallaJuegoBuscaminas extends javax.swing.JFrame {

    private final int heightTablero;
    private final int widthTablero;
    private final Random r = new Random();
    private int cantMinas;

    JPanel[][] panelBody;
    JLabel lblMinaAlrededor;

    public PantallaJuegoBuscaminas(int heightTablero, int widthTablero, int cantMinas) {
        initComponents();
        this.heightTablero = heightTablero;
        this.widthTablero = widthTablero;
        this.cantMinas = cantMinas;
        iniciarTablero();
        this.setSize(widthTablero * 50, heightTablero * 50);
    }

    private void iniciarTablero() {
        setearTableroYMinas();
        setearNumeros();

    }

    private void setearTableroYMinas() {
        // Dividir tablero en JPanel - Poner botones por como 2da carta
        this.setLayout(new GridLayout(heightTablero, widthTablero, 5, 5));
        panelBody = new JPanel[heightTablero][widthTablero];
        for (int i = 0; i < heightTablero; i++) {
            for (int j = 0; j < widthTablero; j++) {
                panelBody[i][j] = new JPanel(new CardLayout());
                panelBody[i][j].setBackground(Color.lightGray);
                agregarBoton(i, j);
                this.add(panelBody[i][j]);
            }
        }
        // Poner minas como JLabel como 1ra carta
        int x = 0, y = 0;
        do {
            x = r.nextInt(heightTablero);
            y = r.nextInt(widthTablero);
            try {
                panelBody[x][y].getComponent(1);
            } catch (Exception e) {
                JLabel lblCasillaText = new JLabel("X", SwingConstants.CENTER);
                panelBody[x][y].add(lblCasillaText, "lblCasillaText");
                cantMinas--;
            }
        } while (cantMinas > 0);
        // Rellena los espacios vacíos con un JLabel vacío
        for (int i = 0; i < heightTablero; i++) {
            for (int j = 0; j < widthTablero; j++) {
                try {
                    panelBody[i][j].getComponent(1);
                } catch (Exception e) {
                    JLabel lblCasillaText = new JLabel("");
                    panelBody[i][j].add(lblCasillaText, "lblCasillaText");
                }
            }
        }
    }

    private void agregarBoton(int i, int j) {
        JButton button = new JButton();
        button.setFocusable(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    JLabel lblNumero = (JLabel) panelBody[i][j].getComponent(1);
                    CardLayout layout = (CardLayout) panelBody[i][j].getLayout();
                    layout.show(panelBody[i][j], "lblCasillaText");
                    limpiarCasillasVacias(i, j);
                    checkWinOrLose(i, j);
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Buscaminas/redflag.png")));
                }
            }
        });
        panelBody[i][j].add(button, "button"); // Agregar con identificador
        ((CardLayout) panelBody[i][j].getLayout()).show(panelBody[i][j], "button"); // Mostrar primero el botón
    }

    private void setearNumeros() {
        // Setea los números sumando al rededor de las minas
        for (int i = 0; i < heightTablero; i++) {
            for (int j = 0; j < widthTablero; j++) {
                lblMinaAlrededor = (JLabel) panelBody[i][j].getComponent(1);
                if (lblMinaAlrededor.getText().equals("X")) {
                    for (int yAux = -1; yAux <= 1; yAux++) {
                        for (int xAux = -1; xAux <= 1; xAux++) {
                            //No toma en cuenta al centro
                            if (yAux == 0 && xAux == 0) {
                                continue;
                            }
                            // No toma en cuenta cuando se sale del 10x10 -> tira un error que no maneje hasta ahora
                            if (xAux + i < 0 || yAux + j < 0 || xAux + i > (heightTablero - 1) || yAux + j > (widthTablero - 1)) {
                                continue;
                            }
                            sumarNumeroCasilla(xAux + i, yAux + j);
                        }
                    }
                }
            }
        }
    }

    private void sumarNumeroCasilla(int xAux, int yAux) {

        JLabel lblNumero = (JLabel) panelBody[xAux][yAux].getComponent(1);      // Agarrar lbl de la casilla
        if (!lblNumero.getText().equals("X")) {                            // ver que no haya una mina antes
            if (lblNumero.getText().equals("")) {
                lblNumero.setText("1");
                lblNumero.setForeground(Color.blue);
                lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
            } else {
                int numMinas = Integer.valueOf(lblNumero.getText());                // pasarlo a int
                lblNumero.setText(String.valueOf(++numMinas));                    // pasar a string y sumarle++
                Color color = switch (lblNumero.getText()) {
                    case "2" ->
                        Color.GREEN;
                    case "3" ->
                        Color.RED;
                    case "4" ->
                        Color.CYAN;
                    case "5" ->
                        Color.MAGENTA;
                    case "6" ->
                        Color.YELLOW;
                    case "7" ->
                        Color.ORANGE;
                    case "8" ->
                        Color.DARK_GRAY;
                    default ->
                        lblNumero.getForeground();
                };
                lblNumero.setForeground(color);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkWinOrLose(int i, int j) {
        JLabel lblVacio = (JLabel) panelBody[i][j].getComponent(1);
        if (lblVacio.getText().equals("X")) {
            panelBody[i][j].setBackground(Color.red);
            Utils.crearPantallaFinJuego(this, 2);
        }
    }

    private void limpiarCasillasVacias(int i, int j) {
        JLabel lblVacio = (JLabel) panelBody[i][j].getComponent(1);
        // Esto se va a ejecutar la que tocaste esta vacia
        if (lblVacio.getText().equals("")) {
            lblVacio.setText(" ");
            for (int yAux = -1; yAux <= 1; yAux++) {
                for (int xAux = -1; xAux <= 1; xAux++) {
                    try {
                        lblVacio = (JLabel) panelBody[xAux + i][yAux + j].getComponent(1); // Esta me esta tirando un error medio chango -> se detendrá la busqueda?
                        if (!lblVacio.getText().equals("X") || lblVacio.getText().equals("")) {
                            CardLayout layout = (CardLayout) panelBody[xAux + i][yAux + j].getLayout();
                            layout.show(panelBody[xAux + i][yAux + j], "lblCasillaText");
                            limpiarCasillasVacias(xAux + i, yAux + j);
                        } else {
                            System.out.println("Termina busqueda por numero");
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        } else {
            // System.out.println("Texto en casilla [" + i + "][" + j + "] - " + lblVacio.getText());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
