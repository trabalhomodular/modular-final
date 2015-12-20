/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import dao.FuncionarioDAO;
import dao.HabilitacaoDAO;
import model.Cliente;
import model.Empresa;
import model.Funcionario;
import model.Habilitacao;


public class JanelaTecnico extends javax.swing.JFrame {
    private int tipo;
    private Empresa empresa;
    
    public JanelaTecnico(int tipo, Empresa empresa) throws SQLException {
        this.tipo = tipo;
        this.empresa = empresa;
        
    	initComponents();
        
    	this.setLocationRelativeTo(this);
    }

    private void initComponents() throws SQLException {
        textNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textTelefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        botaoCadastro = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();
        comboHabilidade = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Cadastro Funcionário");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Endereço Eletrônico:");

        textEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Telefone:");

        textTelefone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Habilidade Profissional:");

        botaoCadastro.setText("Cadastrar");
        botaoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton1ActionPerformed(evt);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar novo funcionário.\nTente novamente.\n" + e.getMessage(), "Cadastro funcionário", JOptionPane.ERROR_MESSAGE);
	                
				}
            }
        });

        botaoCancela.setText("Cancelar");
        botaoCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        System.out.println(new HabilitacaoDAO(empresa.getSqlUtil()).selectAll().toArray());
        
        comboHabilidade.setModel(new javax.swing.DefaultComboBoxModel(new HabilitacaoDAO(empresa.getSqlUtil()).getListArray()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(175, 175, 175))
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(128, 128, 128)))
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoCadastro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoCancela))
                            .addComponent(comboHabilidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboHabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancela)
                    .addComponent(botaoCadastro))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
    	FuncionarioDAO dao = new FuncionarioDAO(empresa.getSqlUtil());
        if (tipo == 0){
            if (textNome.getText().equals("") || textEmail.getText().equals("") || textTelefone.getText().equals("") || comboHabilidade.getSelectedItem().equals("Selecionar habilidade")){
                JOptionPane.showMessageDialog(this, "Completar os campos!");
            }
            else{
                Habilitacao habilitacao = (Habilitacao)comboHabilidade.getSelectedItem();
                
                funcionario = new Funcionario(0, textNome.getText(), textEmail.getText(), textTelefone.getText(), habilitacao);
                
                if (dao.insereFuncionario(funcionario)) {
                	Funcionario f = dao.findByNomeEmail(funcionario.getNome(), funcionario.getEmail());
                	funcionario = f;
                	empresa.getFuncionarios().insereFuncionario(f);
                	JOptionPane.showMessageDialog(null, "Novo funcionário cadastrado com sucesso!\nIdentificador: " + f.getId(), "Cadastro funcionário", JOptionPane.INFORMATION_MESSAGE);
                	JanelaAcompanhamentoTecnico janela = new JanelaAcompanhamentoTecnico(funcionario, empresa);
                    janela.setVisible(true);
                    this.dispose();
                } else {
                	JOptionPane.showMessageDialog(null, "Falha ao cadastrar novo funcionário.\nTente novamente.", "Cadastro funcionário", JOptionPane.ERROR_MESSAGE);
                }
            } 
        } else {
            JanelaAcompanhamentoTecnico janela = new JanelaAcompanhamentoTecnico(funcionario, empresa);
            janela.setVisible(true);
            this.dispose();
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    
    // Variables declaration
    private javax.swing.JButton botaoCadastro;
    private javax.swing.JButton botaoCancela;
    private javax.swing.JComboBox comboHabilidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textTelefone;
    private Funcionario funcionario;
}
