package Utilities;

import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import pages.AdminLandingPage;
import pages.AdminLoginPage;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.lang.reflect.Field;


public class TestAdminLogin {
	
	WebDriver driver;
	
	/*AdminLandingPage objLanding;
	AdminLoginPage objLogin;*/
	
	private VirtualFlowParser vfp;
	
	@BeforeTest
	
	public void setup(){
		/*File pathToFirefoxBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxbin = new FirefoxBinary(pathToFirefoxBinary);
		driver = new FirefoxDriver(firefoxbin,null);*/
		//System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\firefox-sdk\\bin\\firefox.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://qa.velocitypayment.com/admin/imtiaz");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
  @Test(priority=0)
  /*public void f() {
  }*/
  
  	public void test_successful_Login() throws SQLException, Exception{
	  	
	  /*objLogin = new AdminLoginPage(driver);
	  if (objLogin.verifySubmitPresent()){
		  System.out.println("Submit button is present on login page, continue to login");
		  		if (objLogin.loginToAdmin()){
		  
						  objLanding = new AdminLandingPage(driver);
						  	if (objLanding.isLogoutLinkPresent()){
						  		System.out.println("Logout link is present");
						  		objLanding.selectLogout();
						  			}
						  	else {
						  		System.out.println("Logout link is not present");
						  	  	}
				
						  	}
		  		else { System.out.println("Unable to Login, Dont try to Logout");
		  				return;
		  			}
		 
	  }
	  else {
		  System.out.println("Submit Button not present on Login page");
		  return;
// Come out of test, don't execute anymore
		  
		  
		
		  
		  
		  
	  }*/
	  Page pg = null;
	  String vFlow = "";
			vfp = new VirtualFlowParser(vFlow);
			if (vfp != null)
			{

				while (vfp.parseFlow())
				{

					String page = vfp.getPage();
					System.out.println("Page text is: " + page);
					String action = vfp.getAction();
					System.out.println("Action text is: " + action);
					
					//pg.getClass().getName();
					//pg = page.valueOf(getClass());
					
					//pg = new Page();
					
					try {
					//Class c = ClassLoader.getSystemClassLoader().loadClass("Utilities.Page");
						
						/*ClassLoader classLoader = this.getClass().getClassLoader();
						Class loadedMyClass = classLoader.loadClass(page);
						

							Constructor constructor = loadedMyClass.getConstructor(); 
							Page myClassObject = (Page) constructor.newInstance(page); 
							myClassObject.setData();
*/
						Class c = Class.forName("pages."+page);
						pg = (Page) c.newInstance();
						
						
						if (action.equalsIgnoreCase("setData"))
						{
							//pg.setData(driver);
						}
						else if (action.startsWith("Click"))
						{
							/*System.out.println("Action is: "+action);
							String actionName = action.substring(5).trim();
							System.out.println("Substring Action is: "+actionName);
							pg.perform(driver, actionName);*/
						}
						
						
						Database_Util testDB = new Database_Util();
						testDB.openDBConnection();
						
						
						//pg.newInstance();
						//pg.setData();
						
						/*pg = new AdminLoginPage(driver);
						((AdminLoginPage) pg).loginToAdmin();*/
						
						
						
						/*Constructor<Page> ctor = Page.class.getDeclaredConstructor(setData.class);
					    ctor.setAccessible(true);
					    pg = (Page)ctor.newInstance(driver);
					    	pg.setData();*/
						
						/*Constructor<AdminLoginPage> ctor = AdminLoginPage.class.getDeclaredConstructor();
					    ctor.setAccessible(true);
					    pg = (AdminLoginPage)ctor.newInstance(driver);
					    	pg.setData();*/
						
						
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
	  
  }
  
}
}
