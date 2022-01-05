package br.sp.gabimarximo.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.sp.gabimarximo.core.BasePage;
import br.sp.gabimarximo.core.DSL;
import br.sp.gabimarximo.core.DriverFactory;
import static br.sp.gabimarximo.core.DriverFactory.getDriver;

public class TestesSincronismo extends BasePage {

	private DSL dsl;

	@Before
	public void inicializa() {
		DriverFactory.getDriver()
				.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}

	@Test
	public void testeRespostaDemoradaEsperaFixa() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		Thread.sleep(5000);
		dsl.escrever("novoCampo", "Deu certo?");

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testeRespostaDemoradaEsperaImplicita() {
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dsl.clicarBotao("buttonDelay");
		dsl.escrever("novoCampo", "Deu certo?");
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testeRespostaDemoradaEsperaExplicita() {
		dsl.clicarBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escrever("novoCampo", "Deu certo?");
	}

}
