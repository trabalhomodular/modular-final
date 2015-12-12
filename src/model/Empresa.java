package model;

public class Empresa {
	private ListaOS ordens;
	private ListaCliente clientes;
	private ListaFuncionario funcionarios;
	
	public Empresa(ListaOS ordens, ListaCliente clientes, ListaFuncionario funcionarios) {
		super();
		this.ordens = ordens;
		this.clientes = clientes;
		this.funcionarios = funcionarios;
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
