package com.imdb.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.imdb.utils.CommonMethods;
import net.serenitybdd.core.annotations.findby.FindBy;

public class NavigationPage extends CommonMethods {

	public String aURL;

	public NavigationPage(WebDriver driver) {
		super(driver);
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("config.properties")));
			aURL = prop.getProperty("ApplcationURL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FindBy(css = "li#navTitleMenu")

	private WebElement moviesMainMenu;

	@FindBy(linkText = "Top Rated TV Shows")

	private WebElement topRatedTvShowsSubMenu;

	@FindBy(id = "imdb-signin-link")

	private WebElement signIn;

	public void launchApplication() {
		try {
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
			getDriver().manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
			getDriver().get(aURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setMainMenuMovies() {
		mouseHover(moviesMainMenu);
	}

	public void setSubMenuTopRatedTVShows() {
		clickElement(topRatedTvShowsSubMenu);
	}

	public void signIn() {
		clickElement(signIn);
	}
	
	public void parentWindow() {
		switchToMainWindow();
	}
}
