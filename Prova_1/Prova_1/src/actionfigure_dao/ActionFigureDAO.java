package actionfigure_dao;

import java.sql.*;
import actionfigure_dto.ActionFigureDTO;

public class ActionFigureDAO {

    public ActionFigureDAO() {

    }

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirActionFigure(ActionFigureDTO actionFigureDTO) {
        try {

            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Insert into action_figure (nome_acfg, personagem_acfg, cor_acfg, conservacao_acfg, "
                    + "edicao_colecionador_acfg, raridade_acfg, tamanho_acfg, pais_acfg, preco_acfg, numero_acfg) values ( "
                    + "'" + actionFigureDTO.getNome_acfg() + "', "
                    + "'" + actionFigureDTO.getPersonagem_acfg() + "', "
                    + "'" + actionFigureDTO.getCor_acfg() + "', "
                    + "'" + actionFigureDTO.getConservacao_acfg() + "', "
                    + "'" + actionFigureDTO.getEdicaoColecionador_acfg() + "', "
                    + "'" + actionFigureDTO.getRaridade_acfg() + "', "
                    + "'" + actionFigureDTO.getTamanho_acfg() + "', "
                    + "'" + actionFigureDTO.getPais_acfg() + "', "
                    + actionFigureDTO.getPreco_acfg() + ", "
                    + actionFigureDTO.getNumero_acfg() + ")";

            stmt.execute(comando.toUpperCase());

            ConexaoDAO.con.commit();

            stmt.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;

        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public ResultSet consultarActionFigure(ActionFigureDTO actionFigureDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "Select a.* "
                            + "from action_figure a "
                            + "where nome_acfg like '" + actionFigureDTO.getNome_acfg() + "%' "
                            + "order by a.nome_acfg";
                    break;

                case 2:
                    comando = "Select a.* "
                            + "from action_figure a "
                            + "where a.id_acfg = " + actionFigureDTO.getId_acfg();
                    break;

                case 3:
                    comando = "Select a.id_acfg, a.nome_acfg "
                            + "from action_figure a";
                    break;
            }

            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }

    }

    public boolean alterarActionFigure(ActionFigureDTO actionFigureDTO) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Update action_figure set "
                    + "nome_acfg = '" + actionFigureDTO.getNome_acfg() + "', "
                    + "personagem_acfg = '" + actionFigureDTO.getPersonagem_acfg() + "', "
                    + "cor_acfg = '" + actionFigureDTO.getCor_acfg() + "', "
                    + "conservacao_acfg = '" + actionFigureDTO.getConservacao_acfg() + "', "
                    + "edicao_colecionador_acfg = '" + actionFigureDTO.getEdicaoColecionador_acfg() + "', "
                    + "raridade_acfg = '" + actionFigureDTO.getRaridade_acfg() + "', "
                    + "tamanho_acfg = '" + actionFigureDTO.getTamanho_acfg() + "', "
                    + "pais_acfg = '" + actionFigureDTO.getPais_acfg() + "', "
                    + "preco_acfg = " + actionFigureDTO.getPreco_acfg() + ", "
                    + "numero_acfg = " + actionFigureDTO.getNumero_acfg() + " "
                    + "where id_acfg = " + actionFigureDTO.getId_acfg();

            // Executa o comando SQL
            stmt.execute(comando.toUpperCase());

            // Commit
            ConexaoDAO.con.commit();

            stmt.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public boolean excluirActionFigure(ActionFigureDTO actionFigureDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();

            String comando = "Delete from action_figure where id_acfg = "
                    + actionFigureDTO.getId_acfg();

            stmt.execute(comando);

            ConexaoDAO.con.commit();

            stmt.close();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

}
