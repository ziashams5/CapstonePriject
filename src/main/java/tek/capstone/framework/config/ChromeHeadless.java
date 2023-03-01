package tek.capstone.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeHeadless implements Browser{

	@Override
	public WebDriver openBrowser(String url) {

		WebDriverManager.chromedriver().setup();
		
		// each browser class has its own options by using options class - ChromeOptions-FirefoxOptions-EdgeOptions
		// you can use options class to make headless, define a specific version to excute,
		//,pass SSL crtifications to excute in differen mode like incognito/private mode 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		//options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		return driver;
	}

}
