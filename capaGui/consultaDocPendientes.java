/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * consultaDocPendientes.java
 *
 * Created on 09-may-2010, 0:00:08
 */
package capaGui;

import capaDatos.DocuPendientes;
import capaNegocio.negocio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kamalolz
 */
public class consultaDocPendientes extends javax.swing.JFrame {
    DefaultTableModel dtm = new DefaultTableModel();

    public consultaDocPendientes() {
        initComponents();
        String columas[]={"Rut","Nombre","Tipo de Documento"
                ,"Numero de Documento Pendiente","Monto Pendiente","Abonos",
                "Fecha del Ultimo Pago"};
        dtm.setColumnIdentifiers(columas);
        this.table1.setModel(dtm);
        this.setLocationRelativeTo(null);
        this.mostrar();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documentos Pendientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new consultaDocPendientes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
    private Connection cnn;
    private Statement stm;
    private ResultSet rst;

    public void mostrar() {
        negocio neg = new negocio();
        Iterator it = neg.getDocuPendientes().iterator();
        while (it.hasNext()) {
            DocuPendientes docu = (DocuPendientes) it.next();
            String filas[]={
                docu.getRut_docu() + "-" + docu.getDigito_docu(),
                    docu.getNomCli_docu(),
                    docu.getTipoDoc_docu(),
                    ""+docu.getNumDoc_docu(),
                    ""+docu.getMontoPen_docu(),
                    ""+docu.getAbonos_docu(),
                    date2string(docu.getFechUltimo_docu())};
            dtm.addRow(filas);
        }
    }
     public String date2string(Date fecha) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(fecha);
    }
}