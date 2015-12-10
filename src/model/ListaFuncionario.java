package model;

import java.util.ArrayList;

public class ListaFuncionario {
private ArrayList<Funcionario> funcionarios;
	
	public ListaFuncionario(){
		funcionarios = new ArrayList<>();
	}
	
	public boolean insereFuncionario(Funcionario func){
		return funcionarios.add(func);
	}
	
	public Funcionario removeFuncionario(Funcionario func){
		Funcionario aux = null;
		for (Funcionario f : funcionarios){
			if (f.getId() == func.getId()){
				aux = f;
				funcionarios.remove(f);
			}
		}
		return aux;
	}
	
	public Funcionario buscaFuncionario(int id){
		for (Funcionario f : funcionarios){
			if (f.getId() == id){
				return f;
			}
		}
		return null;
	}
	
	public ArrayList<Funcionario> getLista(){
		return funcionarios;
	}
}
