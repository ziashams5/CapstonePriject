package tek.capstone.framework.pages;

import tek.capstone.framework.base.BaseSetup;

public class POMFactory extends BaseSetup {
	
	// in class level, declare an object. 
	private RetailHomePage homePage;
	private RetailSignInPage signInPage;
	private RetailAccountPage accountPage;
	private RetailOrderPage orderPage;
	
	
	
	// create constructor
	public POMFactory() {
		this.homePage = new RetailHomePage();
		this.signInPage = new RetailSignInPage();
		this.accountPage = new RetailAccountPage();
		this.orderPage = new RetailOrderPage();
	}
	
	
	
	// overloading constuctor 
	public RetailHomePage homePage() {
		return this.homePage;
	}
	
	public RetailSignInPage signInPage() {
		return this.signInPage;
	}
	
	public RetailAccountPage accountPage() {
		return this.accountPage;
	}
	
	public RetailOrderPage orderPage() {
		return this.orderPage;
	}
	
	
	
	
	

}
