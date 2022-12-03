package org.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PricedDetails {

    
    WebDriver driver;

    @BeforeTest
    public void SetUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Demo\\driver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.nyse.com/ipo-center/recent-ipo");
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[text()='90']")).click();

    }


    @Test(priority = 1)
    public void RowCount() {
    List <WebElement> path  = driver.findElements(By.xpath("//*/table[@class='table-data table-condensed mb-10 table'][2]/tbody/tr"));
    int count  = path.size();

    System.out.println("No. of Rows: "+ count);
    }



    @Test(priority = 2)
    public void RowData() {
        List <WebElement> path  = driver.findElements(By.xpath("//*/table[@class='table-data table-condensed mb-10 table'][2]/tbody/tr"));
        List<String> rowData = new ArrayList<String>();

        for(WebElement opt: path) {
            rowData.add(opt.getText()); 
        }

//        System.out.println("Elements in Row are:" + rowData);


    for(int i=1;i<=path.size();i++ ) {
        System.out.println("Row " + i + ": \n " + driver.findElement(By.xpath("//*/table[@class='table-data table-condensed mb-10 table'][2]/tbody/tr["+i+"]")).getText());
    }
    }
    @Test(priority = 3)
    public void ColCount() {

        List<WebElement> path = driver.findElements(By.xpath("//table[2]/thead/tr/th"));
        int count = path.size();

        System.out.println("\nNo. of Columns: " + count);
    }



    @Test(priority = 4)
    public void colData() {
        List<WebElement> pathC = driver.findElements(By.xpath("//table[2]/thead/tr/th"));
        List <WebElement> pathR  = driver.findElements(By.xpath("//*/table[@class='table-data table-condensed mb-10 table'][2]/tbody/tr"));

        for(int i=1;i<=pathC.size();i++) {
            System.out.println("\n"+driver.findElement(By.xpath("//table[2]/thead/tr/th["+i+"]")).getText());
            System.out.println("===============");

            for(int j=1;j<=pathR.size();j++) {

            System.out.println(driver.findElement(By.xpath("//table[2]/tbody/tr["+ j+"]/td["+i+"]")).getText());
        }
            System.out.println("");
    }
    }
    @Test(priority = 5)
    public void CellData() {
        List <WebElement> pathR  = driver.findElements(By.xpath("//*/table[@class='table-data table-condensed mb-10 table'][2]/tbody/tr"));
        List<WebElement> pathL = driver.findElements(By.xpath("//table[2]/thead/tr/th"));
        List<WebElement> cell = driver.findElements(By.xpath("//*/table[@class='table-data table-condensed mb-10 table'][2]/tbody/tr/td"));
        List<String> values = new ArrayList();

//        for(WebElement opt : cell) {
//            values.add(opt.getText());
//        }

        System.out.println("\nValues in table are: \n" );
        for(int i=1;i<=pathR.size();i++) {
            for(int j=1;j<=pathL.size();j++) {

                System.out.print(driver.findElement(By.xpath("//*/tr[" + i + "]/td[" + j + "] " )).getText()+" ");
            }
            System.out.println();
        }

    }

    @Test(priority = 6)
    public void MaxValue() {

         List <WebElement> colCount = driver.findElements(By.xpath("//table[2]/tbody/tr/td[7]"));
         
         List <String> colValues = new ArrayList<String>();

         List <Double> array = new ArrayList<Double>();

         for(WebElement opt: colCount) {
             colValues.add(opt.getText());
         }
        System.out.println("\nValues in Column are: "+ colValues);
    System.out.println();


         for( int i=1;i<=colCount.size();i++) {
             String Offer = driver.findElement(By.xpath("//table[2]/tbody/tr[" + i + "]/td[7]")).getText();
             Double dOffer = Double.parseDouble(Offer);
             array.add(dOffer );
         }



         System.out.println("Max Value: "+ Collections.max(array));

     System.out.println("\nIssuer with Max Current % is: "+ driver.findElement(By.xpath("//tr/td[text()='"+Collections.max(array)+"']//preceding::td[4]" )).getText());
    }

    @Test(priority = 7)
    public void GetValue() {

         System.out.println("\nBookRunner of Hanover Bancorp, Inc.is: "+ driver.findElement(By.xpath("//tr/td/strong[text()[normalize-space()='Hanover Bancorp, Inc.']]//following::td[2]")).getText());

    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }
}