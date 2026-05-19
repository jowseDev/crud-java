package actionfigure_view;

import actionfigure_dto.ActionFigureDTO;
import actionfigure_ctr.ActionFigureCTR;
import actionfigure_dao.ConexaoDAO;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class ActionFigureVIEW extends javax.swing.JInternalFrame {

    public ActionFigureVIEW() {
        initComponents();

        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_actionfigure = (DefaultTableModel) jtl_consultar_actionfigure.getModel();
    }

    ActionFigureDTO actionFigureDTO = new ActionFigureDTO();
    ActionFigureCTR actionFigureCTR = new ActionFigureCTR();

    int gravar_alterar;

    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_actionfigure;

    private void liberaCampos(boolean a) {

        nome_acfg.setEnabled(a);
        personagem_acfg.setEnabled(a);
        cor_acfg.setEnabled(a);
        conservacao_acfg.setEnabled(a);
        edicaoColecionador_acfg.setEnabled(a);
        raridade_acfg.setEnabled(a);
        tamanho_acfg.setEnabled(a);
        pais_acfg.setEnabled(a);
        preco_acfg.setEnabled(a);
        numero_acfg.setEnabled(a);

    }

    private void limpaCampos() {

        nome_acfg.setText("");
        personagem_acfg.setText("");
        cor_acfg.setText("");
        conservacao_acfg.setText("");
        edicaoColecionador_acfg.setText("");
        raridade_acfg.setText("");
        tamanho_acfg.setText("");
        preco_acfg.setText("");
        numero_acfg.setText("");
    }

    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);

    }

    private void gravar() {
        try {
            actionFigureDTO.setNome_acfg(nome_acfg1.getText());
            actionFigureDTO.setPersonagem_acfg(personagem_acfg.getText());
            actionFigureDTO.setCor_acfg(cor_acfg.getText());
            actionFigureDTO.setConservacao_acfg(conservacao_acfg.getText());
            actionFigureDTO.setEdicaoColecionador_acfg(edicaoColecionador_acfg.getText());
            actionFigureDTO.setRaridade_acfg(raridade_acfg.getText());
            actionFigureDTO.setTamanho_acfg(tamanho_acfg.getText());
            actionFigureDTO.setPais_acfg(pais_acfg.getSelectedItem().toString());
            actionFigureDTO.setPreco_acfg(Integer.parseInt(preco_acfg.getText()));
            actionFigureDTO.setNumero_acfg(Integer.parseInt(numero_acfg.getText()));

            JOptionPane.showMessageDialog(null,
                    actionFigureCTR.inserirActionFigure(actionFigureDTO)
            );

        } catch (Exception e) {
            System.out.println("Erro ao Gravar " + e.getMessage());
        }
    }

    private void preencheTabela(String nome_acfg) {
        try {
            modelo_jtl_consultar_actionfigure.setNumRows(0);

            actionFigureDTO.setNome_acfg(nome_acfg);
            rs = actionFigureCTR.consultarActionFigure(actionFigureDTO, 1);
            while (rs.next()) {
                modelo_jtl_consultar_actionfigure.addRow(new Object[]{
                    rs.getString("id_acfg"),
                    rs.getString("nome_acfg"),});
            }
        } catch (Exception e) {
            System.out.println("Erro SQL: " + e);
        } finally {
            actionFigureCTR.CloseDB();
        }
    }

    private void preencheCampos(int id_acfg) {
        try {
            actionFigureDTO.setId_acfg(id_acfg);
            rs = actionFigureCTR.consultarActionFigure(actionFigureDTO, 2); // 2 = é a pesquisa no id classe DAO
            if (rs.next()) {
                limpaCampos();
                nome_acfg1.setText(rs.getString("nome_acfg"));
                personagem_acfg.setText(rs.getString("personagem_acfg"));
                cor_acfg.setText(rs.getString("cor_acfg"));
                conservacao_acfg.setText(rs.getString("conservacao_acfg"));
                edicaoColecionador_acfg.setText(rs.getString("edicao_colecionador_acfg"));
                raridade_acfg.setText(rs.getString("raridade_acfg"));
                tamanho_acfg.setText(rs.getString("tamanho_acfg"));
                pais_acfg.setSelectedItem(rs.getString("pais_acfg"));
                preco_acfg.setText(rs.getString("preco_acfg"));
                numero_acfg.setText(rs.getString("numero_acfg"));

                gravar_alterar = 2;
                liberaCampos(true);
            }
        } catch (Exception e) {
            System.out.println("Erro SQL: " + e);
        } finally {
            actionFigureCTR.CloseDB();
        }
    }

    private void alterar() {
        try {
            actionFigureDTO.setNome_acfg(nome_acfg1.getText());
            actionFigureDTO.setPersonagem_acfg(personagem_acfg.getText());
            actionFigureDTO.setCor_acfg(cor_acfg.getText());
            actionFigureDTO.setConservacao_acfg(conservacao_acfg.getText());
            actionFigureDTO.setEdicaoColecionador_acfg(edicaoColecionador_acfg.getText());
            actionFigureDTO.setRaridade_acfg(raridade_acfg.getText());
            actionFigureDTO.setTamanho_acfg(tamanho_acfg.getText());
            actionFigureDTO.setPais_acfg(pais_acfg.getSelectedItem().toString());
            actionFigureDTO.setPreco_acfg(Integer.parseInt(preco_acfg.getText()));
            actionFigureDTO.setNumero_acfg(Integer.parseInt(numero_acfg.getText()));

            JOptionPane.showMessageDialog(null,
                    actionFigureCTR.alterarActionFigure(actionFigureDTO)
            );

        } catch (Exception e) {
            System.out.println("Erro ao Alterar: " + e.getMessage());
        }
    }
    
    private void excluir() {
    if (JOptionPane.showConfirmDialog(null, 
            "Deseja realmente excluir a Action Figure?", 
            "Aviso",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

        JOptionPane.showMessageDialog(null,
                actionFigureCTR.excluirActionFigure(actionFigureDTO)
        );
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        nome_acfg = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nome_acfg1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numero_acfg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        personagem_acfg = new javax.swing.JTextField();
        cor_acfg = new javax.swing.JTextField();
        preco_acfg = new javax.swing.JTextField();
        edicaoColecionador_acfg = new javax.swing.JTextField();
        conservacao_acfg = new javax.swing.JTextField();
        tamanho_acfg = new javax.swing.JTextField();
        raridade_acfg = new javax.swing.JTextField();
        pais_acfg = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_actionfigure = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        pesquisa_nome_acfg = new javax.swing.JTextField();

        jLabel14.setText("ActionFigure");

        nome_acfg.addActionListener(this::nome_acfgActionPerformed);

        jLabel1.setText(" Nome do ACG:");

        jLabel15.setText("ActionFigure");

        nome_acfg1.addActionListener(this::nome_acfg1ActionPerformed);

        jLabel2.setText(" Nome do ACG:");

        numero_acfg.addActionListener(this::numero_acfgActionPerformed);

        jLabel4.setText("Edição de colecionador?:");

        jLabel6.setText("Cor:");

        jLabel7.setText("Pais de origem:");

        jLabel8.setText("Raridade:");

        jLabel9.setText("Numero identificador:");

        jLabel10.setText("Estado de Conservação:");

        jLabel11.setText("Tamanho:");

        jLabel12.setText("Personagem ACG:");

        personagem_acfg.addActionListener(this::personagem_acfgActionPerformed);

        cor_acfg.addActionListener(this::cor_acfgActionPerformed);

        preco_acfg.addActionListener(this::preco_acfgActionPerformed);

        edicaoColecionador_acfg.addActionListener(this::edicaoColecionador_acfgActionPerformed);

        conservacao_acfg.addActionListener(this::conservacao_acfgActionPerformed);

        tamanho_acfg.addActionListener(this::tamanho_acfgActionPerformed);

        raridade_acfg.addActionListener(this::raridade_acfgActionPerformed);

        pais_acfg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afeganistão", "Albânia", "Argélia", "Andorra", "Angola", "Argentina", "Armênia", "Austrália", "Áustria", "Azerbaijão", "Bahamas", "Bahrein", "Bangladesh", "Barbados", "Belarus", "Bélgica", "Belize", "Benin", "Butão", "Bolívia", "Bósnia e Herzegovina", "Botsuana", "Brasil", "Brunei", "Bulgária", "Burkina Faso", "Burundi", "Cabo Verde", "Camboja", "Camarões", "Canadá", "República Centro-Africana", "Chade", "Chile", "China", "Colômbia", "Comores", "Congo", "República Democrática do Congo", "Costa Rica", "Croácia", "Cuba", "Chipre", "República Tcheca", "Dinamarca", "Djibuti", "Dominica", "República Dominicana", "Equador", "Egito", "El Salvador", "Guiné Equatorial", "Eritreia", "Estônia", "Essuatíni", "Etiópia", "Fiji", "Finlândia", "França", "Gabão", "Gâmbia", "Geórgia", "Alemanha", "Gana", "Grécia", "Granada", "Guatemala", "Guiné", "Guiné-Bissau", "Guiana", "Haiti", "Honduras", "Hungria", "Islândia", "Índia", "Indonésia", "Irã", "Iraque", "Irlanda", "Israel", "Itália", "Jamaica", "Japão", "Jordânia", "Cazaquistão", "Quênia", "Kiribati", "Coreia do Norte", "Coreia do Sul", "Kuwait", "Quirguistão", "Laos", "Letônia", "Líbano", "Lesoto", "Libéria", "Líbia", "Liechtenstein", "Lituânia", "Luxemburgo", "Madagascar", "Malaui", "Malásia", "Maldivas", "Mali", "Malta", "Ilhas Marshall", "Mauritânia", "Maurício", "México", "Micronésia", "Moldávia", "Mônaco", "Mongólia", "Montenegro", "Marrocos", "Moçambique", "Mianmar", "Namíbia", "Nauru", "Nepal", "Países Baixos", "Nova Zelândia", "Nicarágua", "Níger", "Nigéria", "Noruega", "Omã", "Paquistão", "Palau", "Panamá", "Papua-Nova Guiné", "Paraguai", "Peru", "Filipinas", "Polônia", "Portugal", "Catar", "Romênia", "Rússia", "Ruanda", "São Cristóvão e Nevis", "Santa Lúcia", "São Vicente e Granadinas", "Samoa", "San Marino", "São Tomé e Príncipe", "Arábia Saudita", "Senegal", "Sérvia", "Seychelles", "Serra Leoa", "Singapura", "Eslováquia", "Eslovênia", "Ilhas Salomão", "Somália", "África do Sul", "Sudão do Sul", "Espanha", "Sri Lanka", "Sudão", "Suriname", "Suécia", "Suíça", "Síria", "Taiwan", "Tadjiquistão", "Tanzânia", "Tailândia", "Timor-Leste", "Togo", "Tonga", "Trinidad e Tobago", "Tunísia", "Turquia", "Turcomenistão", "Tuvalu", "Uganda", "Ucrânia", "Emirados Árabes Unidos", "Reino Unido", "Estados Unidos", "Uruguai", "Uzbequistão", "Vanuatu", "Vaticano", "Venezuela", "Vietnã", "Iêmen", "Zâmbia", "Zimbábue" }));
        pais_acfg.addActionListener(this::pais_acfgActionPerformed);

        jLabel3.setText("Preço:");

        jLabel16.setText("Consulta");

        jtl_consultar_actionfigure.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nome"
            }
        ));
        jtl_consultar_actionfigure.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_actionfigureMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtl_consultar_actionfigure);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(this::btnConsultarActionPerformed);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        btnSair.setText("Sair");
        btnSair.addActionListener(this::btnSairActionPerformed);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(this::btnNovoActionPerformed);

        jLabel17.setText("Nome:");

        pesquisa_nome_acfg.addActionListener(this::pesquisa_nome_acfgActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nome_acfg1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(personagem_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(162, 162, 162)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(conservacao_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(preco_acfg)
                                    .addComponent(edicaoColecionador_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tamanho_acfg)
                            .addComponent(raridade_acfg)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pais_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cor_acfg)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(numero_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(281, 281, 281))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pesquisa_nome_acfg))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(117, 117, 117))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome_acfg1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personagem_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cor_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(preco_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tamanho_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(edicaoColecionador_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(raridade_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(conservacao_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pais_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numero_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(94, 94, 94))
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisa_nome_acfg, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(205, 205, 205))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nome_acfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_acfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_acfgActionPerformed

    private void nome_acfg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_acfg1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_acfg1ActionPerformed

    private void numero_acfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numero_acfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numero_acfgActionPerformed

    private void personagem_acfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personagem_acfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personagem_acfgActionPerformed

    private void cor_acfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cor_acfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cor_acfgActionPerformed

    private void preco_acfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preco_acfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preco_acfgActionPerformed

    private void edicaoColecionador_acfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edicaoColecionador_acfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edicaoColecionador_acfgActionPerformed

    private void conservacao_acfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conservacao_acfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conservacao_acfgActionPerformed

    private void tamanho_acfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamanho_acfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamanho_acfgActionPerformed

    private void raridade_acfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raridade_acfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_raridade_acfgActionPerformed

    private void pais_acfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pais_acfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pais_acfgActionPerformed

    private void jtl_consultar_actionfigureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_actionfigureMouseClicked
        preencheCampos(Integer.parseInt(String.valueOf(
                jtl_consultar_actionfigure.getValueAt(jtl_consultar_actionfigure.getSelectedRow(), 0))));
        liberaBotoes(false, true, true, true, true);
    }//GEN-LAST:event_jtl_consultar_actionfigureMouseClicked

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        preencheTabela(pesquisa_nome_acfg.getText());
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (gravar_alterar == 1) {
            gravar();
            gravar_alterar = 0;
        } else {
            if (gravar_alterar == 2) {
                alterar();
                gravar_alterar = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Erro no sistema!!");
            }
        }
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_actionfigure.setNumRows(0);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, false, true);
        gravar_alterar = 1;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void pesquisa_nome_acfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisa_nome_acfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisa_nome_acfgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField conservacao_acfg;
    private javax.swing.JTextField cor_acfg;
    private javax.swing.JTextField edicaoColecionador_acfg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtl_consultar_actionfigure;
    private javax.swing.JTextField nome_acfg;
    private javax.swing.JTextField nome_acfg1;
    private javax.swing.JTextField numero_acfg;
    private javax.swing.JComboBox<String> pais_acfg;
    private javax.swing.JTextField personagem_acfg;
    private javax.swing.JTextField pesquisa_nome_acfg;
    private javax.swing.JTextField preco_acfg;
    private javax.swing.JTextField raridade_acfg;
    private javax.swing.JTextField tamanho_acfg;
    // End of variables declaration//GEN-END:variables
}
