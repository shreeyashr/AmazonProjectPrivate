package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		this.driver=driver;				
	}
	
	By AmazonLabel=By.xpath("//a[@aria-label='Amazon.in']");
	By signInBtn=By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
	By userName=By.xpath("//input[@id='ap_email']");
	By continueBtn=By.xpath("//input[@id='continue']");
	By password=By.xpath("//input[@id='ap_password']");
	By userSignInBtn=By.xpath("//input[@id='signInSubmit']");
	
	public void validateHomePage() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(driver.findElement(AmazonLabel))).isDisplayed());
	}
	
	public void clickSignInBtn() {
		driver.findElement(signInBtn).click();
	}
	
	public void enterUserName() {
		driver.findElement(userName).sendKeys("shreeyashr@gmail.com");
		driver.findElement(continueBtn).click();
	}
	
	public void enterPassword() {
		driver.findElement(password).sendKeys("Shweta@123");
	}
	
	public void clickUserSignIn() {
		driver.findElement(userSignInBtn).click();
	}
}
