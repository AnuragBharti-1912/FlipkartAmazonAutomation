package com.automation.smallcase.qa.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.smallcase.qa.base.BasePage;
import com.automation.smallcase.qa.pages.AddCartPage;
import com.automation.smallcase.qa.pages.LandingPage;

public class AssignmentFlipkart extends BasePage {

	@BeforeTest
	public void initialize() throws IOException{
		driver=initializeDriver();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void TestFlipkartSearch() throws InterruptedException {
		LandingPage lp= new LandingPage(driver);
		AddCartPage ac= new AddCartPage(driver);

		Reporter.log("TC to test Flipkart Search functioanlity started", true);
		String s_search_string = prop.getProperty("flipkartSearchItem");
		driver.get(prop.getProperty("url"));
		Reporter.log("Chrome Invoked and navigated to URL: " + prop.getProperty("url") + "<br>", true);

		//Checking page is navigated with the expected title
		String actual = driver.getTitle();
		String expected = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(actual, expected);
		Reporter.log("Page Navigated." + "<br>", true);

		//Clicking on Cross button
		lp.LoginClose().click();
		Reporter.log("Sign In Window Closed." + "<br>", true);

		//Check Search Box is Displayed
		lp.CheckSearchBox();
		Assert.assertEquals(lp.CheckSearchBox().isDisplayed(), true);
		Reporter.log("Search Box is displayed." + "<br>", true);

		//Enter TV in Search text box
		lp.CheckSearchBox().sendKeys(s_search_string);

		//Clicked on Search button
		lp.ClickSearchIcon().click();
		log.info("search icon is clicked");

		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		lp.SelectFirstItem().click();
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		Reporter.log("Focus is on subwindowHandler");

		driver.manage().window().maximize();
		Reporter.log("window is maximized");

		Thread.sleep(2000);
		Assert.assertEquals(ac.AddToCart().isDisplayed(), true);
		Reporter.log("Add Cart is displayed." + "<br>", true);
		ac.AddToCart().click();
		Thread.sleep(2000);

		String oneitemprices=ac.ItemPrices().getText();
		String[] oneitemprice = oneitemprices.split("\n");
		System.out.println("Price of 1 item is Rs:"+oneitemprice[1]);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(lp.ElementToBeClickable())).click();
		Thread.sleep(2000);

		String doubleitemprices=ac.ItemPrices().getText();
		String[] twoitemprice = doubleitemprices.split("\n");
		System.out.println("Price of 2 items is Rs:"+twoitemprice[1]);

	}
	@AfterTest
	public void teardown() {
		driver.quit();
		driver=null;
	}

}


