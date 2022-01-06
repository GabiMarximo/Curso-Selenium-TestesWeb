package br.sp.gabimarximo.suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.sp.gabimarximo.core.DriverFactory;
import br.sp.gabimarximo.tests.TesteRegrasCadastro;
import br.sp.gabimarximo.tests.TestesCampoTreinamentoCadastro;

@RunWith(Suite.class)
@SuiteClasses({ TestesCampoTreinamentoCadastro.class, TesteRegrasCadastro.class })

public class SuiteTeste {

	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}

}
