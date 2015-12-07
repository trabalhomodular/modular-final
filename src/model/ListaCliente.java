package model;

import java.util.ArrayList;

public class ListaCliente {
	private ArrayList<Cliente> clientes;
	
	public ListaCliente(){
		clientes = new ArrayList<>();
	}
	
	public boolean insereCliente(Cliente cli){
		return clientes.add(cli);
	}
	
	public Cliente removeCliente(Cliente cli){
		Cliente aux = null;
		for(Cliente c : clientes){
			if(c.getCpf().equals(cli.getCpf())){
				aux = c;
				clientes.remove(c);
			}
		}
		return aux;
	}
	
	public Cliente buscaCliente(String cpf){
		for(Cliente c : clientes){
			if(c.getCpf().equals(cpf))
				return c;
		}
		return null;
	}

}
