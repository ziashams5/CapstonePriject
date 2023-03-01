package tek.capstone.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup {
	
	
	public RetailHomePage() {
		// we implement the concept of Page Object Model
		// we create single object of each page like RetailHomePage, SignInPage, AccountPage etc
		// using @FindBy annotaion of PageFactory class to initialize/locate UI elements.
		PageFactory.initElements(getDriver(), this);
	}
		@FindBy(linkText ="TEKSCHOOL")
		public WebElement tekschoolLogo;
		
		@FindBy(id = "searchInput")
		public WebElement searchBarInput;
		
		@FindBy(id = "searchBtn")
		public WebElement searchButton;
		
		@FindBy(xpath ="//img[contains(@alt,'Pokemon')]")
		public WebElement pokemonImage;
		
		@FindBy(id="signinLink")
		public WebElement signInOption;
		
		
		@FindBy(id="accountLink")
		public WebElement accountOption;
		
		@FindBy(id="logoutBtn")
		public WebElement logoutOption;
		
		
	}
	


