package br.com.fakebank;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.fakebank.exception.FakeBankNegocioException;
import br.com.fakebank.exception.SaldoInsuficienteException;
import br.com.fakebank.model.Conta;


public class FakeBankTesteUnidade {
	
	private Conta conta;
	
	@Before
	public void before() {
		this.conta = new Conta();
	}
	
	/**
 	 * Objetivo do teste : 	Validar um deposito valido
	 */
	@Test
	public void deveDepositarValorValido() {
		conta.depositar(10.0);
		assertEquals(conta.getSaldo(), Double.valueOf(10.0));
	}

	
	/**
 	 * Objetivo do teste : 	Validar tratamento quando valor é negativo
 	 * 
	 */
	@Test(expected = FakeBankNegocioException.class)
	public void deveInvalidarDepositoValorNegativo() {
		conta.depositar(-10.0);
	}
	
	/**
 	 * Objetivo do teste : 	Validar tratamento quando valor é zero
 	 * 
	 */
	@Test(expected = FakeBankNegocioException.class)
	public void deveInvalidarDepositoValorZero() {
		conta.depositar(0.0);
	}
	
	/**
 	 * Objetivo do teste : 	Validar saque valido
 	 * 
	 */
	@Test
	public void deveRealizarSaque() {
		conta.depositar(10.0);
		conta.sacar(9.0);
		assertEquals(conta.getSaldo(), Double.valueOf(1.0));
	}
	
	/**
 	 * Objetivo do teste : 	Validar saque invalido quando o valor ultrapassa saldo da conta
 	 * 
	 */
	@Test(expected = SaldoInsuficienteException.class)
	public void deveInvalidarSaque() {		
		conta.depositar(10.0);
		conta.sacar(11.0);
	}
	
	/**
 	 * Objetivo do teste : 	Validar saque invalido quando valor negativo
 	 * 
	 */
	@Test(expected = FakeBankNegocioException.class)
	public void deveInvalidarSaqueComValorNegativo() {		
		conta.depositar(10.0);
		conta.sacar(-11.0);
	}

	/**
 	 * Objetivo do teste : 	Validar saque invalido quando valor nulo
 	 * 
	 */
	@Test(expected = FakeBankNegocioException.class)
	public void deveInvalidarSaqueComValorNulo() {		

		conta.sacar(null);
	}

	/**
 	 * Objetivo do teste : 	Validar saque invalido quando saldo insuficiente
 	 * 
	 */
	@Test(expected = SaldoInsuficienteException.class)
	public void deveInvalidarSaqueSaldoInsuficiente() {		
		
		Conta destino = new Conta();
		conta.transferir(destino, 10.0);
		
	}
	
	/**
 	 * Objetivo do teste : 	Validar transferencia valido com conta de destino com saldo zerado
 	 * 
	 */
	@Test
	public void deveTransferirValoresEntreContasComDestinoZerado() {		
		
		conta.depositar(100.0);		
		
		Conta destino = new Conta();
		
		conta.transferir(destino, 10.0);

		assertEquals(conta.getSaldo(), Double.valueOf(90.0));
		assertEquals(destino.getSaldo(), Double.valueOf(10.0));

	}
	
	/**
 	 * Objetivo do teste : 	Validar transferencia valido com conta de destino com saldo
 	 * 
	 */
	@Test
	public void deveTransferirValoresEntreContasComSaldo() {		
		
		conta.depositar(100.0);		
		Conta destino = new Conta(200.0);
		
		conta.transferir(destino, 50.0);
		
		assertEquals(destino.getSaldo(), Double.valueOf(250.0));
		assertEquals(conta.getSaldo(), Double.valueOf(50.0));

	}


}
