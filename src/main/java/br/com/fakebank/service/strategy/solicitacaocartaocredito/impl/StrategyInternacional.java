package br.com.fakebank.service.strategy.solicitacaocartaocredito.impl;

import br.com.fakebank.Constantes;
import br.com.fakebank.exception.FakeBankNegocioException;
import br.com.fakebank.model.TipoCartaoCredito;
import br.com.fakebank.service.strategy.solicitacaocartaocredito.SolicitarCartaoCreditoStrategy;

public class StrategyInternacional implements SolicitarCartaoCreditoStrategy {

	@Override
	public TipoCartaoCredito obter(Double saldo) {
			
		if(saldo > 1000) {
			return TipoCartaoCredito.INTERNACIONAL;
		}
		
		throw new FakeBankNegocioException(Constantes.MSG_REQUISITO_INVALIDO_CARTAO);
	}

}
