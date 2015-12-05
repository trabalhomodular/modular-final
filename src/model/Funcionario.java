package model;

public class Funcionario {
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private int habilitacao;
	
	public Funcionario() {
	}
	
	public Funcionario(int id, String nome, String email, String telefone, int habilitacao) {
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

	public int getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(int habilitacao) {
		this.habilitacao = habilitacao;
	}
}
