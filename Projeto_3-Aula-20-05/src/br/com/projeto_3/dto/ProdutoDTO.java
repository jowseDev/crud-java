/**
 *
 * @author Jose
 */
package br.com.projeto_3.dto;

public class ProdutoDTO {
    private String nome_p, desc_p, cod_bar_p;
    private double pcusto_p, pvenda_p;
    private int id_p;

    public String getNome_p() {
        return nome_p;
    }

    public void setNome_p(String nome_p) {
        this.nome_p = nome_p;
    }

    public String getDesc_p() {
        return desc_p;
    }

    public void setDesc_p(String desc_p) {
        this.desc_p = desc_p;
    }

    public String getCod_bar_p() {
        return cod_bar_p;
    }

    public void setCod_bar_p(String cod_bar_p) {
        this.cod_bar_p = cod_bar_p;
    }

    public double getPcusto_p() {
        return pcusto_p;
    }

    public void setPcusto_p(double pcusto_p) {
        this.pcusto_p = pcusto_p;
    }

    public double getPvenda_p() {
        return pvenda_p;
    }

    public void setPvenda_p(double pvenda_p) {
        this.pvenda_p = pvenda_p;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }
    
}
