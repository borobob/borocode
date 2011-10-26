/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package capaDatos;

import java.util.Date;

/**º
 *
 * @author Kamalolz
 */
public class Clientes {
    private String rut_cli;
    private String digito_cli;
    private String nombre_cli;
    private String domicilio;
    private String comuna_cli;
    private String ciudad_cli;
    private String fonos_cli;
    private String email_cli;
    private String lugarTrabajo_cli;
    private Date fechApe_cli;
    private int cupo_cli;
    private int saldoDB_cli;  //saldo debito
    private int saldoCR_cli;
    private int saldoFIN_cli;

    public Clientes() {
    }


    public Clientes(String rut_cli,String digito_cli, String nombre_cli, String domicilio, String comuna_cli, String ciudad_cli, String fonos_cli, String email_cli, String lugarTrabajo_cli, Date fechApe_cli, int cupo_cli, int saldoDB_cli, int saldoCR_cli, int saldoFIN_cli) {
        this.rut_cli = rut_cli;
        this.digito_cli = digito_cli;
        this.nombre_cli = nombre_cli;
        this.domicilio = domicilio;
        this.comuna_cli = comuna_cli;
        this.ciudad_cli = ciudad_cli;
        this.fonos_cli = fonos_cli;
        this.email_cli = email_cli;
        this.lugarTrabajo_cli = lugarTrabajo_cli;
        this.fechApe_cli = fechApe_cli;
        this.cupo_cli = cupo_cli;
        this.saldoDB_cli = saldoDB_cli;
        this.saldoCR_cli = saldoCR_cli;
        this.saldoFIN_cli = saldoFIN_cli;
    }

    

    public String getDigito_cli() {return digito_cli;}
    public void setDigito_cli(String digito_cli) {this.digito_cli = digito_cli;}
    public String getCiudad_cli() {return ciudad_cli;}
    public void setCiudad_cli(String ciudad_cli) {this.ciudad_cli = ciudad_cli;}
    public String getComuna_cli() {return comuna_cli;}
    public void setComuna_cli(String comuna_cli) {this.comuna_cli = comuna_cli;}
    public int getCupo_cli() {return cupo_cli;}
    public void setCupo_cli(int cupo_cli) {this.cupo_cli = cupo_cli;}
    public String getDomicilio() {return domicilio;}
    public void setDomicilio(String domicilio) {this.domicilio = domicilio;}
    public String getEmail_cli() {return email_cli;}
    public void setEmail_cli(String email_cli) {this.email_cli = email_cli;}
    public Date getFechApe_cli() {return fechApe_cli;}
    public void setFechApe_cli(Date fechApe_cli) {this.fechApe_cli = fechApe_cli;}
    public String getFonos_cli() {return fonos_cli;}
    public void setFonos_cli(String fonos_cli) {this.fonos_cli = fonos_cli;}
    public String getLugarTrabajo_cli() {return lugarTrabajo_cli;}
    public void setLugarTrabajo_cli(String lugarTrabajo_cli) {this.lugarTrabajo_cli = lugarTrabajo_cli;}
    public String getNombre_cli() {return nombre_cli;}
    public void setNombre_cli(String nombre_cli) {this.nombre_cli = nombre_cli;}
    public String getRut_cli() {return rut_cli;}
    public void setRut_cli(String rut_cli) {this.rut_cli = rut_cli;}
    public int getSaldoCR_cli() {return saldoCR_cli;}
    public void setSaldoCR_cli(int saldoCR_cli) {this.saldoCR_cli = saldoCR_cli;}
    public int getSaldoDB_cli() {return saldoDB_cli;}
    public void setSaldoDB_cli(int saldoDB_cli) {this.saldoDB_cli = saldoDB_cli;}
    public int getSaldoFIN_cli() {return saldoFIN_cli;}
    public void setSaldoFIN_cli(int saldoFIN_cli) {this.saldoFIN_cli = saldoFIN_cli;}
}