package gui;

import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import model.Empresa;
import model.OrdemServico;


@SuppressWarnings("serial")
public class JanelaOrcamento extends javax.swing.JFrame {
	private Empresa empresa;
	
    public JanelaOrcamento(OrdemServico os, Empresa empresa) {
    	this.os = os;
    	this.empresa = empresa;
        initComponents();
        this.setLocationRelativeTo(this);
    }

    private void initComponents() {
        textNome = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        labelOrcamento = new javax.swing.JLabel();
        labelCPF = new javax.swing.JLabel();
        textCPF = new javax.swing.JTextField();
        labelTelefone = new javax.swing.JLabel();
        textTelefone = new javax.swing.JTextField();
        botaoFinalizar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelNumSolicitacao = new javax.swing.JLabel();
        textNumSolicitacao = new javax.swing.JTextField();
        labelCarga = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        labelMateriais = new javax.swing.JLabel();
        textCarga = new javax.swing.JTextField();
        textValor = new javax.swing.JTextField();
        scrollMateriais = new javax.swing.JScrollPane();
        tableMateriais = new javax.swing.JTable();
        spinnerValidade = new javax.swing.JSpinner();
        labelValidade = new javax.swing.JLabel();
        labelDias = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textNome.setEditable(false);
        textNome.setFont(new java.awt.Font("Tahoma", 0, 18));

        labelNome.setFont(new java.awt.Font("Tahoma", 1, 18));
        labelNome.setText("Nome:");

        labelOrcamento.setFont(new java.awt.Font("Tahoma", 1, 24));
        labelOrcamento.setText("Orçamento");

        labelCPF.setFont(new java.awt.Font("Tahoma", 1, 18));
        labelCPF.setText("CPF:");

        textCPF.setEditable(false);
        textCPF.setFont(new java.awt.Font("Tahoma", 0, 18));

        labelTelefone.setFont(new java.awt.Font("Tahoma", 1, 18));
        labelTelefone.setText("Telefone:");

        textTelefone.setEditable(false);
        textTelefone.setFont(new java.awt.Font("Tahoma", 0, 18));

        botaoFinalizar.setText("Finalizar");
        botaoFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFinalizarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        labelNumSolicitacao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelNumSolicitacao.setText("Número da Solicitação:");

        textNumSolicitacao.setEditable(false);
        textNumSolicitacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        labelCarga.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelCarga.setText("Carga Horária:");

        labelValor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelValor.setText("Valor por Hora:");

        labelMateriais.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelMateriais.setText("Materiais:");

        textCarga.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        textValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tableMateriais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Materiais", "Custo"
            }
        ));
        scrollMateriais.setViewportView(tableMateriais);

        SpinnerModel model = new SpinnerNumberModel(30, 30, 90, 1);
        spinnerValidade.setModel(model);

        labelValidade.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelValidade.setText("Validade:");

        labelDias.setText("Dias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(labelOrcamento))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(botaoFinalizar)
                        .addGap(62, 62, 62)
                        .addComponent(botaoCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNome)
                            .addComponent(labelTelefone)
                            .addComponent(labelCPF)
                            .addComponent(labelNumSolicitacao)
                            .addComponent(labelCarga)
                            .addComponent(labelValor)
                            .addComponent(labelMateriais)
                            .addComponent(labelValidade))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spinnerValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelDias))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textNumSolicitacao, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textCarga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                .addComponent(textNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                .addComponent(textCPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                .addComponent(textValor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                .addComponent(scrollMateriais, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelOrcamento)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCPF))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTelefone)
                    .addComponent(textTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNumSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumSolicitacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCarga)
                    .addComponent(textCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelValor)
                    .addComponent(textValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelMateriais))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollMateriais, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValidade)
                    .addComponent(labelDias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoFinalizar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }

    private void botaoFinalizarActionPerformed(java.awt.event.ActionEvent evt) {
        if (textCarga.getText().equals("") || textValor.getText().equals("") || tableMateriais.getValueAt(0, 0) == null ){
            JOptionPane.showMessageDialog(this, "Por favor, complete todos os campos!");
        }
        else{
            
        	os.setHoras(Double.parseDouble(textCarga.getText()));
        	os.setValorHora(Double.parseDouble(textValor.getText()));
        	os.setValorTotal(Double.parseDouble(textValor.getText())*Double.parseDouble(textCarga.getText()));
        	os.setValidade(Integer.parseInt(spinnerValidade.getValue().toString()));
        	
        	//TODO Gravas Ordem de Servico no Banco
        	
            JanelaAcompanhamentoTecnico janela = new JanelaAcompanhamentoTecnico(os.getFuncionario(), empresa);
            janela.setVisible(true);
            this.dispose();
        }
            
    }

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {
         JanelaAcompanhamentoTecnico janela = new JanelaAcompanhamentoTecnico(os.getFuncionario(), empresa);
         janela.setVisible(true);
         this.dispose();
    }
    
//    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JanelaOrdemdeServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JanelaOrdemdeServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JanelaOrdemdeServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JanelaOrdemdeServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//            	OrdemServico os = new OrdemServico();
//                new JanelaOrcamento(os).setVisible(true);
//            }
//        });
//    }
    
    // Variables declaration
    private javax.swing.JButton botaoFinalizar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelValidade;
    private javax.swing.JLabel labelOrcamento;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labelNumSolicitacao;
    private javax.swing.JLabel labelDias;
    private javax.swing.JLabel labelCarga;
    private javax.swing.JLabel labelValor;
    private javax.swing.JLabel labelMateriais;
    private javax.swing.JScrollPane scrollMateriais;
    private javax.swing.JSpinner spinnerValidade;
    private javax.swing.JTable tableMateriais;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textCPF;
    private javax.swing.JTextField textTelefone;
    private javax.swing.JTextField textNumSolicitacao;
    private javax.swing.JTextField textCarga;
    private javax.swing.JTextField textValor;
    
    private OrdemServico os;
}
