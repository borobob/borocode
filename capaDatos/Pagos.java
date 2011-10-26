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
public class Pagos {
    private String rut_pago;
    private String digito_pago;
    private int tipoMov_pago;
    private Date fech_pago;
    private int monto_pago;
    private int docu_pago;
    private int numCuota_pago;
    private String tipoDoc_pago;
    private int numDoc_pago;
    private String descrip_pago;
    private int caja_pago;
    private String sucursal_pago;

    public Pagos(String rut_pago, String digito_pago, int tipoMov_pago, Date fech_pago, int monto_pago, int docu_pago, int numCuota_pago, String tipoDoc_pago, int numDoc_pago, String descrip_pago, int caja_pago, String sucursal_pago) {
        this.rut_pago = rut_pago;
        this.digito_pago = digito_pago;
        this.tipoMov_pago = tipoMov_pago;
        this.fech_pago = fech_pago;
        this.monto_pago = monto_pago;
        this.docu_pago = docu_pago;
        this.numCuota_pago = numCuota_pago;
        this.tipoDoc_pago = tipoDoc_pago;
        this.numDoc_pago = numDoc_pago;
        this.descrip_pago = descrip_pago;
        this.caja_pago = caja_pago;
        this.sucursal_pago = sucursal_pago;
    }

    public Pagos() {}
    public int getCaja_pago() {return caja_pago;}
    public void setCaja_pago(int caja_pago) {this.caja_pago = caja_pago;}
    public String getDescrip_pago() {return descrip_pago;}
    public void setDescrip_pago(String descrip_pago) {this.descrip_pago = descrip_pago;}
    public String getDigito_pago() { return digito_pago;}
    public void setDigito_pago(String digito_pago) {this.digito_pago = digito_pago;}
    public int getDocu_pago() { return docu_pago;}
    public void setDocu_pago(int docu_pago) { this.docu_pago = docu_pago;}
    public Date getFech_pago() {return fech_pago;}
    public void setFech_pago(Date fech_pago) {this.fech_pago = fech_pago;}
    public int getMonto_pago() { return monto_pago;}
    public void setMonto_pago(int monto_pago) {this.monto_pago = monto_pago;}
    public int getNumCuota_pago() {return numCuota_pago; }
    public void setNumCuota_pago(int numCuota_pago) {this.numCuota_pago = numCuota_pago;}
    public int getNumDoc_pago() {return numDoc_pago;}
    public void setNumDoc_pago(int numDoc_pago) {this.numDoc_pago = numDoc_pago; }
    public String getRut_pago() {return rut_pago;}
    public void setRut_pago(String rut_pago) { this.rut_pago = rut_pago; }
    public String getSucursal_pago() { return sucursal_pago; }
    public void setSucursal_pago(String sucursal_pago) { this.sucursal_pago = sucursal_pago;}
    public String getTipoDoc_pago() {return tipoDoc_pago; }
    public void setTipoDoc_pago(String tipoDoc_pago) {this.tipoDoc_pago = tipoDoc_pago;}
    public int getTipoMov_pago() {return tipoMov_pago;}
    public void setTipoMov_pago(int tipoMov_pago) {this.tipoMov_pago = tipoMov_pago;}
}
