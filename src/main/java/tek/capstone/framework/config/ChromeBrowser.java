package tek.capstone.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowser implements Browser{

	// this class implements Browser interface
	// so it must implement method/s of Browser interface
	// by default, all method in interface are abstracted
	// this class opens chromeBrowser and navigates to application directlly
	
	public WebDriver openBrowser(String url) {
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		return driver;
	}

}
