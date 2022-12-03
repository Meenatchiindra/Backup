package org.sample;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.base.LibGlobal;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Store extends LibGlobal {
	LibGlobal lib=new LibGlobal();
	
	
	@Test(priority=1)
	public void Registration() throws IOException {
		lib.getDriver("chrome");
		lib.getUrl("http://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys(lib.particularExcelReadData("C:\\Users\\HP\\Desktop\\Store.xlsx", "Sheet2", 1, 0));
		driver.findElement(By.id("input-lastname")).sendKeys(lib.particularExcelReadData("C:\\Users\\HP\\Desktop\\Store.xlsx", "Sheet2", 1, 1));
		driver.findElement(By.id("input-email")).sendKeys(lib.particularExcelReadData("C:\\Users\\HP\\Desktop\\Store.xlsx", "Sheet2", 1, 2));
		driver.findElement(By.id("input-telephone")).sendKeys(lib.particularExcelReadData("C:\\Users\\HP\\Desktop\\Store.xlsx", "Sheet2", 1, 3));
		driver.findElement(By.id("input-password")).sendKeys(lib.particularExcelReadData("C:\\Users\\HP\\Desktop\\Store.xlsx", "Sheet2", 1, 4));
		driver.findElement(By.id("input-confirm")).sendKeys(lib.particularExcelReadData("C:\\Users\\HP\\Desktop\\Store.xlsx", "Sheet2", 1, 5));
		driver.findElement(By.xpath("//input[@name='newsletter'][1]")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.close();
		
		
		
	}
	@Test (priority=2)
	public void OpenBrowser() {
		Reporter.log("This test verifies the current selenium compatibility with TestNG by launching the chrome driver");
	       Reporter.log("Launching Google Chrome Driver version 81 for this test"); 
	        lib.getDriver("chrome");
	        driver.get("https://www.google.com");
	        
	       Reporter.log("The website used was DemoQA for this test", true);
	        String expectedTitle = "google";
	        String originalTitle = driver.getTitle();
	        Assert.assertEquals(originalTitle, expectedTitle);
	        Assert.assertEquals(originalTitle, expectedTitle);
  }
	

}
