package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utilities.Database_Util;

public class MainTestDriver {

	private static Database_Util testDB;
	private static ResultSet testRS;
	public static String sqlMainQuery;
	private static Connection dbConn;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello World");
		
		testDB = new Database_Util();
		
		try {
			dbConn = testDB.openDBConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sqlMainQuery = "Select * from MainTable where Environment = 'QA' and TestType = 'Smoke' and Product = 'VT'";
		
		try {
			testRS = testDB.executeQuery(sqlMainQuery,dbConn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int recCount = testDB.getRecordCount();
		System.out.println("Record Count is: "+ recCount);
		
		
		try {
			while (testRS.next()){
				String RecordNumber = testRS.getString("Rnumber");
				System.out.println("RecordNumber is: " + RecordNumber);
				String RecordID = testRS.getString("RID");
				System.out.println("YouRecordID is: " + RecordID);
				
				String Environment = testRS.getString("Environment");
				System.out.println("Environment is: " + Environment);
				
				String TestCaseID = testRS.getString("TestCaseID");
				System.out.println("TestCaseID is: " + TestCaseID);
				
				String TestType = testRS.getString("TestType");
				System.out.println("TestType is: " + TestType);
				
				String Product = testRS.getString("Product");
				System.out.println("Product is: " + Product);
				
				String URLID = testRS.getString("Url_ID");
				System.out.println("URLID is: " + URLID);
				
				String LoginID = testRS.getString("Login_ID");
				System.out.println("LoginID is: " + LoginID);
			
			
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			testDB.closeDBConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}
