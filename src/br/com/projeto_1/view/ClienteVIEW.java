package br.com.projeto_1.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import br.com.projeto_1.dto.ClienteDTO;
import br.com.projeto_1.ctr.ClienteCTR;

import java.awt.Dimension;

public class ClienteVIEW extends javax.swing.JInternalFrame {
    
    ClienteDTO clienteDTO = new ClienteDTO();
    ClienteCTR clienteCTR = new ClienteCTR();
    
    int gravar_alterar;
    
    public ClienteVIEW() {
        initComponents();
    }
    
    public void setPosicao(){
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    private void liberaCampos(boolean a){
        nome_cli.setEnabled(a);
        logadouro_cli.setEnabled(a);
        numero_cli.setEnabled(a);
        bairro_cli.setEnabled(a);
        cidade_cli.setEnabled(a);
        cep_cli.setEnabled(a);
        cpf_cli.setEnabled(a);
        rg_cli.setEnabled(a);
   }
   
   private void limpaCampos(){
       nome_cli.setText("");
       logadouro_cli.setText("");
       numero_cli.setText("");
       bairro_cli.setText("");
       cidade_cli.setText("");
       cep_cli.setText("");
       cpf_cli.setText("");
       rg_cli.setText("");
   }
   
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estado_cli = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        numero_cli = new javax.swing.JTextField();
        logadouro_cli = new javax.swing.JTextField();
        nome_cli = new javax.swing.JTextField();
        bairro_cli = new javax.swing.JTextField();
        cidade_cli = new javax.swing.JTextField();
        cep_cli = new javax.swing.JTextField();
        rg_cli = new javax.swing.JTextField();
        cpf_cli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        estado_cli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel1.setText("Cliente");

        numero_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numero_cliActionPerformed(evt);
            }
        });

        logadouro_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logadouro_cliActionPerformed(evt);
            }
        });

        nome_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_cliActionPerformed(evt);
            }
        });

        bairro_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairro_cliActionPerformed(evt);
            }
        });

        cidade_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidade_cliActionPerformed(evt);
            }
        });

        cep_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cep_cliActionPerformed(evt);
            }
        });

        rg_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rg_cliActionPerformed(evt);
            }
        });

        cpf_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf_cliActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        jLabel3.setText("Cidade:");

        jLabel4.setText("Logadouro:");

        jLabel5.setText("Numero:");

        jLabel6.setText("CEP:");

        jLabel7.setText("CPF:");

        jLabel8.setText("RG:");

        jLabel9.setText("Bairro:");

        jLabel10.setText("Estado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cep_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpf_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rg_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cidade_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(estado_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nome_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logadouro_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numero_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bairro_cli)))
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logadouro_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numero_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bairro_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cidade_cli, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estado_cli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rg_cli, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cep_cli, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addComponent(cpf_cli, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)))
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numero_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numero_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numero_cliActionPerformed

    private void logadouro_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logadouro_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logadouro_cliActionPerformed

    private void nome_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_cliActionPerformed

    private void bairro_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairro_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bairro_cliActionPerformed

    private void cidade_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidade_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidade_cliActionPerformed

    private void cep_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cep_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cep_cliActionPerformed

    private void rg_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rg_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rg_cliActionPerformed

    private void cpf_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpf_cliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairro_cli;
    private javax.swing.JTextField cep_cli;
    private javax.swing.JTextField cidade_cli;
    private javax.swing.JTextField cpf_cli;
    private javax.swing.JComboBox<String> estado_cli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField logadouro_cli;
    private javax.swing.JTextField nome_cli;
    private javax.swing.JTextField numero_cli;
    private javax.swing.JTextField rg_cli;
    // End of variables declaration//GEN-END:variables
}
