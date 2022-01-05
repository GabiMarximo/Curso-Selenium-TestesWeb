package br.sp.gabimarximo.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.sp.gabimarximo.core.BasePage;
import br.sp.gabimarximo.core.DSL;
import br.sp.gabimarximo.core.DriverFactory;
import static br.sp.gabimarximo.core.DriverFactory.getDriver;

public class TestesCampoTreinamentoBotoesEJanelas extends BasePage {

	private DSL dsl;

	@Before
	public void inicializa() {
		DriverFactory.getDriver()
				.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}

	@Test
	public void testeCliqueMe() {
		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimples"));
	}

	@Test
	public void testeAlertSimples() {
		dsl.clicarBotao("alert");
		String texto = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Alert Simples", texto);

		dsl.escrever("elementosForm:nome", texto);
	}

	@Test
	public void testeConfirmSimplesConfirmado() {
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void testeConfirmSimplesNegado() {
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
	}

	@Test
	public void testePrompt() {
		dsl.clicarBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
		Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void testeFrame() {
		dsl.entrarFrame("frame1");
		dsl.clicarBotao("frameButton");
		String mensagem = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", mensagem);

		dsl.sairFrame();
		dsl.escrever("elementosForm:nome", mensagem);
	}

	@Test
	public void testeAbrirPopUp() {
		dsl.clicarBotao("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escrever(By.tagName("textarea"), "Deu Certo?");
		getDriver().close();
		dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[0]);
		dsl.escrever(By.tagName("textarea"), "e agora?");
	}

	@Test
	public void testeAbrirPopUpDoMal() {
		dsl.clicarBotao("buttonPopUpHard");
		System.out.println(getDriver().getWindowHandle());
		System.out.println(getDriver().getWindowHandle());
		dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[1]);
		dsl.escrever(By.tagName("textarea"), "Deu Certo?");
		dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[0]);
		dsl.escrever(By.tagName("textarea"), "e agora?");
	}

	@Test
	public void testeFrameEscondido() {
		WebElement frame = getDriver().findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		String mensagem = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", mensagem);
	}
}
