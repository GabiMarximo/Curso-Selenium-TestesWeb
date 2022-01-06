package br.sp.gabimarximo.tests;

import static br.sp.gabimarximo.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.sp.gabimarximo.core.BaseTest;
import br.sp.gabimarximo.pages.CampoTreinamentoPage;

public class TestesCampoTreinamentoCadastro extends BaseTest {

	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}

	@Test
	public void testeCadastro() {
		page.setNome("Gabrielle");
		page.setSobrenome("Marximo");
		page.setSexoFeminino();
		page.setComidaPizza();
		page.setEscolaridade("Superior");
		page.setEsporte("Futebol");
		page.cadastrar();

		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Gabrielle", page.obterNomeCadastro());
		Assert.assertEquals("Marximo", page.obterSobrenomeCadastro());
		Assert.assertEquals("Feminino", page.obterSexoCadastro());
		Assert.assertEquals("Pizza", page.obterComidaCadastro());
		Assert.assertEquals("superior", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Futebol", page.obterEsportesCadastro());
	}

}
