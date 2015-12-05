package util;

import java.sql.*;

/**
 * Responsible for the actions and connection with the database SQLite
 * 
 * @author robertoroquesilva
 */
public class SqliteUtil {

	private Connection conn;
	private Statement stm;

	/**
	 * Create the connections in the specific path.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public SqliteUtil() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		this.conn = DriverManager.getConnection("jdbc:sqlite:modular.db");
		this.stm = this.conn.createStatement();
	}

	/**
	 * Initialize the database creating the tables
	 * 
	 * @throws SQLException
	 */
	public void initDB() throws SQLException {
		this.stm.execute(
				"CREATE TABLE IF NOT EXISTS habilitacao (" 
						+ "id INTEGER PRIMARY KEY," 
						+ "tipo TEXT NOT NULL)");

		this.stm.execute("CREATE TABLE IF NOT EXISTS funcionario (" 
				+ "id INTEGER PRIMARY KEY," 
				+ "nome TEXT NOT NULL,"
				+ "email TEXT NOT NULL," 
				+ "telefone TEXT NOT NULL," 
				+ "habilitacao INTEGER,"
				+ "FOREIGN KEY(habilitacao) REFERENCES habilitacao(id))");

		this.stm.execute("CREATE TABLE IF NOT EXISTS cliente (" 
				+ "id INTEGER PRIMARY KEY," 
				+ "nome TEXT NOT NULL,"
				+ "email TEXT NOT NULL," 
				+ "telefone TEXT NOT NULL," 
				+ "cpf TEXT NOT NULL," 
				+ "rg TEXT NOT NULL,"
				+ "data_nascimento DATE NOT NULL)");

		this.stm.execute("CREATE TABLE IF NOT EXISTS status_os (" 
				+ "id INTEGER PRIMARY KEY," 
				+ "status TEXT NOT NULL,"
				+ "descricao TEXT NOT NULL)");

		this.stm.execute("CREATE TABLE IF NOT EXISTS material (" 
				+ "id INTEGER PRIMARY KEY," 
				+ "nome TEXT NOT NULL,"
				+ "valor REAL NOT NULL)");

		this.stm.execute("CREATE TABLE IF NOT EXISTS ordem_servico (" 
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
				+ "FOREIGN KEY(id_cliente) REFERENCES cliente(id),"
				+ "FOREIGN KEY(tipo_profissional) REFERENCES habilitacao(id),"
				+ "FOREIGN KEY(status) REFERENCES status(id),"
				+ "FOREIGN KEY(id_funcionario) REFERENCES funcionario(id))");

		this.stm.execute("CREATE TABLE IF NOT EXISTS material_os (" 
				+ "id_os INTEGER PRIMARY KEY,"
				+ "id_material INTEGER NOT NULL," 
				+ "quantidade INTEGER NOT NULL,"
				+ "FOREIGN KEY(id_os) REFERENCES ordem_servico(id),"
				+ "FOREIGN KEY(id_material) REFERENCES material(id))");

	}

	/**
	 * Execute a SQL statement of the insert or update type
	 * 
	 * @param sql
	 * @return result as int
	 * @throws SQLException
	 */
	public int executeSQL(String sql) throws SQLException {
		this.stm = this.conn.createStatement();
		return this.stm.executeUpdate(sql);
	}

	/**
	 * Execute a select command in the database
	 * 
	 * @param sql
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet executeQuerySQL(String sql) throws SQLException {
		this.stm = this.conn.createStatement();
		return this.stm.executeQuery(sql);
	}

	/**
	 * Force to close the database connection
	 * 
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		this.stm.close();
	}
}
