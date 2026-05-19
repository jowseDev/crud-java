package actionfigure_ctr;

import actionfigure_dto.ActionFigureDTO;
import actionfigure_dao.ActionFigureDAO;
import actionfigure_dao.ConexaoDAO;
import java.sql.ResultSet;

public class ActionFigureCTR {

    ActionFigureDAO actionFigureDAO = new ActionFigureDAO();

    public ActionFigureCTR() {

    }

    public String inserirActionFigure(ActionFigureDTO actionFigureDTO) {
        try {

            if (actionFigureDAO.inserirActionFigure(actionFigureDTO)) {
                return "ActionFigure Cadastrado com Sucesso!!!";
            } else {
                return "ActionFigure NÃO Cadastrado!!!";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "ActionFigure NÃO Cadastrado";
        }
    }

    public ResultSet consultarActionFigure(ActionFigureDTO actionFigureDTO, int opcao) {
        ResultSet rs = null;

        rs = actionFigureDAO.consultarActionFigure(actionFigureDTO, opcao);

        return rs;
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }

    public String alterarActionFigure(ActionFigureDTO actionFigureDTO) {
        try {

            // Chama o método do DAO
            if (actionFigureDAO.alterarActionFigure(actionFigureDTO)) {
                return "Action Figure Alterada com Sucesso!!!";
            } else {
                return "Action Figure NÃO Alterada!!!";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Action Figure NÃO Alterada!!!";
        }
    }

    public String excluirActionFigure(ActionFigureDTO actionFigureDTO) {
        try {

            if (actionFigureDAO.excluirActionFigure(actionFigureDTO)) {
                return "Action Figure Excluída com Sucesso!!!";
            } else {
                return "Action Figure NÃO foi Excluída!!!";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Action Figure NÃO foi Excluída!!!";
        }
    }

}
