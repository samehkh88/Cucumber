package CucumberOptions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


@CucumberOptions(features="src/test/java/features"
,glue= {"stepDefinations"}
,plugin= {"pretty","html:target/cucumber-html-report"},
tags="@One")
public class TestRunner1 extends AbstractTestNGCucumberTests
{
	public static WebDriver driver ;

	@BeforeSuite
	@Parameters({ "browser" })
	public void Startdriver(@Optional("chrome") String BrowserName)

	{
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (BrowserName.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	//take screenshot when test case fail

	
	@AfterClass
	public void WaitAfterClass()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void WaitAftermethod()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@AfterSuite
	public void StopDriver()
	{
		driver.quit();
	}

}
	
   

