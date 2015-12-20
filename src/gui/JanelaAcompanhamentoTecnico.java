
package gui;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.OrdemServicoDAO;
import model.*;

public class JanelaAcompanhamentoTecnico extends javax.swing.JFrame {
	private Funcionario func;
	private DefaultTableModel model;
	private Empresa empresa;

	public JanelaAcompanhamentoTecnico(Funcionario func, Empresa empresa) {
		this.func = func;
		this.empresa = empresa;

		initComponents();

		model = (DefaultTableModel) jTable1.getModel();
		try {
			addTabela();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.setLocationRelativeTo(this);
	}

	public void addTabela() throws SQLException {
		OrdemServicoDAO osDAO = new OrdemServicoDAO(empresa.getSqlUtil());
		for (OrdemServico os : osDAO.listByFuncionario(func)) {
			Object[] linha = { 
					os.getId(), 
					os.getCliente().getNome(),
					os.getFuncionario() == null ? "-" : os.getFuncionario(), 
					os.getStatus().getStatus() 
				};
			model.addRow(linha);
		}
		
		for (OrdemServico os : osDAO.listPendentes()) {
			Object[] linha = { 
					os.getId(), 
					os.getCliente().getNome(),
					os.getFuncionario() == null ? "-" : os.getFuncionario(), 
					os.getStatus().getStatus() 
				};
			model.addRow(linha);
		}
	}

	private void initComponents() {

		jTextField1 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTextField1.setEditable(false);
		jTextField1.setText(Integer.toString(this.func.getId()));
		jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("Matrícula Técnico:");

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel2.setText("Acompanhamento da Solicitação");

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Ordem Serviço", "Cliente", "Funcionário", "Status" }));
		jScrollPane1.setViewportView(jTable1);

		jButton1.setText("Alterar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Cancelar");

		jButton3.setText("Editar Perfil");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton3ActionPerformed(evt);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,
							"Falha ao abrir nova janela.\nTente novamente.\n" + e.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(76, 76, 76)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(75, 75, 75).addComponent(jButton1)
										.addGap(50, 50, 50).addComponent(jButton3)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton2).addGap(41, 41, 41))
						.addComponent(jScrollPane1)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 226,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(101, 101, 101))
				.addGroup(layout.createSequentialGroup().addGap(102, 102, 102).addComponent(jLabel2)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel2).addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1))
				.addGap(18, 18, 18)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton1)
						.addComponent(jButton2).addComponent(jButton3))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		OrdemServico os = new OrdemServico();

		if (jTable1.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha!");
		} else if (jTable1.getValueAt(jTable1.getSelectedRow(), 3).equals("Cadastrada")) {
			// TODO Encontrar Ordem de Servico no banco e colocar na variavel
			JanelaOrcamento orcamento = new JanelaOrcamento(os, empresa);
			orcamento.setVisible(true);
			this.dispose();
		} else if (jTable1.getValueAt(jTable1.getSelectedRow(), 3).equals("Aprovada")) {
			// TODO Encontrar Ordem de Servico no banco e colocar na variavel
			JanelaFaturadoServico janela = new JanelaFaturadoServico(1, os, empresa);
			janela.setVisible(true);
		} else if (jTable1.getValueAt(jTable1.getSelectedRow(), 3).equals("Concluída")) {
			// TODO Encontrar Ordem de Servico no banco e colocar na variavel
			JanelaPagamento janela = new JanelaPagamento(os, empresa);
			janela.setVisible(true);
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		JanelaTecnico janela = new JanelaTecnico(1, empresa);
		janela.setVisible(true);
		this.dispose();
	}

	// Variables declaration
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
}
