
package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;//log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public static WebDriver driver;
	public Logger logger; //log4j
	public Properties p;
	
	 @BeforeClass(groups= {"Sanity","Regression","Master"})
	 @Parameters({"os", "browser"})
	 public void setup(String os,String br) throws IOException
	 {
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		 
		logger=LogManager.getLogger(this.getClass()); //log4j
		
	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		//os
		if(os.equalsIgnoreCase("windows"))
		{
			capabilities.setPlatform(Platform.WIN10);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No Matching os");
			return;
		}
		
		//browser
		switch(br.toLowerCase())
		{
			case "chrome":capabilities.setBrowserName("chrome");break;
			case "edge" :capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox":capabilities.setBrowserName("firefox");break;
			default :System.out.println("No matching browser");return;
		}
		
	 driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	 }
		
	if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	{
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();break;
		case "edge" : driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default:System.out.println("Invalid Browser");return;
		}
	}
		 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(p.getProperty("appURl"));//reading url from properties file
		driver.manage().window().maximize();
		
	 }

	 private void swicth(String lowerCase) {
		// TODO Auto-generated method stub
		
	}

	@AfterClass(groups= {"Sanity","Regression","Master"})
	 public void teardown()
	 {
		 driver.quit();
	 }
	 
	 public String randomString()
	 {
		String generatestring= RandomStringUtils.randomAlphabetic(5);
		return generatestring;
	 }
	 
	 public String randomNumber()
	 {
		String generatenumber= RandomStringUtils.randomNumeric(10);
		return generatenumber;
	 }
	 
	 public String randomAlphaNum()
	 {
		String generatestring= RandomStringUtils.randomAlphabetic(3);
		String generatenumber=RandomStringUtils.randomNumeric(3);
	    return 	(generatestring+"@"+generatenumber);	
		
	 }
	 
 public  String captureScreen(String tname)
 {
	 String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	 
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File sourcefile=ts.getScreenshotAs(OutputType.FILE);
	 
	 String targetFilePath=System.getProperty("user.dir")+".\\screenshots\\"+tname+"_"+timestamp+".png";
     File targetFile=new File(targetFilePath);
	 
	 sourcefile.renameTo(targetFile);
	 
	 return targetFilePath;
	 
 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	

}
