/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package capaDatos;

/**
 *
 * @author Alumno
 */
public class Vendedor {
    private String rutVendedor;
    private String nombbreVendedor;
    private float comisionVendedor;
    private double totalVentasVendedor;

    public Vendedor() {
    }

    public Vendedor(String rutVendedor, String nombbreVendedor, float comisionVendedor, double totalVentasVendedor) {
        this.rutVendedor = rutVendedor;
        this.nombbreVendedor = nombbreVendedor;
        this.comisionVendedor = comisionVendedor;
        this.totalVentasVendedor = totalVentasVendedor;
    }

    public float getComisionVendedor() {
        return comisionVendedor;
    }

    public void setComisionVendedor(float comisionVendedor) {
        this.comisionVendedor = comisionVendedor;
    }

    public String getNombbreVendedor() {
        return nombbreVendedor;
    }

    public void setNombbreVendedor(String nombbreVendedor) {
        this.nombbreVendedor = nombbreVendedor;
    }

    public String getRutVendedor() {
        return rutVendedor;
    }

    public void setRutVendedor(String rutVendedor) {
        this.rutVendedor = rutVendedor;
    }

    public double getTotalVentasVendedor() {
        return totalVentasVendedor;
    }

    public void setTotalVentasVendedor(double totalVentasVendedor) {
        this.totalVentasVendedor = totalVentasVendedor;
    }

    


}
