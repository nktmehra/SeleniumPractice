package com.nkt.org.mavenDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Class3 {

	static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) {
		try {
			openCLock();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	static void openCLock() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Real Me");
		cap.setCapability("udid", "99FMC6VCCQ5945SS");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion","9");
		cap.setCapability("noRetest",true);
		cap.setCapability("appPackage", "com.google.android.calendar");
		cap.setCapability("appActivity", "com.google.android.calendar.AllInOneCalendarActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url,cap);
		System.out.println("Calendar Started");
	}

}
