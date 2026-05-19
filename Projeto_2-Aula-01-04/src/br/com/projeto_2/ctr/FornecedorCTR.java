/**
 *
 * @author Jose
 */
package br.com.projeto_2.ctr;

import br.com.projeto_2.dao.ConexaoDAO;
import br.com.projeto_2.dao.FornecedorDAO;
import br.com.projeto_2.dto.FornecedorDTO;

import java.sql.ResultSet;

public class FornecedorCTR {

    FornecedorDAO fornecedorDAO = new FornecedorDAO();

    public FornecedorCTR() {

    }

    public String excluirFornecedor(FornecedorDTO fornecedorDTO) {
        try {

            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (fornecedorDAO.alterarFornecedor(fornecedorDTO)) {
                return "Fornecedor Excluido com Sucesso!!!";
            } else {
                return "Fornecedor NÃO foi Excluido!!!";
            }

        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO foi Excluido!!!";
        }
    } //Fecha o método alterarCliente

    public String inserirFornecedor(FornecedorDTO fornecedorDTO) {
        try {

            if (fornecedorDAO.inserirFornecedor(fornecedorDTO)) {
                return "Fornecedor Cadastrado com Sucesso!!!";
            } else {
                return "Fornecedor NÃO Cadastrado!!!";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Cadastrado";
        }
    }

    public String alterarFornecedor(FornecedorDTO fornecedorDTO) {
        try {

            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (fornecedorDAO.alterarFornecedor(fornecedorDTO)) {
                return "Fornecedor Alterado com Sucesso!!!";
            } else {
                return "Fornecedor NÃO Alterado!!!";
            }

        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Alterado!!!";
        }
    } //Fecha o método alterarCliente

    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao) {

        ResultSet rs = null;

        rs = fornecedorDAO.consultarFornecedor(fornecedorDTO, opcao);

        return rs;
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
