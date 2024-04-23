package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectFactory {
	
	public WebDriver driver;
	public LoginPage loginPage;
	public ProductPage productPage;
	
	public PageObjectFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage getLoginPage() {
		loginPage=new LoginPage(driver);
		return loginPage;
	}
	
	public ProductPage getProductPage() {
		productPage=new ProductPage(driver);
		return productPage;
	}

}
