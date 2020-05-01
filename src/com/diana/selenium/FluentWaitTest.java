package com.diana.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "//Users//DSV//Downloads//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		// parent to child
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		// xpath [@id='start']/button

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 3 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3));

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("[id='finish'] h4"));
				} else
					return null;
			}

		});
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
	}

}
