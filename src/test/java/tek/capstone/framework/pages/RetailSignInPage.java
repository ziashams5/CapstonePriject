package tek.capstone.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.framework.base.BaseSetup;

public class RetailSignInPage extends BaseSetup {
	
	public RetailSignInPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(linkText = "TEKSCHOOL")
	public WebElement tekschoolLogo;
	@FindBy(id="email")
	public WebElement emailField;
	
	@FindBy(id = "password")
	public WebElement passWordField;
	
	@FindBy(id = "loginBtn")
	public WebElement loginButton;
	
	@FindBy(id="newAccountBtn")
	public WebElement createNewAccountButton;
	
	@FindBy(id="nameInput")
	public WebElement createNewAccountNamefield;
	
	@FindBy(id="emailInput")
	public WebElement createNewAccountEmailField;
	
	@FindBy(id="passwordInput")
	public WebElement createNewAccountpasswordField;
	
	@FindBy(id="confirmPasswordInput")
	public WebElement createNewAccountConfirmPasswordField;
	
	@FindBy(id="signupBtn")
	public WebElement signUpButton;
	

}
