package br.com.fakebank.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaEnvioMensagem extends PaginaGenerica {

	private WebDriver driver;
	
	public PaginaEnvioMensagem(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
		
	public void preencherCampoPrimeiroNome(String valor) {
		WebElement webElement = obterElementoByName("first_name");
		preencherCampoTexto(webElement, valor);
	}
	
	public void preencherCampoUltimoNome(String valor) {
		WebElement webElement = obterElementoByName("last_name");
		preencherCampoTexto(webElement, valor);
	}
	
	public void preencherCampoEmail(String valor) {
		WebElement webElement = obterElementoByName("email");
		preencherCampoTexto(webElement, valor);
	}
	
	public void preencherCampoMensagem(String valor) {
		WebElement webElement = obterElementoByXpath("//form[@id='contact_form']/textarea");
		preencherCampoTexto(webElement, valor);
	}
	
	public void clickBotaoSubmit() {
		WebElement webElement = obterElementoByXpath("//div[@id='form_buttons']/input[2]");
		webElement.click();
	}
	
	
}
