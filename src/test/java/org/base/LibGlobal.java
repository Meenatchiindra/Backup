package org.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class LibGlobal {
public static WebDriver driver;


	
	
	public void setUp() throws Exception {
		// Connection object
		// Statement object
		Statement stmt;
		// Constant for Database URL
		//jdbc:oracle:thin:@localhost:1521:sid
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		//Database Username
		String DB_USER = "meena";
		// Database Password
		String DB_PASSWORD = "max@2022";

	try{
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		//jdbc:oracle:thin:@//localhost:1521/orcl
	
	Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	Statement st= con.createStatement();
	ResultSet rs= st.executeQuery("Select * from Persons");
	while(rs.next()) {
		int EmpId= rs.getInt("PersonID");
		String Empln= rs.getString("LastName");
		String Empfn=rs.getString("FirstName");
		//Double EmpSal= rs.getDouble(4);
		String EmpAddress=rs.getString("Address");
		String Empcity=rs.getString("City");
		System.out.println(EmpId+"\t"+Empln+"\t"+Empfn+"\t"+EmpAddress+"\t"+Empcity);
		}
	
	
	
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	}

	
	

	
	

public void getDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Demo\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "");
		driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "");
			driver=new InternetExplorerDriver();
		}}
	
	public void getUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		}
	public String particularExcelReadData(String path,String name,int rownum,int cellnum) throws IOException {
		FileInputStream excel=new FileInputStream(path);
		Workbook w=new XSSFWorkbook(excel);
		Sheet sheet = w.getSheet(name);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		System.out.println(cell);
		String value="";
		if(cell.getCellType()==CellType.STRING) {
			value=cell.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(cell))
		{
		Date dd = cell.getDateCellValue();
		SimpleDateFormat dateFormat=new SimpleDateFormat("mm-dd-yyyy");
		value=dateFormat.format(dd);
		}
		else {
		double numericCellValue = cell.getNumericCellValue();}
		
	return value;

	}}
