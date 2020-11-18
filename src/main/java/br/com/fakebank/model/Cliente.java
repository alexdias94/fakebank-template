package br.com.fakebank.model;

import java.util.Objects;

public class Cliente {

	private Integer id;
	private String cpf;
	private String nome;
	private String telefone;
	private Conta conta;

	
	public Cliente(Conta conta) {
		this.conta = conta;	
	}
	
	public void atribuirCartaoCredito(TipoCartaoCredito tipo) {
		if(Objects.isNull(this.conta)) {
			this.conta =  new Conta();
		}
		this.conta.setTipoCredito(tipo);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
