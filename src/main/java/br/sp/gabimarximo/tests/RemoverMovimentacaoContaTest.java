package br.sp.gabimarximo.tests;

import org.junit.Assert;
import org.junit.Test;

import br.sp.gabimarximo.core.BaseTest;
import br.sp.gabimarximo.pages.ContasPage;
import br.sp.gabimarximo.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void testExcluirContaComMovimentacao(){
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta("Conta com movimentacao");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
}