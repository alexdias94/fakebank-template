package br.com.fakebank;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.fakebank.exception.FakeBankNegocioException;
import br.com.fakebank.integration.ApiBankIntegration;
import br.com.fakebank.service.BankServico;



public class TesteIntegracao {


	private static BankServico servico;
	
	/**
	 * Api de clientes 
	 * metodos : 
	 * 			 consultarCliente(String cpf) 
	 * 			 cadastrar(PessoaVO pessoa) 
	 *  		 deletar(String cpf)
	 */
	private static ApiBankIntegration apiBank;

	@BeforeClass
	public static void antesDeTudo () {
		apiBank = new ApiBankIntegration();
		servico = new BankServico();
	}

	
	@AfterClass
	public static void noFimDeTudo () {
		
	}

	/**
 	 * Objetivo do teste : 	Validar pessoa com saldo fora do permitido
	 * Tem saldo inferior ao solicitado para cartao nacional
	 * Nacional : Ter um saldo >= 100 E <= 1000  
	 */
	@Test(expected = FakeBankNegocioException.class)
	public void deveInvalidarSolicitacaoCreditoInferiorAoPermitido() {

	}

	/**
	 * Objetivo do teste : 	Validar pessoa com restrição serasa
	 * Tem saldo válido para cartão nacional
	 * Nacional : Ter um saldo >= 100 E <= 1000  
	 */
	@Test(expected = FakeBankNegocioException.class)
	public void deveInvalidarSolicitacaoDevidoRegistroSerasa() {

	}
	
	/**
	 * Objetivo do teste : 	Validar pessoa com todos criterios necessários
	 * Pessoa tem restrição serasa
	 * Tem saldo válido para cartão nacional
	 * Nacional : Ter um saldo >= 100 E <= 1000  
	 */
	@Test
	public void deveValidarSolicitacaoAtendeAosCriterios() {

	}


}
