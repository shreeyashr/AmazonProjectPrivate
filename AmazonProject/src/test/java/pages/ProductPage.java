package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductPage {

	WebDriver driver;
	float productPagePrice;
	float cartPagePrice;
	float subTotal;
	float addedProductTotal=0;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
	By searchBtn = By.xpath("//input[@id='nav-search-submit-button']");
	By addToCartBtn = By.xpath("//*[text()='Add to Cart']");
	By closePanel = By.cssSelector("a#attach-close_sideSheet-link");
	By navigateToCart = By.xpath("//span[@class='nav-cart-icon nav-sprite']");
	By productPriceInCart = By.xpath("(//*[@class='sc-badge-price-to-pay'])");
	By subTotalElement = By.xpath("//span[@id='sc-subtotal-amount-activecart']");
	By deleteProduct = By.xpath("//input[@value='Delete']");
	
	public void searchProduct(String product) {
		driver.findElement(searchBox).sendKeys(product);
		driver.findElement(searchBtn).click();
	}
	
	public void getProductPagePrice() {
		
	}

	public void addProductToCart(int prodNum) {
		WebElement productPageValue=driver.findElement(By.xpath("(//div[@data-cy='title-recipe'])["+prodNum+"]//parent::div//span[@class='a-price-whole']"));
		productPagePrice = Float.parseFloat(productPageValue.getText().replaceAll("[^0-9.]", ""));
		System.out.println("**********productPagePrice is "+productPagePrice+"**********");
		WebElement addToCart=driver.findElement(By.xpath("(//div[@data-cy='title-recipe'])["+prodNum+"]//parent::div//button"));
		addToCart.click();
		addedProductTotal=addedProductTotal+productPagePrice;
		System.out.println("**********productTotal is "+addedProductTotal+"**********");
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
	}

	public void goToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(navigateToCart)));
		WebElement navigateToCart=driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click(); ", navigateToCart);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(productPriceInCart)));
		cartPagePrice = Float.parseFloat(driver.findElement(productPriceInCart).getText().replaceAll("[^0-9.]", ""));
		System.out.println("**********cartPagePrice is "+cartPagePrice+"**********");
	}
	
	public void productCartPriceEqual() {
		Assert.assertEquals(productPagePrice, cartPagePrice);
	}
	
	public void subTotalIsCorrect() {
		WebElement subTotalPriceElement=driver.findElement(subTotalElement);
		wait.until(ExpectedConditions.visibilityOf(subTotalPriceElement));
		subTotal=Float.parseFloat(subTotalPriceElement.getText().replaceAll("[^0-9.]", ""));
		System.out.println("**********ActualsubTotalPrice is "+subTotal+"**********");
		Assert.assertEquals(addedProductTotal, subTotal);
	}
	
	public void removeProduct() {
		driver.findElement(deleteProduct).click();
	}

}
