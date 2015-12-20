
package gui;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import dao.ClienteDAO;
import model.Cliente;
import model.Empresa;

public class JanelaCliente extends javax.swing.JFrame {
	private Cliente cliente;
	private Empresa empresa;

	public JanelaCliente(Cliente cliente, Empresa empresa) {
		this.cliente = cliente;
		this.empresa = empresa;

		initComponents();

		this.setLocationRelativeTo(this);
	}

	private void initComponents() {

		jTextField1 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		cadastrarButton = new javax.swing.JButton();
		cancelarButton = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jTextField6 = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel1.setText("Nome:");

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel2.setText("Cadastro Cliente");

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel3.setText("CPF:");
		jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18));

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel4.setText("Identidade:");

		jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18));

		cadastrarButton.setText("Cadastrar");
		cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					cadastrarButtonActionPerformed(evt);
				} catch (SQLException | ParseException e) {
					JOptionPane.showMessageDialog(null, "Erro no cadastro de novo cliente.\nTente novamente.\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});

		cancelarButton.setText("Cancelar");
		cancelarButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelarButtonActionPerformed(evt);
			}
		});

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel5.setText("Email:");

		jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18));

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel6.setText("Telefone:");

		jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18));

		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel7.setText("Data de Nascimento:");

		jTextField6.setFont(new java.awt.Font("Tahoma", 0, 18));
		
		if (cliente != null) {
			jTextField1.setText(cliente.getNome());
			jTextField5.setText(cliente.getEmail());
			jTextField6.setText(cliente.getTelefone());
			jTextField2.setText(cliente.getCpf());
			jTextField4.setText(cliente.getRg());
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String dataNascimento = formatter.format(cliente.getDataNascimento());
			jTextField3.setText(dataNascimento);
		}

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(199, 199, 199)
						.addComponent(
								jLabel2)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addGap(76, 76, 76)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1).addComponent(jLabel4).addComponent(jLabel3).addComponent(jLabel5)
								.addComponent(jLabel6).addComponent(jLabel7))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 227,
												javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 227,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 227,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 226,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 226,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup().addComponent(cadastrarButton)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(cancelarButton)))
								.addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 227,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(132, 132, 132)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel2).addGap(54, 54, 54)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel7).addComponent(jTextField3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel3))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel4))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel5))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel6).addComponent(jTextField6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(38, 38, 38)))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(cadastrarButton)
						.addComponent(cancelarButton)).addContainerGap(44, Short.MAX_VALUE)));

		pack();
	}

	private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ParseException {
		ClienteDAO dao = new ClienteDAO(empresa.getSqlUtil());
		if (cliente == null) {
			if (jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField3.getText().equals("")
					|| jTextField4.getText().equals("") || jTextField5.getText().equals("")
					|| jTextField6.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Completar os campos!");
			} else {
				DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
				Date dataNascimento = (Date) formatter.parse(jTextField3.getText());
				Cliente cliente = new Cliente(1, jTextField1.getText(), jTextField5.getText(), jTextField6.getText(),
						jTextField2.getText(), jTextField4.getText(), dataNascimento);

				if (dao.insereCliente(cliente)) {
					Cliente c = dao.findByCpf(cliente.getCpf());
					empresa.getClientes().insereCliente(c);

					JOptionPane.showMessageDialog(null,
							"Novo cliente cadastrado com sucesso!\nIdentificador: " + c.getCpf(), "Cadastro cliente",
							JOptionPane.INFORMATION_MESSAGE);

					JanelaAcompanhamentoCliente janela = new JanelaAcompanhamentoCliente(c, empresa);
					janela.setVisible(true);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar novo cliente.\nTente novamente.",
							"Cadastro cliente", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
			Date dataNascimento = (Date) formatter.parse(jTextField3.getText());
			Cliente c = new Cliente(cliente.getId(), jTextField1.getText(), jTextField5.getText(), jTextField6.getText(),
					jTextField2.getText(), jTextField4.getText(), dataNascimento);
			
			if (dao.atualizaCliente(c)) {
				c = dao.findByCpf(c.getCpf());

				JOptionPane.showMessageDialog(null,
						"Cliente " + c.getCpf() + " atualizado com sucesso!", "Cadastro cliente",
						JOptionPane.INFORMATION_MESSAGE);

				JanelaAcompanhamentoCliente janela = new JanelaAcompanhamentoCliente(c, empresa);
				janela.setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Falha ao atualizar cliente.\nTente novamente.",
						"Cadastro cliente", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	
	private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

	// /**
	// * @param args the command line arguments
	// */
	// public static void main(String args[]) {
	// /* Set the Nimbus look and feel */
	// //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code
	// (optional) ">
	// /* If Nimbus (introduced in Java SE 6) is not available, stay with the
	// default look and feel.
	// * For details see
	// http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
	// */
	// try {
	// for (javax.swing.UIManager.LookAndFeelInfo info :
	// javax.swing.UIManager.getInstalledLookAndFeels()) {
	// if ("Nimbus".equals(info.getName())) {
	// javax.swing.UIManager.setLookAndFeel(info.getClassName());
	// break;
	// }
	// }
	// } catch (ClassNotFoundException ex) {
	// java.util.logging.Logger.getLogger(JanelaCliente.class.getName()).log(java.util.logging.Level.SEVERE,
	// null, ex);
	// } catch (InstantiationException ex) {
	// java.util.logging.Logger.getLogger(JanelaCliente.class.getName()).log(java.util.logging.Level.SEVERE,
	// null, ex);
	// } catch (IllegalAccessException ex) {
	// java.util.logging.Logger.getLogger(JanelaCliente.class.getName()).log(java.util.logging.Level.SEVERE,
	// null, ex);
	// } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	// java.util.logging.Logger.getLogger(JanelaCliente.class.getName()).log(java.util.logging.Level.SEVERE,
	// null, ex);
	// }
	//
	// java.awt.EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// new JanelaCliente(0).setVisible(true);
	// }
	// });
	// }

	// Variables declaration
	private javax.swing.JButton cadastrarButton;
	private javax.swing.JButton cancelarButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
}
