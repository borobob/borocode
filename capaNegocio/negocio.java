/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import capaConexion.Conexion;
import capaDatos.Clientes;
import capaDatos.DocuCancelados;
import capaDatos.DocuPendientes;
import capaDatos.Documento;
import capaDatos.Pagos;
import capaDatos.Vendedor;
import capaDatos.Ventas;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BORO
 */
public class negocio {

    private Conexion cnn;

    public negocio() {
        cnn = new Conexion();
    }

    private void configurarConexion() {
        cnn.setDriver("com.mysql.jdbc.Driver");
        cnn.setNombreBaseDeDatos("jdbc:mysql://localhost/proyect");
        cnn.setUser("root");
        cnn.setPass("");
    }

    public void addCliente(Clientes clie) {
        this.configurarConexion();
        cnn.setSenteciaSQL("Insert into clientes values("
                + "'" + clie.getRut_cli()
                + "','" + clie.getDigito_cli()
                + "','" + clie.getNombre_cli()
                + "','" + clie.getDomicilio()
                + "','" + clie.getComuna_cli()
                + "','" + clie.getCiudad_cli()
                + "','" + clie.getFonos_cli()
                + "','" + clie.getEmail_cli()
                + "','" + clie.getLugarTrabajo_cli()
                + "','" + date2string(clie.getFechApe_cli())
                + "'," + clie.getCupo_cli()
                + "," + clie.getSaldoDB_cli()
                + "," + clie.getSaldoCR_cli()
                + "," + clie.getSaldoFIN_cli() + ")");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public void addVentas(Ventas vta, int cuota, String nombre) {
        this.configurarConexion();
        cnn.setSenteciaSQL("Insert into ventas (rut_vta,digito_vta,tipoMov_vta,fech_vta,"
                + "monto_vta,numCuota_vta,valorCuota_vta,"
                + "interesCuota_vta,docu_vta,tipoDoc_vta,descrip_vta,"
                + "vendedor_vta,sucursal_vta)values("
                + "'" + vta.getRut_vta()
                + "','" + vta.getDigito_vta()
                + "'," + vta.getTipoMov_vta()
                + ",'" + date2string(vta.getFecha_vta())
                + "'," + vta.getMonto_vta()
                + "," + vta.getNumCuota_vta()
                + "," + vta.getValorCuota_vta()
                + "," + vta.getInteresCuota_vta()
                + "," + vta.getDocu_vta()
                + ",'" + vta.getTipoDoc_vta()
                + "','" + vta.getDescrip_vta()
                + "','" + vta.getVendedor_vta()
                + "','" + vta.getSucursal_vta() + "')");
        cnn.setEsSelect(false);
        cnn.conectar();
        if (cuota != 13) {
            DocuPendientes docu = new DocuPendientes();
            docu.setRut_docu(vta.getRut_vta());
            docu.setDigito_docu(vta.getDigito_vta());
            docu.setNomCli_docu(nombre);
            docu.setNumDoc_docu(vta.getDocu_vta());
            docu.setTipoDoc_docu(vta.getTipoDoc_vta());
            docu.setMontoPen_docu(vta.getMonto_vta());
            docu.setAbonos_docu(0);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, 1);
            docu.setFechUltimo_docu(cal.getTime());
            docu.setCuota_docu(vta.getNumCuota_vta());
            addDocuPendiente(docu);
        } else {
            Pagos pago = new Pagos();
            negocio neg = new negocio();
            DocuCancelados cans = new DocuCancelados();
            Clientes clie = new Clientes();
            cans.setRut_cancel(vta.getRut_vta());
            cans.setDigito_cancel(vta.getDigito_vta());
            cans.setNomCli_cancel(nombre);
            cans.setTipoDoc_cancel(vta.getTipoDoc_vta());
            cans.setNumDoc_cancel(vta.getDocu_vta());
            cans.setMontoTotal_cancel(vta.getMonto_vta());
            cans.setFechUltimoPago_docu(vta.getFecha_vta());
            neg.addDocuCancelado(cans);
        }
        cnn.cerrarConexion();
    }

