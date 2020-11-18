package br.com.fakebank.model;

import java.util.Objects;

public class Conta {

	private String agencia;
	private String numero;
	private TipoConta tipo;
	private Double saldo;
	private TipoCartaoCredito tipoCredito;

	public Conta() {

	}

	public Conta(Double saldo) {
		this.saldo = saldo;
	}

	public void depositar(Double valorDepositado) {


	}

	public String sacar(Double valorSacado) {

		return "";
	}

	public void transferir(Conta destino, Double valor) {

	}

	public TipoCartaoCredito getTipoCredito() {
		return tipoCredito;
	}

	public void setTipoCredito(TipoCartaoCredito tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public Double getSaldo() {

		if (Objects.isNull(this.saldo)) {
			return 0.0;
		}

		return saldo;
	}
	
}
