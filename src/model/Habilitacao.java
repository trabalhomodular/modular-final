package model;

public class Habilitacao {
	private int id;
	private String tipo;
	
	public Habilitacao() {		
	}

	public Habilitacao(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return tipo;
	}
}
