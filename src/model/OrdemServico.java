package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdemServico {
	private int id;
	private Cliente cliente;
	private Habilitacao tipoProfissional;
	private StatusOs status;
	private Funcionario funcionario;
	private String descricao;
	private double horas;
	private double valorHora;
	private double valorTotal;
	private Date dataOrcamento;
	private int validade;
	private List<Material> listaMaterial;
	
	public OrdemServico() {
		listaMaterial = new ArrayList<>();
	}

	public OrdemServico(int id, Cliente cliente, Habilitacao tipoProfissional, StatusOs status, Funcionario funcionario,
			String descricao, double horas, double valorHora, double valorTotal, Date dataOrcamento, int validade,
			List<Material> listaMaterial) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.tipoProfissional = tipoProfissional;
		this.status = status;
		this.funcionario = funcionario;
		this.descricao = descricao;
		this.horas = horas;
		this.valorHora = valorHora;
		this.valorTotal = valorTotal;
		this.dataOrcamento = dataOrcamento;
		this.validade = validade;
		this.listaMaterial = listaMaterial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Habilitacao getTipoProfissional() {
		return tipoProfissional;
	}

	public void setTipoProfissional(Habilitacao tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}

	public StatusOs getStatus() {
		return status;
	}

	public void setStatus(StatusOs status) {
		this.status = status;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getDataOrcamento() {
		return dataOrcamento;
	}

	public void setDataOrcamento(Date dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}

	public int getValidade() {
		return validade;
	}

	public void setValidade(int validade) {
		this.validade = validade;
	}

	public List<Material> getListaMaterial() {
		return listaMaterial;
	}

	public void setListaMaterial(List<Material> listaMaterial) {
		this.listaMaterial = listaMaterial;
	}

}
