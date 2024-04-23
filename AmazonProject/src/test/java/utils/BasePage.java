package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

	public WebDriver driver;
	String userDir = System.getProperty("user.dir");

	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis=new FileInputStream(userDir+"\\src\\test\\resources\\DefaultVariables.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver",
					userDir + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}

}
