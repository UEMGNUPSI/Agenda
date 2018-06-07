package view;

import dao.UsuarioDAO;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.UsuarioM;
import util.LimiteDigitos;


public class UsuarioView extends javax.swing.JInternalFrame {
    
    UsuarioM usuarioM = new UsuarioM();
    UsuarioDAO usuarioDAO= new UsuarioDAO();
    List<UsuarioM> listaUsuario = new ArrayList<>();
   
    public UsuarioView() {
        initComponents();
        JConfirmaAdministrador.setSize(471, 350);
        this.setVisible(true);
        atualizaTabelaUsuario();
        tfdId.setVisible(false);
        tfdNome.setDocument(new LimiteDigitos(90));
        tfdContato.setDocument(new LimiteDigitos(64));
        tfdNomeUsuario.setDocument(new LimiteDigitos(20));
        tfdSenha.setDocument(new LimiteDigitos(20));
        tfdConfirmaSenha.setDocument(new LimiteDigitos(20));
        txtusuario.setDocument(new LimiteDigitos(20));
        txtsenha.setDocument(new LimiteDigitos(20));
        btnEntrar.setUI(new BasicButtonUI());
    }
    
    
     public void atualizaTabelaUsuario() {

        try {
            listaUsuario = usuarioDAO.listaTodos(); 
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
        tbeUsuario.getColumnModel().getColumn(0).setMinWidth(0);
        tbeUsuario.getColumnModel().getColumn(0).setMaxWidth(0);
        tbeUsuario.getColumnModel().getColumn(0).setPreferredWidth(0);
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

        JConfirmaAdministrador = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        txtsenha = new javax.swing.JPasswordField();
        txtusuario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
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
        tfdId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfdNomeUsuario = new javax.swing.JTextField();
        tfdConfirmaSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        tfdSenha = new javax.swing.JPasswordField();

        jPanel1.setBackground(new java.awt.Color(244, 244, 244));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel1.setText("Usuário");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel7.setText("Senha");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        btnEntrar.setBackground(new java.awt.Color(165, 214, 168));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(61, 100, 63));
        btnEntrar.setText("Entrar");
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 90, -1));

        txtsenha.setBackground(new java.awt.Color(250, 250, 250));
        txtsenha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtsenha.setForeground(new java.awt.Color(29, 29, 29));
        txtsenha.setToolTipText("Digite sua senha");
        txtsenha.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 226, 226)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        txtsenha.setPreferredSize(new java.awt.Dimension(210, 23));
        txtsenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsenhaKeyPressed(evt);
            }
        });
        jPanel1.add(txtsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 340, 40));

        txtusuario.setBackground(new java.awt.Color(250, 250, 250));
        txtusuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(29, 29, 29));
        txtusuario.setToolTipText("Digite seu usuário");
        txtusuario.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 226, 226)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        txtusuario.setPreferredSize(new java.awt.Dimension(59, 23));
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusuarioKeyPressed(evt);
            }
        });
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 340, 40));

        jPanel2.setBackground(new java.awt.Color(38, 54, 59));
        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(243, 243, 243));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ENTRE COM ADMINISTRADOR");
        jPanel2.add(jLabel8, "card2");

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 60));

        javax.swing.GroupLayout JConfirmaAdministradorLayout = new javax.swing.GroupLayout(JConfirmaAdministrador.getContentPane());
        JConfirmaAdministrador.getContentPane().setLayout(JConfirmaAdministradorLayout);
        JConfirmaAdministradorLayout.setHorizontalGroup(
            JConfirmaAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
            .addGroup(JConfirmaAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JConfirmaAdministradorLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        JConfirmaAdministradorLayout.setVerticalGroup(
            JConfirmaAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
            .addGroup(JConfirmaAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JConfirmaAdministradorLayout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

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

        tfdId.setEditable(false);
        tfdId.setEnabled(false);

        jLabel2.setText("Nome");

        tfdNome.setEnabled(false);

        jLabel5.setText("Confirmar senha");

        jLabel3.setText("Nome de usuário");

        tfdNomeUsuario.setEnabled(false);

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
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdContato, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDadosUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(tfdNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(tfdSenha)
                    .addComponent(tfdConfirmaSenha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        pnlDadosUsuarioLayout.setVerticalGroup(
            pnlDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosUsuarioLayout.createSequentialGroup()
                .addGap(12, 12, 12)
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
                .addGroup(pnlDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDadosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        JConfirmaAdministrador.setVisible(true);
        JConfirmaAdministrador.setLocationRelativeTo(null);
        btnEntrar.setUI(new BasicButtonUI());
        txtusuario.requestFocus();
        JConfirmaAdministrador.setAlwaysOnTop(true);
       
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
         if (tfdNome.getText().isEmpty() || tfdContato.getText().isEmpty() || tfdNomeUsuario.getText().isEmpty() || tfdSenha.getText().isEmpty() || tfdConfirmaSenha.getText().isEmpty()) {
             
            JOptionPane.showMessageDialog(null, "Prencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            tfdNome.requestFocusInWindow();
        } else if (tfdId.getText().isEmpty()){
            if(tfdSenha.getText().equals(tfdConfirmaSenha.getText())){
                
                usuarioM = new UsuarioM();
                usuarioM.setNome(tfdNome.getText());
                usuarioM.setContato(tfdContato.getText());
                usuarioM.setUsuario(tfdNomeUsuario.getText());
                usuarioM.setSenha(tfdSenha.getText());
                usuarioM.setAdmin(true);
                try {
                    usuarioDAO.salvar(usuarioM);
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
                usuarioM.setUsuario(tfdNomeUsuario.getText());
                usuarioM.setSenha(tfdSenha.getText());
                usuarioM.setAdmin(isIcon);
        
                try {
                    usuarioDAO.alterar(usuarioM);
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
                    usuarioDAO.excluir(usuarioM);
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
        tfdNomeUsuario.setText(tbeUsuario.getValueAt(tbeUsuario.getSelectedRow(), 2).toString());
        tfdContato.setText(tbeUsuario.getValueAt(tbeUsuario.getSelectedRow(), 3).toString());
        
        
        // Bloco senha para pegar a senha direto do banco
        tfdId.setText(tbeUsuario.getValueAt(tbeUsuario.getSelectedRow(), 0).toString());
        try {
        usuarioM = usuarioDAO.BuscaPorId(Integer.parseInt(tfdId.getText()));

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
        tfdSenha.setText(usuarioM.getSenha());
        tfdConfirmaSenha.setText(usuarioM.getSenha());
        // Fim bloco senha
        
       preparaSelecaoTabela();
    }//GEN-LAST:event_tbeUsuarioMouseClicked

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        usuarioM = null;
        try {
            if (txtusuario.getText().isEmpty()) {
                //erro.setText("O nome do usuario deve ser preechido");
                JOptionPane.showMessageDialog(null, "O usuário deve ser preenchido", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                txtusuario.requestFocus();

            } else if (txtsenha.getText().isEmpty()) {
                //erro.setText("A senha deve ser preechido");
                //erro.setVisible(true);
                JOptionPane.showMessageDialog(null, "A senha deve ser preenchida", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                txtsenha.requestFocus();
            } else {
                usuarioM = usuarioDAO.validaAdmin(txtusuario.getText(), txtsenha.getText());
                if(usuarioM == null){
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                    txtusuario.setText("");
                    txtsenha.setText("");
                    txtusuario.requestFocus();
                }else{
                    txtusuario.setText("");
                    txtsenha.setText("");
                    limpaCamposUsuario();
                    preparaNovo();
                    ativaCampos();
                    tfdNome.requestFocusInWindow();
                    JConfirmaAdministrador.dispose();
                }

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
            txtusuario.setText("");
            txtsenha.setText("");
            txtusuario.requestFocus();
            ex.printStackTrace();

        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtusuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtsenha.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtusuarioKeyPressed

    private void txtsenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            usuarioM = null;
            try {
                if (txtusuario.getText().isEmpty()) {
                    //erro.setText("O nome do usuario deve ser preechido");
                    JOptionPane.showMessageDialog(null, "O usuário deve ser preenchido", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                    txtusuario.requestFocus();

                } else if (txtsenha.getText().isEmpty()) {
                    //erro.setText("A senha deve ser preechido");
                    //erro.setVisible(true);
                    JOptionPane.showMessageDialog(null, "A senha deve ser preenchida", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                    txtsenha.requestFocus();
                } else {
                    usuarioM = usuarioDAO.validaAdmin(txtusuario.getText(), txtsenha.getText());
                    if(usuarioM == null){
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                        txtusuario.setText("");
                        txtsenha.setText("");
                        txtusuario.requestFocus();
                    }else{
                        txtusuario.setText("");
                        txtsenha.setText("");
                        limpaCamposUsuario();
                        preparaNovo();
                        ativaCampos();
                        tfdNome.requestFocusInWindow();
                        JConfirmaAdministrador.dispose();
                    }

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                txtusuario.setText("");
                txtsenha.setText("");
                txtusuario.requestFocus();
                ex.printStackTrace();

            }
        }
    }//GEN-LAST:event_txtsenhaKeyPressed

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
        tfdNomeUsuario.setText("");        
        tfdSenha.setText("");       
        tfdConfirmaSenha.setText("");  

    }
    
    public void ativaCampos() {
        tfdNome.setEnabled(true);
        tfdContato.setEnabled(true);
        tfdNomeUsuario.setEnabled(true);   
        tfdSenha.setEnabled(true);    
        tfdConfirmaSenha.setEnabled(true);
       
    }
    
    public void desativaCampos(){
        tfdId.setText("");
        tfdId.setEnabled(false);
        tfdId.setEditable(false);
        tfdNomeUsuario.setText("");
        tfdNomeUsuario.setEnabled(false);
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
    private javax.swing.JDialog JConfirmaAdministrador;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlDadosUsuario;
    private javax.swing.JTable tbeUsuario;
    private javax.swing.JPasswordField tfdConfirmaSenha;
    private javax.swing.JTextField tfdContato;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdNomeUsuario;
    private javax.swing.JPasswordField tfdSenha;
    private javax.swing.JPasswordField txtsenha;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
