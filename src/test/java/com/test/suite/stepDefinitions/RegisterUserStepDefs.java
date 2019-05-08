package com.test.suite.stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import com.imdb.utils.EmailGenerator;
import com.imdb.utils.ExcelReader;
import com.test.suite.testSteps.RegisterUserSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class RegisterUserStepDefs {
	String emailDomain;
	static long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
	static String random = Long.toString(number);
	public static String emailId = random;

	@Steps
	RegisterUserSteps registerUserSteps;

	@Then("^Click on Create Account button$")
	public void createAccountButton() {
		registerUserSteps.createAccount();
	}

	@Given("^Fill in the following user details to create a new account$")
	@Then("^Fill in the following user details to sign in$")
	public void userDetails(DataTable table) {
		for (Map<String, String> row : table.asMaps(String.class, String.class)) {
			String field = row.get("Field");
			String value = row.get("Value");
			setUserDetails(field, value);
		}
	}

	@Then("^Click on Continue button$")
	public void continueButton() {
		registerUserSteps.continueButton();
	}

	@Then("^click on Submit button$")
	public void submitButton() {
		registerUserSteps.signInSubmit();
	}

	private void setUserDetails(String field, String value) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("config.properties")));
			emailDomain = prop.getProperty("EmailDomain");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		switch (field) {
		case "Customer Name":
			registerUserSteps.setCustomerName(value);
			break;

		case "Email Address":
			registerUserSteps.setEmailId(value + emailId + emailDomain);
			break;

		case "Password":
			registerUserSteps.setPassword(value);
			break;

		case "Confirm Password":
			registerUserSteps.setConfirmPassword(value);
			break;

		}
	}

	@Then("^Click on logout option$")
	public void logout() {
		registerUserSteps.logout();
	}

	@Then("^Click on profile dropdown$")
	public void profileDropdown() {
		registerUserSteps.profileDropdown();
	}

	@Then("^Sign in with imdb account$")
	public void signInWithIMDB() {
		registerUserSteps.signInWithIMDB();
	}

	@Given("^Fill in the following user details: \"([^\"]*)\"$")
	public void userDetails_CreateAccount(String field) {
		try {
			ExcelReader.setExcelFile("UserDetails");
			if (field.equals("Create Account")) {
				registerUserSteps.setCustomerName(ExcelReader.getCellData(1, 0));
				setEmailIdPassword();
				registerUserSteps.setConfirmPassword(ExcelReader.getCellData(1, 3));

			} else if (field.equals("Sign In")) {
				setEmailIdPassword();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^Launch the email service provider$")
	public void launchServiceProvider() {
		try {
			registerUserSteps.launchEmailServiceProvider();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Click on verification email that the user received$")
	public void receivedEmail() {
		registerUserSteps.emailSubject();
	}

	@Then("^Verify email with mail service provider$")
	public void emailConfirmation() {
		registerUserSteps.emailConfirmation();
	}

	@Then("^Click on account activation link$")
	public void activateAccount() {
		registerUserSteps.activateAccount();
	}

	@Then("^Verify the title \"([^\"]*)\"$")
	public void assertPageNavigation(String expectedText) {
		registerUserSteps.completeRegistrationTitle(expectedText);
	}

	@Then("^Verify the logged out state of the user$")
	public void verifyLogoutState() {
		registerUserSteps.verifyLogoutState();
	}

	@Then("^Open the mail box of service provider$")
	public void openMailBox() {
		registerUserSteps.openMailBox();
	}

	@Then("^Login to the email service provider$")
	public void loginToServiceProvider() {
		registerUserSteps.loginToServiceProvider(EmailGenerator.imapUserNameDetail, EmailGenerator.imapPasswordDetail);
	}

	private void setEmailIdPassword() {
		try {
			registerUserSteps.setEmailId(EmailGenerator.imapUserNameDetail);
			registerUserSteps.setPassword(ExcelReader.getCellData(1, 2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
