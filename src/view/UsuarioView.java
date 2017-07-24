
package view;

import dao.UsuarioDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.UsuarioM;
import util.LimiteDigitos;


public class UsuarioView extends javax.swing.JInternalFrame {
    UsuarioM usuarioM;
    List<UsuarioM> listaUsuario;
   
    public UsuarioView() {
        listaUsuario = new ArrayList<>();
        initComponents();
        this.setVisible(true);
        atualizaTabelaUsuario();
        tfdNome.setDocument(new LimiteDigitos(90));
        tfdContato.setDocument(new LimiteDigitos(64));
        tfdUsuario.setDocument(new LimiteDigitos(20));
        tfdSenha.setDocument(new LimiteDigitos(20));
        tfdConfirmaSenha.setDocument(new LimiteDigitos(20));

    }
    
    
     public void atualizaTabelaUsuario() {

        try {
            // REMOVE DA LISTA OS USUARIOS OCULTOS CONVIDADO CONVIDADO, A A, ROOT ROOT.
            listaUsuario = UsuarioDAO.listaTodos(); 
            
            UsuarioM usuario0 = listaUsuario.get(0);
            UsuarioM usuario1 = listaUsuario.get(1);
            UsuarioM usuario2 = listaUsuario.get(2);
            listaUsuario.remove(usuario1);
            listaUsuario.remove(usuario2);
            listaUsuario.remove(usuario0);
            
                
        } catch (SQLException ex){
            Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dados[][] = new String[listaUsuario.size()][4];
        int i = 0;
        for (UsuarioM usuario : listaUsuario) {
                    dados[i][0] = String.valueOf(usuario.getId());
                    dados[i][1] = usuario.getNome();
                    dados[i][2] = usuario.getUsuario();
                    dados[i][3] = usuario.getContato();
                    i++;
        }
        String tituloColuna[] = {"ID", "Nome", "Usuario", "Contato"};
        
        DefaultTableModel tabelaUsuario = new DefaultTableModel();
        tabelaUsuario.setDataVector(dados, tituloColuna);
        tbeUsuario.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                  false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbeUsuario.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbeUsuario.getColumnModel().getColumn(1).setPreferredWidth(300);
        tbeUsuario.getColumnModel().getColumn(2).setPreferredWidth(150);
        tbeUsuario.getColumnModel().getColumn(3).setPreferredWidth(300);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tbeUsuario.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tbeUsuario.setRowHeight(25);
        tbeUsuario.updateUI();

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbeUsuario = new javax.swing.JTable();
        pnlDadosUsuario = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfdContato = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfdId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfdUsuario = new javax.swing.JTextField();
        tfdConfirmaSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        tfdSenha = new javax.swing.JPasswordField();

        setClosable(true);
        setResizable(true);
        setTitle("Cadastrar Usuário");
        setPreferredSize(new java.awt.Dimension(1050, 455));

        btnNovo.setText("Novo");
        btnNovo.setPreferredSize(new java.awt.Dimension(75, 23));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.setPreferredSize(new java.awt.Dimension(75, 23));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.setPreferredSize(new java.awt.Dimension(75, 23));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.setPreferredSize(new java.awt.Dimension(75, 23));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setMaximumSize(new java.awt.Dimension(65, 23));
        btnCancelar.setMinimumSize(new java.awt.Dimension(65, 23));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tbeUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbeUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbeUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbeUsuario);

        pnlDadosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do usuário"));
        pnlDadosUsuario.setToolTipText("");

        jLabel6.setText("Contato");

        tfdContato.setEnabled(false);

        jLabel1.setText("ID");

        tfdId.setEditable(false);
        tfdId.setEnabled(false);

        jLabel2.setText("Nome");

        tfdNome.setEnabled(false);

        jLabel5.setText("Confirmar senha");

        jLabel3.setText("Nome de usuário");

        tfdUsuario.setEnabled(false);

        tfdConfirmaSenha.setEnabled(false);
        tfdConfirmaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdConfirmaSenhaActionPerformed(evt);
            }
        });

        jLabel4.setText("Senha");

        tfdSenha.setEnabled(false);

        javax.swing.GroupLayout pnlDadosUsuarioLayout = new javax.swing.GroupLayout(pnlDadosUsuario);
        pnlDadosUsuario.setLayout(pnlDadosUsuarioLayout);
        pnlDadosUsuarioLayout.setHorizontalGroup(
            pnlDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdContato, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(tfdUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(tfdSenha)
                    .addComponent(tfdConfirmaSenha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        pnlDadosUsuarioLayout.setVerticalGroup(
            pnlDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDadosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDadosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
       limpaCamposUsuario();
       preparaNovo();
       ativaCampos();
       tfdNome.requestFocusInWindow();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
         if (tfdNome.getText().isEmpty() || tfdContato.getText().isEmpty() || tfdUsuario.getText().isEmpty() || tfdSenha.getText().isEmpty() || tfdConfirmaSenha.getText().isEmpty()) {
             
            JOptionPane.showMessageDialog(null, "Prencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            tfdNome.requestFocusInWindow();
        } else if (tfdId.getText().isEmpty()){
            if(tfdSenha.getText().equals(tfdConfirmaSenha.getText())){
                
                usuarioM = new UsuarioM();
                usuarioM.setNome(tfdNome.getText());
                usuarioM.setContato(tfdContato.getText());
                usuarioM.setUsuario(tfdUsuario.getText());
                usuarioM.setSenha(tfdSenha.getText());
                usuarioM.setAdmin(true);
                try {
                    UsuarioDAO.salvar(usuarioM);
                    JOptionPane.showMessageDialog(null, "Usuario Gravado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabelaUsuario();
                    limpaCamposUsuario();
                    preparaSalvareCancelar();
                    desativaCampos();
                  

                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
                 if (ex.getErrorCode() == 1062) {
                        JOptionPane.showMessageDialog(null, "Usuario já existente.", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Senhas não coincidem", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        }
         else{   if(tfdSenha.getText().equals(tfdConfirmaSenha.getText())){         
                usuarioM = new UsuarioM();
                usuarioM.setId(Integer.parseInt(tfdId.getText()));
                usuarioM.setNome(tfdNome.getText());
                usuarioM.setContato(tfdContato.getText());              
                usuarioM.setUsuario(tfdUsuario.getText());
                usuarioM.setSenha(tfdSenha.getText());
                usuarioM.setAdmin(isIcon);
        
                try {
                    UsuarioDAO.alterar(usuarioM);
                    JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabelaUsuario();
                    preparaSalvareCancelar();
                    desativaCampos();
                    
                    
                } catch (SQLException ex) {
                    if (ex.getErrorCode() == 1062) {
                        JOptionPane.showMessageDialog(null, "Usuário com nome já existente.", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
            }

        }else{
                JOptionPane.showMessageDialog(null, "Senhas não coincidem", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        }   
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         if (tfdId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um usuario.", "Erro", JOptionPane.WARNING_MESSAGE);
        } else {
            usuarioM = new UsuarioM();
            usuarioM.setId(Integer.parseInt(tfdId.getText()));
            int confirma = JOptionPane.showConfirmDialog(null, "Deseja Excluir: " + tfdNome.getText() + "?");
            if (confirma == 0) {
                try {
                    UsuarioDAO.excluir(usuarioM);
                    atualizaTabelaUsuario();
                    limpaCamposUsuario();

                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
        limpaCamposUsuario();
        atualizaTabelaUsuario();
        preparaExcluir();
                                              

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        String ConfirmarAlt = JOptionPane.showInputDialog(null,"Digite sua senha:");
        String senhaAlt = tfdSenha.getText();
        if(ConfirmarAlt.equals(senhaAlt)){
            preparaAlterar();
            ativaCampos();
        }else{
            JOptionPane.showMessageDialog(null, "Senha Não Confere.");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCamposUsuario();
        preparaSalvareCancelar();
        desativaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tfdConfirmaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdConfirmaSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdConfirmaSenhaActionPerformed

    private void tbeUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbeUsuarioMouseClicked

        
        tfdNome.setText(tbeUsuario.getValueAt(tbeUsuario.getSelectedRow(), 1).toString());
        tfdUsuario.setText(tbeUsuario.getValueAt(tbeUsuario.getSelectedRow(), 2).toString());
        tfdContato.setText(tbeUsuario.getValueAt(tbeUsuario.getSelectedRow(), 3).toString());
        
        
        // Bloco senha para pegar a senha direto do banco
        tfdId.setText(tbeUsuario.getValueAt(tbeUsuario.getSelectedRow(), 0).toString());
        try {
        usuarioM = UsuarioDAO.BuscaPorId(Integer.parseInt(tfdId.getText()));

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
        tfdSenha.setText(usuarioM.getSenha());
        tfdConfirmaSenha.setText(usuarioM.getSenha());
        // Fim bloco senha
        
       preparaSelecaoTabela();
    }//GEN-LAST:event_tbeUsuarioMouseClicked

            // INÍCIO MÉTODOS DE CONTROLE DE BOTÕES
    
    public void preparaSalvareCancelar() {
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        tbeUsuario.setEnabled(true);
    }
    
    public void limpaCamposUsuario() {
        
        tfdId.setText("");
        tfdNome.setText("");
        tfdContato.setText("");
        tfdUsuario.setText("");        
        tfdSenha.setText("");       
        tfdConfirmaSenha.setText("");  

    }
    
    public void ativaCampos() {
        tfdNome.setEnabled(true);
        tfdContato.setEnabled(true);
        tfdUsuario.setEnabled(true);   
        tfdSenha.setEnabled(true);    
        tfdConfirmaSenha.setEnabled(true);
       
    }
    
    public void desativaCampos(){
        tfdId.setText("");
        tfdId.setEnabled(false);
        tfdId.setEditable(false);
        tfdUsuario.setText("");
        tfdUsuario.setEnabled(false);
        tfdSenha.setText("");
        tfdSenha.setEnabled(false);
        tfdConfirmaSenha.setText("");
        tfdConfirmaSenha.setEnabled(false);
        tfdNome.setText("");
        tfdNome.setEnabled(false);
        tfdContato.setText("");
        tfdContato.setEnabled(false);

    } 
   
    public void preparaNovo() {
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        tbeUsuario.setEnabled(false);
        tbeUsuario.clearSelection();
    }
    public void preparaAlterar() {
        btnNovo.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        tbeUsuario.setEnabled(false);
        tbeUsuario.clearSelection();
    }
    
    public void preparaExcluir() {
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
    }
    
    public void preparaSelecaoTabela(){
        btnNovo.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnAlterar.setEnabled(true);
    }
    
    // FIM MÉTODOS DE CONTROLE DE BOTÕES

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlDadosUsuario;
    private javax.swing.JTable tbeUsuario;
    private javax.swing.JPasswordField tfdConfirmaSenha;
    private javax.swing.JTextField tfdContato;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JPasswordField tfdSenha;
    private javax.swing.JTextField tfdUsuario;
    // End of variables declaration//GEN-END:variables
}
