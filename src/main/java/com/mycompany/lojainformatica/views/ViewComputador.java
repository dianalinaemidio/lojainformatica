
package com.mycompany.lojainformatica.views;

import com.mycompany.lojainformatica.dao.ComputadorDAO;
import com.mycompany.lojainformatica.models.Computador;
import javax.swing.JOptionPane;


public class ViewComputador extends javax.swing.JFrame {
    Computador obj = null;
  
    public ViewComputador() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    
    
    public ViewComputador(Computador objAtualizar) {
        initComponents();
        
        this.obj = objAtualizar;
        
        //Passar valores do objeto para a tela
        lblID.setText( String.valueOf(obj.getId())  );
        txtHd.setText(String.valueOf(obj.getHd()));
        txtProcessor.setText(String.valueOf(obj.getProcessador()));
    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtHd1 = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        hd = new javax.swing.JLabel();
        txtHd = new javax.swing.JTextField();
        processador = new javax.swing.JLabel();
        txtProcessor = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();

        jLabel4.setText("HD:");

        txtHd1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblID.setText("0");

        id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        id.setText("ID:");

        hd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        hd.setText("HD:");

        txtHd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHdActionPerformed(evt);
            }
        });

        processador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        processador.setText("Processador:");

        txtProcessor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(processador, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHd)
                            .addComponent(txtProcessor)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblID)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(lblID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hd)
                    .addComponent(txtProcessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(processador))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    // BOTÃO SALVAR
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
      
        //Resgatar dados da interface e passar para o objeto
            String hd = txtHd.getText();
            String processador = txtProcessor.getText();
      
        //Passei os dados da tela para o objeto
            Computador novoComputador = new Computador(hd, processador);
       
       //Mandar o objeto para a classe DAO
            boolean retorno = ComputadorDAO.salvar(novoComputador);
            
            if(retorno == true){
                JOptionPane.showMessageDialog(rootPane, "Computador registrado com sucesso");
            }else{
                JOptionPane.showMessageDialog(rootPane, "Falha ao registrar o computador");
            }
    }//GEN-LAST:event_btnSalvarActionPerformed

    
    private void txtHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHdActionPerformed

    //BOTÃO CONSULTAR
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // Oculta a tela atual
        this.setVisible(false);

        // Cria uma nova instância da tela `ViewConsulta`
        ViewConsulta viewConsulta = new ViewConsulta();

        // Torna a tela `ViewConsulta` visível
        viewConsulta.setVisible(true);
    }//GEN-LAST:event_btnConsultarActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(ViewComputador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewComputador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewComputador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewComputador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewComputador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel hd;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel processador;
    private javax.swing.JTextField txtHd;
    private javax.swing.JTextField txtHd1;
    private javax.swing.JTextField txtProcessor;
    // End of variables declaration//GEN-END:variables
}
