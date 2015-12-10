package model;

import java.util.ArrayList;

public class ListaOS {
private ArrayList<OrdemServico> ordemServico;
	
	public ListaOS(){
		ordemServico = new ArrayList<>();
	}
	
	public boolean insereOS(OrdemServico os){
		return ordemServico.add(os);
	}
	
	public OrdemServico removeOS(OrdemServico ordem){
		OrdemServico aux = null;
		for (OrdemServico os : ordemServico){
			if (os.getId() == ordem.getId()){
				aux = os;
				ordemServico.remove(os);
			}
		}
		return aux;
	}
	
	public OrdemServico buscaOS(int id){
		for (OrdemServico os : ordemServico){
			if (os.getId() == id){
				return os;
			}
		}
		return null;
	}

	public ArrayList<OrdemServico> getLista(){
		return ordemServico;
	}
}
