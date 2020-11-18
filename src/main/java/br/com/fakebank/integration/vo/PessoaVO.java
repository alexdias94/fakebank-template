package br.com.fakebank.integration.vo;

public class PessoaVO {

	private Long id;
	private String cpf;
	private String situacao;
	private Double credito;
	private String nome;
	
	
	public PessoaVO() {}
	
	public PessoaVO(String cpf,String situacao, Double credito, String nome) {
		this.cpf = cpf;
		this.situacao = situacao;
		this.credito = credito;
		this.nome = nome;
	}
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Double getCredito() {
		return credito;
	}
	public void setCredito(Double credito) {
		this.credito = credito;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
