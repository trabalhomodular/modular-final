package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Habilitacao;
import util.SqliteUtil;

/*
 * CREATE TABLE IF NOT EXISTS habilitacao (" 
	id INTEGER PRIMARY KEY," 
	tipo TEXT NOT NULL)"
 */

public class HabilitacaoDAO {
	private SqliteUtil sqlUtil;
	
	public HabilitacaoDAO(SqliteUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}
	
	public boolean insereHabilitacao(Habilitacao h) throws SQLException {
		StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO habilitacao VALUES (NULL, '");
        sql.append(h.getTipo());
        sql.append("')");
        
		return sqlUtil.executeSQL(sql.toString()) > 0;
	}
	
	public ArrayList<Habilitacao> selectAll() throws SQLException {
		ArrayList<Habilitacao> habilitacoes = new ArrayList<>();
        String sql = "SELECT * FROM habilitacao";
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        while (rs.next()) {
        	habilitacoes.add(convertResultSet(rs));
        }

        return habilitacoes;
    }
	
	public Habilitacao findById(int id) throws SQLException {
		Habilitacao habilitacao = null;
		String sql = "SELECT * FROM habilitacao WHERE id = " + id;
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        
        if (rs.next())
        	habilitacao = convertResultSet(rs);
        
		return habilitacao;
	}
	
	public String[] getListArray() throws SQLException {
		ArrayList<Habilitacao> hbs = selectAll();
		String[] array = new String[hbs.size()];
		int i = 0;
		for (Habilitacao h : hbs) {
			array[i] = h.getTipo();
			i++;
		}
		
		return array;
	}
	
	private Habilitacao convertResultSet(ResultSet rs) throws SQLException {
		Habilitacao h = new Habilitacao();
        h.setId(rs.getInt("id"));
        h.setTipo(rs.getString("tipo"));

        return h;
    }

}
