package pages;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {
 
	WebDriver driver;
	By adminuserID = By.name("user");
	By adminPassword = By.name("password");
	By adminSubmit = By.cssSelector("input.button2");






//	userid and password to login HAHA, doing a pull - Doing another pull

	String pUserid;
	String pPassword;
	
	
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
	
	public Boolean verifySubmitPresent() {
	
//		return driver.findElement(adminSubmit).isDisplayed();
		return driver.findElements(adminSubmit).size()!= 0;
	}
	
	
	public void getData(){
		pUserid = "iahmed";
		pPassword = "hello8888";
		
	}
	
	
	
	
	public boolean setData(String oUserid,String oPassword){
	
		this.getData();
		oUserid = pUserid;
		oPassword = pPassword;
		
		
		
		if (!oUserid.equals("")){
			
			if (driver.findElements(adminuserID).size()!= 0){
				driver.findElement(adminuserID).sendKeys(oUserid);
			}
			else {
				System.out.println("UserID object is missing on login page, exiting");
				return false;
				}	
			}
				
		else {
			System.out.println("UserID data is missing, exiting");
			return false;
		}
		
		
		if (!oPassword.equals("")){
			
			if (driver.findElements(adminPassword).size()!= 0){
				driver.findElement(adminPassword).sendKeys(oPassword);
			}
			else {
				System.out.println("Password object is missing on login page, exiting");
				return false;
				}	
			}
				
		else {
			System.out.println("Password data is missing, exiting");
			return false;
		}

		
		return true;
		
	}
	
	
	public boolean loginToAdmin(){
	
		this.verifySubmitPresent();
		if (this.setData(pUserid, pPassword)){

			this.clickSubmit();
		}
		else {
			System.out.println("Either of Test Data or Objects are missing");
			return false;
		}

		return true;
	
	}	
	
/*	@Test
  public void f() {
  }*/
}
