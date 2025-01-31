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
        int xAux = 0, yAux = 0;
        for (int i = 0; i < heightTablero; i++) {
            for (int j = 0; j < widthTablero; j++) {
                xAux = i;
                yAux = j;
                xAux--;
                yAux--;
                deteccionDeMina(xAux, yAux); // ARR-IZQ

                xAux = i;
                yAux = j;
                xAux--;
                deteccionDeMina(xAux, yAux); // ARR

                xAux = i;
                yAux = j;
                xAux--;
                yAux++;
                deteccionDeMina(xAux, yAux); // ARR-DER

                xAux = i;
                yAux = j;
                yAux--;
                deteccionDeMina(xAux, yAux); // CEN-IZQ

                xAux = i;
                yAux = j;
                yAux++;
                deteccionDeMina(xAux, yAux); // CEN-DER

                xAux = i;
                yAux = j;
                xAux++;
                yAux--;
                deteccionDeMina(xAux, yAux); // ABJ-IZQ

                xAux = i;
                yAux = j;
                xAux++;
                deteccionDeMina(xAux, yAux); // ABJ

                xAux = i;
                yAux = j;
                xAux++;
                yAux++;
                deteccionDeMina(xAux, yAux); // ABJ-DER

                try {
                    panelBody[i][j].getComponent(0);
                } catch (Exception e) {
                    if (cantMinasAlrededor != 0) {
                        int contAux = cantMinasAlrededor;
                        JLabel label = new JLabel(Integer.toString(contAux));
                        if (label.getText().equals("1")) {
                            label.setForeground(Color.blue);
                        }
                        if (label.getText().equals("2")) {
                            label.setForeground(Color.GREEN);
                        }
                        if (label.getText().equals("3")) {
                            label.setForeground(Color.red);
                        }
                        panelBody[i][j].add(label);

                        System.out.println("Cantidad de minas detectadas para la casilla [" + i + "][" + j + "]: " + cantMinasAlrededor);

                    }
                }
                cantMinasAlrededor = 0;
            }

        }
    }

    private void deteccionDeMina(int i, int j) {
        try {
            lblMinaAlrededor = (JLabel) panelBody[i][j].getComponent(0);
            if (lblMinaAlrededor.getText().equals("X")) {
                cantMinasAlrededor++;
            }
        } catch (Exception e) {
            // poner comentario
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
