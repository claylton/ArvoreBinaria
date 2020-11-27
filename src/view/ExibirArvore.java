/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.ArvoreBinaria;

/**
 *
 * @author clayl
 */
public class ExibirArvore extends javax.swing.JFrame {

    ArvoreBinaria arvore;
    /**
     * Creates new form ExibirArvore
     */
    public ExibirArvore(ArvoreBinaria arvoreRubro) {
        initComponents();
        this.arvore = arvoreRubro;
        arvoreRubroNegraLayout.setText(arvore.imprimeArvore());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arvoreRubroNegraLayout = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();
        arvoreRubroNegraLayout1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        arvoreRubroNegraLayout.setBackground(new java.awt.Color(204, 255, 102));
        arvoreRubroNegraLayout.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        arvoreRubroNegraLayout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arvoreRubroNegraLayout.setText("<html> asdasdasdasd<br>asdasdasdasasdasdasdasasdasdasdasasdasdasdasasdasdasdasasdasdasdasasdasdasdasasdasdasdasasdasdasdasasdasdasdasasdasdasdas</html>");
        arvoreRubroNegraLayout.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Árvore Rubro-Negra");

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        arvoreRubroNegraLayout1.setBackground(new java.awt.Color(204, 255, 102));
        arvoreRubroNegraLayout1.setForeground(new java.awt.Color(153, 255, 0));
        arvoreRubroNegraLayout1.setText("<html> asdasdasdasd<br>asdasdasdas</html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(arvoreRubroNegraLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(473, 473, 473)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(544, 544, 544)
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(arvoreRubroNegraLayout1, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arvoreRubroNegraLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arvoreRubroNegraLayout1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arvoreRubroNegraLayout;
    private javax.swing.JLabel arvoreRubroNegraLayout1;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
