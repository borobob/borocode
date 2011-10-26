/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package capaDatos;

import java.util.Date;

/**
 *
 * @author Kamalolz
 */
public class DocuCancelados {
    private String rut_cancel;
    private String digito_cancel;
    private String nomCli_cancel;
    private String tipoDoc_cancel;
    private int numDoc_cancel;
    private int montoTotal_cancel;
    private Date fechUltimoPago_docu;

    public DocuCancelados(String rut_cancel, String digito_cancel, String nomCli_cancel, String tipoDoc_cancel, int numDoc_cancel, int montoTotal_cancel, Date fechUltimoPago_docu) {
        this.rut_cancel = rut_cancel;
        this.digito_cancel = digito_cancel;
        this.nomCli_cancel = nomCli_cancel;
        this.tipoDoc_cancel = tipoDoc_cancel;
        this.numDoc_cancel = numDoc_cancel;
        this.montoTotal_cancel = montoTotal_cancel;
        this.fechUltimoPago_docu = fechUltimoPago_docu;
    }

    public DocuCancelados() {
    }

    public String getDigito_cancel() {
        return digito_cancel;
    }

    public void setDigito_cancel(String digito_cancel) {
        this.digito_cancel = digito_cancel;
    }

    public Date getFechUltimoPago_docu() {
        return fechUltimoPago_docu;
    }

    public void setFechUltimoPago_docu(Date fechUltimoPago_docu) {
        this.fechUltimoPago_docu = fechUltimoPago_docu;
    }

    public int getMontoTotal_cancel() {
        return montoTotal_cancel;
    }

    public void setMontoTotal_cancel(int montoTotal_cancel) {
        this.montoTotal_cancel = montoTotal_cancel;
    }

    public String getNomCli_cancel() {
        return nomCli_cancel;
    }

    public void setNomCli_cancel(String nomCli_cancel) {
        this.nomCli_cancel = nomCli_cancel;
    }

    public int getNumDoc_cancel() {
        return numDoc_cancel;
    }

    public void setNumDoc_cancel(int numDoc_cancel) {
        this.numDoc_cancel = numDoc_cancel;
    }

    public String getRut_cancel() {
        return rut_cancel;
    }

    public void setRut_cancel(String rut_cancel) {
        this.rut_cancel = rut_cancel;
    }

    public String getTipoDoc_cancel() {
        return tipoDoc_cancel;
    }

    public void setTipoDoc_cancel(String tipoDoc_cancel) {
        this.tipoDoc_cancel = tipoDoc_cancel;
    }

}
