/**
 *
 * @author Jose
 */
package br.com.projeto_3.dao;

import br.com.projeto_3.dto.ClienteDTO;
import br.com.projeto_3.dto.VendaDTO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JTable;

public class VendaDAO {
    public VendaDAO(){
    }
    
   SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    
    private ResultSet rs = null;
    Statement stmt = null;
    Statement stmt1 = null;

    public boolean inserirVenda(VendaDTO vendaDTO,ClienteDTO clienteDTO,JTable produtos){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();

            String comando1 = "Insert into Venda (dat_v, val_v, "
                    + "id_cli) values ( "
                    + "to_date ('" + date.format(vendaDTO.getDat_v()) + "', 'DD/MM/YYYY'), "
                    + vendaDTO.getVal_v() + ", "
                    + clienteDTO.getId_cli() + ")";
            
            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();
  
            for(int cont = 0; cont < produtos.getRowCount(); cont++){
                String comando2 = "Insert into produto_v (id_v, id_p, "
                + "val_p, qtd_p) values ( "
                + rs.getInt("id_v") + ", " 
                + produtos.getValueAt(cont, 0) + ", "
                + produtos.getValueAt(cont, 2) + ", "
                + produtos.getValueAt(cont, 3) + "); ";
                stmt1.execute(comando2);
        } 
            ConexaoDAO.con.commit();
            stmt.close();
            stmt1.close();
            rs.close();
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
}
    

