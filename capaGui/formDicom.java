/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * formDicom.java
 *
 * Created on 11-05-2010, 02:16:31 PM
 */

package capaGui;

import capaDatos.DocuPendientes;
import capaNegocio.negocio;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Alumno
 */
public class formDicom extends javax.swing.JFrame {

    /** Creates new form formDicom */
    public formDicom() {
        initComponents();
        this.revisarDeudores();
        this.setLocationRelativeTo(null);
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
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
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
                new formDicom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    public void revisarDeudores() {
        Date hoy = Calendar.getInstance().getTime();
        negocio neg = new negocio();
        Iterator it = neg.getDocuPendientes().iterator();

        while (it.hasNext()) {
            DocuPendientes docu = (DocuPendientes) it.next();
            if (docu.getFechUltimo_docu().before(hoy)) {
                this.jTextArea1.append("Numero de Documento: " + docu.getNumDoc_docu() + "\n"
                        + "Numero de boleta: " + docu.getDocu_docu() + "\n"
                        + "Fecha vencimiento: " + neg.date2string(docu.getFechUltimo_docu()) + "\n"
                        + "Rut: " + docu.getRut_docu() + "-" + docu.getDigito_docu() + "\n"
                        + "\n=====================\n");
            }
        }
    }
}
