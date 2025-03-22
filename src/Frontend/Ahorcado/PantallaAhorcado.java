/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend.Ahorcado;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PantallaAhorcado extends javax.swing.JFrame {

    JPanel panelDibujo;

    public PantallaAhorcado(String palabra) {
        initComponents(); // Aquí se establece el layout auto-generado
        panelDibujo = new DibujoAhorcado(this.getHeight() - 50, this.getWidth() - 50, palabra, this);
        this.setResizable(false);
        this.getContentPane().setLayout(new BorderLayout()); // se pone un layout nuevo para poder agregar el componente  JPanel
        this.getContentPane().add(panelDibujo, BorderLayout.CENTER); // Hacemos que el JPanel ocupe todo el JFrame
        pack();
        this.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
