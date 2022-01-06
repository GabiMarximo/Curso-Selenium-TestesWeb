package br.sp.gabimarximo.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = false;

	public static Browsers BROWSER = Browsers.FIREFOX;
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.NUVEM;
	
	public enum Browsers {
		CHROME, FIREFOX, IE
	}
	
	public enum TipoExecucao {
		LOCAL,
		GRID,
		NUVEM
	}

}
