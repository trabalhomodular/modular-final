package gui;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.OrdemServicoDAO;
import model.Cliente;
import model.Empresa;
import model.Funcionario;
import model.OrdemServico;
import model.StatusOs;

public class JanelaAcompanhamentoCliente extends javax.swing.JFrame {
	private Empresa empresa;
    private Cliente cliente;
    private DefaultTableModel model;
    private OrdemServicoDAO osDAO;
    
    public JanelaAcompanhamentoCliente(Cliente cliente, Empresa empresa) {
        this.cliente = cliente;
        this.empresa = empresa;
        osDAO = new OrdemServicoDAO(empresa.getSqlUtil());
        
        initComponents();
        
        model = (DefaultTableModel) jTable1.getModel();
        try {
			addTabela();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar janela.\nTente novamente.\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
        
        this.setLocationRelativeTo(this);
    }
    public void addTabela() throws SQLException{
        for (OrdemServico os : osDAO.listByCliente(cliente)) {
        	Object[] linha = {os.getId(), os.getTipoProfissional().getTipo(), os.getFuncionario() == null ? "-" : os.getFuncionario().toString(), os.getStatus().getStatus()};
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
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setEditable(false);
        jTextField1.setText(cliente.getCpf());
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("Matrícula do Cliente:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel2.setText("Acompanhamento da Solicitação");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Ordem de Serviço", "Tipo de profissional", "Funcionário", "Status"}
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Alterar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton1ActionPerformed(evt);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro ao buscar Ordem de Serviço.\nTente novamente.\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Novo Serviço");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Editar Perfil");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(43, 43, 43)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        if (jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha!", "FazConsertos", JOptionPane.INFORMATION_MESSAGE);
        } else {
        	if (jTable1.getValueAt(jTable1.getSelectedRow(), 3).equals("Aguardando Aprovação do Cliente")) {
	        	OrdemServico os = osDAO.findById((int)jTable1.getValueAt(jTable1.getSelectedRow(), 1));
	            JanelaFaturadoServico orcamento = new JanelaFaturadoServico(1, os, empresa);
	            orcamento.setVisible(true);
	            this.dispose();
        	} else {
        		JOptionPane.showMessageDialog(this, "Por favor, aguarde o retorno de um dos técnicos.", "FazConsertos", JOptionPane.INFORMATION_MESSAGE);
        	}
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        JanelaOrdemdeServico janela = new JanelaOrdemdeServico(empresa, cliente);
        janela.setVisible(true);
        this.dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        JanelaCliente janela = new JanelaCliente(cliente, empresa);
        janela.setVisible(true);
        this.dispose();
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JanelaAcompanhamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JanelaAcompanhamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JanelaAcompanhamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JanelaAcompanhamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JanelaAcompanhamentoCliente(0).setVisible(true);
//            }
//        });
//    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
}
