package tek.capstone.framework.config;

import org.openqa.selenium.WebDriver;

public interface Browser {
	
	
	
	// this interface has one method and returns webDriver
	// we implement the concept of Interface
	
	WebDriver openBrowser(String url);
	

}
