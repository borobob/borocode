/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * consultaVendedor.java
 *
 * Created on 24-jun-2010, 0:39:15
 */

package capaGui;

import capaDatos.Vendedor;
import capaNegocio.negocio;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BORO
 */
public class consultaVendedor extends javax.swing.JFrame {
    DefaultTableModel dtm = new DefaultTableModel();
    /** Creates new form consultaVendedor */
    public consultaVendedor() {
        initComponents();
        GregorianCalendar cal = new GregorianCalendar();
        this.setTitle("Listado de Comisiones por vendedor al " + date2string(cal.getTime()));
                 String columnas[] = {"Rut", "Nombre", "Comisión", "Totál ventas netas",
            "Total comisión a pagar"};
        dtm.setColumnIdentifiers(columnas);
        this.setLocationRelativeTo(null);
        this.jTable1.setModel(dtm);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtTotalVentas = new javax.swing.JTextField();
        txtTotalComi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Totales: ");

        txtTotalVentas.setEditable(false);

        txtTotalComi.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
                .addComponent(txtTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalComi, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalComi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                new consultaVendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtTotalComi;
    private javax.swing.JTextField txtTotalVentas;
    // End of variables declaration//GEN-END:variables
    private void llenar() {
        negocio neg = new negocio();
        double totalVentas = 0;
        double comision = 0;
        Iterator it = neg.getVendedores().iterator();
        while (it.hasNext()) {
            Vendedor ven = (Vendedor) it.next();
           double comi = ven.getComisionVendedor();
           double totalVent = ven.getTotalVentasVendedor();
           double totalComi = (comi/100) * totalVent;
            String filas[] = {ven.getRutVendedor(),
                ven.getNombbreVendedor(),
                "" + comi,"" + totalVent , ""+totalComi};
            dtm.addRow(filas);
            totalVentas = totalVent + totalVentas;
            comision = totalComi + comision;
            this.txtTotalVentas.setText(totalVentas+"");
            this.txtTotalComi.setText(comision+"");
        }
    }
        public String date2string(Date fecha) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(fecha);
    }
}