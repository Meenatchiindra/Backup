package org.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Demo\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("www.google.com");
		
		
		
		
		
		
		
		
	}

}
