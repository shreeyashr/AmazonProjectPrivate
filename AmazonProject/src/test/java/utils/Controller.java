package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pages.PageObjectFactory;

public class Controller {
	
	public WebDriver driver;
	public PageObjectFactory pageObjectFactory;
	public BasePage basePage;
	public WebControl webControl;
	
	public Controller() throws IOException {
		basePage=new BasePage();
		pageObjectFactory=new PageObjectFactory(basePage.WebDriverManager());
		webControl=new WebControl(basePage.WebDriverManager());
	}

}
