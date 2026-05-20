/**
 *
 * @author Jose
 */
package br.com.projeto_3.dao;
import java.sql.*;
import br.com.projeto_3.dto.FornecedorDTO;
import br.com.projeto_3.dto.ProdutoDTO;

public class ProdutoDAO {
    
   public ProdutoDAO(){
   }
   
   private ResultSet rs = null;
   private Statement stmt = null;
   
   public boolean inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
       try{
           ConexaoDAO.ConnectDB();
           stmt = ConexaoDAO.con.createStatement();
           
            String comando = "Insert into produto (nome_p, desc_p, cod_bar_p, "
                    + "pcusto_p, pvenda_p, id_f) values ( "
                    + "'" + produtoDTO.getNome_p() + "',"
                    + "'"  + produtoDTO.getDesc_p()+ "', "
                    + "'"  + produtoDTO.getCod_bar_p() + "', "
                    + produtoDTO.getPcusto_p()+ ", "
                    + produtoDTO.getPvenda_p()+ ", "
                    + fornecedorDTO.getId_f()+ ") ";
            
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
   
   
   public boolean alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
    try{
        ConexaoDAO.ConnectDB();
        stmt = ConexaoDAO.con.createStatement();
        
        String comando = "UPDATE produto SET "
                + "nome_p = '" + produtoDTO.getNome_p() + "', "
                + "desc_p = '" + produtoDTO.getDesc_p() + "', "
                + "cod_bar_p = '" + produtoDTO.getCod_bar_p()+ "', "
                + "pcusto_p = '" + produtoDTO.getPcusto_p()+ "', "
                + "pvenda_p = '" + produtoDTO.getPvenda_p()+ "', "
                + "id_f = " + fornecedorDTO.getId_f() + " "
                + "WHERE id_P = " + produtoDTO.getId_p();
        
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
   
   public boolean excluirProduto (ProdutoDTO produtoDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Delete from produto where id_p = " + produtoDTO.getId_p();
            
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
   
   public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opc){
        
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch(opc){
                case 1: comando = "Select p.* "+
                        "from produto p " +
                        "where p.nome_p ilike '" + produtoDTO.getNome_p()+ "%' " + 
                "order by p.nome_p";
                break;
                case 2: comando = "Select p.*, f.nome_f, f.id_f " + 
                        "from produto p, fornecedor f " +
                        "where p.id_f = f.id_f and " +
                        "p.id_p = " + produtoDTO.getId_p();
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
   
