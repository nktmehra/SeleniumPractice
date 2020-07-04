package com.nkt.org.mavenDemo;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class RobotClass {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Acer\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.africau.edu/images/default/sample.pdf");
	}
	
	@Test
	public void test() throws Exception {
		
	
		Robot robot = new Robot();
		robot.setAutoDelay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		robot.setAutoDelay(3000);
		StringSelection s = new StringSelection("C:\\Users\\Acer\\Documents\\MongoDb\\PDF4.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		File file = new File("C:\\Users\\Acer\\Documents\\MongoDb\\PDF4.pdf");
		PDDocument document = PDDocument.load(file);
		PDFTextStripper stripper = new PDFTextStripper();
		String data = stripper.getText(document);
		System.out.println(data);
	}

}
