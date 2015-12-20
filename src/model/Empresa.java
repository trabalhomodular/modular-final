package model;

import java.sql.SQLException;
import java.util.List;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.StatusOSDAO;
import util.SqliteUtil;

public class Empresa {
	private ListaOS ordens;
	private ListaCliente clientes;
	private ListaFuncionario funcionarios;
	
	private List<StatusOs> statusOs;
	
	private SqliteUtil sqlUtil;
	
	public Empresa(SqliteUtil sqlUtil) throws SQLException {
		super();
		this.sqlUtil = sqlUtil;
		inicializaListas();
	}

	private void inicializaListas() throws SQLException {
		clientes = new ListaCliente(new ClienteDAO(sqlUtil).selectAll());
		funcionarios = new ListaFuncionario(new FuncionarioDAO(sqlUtil).selectAll());
		statusOs = new StatusOSDAO(sqlUtil).selectAll();
	}

	public ListaOS getOrdens() {
		return ordens;
	}

	public ListaCliente getClientes() {
		return clientes;
	}

	public ListaFuncionario getFuncionarios() {
		return funcionarios;
	}
	
	public SqliteUtil getSqlUtil() {
		return sqlUtil;
	}
	
	public List<StatusOs> getListaStatusOs() {
		return statusOs;
	}
	
	public boolean insere(Object item){
		if(item instanceof Cliente)
			return clientes.insereCliente((Cliente) item);
		else if (item instanceof Funcionario)
			return funcionarios.insereFuncionario((Funcionario) item);
		else if(item instanceof OrdemServico)
			return ordens.insereOS((OrdemServico) item);
		
		return false;
	}
	
	public Object busca(Object item){
		if(item instanceof Cliente)
			return clientes.buscaCliente(((Cliente) item).getCpf());
		else if (item instanceof Funcionario)
			return funcionarios.buscaFuncionario(((Funcionario) item).getId());
		else if(item instanceof OrdemServico)
			return ordens.buscaOS(((OrdemServico) item).getId());
		
		return null;
	}
}
