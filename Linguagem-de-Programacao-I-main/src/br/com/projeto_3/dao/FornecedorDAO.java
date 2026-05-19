/**
 *
 * @author Jose
 */
package br.com.projeto_3.dao;
import java.sql.*;
import java.text.SimpleDateFormat;
import br.com.projeto_3.dto.FornecedorDTO;


public class FornecedorDAO {
    
    public FornecedorDAO(){
}
    
    SimpleDateFormat data_format = new SimpleDateFormat("dd/MM/yyyy");
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirFornecedor(FornecedorDTO fornecedorDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Insert into fornecedor (nome_f, cnpj_f, "
                    + "tel_f, data_cad_f) values ( "
                    + "'" + fornecedorDTO.getNome_f()+ "',"
                    + "'"  + fornecedorDTO.getCnpj_f()+ "', "
                    + "'" + fornecedorDTO.getTel_f()+ "', "
                    +"to_date('" + data_format.format(fornecedorDTO.getData_cad_f()) + "','dd/mm/yyyy')) ";
            
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;         
        } 
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            ConexaoDAO.CloseDB();
        }
    }
        
public boolean alterarFornecedor(FornecedorDTO fornecedorDTO){
    try{
        ConexaoDAO.ConnectDB();
        stmt = ConexaoDAO.con.createStatement();
        
        String comando = "UPDATE fornecedor SET "
                + "nome_f = '" + fornecedorDTO.getNome_f() + "', "
                + "cnpj_f = '" + fornecedorDTO.getCnpj_f() + "', "
                + "tel_f = '" + fornecedorDTO.getTel_f() + "', "
                + "data_cad_f = to_date('" + data_format.format(fornecedorDTO.getData_cad_f()) + "','DD/MM/YYYY') "
                + "WHERE id_f = " + fornecedorDTO.getId_f();
        
        System.out.println("SQL: " + comando); // ✅ mostra o SQL no console
        
        stmt.execute(comando);
        ConexaoDAO.con.commit();
        stmt.close();
        return true;
    }catch(Exception e){
        System.out.println("ERRO alterar: " + e.getMessage());
        return false;
    }finally{
        ConexaoDAO.CloseDB();
    }
}

public boolean excluirFornecedor (FornecedorDTO fornecedorDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Delete from fornecedor where id_f = " + fornecedorDTO.getId_f();
            
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opc){
        
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch(opc){
                case 1: comando = "Select f.id_f, f.nome_f "+
                        "from fornecedor f " +
                        "where f.nome_f ilike '" + fornecedorDTO.getNome_f()+ "%' " + 
                "order by f.nome_f";
                break;
                case 2: comando = "Select f.nome_f, f.cnpj_f, f.tel_f, " + 
                        "to_char(f.data_cad_f, 'dd/mm/yyyy') as data_cad_f " +
                        "from fornecedor f " +
                        "where f.id_f = " + fornecedorDTO.getId_f();
                break;
                case 3: comando = "Select f.id_f, f.nome_f " + 
                        "from fornecedor f ";
                break;
                
            
                
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs; 
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return rs;  
        }
    }
}
    

