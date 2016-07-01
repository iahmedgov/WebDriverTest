package runTests;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import pages.AdminLandingPage;
import pages.AdminLoginPage;


public class TestAdminLogin {
	
	WebDriver driver;
	
	AdminLandingPage objLanding;
	AdminLoginPage objLogin;
	
	@BeforeTest
	
	public void setup(){
	
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://qa.velocitypayment.com/admin/imtiaz");
	}
	
  @Test(priority=0)
  /*public void f() {
  }*/
  
  	public void test_successful_Login(){
	  	
	  objLogin = new AdminLoginPage(driver);
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
		  
	  }
	  
	  
	  
  }
  
}
