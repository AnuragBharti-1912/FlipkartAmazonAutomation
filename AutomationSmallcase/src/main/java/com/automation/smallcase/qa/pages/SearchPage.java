package com.automation.smallcase.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.smallcase.qa.base.BasePage;

public class SearchPage extends  BasePage {

	public SearchPage(WebDriver driver) {
		this.driver=driver;
	}
	public WebDriver driver;

	private By productname=(By.xpath("//span[@class='_35KyD6']"));

	public WebElement ProductNameFromFK() {
		return driver.findElement(productname);
	}
	private By selectsameproduct=By.xpath("//div[@data-cel-widget=\"search_result_1\"]/div/span/div/div/div[2]/div[2]/div/div/div/div/div/h2/a/span");

	public WebElement SelectSameProductInAmazon() {
		return driver.findElement(selectsameproduct);	
	}
}