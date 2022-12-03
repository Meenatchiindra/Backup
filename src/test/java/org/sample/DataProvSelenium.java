package org.sample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProvSelenium {
    WebDriver driver;
    @DataProvider(name = "data")
    public static Object[][] DataSet(){
                Object[][] value = {
                {"valid", "standard_user", "secret_sauce"},
                {"invalid", "standard_user", "123"},
                {"invalid","dell","234"}
                };
        return value;
    }

    @Test(dataProvider = "data")
    public void SampleTest(String credentialstatus, String username, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Demo\\driver\\chromedriver.exe");
        System.out.println(credentialstatus + " " + username + " " + password);
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}


