package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginPage extends BaseClass
{
 
@Test(groups= {"Sanity","Master"})	
public void verify_login()
{
	
  logger.info("----Starting TC002_LoginPage--- ");
  try
  {
  //HomePage
  HomePage hp=new HomePage(driver);
  hp.clickMyAccount();
  hp.clickLogin();
  
  logger.info("----Enter Login details---");
  //Login page
  LoginPage lp=new LoginPage(driver);
  lp.setEmail(p.getProperty("email"));
  lp.setPWD(p.getProperty("password"));
  lp.clicklogin();
	
  
  logger.info("---Display MyAccount Page---");
 //MyAccountPage
  MyAccountPage accpg=new MyAccountPage(driver);
  boolean targetpage=accpg.isMyAccountPageExists();
  
  Assert.assertTrue(targetpage);//or Assert.assertEqualse(targetpage,true,"login fail");
  }
  catch(Exception e)
  {
	  Assert.fail();
  }
  logger.info("----Finishing TC002_LoginPage--- ");
  
}

}
