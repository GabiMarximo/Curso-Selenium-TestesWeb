package br.sp.gabimarximo.tests;

import static br.sp.gabimarximo.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.sp.gabimarximo.core.BasePage;
import br.sp.gabimarximo.core.DSL;
import br.sp.gabimarximo.core.DriverFactory;

public class TesteAjax extends BasePage {

	private DSL dsl;

	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=c6eac");
		dsl = new DSL();
	}

	@Test
	public void testeAjax() {
		dsl.escrever("j_idt311:name", "Teste");
		dsl.clicarBotao("j_idt311:j_idt315");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt311:display"), "Teste"));
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt311:display"));
	}

}
