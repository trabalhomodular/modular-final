package util;

import java.sql.*;

/**
 * Responsible for the actions and connection with the database SQLite
 * 
 * @author robertoroquesilva
 */
public class SqliteUtil {

	private Connection conn;

	/**
	 * Create the connections in the specific path.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public SqliteUtil() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		this.conn = DriverManager.getConnection("jdbc:sqlite:modular.db");
	}

	/**
	 * Initialize the database creating the tables
	 * 
	 * @throws SQLException
	 */
	public void initDB() throws SQLException {
		Statement stm = this.conn.createStatement();
		stm.execute(
				"CREATE TABLE IF NOT EXISTS habilitacao (" 
						+ "id INTEGER PRIMARY KEY," 
						+ "tipo TEXT NOT NULL)");

		stm.execute("CREATE TABLE IF NOT EXISTS funcionario (" 
				+ "id INTEGER PRIMARY KEY," 
				+ "nome TEXT NOT NULL,"
				+ "email TEXT NOT NULL," 
				+ "telefone TEXT NOT NULL," 
				+ "habilitacao INTEGER,"
				+ "FOREIGN KEY(habilitacao) REFERENCES habilitacao(id))");

		stm.execute("CREATE TABLE IF NOT EXISTS cliente (" 
				+ "id INTEGER PRIMARY KEY," 
				+ "nome TEXT NOT NULL,"
				+ "email TEXT NOT NULL," 
				+ "telefone TEXT NOT NULL," 
				+ "cpf TEXT NOT NULL," 
				+ "rg TEXT NOT NULL,"
				+ "data_nascimento DATE NOT NULL)");

		stm.execute("CREATE TABLE IF NOT EXISTS status_os (" 
				+ "id INTEGER PRIMARY KEY," 
				+ "status TEXT NOT NULL,"
				+ "descricao TEXT NOT NULL)");

		stm.execute("CREATE TABLE IF NOT EXISTS material (" 
				+ "id INTEGER PRIMARY KEY," 
				+ "nome TEXT NOT NULL,"
				+ "valor REAL NOT NULL)");

		stm.execute("CREATE TABLE IF NOT EXISTS ordem_servico (" 
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
				+ "FOREIGN KEY(id_funcionario) REFERENCES funcionario(id))");

		stm.execute("CREATE TABLE IF NOT EXISTS material_os (" 
				+ "id_os INTEGER PRIMARY KEY,"
				+ "id_material INTEGER NOT NULL," 
				+ "quantidade INTEGER NOT NULL,"
				+ "FOREIGN KEY(id_os) REFERENCES ordem_servico(id),"
				+ "FOREIGN KEY(id_material) REFERENCES material(id))");
		
		// Popula tabela status_os
		stm.execute("DELETE FROM status_os");
		stm.execute("INSERT INTO status_os VALUES (NULL, 'Cadastrada', 'O usuário deu entrada "
				+ "e a solicitação está arquivadao usuário deu entrada e a solicitação está arquivada')");
		stm.execute("INSERT INTO status_os VALUES (NULL, 'Aguardando Orçamento', 'Algum técnico já "
				+ "abriu a solicitação, mas ainda não completou os dados do orçamento.')");
		stm.execute("INSERT INTO status_os VALUES (NULL, 'Aguardando Aprovação do Cliente', 'O técnico "
				+ "completou o orçamento e liberou para aprovação do cliente.')");
		stm.execute("INSERT INTO status_os VALUES (NULL, 'Aprovada', 'O cliente autorizou o serviço.')");
		stm.execute("INSERT INTO status_os VALUES (NULL, 'Em andamento', 'O técnico está elaborando o serviço solicitado.')");
		stm.execute("INSERT INTO status_os VALUES (NULL, 'Concluída', 'O serviço já foi realizado e o cliente "
				+ "já deu o aceite do serviço executado.')");
		stm.execute("INSERT INTO status_os VALUES (NULL, 'Em cobrança', 'A fatura de pagamento foi emitida.')");
		stm.execute("INSERT INTO status_os VALUES (NULL, 'Encerrada', 'O serviço já foi feito, aprovado e pago.')");
		stm.execute("INSERT INTO status_os VALUES (NULL, 'Cancelada', 'A solicitação foi cancelada a pedido ou "
				+ "por ter esgotado a validade do orçamento.')");
		
		// Popula tabela habilitacao
		stm.execute("DELETE FROM habilitacao");
		stm.execute("INSERT INTO habilitacao (id, tipo) VALUES (1, 'Eletricista')");
		stm.execute("INSERT INTO habilitacao (id, tipo) VALUES (2, 'Bombeiro')");
		stm.execute("INSERT INTO habilitacao (id, tipo) VALUES (3, 'Pedreiro')");
		stm.execute("INSERT INTO habilitacao (id, tipo) VALUES (4, 'Faxineiro')");
		
		// Popula tabela material
		stm.execute("DELETE FROM material");
		stm.execute("INSERT INTO material VALUES (NULL, 'Cabo eletrico', 5.0)");
		stm.execute("INSERT INTO material VALUES (NULL, 'Fita isolante', 0.5)");
		stm.execute("INSERT INTO material VALUES (NULL, 'Painel eletrico', 45.0)");
		stm.execute("INSERT INTO material VALUES (NULL, 'Cano', 14.0)");
		stm.execute("INSERT INTO material VALUES (NULL, 'Parafuso', 0.25)");
		stm.execute("INSERT INTO material VALUES (NULL, 'Pano de chão', 1.0)");
		stm.execute("INSERT INTO material VALUES (NULL, 'Vassoura', 5.0)");
		stm.execute("INSERT INTO material VALUES (NULL, 'Cimento', 45.0)");
		stm.execute("INSERT INTO material VALUES (NULL, 'Azulejo', 35.0)");
		stm.execute("INSERT INTO material VALUES (NULL, 'Marreta', 17.0)");
		stm.execute("INSERT INTO material VALUES (NULL, 'Areia', 19.0)");
		
	}

	/**
	 * Execute a SQL statement of the insert or update type
	 * 
	 * @param sql
	 * @return result as int
	 * @throws SQLException
	 */
	public int executeSQL(String sql) throws SQLException {
		Statement stm = this.conn.createStatement();
		return stm.executeUpdate(sql);
	}

	/**
	 * Execute a select command in the database
	 * 
	 * @param sql
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet executeQuerySQL(String sql) throws SQLException {
		Statement stm = this.conn.createStatement();
		return stm.executeQuery(sql);
	}
}
