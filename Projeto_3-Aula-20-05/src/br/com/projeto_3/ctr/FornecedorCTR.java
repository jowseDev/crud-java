/**
 *
 * @author Jose
 */
package br.com.projeto_3.ctr;

import br.com.projeto_3.dao.ConexaoDAO;
import br.com.projeto_3.dao.FornecedorDAO;
import br.com.projeto_3.dto.FornecedorDTO;
import java.sql.ResultSet;

public class FornecedorCTR {
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    
    public FornecedorCTR(){
    }
    
        public String inserirFornecedor(FornecedorDTO fornecedorDTO){
        try{
            if(fornecedorDAO.inserirFornecedor(fornecedorDTO)){
                return "Cliente cadastrado com sucesso!";
                
            }else{ 
                return "Fornecedor NÃO cadastrado!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor NÃO cadastrado!";
        }
    }
        
        
        public String alterarFornecedor(FornecedorDTO fornecedorDTO){
        try{
            if(fornecedorDAO.alterarFornecedor(fornecedorDTO)){
                return "Fornecedor Alterado com Sucesso!!";
            }else{
                return "Fornecedor NÃO alterado2!";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor NÃO alterado3!";
        }
    }
        
        public String excluirFornecedor (FornecedorDTO fornecedorDTO){
        try{
            if(fornecedorDAO.excluirFornecedor(fornecedorDTO)){
                return "Fornecedor excluido com sucesso!";
            }else{
                return "Forncedor NÃO excluido!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor NÃO excluido!";
        }
    }
        
            public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO,int opc){
        
        ResultSet rs = null;
        
        rs = fornecedorDAO.consultarFornecedor(fornecedorDTO, opc);
        
        return rs; 
        
    }
            
             public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
