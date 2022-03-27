package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class UserloginPage extends PageBase {

	public UserloginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@id='Email']")
	@CacheLookup
	public WebElement emailField;
	
	
	@FindBy(xpath = "//input[@id='Password']")
	@CacheLookup
	public WebElement passwordField;
	
	@FindBy(xpath = "//button[@class=\"button-1 login-button\"]")
	@CacheLookup
	public WebElement LoginButton;
	
	public void UserCanLogin(String mail , String Password)
	{
		SendValue(emailField, mail);
		SendValue(passwordField, Password);
		ClickButtons(LoginButton);
	}

}
