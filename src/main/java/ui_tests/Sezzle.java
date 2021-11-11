package ui_tests;

import pages.Common;
import pages.LoginPage;
import pages.MerchantSignInPage;
import pages.MerchantSignUpPage;

public class Sezzle extends Common {
	
	public static String emailId;
	
	public static void merchantSignUp() {
		
		connect();
		launchAppUrl();
		LoginPage lp = new LoginPage();
		lp.clickSignUpLink();		
		lp.clickMerchantSignUpButton();
		MerchantSignUpPage msp=new MerchantSignUpPage();
		msp.clickCaptchaBox();
		//msp.clickImageSelection();
		msp.clickHelperIcon();
		emailId=msp.enterSignUpDetails();
		msp.clickGetStartedButton();
		Common.waitSleep(5000);
		msp.signedUpTextValidation();
	}
	
	public static void merchantSignIn() {
		
		launchAppUrl();
		LoginPage lp = new LoginPage();
		lp.clickSignInLink();
		lp.clickMerchantSignInButton();
		MerchantSignInPage msp = new MerchantSignInPage();
		msp.enterSignInDetails();
		msp.clickLoginButton();
		Common.waitSleep(5000);
		msp.signedInTextValidation();
	}
	
	public static void validateMandatoryFields() {
		
		//connect();
		launchAppUrl();
		LoginPage lp = new LoginPage();
		lp.clickSignInLink();
		lp.clickMerchantSignInButton();
		MerchantSignInPage msp = new MerchantSignInPage();
		msp.clearAllFields();
		msp.clickLoginButton();
		Common.waitSleep(5000);
		msp.validateMandatoryText();
	}
	
	public static void validateInvalidEmail() {
		
		//connect();
		launchAppUrl();
		LoginPage lp = new LoginPage();
		lp.clickSignInLink();
		lp.clickMerchantSignInButton();
		MerchantSignInPage msp = new MerchantSignInPage();
		msp.clearAllFields();
		msp.enterInvalidEmail();
		Common.waitSleep(5000);
		msp.validateInvalidEmailText();
	}
	
	public static void main(String[] args) {
		getData();
		LOGGER.info("*******************************************");
		LOGGER.info(" ");
		LOGGER.info("Executing Scenario: " + "Sezzle SignUp, SignIn & 2 Other Scenarios");
		LOGGER.info(" ");
		LOGGER.info("*******************************************");
		LOGGER.info("Product: " + projectProp.get("Name"));
		LOGGER.info("Author: " + projectProp.get("Author"));
		
		// SignUp
		merchantSignUp();
		
		// SignIn
		merchantSignIn();
		
		// Negative Scenario 1
		validateMandatoryFields();
		
		// Negative Scenario 2
		validateInvalidEmail();
		
		tearDown();
	}

}