    public void addDocuPendiente(DocuPendientes docu) {
        this.configurarConexion();
        cnn.setSenteciaSQL("Insert into docu_pendientes values("
                + "'" + docu.getRut_docu()
                + "','" + docu.getDigito_docu()
                + "','" + docu.getNomCli_docu()
                + "','" + docu.getTipoDoc_docu()
                + "'," + docu.getNumDoc_docu()
                + "," + docu.getMontoPen_docu()
                + "," + docu.getAbonos_docu()
                + ",'" + date2string(docu.getFechUltimo_docu())
                + "'," + docu.getDocu_docu()
                + "," + docu.getCuota_docu()
                + "," + docu.getCuotaActual_docu() + ")");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public void addDocuCancelado(DocuCancelados docu) {
        this.configurarConexion();
        cnn.setSenteciaSQL("Insert into docu_cancelados values("
                + "'" + docu.getRut_cancel()
                + "','" + docu.getDigito_cancel()
                + "','" + docu.getNomCli_cancel()
                + "'," + docu.getNumDoc_cancel() //'" + docu.getTipoDoc_cancel() + "'
                + "," + docu.getMontoTotal_cancel()
                + ",'" + date2string(docu.getFechUltimoPago_docu()) + "')");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public void addPagos(Pagos pago) {
        this.configurarConexion();
        cnn.setSenteciaSQL("Insert into pagos ( "
                + "rut_pago,"
                + "digito_pago,"
                + "tipoMov_pago,"
                + "fech_pago,"
                + "monto_pago,"
                + "docu_pago,"
                + "numCuota_pago,"
                + "tipDoc_pago,"
                + "numDoc_pago,"
                + "descrip_pago,"
                + "caja_pago,"
                + "sucursal_pago)values("
                + "'" + pago.getRut_pago()
                + "','" + pago.getDigito_pago()
                + "'," + pago.getTipoMov_pago()
                + ",'" + date2string(pago.getFech_pago())
                + "'," + pago.getMonto_pago()
                + "," + pago.getDocu_pago()
                + "," + pago.getNumCuota_pago()
                + ",'" + pago.getTipoDoc_pago()
                + "'," + pago.getNumDoc_pago()
                + ",'" + pago.getDescrip_pago()
                + "'," + pago.getCaja_pago()
                + ",'" + pago.getSucursal_pago() + "')");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public void editarCliente(Clientes clie) {
        this.configurarConexion();
        cnn.setSenteciaSQL("update clientes set "
                + " nombre_cli='" + clie.getNombre_cli()
                + "',domicilio_cli='" + clie.getDomicilio()
                + "',comuna_cli='" + clie.getComuna_cli()
                + "',ciudad_cli='" + clie.getCiudad_cli()
                + "',fonos_cli='" + clie.getFonos_cli()
                + "',email_cli='" + clie.getEmail_cli()
                + "',lugarTrab_cli='" + clie.getLugarTrabajo_cli()
                + "',cupo_cli=" + clie.getCupo_cli()
                + ",saldoDB_cli=" + clie.getSaldoDB_cli()
                + ",saldoCR_cli=" + clie.getSaldoCR_cli()
                + ",saldoFin_cli=" + clie.getSaldoFIN_cli() + "  where rut_cli='" + clie.getRut_cli() + "' ");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public void editarVenta(Ventas vta) {
        this.configurarConexion();
        cnn.setSenteciaSQL("update Ventas set "
                + "tipoMov_vta=" + vta.getTipoMov_vta()
                + ",fech_vta='" + date2string(vta.getFecha_vta())
                + "',monto_vta=" + vta.getMonto_vta()
                + ",numCuota_vta=" + vta.getNumCuota_vta()
                + ",valorCuota_vta=" + vta.getValorCuota_vta()
                + ",interesCuota_vta=" + vta.getInteresCuota_vta()
                + ",docu_vta=" + vta.getDocu_vta()
                + ",tipoDoc_vta='" + vta.getTipoDoc_vta()
                + "',descrip_vta='" + vta.getDescrip_vta()
                + "',vendedor_vta='" + vta.getVendedor_vta()
                + "',sucursal_vta='" + vta.getSucursal_vta()
                + "'  where rut_vta='" + vta.getRut_vta() + "'");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public void editarPago(Pagos pago) {
        this.configurarConexion();
        cnn.setSenteciaSQL("UPDATE Pagos SET "
                + " tipoMov_pago=" + pago.getTipoMov_pago()
                + ",fech_pago='" + date2string(pago.getFech_pago())
                + "',monto_pago=" + pago.getMonto_pago()
                + ",docu_pago=" + pago.getDocu_pago()
                + ",numCuota_pago=" + pago.getNumCuota_pago()
                + ",tipoDoc_pago='" + pago.getTipoDoc_pago()
                + "',numDoc_pago=" + pago.getNumDoc_pago()
                + ",descrip_pago='" + pago.getDescrip_pago()
                + "',caja_pago=" + pago.getCaja_pago()
                + ",sucursal_pago='" + pago.getSucursal_pago() + "'");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public void editarDocuPendientes(DocuPendientes docu) {
        this.configurarConexion();
        cnn.setSenteciaSQL("UPDATE docu_pendientes SET "
                + "nomCli_docu='" + docu.getNomCli_docu()
                + "',tipoDoc_docu='" + docu.getTipoDoc_docu()
                + "',numDoc_docu=" + docu.getNumDoc_docu()
                + ",montoPen_docu=" + docu.getMontoPen_docu()
                + ",abonos_docu=" + docu.getAbonos_docu()
                + ",fechUltimo_docu='" + date2string(docu.getFechUltimo_docu())
                + ",cuota_docu=" + docu.getCuota_docu()
                + ",cuotaActual_docu=" + docu.getCuotaActual_docu());
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public Clientes getBuscarClientes(String rut) {
        this.configurarConexion();
        Clientes clie = new Clientes();
        cnn.setSenteciaSQL("select * from clientes where rut_cli= '" + rut.trim() + "'");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            if (cnn.getRst().next()) {
                clie.setRut_cli(cnn.getRst().getString("rut_cli"));
                clie.setDigito_cli(cnn.getRst().getString("digito_cli"));
                clie.setNombre_cli(cnn.getRst().getString("nombre_cli"));
                clie.setDomicilio(cnn.getRst().getString("domicilio_cli"));
                clie.setComuna_cli(cnn.getRst().getString("comuna_cli"));
                clie.setCiudad_cli(cnn.getRst().getString("ciudad_cli"));
                clie.setFonos_cli(cnn.getRst().getString("fonos_cli"));
                clie.setEmail_cli(cnn.getRst().getString("email_cli"));
                clie.setLugarTrabajo_cli(cnn.getRst().getString("lugarTrab_cli"));
                clie.setFechApe_cli(cnn.getRst().getDate("fechApe_cli"));
                clie.setCupo_cli(cnn.getRst().getInt("cupo_cli"));
                clie.setSaldoDB_cli(cnn.getRst().getInt("saldoDB_cli"));
                clie.setSaldoCR_cli(cnn.getRst().getInt("saldoCR_cli"));
                clie.setSaldoFIN_cli(cnn.getRst().getInt("saldoFin_cli"));
            } else {
                clie.setRut_cli("");
                clie.setNombre_cli("");
            }//Cierre if
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clie;
    }

    public Clientes BuscarNombreCliente(String nombre) {
        this.configurarConexion();
        Clientes clie = new Clientes();
        cnn.setSenteciaSQL("select * from clientes where nombre_cli like '%" + nombre.trim() + "%'");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            if (cnn.getRst().next()) {
                clie.setRut_cli(cnn.getRst().getString("rut_cli"));
                clie.setDigito_cli(cnn.getRst().getString("digito_cli"));
                clie.setNombre_cli(cnn.getRst().getString("nombre_cli"));
                clie.setDomicilio(cnn.getRst().getString("domicilio_cli"));
                clie.setComuna_cli(cnn.getRst().getString("comuna_cli"));
                clie.setCiudad_cli(cnn.getRst().getString("ciudad_cli"));
                clie.setFonos_cli(cnn.getRst().getString("fonos_cli"));
                clie.setEmail_cli(cnn.getRst().getString("email_cli"));
                clie.setLugarTrabajo_cli(cnn.getRst().getString("lugarTrab_cli"));
                clie.setFechApe_cli(cnn.getRst().getDate("fechApe_cli"));
                clie.setCupo_cli(cnn.getRst().getInt("cupo_cli"));
                clie.setSaldoDB_cli(cnn.getRst().getInt("saldoDB_cli"));
                clie.setSaldoCR_cli(cnn.getRst().getInt("saldoCR_cli"));
                clie.setSaldoFIN_cli(cnn.getRst().getInt("saldoFin_cli"));
            } else {
                clie.setRut_cli("");
                clie.setNombre_cli("");
            }//Cierre if
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clie;
    }

    public Ventas getBuscarVentas(String rut) {
        this.configurarConexion();
        Ventas vta = new Ventas();
        cnn.setSenteciaSQL("select * from ventas,clientes where rut_vta= '" + rut.trim() + "'");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            if (cnn.getRst().next()) {
                vta.setRut_vta(cnn.getRst().getString("rut_vta"));
                vta.setDigito_vta(cnn.getRst().getString("digito_vta"));
                vta.setTipoMov_vta(cnn.getRst().getInt("tipoMov_vta"));
                vta.setFecha_vta(cnn.getRst().getDate("fech_vta"));
                vta.setMonto_vta(cnn.getRst().getInt("monto_vta"));
                vta.setNumCuota_vta(cnn.getRst().getInt("numCuota_vta"));
                vta.setValorCuota_vta(cnn.getRst().getInt("valorCuota_vta"));
                vta.setInteresCuota_vta(cnn.getRst().getInt("interesCuota_vta"));
                vta.setDocu_vta(cnn.getRst().getInt("docu_vta"));
                vta.setTipoDoc_vta(cnn.getRst().getString("tipoDoc_vta"));
                vta.setDescrip_vta(cnn.getRst().getString("descrip_vta"));
                vta.setVendedor_vta(cnn.getRst().getString("vendedor_vta"));
                vta.setSucursal_vta(cnn.getRst().getString("sucursal_vta"));
            } else {
                vta.setRut_vta("");
            }//Cierre if
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vta;
    }

    public Pagos getBuscarPagos(String rut) {
        this.configurarConexion();
        Pagos pago = new Pagos();
        cnn.setSenteciaSQL("select * from pagos where rut_pago= '" + rut.trim() + "'");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            if (cnn.getRst().next()) {
                pago.setRut_pago(cnn.getRst().getString("rut_pago"));
                pago.setDigito_pago(cnn.getRst().getString("digito_pago"));
                pago.setTipoMov_pago(cnn.getRst().getInt("tipoMov_pago"));
                pago.setFech_pago(cnn.getRst().getDate("fech_pago"));
                pago.setMonto_pago(cnn.getRst().getInt("monto_pago"));
                pago.setDocu_pago(cnn.getRst().getInt("docu_pago"));
                pago.setTipoDoc_pago(cnn.getRst().getString("tipDoc_pago"));
                pago.setNumCuota_pago(cnn.getRst().getInt("numCuota_pago"));
                pago.setDescrip_pago(cnn.getRst().getString("descrip_pago"));
                pago.setCaja_pago(cnn.getRst().getInt("caja_pago"));
                pago.setSucursal_pago(cnn.getRst().getString("sucursal_pago"));
            } else {
                pago.setRut_pago("");
            }//Cierre if
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pago;
    }

    public DocuPendientes getBuscarDocuPendientes(String rut) {
        this.configurarConexion();
        DocuPendientes docu = new DocuPendientes();
        cnn.setSenteciaSQL("select * from docu_pendientes where rut_docu= '" + rut.trim() + "'");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            if (cnn.getRst().next()) {
                docu.setRut_docu(cnn.getRst().getString("rut_docu"));
                docu.setDigito_docu(cnn.getRst().getString("digito_docu"));
                docu.setNomCli_docu(cnn.getRst().getString("nomCli_docu"));
                docu.setTipoDoc_docu(cnn.getRst().getString("tipoDoc_docu"));
                docu.setNumDoc_docu(cnn.getRst().getInt("numDoc_docu"));
                docu.setMontoPen_docu(cnn.getRst().getInt("montoPen_docu"));
                docu.setAbonos_docu(cnn.getRst().getInt("abonos_docu"));
                docu.setFechUltimo_docu(cnn.getRst().getDate("fechUltimo_docu"));
                docu.setDocu_docu(cnn.getRst().getInt("docu_docu"));
            } else {
                docu.setRut_docu("");
            }//Cierre if
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return docu;
    }

    public DocuPendientes getBuscarDocuPendientes(int numDocu) {
        this.configurarConexion();
        DocuPendientes docu = new DocuPendientes();
        cnn.setSenteciaSQL("select * from docu_pendientes where numDoc_docu= " + numDocu);
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            if (cnn.getRst().next()) {
                docu.setRut_docu(cnn.getRst().getString("rut_docu"));
                docu.setDigito_docu(cnn.getRst().getString("digito_docu"));
                docu.setNomCli_docu(cnn.getRst().getString("nomCli_docu"));
                docu.setTipoDoc_docu(cnn.getRst().getString("tipoDoc_docu"));
                docu.setNumDoc_docu(cnn.getRst().getInt("numDoc_docu"));
                docu.setMontoPen_docu(cnn.getRst().getInt("montoPen_docu"));
                docu.setAbonos_docu(cnn.getRst().getInt("abonos_docu"));
                docu.setFechUltimo_docu(cnn.getRst().getDate("fechUltimo_docu"));
                docu.setDocu_docu(cnn.getRst().getInt("docu_docu"));
            } else {
                docu.setRut_docu("");
            }//Cierre if
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return docu;
    }

    public void borrarDocuPendiente(int numDocu) {
        this.configurarConexion();
        cnn.setSenteciaSQL("DELETE FROM docu_pendientes WHERE numDoc_docu=" + numDocu);
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public ArrayList getDocuPendientes() {
        this.configurarConexion();
        ArrayList lista = new ArrayList();
        cnn.setSenteciaSQL("Select * from docu_pendientes ORDER BY nomCli_docu ASC");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                DocuPendientes docu = new DocuPendientes();
                docu.setRut_docu(cnn.getRst().getString("rut_docu"));
                docu.setDigito_docu(cnn.getRst().getString("digito_docu"));
                docu.setNomCli_docu(cnn.getRst().getString("nomCli_docu"));
                docu.setTipoDoc_docu(cnn.getRst().getString("tipoDoc_docu"));
                docu.setNumDoc_docu(cnn.getRst().getInt("numDoc_docu"));
                docu.setMontoPen_docu(cnn.getRst().getInt("montoPen_docu"));
                docu.setAbonos_docu(cnn.getRst().getInt("abonos_docu"));
                docu.setFechUltimo_docu(cnn.getRst().getDate("fechUltimo_docu"));
                lista.add(docu);
            }
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList getDocuCancelados() {
        this.configurarConexion();
        ArrayList lista = new ArrayList();
        cnn.setSenteciaSQL("Select * from docu_cancelados ORDER BY nomCli_cancel ASC");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                DocuCancelados docu = new DocuCancelados();
                docu.setRut_cancel(cnn.getRst().getString("rut_cancel"));
                docu.setDigito_cancel(cnn.getRst().getString("digito_cancel"));
                docu.setNomCli_cancel(cnn.getRst().getString("nomCli_cancel"));
                docu.setNumDoc_cancel(cnn.getRst().getInt("numDoc_cancel"));
                docu.setMontoTotal_cancel(cnn.getRst().getInt("montoTotal_cancel"));
                docu.setFechUltimoPago_docu(cnn.getRst().getDate("fechUltimoPago_docu"));
                lista.add(docu);
            }
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList getVentas() {
        this.configurarConexion();
        ArrayList lista = new ArrayList();
        cnn.setSenteciaSQL("Select * from ventas ORDER BY fech_vta ASC");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Ventas vta = new Ventas();
                vta.setRut_vta(cnn.getRst().getString("rut_vta"));
                vta.setDigito_vta(cnn.getRst().getString("digito_vta"));
                vta.setTipoMov_vta(cnn.getRst().getInt("tipoMov_vta"));
                vta.setFecha_vta(cnn.getRst().getDate("fech_vta"));
                vta.setMonto_vta(cnn.getRst().getInt("monto_vta"));
                vta.setNumCuota_vta(cnn.getRst().getInt("numCuota_vta"));
                vta.setValorCuota_vta(cnn.getRst().getInt("valorCuota_vta"));
                vta.setInteresCuota_vta(cnn.getRst().getInt("interesCuota_vta"));
                vta.setDocu_vta(cnn.getRst().getInt("docu_vta"));
                vta.setTipoDoc_vta(cnn.getRst().getString("tipoDoc_vta"));
                vta.setDescrip_vta(cnn.getRst().getString("descrip_vta"));
                vta.setVendedor_vta(cnn.getRst().getString("vendedor_vta"));
                vta.setSucursal_vta(cnn.getRst().getString("sucursal_vta"));
                lista.add(vta);
            }
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList getPagos() {
        this.configurarConexion();
        ArrayList lista = new ArrayList();
        cnn.setSenteciaSQL("Select * from pagos ORDER BY fech_pago ASC");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Pagos pago = new Pagos();
                pago.setRut_pago(cnn.getRst().getString("rut_pago"));
                pago.setDigito_pago(cnn.getRst().getString("digito_pago"));
                pago.setTipoMov_pago(cnn.getRst().getInt("tipoMov_pago"));
                pago.setFech_pago(cnn.getRst().getDate("fech_pago"));
                pago.setMonto_pago(cnn.getRst().getInt("monto_pago"));
                pago.setDocu_pago(cnn.getRst().getInt("docu_pago"));
                pago.setTipoDoc_pago(cnn.getRst().getString("tipDoc_pago"));
                pago.setNumCuota_pago(cnn.getRst().getInt("numCuota_pago"));
                pago.setDescrip_pago(cnn.getRst().getString("descrip_pago"));
                pago.setCaja_pago(cnn.getRst().getInt("caja_pago"));
                pago.setSucursal_pago(cnn.getRst().getString("sucursal_pago"));
                lista.add(pago);
            }
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList getClientes() {
        this.configurarConexion();
        ArrayList lista = new ArrayList();
        cnn.setSenteciaSQL("Select * from clientes ORDER BY nombre_cli ASC");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Clientes clie = new Clientes();
                clie.setRut_cli(cnn.getRst().getString("rut_cli"));
                clie.setDigito_cli(cnn.getRst().getString("digito_cli"));
                clie.setNombre_cli(cnn.getRst().getString("nombre_cli"));
                clie.setDomicilio(cnn.getRst().getString("domicilio_cli"));
                clie.setComuna_cli(cnn.getRst().getString("comuna_cli"));
                clie.setCiudad_cli(cnn.getRst().getString("ciudad_cli"));
                clie.setFonos_cli(cnn.getRst().getString("fonos_cli"));
                clie.setEmail_cli(cnn.getRst().getString("email_cli"));
                clie.setLugarTrabajo_cli(cnn.getRst().getString("lugarTrab_cli"));
                clie.setFechApe_cli(cnn.getRst().getDate("fechApe_cli"));
                clie.setCupo_cli(cnn.getRst().getInt("cupo_cli"));
                clie.setSaldoDB_cli(cnn.getRst().getInt("saldoDB_cli"));
                clie.setSaldoCR_cli(cnn.getRst().getInt("saldoCR_cli"));
                clie.setSaldoFIN_cli(cnn.getRst().getInt("saldoFin_cli"));
                lista.add(clie);
            }
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void deleteVentas(String rut) {
        this.configurarConexion();
        cnn.setSenteciaSQL("Delete from ventas where rut_vta='" + rut + "'");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public void eliminarRegistro(String rut) {
        this.configurarConexion();
        cnn.setSenteciaSQL("Delete from clientes where rut_cli='" + rut.trim() + "'");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public void eliminarPago(String rut) {
        this.configurarConexion();
        cnn.setSenteciaSQL("Delete from pagos where rut_pago='" + rut.trim() + "'");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public void eliminarDocuPendiente(String rut) {
        this.configurarConexion();
        cnn.setSenteciaSQL("Delete from docu_pendientes where rut_docu='" + rut.trim() + "'");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public String date2string(Date fecha) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(fecha);
    }

    public Documento getBuscarDocumento(String docu) {
        this.configurarConexion();
        Documento doc = new Documento();
        cnn.setSenteciaSQL("select * from docu_pendientes where numDoc_docu = " + docu.trim() + "");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            if (cnn.getRst().next()) {
                doc.setRut_docu(cnn.getRst().getString("rut_docu"));
                doc.setDigito_docu(cnn.getRst().getString("digito_docu"));
                doc.setNomCli_docu(cnn.getRst().getString("nomCli_docu"));
                doc.setTipoDoc_docu(cnn.getRst().getString("tipoDoc_docu"));
                doc.setNumDoc_docu(cnn.getRst().getInt("numDoc_docu"));
                doc.setMontoPen_docu(cnn.getRst().getInt("montoPen_docu"));
                doc.setAbonos_docu(cnn.getRst().getInt("abonos_docu"));
                doc.setFechUltimo_docu(cnn.getRst().getDate("fechUltimo_docu"));
                doc.setDocu_docu(cnn.getRst().getInt("docu_docu"));
                doc.setCuota_docu(cnn.getRst().getInt("cuota_docu"));
                doc.setCuotaActual_docu(cnn.getRst().getInt("cuotaActual_docu"));
            } else {
                doc.setRut_docu("");
                doc.setNomCli_docu("");
            }//Cierre if
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc;
    }

    public int getDocuVentas(int docu_pago) {
        this.configurarConexion();
        cnn.setSenteciaSQL("select valorCuota_vta from ventas where docu_vta= " + docu_pago);
        cnn.setEsSelect(true);
        cnn.conectar();
        int valor = 0;
        try {
            if (cnn.getRst().next()) {
                valor = cnn.getRst().getInt("valorCuota_vta");
            } else {
            }//Cierre if
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public void editarPendiente(int numDoc, int cuotaActual, String fechaNueva, int monto, int bono) {
        this.configurarConexion();
        cnn.setSenteciaSQL("update docu_pendientes set "
                + " cuotaActual_docu=" + cuotaActual
                + ",fechUltimo_docu='" + fechaNueva
                + "', montoPen_docu= " + monto
                + ",abonos_docu=" + bono
                + "  where numDoc_docu=" + numDoc + " ");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public boolean existeRut(String rut) {
        this.configurarConexion();
        boolean siNo = false;
        cnn.setSenteciaSQL("select * from clientes");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            siNo = true;
            while (cnn.getRst().next()) {
                if (cnn.getRst().getString("rut_cli").equalsIgnoreCase(rut)) {
                    siNo = false;
                }
            }
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return siNo;
    }

    public boolean existeDocumento(int docu) {
        this.configurarConexion();
        boolean siNo = false;
        cnn.setSenteciaSQL("select * from ventas");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            siNo = true;
            while (cnn.getRst().next()) {
                if (cnn.getRst().getInt("docu_vta") == docu) {
                    siNo = false;
                }
            }
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return siNo;
    }

    public int getDebito(String rut) {
        this.configurarConexion();
        cnn.setSenteciaSQL("select nomCli_docu ,sum(montoPen_docu) as valor from docu_pendientes where rut_docu= '"
                + rut + "' group by nomCli_docu");
        cnn.setEsSelect(true);
        cnn.conectar();
        int valor = 0;
        try {
            if (cnn.getRst().next()) {
                valor = cnn.getRst().getInt("valor");
            } else {
            }//Cierre if
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public int getSaldoPagado(String rut) {
        this.configurarConexion();
        cnn.setSenteciaSQL("select rut_docu ,sum(abonos_docu) as valor from docu_pendientes where rut_docu= '"
                + rut + "' group by rut_docu");
        cnn.setEsSelect(true);
        cnn.conectar();
        int valor = 0;
        try {
            if (cnn.getRst().next()) {
                valor = cnn.getRst().getInt("valor");
            } else {
            }//Cierre if
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public int getAbono(int documento) {
        this.configurarConexion();
        cnn.setSenteciaSQL("select abonos_docu from docu_pendientes where numDoc_docu=" + documento);
        cnn.setEsSelect(true);
        cnn.conectar();
        int abono = 0;
        try {

            if (cnn.getRst().next()) {
                abono = cnn.getRst().getInt("abonos_docu");
            }
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return abono;
    }

    public double getCupo(String rut) {
        this.configurarConexion();

        double cupoCli = 0;
        cnn.setSenteciaSQL("select cupo_cli from clientes where rut_cli=" + rut);
        cnn.setEsSelect(true);
        cnn.conectar();
        try {

            if (cnn.getRst().next()) {
                cupoCli = cnn.getRst().getInt("cupo_cli");

            }
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cupoCli;
    }

    public void addVendedor(Vendedor ven) {
        this.configurarConexion();
        cnn.setSenteciaSQL("Insert into vendedores values('"
                + ven.getRutVendedor() + "','"
                + ven.getNombbreVendedor() + "',"
                + ven.getComisionVendedor() + ",0)");
        System.out.println("Insert into vendedores values('"
                + ven.getRutVendedor() + "','"
                + ven.getNombbreVendedor() + "',"
                + ven.getComisionVendedor() + ",0)");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();
    }
        public boolean existeRutVend(String rut) {
        this.configurarConexion();
        boolean siNo = false;
        cnn.setSenteciaSQL("select * from vendedores");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            siNo = true;
            while (cnn.getRst().next()) {
                if (cnn.getRst().getString("rutVendedor").equalsIgnoreCase(rut)) {
                    siNo = false;
                }
            }
            cnn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return siNo;
    }

        public ArrayList rutVendedores(){
        this.configurarConexion();
        ArrayList lista=new ArrayList();
        cnn.setSenteciaSQL("SELECT rutVendedor FROM Vendedores");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Vendedor ven=new Vendedor();
                ven.setRutVendedor(cnn.getRst().getString("rutVendedor"));
                lista.add(ven);
            }
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

        public ArrayList getVendedores() {
        this.configurarConexion();
        ArrayList lista = new ArrayList();
        cnn.setSenteciaSQL("Select * from Vendedores ORDER BY rutVendedor");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Vendedor ven=new Vendedor();
                ven.setRutVendedor(cnn.getRst().getString("rutVendedor"));
                ven.setNombbreVendedor(cnn.getRst().getString("nombreVendedor"));
                ven.setComisionVendedor(cnn.getRst().getFloat("comisionVendedor"));
                ven.setTotalVentasVendedor(cnn.getRst().getDouble("totalVentasVendedor"));
                lista.add(ven);
            }
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    public String getNomVendedor(String rut) {
        this.configurarConexion();
        String nombre ="";
        cnn.setSenteciaSQL("Select nombreVendedor from vendedores where rutVendedor = '"+rut+"'");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            if (cnn.getRst().next()) {

                nombre = cnn.getRst().getString("nombreVendedor");

            }
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;

    }

    public double getVentasVendedor(String rut) {
                this.configurarConexion();
        double ventasVendedor = 0;
        cnn.setSenteciaSQL("Select totalVentasVendedor from vendedores where rutVendedor= '"+rut+"'");
        cnn.setEsSelect(true);
        cnn.conectar();
        try {
            if (cnn.getRst().next()) {
                ventasVendedor = cnn.getRst().getInt("totalVentasVendedor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ventasVendedor;
    }

    public void editVentasVend(String rut,double nuevoTotalVentas) {
                this.configurarConexion();
        cnn.setSenteciaSQL("update vendedores set "
                + " totalVentasVendedor = " + nuevoTotalVentas
                + " where rutVendedor = '" + rut + "'");
        cnn.setEsSelect(false);
        cnn.conectar();
        cnn.cerrarConexion();

    }
}




