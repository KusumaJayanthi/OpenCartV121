package pageObjects;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
  public MyAccountPage(WebDriver driver)
  {
	 super(driver);
  }
  
 @FindBy(xpath="//h2[normalize-space()='My Account']")
 WebElement mesgHeading;
 
 @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
 WebElement lnkLogout;
 
 public boolean  isMyAccountPageExists()
 {
	 try
	 {
	 return(mesgHeading.isDisplayed()); 
	 }
	 catch(Exception e)
	 {
		 return false;
	 }
 }
  
 public void clickLogout()
 {
	 lnkLogout.click(); 
 }
  
  
  
}
