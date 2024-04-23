package stepdef;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utils.Controller;

public class Login {

	public WebDriver driver;
	Controller controller;
	LoginPage loginPage;

	public Login(Controller controller) {
		this.controller = controller;
	}

	@Given("user validate amazon homepage is loaded")
	public void I_validate_amazon_homepage_is_loaded() {
		loginPage=new LoginPage(controller.basePage.driver);
		loginPage.validateHomePage();
	}

	@Then("user click on signIn button")
	public void click_signIn_button() {
		loginPage.clickSignInBtn();
	}

	@Then("user enters username")
	public void User_enters_username() {
		loginPage.enterUserName();
	}

	@Then("user enters password")
	public void User_enters_password() {
		loginPage.enterPassword();
	}

	@Then("user click on login and confirms Login")
	public void User_click_on_login_and_confirms_Login() {
		loginPage.clickUserSignIn();
	}

}
