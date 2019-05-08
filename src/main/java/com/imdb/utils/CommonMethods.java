package com.imdb.utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import net.serenitybdd.core.pages.PageObject;

public class CommonMethods extends PageObject {

	public CommonMethods(WebDriver driver) {
		super(driver);
	}

	/**
	 * Type string into element
	 * 
	 * @param elementelement
	 * @param sstring
	 */
	public void typeInto(WebElement element, String s) {
		element.clear();
		element.sendKeys(s);
	}

	/**
	 * Mouse hover an element
	 * 
	 * @param element
	 **/
	public void mouseHover(WebElement element) {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(element).build().perform();
	}

	/**
	 * Click on a element
	 * 
	 * @param element
	 */
	protected void clickElement(WebElement element) {
		element.click();
	}

	/**
	 * Verify title partially
	 * 
	 * @param expectedTitle
	 */
	public void titlePartialMatch(String expectedTitle) {
		String actualTitle = getDriver().getTitle();
		System.out.println("Title from the application: " + actualTitle);
		System.out.println("Expected Title: " + expectedTitle);
		if (actualTitle.contains(expectedTitle)) {
			System.out.println("Title Matches");
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Verify text partially
	 * 
	 * @param expectedTitle
	 */
	public void textPartialMatch(WebElement element, String expectedText) {
		String actualText = element.getText().trim();
		System.out.println("Title from the application: " + actualText);
		System.out.println("Expected Title: " + expectedText);
		if (actualText.contains(expectedText)) {
			System.out.println("Verified");
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * To get the text of an element
	 * @param element
	 * @return
	 */
	public String returnText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * To switch to the current window
	 */
	public void switchToMainWindow() {
		String mainWindow = getDriver().getWindowHandle();
		Set<String> set = getDriver().getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!mainWindow.equals(childWindow)) {
				getDriver().switchTo().window(childWindow);
				System.out.println(getDriver().switchTo().window(childWindow).getTitle());
			}
		}
	}
}
