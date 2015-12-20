package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;
import util.SqliteUtil;

/*
 * "CREATE TABLE IF NOT EXISTS cliente (" 
 "id INTEGER PRIMARY KEY," 
 "nome TEXT NOT NULL,"
 "email TEXT NOT NULL," 
 "telefone TEXT NOT NULL," 
 "cpf TEXT NOT NULL," 
 "rg TEXT NOT NULL,"
 "data_nascimento DATE NOT NULL)
 */

public class ClienteDAO {
	private SqliteUtil sqlUtil;
	
	public ClienteDAO(SqliteUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}
	
	public boolean insereCliente(Cliente c) throws SQLException {
		StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO cliente VALUES (NULL, '");
        sql.append(c.getNome());
        sql.append("','");
        sql.append(c.getEmail());
        sql.append("','");
        sql.append(c.getTelefone());
        sql.append("','");
        sql.append(c.getCpf());
        sql.append("','");
        sql.append(c.getRg());
        sql.append("','");
        sql.append(c.getDataNascimento());
        sql.append("')");
        
		return sqlUtil.executeSQL(sql.toString()) > 0;
	}
	
	public ArrayList<Cliente> selectAll() throws SQLException {
		ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        while (rs.next()) {
            clientes.add(convertResultSet(rs));
        }

        return clientes;
    }
	
	public Cliente findByCpf(String cpf) throws SQLException {
		Cliente cliente = null;
		String sql = "SELECT * FROM cliente WHERE cpf = '" + cpf + "'";
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        
        if (rs.next())
        	cliente = convertResultSet(rs);
        
		return cliente;
	}
	
	public Cliente findById(int id) throws SQLException {
		Cliente cliente = null;
		String sql = "SELECT * FROM cliente WHERE id = "+ id;
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        
        if (rs.next())
        	cliente = convertResultSet(rs);
        
		return cliente;
	}
	
	private Cliente convertResultSet(ResultSet rs) throws SQLException {
        Cliente c = new Cliente();
        c.setId(rs.getInt("id"));
        c.setNome(rs.getString("nome"));
        c.setTelefone(rs.getString("telefone"));
        c.setEmail(rs.getString("email"));
        c.setCpf(rs.getString("cpf"));
        c.setRg(rs.getString("rg"));
        c.setDataNascimento(rs.getDate("data_nascimento"));

        return c;
    }

	public boolean atualizaCliente(Cliente cliente) throws SQLException {
		String sql = "UPDATE cliente SET nome = '" + cliente.getNome();
		sql += "', email = '" + cliente.getEmail();
		sql += "', telefone = '" + cliente.getTelefone();
		sql += "', cpf = '" + cliente.getCpf();
		sql += "', rg = '" + cliente.getRg();
		sql += "', data_nascimento = '" + cliente.getDataNascimento();
		sql += "' WHERE id = " + cliente.getId();
		
		return sqlUtil.executeSQL(sql) > 0;
	}

}
