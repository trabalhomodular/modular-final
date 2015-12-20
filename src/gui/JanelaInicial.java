/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Cliente;
import model.Empresa;
import model.Funcionario;


@SuppressWarnings("serial")
public class JanelaInicial extends javax.swing.JFrame {
	
    public JanelaInicial(Empresa empresa) {
    	this.empresa = empresa;
        initComponents();
        this.setLocationRelativeTo(this);
    }

    private void initComponents() {
        textFieldID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botaoLogin = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        checkBoxCliente = new javax.swing.JCheckBox();
        checkBoxFuncionario = new javax.swing.JCheckBox();
        botaoCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textFieldID.setFont(new java.awt.Font("Tahoma", 0, 18));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("Identificador:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel2.setText("EMPRESA FAZCONSERTOS");
        jLabel2.setHorizontalAlignment(JLabel.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18));

        botaoLogin.setText("Login");
        botaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        checkBoxCliente.setFont(new java.awt.Font("Tahoma", 0, 18));
        checkBoxCliente.setText("Cliente");
        checkBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxClienteActionPerformed(evt);
            }
        });

        checkBoxFuncionario.setFont(new java.awt.Font("Tahoma", 0, 18));
        checkBoxFuncionario.setText("Funcionário");
        checkBoxFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxFuncionarioActionPerformed(evt);
            }
        });

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					botaoCadastroActionPerformed(evt);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Falha ao abrir nova janela.\nTente novamente.\n" + e.getMessage(), "Cadastro funcionário", JOptionPane.ERROR_MESSAGE);
				}
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkBoxCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkBoxFuncionario))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel1)
                                    .addComponent(botaoLogin))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botaoCadastrar)
                                        .addGap(54, 54, 54)
                                        .addComponent(botaoCancelar))
                                    .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabel3)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(checkBoxCliente)
                    .addComponent(checkBoxFuncionario))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botaoLogin)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoCadastrar))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        
        pack();
     
    }

    private void botaoLoginActionPerformed(java.awt.event.ActionEvent evt) {
        if ((textFieldID.getText().equals("")) || (!checkBoxCliente.isSelected() && !checkBoxFuncionario.isSelected())){
            JOptionPane.showMessageDialog(this, "Por favor, complete os campos!");
        } else {
        	if (checkBoxFuncionario.isSelected()) {
        		int id = 0;
        		try {
            		id = Integer.parseInt(textFieldID.getText().trim());
            	} catch (NumberFormatException ex) {
            		JOptionPane.showMessageDialog(this, "O identificador do funcionário deve ser um número.", "Erro", JOptionPane.ERROR_MESSAGE);
            		textFieldID.setText("");
            		textFieldID.grabFocus();
            	}
        		Funcionario f = empresa.getFuncionarios().buscaFuncionario(id);
        		if (f == null) {
        			JOptionPane.showMessageDialog(this, "Funcionário inexistente.\nTente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            		textFieldID.setText("");
            		textFieldID.grabFocus();
        		} else {
        			JanelaAcompanhamentoTecnico acompFuncionario = new JanelaAcompanhamentoTecnico(f, empresa);
        			acompFuncionario.setVisible(true);
        		}
            } else if (checkBoxCliente.isSelected()) {
                Cliente c = empresa.getClientes().buscaCliente(textFieldID.getText().trim());
                if (c == null) {
                	JOptionPane.showMessageDialog(this, "Cliente inexistente.\nTente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            		textFieldID.setText("");
            		textFieldID.grabFocus();
                } else {
                	JanelaAcompanhamentoCliente acompCliente = new JanelaAcompanhamentoCliente(c, empresa);
                	acompCliente.setVisible(true);
                }
            }
        }
    }

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void checkBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {
        if(checkBoxCliente.isSelected()){
            checkBoxFuncionario.setSelected(false);
        }
    }

    private void botaoCadastroActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        if (!checkBoxCliente.isSelected() && !checkBoxFuncionario.isSelected()){
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma opção!");
        }
        else {
            if(!checkBoxFuncionario.isSelected()){
                JanelaCliente janela = new JanelaCliente(null, empresa);
                janela.setVisible(true);
            }
            else{
                JanelaTecnico janela = new JanelaTecnico(0, empresa);
                janela.setVisible(true);
            }
        }
    }

    private void checkBoxFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {
        if(checkBoxFuncionario.isSelected()){
            checkBoxCliente.setSelected(false);
        }
    }
    
    public Empresa getEmpresaController() {
    	return empresa;
    }

    // Variables declaration
    private javax.swing.JButton botaoLogin;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JCheckBox checkBoxCliente;
    private javax.swing.JCheckBox checkBoxFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textFieldID;
    private Empresa empresa;
}
