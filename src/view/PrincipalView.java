package view;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.UsuarioM;

public class PrincipalView extends javax.swing.JFrame {

    UsuarioM usuarioAtivo = new UsuarioM();
 
    public PrincipalView(UsuarioM usuario) {
        initComponents();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.usuarioAtivo = usuario;
        
        
           
           
        if(usuarioAtivo.isAdmin() == false){
             mnuArquivos.setEnabled(false);
             //mnuConsulta.setEnabled(false);
             mnuRelatorio.setEnabled(false);
             mnuUsuarios.setEnabled(false);
             ConsultaConvidadoView consulta = new ConsultaConvidadoView();
             pnlPrincipal.removeAll();
             pnlPrincipal.add(consulta);
             pnlPrincipal.updateUI();
             
        }
        URL url = this.getClass().getResource("/view/icones/icon.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        
        //icone da barra superior
        ImageIcon icone = new ImageIcon("C:/AGENDA/agenda/src/view/icones/icon.png");
        setIconImage(icone.getImage());
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        pnlPrincipal = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        mnuArquivos = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        mmiFuncionario = new javax.swing.JMenuItem();
        mniDepartamento = new javax.swing.JMenuItem();
        mnuConsulta = new javax.swing.JMenu();
        mnuRelatorio = new javax.swing.JMenu();
        mnuUsuarios = new javax.swing.JMenu();
        mniGerenciarUsuarios = new javax.swing.JMenuItem();
        mniMinhaConta = new javax.swing.JMenuItem();
        mnuSobre = new javax.swing.JMenu();

        jMenu5.setText("jMenu5");

        jMenuItem1.setText("jMenuItem1");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        jMenu2.setText("jMenu2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Agenda");

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1275, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        jMenuBar2.setPreferredSize(new java.awt.Dimension(56, 48));

        mnuArquivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/arquivo.png"))); // NOI18N
        mnuArquivos.setText("Arquivos");
        mnuArquivos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnuArquivos.setHideActionText(true);

        jMenuItem4.setText("Comércio");
        mnuArquivos.add(jMenuItem4);

        mmiFuncionario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mmiFuncionario.setText("Funcionários");
        mmiFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmiFuncionarioActionPerformed(evt);
            }
        });
        mnuArquivos.add(mmiFuncionario);

        mniDepartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mniDepartamento.setText("Setores");
        mniDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDepartamentoActionPerformed(evt);
            }
        });
        mnuArquivos.add(mniDepartamento);

        jMenuBar2.add(mnuArquivos);

        mnuConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/consulta.png"))); // NOI18N
        mnuConsulta.setText("Consulta");
        mnuConsulta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnuConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuConsultaMouseClicked(evt);
            }
        });
        jMenuBar2.add(mnuConsulta);

        mnuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/Relatório48x48.png"))); // NOI18N
        mnuRelatorio.setText("Relatorio");
        mnuRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnuRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuRelatorioMouseClicked(evt);
            }
        });
        jMenuBar2.add(mnuRelatorio);

        mnuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/usuário.png"))); // NOI18N
        mnuUsuarios.setText("Usuários");
        mnuUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnuUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuUsuariosMouseClicked(evt);
            }
        });
        mnuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuariosActionPerformed(evt);
            }
        });

        mniGerenciarUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mniGerenciarUsuarios.setText("Gerenciar usários");
        mniGerenciarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mniGerenciarUsuariosMouseClicked(evt);
            }
        });
        mniGerenciarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGerenciarUsuariosActionPerformed(evt);
            }
        });
        mnuUsuarios.add(mniGerenciarUsuarios);

        mniMinhaConta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mniMinhaConta.setText("Minha conta");
        mniMinhaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniMinhaContaActionPerformed(evt);
            }
        });
        mnuUsuarios.add(mniMinhaConta);

        jMenuBar2.add(mnuUsuarios);

        mnuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/sobre.png"))); // NOI18N
        mnuSobre.setText("Sobre");
        mnuSobre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSobreMouseClicked(evt);
            }
        });
        mnuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSobreActionPerformed(evt);
            }
        });
        jMenuBar2.add(mnuSobre);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mmiFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmiFuncionarioActionPerformed
        
        if(usuarioAtivo.isAdmin() == true)
        {
            FuncionarioView contato = new FuncionarioView();
            pnlPrincipal.removeAll();
            pnlPrincipal.add(contato);
            pnlPrincipal.updateUI();
        }
    }//GEN-LAST:event_mmiFuncionarioActionPerformed

    private void mniDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDepartamentoActionPerformed
        
        if(usuarioAtivo.isAdmin() == true)
        {
            SetorView departamento = new SetorView();
            pnlPrincipal.removeAll();
            pnlPrincipal.add(departamento);
            pnlPrincipal.updateUI();
        }
    }//GEN-LAST:event_mniDepartamentoActionPerformed

    private void mnuConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuConsultaMouseClicked
    
        if(usuarioAtivo.isAdmin() == false)
        {
            ConsultaConvidadoView pesquisaConvidado = new ConsultaConvidadoView();
            pnlPrincipal.add(pesquisaConvidado);
            pesquisaConvidado.setVisible(true);
            //pesquisaConvidado.setPosicao();
            
            pnlPrincipal.removeAll();
            pnlPrincipal.add(pesquisaConvidado);
            pnlPrincipal.updateUI();
           
            
        }else
        {
            PesquisaView pesquisa = new PesquisaView();
            pnlPrincipal.removeAll();
            pnlPrincipal.add(pesquisa);
            pnlPrincipal.updateUI();
        }
        
    }//GEN-LAST:event_mnuConsultaMouseClicked

    private void mnuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuariosActionPerformed
    
    }//GEN-LAST:event_mnuUsuariosActionPerformed

    private void mnuUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuUsuariosMouseClicked
    
    }//GEN-LAST:event_mnuUsuariosMouseClicked

    private void mniGerenciarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGerenciarUsuariosActionPerformed
        
        if(usuarioAtivo.isAdmin() == true)
        {
            UsuarioView usuario = new UsuarioView();
            pnlPrincipal.removeAll();
            pnlPrincipal.add(usuario);
            pnlPrincipal.updateUI();
        }
        
    }//GEN-LAST:event_mniGerenciarUsuariosActionPerformed

    private void mniGerenciarUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mniGerenciarUsuariosMouseClicked
    
    }//GEN-LAST:event_mniGerenciarUsuariosMouseClicked

    private void mniMinhaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniMinhaContaActionPerformed
        
        if(usuarioAtivo.isAdmin() == true)
        {
            MinhaContaView minhaconta = new MinhaContaView(usuarioAtivo);
            pnlPrincipal.removeAll();
            pnlPrincipal.add(minhaconta);
            pnlPrincipal.updateUI();
        }
        
    }//GEN-LAST:event_mniMinhaContaActionPerformed

    private void mnuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSobreActionPerformed
        
    }//GEN-LAST:event_mnuSobreActionPerformed

    private void mnuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSobreMouseClicked

        SobreView sobre = new SobreView();
        pnlPrincipal.removeAll();
        pnlPrincipal.add(sobre);
        pnlPrincipal.updateUI();

    }//GEN-LAST:event_mnuSobreMouseClicked

    private void mnuRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuRelatorioMouseClicked
    
        if(usuarioAtivo.isAdmin() == true)
        {
            RelatorioView relatorio = new RelatorioView();
            pnlPrincipal.removeAll();
            pnlPrincipal.add(relatorio);
            pnlPrincipal.updateUI();
        }
    }//GEN-LAST:event_mnuRelatorioMouseClicked




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private javax.swing.JMenuItem mmiFuncionario;
    private javax.swing.JMenuItem mniDepartamento;
    private javax.swing.JMenuItem mniGerenciarUsuarios;
    private javax.swing.JMenuItem mniMinhaConta;
    private javax.swing.JMenu mnuArquivos;
    private javax.swing.JMenu mnuConsulta;
    private javax.swing.JMenu mnuRelatorio;
    private javax.swing.JMenu mnuSobre;
    private javax.swing.JMenu mnuUsuarios;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
