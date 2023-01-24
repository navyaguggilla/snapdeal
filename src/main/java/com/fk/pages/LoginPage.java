package com.fk.pages;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fk.objectRepository.ObjectRepository;
import com.fk.utility.Functions;
import com.fk.webActions.ElementActions.ElementActions;

import org.openqa.selenium.JavascriptExecutor;

public class LoginPage extends ObjectRepository {

	Logger log;
	WebDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	public String OTP;

	public LoginPage(WebDriver driver,Logger log) throws IOException {
		super("Login.properties");
		obj = new ObjectRepository("Login.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	public void clickSignup() {
		log.info("Clicking on signup Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("signupbutton"));
		element_Actions.findElement(obj.getElement("signupbutton"));
		element_Actions.click(obj.getElement("signupbutton"));
		element_Actions.waitUntilVisibilityLocated(obj.getElement("loginbutton"));
		element_Actions.findElement(obj.getElement("loginbutton"));
		element_Actions.click(obj.getElement("loginbutton"));
		log.info("Signup button is clicked successfully and clicked on login button");
	}
	public void enterEmailAddress(String emailaddress) throws IOException {
		log.info("User entering the email address");
		element_Actions.switchToFrame("iframeLogin");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("emailaddressfield"));
		element_Actions.findElement(obj.getElement("emailaddressfield"));
		element_Actions.sendKeys(emailaddress);
		log.info("User entered email address  successfully : "+ emailaddress);
	}
	public void clickContinueButton() {
		log.info("Clicking on continue Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("continuebutton"));
		element_Actions.findElement(obj.getElement("continuebutton"));
		element_Actions.click(obj.getElement("continuebutton"));
		log.info("User successfully clicked continue button");
	}
	public void enterMobileNumber(String mobilenumber) {
		log.info("User entering the mobile number");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("mobilenumberfield"));
		element_Actions.findElement(obj.getElement("mobilenumberfield"));
		element_Actions.sendKeys(mobilenumber);
		log.info("User entered mobile number successfully : "+ mobilenumber);
	}
	public void enterName(String name) {
		log.info("Entering the username");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("namefield"));
		element_Actions.findElement(obj.getElement("namefield"));
		element_Actions.sendKeys(name);
		log.info("User entered username successfully : "+ name);
	}
	
	public void enterdateofbirth(String dateofbirth) {
		log.info("User entering date of birth");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("mobilenumberfield"));
		element_Actions.findElement(obj.getElement("mobilenumberfield"));
		element_Actions.sendKeys(dateofbirth);
		log.info("User entered date of birth successfully : "+ dateofbirth);
	}
	 public void enterpassword(String password) {
		log.info("User entering the password");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("passwordfield"));
		element_Actions.findElement(obj.getElement("passwordfield"));
		element_Actions.sendKeys(password);
		log.info("User successfully entered password : "+ password);
	}
	 
	 public String getOTPFromMail(String mailUrl,String mailName) {
			((JavascriptExecutor)driver).executeScript("window.open()");
			element_Actions.switchToDesiredWindow(1);
			driver.navigate().to(mailUrl);
			element_Actions.waitUntilVisibilityLocated(obj.getElement("mail_name_field"));
			element_Actions.findElement(obj.getElement("mail_name_field"));
			log.info("User entering the name for creating the mail");
			element_Actions.sendKeys(mailName);
			element_Actions.click(obj.getElement("mail_arrow_btn"));
			log.info("User Enter the name successfully");
			driver.switchTo().frame("ifmail");
			log.info("OTP Field display on mail");
			WebElement mailfield=element_Actions.findElement(obj.getElement("mail_Otp_field"));
			element_Actions.scrollElementIntoView(mailfield);
			log.info("Capturing the OTP on Mail");
			OTP = mailfield.getText();
			log.info("OTP is captured successfully on Mail : "+ OTP);
			driver.switchTo().defaultContent();
			element_Actions.switchToDesiredWindow(0);
			return OTP;
		}
		public void enterOTP(String otp) {
			log.info("User entering the OTP");
			element_Actions.waitUntilVisibilityLocated(obj.getElement("OTP_txt"));
			element_Actions.findElement(obj.getElement("OTP_txt"));
			element_Actions.click(obj.getElement("OTP_txt"));
			element_Actions.sendKeys(otp);
			log.info("User enters the OTP successfully");
		}
	 public void clickContinue() {
			log.info("User clicking on continue button");
			element_Actions.waitUntilVisibilityLocated(obj.getElement("clickcontinue"));
			element_Actions.findElement(obj.getElement("clickcontinue"));
			element_Actions.click(obj.getElement("clickcontinue"));
			log.info("User successfully clicked continue button");

		}
	 
}