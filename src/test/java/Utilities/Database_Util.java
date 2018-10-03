package Utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.*;


public class Database_Util {

	public ResultSet rs;
	private static Connection conn = null;
	
	public static Connection openDBConnection() throws SQLException, Exception {
		String dbURL = "jdbc:sqlserver://DEVSERVAG01;databaseName=GovolutionTestData;user=qa_automation;password=t3st@u70Mat!on;";
		String query = "Select * from MainTable";
	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		Connection conn = DriverManager.getConnection(dbURL);//till here
		
/*		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()){
			String RecordNumber = rs.getString("Rnumber");
			System.out.println("RecordNumber is: " + RecordNumber);
			String RecordID = rs.getString("RID");
			System.out.println("YouRecordID is: " + RecordID);
			
			String Environment = rs.getString("Environment");
			System.out.println("Environment is: " + Environment);
			
			String TestCaseID = rs.getString("TestCaseID");
			System.out.println("TestCaseID is: " + TestCaseID);
			
			String TestType = rs.getString("TestType");
			System.out.println("TestType is: " + TestType);
			
			String Product = rs.getString("Product");
			System.out.println("Product is: " + Product);
			
			String URLID = rs.getString("Url_ID");
			System.out.println("URLID is: " + URLID);
			
			String LoginID = rs.getString("Login_ID");
			System.out.println("LoginID is: " + LoginID);
			
		}
		
		conn.close();*/
		
		return (conn);
			
	}
		
	
	public int getRecordCount() {
		int retVal = 0;

		try {
			if (rs != null) {
				rs.last();
				retVal = rs.getRow();
				rs.beforeFirst();
			}
		} catch (SQLException sqle) {
			System.out.println("Database_Util.getRecordCount() error: " + sqle);
			throw sqle;
		} catch (Exception exc) {
			System.out.println("Database_Util.getRecordCount() error: " + exc);
			throw exc;
		} finally {
			return retVal;
		}

	}
	
	
	public void closeDBConnection() throws SQLException, Exception {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException connsql) {
			System.out.println(
				"Database_Util.closeDBConnection() error: " + connsql);
			throw connsql;
		} catch (Exception eclsql) {
			System.out.println(
				"Database_Util.closeDBConnection() error: " + eclsql);
			throw eclsql;
		}
		

	}
	
	
	
    public ResultSet executeQuery(String sqlString, Connection conn)
	throws SQLException, Exception {
	Statement statement = null;
	try {
		String sql = sqlString;
		conn.nativeSQL(sql);
                   statement =
			conn.createStatement(
                                    // Cursor is scrollable and can fetch previous records
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
			        ResultSet.CONCUR_READ_ONLY);

                    rs = statement.executeQuery(sql);
		return rs;
	} catch (SQLException sqlqry) {
		statement.close();
		System.out.println(
			"Database_Util.executeQuery() error: SQL Statement=["
				+ sqlString
				+ "], Exception=["
				+ sqlqry
				+ "]");
		throw sqlqry;
	} catch (Exception equery) {
		//statement.close();
		System.out.println(
			"Database_Util.executeQuery() error: SQL Statement=["
				+ sqlString
				+ "], Exception=["
				+ equery
				+ "]");
		throw equery;
	} finally {
		statement = null;
	}

}
	
	
	
}
