package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MerchantSignUpPage {
	
	public MerchantSignUpPage() {
		
		if(Common.driver.findElement(By.xpath(Common.locatorsProp.get("MerchantSignUpText").toString())).isDisplayed()) {
			Common.LOGGER.info("Merchant SignUp Page is Displayed");
		}else {
			Common.LOGGER.error("Merchant SignUp Page isn't Displayed");
		}
	}
	
	// Switch to captcha iframe
	public void clickCaptchaBox() {
		Common.clickButton(Common.locatorsProp.get("CaptchaBox").toString());
		Common.LOGGER.info("Clicked the First Captcha Box in Login Page");
	}

	// Switch to image selection iframe
	public void clickImageSelection() {
		Common.clickButton(Common.locatorsProp.get("ImageSelectionCaptcha").toString());
		Common.LOGGER.info("Clicked Image Selection Frame in Login Page");
	}

	// Click Helper Icon
	public void clickHelperIcon() {
		WebElement element = Common.driver.findElement(By.xpath(Common.locatorsProp.get("ImageSelectionCaptcha").toString()));
		Common.driver.switchTo().frame(element);
		Common.waitSleep(5000);
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("HelperIcon").toString())).click();
		Common.LOGGER.info("Captcha Resolved");
		Common.driver.switchTo().defaultContent();
		Common.waitSleep(3000);
	}
	
	public void clickGetStartedButton() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("GetStartedButton").toString())).click();
		Common.LOGGER.info("Clicked GetStarted Button in MerchantSignUp Page");
		Common.waitSleep(5000);
	}

	public String enterSignUpDetails() {
		String alpha=Common.randomAlphaString(4);
		String emailId=alpha.toLowerCase()+"@gmail.com";
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("Email").toString())).click();
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("Email").toString())).sendKeys(emailId);
		Common.LOGGER.info("Email ID: "+emailId);		
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("Password").toString())).sendKeys(Common.projectProp.get("Password").toString());
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("RetypePassword").toString())).sendKeys(Common.projectProp.get("Password").toString());
		return emailId;
	}
	
	public void signedUpTextValidation() {
		if(Common.driver.findElement(By.xpath(Common.locatorsProp.get("SignUpText").toString())).getText().contains(Common.projectProp.get("SignedMessage").toString())) {
			Common.LOGGER.info("Merchant SignedUp Text is Displayed");
		}else {
			Common.LOGGER.error("Merchant SignedUp Text isn't Displayed");
		}
		
	}
}
