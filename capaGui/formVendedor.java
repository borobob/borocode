/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * formVendedor.java
 *
 * Created on 21-jun-2010, 22:09:09
 */
package capaGui;

import capaDatos.Vendedor;
import capaDatos.validaRut;
import capaNegocio.negocio;
import javax.swing.JOptionPane;

/**
 *
 * @author BORO
 */
public class formVendedor extends javax.swing.JFrame {

    /** Creates new form formVendedor */
    public formVendedor() {
        initComponents();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtRut = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDig = new javax.swing.JTextField();
        cbxComision = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario Vendedor");

        jLabel1.setText("Rut: ");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Comisión: ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capaImagenes/agregar.png"))); // NOI18N
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRutKeyTyped(evt);
            }
        });

        jLabel14.setText("-");

        txtDig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDigKeyTyped(evt);
            }
        });

        cbxComision.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione comis...", "3.5 %", "5.0 %" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDig, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(cbxComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtDig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutKeyTyped

        if (this.txtRut.getText().trim().length() > 7) {
            evt.consume();
        }
        if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
            evt.consume();
        }
}//GEN-LAST:event_txtRutKeyTyped

    private void txtDigKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDigKeyTyped
        if (this.txtDig.getText().trim().length() >= 1) {
            evt.consume();
        }
}//GEN-LAST:event_txtDigKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.txtRut.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Error debe ingresar el rut",
                    "Error de ingreso",
                    JOptionPane.ERROR_MESSAGE);
            this.txtRut.requestFocus();
            return;
        }
        if (this.txtDig.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Error debe ingresar el digito de rut",
                    "Error de ingreso",
                    JOptionPane.ERROR_MESSAGE);
            this.txtDig.requestFocus();
            return;
        }
        if (this.txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Error debe ingresar el nombre",
                    "Error de ingreso",
                    JOptionPane.ERROR_MESSAGE);
            this.txtNombre.requestFocus();
            return;
        }
        if (this.cbxComision.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Error debe ingresar una comisión",
                    "Error de ingreso",
                    JOptionPane.ERROR_MESSAGE);
            this.cbxComision.requestFocus();
            return;
        }

        Vendedor ven = new Vendedor();
        validaRut vRut = new validaRut();
        negocio neg = new negocio();


        if (neg.existeRutVend(this.txtRut.getText() + "-" + this.txtDig.getText())) {
            // TODO agregar cliente
            // TODO se valida rut y si es verdadero ingresa rut y digito
            try {
                if (vRut.validaRut(this.txtRut.getText().trim() + "-" + this.txtDig.getText().trim()) == true) {
                    ven.setRutVendedor(this.txtRut.getText().trim() + "-" + this.txtDig.getText().trim());

                } else {
                    JOptionPane.showMessageDialog(null, "Rut no valido");
                    this.txtRut.requestFocus();
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Eror al escribir el rut", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
                this.txtRut.requestFocus();
                return;
            }
            // fin validar rut
            // continua insertando el resto en clientes
            if (this.cbxComision.getSelectedIndex() == 1) {
                ven.setComisionVendedor((float) 3.5);
            } else {
                if (this.cbxComision.getSelectedIndex() == 2) {
                    ven.setComisionVendedor((float) 5);
                }
            }
            ven.setNombbreVendedor(this.txtNombre.getText());

            neg.addVendedor(ven);

            JOptionPane.showMessageDialog(null, "Se ingreso corectamente\n"
                    + "Cliente: " + this.txtNombre.getText() + "\n"
                    + "Rut: " + this.txtRut.getText() + "-" + this.txtDig.getText());
            this.limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "El rut ya esta ingresado");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new formVendedor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxComision;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDig;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables

    public void limpiar() {
        this.txtDig.setText("");
        this.txtRut.setText("");
        this.txtNombre.setText("");
        this.cbxComision.setSelectedIndex(0);
    }
}
