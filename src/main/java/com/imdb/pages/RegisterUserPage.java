package com.imdb.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.imdb.utils.CommonMethods;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class RegisterUserPage extends CommonMethods {

	String emailDomain, logoutURL;

	public RegisterUserPage(WebDriver driver) {
		super(driver);
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("config.properties")));
			emailDomain = prop.getProperty("EmailDomain");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
	static String random = Long.toString(number);
	public static String emailId = random;

	private String LOGIN_CONSTANT = "imdb-signin-link";

	@FindBy(css = ".create-account")

	private WebElement createAccount;

	@FindBy(id = "ap_customer_name")

	private WebElement customerName;

	@FindBy(id = "ap_email")

	private WebElement email;

	@FindBy(id = "ap_password")

	private WebElement password;

	@FindBy(id = "ap_password_check")

	private WebElement confirmPassword;

	@FindBy(id = "continue")

	private WebElement continueButton;

	@FindBy(css = "imdb-signin-link")

	private By signIn;

	@FindBy(css = "span.a-button-inner > input")

	private WebElement signInSubmit;

	@FindBy(css = "li#navUserMenu  > span")

	private WebElement profileDropdown;

	@FindBy(id = "nblogout")

	private WebElement logout;

	@FindBy(css = ".imdb-logo")

	private WebElement signInWithIMDB;

	// Made an assumption that this would be the element identification.
	// Couldn't identify precisely since the page refreshed
	@FindBy(xpath = "//*[contains(text(),'Logging Out')]")

	private WebElement loggingOut;

	@FindBy(xpath = "//*[contains(text(),'Page will refresh')]")

	private WebElement pageRefreshMessage;

	public void createAccount() {
		clickElement(createAccount);
	}

	public void setCustomerName(String customerNameValue) {
		typeInto(customerName, customerNameValue);
	}

	public String setEmailId(String emailValue) {
		System.out.println(emailValue);
		typeInto(email, emailValue);
		return emailValue;
	}

	public void setPassword(String passwordValue) {
		typeInto(password, passwordValue);
	}

	public void setConfirmPassword(String confirmPasswordValue) {
		typeInto(confirmPassword, confirmPasswordValue);
	}

	public void continueButton() {
		clickElement(continueButton);
	}

	public void signInSubmit() {
		clickElement(signInSubmit);
	}

	public void profileDropdown() {
		clickElement(profileDropdown);
	}

	public void logout() {
		clickElement(logout);
	}

	public void signInWithIMDB() {
		clickElement(signInWithIMDB);
	}

	public void completeRegistrationTitle(String expectedTitle) {
		titlePartialMatch(expectedTitle);
	}

	public void verifyLogoutState() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LOGIN_CONSTANT)));
	}
}
