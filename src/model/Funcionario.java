package model;

public class Funcionario {
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private Habilitacao habilitacao;
	
	public Funcionario() {
	}
	
	public Funcionario(int id, String nome, String email, String telefone, Habilitacao habilitacao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.habilitacao = habilitacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Habilitacao getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(Habilitacao habilitacao) {
		this.habilitacao = habilitacao;
	}
	
	public String toString() {
		return "[" + id + "] " + nome; 
	}
}
