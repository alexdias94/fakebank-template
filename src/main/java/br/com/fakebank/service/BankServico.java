package br.com.fakebank.service;

import br.com.fakebank.integration.vo.PessoaVO;
import br.com.fakebank.model.Cliente;
import br.com.fakebank.model.Conta;
import br.com.fakebank.model.TipoCartaoCredito;


public class BankServico {

	
	public Cliente solicitarCartaoCredito(PessoaVO pessoaVO, TipoCartaoCredito tipo) {
				
		return null;
	}
	
	
	private Cliente montarCliente(PessoaVO pessoaVO) {
		
		Cliente cliente = new Cliente(new Conta());
		cliente.setId(pessoaVO.getId().intValue());
		cliente.setNome(pessoaVO.getNome());
		cliente.setCpf(pessoaVO.getCpf());
		
		return cliente;
	}
	

		
}
