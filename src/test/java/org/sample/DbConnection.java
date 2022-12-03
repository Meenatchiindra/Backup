package org.sample;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class DbConnection {
	// Connection object
	static Connection con = null;
	// Statement object
	private static Statement stmt;
	// Constant for Database URL
	//jdbc:oracle:thin:@localhost:1521:sid
	public static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	//Database Username
	public static String DB_USER = "meena";
	// Database Password
	public static String DB_PASSWORD = "max@2022";

	@BeforeTest
	public void setUp() throws Exception {
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

	
	

	@AfterTest
	public void tearDown() throws Exception {
	// Close DB connection
	if (con != null) {
	con.close();
	}
	}
	}


