package com.nkt.org.mavenDemo;


import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MakeMyDemo {

	public  static WebDriver driver;
	@BeforeClass
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.cssSelector("div[class='fsw_inputBox searchCity inactiveWidget ']")).click();
		driver.findElement(By.cssSelector("input[class^='react-autosuggest']")).sendKeys("BOM");
		driver.findElement(By.cssSelector("ul[role='listbox']>li")).click();
		driver.findElement(By.cssSelector("input[placeholder='To']")).sendKeys("Chandigarh");
		driver.findElement(By.xpath("//div[@class='calc60']/p[text()='Chandigarh, India']")).click();
		List<WebElement> dateList = driver.findElements(By.xpath("(//div[@class='DayPicker-Body'])[1]//div[@class='DayPicker-Week']//div[@aria-label]//p[1]"));
		
		for(WebElement e : dateList) {
			String data= e.getText();
			if(data.contains("12")) {
				e.click();
				break;
			}
		}
		String parentHandle = driver.getWindowHandle();
		driver.findElement(By.cssSelector("a[class^='primaryBtn']")).click();
		driver.findElement(By.xpath("(//div[@class='pull-left make_relative'])[1]")).click();
		driver.findElement(By.xpath("(//button[text()=' Book Now '])[1]")).click();
		Set<String>set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();	
		while(itr.hasNext()) {
		String childHandle = itr.next();
			if(!parentHandle.equals(childHandle)) {
				driver.switchTo().window(childHandle);
			}
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.cssSelector("input[value='no']")).click();
		driver.findElement(By.id("review-continue")).click();	
		driver.findElement(By.xpath("//form//a[text()='+ ADD ADULT']")).click();
		driver.findElement(By.cssSelector("input[placeholder^='First'][placeholder$='Name']")).sendKeys("Ankit");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[placeholder^='Last']")).sendKeys("Mehra");
		Thread.sleep(3000);
		WebElement e = driver.findElement(By.xpath("//form//div[contains(@class,'chooseGender')]/label[1]"));
		e.click();
//		Actions act = new Actions(driver);
//		act.moveToElement(e, 770, 559).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[placeholder^='Mobile']")).sendKeys("1234567890");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("aaa@gmail.com");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		WebElement e1 = driver.findElement(By.xpath("//div[@class='seatmap-wrapper ']"));
		List<WebElement> occupiedSeats = e1.findElements(By.xpath("//div[@class='seat-not-available']"));
		System.out.println("Occupied Seats->"+occupiedSeats.size());
		List<WebElement> vacantSeats = e1.findElements(By.xpath("//div[@class='seat_block cursor_pointer ']"));
		System.out.println("Vacant Seats->"+vacantSeats.size());
		for(WebElement e2 : vacantSeats) {
			e2.click();
			break;
		}
		driver.findElement(By.id("ancillary-continue")).click();
	}
	
		
		
	
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
