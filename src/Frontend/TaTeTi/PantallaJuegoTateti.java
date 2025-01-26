/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend.TaTeTi;

import Utils.Utils;
import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;

public class PantallaJuegoTateti extends javax.swing.JFrame {

    private JButton buttons[] = new JButton[9];
    private Random r = new Random();
    private int contTurnos = 0;
    private boolean partidaGanada = false;
    private boolean partidaEmpatada = false;
    
    // Esta variable es modificada desde la anterior pantalla
    private int turno;

    public PantallaJuegoTateti(int turno) {
        this.turno = turno;
        initComponents();
        iniciarJuego();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn00 = new javax.swing.JButton();
        btn01 = new javax.swing.JButton();
        btn02 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(3, 3));

        btn00.setPreferredSize(new java.awt.Dimension(72, 50));
        btn00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn00ActionPerformed(evt);
            }
        });
        jPanel1.add(btn00);

        btn01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01ActionPerformed(evt);
            }
        });
        jPanel1.add(btn01);

        btn02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn02ActionPerformed(evt);
            }
        });
        jPanel1.add(btn02);

        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });
        jPanel1.add(btn10);

        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });
        jPanel1.add(btn11);

        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });
        jPanel1.add(btn12);

        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });
        jPanel1.add(btn20);

        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });
        jPanel1.add(btn21);

        btn22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn22ActionPerformed(evt);
            }
        });
        jPanel1.add(btn22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarJuego() {
        buttons[0] = btn00;
        buttons[1] = btn01;
        buttons[2] = btn02;
        buttons[3] = btn10;
        buttons[4] = btn11;
        buttons[5] = btn12;
        buttons[6] = btn20;
        buttons[7] = btn21;
        buttons[8] = btn22;
        
        if(turno == 1) { // Comienza la maquina
            maquinaJuega();
            contTurnos++;
        }
    }
        
    

    private void btn00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn00ActionPerformed
        buttons[0].setEnabled(false);
        ponerIconoSegunTurno(buttons[0]);
    }//GEN-LAST:event_btn00ActionPerformed

    // Arreglar error -> posicion mal del boton 
    private void btn01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01ActionPerformed
        buttons[1].setEnabled(false);
        ponerIconoSegunTurno(buttons[1]);
    }//GEN-LAST:event_btn01ActionPerformed

    private void btn02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn02ActionPerformed
        buttons[2].setEnabled(false);
        ponerIconoSegunTurno(buttons[2]);
    }//GEN-LAST:event_btn02ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        buttons[3].setEnabled(false);
        ponerIconoSegunTurno(buttons[3]);
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        buttons[4].setEnabled(false);
        ponerIconoSegunTurno(buttons[4]);
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        buttons[5].setEnabled(false);
        ponerIconoSegunTurno(buttons[5]);
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        buttons[6].setEnabled(false);
        ponerIconoSegunTurno(buttons[6]);
    }//GEN-LAST:event_btn20ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        buttons[7].setEnabled(false);
        ponerIconoSegunTurno(buttons[7]);
    }//GEN-LAST:event_btn21ActionPerformed

    private void btn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn22ActionPerformed
        buttons[8].setEnabled(false);
        ponerIconoSegunTurno(buttons[8]);
    }//GEN-LAST:event_btn22ActionPerformed

    private void ponerIconoSegunTurno(JButton btn) {
        contTurnos++;

        btn.setText("X");
        // Primero se verifica si la persona gana la partida
        verificarVictoria("X", Color.green);

        // Este segmento se encarga de no empatar la partida si la persona gana en su último turno
        if (partidaGanada == false) {
            verificarEmpate();
        }

        // Si no se empata ni se gana todavía, la máquina seguira jugando
        if (partidaGanada == false && partidaEmpatada == false) {
            maquinaJuega();
            verificarVictoria("O", Color.red);
        }

    }

    // Busca un boton libre al cual ponerle la "O"
    private void maquinaJuega() {
        boolean flag = false;
        do {
            int botonAleatorio = r.nextInt(9); // Elegir boton random simulando maquina
            if (buttons[botonAleatorio].getText().equals("") || contTurnos >= 5) {
                buttons[botonAleatorio].setText("O");
                buttons[botonAleatorio].setEnabled(false);
                flag = true;
            }
        } while (!flag);
    }

    private void verificarEmpate() {
        if (contTurnos == 5) {
            for (JButton button : buttons) {
                button.setBackground(Color.yellow);
            }
            partidaEmpatada = true;
            Utils.crearPantallaFinJuego(this);
        }
    }

    private void verificarVictoria(String symbol, Color background) {
        // Horizontales
        patronGanador(0, 1, 2, symbol, background);
        patronGanador(3, 4, 5, symbol, background);
        patronGanador(6, 7, 8, symbol, background);

        // Diagonales
        patronGanador(0, 4, 8, symbol, background);
        patronGanador(2, 4, 6, symbol, background);

        // Verticales
        patronGanador(0, 3, 6, symbol, background);
        patronGanador(1, 4, 7, symbol, background);
        patronGanador(2, 5, 8, symbol, background);
    }

    private void patronGanador(int btn1, int btn2, int btn3, String s, Color b) {
        if (buttons[btn1].getText().equals(s) && buttons[btn2].getText().equals(s) && buttons[btn3].getText().equals(s)) {
            buttons[btn1].setBackground(b);
            buttons[btn2].setBackground(b);
            buttons[btn3].setBackground(b);

            // Este bool me define si alguno de los 2 jugadores gana la partida
            partidaGanada = true;
            desactivarBotones();

            Utils.crearPantallaFinJuego(this);
        }
    }

    private void desactivarBotones() {
        for (JButton btn : buttons) {
            btn.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn00;
    private javax.swing.JButton btn01;
    private javax.swing.JButton btn02;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
