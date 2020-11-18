package br.com.fakebank.service.strategy.solicitacaocartaocredito;

import br.com.fakebank.model.TipoCartaoCredito;

public interface SolicitarCartaoCreditoStrategy {

	public TipoCartaoCredito obter(Double saldo);
}
