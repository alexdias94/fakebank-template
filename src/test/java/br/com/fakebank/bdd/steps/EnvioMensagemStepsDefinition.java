package br.com.fakebank.bdd.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.fakebank.bdd.pages.PaginaEnvioMensagem;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EnvioMensagemStepsDefinition {
	
	private WebDriver driver;
	private PaginaEnvioMensagem pagina;
	
	public EnvioMensagemStepsDefinition () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		this.pagina = new PaginaEnvioMensagem(driver);
	}
	
	@Given("Que estou na pagina de envio de mensagem")
	public void dadoQueEstouNaPaginaInicial() {
		driver.get("http://www.google.com");
	}

	@When("Preencher o campo primeiro nome {string}")
	public void preencherCampoPrimeiroNome(String primeiroNome) {

	}	
	
	@And("Preencher o campo ultimo nome {string}")
	public void preencherCampoUltimoNome(String ultimoNome) {

	}
	
	@And("Preencher o campo email {string}")
	public void preencherCampoEmail(String email) {

	}
	
	@And("Preencher o campo mensagem {string}")
	public void preencherCampoMensagem(String mensagem) {

	}
	
	@Then("Clicar no botao submit sistema deve validar os dados a apresentar mensagem {string}")
	public void validarDados(String mensagem) {
		assertEquals("sucesso", "erro");
		driver.close();

	}

	
}
