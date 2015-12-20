package gui;

import java.sql.SQLException;
import javax.swing.JOptionPane;

import model.Empresa;
import util.SqliteUtil;

public class ProjectMain {

	public static void main(String[] args) {
		SqliteUtil sqlUtil;
		
		try {
			sqlUtil = new SqliteUtil();
			sqlUtil.initDB();
			Empresa empresa = new Empresa(sqlUtil);
            
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

	        JanelaInicial janelaInicial = new JanelaInicial(empresa);
	        janelaInicial.setVisible(true);
	        
		} catch (ClassNotFoundException 
				| SQLException 
				| InstantiationException
				| IllegalAccessException 
				| javax.swing.UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro!\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

}
