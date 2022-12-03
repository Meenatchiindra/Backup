package org.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Empty1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\202760\\eclipse-workspace\\demo\\driver1\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.get("http://localhost:4200/login");
        driver.findElement(By.linkText("Click here")).click();
        driver.findElement(By.id("UserName")).sendKeys("");
        driver.findElement(By.id("Password")).sendKeys("");
        driver.findElement(By.id("Address")).sendKeys("");
        driver.findElement(By.id("City")).sendKeys("");
        Select state=new Select(driver.findElement(By.id("StateId")));
        state.selectByVisibleText("");
        
        state.selectByVisibleText("Kerala");
        state.deselectByValue("kerala");
        WebElement update = driver.findElement(By.xpath("//button[text()='Update']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", update);
        driver.quit();

    }
}