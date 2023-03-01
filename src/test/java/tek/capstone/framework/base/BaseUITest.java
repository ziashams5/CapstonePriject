package tek.capstone.framework.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.capstone.framework.utilities.CommonUtilities;

public class BaseUITest extends CommonUtilities{
	
	@Before
	public void setupTest() {
		super.setupBrowser();
	}
	
	@After
	public void closeTests(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[]screenshot = takeScreenShotAsBytes();
			scenario.attach(screenshot, "image/png", scenario.getName()+"scenario Failled");
		}
		super.quitBrowser();
		
	}
	

}
