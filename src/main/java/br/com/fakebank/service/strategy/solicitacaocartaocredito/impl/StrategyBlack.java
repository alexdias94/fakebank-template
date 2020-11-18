package br.com.fakebank.service.strategy.solicitacaocartaocredito.impl;

import br.com.fakebank.Constantes;
import br.com.fakebank.exception.FakeBankNegocioException;
import br.com.fakebank.model.TipoCartaoCredito;
import br.com.fakebank.service.strategy.solicitacaocartaocredito.SolicitarCartaoCreditoStrategy;

public class StrategyBlack implements SolicitarCartaoCreditoStrategy {

	@Override
	public TipoCartaoCredito obter(Double credito) {

		if (credito >= 15.000) {
			return TipoCartaoCredito.BLACK;
		}

		throw new FakeBankNegocioException(Constantes.MSG_REQUISITO_INVALIDO_CARTAO);
	}

}
