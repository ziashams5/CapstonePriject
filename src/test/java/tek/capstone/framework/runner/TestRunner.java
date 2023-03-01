package tek.capstone.framework.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;;

// we write on top of the class scope 
// both RunWith() and CucumberOptions are Interfaces
@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@registerNewAccount",// test - smoke
		features = "classpath:features", // we provide/define the address/path of feaures file-folder
		glue ="tek.capstone.framework", // define the address StepDefination class/ do not provide step
		dryRun = false,
		plugin = {//for reporting
				"pretty",
                "html:target/htmlReports/cucumber-pretty.html",// we can email this report
                "json:target/jsonReports/cucumber.json"// used by JVM to generate charts/graph
		},
		snippets = CAMELCASE,
		monochrome = true// makes it readable
		
		)

public class TestRunner {
	
	// this is the entry point to automate test cases
	// if u decide to name your class other then TestRunner, then u have to change the name in POM.xml file too

}
