package br.sp.gabimarximo.tests;

import org.junit.Assert;
import org.junit.Test;

import br.sp.gabimarximo.core.BaseTest;
import br.sp.gabimarximo.pages.HomePage;
import br.sp.gabimarximo.pages.MenuPage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();
	
	@Test
	public void testSaldoConta() {
		menu.acessarTelaPrincipal();
		Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
	}

}
