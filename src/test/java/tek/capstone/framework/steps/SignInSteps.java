package tek.capstone.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.framework.pages.POMFactory;
import tek.capstone.framework.utilities.CommonUtilities;

public class SignInSteps extends CommonUtilities{
	
	POMFactory factory = new POMFactory();
	
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(factory.signInPage().tekschoolLogo));
		logger.info("user is on retail website");
	}
	
	@When("user click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.homePage().signInOption);
		logger.info("user clicked on Sign in Option");
		
	}
	
	@And("User enter email {string} and password {string}")
	public void userEnterEmailPassword(String emailValue, String passValue) {
		sendText(factory.signInPage().emailField, emailValue);
		sendText(factory.signInPage().passWordField, passValue);
		logger.info("user entered email and password");
		
	}
	
	@And("User click on login button")
	public void UserClickOnLogInButton() {
		click(factory.signInPage().loginButton);
		logger.info("user clicked on login button");
		
		
	}
	
	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().accountOption));
		logger.info("user is logged in into Account");
		
	
		
		// Second Scenario from SignIn.feature file
	}
	
	
		
	@And("User clik on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.signInPage().createNewAccountButton);
		logger.info("User cliked on Create New Account option");
	}
	
	// DataTable concept:
	// we have 2 options:
	// 1. if our data table does not have Header we use <List<List>> List is index Based
	// 2. if data has Header, we use <List<Map>> as below. Map is key/value pair
	// name |email	    |password |confirmPassword| ====> Header
	// jack |jack@ma.com|Tek@12345|Tek@12345      |====> first row = index(0)
	// ahmad|ahmad@.com |Shams1234|Shams@123      |====> second row =index(1)
	
	// If i want to get "Shams123" get(index1).get(password) 
	@And("User fill the sign up information with bolow data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		sendText(factory.signInPage().createNewAccountNamefield,data.get(0).get("name"));
		sendText(factory.signInPage().createNewAccountEmailField,data.get(0).get("email"));
		sendText(factory.signInPage().createNewAccountpasswordField,data.get(0).get("password"));
		sendText(factory.signInPage().createNewAccountConfirmPasswordField,data.get(0).get("confirmPassword"));
		logger.info("User fill up information form");
		
	}
	
	@And("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.signInPage().signUpButton);
		logger.info("User clicked on sign up button");
	
	}
	
	@Then ("User should be logged in into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(isElementDisplayed(factory.accountPage().accountProfilePicture));
		logger.info("User is logged into account page");
	}
	
}
