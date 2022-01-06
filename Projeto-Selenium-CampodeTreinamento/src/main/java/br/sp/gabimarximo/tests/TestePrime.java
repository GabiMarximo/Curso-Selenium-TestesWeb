package br.sp.gabimarximo.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.sp.gabimarximo.core.BasePage;
import br.sp.gabimarximo.core.DSL;
import static br.sp.gabimarximo.core.DriverFactory.getDriver;

public class TestePrime extends BasePage {

	private DSL dsl;

	@Before
	public void inicializa() {
		dsl = new DSL();
	}

	@Test
	public void testeInteragirComRadio() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=c6eac");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt312:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='Option2']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:1"));
	}

	@Test
	public void testeInteragirComSelectPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=e5faa");
		dsl.selecionarComboPrime("j_idt311:option", "Option1");
		Assert.assertEquals("Option1", dsl.obterTexto("j_idt311:option_label"));
	}

}
