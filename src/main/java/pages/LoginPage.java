package pages;

import org.openqa.selenium.By;

public class LoginPage {
	
	public LoginPage() {
		
		if(Common.driver.findElement(By.xpath(Common.locatorsProp.get("LoginPageSignUpButton").toString())).isDisplayed()) {
			Common.LOGGER.info("Login Page is Displayed");
		}else {
			Common.LOGGER.error("Login Page isn't Displayed");
		}
	}
	
	public void clickSignUpLink() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("LoginPageSignUpLink").toString())).click();
		Common.LOGGER.info("Clicked SignUp Hyperlink in Login Page");
	}
	
	public void clickSignInLink() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("LoginPageSignInButton").toString())).click();
		Common.LOGGER.info("Clicked SignIn Button in Login Page");
	}
	
	public void clickMerchantSignUpButton() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("MerchantSignUpButton").toString())).click();
		Common.LOGGER.info("Clicked Merchant SignUp Button in Login Page");
	}
	
	public void clickMerchantSignInButton() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("MerchantSignInButton").toString())).click();
		Common.LOGGER.info("Clicked Merchant SignIn Button in Login Page");
	}
	
	
}
