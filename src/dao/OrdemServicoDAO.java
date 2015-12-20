package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;
import model.Funcionario;
import model.OrdemServico;
import util.SqliteUtil;

/*
"CREATE TABLE IF NOT EXISTS ordem_servico (" 
				+ "id INTEGER PRIMARY KEY,"
				+ "id_cliente INTEGER NOT NULL," 
				+ "tipo_profissional INTEGER NOT NULL," 
				+ "status INTEGER NOT NULL,"
				+ "id_funcionario INTEGER," 
				+ "descricao TEXT NOT NULL," 
				+ "horas REAL NOT NULL," 
				+ "valor_hora REAL,"
				+ "valor_total REAL," 
				+ "data_orcamento DATE NOT NULL," 
				+ "validade INTEGER NOT NULL,"
				+ "numero_recibo INTEGER,"
				+ "forma_pagamento TEXT,"
				+ "inst_pagadora TEXT,"
				+ "FOREIGN KEY(id_cliente) REFERENCES cliente(id),"
				+ "FOREIGN KEY(tipo_profissional) REFERENCES habilitacao(id),"
				+ "FOREIGN KEY(status) REFERENCES status(id),"
				+ "FOREIGN KEY(id_funcionario) REFERENCES funcionario(id))"
 */

public class OrdemServicoDAO {
	private SqliteUtil sqlUtil;
	
	public OrdemServicoDAO(SqliteUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}
	
	public boolean insereOrdemServico(OrdemServico os) throws SQLException {
		StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ordem_servico VALUES (NULL, ");
        sql.append(os.getCliente().getId());
        sql.append(",");
        sql.append(os.getTipoProfissional().getId());
        sql.append(",");
        sql.append(os.getStatus().getId());
        sql.append(",");
        sql.append(os.getFuncionario() == null ? "NULL" : os.getFuncionario().getId());
        sql.append(",'");
        sql.append(os.getDescricao());
        sql.append("',");
        sql.append(os.getHoras());
        sql.append(",");
        sql.append("NULL"); // valor_horas
        sql.append(",");
        sql.append("NULL"); // valor_total
        sql.append(",'");
        sql.append(os.getDataOrcamento() == null ? "NULL" : os.getDataOrcamento());
        sql.append("',");
        sql.append(os.getValidade());
        sql.append(",");
        sql.append(os.getNumeroRecibo() == 0 ? "NULL" : os.getNumeroRecibo());
        sql.append(",'");
        sql.append(os.getFormaPagamento() == null ? "NULL" : os.getFormaPagamento());
        sql.append("','");
        sql.append(os.getInstPagadora() == null ? "NULL" : os.getInstPagadora());
        sql.append("')");
        
		return sqlUtil.executeSQL(sql.toString()) > 0;
	}
	
	public ArrayList<OrdemServico> selectAll() throws SQLException {
		ArrayList<OrdemServico> os = new ArrayList<>();
        String sql = "SELECT * FROM ordem_servico";
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        while (rs.next()) {
            os.add(convertResultSet(rs));
        }

        return os;
    }
	
	public OrdemServico findById(int id) throws SQLException {
		OrdemServico os = null;
		String sql = "SELECT * FROM ordem_servico WHERE id = " + id;
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        
        if (rs.next())
        	os = convertResultSet(rs);
        
		return os;
	}
	
	public boolean atualizaDadosOrcamento(OrdemServico os) throws SQLException {
		String sql = "UPDATE ordem_servico SET id_funcionario = " + os.getFuncionario().getId();
		sql += ", status = " + os.getStatus().getId();
		sql += ", horas = " + os.getHoras();
		sql += ", valor_hora = " + os.getValorHora();
		sql += ", valor_total = " + os.getValorTotal();
		sql += ", data_orcamento = '" + os.getDataOrcamento() + "'";
		sql += " WHERE id = " + os.getId();
		
		return sqlUtil.executeSQL(sql) > 0;
	}
	
	public boolean atualizaDadosPagamento(OrdemServico os) throws SQLException {
		String sql = "UPDATE ordem_servico SET status = " + os.getStatus().getId();
		sql += ", numero_recibo = " + os.getNumeroRecibo();
		sql += ", forma_pagamento = '" + os.getFormaPagamento() + "'";
		sql += ", inst_pagadora = '" + os.getInstPagadora() + "'";
		sql += " WHERE id = " + os.getId();
		
		return sqlUtil.executeSQL(sql) > 0;
	}
	
	public boolean atualizaStatus(OrdemServico os) throws SQLException {
		String sql = "UPDATE ordem_servico SET status = " + os.getStatus().getId() 
				+ " WHERE id = " + os.getId();
		
		return sqlUtil.executeSQL(sql) > 0;
	}
	
	public ArrayList<OrdemServico> listByCliente(Cliente cliente) throws SQLException {
		ArrayList<OrdemServico> os = new ArrayList<>();
        String sql = "SELECT * FROM ordem_servico WHERE id_cliente = " + cliente.getId();
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        while (rs.next()) {
            os.add(convertResultSet(rs));
        }

        return os;
    }
	
	private OrdemServico convertResultSet(ResultSet rs) throws SQLException {
        OrdemServico os = new OrdemServico();
        
        os.setId(rs.getInt("id"));
        os.setCliente(new ClienteDAO(sqlUtil).findById(rs.getInt("id_cliente")));
        os.setTipoProfissional(new HabilitacaoDAO(sqlUtil).findById(rs.getInt("tipo_profissional")));
        os.setStatus(new StatusOSDAO(sqlUtil).findById(rs.getInt("status")));
        os.setFuncionario(rs.getString("id_funcionario") == null ? null : new FuncionarioDAO(sqlUtil).findById(rs.getInt("id_funcionario")));
        os.setDescricao(rs.getString("descricao"));
        os.setHoras(rs.getString("horas") == null ? null : rs.getDouble("horas"));
        os.setValorHora(rs.getString("valor_hora") == null ? 0.0 : rs.getDouble("valor_hora"));
        os.setValorTotal(rs.getString("valor_total") == null ? 0.0 : rs.getDouble("valor_total"));
        os.setDataOrcamento(rs.getDate("data_orcamento") == null ? null : rs.getDate("data_orcamento"));
        os.setValidade(rs.getInt("validade"));
        os.setNumeroRecibo(rs.getString("numero_recibo") == null ? 0 : rs.getInt("numero_recibo"));
        os.setFormaPagamento(rs.getString("forma_pagamento") == null ? null : rs.getString("forma_pagamento"));
        os.setInstPagadora(rs.getString("inst_pagadora") == null ? null : rs.getString("inst_pagadora"));

        return os;
    }

	public ArrayList<OrdemServico> listByFuncionario(Funcionario func) throws SQLException {
		ArrayList<OrdemServico> os = new ArrayList<>();
        String sql = "SELECT * FROM ordem_servico WHERE id_funcionario = " + func.getId();
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        while (rs.next()) {
            os.add(convertResultSet(rs));
        }

        return os;
	}

	public ArrayList<OrdemServico> listPendentes() throws SQLException {
		ArrayList<OrdemServico> os = new ArrayList<>();
        String sql = "SELECT * FROM ordem_servico WHERE status IN (1, 2)";
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        while (rs.next()) {
            os.add(convertResultSet(rs));
        }

        return os;
	}

}
