/**
 *
 * @author Jose
 */
package br.com.projeto_3.ctr;

import br.com.projeto_3.dao.ConexaoDAO;
import br.com.projeto_3.dao.ProdutoDAO;
import br.com.projeto_3.dto.FornecedorDTO;
import br.com.projeto_3.dto.ProdutoDTO;
import java.sql.ResultSet;

public class ProdutoCTR {
    ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public ProdutoCTR(){
    }
    
    public String inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try{
            if(produtoDAO.inserirProduto(produtoDTO, fornecedorDTO)){
                return "Produto cadastrado com sucesso!";
                
            }else{ 
                return "Produto NÃO cadastrado!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto NÃO cadastrado!";
        }
    }
    
     public String alterarProduto( ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try{
            if(produtoDAO.alterarProduto(produtoDTO, fornecedorDTO)){
                return "Produto Alterado com Sucesso!!";
            }else{
                return "Produto NÃO alterado2!";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Produto NÃO alterado3!";
        }
    }
        
        public String excluirProduto (ProdutoDTO produtoDTO){
        try{
            if(produtoDAO.excluirProduto(produtoDTO)){
                return "Produto excluido com Sucesso!";
            }else{
                return "Produto NÃO excluido!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto NÃO excluido!";
        }
    }
        
         public ResultSet consultarProduto(ProdutoDTO produtoDTO,int opc){
        
        ResultSet rs = null;
        
        rs = produtoDAO.consultarProduto(produtoDTO, opc);
        
        return rs; 
        
    }
            
             public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
