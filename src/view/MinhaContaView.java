
package view;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.UsuarioM;
import util.LimiteDigitos;



public class MinhaContaView extends javax.swing.JInternalFrame {

   public UsuarioM usuario = new UsuarioM();
    public MinhaContaView(UsuarioM usuario) {
        initComponents();
        this.setVisible(true);
        this.usuario = usuario;
        
     tfdNome.setDocument(new LimiteDigitos(90));
    tfdContato.setDocument(new LimiteDigitos(64));
    tfdUsuario.setDocument(new LimiteDigitos(20));
    tfdSenha.setDocument(new LimiteDigitos(20));
    
    iniciaUsuario(usuario);
    }
  

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlDetalhes = new javax.swing.JPanel();
        tfdContato = new javax.swing.JTextField();
        tfdId = new javax.swing.JTextField();
        tfdUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfdSenha = new javax.swing.JPasswordField();
        tfdNome = new javax.swing.JTextField();
        tfdConfirmaSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTipoDeConta = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Minha Conta");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setPreferredSize(new java.awt.Dimension(78, 23));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        pnlDetalhes.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes da Conta"));

        tfdContato.setEnabled(false);
        tfdContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdContatoActionPerformed(evt);
            }
        });

        tfdId.setEnabled(false);

        tfdUsuario.setEnabled(false);

        jLabel4.setText("Nome");

        tfdSenha.setEnabled(false);

        tfdNome.setEnabled(false);

        tfdConfirmaSenha.setEnabled(false);

        jLabel5.setText("Contato");

        jLabel6.setText("Usuário");

        jLabel7.setText("Senha");

        jLabel8.setText("Confirma Senha");

        jLabel3.setText("ID");

        jLabel2.setText("Tipo de Conta:");

        lblTipoDeConta.setText("TipoDeConta");

        javax.swing.GroupLayout pnlDetalhesLayout = new javax.swing.GroupLayout(pnlDetalhes);
        pnlDetalhes.setLayout(pnlDetalhesLayout);
        pnlDetalhesLayout.setHorizontalGroup(
            pnlDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdNome)
                    .addComponent(tfdContato)
                    .addComponent(tfdUsuario)
                    .addComponent(tfdSenha)
                    .addComponent(tfdConfirmaSenha)
                    .addGroup(pnlDetalhesLayout.createSequentialGroup()
                        .addGroup(pnlDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDetalhesLayout.createSequentialGroup()
                        .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipoDeConta)
                        .addGap(24, 24, 24)))
                .addGap(6, 6, 6))
        );
        pnlDetalhesLayout.setVerticalGroup(
            pnlDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lblTipoDeConta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
     if ( tfdNome.getText().isEmpty() || tfdContato.getText().isEmpty() || tfdUsuario.getText().isEmpty() || tfdSenha.getText().isEmpty() || tfdConfirmaSenha.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Prencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            tfdNome.requestFocusInWindow();
        }else {
             if(tfdSenha.getText().equals(tfdConfirmaSenha.getText())){
                
                usuario.setNome(tfdNome.getText());
                usuario.setContato(tfdContato.getText());
                usuario.setUsuario(tfdUsuario.getText());
                usuario.setSenha(tfdSenha.getText());
                try {
                    usuarioDAO.alterar(usuario);
                    JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    desativaCampos();
                } catch (SQLException ex) {
                          if (ex.getErrorCode() == 1062) {
                        JOptionPane.showMessageDialog(null, "Usuario com nome já existente.", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
            }

        }else{
                 JOptionPane.showMessageDialog(null, "Senhas não coincidem.", "Erro", JOptionPane.WARNING_MESSAGE);
             }
         }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        String ConfirmarAlt = JOptionPane.showInputDialog(null,"Digite sua senha:");
        String senhaAlt = tfdSenha.getText();
        if(ConfirmarAlt.equals(senhaAlt)){
           preparaSalvar();
           ativaCampos();
        }else{
           JOptionPane.showMessageDialog(null, "Senha Não Confere.");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
     iniciaUsuario(usuario); //quando clica cancelar volta as informações iniciais
        desativaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tfdContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdContatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdContatoActionPerformed

     public void iniciaUsuario(UsuarioM usuario){
       
       tfdId.setText(Integer.toString(usuario.getId()));
       tfdNome.setText(usuario.getNome());
       tfdContato.setText(usuario.getContato());
       tfdUsuario.setText(usuario.getUsuario());
       tfdSenha.setText(usuario.getSenha());
       tfdConfirmaSenha.setText(usuario.getSenha());
        if(usuario.isAdmin() == true){
        lblTipoDeConta.setText("Administrador");
        }else{
        lblTipoDeConta.setText("Convidado");
        }
      
    }

    
     
    public void desativaCampos(){

        tfdNome.setEnabled(false);
        tfdContato.setEnabled(false);
        tfdUsuario.setEnabled(false);
        tfdSenha.setEnabled(false);
        tfdConfirmaSenha.setEnabled(false);
        
       btnAlterar.setEnabled(true);
       btnSalvar.setEnabled(false);
       btnCancelar.setEnabled(false);
    }
    
    public void ativaCampos(){
        tfdNome.setEnabled(true);
        tfdContato.setEnabled(true);
        tfdUsuario.setEnabled(true);
        tfdSenha.setEnabled(true);
        tfdConfirmaSenha.setEnabled(true);
    }
    public void preparaSalvar(){
        btnAlterar.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblTipoDeConta;
    private javax.swing.JPanel pnlDetalhes;
    private javax.swing.JPasswordField tfdConfirmaSenha;
    private javax.swing.JTextField tfdContato;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JPasswordField tfdSenha;
    private javax.swing.JTextField tfdUsuario;
    // End of variables declaration//GEN-END:variables
}
