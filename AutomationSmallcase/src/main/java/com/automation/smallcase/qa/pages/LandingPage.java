package com.automation.smallcase.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.automation.smallcase.qa.base.BasePage;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	public WebDriver driver;

	private By sign_in_cross =(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
	public WebElement LoginClose() {
		return driver.findElement(sign_in_cross);
	}
	
	private By searchbx = (By.xpath("//input[@name ='q' and @type='text']"));
	public WebElement CheckSearchBox() {
		return driver.findElement(searchbx);
	}
	private By clicksearch=(By.xpath("//button[@class='vh79eN']"));
	public WebElement ClickSearchIcon() {
		return driver.findElement(clicksearch);
	}
	
	private By selectItem=(By.xpath("//div[@class='_3wU53n'][1]"));
	public WebElement SelectFirstItem() {
		return driver.findElement(selectItem);
	}
	private By clickableElement=(By.xpath("//button[@class='wNrY5O'][2]"));
	public WebElement ElementToBeClickable() {
		return driver.findElement(clickableElement);
	}

	private By productname=(By.xpath("//span[@class='_35KyD6']"));
	public WebElement ProductNameFromFK() {
		return driver.findElement(productname);
	}
	private By searchbx2 = (By.id("twotabsearchtextbox"));
	public WebElement CheckSearchBox2() {
		return driver.findElement(searchbx2);
	}
}