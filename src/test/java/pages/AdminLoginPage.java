package pages;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utilities.Page;
import pages.AdminLandingPage;

public class AdminLoginPage extends Page {
 
	WebDriver driver;
	By adminuserID = By.name("user");
	By adminPassword = By.name("password");
	By adminSubmit = By.cssSelector("input.button2");

	




//	userid and password to login HAHA, doing a pull - Doing another pull

	String pUserid;
	String pPassword;
	
	public AdminLoginPage(){
		
		super();
		
	}
	
	public AdminLoginPage(WebDriver driver){
	
		this.driver = driver;
	}
	
	
	public void setUserID(String strUserID) {
	
		driver.findElement(adminuserID).sendKeys(strUserID);
	}
	
	public void setPassword(String strPassword) {
		
		driver.findElement(adminPassword).sendKeys(strPassword);
		
	}
	
	public void clickSubmit() {
		
		driver.findElement(adminSubmit).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public Boolean verifySubmitPresent(WebDriver driver) {
		this.driver = driver;
//		return driver.findElement(adminSubmit).isDisplayed();
		return driver.findElements(adminSubmit).size()!= 0;
	}
	
	
	public void getData(String oUserid,String oPassword){
		this.pUserid = oUserid;
		this.pPassword = oPassword;
		
	}
	
	
	
	
	public void setData(WebDriver driver){
		this.driver = driver;
		
		this.getData("iahmed","hello2222");
		/*oUserid = pUserid;
		oPassword = pPassword;*/
		this.verifySubmitPresent(driver);
		if (this.verifySubmitPresent(driver)){
			System.out.println("Submit Button is present on Login page, Continue to log in..");
		
		if (!pUserid.equals("")){
			
			if (driver.findElements(adminuserID).size()!= 0){
				driver.findElement(adminuserID).sendKeys(pUserid);
			}
			else {
				System.out.println("UserID object is missing on login page, exiting");
				//return false;
				}	
			}
				
		else {
			System.out.println("UserID data is missing, exiting");
			//return false;
		}
		
		
		if (!pPassword.equals("")){
			
			if (driver.findElements(adminPassword).size()!= 0){
				driver.findElement(adminPassword).sendKeys(pPassword);
			}
			else {
				System.out.println("Password object is missing on login page, exiting");
				//return false;
				}	
			}
				
		else {
			System.out.println("Password data is missing, exiting");
			//return false;
		}
		this.clickSubmit();
		}
		else {System.out.println("Submit Button is missing, Cant Log in");}
		
		//return true;
		
	}
	
	
	public boolean loginToAdmin(){
	
		if (this.verifySubmitPresent(driver)){
				System.out.println("Submit Button is present on Login page, Continue to log in..");
				this.setData(driver);
				this.clickSubmit();
		
			
		}
		return true;
	}	
	
	public void perform(WebDriver driver, String linkText)
	{
		
	}
	
	
/*	@Test
  public void f() {
  }*/
}
