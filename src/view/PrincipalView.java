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
import javax.swing.plaf.basic.BasicMenuItemUI;
import javax.swing.plaf.basic.BasicMenuUI;
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
             mnuComercio.setEnabled(false);
             pnlPrincipal.removeAll();
             pnlPrincipal.updateUI();
        }
        //icone da barra superior
        URL url = this.getClass().getResource("/view/icones/icon.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
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
        mmiFuncionario = new javax.swing.JMenuItem();
        mniDepartamento = new javax.swing.JMenuItem();
        mnuComercio = new javax.swing.JMenu();
        mnuConsulta = new javax.swing.JMenu();
        mniPesquisaComercio = new javax.swing.JMenuItem();
        mniPesquisaFuncionario = new javax.swing.JMenuItem();
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

        pnlPrincipal.setBackground(new java.awt.Color(249, 249, 249));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1275, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        jMenuBar2.setBackground(new java.awt.Color(226, 226, 226));
        jMenuBar2.setBorderPainted(false);
        jMenuBar2.setPreferredSize(new java.awt.Dimension(56, 70));

        mnuArquivos.setBackground(new java.awt.Color(40, 102, 227));
        mnuArquivos.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 9, 0, 9));
        mnuArquivos.setForeground(new java.awt.Color(34, 34, 34));
        mnuArquivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/Icon-Arquivo.png"))); // NOI18N
        mnuArquivos.setText("Arquivos");
        mnuArquivos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnuArquivos.setHideActionText(true);

        mmiFuncionario.setBackground(new java.awt.Color(242, 242, 242));
        mmiFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mmiFuncionario.setForeground(new java.awt.Color(34, 34, 34));
        mmiFuncionario.setText("Funcionários");
        mmiFuncionario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 9, 1, 1));
        mmiFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mmiFuncionario.setPreferredSize(new java.awt.Dimension(141, 26));
        mmiFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmiFuncionarioActionPerformed(evt);
            }
        });
        mnuArquivos.add(mmiFuncionario);

        mniDepartamento.setBackground(new java.awt.Color(242, 242, 242));
        mniDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mniDepartamento.setForeground(new java.awt.Color(34, 34, 34));
        mniDepartamento.setText("Setores");
        mniDepartamento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 9, 1, 1));
        mniDepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniDepartamento.setPreferredSize(new java.awt.Dimension(141, 26));
        mniDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDepartamentoActionPerformed(evt);
            }
        });
        mnuArquivos.add(mniDepartamento);

        jMenuBar2.add(mnuArquivos);

        mnuComercio.setBackground(new java.awt.Color(40, 102, 227));
        mnuComercio.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 9, 0, 9));
        mnuComercio.setForeground(new java.awt.Color(34, 34, 34));
        mnuComercio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/Icon-Comercio.png"))); // NOI18N
        mnuComercio.setText("Comércio");
        mnuComercio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuComercio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnuComercio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuComercioMouseClicked(evt);
            }
        });
        jMenuBar2.add(mnuComercio);

        mnuConsulta.setBackground(new java.awt.Color(40, 102, 227));
        mnuConsulta.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 9, 0, 9));
        mnuConsulta.setForeground(new java.awt.Color(34, 34, 34));
        mnuConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/Icon-Consulta.png"))); // NOI18N
        mnuConsulta.setText("Consultas");
        mnuConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnuConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuConsultaMouseClicked(evt);
            }
        });

        mniPesquisaComercio.setBackground(new java.awt.Color(242, 242, 242));
        mniPesquisaComercio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mniPesquisaComercio.setForeground(new java.awt.Color(34, 34, 34));
        mniPesquisaComercio.setText("Comércios");
        mniPesquisaComercio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 9, 1, 1));
        mniPesquisaComercio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniPesquisaComercio.setPreferredSize(new java.awt.Dimension(147, 26));
        mniPesquisaComercio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPesquisaComercioActionPerformed(evt);
            }
        });
        mnuConsulta.add(mniPesquisaComercio);

        mniPesquisaFuncionario.setBackground(new java.awt.Color(242, 242, 242));
        mniPesquisaFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mniPesquisaFuncionario.setForeground(new java.awt.Color(34, 34, 34));
        mniPesquisaFuncionario.setText("Funcionários");
        mniPesquisaFuncionario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 9, 1, 1));
        mniPesquisaFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniPesquisaFuncionario.setPreferredSize(new java.awt.Dimension(147, 26));
        mniPesquisaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPesquisaFuncionarioActionPerformed(evt);
            }
        });
        mnuConsulta.add(mniPesquisaFuncionario);

        jMenuBar2.add(mnuConsulta);

        mnuRelatorio.setBackground(new java.awt.Color(40, 102, 227));
        mnuRelatorio.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 9, 0, 9));
        mnuRelatorio.setForeground(new java.awt.Color(34, 34, 34));
        mnuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/Icon-Relatório.png"))); // NOI18N
        mnuRelatorio.setText("Relatório");
        mnuRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnuRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuRelatorioMouseClicked(evt);
            }
        });
        jMenuBar2.add(mnuRelatorio);

        mnuUsuarios.setBackground(new java.awt.Color(40, 102, 227));
        mnuUsuarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 9, 0, 9));
        mnuUsuarios.setForeground(new java.awt.Color(34, 34, 34));
        mnuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/Icon-Usuário.png"))); // NOI18N
        mnuUsuarios.setText("Usuários");
        mnuUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        mniGerenciarUsuarios.setBackground(new java.awt.Color(242, 242, 242));
        mniGerenciarUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mniGerenciarUsuarios.setForeground(new java.awt.Color(34, 34, 34));
        mniGerenciarUsuarios.setText("Gerenciar usários");
        mniGerenciarUsuarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 1));
        mniGerenciarUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniGerenciarUsuarios.setPreferredSize(new java.awt.Dimension(139, 26));
        mniGerenciarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGerenciarUsuariosActionPerformed(evt);
            }
        });
        mnuUsuarios.add(mniGerenciarUsuarios);

        mniMinhaConta.setBackground(new java.awt.Color(242, 242, 242));
        mniMinhaConta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mniMinhaConta.setForeground(new java.awt.Color(34, 34, 34));
        mniMinhaConta.setText("Minha conta");
        mniMinhaConta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 1));
        mniMinhaConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniMinhaConta.setPreferredSize(new java.awt.Dimension(139, 26));
        mniMinhaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniMinhaContaActionPerformed(evt);
            }
        });
        mnuUsuarios.add(mniMinhaConta);

        jMenuBar2.add(mnuUsuarios);

        mnuSobre.setBackground(new java.awt.Color(40, 102, 227));
        mnuSobre.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 9, 0, 9));
        mnuSobre.setForeground(new java.awt.Color(34, 34, 34));
        mnuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/Icon-Sobre.png"))); // NOI18N
        mnuSobre.setText("Sobre");
        mnuSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuSobre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSobreMouseClicked(evt);
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

    }//GEN-LAST:event_mnuConsultaMouseClicked

    private void mniGerenciarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGerenciarUsuariosActionPerformed
        
        if(usuarioAtivo.isAdmin() == true)
        {
            UsuarioView usuario = new UsuarioView();
            pnlPrincipal.removeAll();
            pnlPrincipal.add(usuario);
            pnlPrincipal.updateUI();
        }
        
    }//GEN-LAST:event_mniGerenciarUsuariosActionPerformed

    private void mniMinhaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniMinhaContaActionPerformed
        
        if(usuarioAtivo.isAdmin() == true)
        {
            MinhaContaView minhaconta = new MinhaContaView(usuarioAtivo);
            pnlPrincipal.removeAll();
            pnlPrincipal.add(minhaconta);
            pnlPrincipal.updateUI();
        }
        
    }//GEN-LAST:event_mniMinhaContaActionPerformed

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

    private void mniPesquisaComercioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPesquisaComercioActionPerformed
        ConsultaComercioView pesquisacomercio = new ConsultaComercioView();
        pnlPrincipal.removeAll();
        pnlPrincipal.add(pesquisacomercio);
        pnlPrincipal.updateUI();
    }//GEN-LAST:event_mniPesquisaComercioActionPerformed

    private void mnuComercioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuComercioMouseClicked
            ComercioView comercio = new ComercioView();
            pnlPrincipal.removeAll();
            pnlPrincipal.add(comercio);
            pnlPrincipal.updateUI();
            comercio.setLocation(pnlPrincipal.getWidth()/2 - comercio.getWidth()/2,pnlPrincipal.getHeight()/2 - comercio.getHeight()/2);
    }//GEN-LAST:event_mnuComercioMouseClicked

    private void mniPesquisaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPesquisaFuncionarioActionPerformed

        if(usuarioAtivo.isAdmin() == true)
        {
            ConsultaView pesquisa = new ConsultaView();
            pnlPrincipal.removeAll();
            pnlPrincipal.add(pesquisa);
            pnlPrincipal.updateUI();

        }else
        {
            
            ConsultaConvidadoView pesquisaConvidado = new ConsultaConvidadoView();
            pnlPrincipal.add(pesquisaConvidado);
            pesquisaConvidado.setVisible(true);
            pesquisaConvidado.setLocation(pnlPrincipal.getWidth()/2 - pesquisaConvidado.getWidth()/2,pnlPrincipal.getHeight()/2 - pesquisaConvidado.getHeight()/2);
            
            pnlPrincipal.removeAll();
            pnlPrincipal.add(pesquisaConvidado);
            pnlPrincipal.updateUI();
            
        }
    }//GEN-LAST:event_mniPesquisaFuncionarioActionPerformed




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
    private javax.swing.JMenuItem mniPesquisaComercio;
    private javax.swing.JMenuItem mniPesquisaFuncionario;
    private javax.swing.JMenu mnuArquivos;
    private javax.swing.JMenu mnuComercio;
    private javax.swing.JMenu mnuConsulta;
    private javax.swing.JMenu mnuRelatorio;
    private javax.swing.JMenu mnuSobre;
    private javax.swing.JMenu mnuUsuarios;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
