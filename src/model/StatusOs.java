package model;

public class StatusOs {
	private int id;
	private String status;
	private String descricao;
	
	public StatusOs() {
	}

	public StatusOs(int id, String status, String descricao) {
		super();
		this.id = id;
		this.status = status;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
