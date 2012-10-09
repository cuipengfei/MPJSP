package Collector.Test.Functional;

import java.util.concurrent.TimeUnit;

import org.concordion.integration.junit3.ConcordionTestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumHappyPath extends ConcordionTestCase {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:6789";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void happyPathTest() throws Exception {
		driver.get(baseUrl + "/spring_sample/Collector");
		assertEquals("name page", driver.getTitle());
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("selenium");
		driver.findElement(By.id("next")).click();
		assertEquals("hobby page", driver.getTitle());
		driver.findElement(By.name("hobby")).clear();
		driver.findElement(By.name("hobby")).sendKeys("test web app");
		driver.findElement(By.id("next")).click();
		assertEquals("result page", driver.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
