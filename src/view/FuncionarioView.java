package view;

import dao.FuncionarioDAO;
import dao.SetorDAO;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.FuncionarioM;
import model.SetorM;
import util.LimiteDigitos;


public class FuncionarioView extends javax.swing.JInternalFrame {
   
    //Declaração variáveis de acesso.
    FuncionarioM funcionario = new FuncionarioM();
    List<FuncionarioM> listaFuncionario;
    List<SetorM> listaSetor;
    SetorDAO setorDAO;
    FuncionarioDAO funcionarioDAO;
    public FuncionarioView() {
    
        //Intansciação das váriaves de acesso na classe.
        this.funcionarioDAO = new FuncionarioDAO();
        this.setorDAO = new SetorDAO();  
        this.listaSetor = new ArrayList<>();
        this.listaFuncionario = new ArrayList<>();
        
        //Inicia componentes
        initComponents();
        this.setVisible(true);
        
        //Chamada de Métodos
        tbeFuncionario.getTableHeader().setReorderingAllowed(false);
        atualizaBoxSetor();
        atualizaTabelaFuncionario();
        desativarCampos();
        tfdId.setVisible(false);
        
        tfdNome.setDocument(new LimiteDigitos(50));
        tfdEndereco.setDocument(new LimiteDigitos(64));
        tfdCidadeEstado.setDocument(new LimiteDigitos(64));
        tfdEmail.setDocument(new LimiteDigitos(64));
        tfdDia.setDocument(new LimiteDigitos(45));
        tfdHorario.setDocument(new LimiteDigitos(90));
        taaObservacao.setDocument(new LimiteDigitos(150));
        tfdbusca.setDocument(new LimiteDigitos(50));
        tfdRamal.setDocument(new LimiteDigitos(15));
        
        
    }

