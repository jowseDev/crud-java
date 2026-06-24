/**
 *
 * @author Jose
 */
package br.com.projeto_3.dto;

import java.util.Date;

public class VendaDTO {
    private int id_v;
    private double val_v;
    private Date dat_v;

    public int getId_v() {
        return id_v;
    }

    public void setId_v(int id_v) {
        this.id_v = id_v;
    }

    public double getVal_v() {
        return val_v;
    }

    public void setVal_v(double val_v) {
        this.val_v = val_v;
    }

    public Date getDat_v() {
        return dat_v;
    }

    public void setDat_v(Date dat_v) {
        this.dat_v = dat_v;
    }
}
