package view;

import java.sql.SQLException;
import java.util.List;
import model.ComercioM;
import dao.ComercioDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import util.LimiteDigitos;


public class ComercioView extends javax.swing.JInternalFrame {
    ComercioM comercio = new ComercioM();
    List<ComercioM> listacomercio;
    ComercioDAO comerciodao;
    
    public ComercioView() {
        //Inicia componentes
        initComponents();
        this.setVisible(true);
        
        //Intansciação das váriaves de acesso na classe.
        this.listacomercio = new ArrayList<>();
        
        //Chamada de Métodos
        tbeComercio.getTableHeader().setReorderingAllowed(false);
        atualizaTabelaComercio();
        desativarCampos();
        
        //Limita digitos nos campos
        tfdNome.setDocument(new LimiteDigitos(90));
        tfdEndereco.setDocument(new LimiteDigitos(64));
        tfdCidadeEstado.setDocument(new LimiteDigitos(64));
        tfdEmail.setDocument(new LimiteDigitos(64));
        taaObservacao.setDocument(new LimiteDigitos(150));
    }
    
         //Atualiza todos os comercios para a tabela
    public void atualizaTabelaComercio(){
        comercio = new ComercioM();
        try {
        listacomercio = comerciodao.listaComercio();
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
        
        }
        
        String dados[][] = new String[listacomercio.size()][5];
            int i = 0;
            for (ComercioM comercio : listacomercio) {
                dados[i][0] = String.valueOf(comercio.getId());
                dados[i][1] = comercio.getNome();
                dados[i][2] = comercio.getEndereco();
                dados[i][3] = comercio.getTelComercial1();
                dados[i][4] = comercio.getObservacao();
               
                i++;
            }
            String tituloColuna[] = {"ID", "Nome", "Endereço","Telefone", "Observação"};
            DefaultTableModel tabelaComercio = new DefaultTableModel();
            tabelaComercio.setDataVector(dados, tituloColuna);
            tbeComercio.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tbeComercio.getColumnModel().getColumn(0).setPreferredWidth(10);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tbeComercio.getColumnModel().getColumn(0).setCellRenderer(centralizado);

            tbeComercio.setRowHeight(25);
            tbeComercio.updateUI();
    }
    //atualiza parcialmente os funcionarios a partir do que foi digitado na busca
    public void atualizaTabelaFiltro(){
        comercio = new ComercioM();
        

        String dados[][] = new String[listacomercio.size()][6];
            int i = 0;
            for (ComercioM comercio : listacomercio) {
                dados[i][0] = String.valueOf(comercio.getId());
                dados[i][1] = comercio.getNome();
                dados[i][2] = comercio.getEndereco();
                dados[i][3] = comercio.getCelular();
                dados[i][4] = comercio.getObservacao();
               
                i++;
            }
            String tituloColuna[] = {"ID", "Nome", "Setor","Ramal", "Cargo", "Status"};
            DefaultTableModel tabelaComercio = new DefaultTableModel();
            tabelaComercio.setDataVector(dados, tituloColuna);
            tbeComercio.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tbeComercio.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbeComercio.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbeComercio.getColumnModel().getColumn(2).setPreferredWidth(100);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tbeComercio.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tbeComercio.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            tbeComercio.getColumnModel().getColumn(4).setCellRenderer(centralizado);
            tbeComercio.setRowHeight(25);
            tbeComercio.updateUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel7 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        tfdTelComercial1 = new javax.swing.JFormattedTextField();
        tfdTelComercial2 = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taaObservacao = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfdEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        tfdAreaAtuante = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tfdbusca = new javax.swing.JTextField();
        cbxFiltro = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnLimpa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbeComercio = new javax.swing.JTable();

        setClosable(true);
        setMinimumSize(new java.awt.Dimension(38, 94));
        setPreferredSize(new java.awt.Dimension(1276, 605));

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

        jLabel2.setText("Endereço ");

        jLabel3.setText("Cidade/Estado ");

        jLabel7.setText("Celular (1) *");

        tfdNome.setEnabled(false);

        tfdTelComercial1.setFormatterFactory(setFormatoTelefone());

        tfdTelComercial2.setFormatterFactory(setFormatoTelefone());

        taaObservacao.setColumns(20);
        taaObservacao.setRows(5);
        jScrollPane2.setViewportView(taaObservacao);

        jLabel9.setText("Seguimento da empresa");

        jLabel10.setText("E-Mail ");

        tfdEmail.setEnabled(false);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(tfdNome)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(65, 65, 65)
                                                    .addComponent(jLabel20)
                                                    .addGap(84, 84, 84)
                                                    .addComponent(jLabel19))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                            .addComponent(jLabel3)
                                                            .addGap(29, 29, 29))
                                                        .addComponent(tfdCidadeEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfdCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfdTelComercial1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfdTelComercial2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfdEmail, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdAreaAtuante, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(tfdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(tfdCidadeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdAreaAtuante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdTelComercial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdTelComercial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(tfdCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(6, 6, 6)
                .addComponent(tfdEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        tfdbusca.setPreferredSize(new java.awt.Dimension(6, 23));
        tfdbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdbuscaKeyPressed(evt);
            }
        });

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Seguimento" }));
        cbxFiltro.setPreferredSize(new java.awt.Dimension(95, 23));

        jLabel15.setText("Filtro");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpa.setText("Limpar");
        btnLimpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaActionPerformed(evt);
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
                .addComponent(btnLimpa, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15)
                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tfdbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnBuscar)
                .addComponent(btnLimpa))
        );

        tbeComercio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Celular", "Telefone", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbeComercio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbeComercioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbeComercio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        prepararAlterar();
        ativarCampos();
        tfdNome.requestFocusInWindow();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(tfdId.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um Contato", "erro", JOptionPane.WARNING_MESSAGE);
        }
        else{
            comercio.setId(Integer.parseInt(tfdId.getText()));
            int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir: "+ tfdNome.getText());
            if(confirma ==0){
                try{
                    comerciodao.excluir(comercio);
                    limparCamposComercio();
                    tfdNome.requestFocusInWindow();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
                }
                atualizaTabelaComercio();
                prepararExcluir();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(tfdNome.getText().isEmpty() || tfdEndereco.getText().isEmpty() || tfdCelular1.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Preencha todos os obrigatórios !", "erro", JOptionPane.WARNING_MESSAGE);
            tfdNome.requestFocusInWindow();
        }
        else if(tfdId.getText().isEmpty()){
            //Salva tudo digitado no campo de texto para o objeto e salva no banco de dados
            comercio.setNome(tfdNome.getText());
            comercio.setArea_atuante(tfdAreaAtuante.getText());
            comercio.setEndereco(tfdEndereco.getText());
            comercio.setCidadeEstado(tfdCidadeEstado.getText());
            comercio.setTelComercial1(tfdTelComercial1.getText());
            comercio.setTelComercial2(tfdTelComercial2.getText());
            comercio.setCelular(tfdCelular1.getText());
            comercio.setEmail(tfdEmail.getText());
            comercio.setObservacao(taaObservacao.getText());
            

            try{
                comerciodao.salvar(comercio);
                JOptionPane.showMessageDialog(null, "Gravado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                tfdNome.requestFocusInWindow();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);

            }

            atualizaTabelaComercio();
            prepararSalvareCancelar();
            desativarCampos();
            limparCamposComercio();
        }
        else{
            //Salva tudo que foi alterado nos campos de texto para o objeto e salva no banco de dados
            comercio.setId(Integer.parseInt(tfdId.getText()));
            comercio.setNome(tfdNome.getText());
            comercio.setArea_atuante(tfdAreaAtuante.getText());
            comercio.setEndereco(tfdEndereco.getText());
            comercio.setCidadeEstado(tfdCidadeEstado.getText());
            comercio.setTelComercial1(tfdTelComercial1.getText());
            comercio.setTelComercial2(tfdTelComercial2.getText());
            comercio.setCelular(tfdCelular1.getText());
            comercio.setEmail(tfdEmail.getText());
            comercio.setObservacao(taaObservacao.getText());
            try{
                comerciodao.alterar(comercio);
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                tfdNome.requestFocusInWindow();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }
            atualizaTabelaComercio();
            prepararSalvareCancelar();
            desativarCampos();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCamposComercio();
        prepararSalvareCancelar();
        desativarCampos();
        cbxFiltro.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limparCamposComercio();
        prepararNovo();
        ativarCampos();
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        tfdNome.requestFocusInWindow();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tfdCidadeEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdCidadeEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdCidadeEstadoActionPerformed

    private void tfdbuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdbuscaKeyPressed

    }//GEN-LAST:event_tfdbuscaKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        listacomercio = null;
        if(tfdbusca.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null, "Preencha o campo corretamente! ", "erro", JOptionPane.WARNING_MESSAGE);
            atualizaTabelaComercio();
        }
        else if(cbxFiltro.getSelectedIndex()== 0)
        {
            try{

                listacomercio = comerciodao.buscaFiltroNome(tfdbusca.getText());
                if(listacomercio == null){

                    JOptionPane.showMessageDialog(null, "Nenhum contato encontrado!","", JOptionPane.WARNING_MESSAGE);
                    atualizaTabelaComercio();

                }else{

                    atualizaTabelaFiltro();

                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }

        }
        else if(cbxFiltro.getSelectedIndex() == 1){

            try{

                listacomercio = comerciodao.buscaFiltroSeguimento(tfdbusca.getText());
                if(listacomercio == null){

                    JOptionPane.showMessageDialog(null, "Nenhum contato encontrado!","", JOptionPane.WARNING_MESSAGE);
                    atualizaTabelaComercio();

                }else{

                    atualizaTabelaFiltro();

                }

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage(), "erro", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaActionPerformed
        cbxFiltro.setSelectedItem("");
        tfdbusca.setText("");
        atualizaTabelaComercio();
        tfdbusca.requestFocusInWindow();
    }//GEN-LAST:event_btnLimpaActionPerformed

    private void tbeComercioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbeComercioMouseClicked
        comercio = new ComercioM();

        tfdId.setText(tbeComercio.getValueAt(tbeComercio.getSelectedRow(),0).toString());
        String integer = tfdId.getText();
        int id = Integer.parseInt(integer);
        comercio.setId(id);

        try{
            comercio = comerciodao.busca(id);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }

        tbeComercio.getTableHeader().setReorderingAllowed(false);
        tfdId.setText(Integer.toString(comercio.getId()));
        tfdNome.setText(comercio.getNome());
        tfdAreaAtuante.setText(comercio.getArea_atuante());
        tfdEndereco.setText(comercio.getEndereco());
        tfdCidadeEstado.setText(comercio.getCidadeEstado());
        tfdTelComercial1.setText(comercio.getTelComercial1());
        tfdTelComercial2.setText(comercio.getTelComercial2());
        tfdCelular1.setText(comercio.getCelular());
        tfdEmail.setText(comercio.getEmail());
        taaObservacao.setText(comercio.getObservacao());
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_tbeComercioMouseClicked

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
   public void limparCamposComercio(){
       tfdId.setText("");
       tfdNome.setText("");
       tfdAreaAtuante.setText("");
       tfdEndereco.setText("");
       tfdCidadeEstado.setText("");
       tfdTelComercial1.setValue("");
       tfdTelComercial2.setValue("");
       tfdCelular1.setValue("");
       tfdEmail.setText("");
       taaObservacao.setText("");
       cbxFiltro.setSelectedItem("");
       tfdbusca.setText("");
   }
   
   public void ativarCampos(){
       tfdNome.setEnabled(true);
       tfdAreaAtuante.setEnabled(true);
       tfdEndereco.setEnabled(true);
       tfdCidadeEstado.setEnabled(true);
       tfdTelComercial1.setEnabled(true);
       tfdTelComercial2.setEnabled(true);
       tfdCelular1.setEnabled(true);
       tfdEmail.setEnabled(true);
       taaObservacao.setEnabled(true);
       cbxFiltro.setEnabled(true);
   }

   public void desativarCampos(){
       tfdNome.setEnabled(false);
       tfdAreaAtuante.setEnabled(false);
       tfdEndereco.setEnabled(false);
       tfdCidadeEstado.setEnabled(false);
       tfdTelComercial1.setEnabled(false);
       tfdTelComercial2.setEnabled(false);
       tfdCelular1.setEnabled(false);
       tfdEmail.setEnabled(false);
       taaObservacao.setEnabled(false);
   }
   
   public void prepararNovo() {
       btnNovo.setEnabled(false);
       btnSalvar.setEnabled(true);
       btnCancelar.setEnabled(true);
       tbeComercio.setEnabled(false);
       tbeComercio.clearSelection();
   }
   
   public void prepararSalvareCancelar() {
       btnNovo.setEnabled(true);
       btnSalvar.setEnabled(false);
       btnCancelar.setEnabled(false);
       tbeComercio.setEnabled(true);
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
       tbeComercio.setEnabled(false);
       tbeComercio.clearSelection();
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
    private javax.swing.JButton btnLimpa;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taaObservacao;
    private javax.swing.JTable tbeComercio;
    private javax.swing.JTextField tfdAreaAtuante;
    private javax.swing.JFormattedTextField tfdCelular1;
    private javax.swing.JTextField tfdCidadeEstado;
    private javax.swing.JTextField tfdEmail;
    private javax.swing.JTextField tfdEndereco;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JFormattedTextField tfdTelComercial1;
    private javax.swing.JFormattedTextField tfdTelComercial2;
    private javax.swing.JTextField tfdbusca;
    // End of variables declaration//GEN-END:variables
}
