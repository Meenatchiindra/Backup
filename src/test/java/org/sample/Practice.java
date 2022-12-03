package org.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice {
@Test
public void pra() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Demo\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver .get("https://courses.letskodeit.com/practice");
	driver.findElement(By.cssSelector("#hondaradio")).click();
	
	
}

}
