package org.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExcelValue {
	WebDriver driver;
	String password="" ,username="";
	private String text;
	//String username="";
	@BeforeMethod
	public void launch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Demo\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.get("https://www.saucedemo.com/");
		//driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");
		//driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");
		//driver.get("https://leafground.com/pages/table.html");
		driver.get("https://www.nyse.com/ipo-center/recent-ipo");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Thread.sleep(3000);
	    WebElement ninety = driver.findElement(By.xpath("//button[text()='90']"));
	    ninety.click();
	    
		

	}
	@Test(enabled=false)
	public void Demo1() throws InterruptedException {
		
		
		WebElement element1 = driver.findElement(By.id("user-name"));
		element1.sendKeys("standard_user");
		username = element1.getAttribute("value");
		System.out.println(username);
		WebElement element = driver.findElement(By.id("password"));
		element.sendKeys("secret_sauce");
		Thread.sleep(5000);
		password = element.getAttribute("value");
		System.out.println(password);
		driver.findElement(By.id("login-button")).click();
		System.out.println("browser 1 is executed");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Demo\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		System.out.println("browser 2 is executed");
		
		
	}
	@Test(enabled=false)
	public void demo2() {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		System.out.println("browser 3 is executed");
		
		}
	@Test(enabled=false)
	public void demo3numbers() {
		// String Actual = driver.findElement(By.xpath("//*[@id='post-body-8228718889842861683']/div[1]/table/tbody/tr[1]/td[2]")).getText();
		  //int Actualvalue = Integer.parseInt(Actual);
		  //System.out.println(Actual);
		  //int ExceptedValue=5;
		  
		int givennumber = Integer.parseInt(driver.findElement(By.xpath("//*[@id='post-body-8228718889842861683']/div[1]/table/tbody/tr[1]/td[2]")).getText());
		System.out.println(givennumber);
		//int Excepted=Integer.parseInt(driver.findElement(By.xpath("//*[@id='post-body-8228718889842861683']/div[1]/table/tbody/tr[1]/td[2]")).getText());
		int Excepted=4;
		Assert.assertTrue(givennumber>= Excepted, "condition is True");
		//if(givennumber.equals(Excepted)) {
            System.out.println("Both are equal");
        //}else System.out.println("Not equal");
        
    
		
		//Assert.assertTrue(true, "value not matched");
		 // System.out.println("value  not matchable");
		//Assert.assertEquals(givennumber, Excepted, "value is greater");
		
	}
	@Test(enabled=false)
	public void webTable() throws InterruptedException {
		List<WebElement> rowcount = driver.findElements(By.tagName("tr"));
		int row = rowcount.size();
		System.out.println(row);
		List<WebElement> colcount = driver.findElements(By.tagName("th"));
		int col = colcount.size();
		System.out.println(col);
		List<WebElement> data = driver.findElements(By.tagName("td"));
		for(int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i).getText());
		}
		WebElement value = driver.findElement(By.xpath("(//td[normalize-space()='Learn to interact with Elements'])[2]//following::td[1]"));
		String value1 = value.getText();
		System.out.println("The percentage value is " +value1);
		List<WebElement> allprogress = driver.findElements(By.xpath("//td[2]"));
		List<Integer> numberList=new ArrayList<Integer>();
		for (WebElement element : allprogress) {
			System.out.println(element.getText());
			String indiduvalValue = element.getText().replace("%","");
			numberList.add(Integer.parseInt(indiduvalValue));}
			System.out.println("Final list is" +numberList);
			Integer smallValue = Collections.min(numberList);
			System.out.println("The lesser progress value been " +smallValue);
		//	//td[normalize-space()='20%']//following::td
			String smallValueString = Integer.toString(smallValue) + "%";
			String finalPath= "//td[normalize-space()="+"\"" +smallValueString+"\""+"]"+"//following::td";
			System.out.println(finalPath);
			WebElement check = driver.findElement(By.xpath(finalPath));
			String text2 = check.getText();
			
			check.click();
			Thread.sleep(5000);
			System.out.println("Least value is clicked ");
		//*[@id="wrapper"]
		//*[@id="contentblock"]/section/div[1]/table
		//*[@id="contentblock"]/section/div[1]/table/tbody/tr[1]/th[1]
		//*[@id="contentblock"]/section/div[1]/table/tbody/tr[3]/td[2];
	 

	}
	@Test
	public void ipo() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// WebElement ninety = driver.findElement(By.xpath("//button[text()='90']"));
		// WebElement ninety1 = driver.findElement(By.xpath("(//button[@class='font-medium justify-center items-center no-underline focus-within:outline-none focus:outline-none focus-within:ring focus:ring leading-tight align-middle duration-75 active:shadow-none active:translate-y-px max-w-full select-none bg-black text-white border-white shadow-lg  hover:text-primary    active:text-primary  active:shadow-none  checked:text-primary   text-xs md:text-sm gap-1 md:gap-4 border rounded-tl rounded-tr rounded-bl rounded-br inline-flex py-1 px-2 md:py-2 md:px-3 px-6 md:px-12 cursor-pointer uppercase break-words'])[2]"));
		 //JavascriptExecutor jse = (JavascriptExecutor)driver;
	        //jse.executeScript("arguments[0].scrollIntoView(true);",ninety1);
		 //Actions builder = new Actions(driver);
	        //builder.moveToElement(ninety1).click().build().perform();
	        
		// ninety.sendKeys(Keys.ENTER);
		 
		 //WebElement iframe = driver.findElement(By.cssSelector("#modal>iframe"));
//Actions a=new Actions(driver);
//a.moveToElement(ninety);
//a.click().build().perform();
WebElement value1 = driver.findElement(By.xpath("//td[text()='PRIMENUMB']//preceding::td[2]"));
String get = value1.getText();
System.out.println(get);


		
		
		 
		 //driver.switchTo().frame(1);
		 //ninety.click();
		 

		 //WebDriverWait wait = new WebDriverWait(driver, 10);
		 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='180']")));
		 //ninety.click();
		
		 
		 //JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].scrollIntoView(true)", ninety);
		
		 
		 
		//JavascriptExecutor executor1 = (JavascriptExecutor) driver;
	    // executor1.executeScript("arguments[0].click();", ninety);
		//ninety.sendKeys(Keys.ENTER);
	    // String ninety1 = ninety.getText();
		// System.out.println(ninety1);
		 
		//WebElement value1 = driver.findElement(By.xpath("//strong[text()='AMTD Digital Inc.']//following::td[2]"));
		//String get = value1.getText();
		//System.out.println(get);
		 
	       // WebDriverWait wait = new WebDriverWait(driver,30);
	        
	        //WebElement value1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='PRIMENUMB']//preceding::td[2]")));
		//String text2 = value1.getText();
		// System.out.println(text2);
	

	}
	@Test(enabled=false)
	public void makeMyTrip() {
		//driver.get("https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-04/08/2022_BLR-DEL-05/08/2022&tripType=R&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng");
		driver.get("https://groww.in/stocks/user/explore");
		driver.manage().window().maximize();
		WebElement tablecount = driver.findElement(By.tagName("table"));
		//*[@id="topByTable"]/tr[1]/td[3]
		

	}

	
	@AfterTest
	public void teardown() {
		//driver.quit();
		

	}

}
