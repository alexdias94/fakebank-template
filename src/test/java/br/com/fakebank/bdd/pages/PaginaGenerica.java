package br.com.fakebank.bdd.pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public abstract class PaginaGenerica {

	private WebDriver driver;
	
	public PaginaGenerica(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement obterElementoByName(String nameLocator) {
		WebElement webElement = driver.findElement(By.name(nameLocator));
		return webElement;
	}
	
	public WebElement obterElementoByXpath(String xpathLocator) {
		return driver.findElement(By.xpath(xpathLocator));
	}
	
	public void preencherCampoTexto(WebElement element, String value) {
		
		if(Objects.isNull(element)) {
			return;
		}
		
		element.click();
		element.sendKeys(value);
	}
	
	public void aguardarEmSegundos(long tempoTotalAguardar, long tempoChecagem, WebElement element) {

		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(tempoChecagem))
															 .pollingEvery(Duration.ofSeconds(3))
															 .ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	
	}
}
