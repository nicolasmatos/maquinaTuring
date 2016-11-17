package maquinaturing;

import java.awt.Dimension;

public class FormTuring extends javax.swing.JFrame {

    public FormTuring() {
        initComponents();
    }

    public static void main(String[] args) {
        FormTuring f = new FormTuring();
        f.setVisible(true);
        f.setTitle("Maquina de Turing");
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        panel1 = new java.awt.Panel();
        lblAlfabeto = new javax.swing.JLabel();
        lblQtdEstados = new javax.swing.JLabel();
        lblTransicoes = new javax.swing.JLabel();
        jtxtAlfabetoMt = new javax.swing.JTextField();
        jtxtAlfabetoFt = new javax.swing.JTextField();
        lblEntrada = new javax.swing.JLabel();
        jtxtEstados = new javax.swing.JTextField();
        jtxtRegras = new javax.swing.JTextField();
        jbtExecutar = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxaResultado = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jtxtEntrada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtEstadoInicial = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 129, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        label1.setText("label1");

        jFormattedTextField1.setText("jFormattedTextField1");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        lblAlfabeto.setText("Alfabeto Máquina");

        lblQtdEstados.setText("Alfabeto Fita");

        lblTransicoes.setText("Estados");

        jtxtAlfabetoMt.setText("a,b");
        jtxtAlfabetoMt.setToolTipText("");

        jtxtAlfabetoFt.setText("a,b,x,y");
        jtxtAlfabetoFt.setToolTipText("");

        lblEntrada.setText("Regras");

        jtxtEstados.setText("q0,q1,q2,q3,q4");
        jtxtEstados.setToolTipText("");

        jtxtRegras.setText("q0/a/b/q1/R,q1/b/c/q2/R,q2/c/a/q0/H");
        jtxtRegras.setToolTipText("");

        jbtExecutar.setBackground(new java.awt.Color(245, 245, 245));
        jbtExecutar.setLabel("Verificar");
        jbtExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExecutarActionPerformed(evt);
            }
        });

        jtxaResultado.setColumns(20);
        jtxaResultado.setRows(5);
        jScrollPane1.setViewportView(jtxaResultado);

        jLabel3.setText("Entrada");

        jtxtEntrada.setText("a/a/a/a/a/a/b/b/b/b/b/b");
        jtxtEntrada.setToolTipText("");

        jLabel4.setText("Estado Inicial");
        jLabel4.setToolTipText("");

        jtxtEstadoInicial.setText("q0");
        jtxtEstadoInicial.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEntrada)
                    .addComponent(lblTransicoes)
                    .addComponent(jbtExecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtxtEntrada, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtxtRegras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtxtEstados, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblAlfabeto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtxtAlfabetoMt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblQtdEstados)
                                .addComponent(jtxtAlfabetoFt, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(jtxtEstadoInicial)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAlfabeto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtAlfabetoMt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQtdEstados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtAlfabetoFt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTransicoes)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtEstadoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtRegras, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtExecutar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jbtExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExecutarActionPerformed
        jtxaResultado.setText("");
        MaquinaTuring mt  = new MaquinaTuring(jtxtEstados.getText(), jtxtAlfabetoMt.getText(), jtxtAlfabetoFt.getText(), jtxtRegras.getText(), jtxtEntrada.getText());
        mt.setEstadoAtual(jtxtEstadoInicial.getText());
        jtxaResultado.setText(mt.verificacao());
        
    }//GEN-LAST:event_jbtExecutarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Button jbtExecutar;
    private javax.swing.JTextArea jtxaResultado;
    private javax.swing.JTextField jtxtAlfabetoFt;
    private javax.swing.JTextField jtxtAlfabetoMt;
    private javax.swing.JTextField jtxtEntrada;
    private javax.swing.JTextField jtxtEstadoInicial;
    private javax.swing.JTextField jtxtEstados;
    private javax.swing.JTextField jtxtRegras;
    private java.awt.Label label1;
    private javax.swing.JLabel lblAlfabeto;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblQtdEstados;
    private javax.swing.JLabel lblTransicoes;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
