/**
 *
 * @author Jose
 */
package br.com.projeto_3.dto;

import java.util.Date;

public class FornecedorDTO {
    
    private String nome_f, cnpj_f, tel_f;
    private Date data_cad_f;
    private int id_f;

    public String getNome_f() {
        return nome_f;
    }

    public void setNome_f(String nome_f) {
        this.nome_f = nome_f;
    }

    public String getCnpj_f() {
        return cnpj_f;
    }

    public void setCnpj_f(String cnpj_f) {
        this.cnpj_f = cnpj_f;
    }

    public String getTel_f() {
        return tel_f;
    }

    public void setTel_f(String tel_f) {
        this.tel_f = tel_f;
    }

    public Date getData_cad_f() {
        return data_cad_f;
    }

    public void setData_cad_f(Date data_cad_f) {
        this.data_cad_f = data_cad_f;
    }

    public int getId_f() {
        return id_f;
    }

    public void setId_f(int id_f) {
        this.id_f = id_f;
    }
}
