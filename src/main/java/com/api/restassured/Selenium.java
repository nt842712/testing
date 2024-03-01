package com.api.restassured;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.Timeout;

public class Selenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/ntalesha/Downloads/chromedriver-mac-arm6/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
		//WebElement element=driver.findElement(By.xpath(""));
		
		driver.manage().window().maximize();
		Set<Cookie> cookie=driver.manage().getCookies();
		
		System.out.println(driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Wait<WebDriver> wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
		
		
	    Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(30))
	            .pollingEvery(Duration.ofSeconds(5))
	            .ignoring(NoSuchElementException.class);
	    
	    
	    fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
		
		
		
		
		
		//wait.until(new )
		
		
		
		cookie.toString();
		
		System.out.println(cookie.toString());
		
		//driver.navigate().to("");		
		//driver.switchTo().frame(driver.findElement(By.xpath("")));
		//driver.close();
		driver.quit();

	}

}
