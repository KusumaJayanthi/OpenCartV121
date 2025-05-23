package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegisterPage extends BasePage
{
	
public AccountRegisterPage(WebDriver driver)
{
	super(driver);
}

@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstName;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastName;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtConfirmPWD;

@FindBy(xpath="//input[@name='agree']")
WebElement cliPolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement cliContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement displayMesg;

public void setFirstName(String fname)
{
	txtFirstName.sendKeys(fname);
}

public void setLastName(String lname)
{
	txtLastName.sendKeys(lname);
}

public void setEmail(String email)
{
	txtEmail.sendKeys(email);
}

public void setPhoneNo(String phno)
{
	txtTelephone.sendKeys(phno);
}

public void setPassword(String pwd)
{
	txtPassword.sendKeys(pwd);
}

public void setConfirmPwd(String Cpwd)
{
	txtConfirmPWD.sendKeys(Cpwd);
}

public void clickbtn()
{
	cliPolicy.click();
}

public void cliContibtn()
{
	//sol 1
	cliContinue.click();
	
	//sol 2
	//cliContinue.submit();
	
	//sol 3
	//JavaScriptExeutor js=(JavaScriptExeutor)driver;
	//js.executeScript("arguments[0].click();",cliContinue);
	
	//sol 4
	//Actions act=new Actions(driver);
	//act.moveToElement(cliContinue).click().perform();
	
	//sol 5
	//cliContinue.sendKeys(Keys.RETURN);
	
	//sol 6
 //WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
// mywait.until(ExpectedConditions.elementToBeClickable(cliContinue)).click();
	
}	
 public String getConfirmationMesg()
 {
	 try
	 {
	return (displayMesg.getText());
	 }
	 catch(Exception e)
	 {
		return(e.getMessage());
	 }
 }
	
	
}