    //Pega a lista de setores 
    public void atualizaBoxSetor(){
       
        cbxSetor.removeAllItems();
        cbxSetor.addItem("Selecione");
        
        try {
            listaSetor = setorDAO.listaTodos();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         String dados[][] = new String[listaSetor.size()][3];
        for (SetorM setor : listaSetor) {
            cbxSetor.addItem(setor.getNome());
        }
    } 
    
    
    
     //Atualiza todos os funcionario para a tabela
     public void atualizaTabelaFuncionario(){
        funcionario = new FuncionarioM();
        try {
            listaFuncionario = funcionarioDAO.listaTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
        }
        
        String dados[][] = new String[listaFuncionario.size()][6];
            int i = 0;
            for (FuncionarioM funcionario : listaFuncionario) {
                dados[i][0] = String.valueOf(funcionario.getId());
                dados[i][1] = funcionario.getNome();
                dados[i][2] = funcionario.getSetor().getNome();
                dados[i][3] = funcionario.getRamal();
                if(funcionario.getDocente() == true){
                dados[i][4] = String.valueOf("Docente");}
                else{dados[i][4] = String.valueOf("Técnico Administrativo");}
                if(funcionario.getInativo()== true){
                dados[i][5] = String.valueOf("Inativo");}
                else{dados[i][5] = String.valueOf("Ativo");}
               
                i++;
            }
            String tituloColuna[] = {"ID", "Nome", "Setor","Ramal", "Cargo", "Status"};
            DefaultTableModel tabelaFuncionario = new DefaultTableModel();
            tabelaFuncionario.setDataVector(dados, tituloColuna);
            tbeFuncionario.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false,
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            tbeFuncionario.getColumnModel().getColumn(0).setMinWidth(0);
            tbeFuncionario.getColumnModel().getColumn(0).setMaxWidth(0);
            tbeFuncionario.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbeFuncionario.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbeFuncionario.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbeFuncionario.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbeFuncionario.getColumnModel().getColumn(5).setPreferredWidth(40);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tbeFuncionario.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tbeFuncionario.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            tbeFuncionario.getColumnModel().getColumn(4).setCellRenderer(centralizado);
            tbeFuncionario.getColumnModel().getColumn(5).setCellRenderer(centralizado);
            tbeFuncionario.setRowHeight(25);
            tbeFuncionario.updateUI();
    }
    //atualiza parcialmente os funcionarios a partir do que foi digitado na busca
    public void atualizaTabelaFiltro(){
        funcionario = new FuncionarioM();
        

        String dados[][] = new String[listaFuncionario.size()][6];
            int i = 0;
            for (FuncionarioM funcionario : listaFuncionario) {
                dados[i][0] = String.valueOf(funcionario.getId());
                dados[i][1] = funcionario.getNome();
                dados[i][2] = funcionario.getSetor().getNome();
                dados[i][3] = funcionario.getRamal();
                if(funcionario.getDocente() == true){
                dados[i][4] = String.valueOf("Docente");}
                else{dados[i][4] = String.valueOf("Técnico Administrativo");}
                if(funcionario.getInativo()== true){
                dados[i][5] = String.valueOf("Inativo");}
                else{dados[i][5] = String.valueOf("Ativo");}
               
                i++;
            }
            String tituloColuna[] = {"ID", "Nome", "Setor","Ramal", "Cargo", "Status"};
            DefaultTableModel tabelaFuncionario = new DefaultTableModel();
            tabelaFuncionario.setDataVector(dados, tituloColuna);
            tbeFuncionario.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false,
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tbeFuncionario.getColumnModel().getColumn(0).setMinWidth(0);
            tbeFuncionario.getColumnModel().getColumn(0).setMaxWidth(0);
            tbeFuncionario.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbeFuncionario.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbeFuncionario.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbeFuncionario.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbeFuncionario.getColumnModel().getColumn(5).setPreferredWidth(40);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tbeFuncionario.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tbeFuncionario.getColumnModel().getColumn(4).setCellRenderer(centralizado);
            tbeFuncionario.getColumnModel().getColumn(5).setCellRenderer(centralizado);
            tbeFuncionario.setRowHeight(25);
            tbeFuncionario.updateUI();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbeFuncionario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        tfdCelular1 = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        tfdCidadeEstado = new javax.swing.JTextField();
        tfdId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfdEndereco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        tfdTelResidencial = new javax.swing.JFormattedTextField();
        tfdTelComercial1 = new javax.swing.JFormattedTextField();
        cbxDocente = new javax.swing.JCheckBox();
        tfdTelComercial2 = new javax.swing.JFormattedTextField();
        tfdCelular2 = new javax.swing.JFormattedTextField();
        tfdHorario = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taaObservacao = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxInativo = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfdEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfdDia = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbxSetor = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        tfdRamal = new javax.swing.JTextField();
        tfdCelular3 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        tfdbusca = new javax.swing.JTextField();
        cbxFiltro = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Cadastrar Funcionários");
        setToolTipText("");

        tbeFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Setor", "Ramal", "Cargo", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbeFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbeFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbeFuncionario);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Informações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        try {
            tfdCelular1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)9.####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfdCelular1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdCelular1KeyPressed(evt);
            }
        });
        jPanel2.add(tfdCelular1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 136, 126, -1));

        jLabel20.setText("* Campos Obrigatórios ");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 17, -1, -1));

        tfdCidadeEstado.setEnabled(false);
        jPanel2.add(tfdCidadeEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 90, 116, -1));

        tfdId.setEditable(false);
        tfdId.setEnabled(false);
        jPanel2.add(tfdId, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 57, -1));

        jLabel1.setText("Nome *");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 17, 70, -1));

        tfdEndereco.setEnabled(false);
        jPanel2.add(tfdEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 90, 262, -1));

        jLabel2.setText("Endereço *");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 70, 100, -1));

        jLabel3.setText("Cidade/Estado *");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 70, -1, -1));

        jLabel4.setText("Tel Residêncial*");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 162, -1, -1));

        jLabel7.setText("Celular (1) *");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 116, 73, -1));

        tfdNome.setEnabled(false);
        jPanel2.add(tfdNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 41, 390, -1));

        try {
            tfdTelResidencial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfdTelResidencial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdTelResidencialKeyPressed(evt);
            }
        });
        jPanel2.add(tfdTelResidencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 182, 126, -1));

        try {
            tfdTelComercial1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfdTelComercial1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdTelComercial1KeyPressed(evt);
            }
        });
        jPanel2.add(tfdTelComercial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 182, 126, -1));

        cbxDocente.setText("Docente");
        cbxDocente.setEnabled(false);
        jPanel2.add(cbxDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 473, -1, -1));

        try {
            tfdTelComercial2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfdTelComercial2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdTelComercial2KeyPressed(evt);
            }
        });
        jPanel2.add(tfdTelComercial2, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 182, 116, -1));

        try {
            tfdCelular2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)9.####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfdCelular2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdCelular2KeyPressed(evt);
            }
        });
        jPanel2.add(tfdCelular2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 136, 126, -1));

        tfdHorario.setEnabled(false);
        jPanel2.add(tfdHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 320, 188, -1));

        jLabel18.setText("Horário");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 300, -1, -1));

        taaObservacao.setColumns(20);
        taaObservacao.setRows(5);
        jScrollPane2.setViewportView(taaObservacao);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 366, 388, -1));

        jLabel8.setText("Celular (2)");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 116, 68, -1));

        jLabel9.setText("Celular (3)");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 116, 76, -1));

        cbxInativo.setText("Inativo");
        cbxInativo.setEnabled(false);
        jPanel2.add(cbxInativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 507, 71, -1));

        jLabel10.setText("E-Mail *");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 208, 90, -1));

        jLabel11.setText("Setor *");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 254, 80, -1));

        tfdEmail.setEnabled(false);
        jPanel2.add(tfdEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 228, 388, -1));

        jLabel12.setText("Ramal");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 254, -1, -1));

        tfdDia.setEnabled(false);
        jPanel2.add(tfdDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 320, 190, -1));

        jLabel13.setText("Dia");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 300, 70, -1));

        cbxSetor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSetor.setEnabled(false);
        jPanel2.add(cbxSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 274, 272, -1));

        jLabel14.setText("Observação");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 346, 100, -1));

        jLabel5.setText("Tel Comercial (1)");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 162, 106, -1));

        jLabel6.setText("Tel Comercial (2)");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 162, 105, -1));

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 473, 82, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 473, 89, -1));

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 473, 82, -1));

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 507, 82, -1));

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 507, 82, -1));
        jPanel2.add(tfdRamal, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 274, 106, -1));

        try {
            tfdCelular3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)9.####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfdCelular3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdCelular3KeyPressed(evt);
            }
        });
        jPanel2.add(tfdCelular3, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 136, 116, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        tfdbusca.setPreferredSize(new java.awt.Dimension(6, 23));
        tfdbusca.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfdbuscaCaretUpdate(evt);
            }
        });
        tfdbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdbuscaKeyPressed(evt);
            }
        });

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Setor", "Inativo" }));
        cbxFiltro.setPreferredSize(new java.awt.Dimension(95, 23));

        jLabel15.setText("Filtro");

        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfdbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15)
                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tfdbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1)
                .addComponent(jButton2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Pega valores das colunas e transcreve para os campos de texto
    private void tbeFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbeFuncionarioMouseClicked
        prepararSalvareCancelar();
        desativarCampos();
        limparCamposFuncionario();
        funcionario = new FuncionarioM();

        tfdId.setText(tbeFuncionario.getValueAt(tbeFuncionario.getSelectedRow(),0).toString());
        String integer = tfdId.getText();
        int id = Integer.parseInt(integer);
        funcionario.setId(id);
        
        try{
            funcionario = FuncionarioDAO.busca(id);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
   
        tbeFuncionario.getTableHeader().setReorderingAllowed(false);
        tfdId.setText(Integer.toString(funcionario.getId()));
        tfdNome.setText(funcionario.getNome());
        tfdEndereco.setText(funcionario.getEndereco());
        tfdCidadeEstado.setText(funcionario.getCidadeestado());
        tfdTelResidencial.setText(funcionario.getTelresidencial());
        tfdTelComercial1.setText(funcionario.getTelcomercial1());
        tfdTelComercial2.setText(funcionario.getTelcomercial2());
        tfdCelular1.setText(funcionario.getCelular1());
        tfdCelular2.setText(funcionario.getCelular2());
        tfdCelular3.setText(funcionario.getCelular3());
        tfdEmail.setText(funcionario.getEmail());
        cbxSetor.setSelectedItem(tbeFuncionario.getValueAt(tbeFuncionario.getSelectedRow(),2).toString());
        tfdRamal.setText(funcionario.getRamal());
        tfdDia.setText(funcionario.getDia());
        tfdHorario.setText(funcionario.getHorario());
        taaObservacao.setText(funcionario.getObservacao());
        cbxDocente.setSelected(funcionario.getDocente());
        cbxInativo.setSelected(funcionario.getInativo());
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_tbeFuncionarioMouseClicked
    
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(tfdNome.getText().isEmpty() || tfdEndereco.getText().isEmpty() || tfdCidadeEstado.getText().isEmpty() || tfdTelResidencial.getText().equals("(__)____-____")||
            tfdCelular1.getText().equals("(__)9____-____")||tfdEmail.getText().isEmpty() || cbxSetor.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Preencha todos os obrigatórios !", "erro", JOptionPane.WARNING_MESSAGE);
            tfdNome.requestFocusInWindow();       
        }
        else if(tfdId.getText().isEmpty()){
            //Salva tudo digitado no campo de texto para o objeto e salva no banco de dados
            funcionario.setNome(tfdNome.getText());
            funcionario.setEndereco(tfdEndereco.getText());
            funcionario.setCidadeestado(tfdCidadeEstado.getText());
            funcionario.setTelresidencial(tfdTelResidencial.getText());
            funcionario.setTelcomercial1(tfdTelComercial1.getText());
            funcionario.setTelcomercial2(tfdTelComercial2.getText());
            funcionario.setCelular1(tfdCelular1.getText());
            funcionario.setCelular2(tfdCelular2.getText());
            funcionario.setCelular3(tfdCelular3.getText());
            funcionario.setEmail(tfdEmail.getText());
            funcionario.setDia(tfdDia.getText());
            funcionario.setHorario(tfdHorario.getText());
            funcionario.setObservacao(taaObservacao.getText());
            funcionario.setSetor(pegaSetor());
            funcionario.setRamal(tfdRamal.getText());
            funcionario.setDocente(cbxDocente.isSelected());
            funcionario.setInativo(cbxInativo.isSelected());
            
            try{
                FuncionarioDAO.salvar(funcionario);
                JOptionPane.showMessageDialog(null, "Gravado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                tfdNome.requestFocusInWindow();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
               
            }

            atualizaTabelaFuncionario();
            prepararSalvareCancelar();
            desativarCampos();
            limparCamposFuncionario();
        }
        else{
            //Salva tudo que foi alterado nos campos de texto para o objeto e salva no banco de dados
            funcionario.setDocente(false);
            funcionario.setInativo(false);
            funcionario.setId(Integer.parseInt(tfdId.getText()));
            funcionario.setNome(tfdNome.getText());
            funcionario.setEndereco(tfdEndereco.getText());
            funcionario.setCidadeestado(tfdCidadeEstado.getText());
            funcionario.setTelresidencial(tfdTelResidencial.getText());
            funcionario.setTelcomercial1(tfdTelComercial1.getText());
            funcionario.setTelcomercial2(tfdTelComercial2.getText());
            funcionario.setCelular1(tfdCelular1.getText());
            funcionario.setCelular2(tfdCelular2.getText());
            funcionario.setCelular3(tfdCelular3.getText());
            funcionario.setEmail(tfdEmail.getText());
            funcionario.setDia(tfdDia.getText());
            funcionario.setHorario(tfdHorario.getText());
            funcionario.setObservacao(taaObservacao.getText());
            funcionario.setSetor(pegaSetor());
            funcionario.setRamal(tfdRamal.getText());
            funcionario.setDocente(cbxDocente.isSelected());
            funcionario.setInativo(cbxInativo.isSelected());
        try{
            FuncionarioDAO.alterar(funcionario);
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            tfdNome.requestFocusInWindow();       
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
        }
        atualizaTabelaFuncionario();
        prepararSalvareCancelar();
        desativarCampos();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    //O botão excluir é liberado após escolhido um funcionario na tabela
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(tfdId.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um Funcionario", "erro", JOptionPane.WARNING_MESSAGE);
        }
        else{
            funcionario.setId(Integer.parseInt(tfdId.getText()));
            int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir: "+ tfdNome.getText());
            if(confirma ==0){
                try{
                    funcionarioDAO.excluir(funcionario);
                    limparCamposFuncionario();
                    tfdNome.requestFocusInWindow();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
                }
                atualizaTabelaFuncionario();
                prepararExcluir();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
     limparCamposFuncionario();
     prepararNovo();
     ativarCampos();
     btnAlterar.setEnabled(false);
     btnExcluir.setEnabled(false);
     tfdNome.requestFocusInWindow(); 
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    limparCamposFuncionario();
    prepararSalvareCancelar();
    desativarCampos();
    cbxFiltro.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
    prepararAlterar();
    ativarCampos();
    tfdNome.requestFocusInWindow();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tfdbuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdbuscaKeyPressed
    
    }//GEN-LAST:event_tfdbuscaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    cbxFiltro.setSelectedItem("");
    tfdbusca.setText("");
    atualizaTabelaFuncionario();
    tfdbusca.requestFocusInWindow(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfdbuscaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfdbuscaCaretUpdate

    }//GEN-LAST:event_tfdbuscaCaretUpdate

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    listaFuncionario = null;

        if(cbxFiltro.getSelectedIndex()== 0)
        {
            try{
                
                listaFuncionario = FuncionarioDAO.buscaFiltroNome(tfdbusca.getText());
                if(listaFuncionario == null){
                    
                    JOptionPane.showMessageDialog(null, "Nenhum contato encontrado!","", JOptionPane.WARNING_MESSAGE);
                    atualizaTabelaFuncionario();
                    
                }else{
                    
                atualizaTabelaFiltro();
                
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        else if(cbxFiltro.getSelectedIndex() == 1){
                        
            try{
                
                listaFuncionario = FuncionarioDAO.buscaFiltroSetor(tfdbusca.getText());
                if(listaFuncionario == null){
                    
                    JOptionPane.showMessageDialog(null, "Nenhum contato encontrado!","", JOptionPane.WARNING_MESSAGE);
                    atualizaTabelaFuncionario();
                    
                }else{
                    
                atualizaTabelaFiltro();
                
                }

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }
        }else if(cbxFiltro.getSelectedIndex() == 2){
            
             try{
                
                listaFuncionario = FuncionarioDAO.buscaFiltroInativo(tfdbusca.getText());
                if(listaFuncionario == null){
                    
                    JOptionPane.showMessageDialog(null, "Nenhum contato encontrado!","", JOptionPane.WARNING_MESSAGE);
                    atualizaTabelaFuncionario();
                    
                }else{
                    
                atualizaTabelaFiltro();
                
                }

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfdCelular1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdCelular1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            tfdCelular1.setValue("");
        }
    }//GEN-LAST:event_tfdCelular1KeyPressed

    private void tfdCelular2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdCelular2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if(tfdCelular2.getText().equals("()"))
            tfdCelular2.setValue("");
        }
    }//GEN-LAST:event_tfdCelular2KeyPressed

    private void tfdCelular3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdCelular3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if(tfdCelular3.getText().equals("()"))
            tfdCelular3.setValue("");
        }
    }//GEN-LAST:event_tfdCelular3KeyPressed

    private void tfdTelResidencialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdTelResidencialKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if(tfdTelResidencial.getText().equals("()"))
             tfdTelResidencial.setValue("");
        }
    }//GEN-LAST:event_tfdTelResidencialKeyPressed

    private void tfdTelComercial1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdTelComercial1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            tfdTelComercial1.setValue("");
        }
    }//GEN-LAST:event_tfdTelComercial1KeyPressed

    private void tfdTelComercial2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdTelComercial2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            tfdTelComercial2.setValue("");
        }
    }//GEN-LAST:event_tfdTelComercial2KeyPressed
   
    //Ao selecionario um setor, é chamada o dao para fazer a busca no banco de dados
    public SetorM pegaSetor(){
        try{
            if(cbxSetor.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Selecione um setor.", "erro", JOptionPane.WARNING_MESSAGE);
            }else{
                return setorDAO.buscaNome(cbxSetor.getSelectedItem().toString());
            }
        }catch(SQLException ex){
            Logger.getLogger(FuncionarioView.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    
    // DECLARAÇÃO DE MÉTODOS DE CONTROLE DE BOTÕES
   public void limparCamposFuncionario(){
       tfdId.setText("");
       tfdNome.setText("");
       tfdEndereco.setText("");
       tfdCidadeEstado.setText("");
       tfdTelResidencial.setValue("");
       tfdTelComercial1.setValue("");
       tfdTelComercial2.setValue("");
       tfdCelular1.setValue("");
       tfdCelular2.setValue("");
       tfdCelular3.setValue("");
       tfdEmail.setText("");
       cbxSetor.setSelectedItem("");
       tfdRamal.setText("");
       tfdDia.setText("");
       tfdHorario.setText("");
       taaObservacao.setText("");
       cbxDocente.setSelected(false);
       cbxInativo.setSelected(false);
       cbxFiltro.setSelectedItem("");
       tfdbusca.setText("");
       atualizaBoxSetor();
   }
   
   public void ativarCampos(){
       tfdNome.setEnabled(true);
       tfdEndereco.setEnabled(true);
       tfdCidadeEstado.setEnabled(true);
       tfdTelResidencial.setEnabled(true);
       tfdTelComercial1.setEnabled(true);
       tfdTelComercial2.setEnabled(true);
       tfdCelular1.setEnabled(true);
       tfdCelular2.setEnabled(true);
       tfdCelular3.setEnabled(true);
       tfdEmail.setEnabled(true);
       cbxSetor.setEnabled(true);
       tfdRamal.setEnabled(true);
       tfdDia.setEnabled(true);
       tfdHorario.setEnabled(true);
       taaObservacao.setEnabled(true);
       cbxDocente.setEnabled(true);cbxDocente.setText("Docente");
       cbxInativo.setEnabled(true);cbxInativo.setText("Inativo");
       cbxFiltro.setEnabled(true);
   }

   public void desativarCampos(){
       tfdNome.setEnabled(false);
       tfdEndereco.setEnabled(false);
       tfdCidadeEstado.setEnabled(false);
       tfdTelResidencial.setEnabled(false);
       tfdTelComercial1.setEnabled(false);
       tfdTelComercial2.setEnabled(false);
       tfdCelular1.setEnabled(false);
       tfdCelular2.setEnabled(false);
       tfdCelular3.setEnabled(false);
       tfdEmail.setEnabled(false);
       cbxSetor.setEnabled(false);
       tfdRamal.setEnabled(false);
       tfdDia.setEnabled(false);
       tfdHorario.setEnabled(false);
       taaObservacao.setEnabled(false);
       cbxDocente.setEnabled(false);cbxDocente.setText("Docente");
       cbxInativo.setEnabled(false);cbxInativo.setText("Inativo");

   }
   
   public void prepararNovo() {
       btnNovo.setEnabled(false);
       btnSalvar.setEnabled(true);
       btnCancelar.setEnabled(true);
       tbeFuncionario.setEnabled(false);
       tbeFuncionario.clearSelection();
       atualizaBoxSetor();
   }
   
   public void prepararSalvareCancelar() {
       btnNovo.setEnabled(true);
       btnSalvar.setEnabled(false);
       btnCancelar.setEnabled(false);
       tbeFuncionario.setEnabled(true);
   }
   
   public void prepararSelecaoTabela(){
       btnNovo.setEnabled(true);
       btnExcluir.setEnabled(true);
       btnAlterar.setEnabled(true);
   }
   
   public void prepararAlterar(){
       //tbeFuncionario.setEnabled(false);
       tbeFuncionario.clearSelection();
       btnNovo.setEnabled(false);
       btnExcluir.setEnabled(false);
       btnAlterar.setEnabled(false);
       btnSalvar.setEnabled(true);
       btnCancelar.setEnabled(true);   
   }
   
   public void prepararExcluir(){
       btnExcluir.setEnabled(false);
       btnAlterar.setEnabled(false);
   }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbxDocente;
    private javax.swing.JComboBox cbxFiltro;
    private javax.swing.JCheckBox cbxInativo;
    private javax.swing.JComboBox cbxSetor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taaObservacao;
    private javax.swing.JTable tbeFuncionario;
    private javax.swing.JFormattedTextField tfdCelular1;
    private javax.swing.JFormattedTextField tfdCelular2;
    private javax.swing.JFormattedTextField tfdCelular3;
    private javax.swing.JTextField tfdCidadeEstado;
    private javax.swing.JTextField tfdDia;
    private javax.swing.JTextField tfdEmail;
    private javax.swing.JTextField tfdEndereco;
    private javax.swing.JTextField tfdHorario;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdRamal;
    private javax.swing.JFormattedTextField tfdTelComercial1;
    private javax.swing.JFormattedTextField tfdTelComercial2;
    private javax.swing.JFormattedTextField tfdTelResidencial;
    private javax.swing.JTextField tfdbusca;
    // End of variables declaration//GEN-END:variables
}
