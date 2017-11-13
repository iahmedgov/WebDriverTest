package Utilities;

import org.testng.annotations.Test;
import java.util.regex.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utilities.Database_Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class VirtualFlowParser {
	
	//Declare Variables
	public StringTokenizer tokens;
	private String page; 
	private String action;
	public String virtualFlow;
	private static ResultSet vfRS;
	private static Database_Util vfTestDB;
	public String appName;
	WebDriver driver;
	
	// Define Constants for easy maintenance
	public final String startTag1 = "<";
	public final String startTag2 = "[";
	public final String endTag1 = ">";
	public final String endTag2 = "]";
	public final String Delimiter = ":";
	public final Pattern expression1 = Pattern.compile("\\[Insert.*\\]", Pattern.CASE_INSENSITIVE);
	public VirtualFlowParser vfp;
	
	
	public VirtualFlowParser(String vf){
			
			//this.virtualFlow = "<Page:AdminLoginPage><Action:setData><Page:AdminLandingPage><Action:Click applicationName>";
			this.virtualFlow = vf;
			
			//<Page:AdminLoginPage><Action:setData><Page:AdminLandingPage><Action:Click logoutLink>
			
				 // Call CreateFlow twice in order to replace 
				 // Virtual Flow in both the Main and VirtualFlow table  
				// GenerateFlow();
				
				 
				tokens = new StringTokenizer(virtualFlow, startTag1);
			

		}
	
	public VirtualFlowParser(){}
	
	
	public boolean parseFlow(){
		String pageToken, actionToken;
		int endTag1Pos, startPos;

					if (tokens.hasMoreTokens()) {

				pageToken = tokens.nextToken();
				page = ExtractText(pageToken, endTag1);

				actionToken = tokens.nextToken();
				action = ExtractText(actionToken, endTag1);

				return true;
			} else {
				return false;
			}
	
		}
	
	/**
	 * Retrieves the last parsed virtual flow "Page:" text.
	 * 
	 * @return	the page an action will be performed on.
	 */

	public String getPage() {
		return page;
	}
	/**
	 * Retrieves the last parsed virtual flow "Action:" text.
	 * 
	 * @return	the action that will be performed on a page.
	 */

	public String getAction() {
		return action;
	}
	
	
	
	
	
	/**
	 * Extracts a given text which appears after a delimiter
	 */
	private String ExtractText(String strText, String endTag1) {
		String strTempText = strText;
		int startPos, endPos;
		endPos = strTempText.indexOf(endTag1);
		startPos = strTempText.indexOf(Delimiter);
		strTempText = strTempText.substring(startPos + 1, endPos);
		strTempText = strTempText.trim();
		return strTempText;
	}
	
	/*public ResultSet selectVirtualFlow(String vf_id, Connection vfConn, Database_Util vfTestDB){
		
		String vfQuery = "Select * from VirtualFlow where Vf_ID = "+vf_id;
		System.out.println("vfQuery is: " + vfQuery);
		
		if (vfConn != null){
			System.out.println("vfConn is not null");
		}
		else {System.out.println("vfConn is null");}
		
		if (vfTestDB != null){
			System.out.println("vfTestDB is not null");
		}
		else {System.out.println("vfTestDB is null");}
		
		
		try {
			
			vfRS = vfTestDB.executeQuery(vfQuery,vfConn);
			while (vfRS.next()){
			String virtualFlow = vfRS.getString("VF_Flow");
			System.out.println("virtualFlow is: " + virtualFlow);
			
			
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\firefox-sdk\\bin\\firefox.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://qa.velocitypayment.com/admin/imtiaz");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			this.vfp = new VirtualFlowParser(virtualFlow);
			//tokens = new StringTokenizer(virtualFlow, startTag1);
			
			if (vfp != null)
			{

				while (vfp.parseFlow())
				{

					String page = vfp.getPage();
					System.out.println("Page text is: " + page);
					String action = vfp.getAction();
					System.out.println("Action text is: " + action);
					
					Page pg = null;
					
					Class c = Class.forName("pages."+page);
					pg = (Page) c.newInstance();
					
					
					if (action.equalsIgnoreCase("setData"))
					{
						pg.setData(driver);
					}
					else if (action.startsWith("Click"))
					{
						System.out.println("Action is: "+action);
						String actionName = action.substring(5).trim();
						System.out.println("Substring Action is: "+actionName);
						pg.perform(driver, actionName);
					}
					
					
					
					
					
				}
			}
			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vfRS;
		
		
		
		
	}*/
	
	
	public String getVirtualFlow(String vf_id, Connection vfConn, Database_Util vfTestDB){
	
		String vfQuery = "Select * from VirtualFlow where Vf_ID = "+vf_id;
		System.out.println("vfQuery is: " + vfQuery);
		
		try {
			vfRS = vfTestDB.executeQuery(vfQuery,vfConn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (vfRS.next()){
			virtualFlow = vfRS.getString("VF_Flow");
			System.out.println("virtualFlow is: " + virtualFlow);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return virtualFlow;
		
	}
	
	
	public void executeVirtualFlow(String vf, VirtualFlowParser vfp){
		this.virtualFlow = vf;
		System.out.println("executeVirtualFlow: " + virtualFlow);
		
		tokens = new StringTokenizer(virtualFlow, startTag1);
		
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\firefox-sdk\\bin\\firefox.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://qa.velocitypayment.com/admin/imtiaz");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		if (vfp != null)
		{

			while (vfp.parseFlow())
			{

				String page = vfp.getPage();
				System.out.println("Page text is: " + page);
				String action = vfp.getAction();
				System.out.println("Action text is: " + action);
				
				Page pg = null;
				
				Class c = null;
				try {
					c = Class.forName("pages."+page);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					pg = (Page) c.newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				if (action.equalsIgnoreCase("setData"))
				{
					pg.setData(driver);
				}
				else if (action.startsWith("Click"))
				{
					System.out.println("Action is: "+action);
					String actionName = action.substring(5).trim();
					System.out.println("Substring Action is: "+actionName);
					pg.perform(driver, actionName);
				}
				
							
				
			}
		}
		

		
	}
	
	
	public String getAppName (String appName_id, Connection vfConn, Database_Util vfTestDB){
		
		String appNameQuery = "select * from VTappName where VTappName_ID = "+appName_id;
		System.out.println("appNameQuery is: " + appNameQuery);
		
		try {
			vfRS = vfTestDB.executeQuery(appNameQuery,vfConn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (vfRS.next()){
			appName = vfRS.getString("VT_AppName");
			System.out.println("appName is: " + appName);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appName;
		
	}
	
	
 // @Test
  /*public void f() {
  }*/
}
