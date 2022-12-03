package org.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertDemo{
	static WebDriver driver;
	
	@BeforeMethod
	public void launch() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Demo\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.softwaretestingmaterial.com/sample-webpage-to-automate/");
		driver.manage().window().maximize();

	}
	@Test
	public void tc0() {
		WebElement mySelectElement = driver.findElement(By.name("multipleselect[]"));
		Select dropdown= new Select(mySelectElement);
		//To deselect an option
		//the deselect method will throw UnsupportedOperationException if the SELECT does not support multiple selections
		List<WebElement> options = dropdown.getOptions();
		for(int i=0;i<options.size();i++)
		{
			WebElement element = options.get(i);
			String text = element.getText();
			System.out.println(text);
			options.get(i).click();
		}}
		@Test
		public void tc1() {
WebElement ele1 = driver.findElement(By.xpath("//select[@name='dropdown']"));
			
			Select drop=new Select(ele1);
			drop.selectByIndex(1);
			
			
			
			
			
			
				
				
			}
		}
		
			
	
	



		


	
	


