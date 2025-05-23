package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass
{
		
 @Test(groups= {"Regression","Master"})
 public void verify_account_registration()
 {
	 logger.info("----Starting TC001_AccountRegistrationTest----"); 
	 
	try
	{
 // Home Page
HomePage hp=new HomePage(driver);
hp.clickMyAccount();
logger.info("Clicked on My Account Link");
hp.clickRegister();
logger.info("Clicked on Register Link");

//AccountReister
AccountRegisterPage accrp=new AccountRegisterPage(driver);

logger.info("Providing Customer details");
accrp.setFirstName(randomString().toUpperCase());
accrp.setLastName(randomString().toUpperCase());

accrp.setEmail(randomString()+"@gmail.com");
accrp.setPhoneNo(randomNumber());

 String password=randomAlphaNum();
accrp.setPassword(password);
accrp.setConfirmPwd(password);

accrp.clickbtn();
accrp.cliContibtn();

logger.info("Expected message");
String ConfMesg=accrp.getConfirmationMesg();
if(ConfMesg.equals("Your Account Has Been Created!"))
{
	Assert.assertTrue(true);
}
else
{ 
	logger.error("Test Failed");
    logger.debug("Debug logs");
	Assert.assertTrue(false);
}
   //Assert.assertEquals(ConfMesg, "Your Account Has Been Created");
	}
	catch(Exception e)
	{
		
		Assert.fail();
	}

	logger.info("----Finished TC001_AccountRegistrationTest----" ); 
 }	 
	 
}	
 
 
 
 
 
 
 
 
 
 
 
 
 
 
	
	
	
	
	
	
	
	
	
	


