package br.com.fakebank.model;

import java.util.Objects;
import java.util.stream.Stream;

public enum TipoConta {

	CORRENTE(1, "Conta Corrente"), POUPANCA(2, "Conta Poupança");

	private Integer codigo;
	private String descricao;

	private TipoConta(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public TipoConta comoEnum(Integer codigo) {

		if (Objects.isNull(codigo)) {
			return null;
		}

		return Stream.of(TipoConta.values()).filter(t -> t.getCodigo().equals(codigo)).findFirst().orElseGet(null);
	}
}
