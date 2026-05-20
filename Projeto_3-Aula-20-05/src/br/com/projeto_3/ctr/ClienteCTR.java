/**
 *
 * @author Jose
 */
package br.com.projeto_3.ctr;

import br.com.projeto_3.dto.ClienteDTO;
import br.com.projeto_3.dao.ClienteDAO;
import br.com.projeto_3.dao.ConexaoDAO;
import java.sql.ResultSet;

public class ClienteCTR {
    
    ClienteDAO clienteDAO = new ClienteDAO();
    public ClienteCTR(){
        
    }
    public String inserirCliente(ClienteDTO clienteDTO){
        try{
            if(clienteDAO.inserirCliente(clienteDTO)){
                return "Cliente cadastrado com sucesso!";
                
            }else{ 
                return "Cliente NÃO cadastrado!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Cliente NÃO cadastrado!";
        }
    }
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO,int opc){
        
        ResultSet rs = null;
        
        rs = clienteDAO.consultarCliente(clienteDTO, opc);
        
        return rs; 
        
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
    
    public String alterarCliente(ClienteDTO clienteDTO){
        try{
            if(clienteDAO.alterarCliente(clienteDTO)){
                return "Cliente Alterado com Sucesso!!";
            }else{
                return "Cliente NÃO alterado2!";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Cliente NÃO alterado3!";
        }
    }
    
    public String excluirCliente (ClienteDTO clienteDTO){
        try{
            if(clienteDAO.excluirCliente(clienteDTO)){
                return "Cliente excluido com sucesso!";
            }else{
                return "Cliente NÃO excluido!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Cliente NÃO excluido!";
        }
    }
}
