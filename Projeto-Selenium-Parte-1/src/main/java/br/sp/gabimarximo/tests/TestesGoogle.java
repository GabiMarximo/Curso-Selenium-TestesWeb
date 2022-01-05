package br.sp.gabimarximo.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.sp.gabimarximo.core.BasePage;

public class TestesGoogle extends BasePage {

	private WebDriver driver;

	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		// driver = new ChromeDriver();
		// driver = new InternetExplorerDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		// driver.manage().window().maximize();

	}

	@Test
	public void teste() {
		driver.get("https://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
	}

}
