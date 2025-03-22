/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend.Ahorcado;

import Utils.Utils;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DibujoAhorcado extends javax.swing.JPanel {

    private int cantErrores, cantLetras, cantAciertos;
    private final JFrame framePadre;
    private final int height, width;

    private String palabra;
    private char[] palabraSeparada;
    private JTextField[] panelLetra;
    private JPanel panelCasillas, panelLetrasIncorrectas;

    public DibujoAhorcado(int height, int width, String palabra, PantallaAhorcado JFrameAhorcado) {
        initComponents();
        this.palabra = palabra;
        palabraSeparada = new char[palabra.length()];
        panelLetra = new JTextField[palabra.length()];
        this.height = height;
        this.width = width;
        this.framePadre = JFrameAhorcado;
        this.setPreferredSize(new Dimension(width, height));
        cantErrores = 0;
        cantAciertos = 0;
        diseñarCasillas();

    }

    private void diseñarCasillas() {
        panelLetrasIncorrectas = new JPanel();
        panelLetrasIncorrectas.setBounds(0, 575, width, height);
        panelLetrasIncorrectas.setVisible(true);
        panelLetrasIncorrectas.setOpaque(true);
        panelLetrasIncorrectas.setBackground(Color.gray);
        panelLetrasIncorrectas.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelLetrasIncorrectas.setForeground(Color.white);
        this.add(panelLetrasIncorrectas);
        
        panelCasillas = new JPanel();
        panelCasillas.setBounds(0, 425, width, height);
        panelCasillas.setVisible(true);
        panelCasillas.setOpaque(true);
        panelCasillas.setBackground(Color.lightGray);
        panelCasillas.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        for (int i = 0; i < palabra.length(); i++) {
            palabraSeparada[i] = palabra.charAt(i);
            panelLetra[i] = new JTextField("");
            panelLetra[i].setHorizontalAlignment(JTextField.CENTER);
            panelLetra[i].setPreferredSize(new Dimension(30, 30));
            if (Character.isWhitespace(palabra.charAt(i))) {
                panelLetra[i].setEnabled(false);
            } else {
                cantLetras++;
            }
            panelCasillas.add(panelLetra[i]);
        }
        this.add(panelCasillas);
        System.out.println(cantLetras);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.black);              // Seteamos el color del dibujo. Este puede superponerse
        g2D.setStroke(new BasicStroke(5));   // Seteamos el ancho de la linea
        g2D.drawLine(275, 150, 425, 150);
        g2D.drawLine(350, 150, 350, 100);
        g2D.drawLine(200, 100, 350, 100);
        g2D.drawLine(200, 100, 200, 400);

        Runnable[] partesCuerpo = new Runnable[]{ // NOVEDAD: Implementación de Runnable y funciones Lambda!!!
            () -> g2D.drawOval(325, 150, 50, 50), // Cabeza
            () -> g2D.drawLine(350, 200, 350, 300), // Cuerpo
            () -> g2D.drawLine(350, 250, 400, 200), // Brazo izquierdo
            () -> g2D.drawLine(350, 250, 300, 200), // Brazo derecho
            () -> g2D.drawLine(350, 300, 400, 350), // Pierna izquierda
            () -> g2D.drawLine(350, 300, 300, 350) // Pierna derecha
        };

        for (int i = 0; i < cantErrores && i < partesCuerpo.length; i++) {
            partesCuerpo[i].run();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEnviarLetra = new javax.swing.JButton();
        txtLetra = new javax.swing.JTextField();

        btnEnviarLetra.setText("ENVIAR");
        btnEnviarLetra.setFocusable(false);
        btnEnviarLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarLetraActionPerformed(evt);
            }
        });

        txtLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLetraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnviarLetra, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(txtLetra))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnEnviarLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarLetraActionPerformed
        if (txtLetra.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingresa una letra primero!", "NO INGRESA LETRA", JOptionPane.ERROR_MESSAGE);
        } else if (txtLetra.getText().length() > 1) {
            JOptionPane.showMessageDialog(null, "Ingresa una sola letra!", "INGRESA MAS DE UNA LETRA", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean flag = false;
            for (int i = 0; i < palabraSeparada.length; i++) {
                if (txtLetra.getText().charAt(0) == palabraSeparada[i]) {
                    panelLetra[i].setText(String.valueOf(palabraSeparada[i]));
                    cantAciertos++;
                    flag = true;
                }
            }
            if(cantAciertos == cantLetras) {
                Utils.crearPantallaFinJuego(framePadre, 3);
            }
            if (!flag) {
                cantErrores++;
                if (cantErrores == 6) {
                    btnEnviarLetra.setEnabled(false);
                    txtLetra.setEnabled(false);
                    Utils.crearPantallaFinJuego(framePadre, 3);
                }
                repaint(); // Pinta el Panel nuevamente para que aparezca la parte del cupero nueva
            }
        }
        txtLetra.setText("");
    }//GEN-LAST:event_btnEnviarLetraActionPerformed

    private void txtLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLetraActionPerformed

    }//GEN-LAST:event_txtLetraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarLetra;
    private javax.swing.JTextField txtLetra;
    // End of variables declaration//GEN-END:variables
}
