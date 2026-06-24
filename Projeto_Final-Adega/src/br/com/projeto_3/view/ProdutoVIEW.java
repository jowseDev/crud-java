/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.projeto_3.view;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import br.com.projeto_3.ctr.FornecedorCTR;
import br.com.projeto_3.ctr.ProdutoCTR;
import br.com.projeto_3.dto.FornecedorDTO;
import br.com.projeto_3.dto.ProdutoDTO;
import java.text.DecimalFormat;


/**
 *
 * @author Conta
 */
public class ProdutoVIEW extends javax.swing.JInternalFrame {

    FornecedorDTO fornecedorDTO = new FornecedorDTO();
        FornecedorCTR fornecedorCTR = new FornecedorCTR();
        ProdutoCTR produtoCTR = new ProdutoCTR();
        ProdutoDTO produtoDTO = new ProdutoDTO();
        
        int gravar_alterar;
        
        ResultSet rs;
        DefaultTableModel modelo_jtl_consultar_fornecedor;
        DefaultTableModel modelo_jtl_consultar_produto;
        
        public void setPosicao(){
            Dimension d = this.getDesktopPane().getSize();
            this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);

        }
        
        private void gravar(){
        try{
            produtoDTO.setNome_p(nome_p.getText());
            produtoDTO.setDesc_p(desc_p.getText());
            produtoDTO.setCod_bar_p(cod_bar_p.getText());
            produtoDTO.setPcusto_p(Double.parseDouble(pcusto_p.getText().replace(",", ".")));
            produtoDTO.setPvenda_p(Double.parseDouble(pvenda_p.getText().replace(",", ".")));
            fornecedorDTO.setId_f(Integer.parseInt(String.valueOf(jtl_consultar_fornecedor.getValueAt(jtl_consultar_fornecedor.getSelectedRow(), 0))));

            JOptionPane.showMessageDialog(null, produtoCTR.inserirProduto(produtoDTO, fornecedorDTO));
            
            
        }catch(Exception e){
            System.out.println("Erro ao gravar!1" + e.getMessage());
        }
    }
        
        
        private void alterar(){
        try{
            
            produtoDTO.setNome_p(nome_p.getText());
            produtoDTO.setDesc_p(desc_p.getText());
            produtoDTO.setCod_bar_p(cod_bar_p.getText());
            produtoDTO.setPcusto_p(Double.parseDouble(pcusto_p.getText().replace(",", ".")));
            produtoDTO.setPvenda_p(Double.parseDouble(pvenda_p.getText().replace(",", ".")));
            fornecedorDTO.setId_f(Integer.parseInt(String.valueOf(jtl_consultar_fornecedor.getValueAt(jtl_consultar_fornecedor.getSelectedRow(), 0))));

            
            JOptionPane.showMessageDialog(null, produtoCTR.alterarProduto(produtoDTO, fornecedorDTO));
            
        }catch(Exception e){
            System.out.println("ERRO ao alterar1" + e.getMessage());
        }}
        
        private void excluir(){          
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Produto?", "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
JOptionPane.showMessageDialog(null, produtoCTR.excluirProduto(produtoDTO));
    }
    }       
        private void liberaCampos(boolean a){
        nome_p.setEnabled(a);
        desc_p.setEnabled(a);
        cod_bar_p.setEnabled(a);
        pcusto_p.setEnabled(a);
        pvenda_p.setEnabled(a);
        pcusto_p.setEnabled(a);
        pesquisa_nome_fornecedor.setEnabled(a);
                btnPesquisarFornecedor.setEnabled(a);
                        jtl_consultar_fornecedor.setEnabled(a);



    }
        private void liberaBotoes(boolean a,  boolean b, boolean c, boolean d, boolean e){
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }
      
      private void limpaCampos(){
       
        
        nome_p.setText("");
        desc_p.setText("");
        cod_bar_p.setText("");
        pcusto_p.setText("");
        pvenda_p.setText("");
        pesquisa_nome_fornecedor.setText("");
        modelo_jtl_consultar_fornecedor.setNumRows(0);
    }
      
      private void preencheTabela(String nome_p){
        try{
            modelo_jtl_consultar_produto.setNumRows(0);
            produtoDTO.setNome_p(nome_p);
            rs = produtoCTR.consultarProduto(produtoDTO, 1);
            while(rs.next()){
                modelo_jtl_consultar_produto.addRow(new Object[]{
                rs.getString("id_p"),
                rs.getString("nome_p"),
            });
            }
        }
        catch(Exception erTab){
            System.out.println("ERRO preencheTabelaProduto " +erTab);
        }
        finally{
            fornecedorCTR.CloseDB();
        }
    }
      private void preencheTabelaF(String nome_f){
        try{
            modelo_jtl_consultar_fornecedor.setNumRows(0);
            fornecedorDTO.setNome_f(nome_f);
            rs = fornecedorCTR.consultarFornecedor(fornecedorDTO, 1);
            while(rs.next()){
                modelo_jtl_consultar_fornecedor.addRow(new Object[]{
                rs.getString("id_f"),
                rs.getString("nome_f"),
            });
            }
        }
        catch(Exception erTab){
            System.out.println("ERRO SQL: " +erTab);
        }
        finally{
            fornecedorCTR.CloseDB();
        }
    }
      
      private void preencheCampos(int id_p){
        try{
            produtoDTO.setId_p(id_p);
            rs = produtoCTR.consultarProduto(produtoDTO, 2);
            if(rs.next()){
                limpaCampos();
                nome_p.setText(rs.getString("nome_p"));
                desc_p.setText(rs.getString("desc_p"));
                cod_bar_p.setText(rs.getString("cod_bar_p"));
                DecimalFormat df = new DecimalFormat("#,##0.00");
                pcusto_p.setText(df.format(rs.getDouble("pcusto_p")));
                pvenda_p.setText(df.format(rs.getDouble("pvenda_p")));
                

                modelo_jtl_consultar_fornecedor.setNumRows(0);
                modelo_jtl_consultar_fornecedor.addRow(new Object[]{rs.getInt("id_f"), rs.getString("nome_f"), });
                jtl_consultar_fornecedor.setRowSelectionInterval(0, 0);
                
                gravar_alterar=2;
                liberaCampos(true);
                
            }
        }
        catch(Exception erTab){
            System.out.println("ERRO SQL: "+erTab); 
        }
        finally{
            fornecedorCTR.CloseDB();
        }
    }
    

    
    /**
     * Creates new form ProdutoVIEW
     */
    public ProdutoVIEW() {
        initComponents();
        
        initComponents();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_fornecedor = (DefaultTableModel) jtl_consultar_fornecedor.getModel();
                modelo_jtl_consultar_produto = (DefaultTableModel) jtl_consultar_produto.getModel();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nome_p = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        desc_p = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cod_bar_p = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pcusto_p = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pvenda_p = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pesquisa_nome_fornecedor = new javax.swing.JTextField();
        btnPesquisarFornecedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_fornecedor = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pesquisa_nome_produto = new javax.swing.JTextField();
        btnPesquisarProduto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtl_consultar_produto = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("PRODUTO");

        nome_p.setNextFocusableComponent(desc_p);

        jLabel2.setText("Nome:");

        desc_p.setNextFocusableComponent(cod_bar_p);

        jLabel3.setText("Descrição:");

        cod_bar_p.setNextFocusableComponent(pcusto_p);

        jLabel4.setText("Código:");

        pcusto_p.setNextFocusableComponent(pvenda_p);

        jLabel5.setText("Preço de Custo:");

        pvenda_p.setNextFocusableComponent(pesquisa_nome_fornecedor);

        jLabel6.setText("Preço de Venda:");

        jLabel7.setText("Fornecedor:");

        pesquisa_nome_fornecedor.setNextFocusableComponent(btnPesquisarFornecedor);
        pesquisa_nome_fornecedor.addActionListener(this::pesquisa_nome_fornecedorActionPerformed);

        btnPesquisarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_3/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisarFornecedor.setNextFocusableComponent(pesquisa_nome_produto);
        btnPesquisarFornecedor.addActionListener(this::btnPesquisarFornecedorActionPerformed);

        jtl_consultar_fornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ));
        jtl_consultar_fornecedor.setNextFocusableComponent(pesquisa_nome_produto);
        jScrollPane1.setViewportView(jtl_consultar_fornecedor);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("CONSULTA");

        jLabel9.setText("Nome:");

        pesquisa_nome_produto.setNextFocusableComponent(btnPesquisarProduto);

        btnPesquisarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_3/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisarProduto.setNextFocusableComponent(btnNovo);
        btnPesquisarProduto.addActionListener(this::btnPesquisarProdutoActionPerformed);

        jtl_consultar_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ));
        jtl_consultar_produto.setNextFocusableComponent(btnNovo);
        jtl_consultar_produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_produtoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtl_consultar_produto);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_3/view/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setNextFocusableComponent(btnCancelar);
        btnNovo.addActionListener(this::btnNovoActionPerformed);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_3/view/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setNextFocusableComponent(btnExcluir);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_3/view/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setNextFocusableComponent(btnSalvar);
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_3/view/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setNextFocusableComponent(btnSair);
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_3/view/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(this::btnSairActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cod_bar_p, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(desc_p, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nome_p, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pcusto_p, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pvenda_p, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesquisa_nome_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnPesquisarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesquisa_nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSair)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar)))
                .addContainerGap(448, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(desc_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cod_bar_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pcusto_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(pvenda_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPesquisarFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pesquisa_nome_fornecedor)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel8)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(pesquisa_nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisa_nome_fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisa_nome_fornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisa_nome_fornecedorActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
liberaCampos(true);
liberaBotoes(false, true, true, true, false);
gravar_alterar=1;        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
if (gravar_alterar==1){
    gravar();
gravar_alterar=0;
}else{
    if(gravar_alterar == 2){
        alterar();
        gravar_alterar=0;
    }
    else{
        JOptionPane.showMessageDialog(null, "Erro no sistema!!");
    }
}
limpaCampos();
liberaCampos(false);
liberaBotoes(true, false, false, false, true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarFornecedorActionPerformed
preencheTabelaF(pesquisa_nome_fornecedor.getText());     // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarFornecedorActionPerformed

    private void btnPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdutoActionPerformed
preencheTabela(pesquisa_nome_produto.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarProdutoActionPerformed

    private void jtl_consultar_produtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_produtoMouseClicked
preencheCampos(Integer.parseInt(String.valueOf(jtl_consultar_produto.getValueAt(jtl_consultar_produto
        .getSelectedRow(), 0))));
liberaBotoes(false, true, true, true, true);        // TODO add your handling code here:
    }//GEN-LAST:event_jtl_consultar_produtoMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
excluir();
limpaCampos();
liberaCampos(false);
liberaBotoes(true, false, false, false, true);
modelo_jtl_consultar_fornecedor.setNumRows(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
limpaCampos();
liberaCampos(false);
modelo_jtl_consultar_fornecedor.setNumRows(0);
liberaBotoes(true, false, false, false, true);
gravar_alterar=0;        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisarFornecedor;
    private javax.swing.JButton btnPesquisarProduto;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField cod_bar_p;
    private javax.swing.JTextField desc_p;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtl_consultar_fornecedor;
    private javax.swing.JTable jtl_consultar_produto;
    private javax.swing.JTextField nome_p;
    private javax.swing.JTextField pcusto_p;
    private javax.swing.JTextField pesquisa_nome_fornecedor;
    private javax.swing.JTextField pesquisa_nome_produto;
    private javax.swing.JTextField pvenda_p;
    // End of variables declaration//GEN-END:variables
}
