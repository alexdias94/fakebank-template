package br.com.fakebank.integration;

import java.io.IOException;
import java.util.Objects;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import com.google.gson.Gson;

import br.com.fakebank.Constantes;
import br.com.fakebank.integration.vo.PessoaVO;

public class ApiBankIntegration {

	public PessoaVO consultarCliente(String cpf)  {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		PessoaVO pessoaVO = null;
		try {

			HttpGet httpget = new HttpGet(obterUrConsultaCliente(cpf));
			
			ResponseHandleClienteVO responseHandler = new ResponseHandleClienteVO();
			
			pessoaVO = httpclient.execute(httpget, responseHandler);
					
			return pessoaVO;
	
		}catch (Exception e) {
			
			tratamento(e);
			
		} finally {
			
			fecharHttpClient(httpclient);
		}
		
		return pessoaVO;
	}
	
	public PessoaVO cadastrar(PessoaVO pessoa)  {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		PessoaVO pessoaVO = null;
		try {

			HttpPost httpPost = new HttpPost(obterUrCadastroCliente());
			
			httpPost.addHeader(new BasicHeader("Content-Type", "application/json"));
			
			StringEntity entity = new StringEntity(new Gson().toJson(pessoa).toString());
		
			httpPost.setEntity(entity);
						
			ResponseHandleClienteVO responseHandler = new ResponseHandleClienteVO();
			
			pessoaVO = httpclient.execute(httpPost, responseHandler);
		
			return pessoaVO;
	
		}catch (Exception e) {
			
			tratamento(e);
		
		} finally {
			
			fecharHttpClient(httpclient);
		}
		
		return pessoaVO;
	}
	
	public void deletar(String cpf)  {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		try {

			HttpDelete httpDelete = new HttpDelete(obterUrConsultaCliente(cpf));
					
			ResponseHandleClienteVO responseHandler = new ResponseHandleClienteVO();
			
			httpclient.execute(httpDelete, responseHandler);		
	
		}catch (Exception e) {
			
			tratamento(e);
		
		} finally {
			
			fecharHttpClient(httpclient);
		}
		
	}

	private void fecharHttpClient(CloseableHttpClient httpClient) {
		
		try {

			httpClient.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro ao fechar http client");
		}
	}

	private String obterUrConsultaCliente(String cpf) {
		return Constantes.URL_BASE_API + "/cliente/cpf/" + cpf;
	}
	private String obterUrCadastroCliente() {
		return Constantes.URL_BASE_API + "/cliente";
	}
	
	private void tratamento(Exception e) {
		if(!Objects.isNull(e)) {
			e.printStackTrace();
			System.out.println("ERRO AO REALIZAR CHAMADA NA API");			
		}
	}
	
}
