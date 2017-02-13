package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utilities.Page;


public class LogoutPage extends Page{

WebDriver driver;
	
	By adminLogoutLink = By.linkText("Logout");
	String linkTextAction;
	String appLinkText;
	
	
	
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
	
	
	
	
	public void perform(WebDriver driver, String linkText)
	{
		this.driver = driver;
		this.linkTextAction = linkText;
		System.out.println("linkTextAction is: "+linkTextAction);
		
		if (linkTextAction.equalsIgnoreCase("logoutLink"))
		{
			this.selectLogout(driver);
		}
			//close the browser
		driver.close();
		
	}
	
	public void setData(WebDriver driver){};
	
	
}
