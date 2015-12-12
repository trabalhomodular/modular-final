package gui;

import java.sql.SQLException;

import model.Empresa;
import model.ListaCliente;
import model.ListaFuncionario;
import model.ListaOS;
import util.SqliteUtil;

public class ProjectMain {

	public static void main(String[] args) {
		ListaCliente clientes = new ListaCliente();
		ListaFuncionario funcionarios = new ListaFuncionario();
		ListaOS ordens = new ListaOS();
		
		try {
			SqliteUtil util = new SqliteUtil();
			util.initDB();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		// TODO Consultar o banco e povoar as listas
		
		final Empresa empresa = new Empresa(ordens, clientes, funcionarios);
		
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaInicial().setVisible(true);
            }
        });
	}

}
