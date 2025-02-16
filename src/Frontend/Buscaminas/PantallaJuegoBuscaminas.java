package Frontend.Buscaminas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PantallaJuegoBuscaminas extends javax.swing.JFrame {

    private final int heightTablero;
    private final int widthTablero;
    private int cantMinas;
    private Random r = new Random();

    JPanel[][] panelBody;
    JLabel lblCasillaText;
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

    }

    // ATENDEME! ORDEN DE LAYOUT ACTUAL = BOTONES -> LAYOUT -> TEXTO
    //           ORDEN DE LAYOUT BUSCAR = BOTONES -> TEXTO -> LAYOUT
    private void setearTableroYMinas() {
        this.setLayout(new GridLayout(heightTablero, widthTablero, 5, 5));
        panelBody = new JPanel[heightTablero][widthTablero];
        for (int i = 0; i < heightTablero; i++) {
            for (int j = 0; j < widthTablero; j++) {
                panelBody[i][j] = new JPanel(new CardLayout());
                panelBody[i][j].setBackground(Color.lightGray);
                // Agregar tanto el botón como el JLabel en cada celda
                agregarBoton(i, j);

                this.add(panelBody[i][j]);
            }
        }

        // PONER MINAS -> Label
        int x = 0, y = 0;
        do {
            x = r.nextInt(heightTablero);
            y = r.nextInt(widthTablero);
            try {
                panelBody[x][y].getComponent(1);
            } catch (Exception e) {
                lblCasillaText = new JLabel("X", SwingConstants.CENTER);
                panelBody[x][y].add(lblCasillaText, "lblCasillaText");
                cantMinas--;
            }
        } while (cantMinas > 0);

    }

    private void agregarBoton(int i, int j) {
        JButton button = new JButton();
        button.setFocusable(false);
        button.addActionListener(e -> {
            // Esto muestra el label debajo del boton
            CardLayout layout = (CardLayout) panelBody[i][j].getLayout();
            layout.show(panelBody[i][j], "lblCasillaText");
            
            // Esto muestra cuando no hay nada debajo
            if(panelBody[i][j].getComponentCount() == 1) {
                panelBody[i][j].remove(button); // Remueve el boton
                panelBody[i][j].revalidate();       // reorganiza todos los componentesa que hayan en el panel
                panelBody[i][j].repaint();          // Dibuja el panel con todo
            }
            
        });

        panelBody[i][j].add(button, "button"); // Agregar con identificador
        ((CardLayout) panelBody[i][j].getLayout()).show(panelBody[i][j], "button"); // Mostrar primero el botón

    }

    private void setearNumeros() {
        for (int i = 0; i < heightTablero; i++) {
            for (int j = 0; j < widthTablero; j++) {
                try {
                    lblMinaAlrededor = (JLabel) panelBody[i][j].getComponent(1);
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
            JLabel lblNumero = (JLabel) panelBody[xAux][yAux].getComponent(1);      // Agarrar lbl de la casilla
            if (!lblNumero.getText().equals("X")) {                            // ver que no haya una mina antes
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

                panelBody[xAux][yAux].add(lblNumero, "lblCasillaText");
            }
        } catch (Exception e) {
            JLabel lbl = new JLabel("", SwingConstants.CENTER);
            lbl.setText("1");
            lbl.setForeground(Color.blue);
            panelBody[xAux][yAux].add(lbl, "lblCasillaText");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
