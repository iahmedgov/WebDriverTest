package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public abstract class Page {
	
	WebDriver driver;
	String page;
	
	public Page()
	{
		super();
	}
	
	public Page(String page)
	{
		this.page = page;
	}
	
	
	public Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setObjectDriver(WebDriver driver){
		this.driver = driver;
	}
	
	public abstract void setData(WebDriver driver);
	
	public abstract void perform(WebDriver driver, String linkText);
	
	
	
	
	
  /*@Test
  public void f() {
  }*/
}
