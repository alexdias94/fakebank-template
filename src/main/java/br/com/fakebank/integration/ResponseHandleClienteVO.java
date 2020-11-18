package br.com.fakebank.integration;

import java.io.IOException;
import java.util.Objects;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import br.com.fakebank.integration.vo.PessoaVO;

public class ResponseHandleClienteVO implements ResponseHandler<PessoaVO>{

	@Override
	public PessoaVO handleResponse(HttpResponse response) throws ClientProtocolException, IOException {

		int status = response.getStatusLine().getStatusCode();
		
		if (temStatusValido(status)) {
			
			return converter(response);
		
		} else {
			
			throw new ClientProtocolException("Resultado não esperado : " + status);
		}
		
	}

	private PessoaVO converter(HttpResponse response) throws ParseException, IOException {
		
		HttpEntity entity = response.getEntity();
		String json = Objects.isNull(entity) ? null  : EntityUtils.toString(entity);
		
		if(Objects.isNull(json) || json.isEmpty()) {
			return null;
		}
		
		return new Gson().fromJson(json, PessoaVO.class);
	}

	
	private boolean temStatusValido(int status) {
		return status >= 200 && status < 300;
	}
	
}
