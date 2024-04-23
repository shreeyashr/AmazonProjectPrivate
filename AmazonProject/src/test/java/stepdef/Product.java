package stepdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ProductPage;
import utils.Controller;

public class Product {

	public WebDriver driver;
	Controller controller;
	ProductPage productPage;
	String productPagePrice;
	String cartPagePrice;

	public Product(Controller controller) {
		this.controller = controller;
		// this.driver=controller.driver;
	}

	@Then("user searches for product {string}")
	public void user_searches_for_product(String product) {
		productPage=new ProductPage(controller.basePage.driver);
		productPage.searchProduct(product);
	}

	@And("user add the product number {int} to cart")
	public void Add_product_to_cart(int prodNum) {
		productPage.addProductToCart(prodNum);
	}

	@Then("user goes to cart from top menu")
	public void go_to_cart_extract_product_price() {
		productPage.goToCart();
	}

	@Then("user validates price on product page and cart price is same")
	public void compare_productPrice_and_cartPrice() {
		productPage.productCartPriceEqual();
	}
	
	@Then("user Validates product total price and cart subtotal is same")
	public void validate_productTotal_and_subTotal_is_same() {
		productPage.subTotalIsCorrect();
	}
	
	@And("user removes product from the cart")
	public void remove_product_from_cart() {
		productPage.removeProduct();
	}

}
