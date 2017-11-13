package pages;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Assert.*;
import Utilities.Page;
//import Main.MainTestDriver;



public class AdminLandingPage extends Page {
	
	WebDriver driver;
	
	
	By adminLogoutLink = By.linkText("Logout");
	//By vtApplicationLink = By.linkText("Access Ahmed Payment");
	String linkTextAction;
	String appLinkText;
	
	public AdminLandingPage(){
		
		
	}
	
	public AdminLandingPage(WebDriver driver){
	
		this.driver = driver;
	}
	
	public boolean isLogoutLinkPresent(WebDriver driver){
		this.driver = driver;
		return driver.findElements(adminLogoutLink).size()!= 0;
		

	}
	
	
	public void selectLogout(WebDriver driver){
		this.driver = driver;
		if (this.isLogoutLinkPresent(driver)){
	  		System.out.println("Logout link is present");
	  		driver.findElement(adminLogoutLink).click();
	  			}
	  	else {
	  		System.out.println("Logout link is not present");
	  	  	}
		
	}
	
	
	public void selectvtApplicationLink(WebDriver driver,String appName)
	{
		//get appLinkText from Database
		appName = Main.MainTestDriver.MT_vtAppName;
		//appName = MT_vtAppName;
		//appName = "Access CC Test";
		this.driver = driver;
		this.appLinkText = appName;
		
		By vtApplicationLink = By.linkText(appLinkText);
		
		if (driver.findElements(vtApplicationLink).size()!= 0)
		{
			driver.findElement(vtApplicationLink).click();
		}
		
	}
	
	public void getInnerText(WebDriver driver)
	{
		this.driver = driver;
		String inntxt = driver.findElement(By.tagName("body")).getText();
		System.out.println("Inner Text is: "+inntxt);
		
	}
	
	
	public void setData(WebDriver driver){};
	
	public void perform(WebDriver driver, String linkText)
	{
		this.driver = driver;
		this.linkTextAction = linkText;
		System.out.println("linkTextAction is: "+linkTextAction);
		
		if (linkTextAction.equalsIgnoreCase("logoutLink"))
		{
			this.selectLogout(driver);
		}
		else if (linkTextAction.equalsIgnoreCase("applicationName"))
		{
			//getAppName
			
			this.selectvtApplicationLink(driver, appLinkText);
		}
		
	}
	
 /* @Test
  public void f() {
  }*/
}
