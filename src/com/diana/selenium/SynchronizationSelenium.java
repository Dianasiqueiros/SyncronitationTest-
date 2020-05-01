package com.diana.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "//Users//DSV//Downloads//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

		driver.findElement(By.linkText("Click to load get data via Ajax!")).click();
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
		System.out.println(driver.findElement(By.id("results")).getText());
	}

}
