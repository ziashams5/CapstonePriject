package tek.capstone.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeBrowser implements Browser{

	@Override
	public WebDriver openBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get(url);
		return driver;
	}

}
