package org.sample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidUsernameAlert {
    WebDriver driver;
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\201717\\eclipse-workspace\\demo\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4200/login");
        driver.manage().window().maximize();

        //valid credentials
        driver.findElement(By.id("UserName")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("abc");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert);
        alert.accept();
    }
}