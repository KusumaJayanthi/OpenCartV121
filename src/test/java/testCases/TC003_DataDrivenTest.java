package testCases;
/*Valid---success---pass--logout
  Valid---Unsccess---fail
  
  Invalid---Success--fail--logout
  Invalid---Unsuccess--pass
*/

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_DataDrivenTest extends BaseClass
{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="DataDriven")//getting dataprovider from diff class
	public void verify_loginDDT(String email,String pwd,String exp)
	{
	logger.info("----Starting TC003_DataDrivenTest---- ");
		try
		{
	//HomePage
	  HomePage hp=new HomePage(driver);
	  hp.clickMyAccount();
	  hp.clickLogin();
	  
	  logger.info("----Enter Login details---");
	  //Login page
	  LoginPage lp=new LoginPage(driver);
	  lp.setEmail(email);
	  lp.setPWD(pwd);
	  lp.clicklogin();
		
	  
	  logger.info("---Display MyAccount Page---");
	 //MyAccountPage
	  MyAccountPage accpg=new MyAccountPage(driver);
	  boolean targetpage=accpg.isMyAccountPageExists();
	  
	  /*Valid---success---pass--logout
	  Valid---Unsccess---fail
	  
	  Invalid---Success--fail--logout
	  Invalid---Unsuccess--pass
	*/
	  
	  if(exp.equalsIgnoreCase("Valid"))
	  {
		  if(targetpage==true)
		  {
			  Assert.assertTrue(true);
			  accpg.clickLogout();
		  }
		  else
		  {
			  Assert.assertTrue(false);
		  }
	  }
	  
	  if(exp.equalsIgnoreCase("Invalid"))
	  {
		  if(targetpage==true)
		  {
			  accpg.clickLogout();
			  Assert.assertTrue(false);
		  }
		  else
		  {
			  Assert.assertTrue(true);
		  }
	  }
		}
		catch(Exception e)
		{
		Assert.fail();	
		}
		
		
	  logger.info("----Finishing TC003_DataDrivenTest---- ");	  
	}	  	

}
