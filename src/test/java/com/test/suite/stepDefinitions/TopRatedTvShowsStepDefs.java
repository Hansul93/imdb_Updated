package com.test.suite.stepDefinitions;

import com.test.suite.testSteps.TopRatedTvShowsSteps;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class TopRatedTvShowsStepDefs {
	@Steps
	private TopRatedTvShowsSteps topRatedTvShowsSteps;

	@Then("^get the list of shows having (\\d+)\\.(\\d+) ratings$")
	public void listOfShowsBasedOnRatings(int arg1, int arg2) {
		topRatedTvShowsSteps.listOfShowsBasedOnRatings(arg1, arg2);
	}

	@Then("^Click on \"([^\"]*)\" link$")
	public void clickTopRatedTvShowsLink(String showName) {
		if (showName.equals("Game of Thrones")) {
			topRatedTvShowsSteps.gameOfThronesLink();
		}
	}

	@Then("^Assert the page navigation to \"([^\"]*)\"$")
	public void assertPageNavigation(String expectedText) {
		topRatedTvShowsSteps.assertPageNavigation(expectedText);
	}
}
