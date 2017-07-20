package view;

import com.sun.istack.internal.logging.Logger;
import dao.FuncionarioDAO;
import dao.SetorDAO;
import java.awt.Frame;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.FuncionarioM;
import model.SetorM;
import java.util.logging.Level;
import util.LimiteDigitos;

public class ConsultaView extends javax.swing.JInternalFrame {

    FuncionarioM funcionario;
    
    List<FuncionarioM> listaFuncionario;
    List<SetorM> listaSetor;
    SetorDAO setorDAO;
    FuncionarioDAO funcionarioDAO;
    
    public ConsultaView(){
        initComponents();
        
        this.setVisible(true);
        
        //Intansciação das váriaves de acesso na classe
        this.funcionarioDAO = new FuncionarioDAO();
        this.setorDAO = new SetorDAO();  
        this.listaSetor = new ArrayList<>();
        this.listaFuncionario = new ArrayList<>();
        atualizaBoxSetor();
        atualizaTabelaFuncionario();
        PanelInfo.setVisible(false);
        
        txtNome.setDocument(new LimiteDigitos(90));
        txtRamal.setDocument(new LimiteDigitos(11));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbeConsulta = new javax.swing.JTable();
        PanelBusca = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtRamal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxSetor = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        ckbInativo_Busca = new javax.swing.JCheckBox();
        ckbDocente_Busca = new javax.swing.JCheckBox();
        btnBusca = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        PanelInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        PanelObs = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taaObs = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblRamal = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelRes = new javax.swing.JLabel();
        lblTel1 = new javax.swing.JLabel();
        lbllTel2 = new javax.swing.JLabel();
        lblSetor = new javax.swing.JLabel();
        lblCel1 = new javax.swing.JLabel();
        lblCel2 = new javax.swing.JLabel();
        lblCel3 = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblEnd = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        ckbDocente = new javax.swing.JCheckBox();
        ckbInativo = new javax.swing.JCheckBox();

        setClosable(true);
        setMaximizable(true);
        setTitle("Consulta");

        tbeConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", ""},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Ramal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbeConsulta.setFocusable(false);
        tbeConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbeConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbeConsulta);
        if (tbeConsulta.getColumnModel().getColumnCount() > 0) {
            tbeConsulta.getColumnModel().getColumn(0).setResizable(false);
            tbeConsulta.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbeConsulta.getColumnModel().getColumn(1).setResizable(false);
            tbeConsulta.getColumnModel().getColumn(2).setResizable(false);
        }

        PanelBusca.setBorder(javax.swing.BorderFactory.createTitledBorder("Busca"));

