package br.sp.gabimarximo.suite;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.sp.gabimarximo.core.DriverFactory;
import br.sp.gabimarximo.pages.LoginPage;
import br.sp.gabimarximo.tests.ContaTest;
import br.sp.gabimarximo.tests.MovimentacaoTest;
import br.sp.gabimarximo.tests.RemoverMovimentacaoContaTest;
import br.sp.gabimarximo.tests.ResumoTest;
import br.sp.gabimarximo.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({ ContaTest.class, MovimentacaoTest.class, RemoverMovimentacaoContaTest.class, SaldoTest.class,
		ResumoTest.class })

public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		page.setEmail("a@c");
		page.setSenha("abc");
		page.entrar();
		page.resetar();
		
		DriverFactory.killDriver();
	}

}
