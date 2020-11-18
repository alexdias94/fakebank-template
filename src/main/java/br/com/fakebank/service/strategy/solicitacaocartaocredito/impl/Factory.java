package br.com.fakebank.service.strategy.solicitacaocartaocredito.impl;

import java.util.Objects;

import br.com.fakebank.exception.FakeBankNegocioException;
import br.com.fakebank.model.TipoCartaoCredito;
import br.com.fakebank.service.strategy.solicitacaocartaocredito.SolicitarCartaoCreditoStrategy;

public class Factory {

	
	public static SolicitarCartaoCreditoStrategy obterInstancia(TipoCartaoCredito tipo) {
	
		if(Objects.isNull(tipo)) {
			FakeBankNegocioException.throwException("Tipo cartao inválido");
		}
		
		return  obterPorTipo(tipo);
	}
	
	private  static SolicitarCartaoCreditoStrategy obterPorTipo(TipoCartaoCredito tipo) {
		
		switch (tipo) {
		
		case INTERNACIONAL:
			
			return new StrategyInternacional();
			
		case NACIONAL:
			
			return new StrategyNacional();
			
			
		case BLACK:
			
			return new StrategyBlack();

		default:
			break;
		}
		
		return null;
	}
	
}
