package tek.capstone.framework.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import tek.capstone.framework.config.Browser;
import tek.capstone.framework.config.ChromeBrowser;
import tek.capstone.framework.config.ChromeHeadless;
import tek.capstone.framework.config.FirefoxBrowser;
import tek.capstone.framework.utilities.ReadYamlFiles;

public class BaseSetup {
	
	// also called CoreClass and it is parent of all other classes
	// StepDefinations,CommonUtility and POM classes extends this class
	// this class defines properties of WebDriver
	// we define methods to manage window,close driver. basically, everything we do with WebDriver
	
	// we implement the concept of inheratance
	
	// variables:
	private static WebDriver webDriver;	
	// we create final method. since below varialbe is just declared,we must intitialze it otherwise it gives us error
	private final ReadYamlFiles environmentVariables;
	public static Logger logger; // is a class that logs each step
	
	
	
	
	// constructor
	public BaseSetup()  {
		// we crate a path to locate env_config.yml
		String filePath = System.getProperty("user.dir")+"/src/main/resources/env_config.yml";
		String log4JPath = System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
		
		try {
			environmentVariables = ReadYamlFiles.getInstance(filePath);
		} catch (FileNotFoundException e) {
			System.out.println("Failed for environment exntext.check possible file path errors");//optional
			throw new RuntimeException("Failed for environment exntext with message"+ e.getMessage());//optional
		}
		
		
		
		logger = logger.getLogger("logger File");
		PropertyConfigurator.configure(log4JPath);
		
	}
	
	
	
	// create a method to return single session of webDriver;
	public WebDriver getDriver() {
		return webDriver;
	}
	
	
	public void setupBrowser() {
		//this method will get/read "ui" information/properties from env_congig.yml using getYamlProperty mehod from ReadYamlFiles 
		// same way if we have "db" data base properties
		HashMap uiProperties = environmentVariables.getYamlProperty("ui");
		String url = uiProperties.get("url").toString();
		Browser browser;
		switch (uiProperties.get("browser").toString().toLowerCase()) {
		case "chrome":
			if((boolean) uiProperties.get("headless")) {
			
				browser = new ChromeHeadless();
			}else{
			
				browser = new ChromeBrowser();
			
			}
			webDriver = browser.openBrowser(url);
			break;
		case "firefox":
			browser = new FirefoxBrowser();
			webDriver = browser.openBrowser(url);
			break;
		case "edge":
			browser = new FirefoxBrowser();
			webDriver = browser.openBrowser(url);
			break;
			
			default:
				throw new RuntimeException("unknow Browser check environment properties");
		}
		
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.of(20, ChronoUnit.SECONDS));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	
	public void quitBrowser() {
		if (webDriver!=null)
			webDriver.quit();
	}
	

}
