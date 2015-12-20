package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.StatusOs;
import util.SqliteUtil;

/*
"CREATE TABLE IF NOT EXISTS status_os (" 
				+ "id INTEGER PRIMARY KEY," 
				+ "status TEXT NOT NULL,"
				+ "descricao TEXT NOT NULL)"
 */

public class StatusOSDAO {
	private SqliteUtil sqlUtil;
	
	public StatusOSDAO(SqliteUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}
	
	public boolean insereHabilitacao(StatusOs s) throws SQLException {
		StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO status_os VALUES (NULL, '");
        sql.append(s.getStatus());
        sql.append("', '");
        sql.append(s.getDescricao());
        sql.append("')");
        
		return sqlUtil.executeSQL(sql.toString()) > 0;
	}
	
	public LinkedList<StatusOs> selectAll() throws SQLException {
		LinkedList<StatusOs> statusos = new LinkedList<>();
        String sql = "SELECT * FROM status_os ORDER BY id";
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        while (rs.next()) {
        	statusos.add(convertResultSet(rs));
        }

        return statusos;
    }
	
	public StatusOs findById(int id) throws SQLException {
		StatusOs status = null;
		String sql = "SELECT * FROM status_os WHERE id = " + id;
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        
        if (rs.next())
        	status = convertResultSet(rs);
        
		return status;
	}
	
	private StatusOs convertResultSet(ResultSet rs) throws SQLException {
		StatusOs s = new StatusOs();
        s.setId(rs.getInt("id"));
        s.setStatus(rs.getString("status"));
        s.setDescricao(rs.getString("descricao"));
        
        return s;
    }

}
