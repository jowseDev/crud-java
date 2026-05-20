/**
 *
 * @author Jose
 */
package br.com.projeto_3.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import br.com.projeto_3.dto.*;

public class FuncionarioDAO {

    public FuncionarioDAO() {

    }

    private ResultSet rs = null;
    private Statement stmt = null;
    // teste 2

    public boolean inserirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Insert into funcionario (nome_fun, cpf_fun, "
                    + "login_fun, senha_fun, tipo_fun) values ( "
                    + "'" + funcionarioDTO.getNome_fun().toUpperCase() + "', "
                    + "'" + funcionarioDTO.getCpf_fun() + "', "
                    + "'" + funcionarioDTO.getLogin_fun() + "', "
                    + "crypt('" + funcionarioDTO.getSenha_fun() + "',gen_salt('bf', 8)) , "
                    + "'" + funcionarioDTO.getTipo_fun().toUpperCase() + "') ";

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

    public boolean alterarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();

            String comando = "";
            comando = "Update funcionario set "
                    + "nome_fun = '" + funcionarioDTO.getNome_fun().toUpperCase() + "', "
                    + "cpf_fun = '" + funcionarioDTO.getCpf_fun() + "', "
                    + "login_fun = '" + funcionarioDTO.getLogin_fun() + "', ";

            if (funcionarioDTO.getSenha_fun() != null) {
                comando += "senha_fun = crypt('" + funcionarioDTO.getSenha_fun() + "',gen_salt('bf', 8)), ";
            }

            comando += "tipo_fun = '" + funcionarioDTO.getTipo_fun().toUpperCase() + "' "
                    + "where id_fun = " + funcionarioDTO.getId_fun();

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
