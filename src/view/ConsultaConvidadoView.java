package view;

import dao.FuncionarioDAO;
import dao.SetorDAO;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.FuncionarioM;
import model.SetorM;
import util.LimiteDigitos;

public class ConsultaConvidadoView extends javax.swing.JInternalFrame {

    
    FuncionarioM funcionario;
    
    List<FuncionarioM> listaFuncionario;
    List<SetorM> listaSetor;
    SetorDAO setorDAO;
    FuncionarioDAO funcionarioDAO;
    
    String SetorSelecionado = "";

    public ConsultaConvidadoView() {
        initComponents();
        this.setVisible(true);
        
        this.funcionarioDAO = new FuncionarioDAO();
        this.setorDAO = new SetorDAO();  
        this.listaSetor = new ArrayList<>();
        this.listaFuncionario = new ArrayList<>();
        
        this.setSize( 893, 560);
               
        atualizaTabelaFuncionario();
        txtNome.setDocument(new LimiteDigitos(90));
        txtRamal.setDocument(new LimiteDigitos(11));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbeConsulta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtRamal = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnBusca = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxSetor = new javax.swing.JComboBox<>();

        jPasswordField1.setText("jPasswordField1");

        setClosable(true);
        setTitle("Consulta Convidados");
        setToolTipText("");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tbeConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Departamento", "Ramal", "Dia", "Horário"
            }
        ));
        jScrollPane1.setViewportView(tbeConsulta);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Busca"));
        jPanel1.setPreferredSize(new java.awt.Dimension(861, 78));

        jLabel3.setText("Ramal");

        txtRamal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRamalKeyPressed(evt);
            }
        });

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        jLabel1.setText("Nome");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnBusca.setText("Buscar");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        jLabel4.setText("Setor");

        cbxSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "NUPSI", "Informática", "Recepção", "Coordenação", "Serviços Gerais", "Administração" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtRamal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRamal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBusca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void setPosicao()
    {
        Dimension d;
        d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBuscaActionPerformed
    {//GEN-HEADEREND:event_btnBuscaActionPerformed
        funcionario = new FuncionarioM();
        if(txtNome.getText().length() <= 0 && txtRamal.getText().length() <= 0 && cbxSetor.getSelectedItem().toString() == "Todos")
            atualizaTabelaFuncionario();
        else if(txtNome.getText().length() > 0 || txtRamal.getText().length()>0 || SetorSelecionado != "Todos")
        {     
            try{
                listaFuncionario = FuncionarioDAO.buscaConvidado(txtNome.getText(), txtRamal.getText(), cbxSetor.getSelectedItem().toString());
                
                if(listaFuncionario == null)
                {
                    JOptionPane.showMessageDialog( null, "Nenhum contato encontrado!");
                    atualizaTabelaFuncionario();
                }
                else
                {
                    atualizaTabelaBusca();
                }
                
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog( null, "Erro: "+ex);
            }
        }
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLimparActionPerformed
    {//GEN-HEADEREND:event_btnLimparActionPerformed
        txtNome.setText("");
        txtRamal.setText("");
        cbxSetor.setSelectedItem("Todos");
                
        atualizaTabelaFuncionario();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            funcionario = null;
        funcionario = new FuncionarioM();
        if(txtNome.getText().length() <= 0)
            atualizaTabelaFuncionario();
        else if(txtNome.getText().length() > 0)
        {     
            try{
                listaFuncionario = FuncionarioDAO.buscaConvidado(txtNome.getText(), txtRamal.getText(), cbxSetor.getSelectedItem().toString());
                
                if(listaFuncionario == null)
                {
                    JOptionPane.showMessageDialog( null, "Nenhum contato encontrado!");
                    atualizaTabelaFuncionario();
                }
                else
                {
                    atualizaTabelaBusca();
                }
                
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog( null, "Erro: "+ex);
            }
        }
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtRamalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRamalKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            funcionario = null;
        funcionario = new FuncionarioM();
        if(txtRamal.getText().length() <= 0)
            atualizaTabelaFuncionario();
        else if(txtRamal.getText().length()>0)
        {     
            try{
                listaFuncionario = FuncionarioDAO.buscaConvidado(txtNome.getText(), txtRamal.getText(), cbxSetor.getSelectedItem().toString());
                
                if(listaFuncionario == null)
                {
                    JOptionPane.showMessageDialog( null, "Nenhum contato encontrado!");
                    atualizaTabelaFuncionario();
                }
                else
                {
                    atualizaTabelaBusca();
                }
                
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog( null, "Erro: "+ex);
            }
        }
        }
    }//GEN-LAST:event_txtRamalKeyPressed

    
    public void atualizaTabelaFuncionario(){
        funcionario = new FuncionarioM();
        try {
            listaFuncionario = funcionarioDAO.listaTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
        
        String dados[][] = new String[listaFuncionario.size()][5];
            int i = 0;
            for (FuncionarioM funcionario : listaFuncionario) {
                dados[i][0] = funcionario.getNome();
                dados[i][1] = funcionario.getSetor().getNome();
                dados[i][2] = funcionario.getRamal();
                dados[i][3] = funcionario.getDia();
                dados[i][4] = funcionario.getHorario();
                i++;
            }
            String tituloColuna[] = {"Nome", "Setor", "Ramal", "Dia", "Horario"};
            DefaultTableModel tabelaConsulta = new DefaultTableModel();
            tabelaConsulta.setDataVector(dados, tituloColuna);
            tbeConsulta.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            
            
            // Tamanho das colunas
            
            tbeConsulta.getColumnModel().getColumn(0).setPreferredWidth(425);
            tbeConsulta.getColumnModel().getColumn(0).setMinWidth(425);
            tbeConsulta.getColumnModel().getColumn(0).setMaxWidth(425);
            
            tbeConsulta.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbeConsulta.getColumnModel().getColumn(1).setMinWidth(150);          
            tbeConsulta.getColumnModel().getColumn(1).setMaxWidth(150);
            
            tbeConsulta.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbeConsulta.getColumnModel().getColumn(2).setMinWidth(80);
            tbeConsulta.getColumnModel().getColumn(2).setMaxWidth(80);
            
            tbeConsulta.getColumnModel().getColumn(3).setPreferredWidth(80);
            tbeConsulta.getColumnModel().getColumn(3).setMinWidth(80);
            tbeConsulta.getColumnModel().getColumn(3).setMaxWidth(80);
            
            tbeConsulta.getColumnModel().getColumn(4).setPreferredWidth(120);
            tbeConsulta.getColumnModel().getColumn(4).setMinWidth(120);
            tbeConsulta.getColumnModel().getColumn(4).setMaxWidth(120);
            
            tbeConsulta.getTableHeader().setReorderingAllowed(false);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            
            tbeConsulta.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            tbeConsulta.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            tbeConsulta.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            tbeConsulta.getColumnModel().getColumn(4).setCellRenderer(centralizado);
            tbeConsulta.setRowHeight(25);
            tbeConsulta.updateUI();
    }
    
    public void atualizaTabelaBusca(){
        funcionario = new FuncionarioM();
                
        String dados[][] = new String[listaFuncionario.size()][5];
            int i = 0;
            for (FuncionarioM funcionario : listaFuncionario) {
                dados[i][0] = funcionario.getNome();
                dados[i][1] = funcionario.getSetor().getNome();
                dados[i][2] = funcionario.getRamal();
                dados[i][3] = funcionario.getDia();
                dados[i][4] = funcionario.getHorario();
                i++;
            }
            String tituloColuna[] = {"Nome", "Setor", "Ramal", "Dia", "Horario"};
            DefaultTableModel tabelaConsulta = new DefaultTableModel();
            tabelaConsulta.setDataVector(dados, tituloColuna);
            tbeConsulta.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            
            // Tamanho das colunas
            
            tbeConsulta.getColumnModel().getColumn(0).setPreferredWidth(425);
            tbeConsulta.getColumnModel().getColumn(0).setMinWidth(425);
            tbeConsulta.getColumnModel().getColumn(0).setMaxWidth(425);
            
            tbeConsulta.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbeConsulta.getColumnModel().getColumn(1).setMinWidth(150);          
            tbeConsulta.getColumnModel().getColumn(1).setMaxWidth(150);
            
            tbeConsulta.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbeConsulta.getColumnModel().getColumn(2).setMinWidth(80);
            tbeConsulta.getColumnModel().getColumn(2).setMaxWidth(80);
            
            tbeConsulta.getColumnModel().getColumn(3).setPreferredWidth(80);
            tbeConsulta.getColumnModel().getColumn(3).setMinWidth(80);
            tbeConsulta.getColumnModel().getColumn(3).setMaxWidth(80);
            
            tbeConsulta.getColumnModel().getColumn(4).setPreferredWidth(130);
            tbeConsulta.getColumnModel().getColumn(4).setMinWidth(130);
            tbeConsulta.getColumnModel().getColumn(4).setMaxWidth(130);
            
            tbeConsulta.getTableHeader().setReorderingAllowed(false);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            
            tbeConsulta.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            tbeConsulta.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            tbeConsulta.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            tbeConsulta.getColumnModel().getColumn(4).setCellRenderer(centralizado);
            tbeConsulta.setRowHeight(25);
            tbeConsulta.updateUI();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbxSetor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbeConsulta;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRamal;
    // End of variables declaration//GEN-END:variables
}
