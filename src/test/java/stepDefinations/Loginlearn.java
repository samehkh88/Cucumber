package stepDefinations;


import org.testng.Assert;

import CucumberOptions.TestRunner1;
import Pages.HomePage;
import Pages.UserloginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Loginlearn extends TestRunner1{

	HomePage Home;
	UserloginPage loginpage;
	
	@Given("the User in home page")
	public void the_user_in_home_page() {
		Home = new HomePage(driver);
		Home.OpenLoginPage();
	}
	
	@When("user enter his user {string} and password {string} and click login")
	    public void user_enter_his_user_something_and_password_something_and_click_login(String UserName, String Password) {
		loginpage = new UserloginPage(driver);
		loginpage.UserCanLogin(UserName, Password);
	}

	@Then("the system redirect to the home page and log out appear")
	public void the_system_redirect_to_the_home_page_and_log_out_appear()  {
		Assert.assertEquals("Log out", Home.logOutLink.getText());
	}

}
