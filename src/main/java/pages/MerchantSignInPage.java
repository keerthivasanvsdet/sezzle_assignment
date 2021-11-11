package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

import ui_tests.Sezzle;

public class MerchantSignInPage {
	
	static HashMap<String, String> tdpMap=new HashMap<String, String>();
	
	public MerchantSignInPage() {
		
		if(Common.driver.findElement(By.xpath(Common.locatorsProp.get("MerchantSignInText").toString())).isDisplayed()) {
			Common.LOGGER.info("Merchant SignIn Page is Displayed");
		}else {
			Common.LOGGER.error("Merchant SignIn Page isn't Displayed");
		}
	}
	
	public void clickLoginButton() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("LoginButton").toString())).click();
		Common.LOGGER.info("Clicked LoginButton in MerchantSignIn Page");
	}

	public void enterSignInDetails() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("SignInEmail").toString())).clear();
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("SignInEmail").toString())).sendKeys(Sezzle.emailId);
		Common.LOGGER.info("Email ID: "+Sezzle.emailId);		
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("Password").toString())).sendKeys(Common.projectProp.get("Password").toString());
		Common.waitSleep(2000);
		Common.LOGGER.info("Email & Password Details are entered");
	}
	
	public void enterInvalidEmail() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("SignInEmail").toString())).clear();
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("SignInEmail").toString())).sendKeys("a");
		Common.LOGGER.info("Invalid Email is entered");
	}
	
	public void signedInTextValidation() {
		if(Common.driver.findElement(By.xpath(Common.locatorsProp.get("SignUpText").toString())).getText().contains(Common.projectProp.get("SignedMessage").toString())) {
			Common.LOGGER.info("Merchant SignedUp Text is Displayed");
		}else {
			Common.LOGGER.error("Merchant SignedUp Text isn't Displayed");
		}	
	}
	
	public void clearAllFields() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("SignInEmail").toString())).clear();
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("Password").toString())).clear();
	}
	
	public void validateMandatoryText() {
		Common.LOGGER.info("Email Validation Text: "+Common.driver.findElement(By.xpath(Common.locatorsProp.get("EmailValidationText").toString())).getText());
		if(Common.driver.findElement(By.xpath(Common.locatorsProp.get("EmailValidationText").toString())).getText().contains(Common.projectProp.get("ValidationText").toString())) {
			Common.LOGGER.info("Merchant EmailValidation Text is Displayed");
		}else {
			Common.LOGGER.error("Merchant EmailValidation Text isn't Displayed");
		}
		
		Common.LOGGER.info("Password Validation Text: "+Common.driver.findElement(By.xpath(Common.locatorsProp.get("PasswordValidationText").toString())).getText());
		if(Common.driver.findElement(By.xpath(Common.locatorsProp.get("PasswordValidationText").toString())).getText().contains(Common.projectProp.get("ValidationText").toString())) {
			Common.LOGGER.info("Merchant PasswordValidation Text is Displayed");
		}else {
			Common.LOGGER.error("Merchant PasswordValidation Text isn't Displayed");
		}
		
	}
	
	public void validateInvalidEmailText() {
		Common.LOGGER.info("Invalid Email Validation Text: "+Common.driver.findElement(By.xpath(Common.locatorsProp.get("EmailValidationText").toString())).getText());
		if(Common.driver.findElement(By.xpath(Common.locatorsProp.get("EmailValidationText").toString())).getText().contains(Common.projectProp.get("InvalidEmailText").toString())) {
			Common.LOGGER.info("Merchant InvalidEmail Text is Displayed");
		}else {
			Common.LOGGER.error("Merchant InvalidEmail Text isn't Displayed");
		}
		
	}
	
}
