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
public class Ventas {
    private String rut_vta;
    private String digito_vta;
    private int tipoMov_vta;
    private Date fecha_vta;
    private int monto_vta;
    private int numCuota_vta;
    private int valorCuota_vta;
    private double interesCuota_vta;
    private int docu_vta;
    private String tipoDoc_vta;
    private String descrip_vta;
    private String vendedor_vta;
    private String sucursal_vta;

    public Ventas(String rut_vta,String digito_vta, int tipoMov_vta, Date fecha_vta, int monto_vta, int numCuota_vta, int valorCuota_vta, double interesCuota_vta, int docu_vta, String tipoDoc_vta, String descrip_vta, String vendedor_vta, String sucursal_vta) {
        this.rut_vta = rut_vta;
        this.digito_vta=digito_vta;
        this.tipoMov_vta = tipoMov_vta;
        this.fecha_vta = fecha_vta;
        this.monto_vta = monto_vta;
        this.numCuota_vta = numCuota_vta;
        this.valorCuota_vta = valorCuota_vta;
        this.interesCuota_vta = interesCuota_vta;
        this.docu_vta = docu_vta;
        this.tipoDoc_vta = tipoDoc_vta;
        this.descrip_vta = descrip_vta;
        this.vendedor_vta = vendedor_vta;
        this.sucursal_vta = sucursal_vta;
    }

    public Ventas(){}

    public String getDigito_vta() {return digito_vta;}
    public void setDigito_vta(String digito_vta) {this.digito_vta = digito_vta;}
    public String getDescrip_vta() {return descrip_vta;}
    public void setDescrip_vta(String descrip_vta) {this.descrip_vta = descrip_vta;}
    public int getDocu_vta() {return docu_vta;}
    public void setDocu_vta(int docu_vta) {this.docu_vta = docu_vta;}
    public Date getFecha_vta() {return fecha_vta;}
    public void setFecha_vta(Date fecha_vta) {this.fecha_vta = fecha_vta;}
    public double getInteresCuota_vta() {return interesCuota_vta;}
    public void setInteresCuota_vta(double interesCuota_vta) {this.interesCuota_vta = interesCuota_vta;}
    public int getMonto_vta() {return monto_vta;}
    public void setMonto_vta(int monto_vta) {this.monto_vta = monto_vta;}
    public int getNumCuota_vta() {return numCuota_vta;}
    public void setNumCuota_vta(int numCuota_vta) {this.numCuota_vta = numCuota_vta;}
    public String getRut_vta() {return rut_vta;}
    public void setRut_vta(String rut_vta) {this.rut_vta = rut_vta;}
    public String getSucursal_vta() {return sucursal_vta;}
    public void setSucursal_vta(String sucursal_vta) {this.sucursal_vta = sucursal_vta;}
    public String getTipoDoc_vta() {return tipoDoc_vta;}
    public void setTipoDoc_vta(String tipoDoc_vta) {this.tipoDoc_vta = tipoDoc_vta;}
    public int getTipoMov_vta() {return tipoMov_vta;}
    public void setTipoMov_vta(int tipoMov_vta) {this.tipoMov_vta = tipoMov_vta;}
    public int getValorCuota_vta() {return valorCuota_vta;}
    public void setValorCuota_vta(int valorCuota_vta) {this.valorCuota_vta = valorCuota_vta;}
    public String getVendedor_vta() {return vendedor_vta;}
    public void setVendedor_vta(String vendedor_vta) {this.vendedor_vta = vendedor_vta;}
    




}
