/**
 *
 * @author Jose
 */
package br.com.projeto_2.view;

import javax.swing.JOptionPane;

public class PrincipalVIEW extends javax.swing.JFrame {

    public PrincipalVIEW() {
        initComponents();
    }

    private void sair() {
        Object[] options = {"Sair", "Cancelar"};
        if (JOptionPane.showOptionDialog(null, "Deseja sair do sistema?", "Informações", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0) {
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        editMenu = new javax.swing.JMenu();
        itemMenuFornecedor = new javax.swing.JMenuItem();
        itemMenuProduto = new javax.swing.JMenuItem();
        fileMenu = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editMenu.setMnemonic('e');
        editMenu.setText("Cadastro");

        itemMenuFornecedor.setMnemonic('d');
        itemMenuFornecedor.setText("Fornecedor");
        itemMenuFornecedor.addActionListener(this::itemMenuFornecedorActionPerformed);
        editMenu.add(itemMenuFornecedor);

        itemMenuProduto.setText("Produto");
        editMenu.add(itemMenuProduto);

        menuBar.add(editMenu);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Sair");

        menuSair.setMnemonic('x');
        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menuSair.addActionListener(this::menuSairActionPerformed);
        fileMenu.add(menuSair);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        sair();
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
       sair();
    }//GEN-LAST:event_menuSairMouseClicked

    private void itemMenuFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemMenuFornecedorActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem itemMenuFornecedor;
    private javax.swing.JMenuItem itemMenuProduto;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuSair;
    // End of variables declaration//GEN-END:variables

}
