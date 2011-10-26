/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package capaConexion;

/**
 *
 * @author Alumno
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexion {
    private String driver;
    private String nombreBaseDeDatos;
    private String user;
    private String pass;
    private String senteciaSQL;
    private String nombreTabla;
    private boolean esSelect;
    //API JDVC
    private Connection cnn;
    private Statement stm;
    private ResultSet rst;

    public Conexion(String driver, String nombreBaseDeDatos, String user, String pass, String senteciaSQL, String nombreTabla, boolean esSelect) {
        this.driver = driver;
        this.nombreBaseDeDatos = nombreBaseDeDatos;
        this.user = user;
        this.pass = pass;
        this.senteciaSQL = senteciaSQL;
        this.nombreTabla = nombreTabla;
        this.esSelect = esSelect;
    }

    public Conexion() {
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the nombreBaseDeDatos
     */
    public String getNombreBaseDeDatos() {
        return nombreBaseDeDatos;
    }

    /**
     * @param nombreBaseDeDatos the nombreBaseDeDatos to set
     */
    public void setNombreBaseDeDatos(String nombreBaseDeDatos) {
        this.nombreBaseDeDatos = nombreBaseDeDatos;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the senteciaSQL
     */
    public String getSenteciaSQL() {
        return senteciaSQL;
    }

    /**
     * @param senteciaSQL the senteciaSQL to set
     */
    public void setSenteciaSQL(String senteciaSQL) {
        this.senteciaSQL = senteciaSQL;
    }

    /**
     * @return the nombreTabla
     */
    public String getNombreTabla() {
        return nombreTabla;
    }

    /**
     * @param nombreTabla the nombreTabla to set
     */
    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    /**
     * @return the esSelect
     */
    public boolean isEsSelect() {
        return esSelect;
    }

    /**
     * @param esSelect the esSelect to set
     */
    public void setEsSelect(boolean esSelect) {
        this.esSelect = esSelect;
    }

    /**
     * @return the cnn
     */
    public Connection getCnn() {
        return cnn;
    }

    /**
     * @param cnn the cnn to set
     */
    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    /**
     * @return the stm
     */
    public Statement getStm() {
        return stm;
    }

    /**
     * @param stm the stm to set
     */
    public void setStm(Statement stm) {
        this.stm = stm;
    }

    /**
     * @return the rst
     */
    public ResultSet getRst() {
        return rst;
    }

    /**
     * @param rst the rst to set
     */
    public void setRst(ResultSet rst) {
        this.rst = rst;
    }

    public void cerrarConexion() {
        try {
            this.cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void conectar(){
        try {
            Class.forName(this.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        try {
            this.setCnn(DriverManager.getConnection(this.getNombreBaseDeDatos(),
                    this.getUser(), this.getPass()));
            this.setStm(this.getCnn().createStatement());

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(this.isEsSelect()==true){
            try {
                this.setRst(this.getStm().executeQuery(this.getSenteciaSQL()));
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                this.getStm().executeUpdate(this.getSenteciaSQL());
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }







}
