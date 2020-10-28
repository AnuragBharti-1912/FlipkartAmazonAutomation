package com.automation.smallcase.qa.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
import com.automation.smallcase.qa.pages.SearchPage;

public class AssignmentFlipkartAmazon extends BasePage {


	@BeforeTest
	public void initialize() throws IOException{
		driver=initializeDriver();
	}
	@Test
	public void TestFlipkartSearch() throws InterruptedException {

		LandingPage lp= new LandingPage(driver);
		AddCartPage ac= new AddCartPage(driver);
		SearchPage sp= new  SearchPage(driver);

		Reporter.log("TC to test product in Flipkart and Amazon Search functioanlity started", true);
		String fk_search_string = prop.getProperty("flipkartAmazonSearchItem");

		driver.get(prop.getProperty("url"));

		Reporter.log("Chrome Invoked and navigated to URL: " + prop.getProperty("url") + "<br>", true);

		//Checking page is navigated with the expected title
		String actualTitle = driver.getTitle();
		
		Reporter.log("Page Navigated." + "<br>", true);

		//Clicking on Cross button
		lp.LoginClose().click();
		Reporter.log("Sign In Window Closed." + "<br>", true);

		//Check Search Box is Displayed
		lp.CheckSearchBox();
		Assert.assertEquals(lp.CheckSearchBox().isDisplayed(), true);
		Reporter.log("Search Box is displayed." + "<br>", true);

		//Enter product in Search text box
		lp.CheckSearchBox().sendKeys(fk_search_string);

		//Clicked on Search button
		lp.ClickSearchIcon().click();
		log.info("search icon is clicked");

		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler = null;

		//click on first item
		lp.SelectFirstItem().click();

		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		Reporter.log("Focus is on subwindowHandler");

		String actualProductName = sp.ProductNameFromFK().getText();
	
		System.out.println("**Providing product name for searching in Amazon**");

		driver.manage().window().maximize();
		Reporter.log("window is maximized");

		Thread.sleep(2000);

		String PriceFK=ac.PriceInFK().getText();
		System.out.println("Price of item in flipkart is Rs:"+PriceFK);

		Thread.sleep(2000);

		WebElement addCart=ac.AddToCart();
		Assert.assertEquals(addCart.isDisplayed(), true);
		Reporter.log("Add Cart is displayed." + "<br>", true); 
		ac.AddToCart().click();
		Thread.sleep(2000);

		String PriceAgain=ac.PriceAgainInFK().getText();
		String[] price2 = PriceAgain.split("\n");
		System.out.println("Again printing the price of an item is Rs:"+price2[1]);
		String str1=price2[1].toString();

		//navigating to amazon.in
		driver.get(prop.getProperty("url2"));

		WebElement searchbx2 = lp.CheckSearchBox2();
		Assert.assertEquals(searchbx2.isDisplayed(), true);
		Reporter.log("Search Box 2 is displayed." + "<br>", true);

		//entering the same product as selected in flipkart
		lp.CheckSearchBox2().click();
		lp.CheckSearchBox2().sendKeys(actualProductName);
		Thread.sleep(2000);
		lp.CheckSearchBox2().sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement fetchResult=driver.findElement(By.cssSelector("div.a-section.a-spacing-small.a-spacing-top-small"));
		System.out.println("matching results found in amazon:"+fetchResult.getText()+"***");

		String parentWindowHandler2 = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler2 = null;

		Thread.sleep(2000);

		WebElement selectproductinamazon= sp.SelectSameProductInAmazon();
		selectproductinamazon.click();
		Thread.sleep(5000);

		Set<String> handles2 = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator2 = handles2.iterator();
		while (iterator2.hasNext()){
			subWindowHandler2 = iterator2.next();
		}
		driver.switchTo().window(subWindowHandler2);
		Reporter.log("Focus is on subwindowHandler2");
		Thread.sleep(5000);

		WebElement priceInAmazon=ac.PriceInAmazon();
		System.out.println("Price of item in amazon is Rs: "+priceInAmazon.getText());

		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable( ac.clickAddToCartAmazon())).click();
		Thread.sleep(2000);


		WebElement closesidesheet=ac.CloseSideSheet();
		closesidesheet.click();

		WebElement navigatecart=ac.NavigateToCart();
		navigatecart.click();
		Thread.sleep(3000);

		String priceAgain2= ac.PriceInAmazonAgain().getText();
		System.out.println("Final price of item in amazon is Rs:"+priceAgain2);
		String str2=priceAgain2;
		if(str1.equalsIgnoreCase(str2)) {
			System.out.println("Price is same in both the sites");
		}else {
			System.out.println("Price is not same");
		}
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		driver=null;
	}


}



