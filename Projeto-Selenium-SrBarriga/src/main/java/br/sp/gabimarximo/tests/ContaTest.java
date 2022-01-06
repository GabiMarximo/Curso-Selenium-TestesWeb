package br.sp.gabimarximo.tests;

import org.junit.Assert;
import org.junit.Test;

import br.sp.gabimarximo.core.BaseTest;
import br.sp.gabimarximo.pages.ContasPage;
import br.sp.gabimarximo.pages.MenuPage;

public class ContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void testInserirConta() {
		menuPage.acessarTelaInserirConta();

		contasPage.setNome("Conta de Teste");
		contasPage.salvar();

		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}

	@Test
	public void testAlterarConta() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarAlterarConta("Conta para alterar");
		contasPage.setNome("Conta alterada");
		contasPage.salvar();

		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());

	}

	@Test
	public void testInserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta mesmo nome");
		contasPage.salvar();

		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
}
