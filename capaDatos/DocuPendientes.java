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
public class DocuPendientes {
private String rut_docu;
    private String digito_docu;
    private String nomCli_docu;
    private String tipoDoc_docu;
    private int numDoc_docu;
    private int montoPen_docu; //Monto pendiente
    private int abonos_docu;
    private Date fechUltimo_docu;
    private int docu_docu;
    private int cuota_docu;
    private int cuotaActual_docu;

    public DocuPendientes() {
    }

    public DocuPendientes(String rut_docu, String digito_docu, String nomCli_docu,
            String tipoDoc_docu, int numDoc_docu, int montoPen_docu, int abonos_docu,
            Date fechUltimo_docu, int docu_docu, int cuota_docu, int cuotaActual_docu) {
        this.rut_docu = rut_docu;
        this.digito_docu = digito_docu;
        this.nomCli_docu = nomCli_docu;
        this.tipoDoc_docu = tipoDoc_docu;
        this.numDoc_docu = numDoc_docu;
        this.montoPen_docu = montoPen_docu;
        this.abonos_docu = abonos_docu;
        this.fechUltimo_docu = fechUltimo_docu;
        this.docu_docu = docu_docu;
        this.cuota_docu = cuota_docu;
        this.cuotaActual_docu = cuotaActual_docu;
    }

    public int getAbonos_docu() {
        return abonos_docu;
    }

    public void setAbonos_docu(int abonos_docu) {
        this.abonos_docu = abonos_docu;
    }

    public int getCuotaActual_docu() {
        return cuotaActual_docu;
    }

    public void setCuotaActual_docu(int cuotaActual_docu) {
        this.cuotaActual_docu = cuotaActual_docu;
    }

    public int getCuota_docu() {
        return cuota_docu;
    }

    public void setCuota_docu(int cuota_docu) {
        this.cuota_docu = cuota_docu;
    }

    public String getDigito_docu() {
        return digito_docu;
    }

    public void setDigito_docu(String digito_docu) {
        this.digito_docu = digito_docu;
    }

    public int getDocu_docu() {
        return docu_docu;
    }

    public void setDocu_docu(int docu_docu) {
        this.docu_docu = docu_docu;
    }

    public Date getFechUltimo_docu() {
        return fechUltimo_docu;
    }

    public void setFechUltimo_docu(Date fechUltimo_docu) {
        this.fechUltimo_docu = fechUltimo_docu;
    }

    public int getMontoPen_docu() {
        return montoPen_docu;
    }

    public void setMontoPen_docu(int montoPen_docu) {
        this.montoPen_docu = montoPen_docu;
    }

    public String getNomCli_docu() {
        return nomCli_docu;
    }

    public void setNomCli_docu(String nomCli_docu) {
        this.nomCli_docu = nomCli_docu;
    }

    public int getNumDoc_docu() {
        return numDoc_docu;
    }

    public void setNumDoc_docu(int numDoc_docu) {
        this.numDoc_docu = numDoc_docu;
    }

    public String getRut_docu() {
        return rut_docu;
    }

    public void setRut_docu(String rut_docu) {
        this.rut_docu = rut_docu;
    }

    public String getTipoDoc_docu() {
        return tipoDoc_docu;
    }

    public void setTipoDoc_docu(String tipoDoc_docu) {
        this.tipoDoc_docu = tipoDoc_docu;
    }

    
}
