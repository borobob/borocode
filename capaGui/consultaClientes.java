/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * consultaClientes.java
 *
 * Created on 09-may-2010, 21:25:51
 */
package capaGui;

import capaDatos.Clientes;
import capaNegocio.negocio;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kamalolz
 */
public class consultaClientes extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();

    public consultaClientes() {
        initComponents();
        String columnas[] = {"Rut", "Nombre", "Domicilio", "Comuna", "Ciudad", "Fono",
            "E-Mail", "Lugar de Trabajo", "Fecha de Apertura", "Cupo"};
        dtm.setColumnIdentifiers(columnas);
        this.Tabla1.setModel(dtm);
        this.setLocationRelativeTo(null);
        this.llenar();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta Clientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Tabla1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new consultaClientes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void llenar() {
        negocio neg = new negocio();
        Iterator it = neg.getClientes().iterator();
        while (it.hasNext()) {
            Clientes clie = (Clientes) it.next();
            String filas[] = {clie.getRut_cli() + "-" + clie.getDigito_cli(),
                clie.getNombre_cli(),
                clie.getDomicilio(),
                clie.getComuna_cli(),
                clie.getCiudad_cli(),
                clie.getFonos_cli(),
                clie.getEmail_cli(),
                clie.getLugarTrabajo_cli(),
                date2string(clie.getFechApe_cli()),
                ""+clie.getCupo_cli()};
            dtm.addRow(filas);
        }
        
    }
        public String date2string(Date fecha) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(fecha);
    }
}
