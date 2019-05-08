package com.test.suite.testSteps;

import com.imdb.pages.TopRatedTvShowsPage;
import net.thucydides.core.annotations.Step;

public class TopRatedTvShowsSteps {

	TopRatedTvShowsPage topRatedTvShowsPage;

	@Step
	public void listOfShowsBasedOnRatings(int arg1, int arg2) {
		topRatedTvShowsPage.listOfShowsBasedOnRatings(arg1, arg2);
	}

	@Step
	public void gameOfThronesLink() {
		topRatedTvShowsPage.gameOfThronesLink();
	}

	@Step
	public void assertPageNavigation(String expectedText) {
		topRatedTvShowsPage.assertPageNavigation(expectedText);
	}
}