        jLabel2.setText("Nome");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        txtRamal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRamalKeyPressed(evt);
            }
        });

        jLabel12.setText("Ramal");

        jLabel11.setText("Setor");

        cbxSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "NUPSI", "Informática", "Recepção", "Coordenação", "Serviços Gerais", "Administração" }));
        cbxSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSetorActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Busca avançada")));

        ckbInativo_Busca.setText("Inativos");

        ckbDocente_Busca.setText("Docentes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ckbDocente_Busca)
                .addGap(18, 18, 18)
                .addComponent(ckbInativo_Busca)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbDocente_Busca)
                    .addComponent(ckbInativo_Busca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBusca.setText("Buscar");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBuscaLayout = new javax.swing.GroupLayout(PanelBusca);
        PanelBusca.setLayout(PanelBuscaLayout);
        PanelBuscaLayout.setHorizontalGroup(
            PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBuscaLayout.createSequentialGroup()
                        .addGroup(PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addGroup(PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(PanelBuscaLayout.createSequentialGroup()
                        .addGroup(PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtRamal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelBuscaLayout.setVerticalGroup(
            PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBuscaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelBuscaLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRamal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBuscaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));
        PanelInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");
        PanelInfo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Ramal:");
        PanelInfo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Setor:");
        PanelInfo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 62, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Telefone Residencial:");
        PanelInfo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 132, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Telefone Comercial 1:");
        PanelInfo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Telefone Comercial 2:");
        PanelInfo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 188, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Celular 1:");
        PanelInfo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Celular 2:");
        PanelInfo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Celular 3:");
        PanelInfo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("E-Mail:");
        PanelInfo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 97, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Cidade/Estado:");
        PanelInfo.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 258, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Endereço:");
        PanelInfo.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 223, -1, -1));

        PanelObs.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));

        taaObs.setColumns(20);
        taaObs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        taaObs.setRows(5);
        taaObs.setEnabled(false);
        jScrollPane2.setViewportView(taaObs);

        javax.swing.GroupLayout PanelObsLayout = new javax.swing.GroupLayout(PanelObs);
        PanelObs.setLayout(PanelObsLayout);
        PanelObsLayout.setHorizontalGroup(
            PanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelObsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        PanelObsLayout.setVerticalGroup(
            PanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelObsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelInfo.add(PanelObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 401, 478, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Dia:");
        PanelInfo.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 293, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Horário:");
        PanelInfo.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 328, -1, -1));

        lblNome.setBackground(new java.awt.Color(255, 255, 255));
        lblNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome.setText("----");
        PanelInfo.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 27, -1, -1));

        lblRamal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRamal.setText("-----");
        PanelInfo.add(lblRamal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmail.setText("-----");
        PanelInfo.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 97, -1, -1));

        lblTelRes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTelRes.setText("----");
        PanelInfo.add(lblTelRes, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 132, -1, -1));

        lblTel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTel1.setText("----");
        PanelInfo.add(lblTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 160, -1, -1));

        lbllTel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbllTel2.setText("----");
        PanelInfo.add(lbllTel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 188, -1, -1));

        lblSetor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSetor.setText("----");
        PanelInfo.add(lblSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 62, -1, -1));

        lblCel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCel1.setText("----");
        PanelInfo.add(lblCel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        lblCel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCel2.setText("----");
        PanelInfo.add(lblCel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        lblCel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCel3.setText("----");
        PanelInfo.add(lblCel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        lblCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCidade.setText("----");
        PanelInfo.add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 258, -1, -1));

        lblEnd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEnd.setText("----");
        PanelInfo.add(lblEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 223, -1, -1));

        lblDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDia.setText("----");
        PanelInfo.add(lblDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 293, -1, -1));

        lblHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHora.setText("----");
        PanelInfo.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 328, -1, -1));

        ckbDocente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckbDocente.setText("Docente");
        ckbDocente.setEnabled(false);
        PanelInfo.add(ckbDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 369, -1, -1));

        ckbInativo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckbInativo.setText("Inativo");
        ckbInativo.setEnabled(false);
        PanelInfo.add(ckbInativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 369, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(PanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed
    
        //Pega a lista de setores 
    public void atualizaBoxSetor(){
       
        cbxSetor.removeAllItems();
        cbxSetor.addItem("Todos");
        try{
            listaSetor = setorDAO.listaTodos();
        }catch(SQLException ex){    
            Logger.getLogger(ConsultaView.class.getClass()).log(Level.SEVERE,null,ex);
        }
         String dados[][] = new String[listaSetor.size()][5];
        for (SetorM setor : listaSetor) {
            cbxSetor.addItem(setor.getNome());
        }
    } 
    
    public void atualizaTabelaFuncionario(){
        funcionario = new FuncionarioM();
        try {
            listaFuncionario = funcionarioDAO.listaTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
        
        String dados[][] = new String[listaFuncionario.size()][3];
            int i = 0;
            for (FuncionarioM funcionario : listaFuncionario) {
                dados[i][0] = String.valueOf(funcionario.getId());
                dados[i][1] = funcionario.getNome();
                dados[i][2] = funcionario.getRamal();
                i++;
            }
            String tituloColuna[] = {"Id","Nome", "Ramal"};
            DefaultTableModel tabelaConsulta = new DefaultTableModel();
            tabelaConsulta.setDataVector(dados, tituloColuna);
            tbeConsulta.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tbeConsulta.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbeConsulta.getColumnModel().getColumn(0).setMinWidth(40);
            tbeConsulta.getColumnModel().getColumn(0).setMaxWidth(40);
            tbeConsulta.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbeConsulta.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbeConsulta.getColumnModel().getColumn(2).setMinWidth(80);
            tbeConsulta.getColumnModel().getColumn(2).setMaxWidth(80);
            tbeConsulta.getTableHeader().setReorderingAllowed(false);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tbeConsulta.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tbeConsulta.getColumnModel().getColumn(2).setCellRenderer(centralizado);
            tbeConsulta.setRowHeight(25);
            tbeConsulta.updateUI();
    }
    
    public void atualizaTabelaBusca(){
        funcionario = new FuncionarioM();
        String dados[][] = new String[listaFuncionario.size()][3];
        int i = 0;
        for (FuncionarioM funcionario : listaFuncionario) {
            dados[i][0] = String.valueOf(funcionario.getId());
            dados[i][1] = funcionario.getNome();
            dados[i][2] = funcionario.getRamal();
            
            i++;
            
        }
        String tituloColuna[] = {"Id", "Nome", "Ramal"};
        DefaultTableModel tabelaConsulta = new DefaultTableModel();
        tabelaConsulta.setDataVector(dados, tituloColuna);
        tbeConsulta.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false//, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
        
        tbeConsulta.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbeConsulta.getColumnModel().getColumn(0).setMinWidth(40);
        tbeConsulta.getColumnModel().getColumn(0).setMaxWidth(40);
        tbeConsulta.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbeConsulta.getColumnModel().getColumn(2).setPreferredWidth(80);
        tbeConsulta.getColumnModel().getColumn(2).setMinWidth(80);
        tbeConsulta.getColumnModel().getColumn(2).setMaxWidth(80);
        tbeConsulta.getTableHeader().setReorderingAllowed(false);
            
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tbeConsulta.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tbeConsulta.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tbeConsulta.setRowHeight(25);
        tbeConsulta.updateUI();
    }
    
    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBuscaActionPerformed
    {//GEN-HEADEREND:event_btnBuscaActionPerformed
        funcionario = new FuncionarioM();
        if(txtNome.getText().length() <= 0 && txtRamal.getText().length() <= 0 && cbxSetor.getSelectedItem().toString() == "Todos" && ckbDocente_Busca.isSelected() == false && ckbInativo_Busca.isSelected() == false)
            atualizaTabelaFuncionario();
        else{     
            try{
                listaFuncionario = FuncionarioDAO.buscaNome(txtNome.getText(), txtRamal.getText(), cbxSetor.getSelectedItem().toString(), ckbDocente_Busca.isSelected(), ckbInativo_Busca.isSelected());
                
                if(listaFuncionario == null){
                    JOptionPane.showMessageDialog( null, "Nenhum contato encontrado!");
                    atualizaTabelaFuncionario();
                }
                else
                    atualizaTabelaBusca();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog( null, "Erro: "+ex);
            }
        }
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void tbeConsultaMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tbeConsultaMouseClicked
    {//GEN-HEADEREND:event_tbeConsultaMouseClicked
        // Quando Clicado
        
        funcionario = new FuncionarioM();
        PanelInfo.setVisible(true);

        lblNome.setText(tbeConsulta.getValueAt(tbeConsulta.getSelectedRow(),0).toString());
        
        String integer = lblNome.getText();
        int id = Integer.parseInt(integer);
        funcionario.setId(id);
        
        try{
            funcionario = FuncionarioDAO.busca(id);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
        
        lblNome.setText(funcionario.getNome());
        lblSetor.setText(funcionario.getSetor().getNome());
        lblRamal.setText(funcionario.getRamal());
        lblCidade.setText(funcionario.getCidadeestado());
        lblTelRes.setText(funcionario.getTelresidencial());
        lblTel1.setText(funcionario.getTelcomercial1().toString());
        lbllTel2.setText(funcionario.getTelcomercial2().toString());
        lblCel1.setText(funcionario.getCelular1().toString());
        lblCel2.setText(funcionario.getCelular2().toString());
        lblCel3.setText(funcionario.getCelular3().toString());
        lblEmail.setText(funcionario.getEmail());
        lblEnd.setText(funcionario.getEndereco().toString());
        lblDia.setText(funcionario.getDia().toString());
        lblHora.setText(funcionario.getHorario().toString());
        taaObs.setText(funcionario.getObservacao());
        ckbDocente.setSelected(funcionario.getDocente());
        ckbInativo.setSelected(funcionario.getInativo());
    }//GEN-LAST:event_tbeConsultaMouseClicked

    private void cbxSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSetorActionPerformed
    }//GEN-LAST:event_cbxSetorActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLimparActionPerformed
    {//GEN-HEADEREND:event_btnLimparActionPerformed
        // Limpar e atualiza
        txtNome.setText("");
        txtRamal.setText("");
        cbxSetor.setSelectedItem("Todos");
        ckbDocente_Busca.setSelected(false);
        ckbInativo_Busca.setSelected(false);
        
        atualizaTabelaFuncionario();     
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            funcionario = null;
        
        funcionario = new FuncionarioM();
        if(txtNome.getText().length() <= 0 )
            atualizaTabelaFuncionario();
        else{     
            try{
                listaFuncionario = FuncionarioDAO.buscaNome(txtNome.getText(), txtRamal.getText(), cbxSetor.getSelectedItem().toString(), ckbDocente_Busca.isSelected(), ckbInativo_Busca.isSelected());
                
                if(listaFuncionario == null){
                    JOptionPane.showMessageDialog( null, "Nenhum contato encontrado!");
                    atualizaTabelaFuncionario();
                }
                else
                    atualizaTabelaBusca();
            }catch(SQLException ex){
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
        else{     
            try{
                listaFuncionario = FuncionarioDAO.buscaNome(txtNome.getText(), txtRamal.getText(), cbxSetor.getSelectedItem().toString(), ckbDocente_Busca.isSelected(), ckbInativo_Busca.isSelected());
                
                if(listaFuncionario == null){
                    JOptionPane.showMessageDialog( null, "Nenhum contato encontrado!");
                    atualizaTabelaFuncionario();
                }
                else
                    atualizaTabelaBusca();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog( null, "Erro: "+ex);
            }
        }
        }
    }//GEN-LAST:event_txtRamalKeyPressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBusca;
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JPanel PanelObs;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbxSetor;
    private javax.swing.JCheckBox ckbDocente;
    private javax.swing.JCheckBox ckbDocente_Busca;
    private javax.swing.JCheckBox ckbInativo;
    private javax.swing.JCheckBox ckbInativo_Busca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCel1;
    private javax.swing.JLabel lblCel2;
    private javax.swing.JLabel lblCel3;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEnd;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRamal;
    private javax.swing.JLabel lblSetor;
    private javax.swing.JLabel lblTel1;
    private javax.swing.JLabel lblTelRes;
    private javax.swing.JLabel lbllTel2;
    private javax.swing.JTextArea taaObs;
    private javax.swing.JTable tbeConsulta;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRamal;
    // End of variables declaration//GEN-END:variables
}
