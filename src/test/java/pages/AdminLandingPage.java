package pages;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Assert.*;



public class AdminLandingPage {
	
	WebDriver driver;
	
	By adminLogoutLink = By.linkText("Logout");
	
	
	
	public AdminLandingPage(WebDriver driver){
	
		this.driver = driver;
	}
	
	public boolean isLogoutLinkPresent(){
		return driver.findElements(adminLogoutLink).size()!= 0;
		

	}
	
	
	public void selectLogout(){
		driver.findElement(adminLogoutLink).click();
	}
	
	
 /* @Test
  public void f() {
  }*/
}
