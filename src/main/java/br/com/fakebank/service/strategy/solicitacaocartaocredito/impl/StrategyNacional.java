package br.com.fakebank.service.strategy.solicitacaocartaocredito.impl;

import br.com.fakebank.Constantes;
import br.com.fakebank.exception.FakeBankNegocioException;
import br.com.fakebank.model.TipoCartaoCredito;
import br.com.fakebank.service.strategy.solicitacaocartaocredito.SolicitarCartaoCreditoStrategy;

public class StrategyNacional implements SolicitarCartaoCreditoStrategy {

	@Override
	public TipoCartaoCredito obter(Double saldo) {
		
		if(temUmSaldoValido(saldo)) {
			return TipoCartaoCredito.NACIONAL;
		}
		
		throw new FakeBankNegocioException(Constantes.MSG_REQUISITO_INVALIDO_CARTAO);
	}

	private boolean temUmSaldoValido(Double saldo) {
		return saldo >= 100 && saldo <= 1000;
	}

}
