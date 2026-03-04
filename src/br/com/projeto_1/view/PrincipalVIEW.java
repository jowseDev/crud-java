
package br.com.projeto_1.view;

import javax.swing.JOptionPane;

public class PrincipalVIEW extends javax.swing.JFrame {

    public PrincipalVIEW() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuCliente = new javax.swing.JMenu();
        itemMenuCliente = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuCliente.setMnemonic('e');
        menuCliente.setText("Cadastro");

        itemMenuCliente.setMnemonic('d');
        itemMenuCliente.setText("Cliente");
        itemMenuCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemMenuClienteMouseClicked(evt);
            }
        });
        itemMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuClienteActionPerformed(evt);
            }
        });
        menuCliente.add(itemMenuCliente);

        menuBar.add(menuCliente);

        menuSair.setMnemonic('f');
        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        menuSair.add(exitMenuItem);

        menuBar.add(menuSair);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1089, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abreClienteVIEW(){
      ClienteVIEW clienteVIEW = new ClienteVIEW();
      this.desktopPane.add(clienteVIEW);
      clienteVIEW.setVisible(true);
      clienteVIEW.setPosicao();
    }
    
    private void sair(){
        Object[] options = {"Sair", "Cancelar"};
        if(JOptionPane.showOptionDialog(null, "Deseja sair do sistema?", "Informações", JOptionPane.DEFAULT_OPTION ,JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0 ){
        System.exit(0);
        }
    }
    
    
    
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        sair();
    }//GEN-LAST:event_exitMenuItemActionPerformed
    
    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSairMouseClicked

    private void itemMenuClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemMenuClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_itemMenuClienteMouseClicked

    private void itemMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuClienteActionPerformed
        abreClienteVIEW();
    }//GEN-LAST:event_itemMenuClienteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem itemMenuCliente;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables

}
