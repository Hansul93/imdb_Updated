package com.test.suite.stepDefinitions;

import com.test.suite.testSteps.NavigationSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class NavigationStepDefs {
	@Steps
	private NavigationSteps navigationSteps;

	@Given("^Launch IMDB application$")
	public void launchApplication() {
		navigationSteps.launchApplication();
	}

	@Then("^Mouse hover on the main menu \"([^\"]*)\"$")
	public void selectMainMenu(String mainMenu) {
		if (mainMenu.equals("Movies")) {
			navigationSteps.setMainMenuMovies();
		}
	}

	@Then("^Choose the sub menu \"([^\"]*)\"$")
	public void selectSubMenu(String subMenu) {
		if (subMenu.equals("Top Rated Tv Shows")) {
			navigationSteps.setSubMenuTopRatedTVShows();
		}
	}

	@Then("^Click on Sign In button$")
	public void signInButton() {
		navigationSteps.signIn();
	}

	@Then("^Switch to parent window$")
	public void parentWindow() {
		navigationSteps.switchToMainWindow();
	}
}
