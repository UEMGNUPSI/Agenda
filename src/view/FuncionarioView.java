package view;

import com.sun.istack.internal.logging.Logger;
import dao.FuncionarioDAO;
import dao.SetorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
        
        tfdNome.setDocument(new LimiteDigitos(90));
        tfdEndereco.setDocument(new LimiteDigitos(64));
        tfdCidadeEstado.setDocument(new LimiteDigitos(64));
        tfdEmail.setDocument(new LimiteDigitos(64));
        tfdDia.setDocument(new LimiteDigitos(45));
        tfdHorario.setDocument(new LimiteDigitos(90));
        taaObservacao.setDocument(new LimiteDigitos(150));
        
        
    }

    //Pega a lista de setores 
    public void atualizaBoxSetor(){
       
        cbxSetor.removeAllItems();
        cbxSetor.addItem("--Selecione--");
        try{
            listaSetor = setorDAO.listaTodos();
        }catch(SQLException ex){    
            Logger.getLogger(FuncionarioView.class.getClass()).log(Level.SEVERE,null,ex);
        }
         String dados[][] = new String[listaSetor.size()][5];
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
                dados[i][3] = String.valueOf(funcionario.getSetor().getRamal());
                if(funcionario.getDocente() == true){
                dados[i][4] = String.valueOf("Professor");}
                else{dados[i][4] = String.valueOf("Funcionário");}
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

            tbeFuncionario.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbeFuncionario.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbeFuncionario.getColumnModel().getColumn(2).setPreferredWidth(100);
            
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
                dados[i][3] = String.valueOf(funcionario.getSetor().getRamal());
                if(funcionario.getDocente() == true){
                dados[i][4] = String.valueOf("Professor");}
                else{dados[i][4] = String.valueOf("Funcionário");}
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

            tbeFuncionario.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbeFuncionario.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbeFuncionario.getColumnModel().getColumn(2).setPreferredWidth(100);
            
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
        jLabel19 = new javax.swing.JLabel();
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
        btnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);

        tbeFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
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

        tfdCelular1.setFormatterFactory(setFormatoCelular());

        jLabel20.setText("* Campos Obrigatórios ");

        tfdCidadeEstado.setEnabled(false);
        tfdCidadeEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdCidadeEstadoActionPerformed(evt);
            }
        });

        jLabel19.setText("ID");

        tfdId.setEditable(false);
        tfdId.setEnabled(false);

        jLabel1.setText("Nome *");

        tfdEndereco.setEnabled(false);

        jLabel2.setText("Endereço *");

        jLabel3.setText("Cidade/Estado *");

        jLabel4.setText("Tel Residêncial*");

        jLabel7.setText("Celular (1) *");

        tfdNome.setEnabled(false);

        tfdTelResidencial.setFormatterFactory(setFormatoTelefone());
        tfdTelResidencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdTelResidencialActionPerformed(evt);
            }
        });

        tfdTelComercial1.setFormatterFactory(setFormatoTelefone());

        cbxDocente.setText("Docente");
        cbxDocente.setEnabled(false);

        tfdTelComercial2.setFormatterFactory(setFormatoTelefone());

        tfdCelular2.setFormatterFactory(setFormatoCelular());

        tfdHorario.setEnabled(false);

        jLabel18.setText("Horário");

        taaObservacao.setColumns(20);
        taaObservacao.setRows(5);
        jScrollPane2.setViewportView(taaObservacao);

        jLabel8.setText("Celular (2)");

        jLabel9.setText("Celular (3)");

        cbxInativo.setText("Inativo");
        cbxInativo.setEnabled(false);

        jLabel10.setText("E-Mail *");

        jLabel11.setText("Setor *");

        tfdEmail.setEnabled(false);

        jLabel12.setText("Ramal");

        tfdDia.setEnabled(false);

        jLabel13.setText("Dia");

        cbxSetor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSetor.setEnabled(false);
        cbxSetor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxSetorItemStateChanged(evt);
            }
        });

        jLabel14.setText("Observação");

        jLabel5.setText("Tel Comercial (1)");

        jLabel6.setText("Tel Comercial (2)");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        tfdCelular3.setFormatterFactory(setFormatoCelular());
        tfdCelular3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdCelular3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(39, 39, 39))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(tfdCidadeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(tfdNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(tfdRamal))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(65, 65, 65)
                                                .addComponent(jLabel20)
                                                .addGap(91, 91, 91)
                                                .addComponent(jLabel19))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(202, 202, 202)
                                                .addComponent(jLabel12))
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(tfdTelResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel4))
                                                        .addGap(10, 10, 10)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(tfdTelComercial1)))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(tfdCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(10, 10, 10)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(tfdCelular2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tfdTelComercial2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tfdCelular3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tfdDia, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel18)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                    .addComponent(tfdHorario))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(tfdEmail)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxDocente)
                                    .addComponent(cbxInativo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel20))
                    .addComponent(jLabel19))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdCidadeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfdCelular2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdCelular3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdTelResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfdTelComercial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdTelComercial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jLabel10)
                .addGap(6, 6, 6)
                .addComponent(tfdEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdRamal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel18))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovo)
                            .addComponent(btnSalvar)
                            .addComponent(btnCancelar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAlterar)
                            .addComponent(btnExcluir)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(cbxDocente)
                        .addGap(11, 11, 11)
                        .addComponent(cbxInativo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        tfdbusca.setPreferredSize(new java.awt.Dimension(6, 23));
        tfdbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdbuscaKeyPressed(evt);
            }
        });

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Setor", "Inativo" }));
        cbxFiltro.setPreferredSize(new java.awt.Dimension(95, 23));

        jLabel15.setText("Filtro");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfdbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15)
                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tfdbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnBuscar)
                .addComponent(jButton1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Pega valores das colunas e transcreve para os campos de texto
    private void tbeFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbeFuncionarioMouseClicked
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
        tfdRamal.setText(tbeFuncionario.getValueAt(tbeFuncionario.getSelectedRow(),3).toString());
        tfdDia.setText(funcionario.getDia());
        tfdHorario.setText(funcionario.getHorario());
        taaObservacao.setText(funcionario.getObservacao());
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_tbeFuncionarioMouseClicked
    
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(tfdNome.getText().isEmpty() || tfdEndereco.getText().isEmpty() || tfdCidadeEstado.getText().isEmpty() || tfdTelResidencial.getText().isEmpty()||
            tfdCelular1.getText().isEmpty() ||tfdEmail.getText().isEmpty() || cbxSetor.getSelectedIndex()==0){
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

    //Quando o setor é selecionado, é transcrito para o campo de texto "Ramal"
    private void cbxSetorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSetorItemStateChanged
    if(cbxSetor.getSelectedIndex()>=1){
        tfdRamal.setText(Integer.toString(pegaSetor().getRamal()));
    }
    }//GEN-LAST:event_cbxSetorItemStateChanged

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    listaFuncionario = null;
        if(tfdbusca.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null, "Preencha o campo corretamente! ", "erro", JOptionPane.WARNING_MESSAGE);
            atualizaTabelaFuncionario();
        }
        else if(cbxFiltro.getSelectedIndex()== 0)
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
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tfdbuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdbuscaKeyPressed
    
    }//GEN-LAST:event_tfdbuscaKeyPressed

    private void tfdTelResidencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdTelResidencialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdTelResidencialActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    cbxFiltro.setSelectedItem("");
    tfdbusca.setText("");
    atualizaTabelaFuncionario();
    tfdbusca.requestFocusInWindow(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfdCelular3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdCelular3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdCelular3ActionPerformed

    private void tfdCidadeEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdCidadeEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdCidadeEstadoActionPerformed
   
    //Ao selecionario um setor, é chamada o dao para fazer a busca no banco de dados
    public SetorM pegaSetor(){
        try{
            if(cbxSetor.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Selecione um setor.", "erro", JOptionPane.WARNING_MESSAGE);
            }else{
                return setorDAO.buscaNome(cbxSetor.getSelectedItem().toString());
            }
        }catch(SQLException ex){
            Logger.getLogger(FuncionarioView.class.getClass()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    
    //Mascara que formata para regularizar como é inserido o telefone
    public static DefaultFormatterFactory setFormatoTelefone(){  
        MaskFormatter comFoco = null;  
        try   
        {   
            comFoco = new MaskFormatter("(##)####-####"); 
            comFoco.setPlaceholderCharacter('_');
        }   
        catch (Exception pe) { }  
        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);  
        return factory;  
    }
    
    //Mascara que formata para regularizar como é inserido o celular
    public static DefaultFormatterFactory setFormatoCelular(){  
        MaskFormatter comFoco = null;  
        try   
        {   
            comFoco = new MaskFormatter("(##)9####-####"); 
            comFoco.setPlaceholderCharacter('_');
        }   
        catch (Exception pe) { }  
        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);  
        return factory;  
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
       tfdDia.setText("");
       tfdHorario.setText("");
       taaObservacao.setText("");
       cbxDocente.setText("");
       cbxInativo.setText("");
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
       btnNovo.setEnabled(false);
       btnExcluir.setEnabled(false);
       btnAlterar.setEnabled(false);
       btnSalvar.setEnabled(true);
       btnCancelar.setEnabled(true);
       tbeFuncionario.setEnabled(false);
       tbeFuncionario.clearSelection();
   }
   
   public void prepararExcluir(){
       btnExcluir.setEnabled(false);
       btnAlterar.setEnabled(false);
   }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbxDocente;
    private javax.swing.JComboBox cbxFiltro;
    private javax.swing.JCheckBox cbxInativo;
    private javax.swing.JComboBox cbxSetor;
    private javax.swing.JButton jButton1;
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
