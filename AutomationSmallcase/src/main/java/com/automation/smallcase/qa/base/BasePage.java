package com.automation.smallcase.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.smallcase.qa.utils.TestUtil;

public class BasePage {
	public static Logger log=LogManager.getLogger(BasePage.class.getName());

	public static WebDriver driver;
	public Properties prop;
	public String Path;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		Path = new File("").getAbsolutePath();
		//FileInputStream fis=  new FileInputStream(Path+ "\\src\\main\\java\\com\\wordpress\\qa\\config\\file.properties");
		FileInputStream fis=  new FileInputStream("C:\\Users\\Anurag Bharti\\eclipse-workspace\\AutomationSmallcase\\src\\main\\java\\com\\automation\\smallcase\\qa\\config\\file.properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anurag Bharti\\eclipse-workspace\\AutomationSmallcase\\drivers\\chromedriver.exe");

		String browsername=prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			driver= new ChromeDriver();
		}

		log.info("chrome is logged in");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

		return driver;
	}

}
