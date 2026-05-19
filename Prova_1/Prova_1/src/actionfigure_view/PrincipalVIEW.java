package actionfigure_view;


import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class PrincipalVIEW extends javax.swing.JFrame {

    public PrincipalVIEW() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void sair() {
        Object[] options = {"Sair", "Cancelar"};
        if (JOptionPane.showOptionDialog(null, "Deseja sair do sistema?", "Informações", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0) {
            System.exit(0);
        }
    }

    private void abreActionFigureVIEW() {
        ActionFigureVIEW actionFigureVIEW = new ActionFigureVIEW();
        this.desktopPane.add(actionFigureVIEW);
        actionFigureVIEW.setVisible(true);

    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        menuCadastrar = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        deleteMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Cadastro");

        menuCadastrar.setMnemonic('x');
        menuCadastrar.setText("CadastrarActionFigure");
        menuCadastrar.addActionListener(this::menuCadastrarActionPerformed);
        fileMenu.add(menuCadastrar);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Sair");

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Sair");
        deleteMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMenuItemMouseClicked(evt);
            }
        });
        deleteMenuItem.addActionListener(this::deleteMenuItemActionPerformed);
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1452, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
      sair();
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void deleteMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMenuItemMouseClicked
      
    }//GEN-LAST:event_deleteMenuItemMouseClicked

    private void menuCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarActionPerformed
        abreActionFigureVIEW();
    }//GEN-LAST:event_menuCadastrarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuCadastrar;
    // End of variables declaration//GEN-END:variables

}
