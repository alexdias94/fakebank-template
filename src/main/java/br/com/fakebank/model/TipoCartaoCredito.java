package br.com.fakebank.model;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author pedro
 *  
 *  Regras : 
 *  
 *  Black : Ter um saldo >= 15.000
 *  
 *  Internacional : Ter um saldo > 1.000 reais 
 *  
 *  Nacional : Ter um saldo >= 100 e <= 1000  
 */
public enum TipoCartaoCredito {

	NACIONAL(1, "Nacional"), INTERNACIONAL(2 , "Internacional"), BLACK(3, "Black");

	private Integer codigo;
	private String descricao;

	private TipoCartaoCredito(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static TipoCartaoCredito comoEnum(Integer codigo) {

		if (Objects.isNull(codigo)) {
			return null;
		}

		return Stream.of(TipoCartaoCredito.values()).filter(t -> t.getCodigo().equals(codigo)).findFirst().orElseGet(null);
	}
}
