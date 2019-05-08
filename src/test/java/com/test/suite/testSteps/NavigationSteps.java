package com.test.suite.testSteps;

import com.imdb.pages.NavigationPage;

import net.thucydides.core.annotations.Step;

public class NavigationSteps {
	NavigationPage navigationPage;

	@Step
	public void launchApplication() {
		navigationPage.launchApplication();
	}

	@Step
	public void setMainMenuMovies() {
		navigationPage.setMainMenuMovies();
	}

	@Step
	public void setSubMenuTopRatedTVShows() {
		navigationPage.setSubMenuTopRatedTVShows();
	}

	@Step
	public void signIn() {
		navigationPage.signIn();
	}

	@Step
	public void switchToMainWindow() {
		navigationPage.parentWindow();
	}
}