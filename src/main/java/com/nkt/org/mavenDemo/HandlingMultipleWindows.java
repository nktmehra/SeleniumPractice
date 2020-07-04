package com.nkt.org.mavenDemo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingMultipleWindows {

	public static WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Acer\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.seleniumframework.com/Practiceform/");
	}

	@Test
	public void test() throws InterruptedException {

		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Handle - "+parentHandle);
		String parentTitle = driver.getTitle();
		System.out.println("Parent Title - "+parentTitle);
		driver.findElement(By.id("button1")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String handle : allWindowHandles ) {
			driver.switchTo().window(handle);
			if(driver.getTitle().equals("Selenium Framework | Selenium, Cucumber, Ruby, Java et al.")){
				break;
			}
		}
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
	}




	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
