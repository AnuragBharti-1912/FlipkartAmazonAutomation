package com.automation.smallcase.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.smallcase.qa.base.BasePage;

public class AddCartPage extends  BasePage {

	public AddCartPage(WebDriver driver) {
		this.driver=driver;
	}
	public WebDriver driver;

	private By addCart= (By.cssSelector("button._2AkmmA._2Npkh4._2MWPVK"));

	public WebElement AddToCart() {
		return driver.findElement(addCart);
	}	

	private By price= (By.xpath("//div[@class='_2twTWD']/div[1]"));

	public WebElement ItemPrices() {
		return driver.findElement(price);
	}

	private By incrementitem=(By.xpath("//button[@class='wNrY5O'][2]"));

	public WebElement IncrementItems() {
		return driver.findElement(incrementitem);
	}
	private By priceFK=(By.cssSelector("div._1vC4OE._3qQ9m1"));

	public WebElement PriceInFK() {
		return driver.findElement(priceFK);
	}
	private By priceAgainInFk=(By.xpath("//div[@class='hJYgKM'][1]"));

	public WebElement PriceAgainInFK() {
		return driver.findElement(priceAgainInFk);
	}
	private By priceinamazon=By.cssSelector("#priceblock_dealprice");
	
	public WebElement PriceInAmazon() {
		return driver.findElement(priceinamazon);
	}
	private By addCartAmazon= (By.id("add-to-cart-button"));

	public WebElement clickAddToCartAmazon() {
		return driver.findElement(addCartAmazon);
	}	

	private By closesidesheet=(By.id("attach-close_sideSheet-link"));

	public WebElement CloseSideSheet() {
		return driver.findElement(closesidesheet);

	}

	private By navigatecart=(By.id("nav-cart-count"));

	public WebElement NavigateToCart() {
		return driver.findElement(navigatecart);

	}

	private By priceinamazonagain=By.xpath("//body/div[@id='a-page']/div[4]/div[1]/div[5]/div[1]/div[1]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/span[2]/span[1]");
	
	public WebElement PriceInAmazonAgain() {
		return driver.findElement(priceinamazonagain);
	}
}