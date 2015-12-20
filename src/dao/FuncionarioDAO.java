package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Funcionario;
import util.SqliteUtil;

/*
 *CREATE TABLE IF NOT EXISTS funcionario (" 
				+ "id INTEGER PRIMARY KEY," 
				+ "nome TEXT NOT NULL,"
				+ "email TEXT NOT NULL," 
				+ "telefone TEXT NOT NULL," 
				+ "habilitacao INTEGER,"
				+ "FOREIGN KEY(habilitacao) REFERENCES habilitacao(id))
 */

public class FuncionarioDAO {
	private SqliteUtil sqlUtil;
	
	public FuncionarioDAO(SqliteUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}
	
	public boolean insereFuncionario(Funcionario f) throws SQLException {
		StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO funcionario VALUES (NULL, '");
        sql.append(f.getNome());
        sql.append("','");
        sql.append(f.getEmail());
        sql.append("','");
        sql.append(f.getTelefone());
        sql.append("',");
        sql.append(f.getHabilitacao().getId());
        sql.append(")");
        
		return sqlUtil.executeSQL(sql.toString()) > 0;
	}
	
	public ArrayList<Funcionario> selectAll() throws SQLException {
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        while (rs.next()) {
        	funcionarios.add(convertResultSet(rs));
        }

        return funcionarios;
    }
	
	public Funcionario findById(int id) throws SQLException {
		Funcionario func = null;
		String sql = "SELECT * FROM funcionario WHERE id = " + id;
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        if (rs.next())
        	func = convertResultSet(rs);
        
		return func;
	}
	
	public Funcionario findByNomeEmail(String nome, String email) throws SQLException {
		Funcionario func = null;
		String sql = "SELECT * FROM funcionario WHERE nome LIKE '" + nome + "' AND email LIKE '" + email + "'";
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        if (rs.next())
        	func = convertResultSet(rs);
        
		return func;
	}
	
	private Funcionario convertResultSet(ResultSet rs) throws SQLException {
        Funcionario f = new Funcionario();
        f.setId(rs.getInt("id"));
        f.setNome(rs.getString("nome"));
        f.setTelefone(rs.getString("telefone"));
        f.setEmail(rs.getString("email"));
        f.setHabilitacao(new HabilitacaoDAO(sqlUtil).findById(rs.getInt("habilitacao")));

        return f;
    }

}
