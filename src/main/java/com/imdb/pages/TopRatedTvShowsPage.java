package com.imdb.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.imdb.utils.CommonMethods;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.By;

public class TopRatedTvShowsPage extends CommonMethods {
	public TopRatedTvShowsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Game of Thrones")

	private WebElement topRatedGameOfThrones;

	@FindBy(css = ".title_wrapper >h1")

	private WebElement header;

	@FindBy(xpath = "//*[contains(@class,'aux-content-widget')]//a")

	private WebElement seenShow;

	public void listOfShowsBasedOnRatings(int arg1, int arg2) {
		List<WebElement> ele = getDriver().findElements(
				By.xpath("//*[contains(@title,'" + arg1 + "." + arg2 + "')]/../../td[@class='titleColumn']//a"));
		System.out.println("List of shows that has " + arg1 + "." + arg2 + " rating");
		for (WebElement element : ele) {
			System.out.println(element.getText());
		}
	}

	public void gameOfThronesLink() {
		clickElement(topRatedGameOfThrones);
	}

	public void assertPageNavigation(String expectedText) {
		titlePartialMatch(expectedText);
		textPartialMatch(header, expectedText);
		textPartialMatch(seenShow, expectedText);
	}
}