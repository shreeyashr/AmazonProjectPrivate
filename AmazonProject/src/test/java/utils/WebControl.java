package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebControl {
	
	public WebDriver driver;
	
	public WebControl(WebDriver driver){
		this.driver=driver;
	}

	public void switchWindowToChild() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String primaryPageWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
	}
}
