package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.FuncionarioDAO;
import dao.SetorDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.FuncionarioM;
import model.SetorM;

public class RelatorioView extends javax.swing.JInternalFrame {
    FuncionarioM funcionario = new FuncionarioM();
    SetorM setor;
    SetorDAO setorDAO;
    List<SetorM> listaSetor;
    
    Document doc;
    List<FuncionarioM> listaRelatorioFunc;
    
    List<FuncionarioM> listaFuncionario;
    FuncionarioDAO funcionarioDAO;
    
    public RelatorioView() {
        initComponents();
        this.setVisible(true);
        
        listaSetor = new ArrayList<>();
        setorDAO = new SetorDAO();
        setor = new SetorM();
        
        //GroupButton de Tipos.
        buttonGroup1.add(radFuncionarios);
        buttonGroup1.add(radSetores);
        
        //GroupButton de Ordenação.
        buttonGroup2.add(radNome);
        buttonGroup2.add(radSetor);
        
        //GroupButton de Filtros.
        buttonGroup3.add(radTodos);
        buttonGroup3.add(radDocente);
        buttonGroup3.add(radInativo);
    }

    public void atualizarTabelaSetor(){
        setor = new SetorM();
        try {
            listaSetor = setorDAO.ListaSetor();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());
        }
        
        String dados[][] = new String[listaSetor.size()][3];
            int i = 0;
            for (SetorM setor : listaSetor) {
                //dados[i][0] = String.valueOf(setor.getId());
                dados[i][0] = setor.getNome();
                dados[i][1] = String.valueOf(setor.getRamal());
                dados[i][2] = String.valueOf(setor.getId());
                i++;
            }
            String tituloColuna[] = {"Setor", "Ramal"};
            DefaultTableModel tabelaSetor = new DefaultTableModel();
            tabelaSetor.setDataVector(dados, tituloColuna);
            tbeRelatorio.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{ false, false };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tbeRelatorio.getColumnModel().getColumn(0).setPreferredWidth(25);
            tbeRelatorio.getColumnModel().getColumn(1).setPreferredWidth(100);

            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tbeRelatorio.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            tbeRelatorio.setRowHeight(25);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbeRelatorio = new javax.swing.JTable();
        PanelBusca = new javax.swing.JPanel();
        btnBusca = new javax.swing.JButton();
        pnlTipos = new javax.swing.JPanel();
        radFuncionarios = new javax.swing.JRadioButton();
        radSetores = new javax.swing.JRadioButton();
        pnlOrdenacao = new javax.swing.JPanel();
        radNome = new javax.swing.JRadioButton();
        radSetor = new javax.swing.JRadioButton();
        pnlFiltro = new javax.swing.JPanel();
        radTodos = new javax.swing.JRadioButton();
        radDocente = new javax.swing.JRadioButton();
        radInativo = new javax.swing.JRadioButton();
        pnlPDF = new javax.swing.JPanel();
        btnRelatorio = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setClosable(true);
        setMaximizable(true);
        setTitle("Relatório");

        tbeRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", ""},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Setor", "Ramal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbeRelatorio.setFocusable(false);
        tbeRelatorio.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbeRelatorio);
        if (tbeRelatorio.getColumnModel().getColumnCount() > 0) {
            tbeRelatorio.getColumnModel().getColumn(0).setResizable(false);
            tbeRelatorio.getColumnModel().getColumn(0).setPreferredWidth(350);
            tbeRelatorio.getColumnModel().getColumn(1).setResizable(false);
            tbeRelatorio.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbeRelatorio.getColumnModel().getColumn(2).setResizable(false);
            tbeRelatorio.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        PanelBusca.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório"));
        PanelBusca.setName("Relatório"); // NOI18N

        btnBusca.setText("Buscar");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        pnlTipos.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos"));
        pnlTipos.setPreferredSize(new java.awt.Dimension(220, 50));

        radFuncionarios.setText("Funcionarios");
        radFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radFuncionariosActionPerformed(evt);
            }
        });

        radSetores.setText("Setores");
        radSetores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radSetoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTiposLayout = new javax.swing.GroupLayout(pnlTipos);
        pnlTipos.setLayout(pnlTiposLayout);
        pnlTiposLayout.setHorizontalGroup(
            pnlTiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTiposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radFuncionarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radSetores)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        pnlTiposLayout.setVerticalGroup(
            pnlTiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTiposLayout.createSequentialGroup()
                .addGroup(pnlTiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radFuncionarios)
                    .addComponent(radSetores))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pnlOrdenacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenação"));
        pnlOrdenacao.setPreferredSize(new java.awt.Dimension(176, 50));

        radNome.setText("Por Nome");
        radNome.setEnabled(false);
        radNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNomeActionPerformed(evt);
            }
        });

        radSetor.setText("Por Setor");
        radSetor.setEnabled(false);

        javax.swing.GroupLayout pnlOrdenacaoLayout = new javax.swing.GroupLayout(pnlOrdenacao);
        pnlOrdenacao.setLayout(pnlOrdenacaoLayout);
        pnlOrdenacaoLayout.setHorizontalGroup(
            pnlOrdenacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdenacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radSetor)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlOrdenacaoLayout.setVerticalGroup(
            pnlOrdenacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdenacaoLayout.createSequentialGroup()
                .addGroup(pnlOrdenacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radNome)
                    .addComponent(radSetor))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pnlFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        radTodos.setText("Todos");
        radTodos.setEnabled(false);

        radDocente.setText("Docentes");
        radDocente.setEnabled(false);

        radInativo.setText("Inativos");
        radInativo.setEnabled(false);

        javax.swing.GroupLayout pnlFiltroLayout = new javax.swing.GroupLayout(pnlFiltro);
        pnlFiltro.setLayout(pnlFiltroLayout);
        pnlFiltroLayout.setHorizontalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFiltroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(radDocente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radInativo))
                    .addGroup(pnlFiltroLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(radTodos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFiltroLayout.setVerticalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addComponent(radTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radDocente)
                    .addComponent(radInativo)))
        );

        javax.swing.GroupLayout PanelBuscaLayout = new javax.swing.GroupLayout(PanelBusca);
        PanelBusca.setLayout(PanelBuscaLayout);
        PanelBuscaLayout.setHorizontalGroup(
            PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PanelBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelBuscaLayout.createSequentialGroup()
                        .addGroup(PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelBuscaLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBuscaLayout.setVerticalGroup(
            PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscaLayout.createSequentialGroup()
                .addComponent(pnlTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBuscaLayout.createSequentialGroup()
                        .addComponent(pnlOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        btnRelatorio.setText("Gerar Relatório PDF");
        btnRelatorio.setEnabled(false);
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPDFLayout = new javax.swing.GroupLayout(pnlPDF);
        pnlPDF.setLayout(pnlPDFLayout);
        pnlPDFLayout.setHorizontalGroup(
            pnlPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPDFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRelatorio)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        pnlPDFLayout.setVerticalGroup(
            pnlPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPDFLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PanelBusca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(pnlPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        PanelBusca.getAccessibleContext().setAccessibleName("Relatorio");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void atualizaTabelaFuncionario(){
        funcionario = new FuncionarioM();
        
        String dados[][] = new String[listaFuncionario.size()][3];
            int i = 0;
            for (FuncionarioM funcionario : listaFuncionario) {
                //dados[i][0] = String.valueOf(funcionario.getId());
                dados[i][0] = funcionario.getNome();
                dados[i][1] = String.valueOf(funcionario.getSetor().getNome());
                dados[i][2] = String.valueOf(funcionario.getSetor().getRamal());
                i++;
            }
            String tituloColuna[] = {"Nome", "Setor", "Ramal"};
            DefaultTableModel tabelaConsulta = new DefaultTableModel();
            tabelaConsulta.setDataVector(dados, tituloColuna);
            tbeRelatorio.setModel(new DefaultTableModel(dados, tituloColuna) {
                boolean[] canEdit = new boolean[]{
                    false, false//, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            tbeRelatorio.getColumnModel().getColumn(0).setPreferredWidth(350);
            tbeRelatorio.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbeRelatorio.getColumnModel().getColumn(2).setPreferredWidth(150);

            tbeRelatorio.getTableHeader().setReorderingAllowed(false);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tbeRelatorio.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            tbeRelatorio.setRowHeight(25);
            tbeRelatorio.updateUI();
    }
    
    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        funcionario = new FuncionarioM();

        //Desliga o botao GERAR PDF, pois esta fazendo uma nova consulta.
        btnRelatorio.setEnabled(false);
        
        if (radFuncionarios.isSelected()){
            if ((radNome.isSelected() || radSetor.isSelected()) && (radTodos.isSelected() || radDocente.isSelected() || radInativo.isSelected())){
            //Gera a lista de Funcionarios com os seus filtros selecionados.      
            String tipos = "Funcionarios";
            String order = "";
            String filtro = "";
            
            if (radNome.isSelected())
                order = "Nome";
            else if (radSetor.isSelected())
                order = "Setor";
            
            if (radTodos.isSelected())
                filtro = "Todos";
            else if (radDocente.isSelected())
                filtro = "Docentes";
            else if (radInativo.isSelected())
                filtro = "Inativos";
            
                try {
                    listaFuncionario = FuncionarioDAO.relatorioFuncionario(tipos, order, filtro);
                    atualizaTabelaFuncionario();
                    btnRelatorio.setEnabled(true);
                } catch (SQLException ex) {
                    Logger.getLogger(RelatorioView.class.getName()).log(Level.SEVERE, "Erro: ", ex);
                }
            }
        }
        else if (radSetores.isSelected()){
            try {
                //Gera a lista de SETORES ORDENADO
                listaSetor = setorDAO.ListaSetor();
                atualizarTabelaSetor();
                btnRelatorio.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(RelatorioView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        String nomediretorio = null;
        String nomepasta = "RelatoriosAgenda"; // Informe o nome da pasta que armazenará o relatório
        String separador = java.io.File.separator;
        try {
            nomediretorio = "C:" + separador + nomepasta;
            if (!new File(nomediretorio).exists()) {
                (new File(nomediretorio)).mkdir();
            }
           gerarDocumento();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnRelatorioActionPerformed

    public void gerarDocumento() throws IOException, DocumentException{
        Font f10 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
        Font f12 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Font fnormal = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
        
        if (radFuncionarios.isSelected()){
            //INICIO RELATORIO DE FUNCIONARIOS.
            doc = new Document(PageSize.A4.rotate());
            
            String caminho = "C:/RelatoriosAgenda/RelatorioFuncionarios.pdf";
            PdfWriter.getInstance(doc, new FileOutputStream(caminho));
            doc.open();
            
            Paragraph nomeUniversidade = new Paragraph("Universidade do Estado de Minas Gerais",f12);
            nomeUniversidade.setAlignment(Element.ALIGN_CENTER);
            nomeUniversidade.setSpacingAfter(10);
            
            Paragraph nomeRelatorio = new Paragraph("Relatório de Funcionários" ,f12);
            nomeRelatorio.setAlignment(Element.ALIGN_CENTER);
            nomeRelatorio.setSpacingAfter(10);
            
            doc.add(nomeUniversidade);
            doc.add(nomeRelatorio);
            
            PdfPTable tabela = new PdfPTable(7);
            tabela.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.setWidthPercentage(100f);

            PdfPCell cabecalhoNome = new PdfPCell(new Paragraph("Nome", f10));
            cabecalhoNome.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(cabecalhoNome);

            PdfPCell cabecalhoEnd = new PdfPCell(new Paragraph("Endereço",f10));
            cabecalhoEnd.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(cabecalhoEnd);
            
            PdfPCell cabecalhoEmail = new PdfPCell(new Paragraph("Email",f10));
            cabecalhoEmail.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(cabecalhoEmail);
            
            PdfPCell cabecalhoCidade = new PdfPCell(new Paragraph("Cidade/Estado",f10));
            cabecalhoCidade.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(cabecalhoCidade);
            
            PdfPCell cabecalhoTelefone = new PdfPCell(new Paragraph("Telefone",f10));
            cabecalhoTelefone.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(cabecalhoTelefone);
            
            PdfPCell cabecalhoCel = new PdfPCell(new Paragraph("Celular",f10));
            cabecalhoCel.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(cabecalhoCel);
            
            PdfPCell cabecalhoSetor = new PdfPCell(new Paragraph("Setor",f10));
            cabecalhoSetor.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(cabecalhoSetor);
            
            tabela.setHeaderRows(1); // linha que sera repetida em todas as paginas.
            
            for (FuncionarioM func : listaFuncionario){
                Paragraph pNome = new Paragraph(func.getNome(), fnormal);
                pNome.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell colNome = new PdfPCell(pNome);
                
                Paragraph pEnd = new Paragraph(func.getEndereco(), fnormal);
                pEnd.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell colEnd = new PdfPCell(pEnd);
                
                Paragraph pEmail = new Paragraph(func.getEmail(), fnormal);
                pEmail.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell colEmail = new PdfPCell(pEmail);
                
                Paragraph pCidade = new Paragraph(func.getCidadeestado(), fnormal);
                pCidade.setAlignment(Element.ALIGN_CENTER);
                PdfPCell colCidade = new PdfPCell(pCidade);
                colCidade.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Paragraph pTel = new Paragraph("Res:  "+func.getTelresidencial()+"\nCom1: "+func.getTelcomercial1()+"\nCom2: "+func.getTelcomercial2(), fnormal);
                pTel.setAlignment(Element.ALIGN_CENTER);
                PdfPCell colTel = new PdfPCell(pTel);
                colTel.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Paragraph pCel = new Paragraph(func.getCelular1()+"\n"+func.getCelular2()+"\n"+func.getCelular3(), fnormal);
                pTel.setAlignment(Element.ALIGN_CENTER);
                PdfPCell colCel = new PdfPCell(pCel);
                colCel.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Paragraph pSetor = new Paragraph(func.getSetor().getNome(), fnormal);
                pSetor.setAlignment(Element.ALIGN_CENTER);
                PdfPCell colSetor = new PdfPCell(pSetor);
                colSetor.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                tabela.addCell(colNome);
                tabela.addCell(colEnd);
                tabela.addCell(colEmail);
                tabela.addCell(colCidade);
                tabela.addCell(colTel);
                tabela.addCell(colCel);
                tabela.addCell(colSetor);
            }
            doc.add(tabela);
            
            JOptionPane.showMessageDialog(null, "Relatório de Funcionários salvo com sucesso em C:/RelatoriosAgenda/");
            Desktop.getDesktop().open(new File(caminho));

        doc.close();
        }// Fim do RELATORIO DE FUNCIONARIOS.
        
        else if (radSetores.isSelected()){
            doc = new Document(PageSize.A4);
            // INICIO RELATORIO DE SETORES.
            String caminho = "C:/RelatoriosAgenda/RelatorioSetores.pdf";
            PdfWriter.getInstance(doc, new FileOutputStream(caminho));
            doc.open();
            
            Paragraph nomeUniversidade = new Paragraph("Universidade do Estado de Minas Gerais",f12);
            nomeUniversidade.setAlignment(Element.ALIGN_CENTER);
            nomeUniversidade.setSpacingAfter(10);
            
            Paragraph nomeRelatorio = new Paragraph("Relatório de Setores" ,f12);
            nomeRelatorio.setAlignment(Element.ALIGN_CENTER);
            nomeRelatorio.setSpacingAfter(10);
            
            doc.add(nomeUniversidade);
            doc.add(nomeRelatorio);
            
            PdfPTable tabela = new PdfPTable(2);
            tabela.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.setWidthPercentage(70f);

            PdfPCell cabecalhoNome = new PdfPCell(new Paragraph("Nome Setor", f10));
            cabecalhoNome.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(cabecalhoNome);

            PdfPCell cabecalhoRamal = new PdfPCell(new Paragraph("Ramal",f10));
            cabecalhoRamal.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(cabecalhoRamal);
            
            tabela.setHeaderRows(1); // linha que sera repetida em todas as paginas.
            
            for (SetorM seto : listaSetor){
                Paragraph pNome = new Paragraph(seto.getNome(), fnormal);
                pNome.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell colNome = new PdfPCell(pNome);
                colNome.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Paragraph pRamal = new Paragraph(""+seto.getRamal(), fnormal);
                pRamal.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell colRamal = new PdfPCell(pRamal);
                colRamal.setHorizontalAlignment(Element.ALIGN_CENTER);

                tabela.addCell(colNome);
                tabela.addCell(colRamal);
            }
            doc.add(tabela);
            
            JOptionPane.showMessageDialog(null, "Relatório de Setores salvo com sucesso em C:/RelatoriosAgenda/");
            Desktop.getDesktop().open(new File(caminho));

        doc.close();
        }// FIM DO RELATORIO DE SETORES.
    }
    
    private void radFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radFuncionariosActionPerformed
        // Habilita e limpa os JRadioButtons necessarios na pesquisa.
        if (radFuncionarios.isSelected()){
            btnRelatorio.setEnabled(false);
            radNome.setEnabled(true);
            radSetor.setEnabled(true);
            radTodos.setEnabled(true);
            radDocente.setEnabled(true);
            radInativo.setEnabled(true);
            
            buttonGroup2.clearSelection();
            buttonGroup3.clearSelection();
        }
    }//GEN-LAST:event_radFuncionariosActionPerformed

    
    private void radSetoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radSetoresActionPerformed
        //Desabilita e limpa os JRadioButtons desnecessarios.
        if (radSetores.isSelected()){
            btnRelatorio.setEnabled(false);
            radNome.setEnabled(false);
            radSetor.setEnabled(false);
            radTodos.setEnabled(false);
            radDocente.setEnabled(false);
            radInativo.setEnabled(false);
            
            buttonGroup2.clearSelection();
            buttonGroup3.clearSelection();
            
            btnBusca.setEnabled(true);
        }
    }//GEN-LAST:event_radSetoresActionPerformed

    private void radNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNomeActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBusca;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlFiltro;
    private javax.swing.JPanel pnlOrdenacao;
    private javax.swing.JPanel pnlPDF;
    private javax.swing.JPanel pnlTipos;
    private javax.swing.JRadioButton radDocente;
    private javax.swing.JRadioButton radFuncionarios;
    private javax.swing.JRadioButton radInativo;
    private javax.swing.JRadioButton radNome;
    private javax.swing.JRadioButton radSetor;
    private javax.swing.JRadioButton radSetores;
    private javax.swing.JRadioButton radTodos;
    private javax.swing.JTable tbeRelatorio;
    // End of variables declaration//GEN-END:variables
}
