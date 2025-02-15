package Frontend.Buscaminas;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaJuegoBuscaminas extends javax.swing.JFrame {

    private final int heightTablero;
    private final int widthTablero;
    private int cantMinas;
    private Random r = new Random();

    JPanel[][] panelBody;
    JLabel lblMinaText;
    JLabel lblMinaAlrededor;
    private int cantMinasAlrededor = 0;

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
        setearBotones();

    }

    private void setearTableroYMinas() {
        this.setLayout(new GridLayout(heightTablero, widthTablero, 5, 5));
        panelBody = new JPanel[heightTablero][widthTablero];
        for (int i = 0; i < heightTablero; i++) {
            for (int j = 0; j < widthTablero; j++) {
                panelBody[i][j] = new JPanel();
                panelBody[i][j].setBackground(Color.lightGray);
                this.add(panelBody[i][j]);
            }
        }
        int x = 0, y = 0;
        do {
            x = r.nextInt(heightTablero);
            y = r.nextInt(widthTablero);
            try {
                panelBody[x][y].getComponent(0);
            } catch (Exception e) {
                panelBody[x][y].add(new JLabel("X"));
                cantMinas--;
            }
        } while (cantMinas > 0);
    }

    private void setearNumeros() {
//        int xAux = 0, yAux = 0;
        for (int i = 0; i < heightTablero; i++) {
            for (int j = 0; j < widthTablero; j++) {
                try {
                    lblMinaAlrededor = (JLabel) panelBody[i][j].getComponent(0);
                    if (lblMinaAlrededor.getText().equals("X")) {
                        for (int yAux = -1; yAux <= 1; yAux++) {
                            for (int xAux = -1; xAux <= 1; xAux++) {
                                if (yAux == 0 && xAux == 0) {
                                    continue;
                                }
                                if (xAux + i < 0 || yAux + j < 0) {
                                    continue;
                                }
                                sumarNumeroCasilla(xAux + i, yAux + j);
                            }
                        }
                    }
                } catch (Exception e) {
                    // System.out.println("Casilla fuera del mapa: [" + i + "][" + j + "]");
                    // Este error lo tira siempre. Tengo que ver que poner acá para manejarlo bien
                }
            }
        }
    }

    private void sumarNumeroCasilla(int xAux, int yAux) {
        try {
            JLabel lblPrueba = (JLabel) panelBody[xAux][yAux].getComponent(0);      // Agarrar lbl de la casilla
            if (!lblPrueba.getText().equals("X")) {                            // ver que no haya una mina antes
                int numMinas = Integer.valueOf(lblPrueba.getText());                // pasarlo a int
                lblPrueba.setText(String.valueOf(++numMinas));                    // pasar a string y sumarle++
                Color color = switch (lblPrueba.getText()) {
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
                        lblPrueba.getForeground();
                };

                lblPrueba.setForeground(color);

                panelBody[xAux][yAux].add(lblPrueba);
            }
        } catch (Exception e) {
            JLabel lbl = new JLabel();
            lbl.setText("1");
            lbl.setForeground(Color.blue);
            panelBody[xAux][yAux].add(lbl);
        }
    }

    private void setearBotones() {

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
