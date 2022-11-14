/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Metodos.Setters_getters;
import coneccion.Conection;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Emili
 */
public class login_admin extends javax.swing.JFrame {

    /**
     * Creates new form login_admin
     */
    public login_admin() {
        initComponents();
        setResizable(false); 
        setLocationRelativeTo(null);
    }
    
    fondo_panel fondo = new fondo_panel();
    class fondo_panel extends JPanel
    {
        private Image imagen;
        @Override
        public void paint(Graphics g)
        {
           imagen = new ImageIcon("src/main/java/Iconos/Pantalla_inicio.png").getImage();
           g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
           setOpaque(false);
           super.paint(g);
        }       
    }
    
    Conection con = new Conection();
    Gestion ges = new Gestion();
//    Seleccionar_laboratorio seleclab = new Seleccionar_laboratorio();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new fondo_panel();
        btn_ingresar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txt_usuario = new javax.swing.JTextField();
        txt_contra = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ingresar.setBackground(new java.awt.Color(0, 0, 0));
        btn_ingresar.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        btn_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ingresar.setText("INGRESAR");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 270, 40));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));
        jPanel2.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 270, 40));
        jPanel2.add(txt_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 270, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        // TODO add your handling code here:
        String usuario_admin = txt_usuario.getText();
        String contrasena_admin = String.valueOf(txt_contra.getPassword());
        
        Setters_getters.setContra(contrasena_admin);
        Setters_getters.setUsuario(usuario_admin);
        
        con.conectar();
        if (con.ban == true) {
            ges.setVisible(true);
            this.dispose();
            txt_contra.setText("");
            ges.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    setVisible(true);
                }                
                @Override
                public void windowClosed(WindowEvent we) {
                    setVisible(true);
                }                
            });
        } 
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here: REGRESAR A LA VENTANA ALUMNO
//        seleclab.setVisible(true);
//        this.dispose();
//        seleclab.addWindowListener(new WindowAdapter(){
//               @Override
//               public void windowClosing(WindowEvent we){
//                   setVisible(true);
//               }
//               
//               public void windowClosed(WindowEvent we){
//                   setVisible(true);
//               }              
//           });     
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txt_contra;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
